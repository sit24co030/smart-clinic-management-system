
package com.smartclinic.smart_clinic_management_system.repository;

import com.smartclinic.smart_clinic_management_system.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByEmail(String email);

    List<Patient> findByEmailOrPhone(String email, String phone);
}
