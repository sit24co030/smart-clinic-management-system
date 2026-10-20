
package com.smartclinic.smart_clinic_management_system.service;

import com.smartclinic.smart_clinic_management_system.entity.Appointment;
import com.smartclinic.smart_clinic_management_system.repository.DoctorRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentService {

    private final DoctorRepository doctorRepository;

    public AppointmentService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Appointment> getAppointmentsByDate(
            List<Appointment> appointments, LocalDate date) {

        return appointments.stream()
                .filter(a -> a.getAppointmentTime() != null)
                .filter(a -> a.getAppointmentTime().toLocalDate().equals(date))
                .toList();
    }
}
