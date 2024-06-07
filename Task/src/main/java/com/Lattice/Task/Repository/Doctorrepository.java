package com.Lattice.Task.Repository;

import com.Lattice.Task.Entity.City;
import com.Lattice.Task.Entity.Doctor;
import com.Lattice.Task.Entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Doctorrepository extends JpaRepository<Doctor,Integer>
{
    List<Doctor> findByCityAndSpeciality(City city, Speciality speciality);
}
