package ru.innopolis.healthcode.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.innopolis.healthcode.dto.DiseaseDTO;
import ru.innopolis.healthcode.repositories.DiseaseRepository;
import ru.innopolis.healthcode.services.DiseaseService;
import static ru.innopolis.healthcode.dto.DiseaseDTO.Response.Private.privateInformationDTO;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DiseaseServiceImpl implements DiseaseService {

    private final DiseaseRepository diseaseRepository;

    @Override
    public List<DiseaseDTO.Response.Private> getAll() {
        return privateInformationDTO(diseaseRepository.findAll());
    }

    @Override
    public DiseaseDTO.Response.General getById(Long id) {
        return null;
    }

    @Override
    public DiseaseDTO.Request.Create addDisease(DiseaseDTO.Request.Create diseaseDTO) {
        return null;
    }

    @Override
    public DiseaseDTO.Request.Create updateDisease(Long diseaseId, DiseaseDTO.Request.Create diseaseDTO) {
        return null;
    }
}
