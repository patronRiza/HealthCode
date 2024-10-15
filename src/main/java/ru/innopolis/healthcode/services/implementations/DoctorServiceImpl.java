package ru.innopolis.healthcode.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.innopolis.healthcode.dto.DoctorDTO;
import ru.innopolis.healthcode.exceptions.MedicalRecordNotFound;
import ru.innopolis.healthcode.models.Doctor;
import ru.innopolis.healthcode.repositories.DoctorRepository;
import ru.innopolis.healthcode.services.DoctorService;
import static ru.innopolis.healthcode.dto.DoctorDTO.Request.Create.toDoctorDTO;
import static ru.innopolis.healthcode.dto.DoctorDTO.Response.General.generalInformationDTO;
import static ru.innopolis.healthcode.dto.DoctorDTO.Response.Private.privateInformationDTO;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public List<DoctorDTO.Response.Private> getAll() {
        return privateInformationDTO(doctorRepository.findAll());
    }

    @Override
    public DoctorDTO.Request.Create addDoctor(DoctorDTO.Request.Create doctorDTO) {
        return toDoctorDTO(doctorRepository.save(
                Doctor.builder()
                        .firstName(doctorDTO.getFirstName())
                        .lastName(doctorDTO.getLastName())
                        .email(doctorDTO.getEmail())
                        .phoneNumber(doctorDTO.getPhoneNumber())
                        .position(doctorDTO.getPosition())
                        .build()
        ));
    }

    @Override
    public void deleteById(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public DoctorDTO.Response.General getById(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(MedicalRecordNotFound::new);
        return generalInformationDTO(doctor);
    }

    @Override
    public DoctorDTO.Request.Create updateDoctor(Long doctorId, DoctorDTO.Request.Create doctorDTO) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(MedicalRecordNotFound::new);

        doctor.setPosition(doctorDTO.getPosition());
        doctor.setPhoneNumber(doctorDTO.getPhoneNumber());

        return toDoctorDTO(doctorRepository.save(doctor));
    }
}
