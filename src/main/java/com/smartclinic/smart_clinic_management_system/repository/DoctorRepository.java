
package com.smartclinic.smart_clinic_management_system.repository;

import com.smartclinic.smart_clinic_management_system.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    List<Doctor> findByNameContainingIgnoreCase(String name);

    List<Doctor> findBySpecialtyIgnoreCase(String specialty);
}
