package ru.innopolis.healthcode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.healthcode.models.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
