package ru.innopolis.healthcode.services;

import ru.innopolis.healthcode.dto.DiseaseDTO;


import java.util.List;

public interface DiseaseService {
    List<DiseaseDTO.Response.Private> getAll();
    DiseaseDTO.Response.General getById(Long id);
    DiseaseDTO.Request.Create addDisease (DiseaseDTO.Request.Create diseaseDTO);
    DiseaseDTO.Request.Create updateDisease (Long diseaseId, DiseaseDTO.Request.Create diseaseDTO);
}
