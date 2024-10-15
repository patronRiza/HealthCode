package ru.innopolis.healthcode.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.healthcode.dto.RecordDTO;
import ru.innopolis.healthcode.services.DiseaseService;
import ru.innopolis.healthcode.services.DoctorService;
import ru.innopolis.healthcode.services.MedicalRecordService;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/records")
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;
    private final DoctorService doctorService;
    private final DiseaseService diseaseService;

    @GetMapping
    public String getMedicalRecordsPage(Model model) {
        model.addAttribute("records", medicalRecordService.getAll());
        return "currentMedicalRecords";
    }

    @GetMapping("/find")
    public String getMedicalRecordsByPatientName(@RequestParam("firstName") String  name, Model model) {
        List<RecordDTO.Response.Brief> records = medicalRecordService.getByPatientName(name);
        model.addAttribute("records", records);
        return "currentMedicalRecords";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        RecordDTO.Response.Private recordDTO = medicalRecordService.getById(id);
        model.addAttribute("doctors", doctorService.getAll());
        model.addAttribute("diseases", diseaseService.getAll());
        model.addAttribute("record", recordDTO);
        return "editPage";
    }

    @PostMapping("/update")
    public String updateRecord(@RequestParam("id") Long id, @ModelAttribute RecordDTO.Request.Create recordDTO) {
        medicalRecordService.updateMedicalRecord(id, recordDTO);
        return "redirect:/records";
    }

    @PostMapping("/delete")
    public String deleteMedicalRecord(@RequestParam("id") Long id) {
        medicalRecordService.deleteMedicalRecord(id);
        return "redirect:/records";
    }


    @PostMapping
    public String  addMedicalRecord(@ModelAttribute  RecordDTO.Request.Create recordDTO) {
        medicalRecordService.addMedicalRecord(recordDTO);
        return "redirect:/records";
    }
}
