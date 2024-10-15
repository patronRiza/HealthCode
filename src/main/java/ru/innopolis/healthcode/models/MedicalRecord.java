package ru.innopolis.healthcode.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "list_of_medical_records")
@Getter
@Setter
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Column(name = "patient_first_name")
    private String patientFirstName;

    @Column(name = "patient_last_name")
    private String patientLastName;

    @Column(name = "patient_email")
    private String patientEmail;

    @Column(name = "patient_phone_number")
    private String patientPhoneNumber;

    @Column(name = "patient_address")
    private String patientAddress;

    @Column(name = "age")
    private Integer age;

    @Column(name = "weight")
    private Integer weight;

    @ManyToOne
    @JoinColumn(name = "disease_id")
    private Disease disease;

    @Column(name = "description")
    private String description;

    @Column(name = "is_closed")
    @ColumnDefault("false")
    private Boolean isClosed;
}
