package ru.innopolis.healthcode.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.innopolis.healthcode.dto.RecordDTO;
import ru.innopolis.healthcode.exceptions.MedicalRecordNotFound;
import ru.innopolis.healthcode.models.MedicalRecord;
import ru.innopolis.healthcode.repositories.MedicalRecordRepository;
import ru.innopolis.healthcode.services.MedicalRecordService;
import java.util.List;
import static ru.innopolis.healthcode.dto.RecordDTO.Response.Brief.briefInformationDTO;
import static ru.innopolis.healthcode.dto.RecordDTO.Response.Private.privateInformationDTO;
import static ru.innopolis.healthcode.dto.RecordDTO.Request.Create.toRecordDTO;

@RequiredArgsConstructor
@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {

    private final MedicalRecordRepository medicalRecordRepository;

    @Override
    public List<RecordDTO.Response.Brief> getAll() {
        return briefInformationDTO(medicalRecordRepository.findAllOpenedRecords());
    }

    @Override
    public RecordDTO.Response.Private getById(Long id) {
        MedicalRecord medicalRecord =
                medicalRecordRepository.findById(id).orElseThrow(MedicalRecordNotFound::new);
        return privateInformationDTO(medicalRecord);
    }

    @Override
    public List<RecordDTO.Response.Brief> getByPatientName(String patientName) {
        List<MedicalRecord> medicalRecord =
                medicalRecordRepository.findByPatientFirstName(patientName);
        return briefInformationDTO(medicalRecord);
    }

    @Override
    public void addMedicalRecord(RecordDTO.Request.Create medicalRecordDTO) {
        toRecordDTO(medicalRecordRepository.save(
                MedicalRecord.builder()
                        .id(medicalRecordDTO.getId())
                        .doctor(medicalRecordDTO.getDoctor())
                        .patientFirstName(medicalRecordDTO.getFirstName())
                        .patientLastName(medicalRecordDTO.getLastName())
                        .patientEmail(medicalRecordDTO.getEmail())
                        .patientPhoneNumber(medicalRecordDTO.getPhoneNumber())
                        .patientAddress(medicalRecordDTO.getAddress())
                        .age(medicalRecordDTO.getAge())
                        .weight(medicalRecordDTO.getWeight())
                        .disease(medicalRecordDTO.getDisease())
                        .description(medicalRecordDTO.getDescription())
                        .isClosed(medicalRecordDTO.getIsClosed())
                        .build()
        ));
    }

    @Override
    public void updateMedicalRecord(Long medicalRecordId, RecordDTO.Request.Create newData) {
        MedicalRecord medicalRecord = medicalRecordRepository
                .findById(medicalRecordId)
                .orElseThrow(MedicalRecordNotFound::new);

        medicalRecord.setDoctor(newData.getDoctor());
        medicalRecord.setPatientFirstName(newData.getFirstName());
        medicalRecord.setPatientLastName(newData.getLastName());
        medicalRecord.setPatientEmail(newData.getEmail());
        medicalRecord.setPatientPhoneNumber(newData.getPhoneNumber());
        medicalRecord.setPatientAddress(newData.getAddress());
        medicalRecord.setAge(newData.getAge());
        medicalRecord.setWeight(newData.getWeight());
        medicalRecord.setDisease(newData.getDisease());
        medicalRecord.setDescription(newData.getDescription());
        medicalRecord.setIsClosed(newData.getIsClosed());

        toRecordDTO(medicalRecordRepository.save(medicalRecord));
    }

    @Override
    public void deleteMedicalRecord(Long medicalRecordId) {
        medicalRecordRepository.deleteById(medicalRecordId);
    }
}
