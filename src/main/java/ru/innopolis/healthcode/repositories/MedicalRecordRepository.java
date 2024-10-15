package ru.innopolis.healthcode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.innopolis.healthcode.models.MedicalRecord;
import java.util.List;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
    @Query(value = "select m from MedicalRecord m where m.isClosed = false")
    List<MedicalRecord> findAllOpenedRecords();

    @Query("select p FROM MedicalRecord p where lower(p.patientFirstName) like lower(concat('%', :name, '%'))")
    List<MedicalRecord> findByPatientFirstName(String name);
}
