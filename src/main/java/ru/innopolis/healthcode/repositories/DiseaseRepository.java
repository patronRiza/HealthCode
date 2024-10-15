package ru.innopolis.healthcode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.healthcode.models.Disease;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Long> {
}
