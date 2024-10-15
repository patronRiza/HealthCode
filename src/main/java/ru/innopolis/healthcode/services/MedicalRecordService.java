package ru.innopolis.healthcode.services;

import ru.innopolis.healthcode.dto.RecordDTO;
import java.util.List;

public interface MedicalRecordService {
    List<RecordDTO.Response.Brief> getAll();
    List<RecordDTO.Response.Brief> getByPatientName(String patientName);
    RecordDTO.Response.Private getById(Long medicalRecordId);
    void addMedicalRecord (RecordDTO.Request.Create medicalRecordDTO);
    void updateMedicalRecord (Long medicalRecordId, RecordDTO.Request.Create medicalRecordDTO);
    void deleteMedicalRecord (Long medicalRecordId);
}
