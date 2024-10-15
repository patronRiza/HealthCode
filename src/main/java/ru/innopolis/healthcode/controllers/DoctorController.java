package ru.innopolis.healthcode.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.healthcode.dto.DoctorDTO;
import ru.innopolis.healthcode.services.DoctorService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<DoctorDTO.Response.Private>> getDoctorsPage(Model model) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(doctorService.getAll());
    }

    @GetMapping("/{doctor-id}")
    public ResponseEntity<DoctorDTO.Response.General> getDoctorById(@PathVariable("doctor-id") Long doctorId, Model model) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(doctorService.getById(doctorId));
    }


    @PostMapping
    public ResponseEntity<DoctorDTO.Request.Create> addDoctor(@Valid @RequestBody DoctorDTO.Request.Create doctorDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(doctorService.addDoctor(doctorDTO));
    }

    @DeleteMapping()
    public ResponseEntity<DoctorDTO.Request.Create> deleteDoctor(@RequestParam("doctor-id") Long doctorId) {
        doctorService.deleteById(doctorId);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED).build();
    }


    @PutMapping("/{doctor-id}")
    public ResponseEntity<DoctorDTO.Request.Create> updateDoctor(@PathVariable("doctor-id") Long doctorId,
                                                    @RequestBody DoctorDTO.Request.Create newData) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(doctorService.updateDoctor(doctorId, newData));
    }
}
