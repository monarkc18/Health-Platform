package com.Lattice.Task.Controller;

import com.Lattice.Task.Entity.City;
import com.Lattice.Task.Entity.Doctor;
import com.Lattice.Task.Entity.Patient;
import com.Lattice.Task.Entity.Symptom;
import com.Lattice.Task.Service.DoctorService;
import com.Lattice.Task.Service.PatientService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/patients")
@Validated
public class PatientController
{
    @Autowired
    public PatientService patientService;

    @Autowired
    public DoctorService doctorService;


    @PostMapping("/add")
    public Patient addPatient(@RequestBody @Valid Patient patient)
    { patient.setSymptom(Symptom.valueOf(patient.getSymptom().name().toUpperCase()));
        return patientService.addPatient(patient);
    }

    @DeleteMapping("/{pid}")
    public ResponseEntity<String> removePatient(@PathVariable int  pid) {

        if (!patientService.existsById(pid)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is no patient with the given ID");
        }
        patientService.removePatient(pid);
        return ResponseEntity.ok("Patient deleted successfully");
    }

    @GetMapping("/suggestdoctor/{pid}")
    public ResponseEntity<?> suggestDoctor(@PathVariable int pid) {
        try {
            Patient patient = patientService.getPatient(pid);
            if (!isLocationSupported(patient.getCity())) {
                return new ResponseEntity<>("We are still waiting to expand to your location", HttpStatus.NOT_FOUND);
            }

            List<Doctor> suggestedDoctors = doctorService.suggestDoctors(patient.getCity(), patient.getSymptom().getSpeciality());

            if (suggestedDoctors.isEmpty()) {
                return new ResponseEntity<>("There isn’t any doctor present at your location for your symptom", HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(suggestedDoctors, HttpStatus.OK);
            }
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    private boolean isLocationSupported(String city) {
        return Arrays.asList(City.DELHI.toString(), City.NOIDA.toString(), City.FARIDABAD.toString()).contains(city.toUpperCase());
    }

}


