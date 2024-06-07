package com.Lattice.Task.Repository;

import com.Lattice.Task.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Patientrepository extends JpaRepository<Patient,Integer>
{

}
