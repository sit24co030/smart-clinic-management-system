
package com.smartclinic.smart_clinic_management_system.controller;

import com.smartclinic.smart_clinic_management_system.entity.Prescription;
import com.smartclinic.smart_clinic_management_system.repository.PrescriptionRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    private final PrescriptionRepository prescriptionRepository;

    public PrescriptionController(
            PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    @GetMapping
    public ResponseEntity<List<Prescription>> getAllPrescriptions() {
        return ResponseEntity.ok(prescriptionRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Prescription> createPrescription(
            @RequestBody Prescription prescription) {
        Prescription savedPrescription =
                prescriptionRepository.save(prescription);
        return ResponseEntity.ok(savedPrescription);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Prescription>> getPrescriptionsByPatient(
            @PathVariable Long patientId) {
        return ResponseEntity.ok(
                prescriptionRepository.findByPatient_Id(patientId));
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Prescription>> getPrescriptionsByDoctor(
            @PathVariable Long doctorId) {
        return ResponseEntity.ok(
                prescriptionRepository.findByDoctor_Id(doctorId));
    }
}
