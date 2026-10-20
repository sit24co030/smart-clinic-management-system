
package com.smartclinic.smart_clinic_management_system.repository;

import com.smartclinic.smart_clinic_management_system.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByDoctor_Id(Long doctorId);
}
