package com.Lattice.Task.Service;

import com.Lattice.Task.Entity.Patient;
import com.Lattice.Task.Repository.Patientrepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService
{
    @Autowired
    public Patientrepository patientrepository;


    public Patient addPatient(Patient patient) {

        return patientrepository.save(patient);
    }

    public void removePatient(int pid) {
        patientrepository.deleteById(pid);
    }

    public boolean existsById(int pid) {
        return patientrepository.existsById(pid);
    }
    public Patient getPatient(int pid) {
        return patientrepository.findById(pid).orElseThrow(() -> new EntityNotFoundException("Patient not found"));
    }

}
