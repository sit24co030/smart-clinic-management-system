
package com.smartclinic.smart_clinic_management_system.controller;

import com.smartclinic.smart_clinic_management_system.entity.Appointment;
import com.smartclinic.smart_clinic_management_system.repository.AppointmentRepository;
import com.smartclinic.smart_clinic_management_system.service.AppointmentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentService appointmentService;

    public AppointmentController(
            AppointmentRepository appointmentRepository,
            AppointmentService appointmentService) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return ResponseEntity.ok(appointmentRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(
            @RequestBody Appointment appointment) {
        Appointment savedAppointment =
                appointmentRepository.save(appointment);
        return ResponseEntity.ok(savedAppointment);
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByDoctor(
            @PathVariable Long doctorId) {
        return ResponseEntity.ok(
                appointmentRepository.findByDoctor_Id(doctorId));
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Appointment>> getAppointmentsByDate(
            @PathVariable LocalDate date) {
        List<Appointment> appointments =
                appointmentService.getAppointmentsByDate(
                        appointmentRepository.findAll(), date);
        return ResponseEntity.ok(appointments);
    }
}
