package ru.innopolis.healthcode.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.healthcode.dto.RecordDTO;
import ru.innopolis.healthcode.models.MedicalRecord;
import ru.innopolis.healthcode.services.DiseaseService;
import ru.innopolis.healthcode.services.DoctorService;
import ru.innopolis.healthcode.services.MedicalRecordService;

@RequiredArgsConstructor
@Controller
public class HomeController {
    @Value("${spring.application.name}")
    String appName;

    private final DoctorService doctorService;
    private final DiseaseService diseaseService;
    private final MedicalRecordService medicalRecordService;

    @GetMapping
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home_page";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("appName", appName);
        model.addAttribute("doctors", doctorService.getAll());
        model.addAttribute("diseases", diseaseService.getAll());
        model.addAttribute("record", RecordDTO.Request.Create.toRecordDTO(new MedicalRecord()));
        return "createMedicalRecords";
    }

}
