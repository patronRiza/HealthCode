package ru.innopolis.healthcode.services;

import ru.innopolis.healthcode.dto.DoctorDTO;

import java.util.List;

public interface DoctorService {
    List<DoctorDTO.Response.Private> getAll();
    DoctorDTO.Request.Create addDoctor (DoctorDTO.Request.Create doctorDTO);
    DoctorDTO.Response.General getById(Long id);
    void deleteById(Long id);
    DoctorDTO.Request.Create updateDoctor (Long doctorId, DoctorDTO.Request.Create doctorDTO);
}
