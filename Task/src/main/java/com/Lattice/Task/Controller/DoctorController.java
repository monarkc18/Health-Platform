package com.Lattice.Task.Controller;

import com.Lattice.Task.Entity.*;
import com.Lattice.Task.Service.DoctorService;
import com.Lattice.Task.Service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
@Validated
public class DoctorController {
    @Autowired
    public DoctorService doctorService;
    @Autowired
    public PatientService patientService;
    @PostMapping("/add")
    public Doctor addDoctor(@RequestBody @Valid Doctor doctor) {
    return doctorService.addDoctor(doctor);
}

    @DeleteMapping("/{docid}")
    public ResponseEntity<String> removeDoctor(@PathVariable int docid) {
        if (!doctorService.existsById(docid)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is no doctor with the given ID");
        }

        doctorService.removeDoctor(docid);
        return ResponseEntity.ok("Doctor deleted successfully");
    }
    }
