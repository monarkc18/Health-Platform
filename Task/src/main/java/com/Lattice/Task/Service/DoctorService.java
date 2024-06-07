package com.Lattice.Task.Service;

import com.Lattice.Task.Entity.*;
import com.Lattice.Task.Repository.Doctorrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DoctorService {
    @Autowired
    public Doctorrepository doctorrepository;


    public Doctor addDoctor(Doctor doctor) {
        return doctorrepository.save(doctor);
    }

    public void removeDoctor(int docid) {

        doctorrepository.deleteById(docid);
    }
    public boolean existsById(int docid) {
        return doctorrepository.existsById(docid);
    }


    public List<Doctor> suggestDoctors(String patientCity, Speciality speciality) {
        if (!isLocationSupported(patientCity)) {
            throw new IllegalArgumentException("We are still waiting to expand to your location");
        }

        City doctorCity = City.fromValue(patientCity);
        return doctorrepository.findByCityAndSpeciality(doctorCity, speciality);
    }

    private boolean isLocationSupported(String city) {
        return Arrays.asList(City.DELHI.toString(), City.NOIDA.toString(), City.FARIDABAD.toString()).contains(city.toUpperCase());
    }
}
