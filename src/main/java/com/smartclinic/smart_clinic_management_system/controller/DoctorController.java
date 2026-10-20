
package com.smartclinic.smart_clinic_management_system.controller;

import com.smartclinic.smart_clinic_management_system.entity.Doctor;
import com.smartclinic.smart_clinic_management_system.repository.DoctorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorRepository doctorRepository;

    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.ok(doctorRepository.findAll());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Doctor>> searchDoctors(
            @RequestParam String name) {
        return ResponseEntity.ok(
                doctorRepository.findByNameContainingIgnoreCase(name));
    }

    @PostMapping
    public ResponseEntity<Doctor> addDoctor(
            @RequestBody Doctor doctor) {
        Doctor savedDoctor = doctorRepository.save(doctor);
        return ResponseEntity.ok(savedDoctor);
    }
}
