package ru.innopolis.healthcode.dto;

import lombok.Builder;
import lombok.Data;
import ru.innopolis.healthcode.models.Disease;
import ru.innopolis.healthcode.models.Doctor;
import ru.innopolis.healthcode.models.MedicalRecord;
import java.util.List;
import java.util.stream.Collectors;


public enum RecordDTO {;

    private interface DtoId { Long getId(); }

    private interface DtoDoctor { Doctor getDoctor(); }

    private interface DtoPatientFirstName { String getFirstName(); }

    private interface DtoPatientLastName { String getLastName(); }

    private interface DtoPatientEmail { String getEmail(); }

    private interface DtoPatientPhoneNumber { String getPhoneNumber(); }

    private interface DtoPatientAddress { String getAddress(); }

    private interface DtoPatientAge { Integer getAge(); }

    private interface DtoPatientWeight { Integer getWeight(); }

    private interface DtoDisease {Disease getDisease(); }

    private interface DtoDescription {String getDescription(); }

    private interface DtoIsClosed { Boolean getIsClosed(); }

    public enum Request {;

        @Data
        @Builder
        public static class Create implements
                DtoId, DtoDoctor, DtoPatientFirstName,
                DtoPatientLastName, DtoPatientEmail, DtoPatientPhoneNumber,
                DtoPatientAddress, DtoDisease, DtoDescription,
                DtoPatientAge, DtoPatientWeight, DtoIsClosed {
            Long id;
            Doctor doctor;
            String firstName;
            String lastName;
            String email;
            String phoneNumber;
            String address;
            Integer age;
            Integer weight;
            Disease disease;
            String description;
            Boolean isClosed;

            public static Create toRecordDTO (MedicalRecord medicalRecord) {
                return Create.builder()
                        .id(medicalRecord.getId())
                        .doctor(medicalRecord.getDoctor())
                        .firstName(medicalRecord.getPatientFirstName())
                        .lastName(medicalRecord.getPatientLastName())
                        .email(medicalRecord.getPatientEmail())
                        .phoneNumber(medicalRecord.getPatientPhoneNumber())
                        .address(medicalRecord.getPatientAddress())
                        .age(medicalRecord.getAge())
                        .weight(medicalRecord.getWeight())
                        .disease(medicalRecord.getDisease())
                        .description(medicalRecord.getDescription())
                        .isClosed(medicalRecord.getIsClosed())
                        .build();
            }

            public static List<Create> toRecordDTO(List<MedicalRecord> medicalRecords) {
                return medicalRecords
                        .stream()
                        .map(Create::toRecordDTO)
                        .collect(Collectors.toList());
            }
        }
    }

    public enum Response {;

        @Data
        @Builder
        public static class Brief implements
                DtoId, DtoDoctor, DtoPatientFirstName, DtoPatientLastName, DtoDisease {
            Long id;
            Doctor doctor;
            String firstName;
            String lastName;
            Disease disease;

            public static Brief briefInformationDTO (MedicalRecord medicalRecord) {
                return Brief.builder()
                        .id(medicalRecord.getId())
                        .doctor(medicalRecord.getDoctor())
                        .firstName(medicalRecord.getPatientFirstName())
                        .lastName(medicalRecord.getPatientLastName())
                        .disease(medicalRecord.getDisease())
                        .build();
            }

            public static List<Brief> briefInformationDTO(List<MedicalRecord> medicalRecords) {
                return medicalRecords
                        .stream()
                        .map(Brief::briefInformationDTO)
                        .collect(Collectors.toList());
            }
        }

        @Data
        @Builder
        public static class General implements
                DtoDoctor, DtoPatientFirstName, DtoPatientLastName,
                DtoPatientEmail, DtoPatientPhoneNumber, DtoPatientAddress,
                DtoPatientAge, DtoPatientWeight, DtoDisease, DtoDescription {
            Doctor doctor;
            String firstName;
            String lastName;
            String email;
            String phoneNumber;
            String address;
            Integer age;
            Integer weight;
            Disease disease;
            String description;

            public static General generalInformationDTO (MedicalRecord medicalRecord) {
                return General.builder()
                        .doctor(medicalRecord.getDoctor())
                        .firstName(medicalRecord.getPatientFirstName())
                        .lastName(medicalRecord.getPatientLastName())
                        .email(medicalRecord.getPatientEmail())
                        .phoneNumber(medicalRecord.getPatientPhoneNumber())
                        .address(medicalRecord.getPatientAddress())
                        .disease(medicalRecord.getDisease())
                        .description(medicalRecord.getDescription())
                        .age(medicalRecord.getAge())
                        .weight(medicalRecord.getWeight())
                        .build();
            }

            public static List<General> generalInformationDTO(List<MedicalRecord> medicalRecords) {
                return medicalRecords
                        .stream()
                        .map(General::generalInformationDTO)
                        .collect(Collectors.toList());
            }
        }

        @Data
        @Builder
        public static class Private implements
                DtoId, DtoDoctor, DtoPatientFirstName,
                DtoPatientLastName, DtoPatientEmail, DtoPatientPhoneNumber,
                DtoPatientAddress, DtoDisease, DtoDescription,
                DtoPatientAge, DtoPatientWeight, DtoIsClosed {
            Long id;
            Doctor doctor;
            String firstName;
            String lastName;
            String email;
            String phoneNumber;
            String address;
            Integer age;
            Integer weight;
            Disease disease;
            String description;
            Boolean isClosed;

            public static Private privateInformationDTO (MedicalRecord medicalRecord) {
                return Private.builder()
                        .id(medicalRecord.getId())
                        .doctor(medicalRecord.getDoctor())
                        .firstName(medicalRecord.getPatientFirstName())
                        .lastName(medicalRecord.getPatientLastName())
                        .email(medicalRecord.getPatientEmail())
                        .phoneNumber(medicalRecord.getPatientPhoneNumber())
                        .address(medicalRecord.getPatientAddress())
                        .age(medicalRecord.getAge())
                        .weight(medicalRecord.getWeight())
                        .disease(medicalRecord.getDisease())
                        .description(medicalRecord.getDescription())
                        .isClosed(medicalRecord.getIsClosed())
                        .build();
            }

            public static List<Private> privateInformationDTO(List<MedicalRecord> medicalRecords) {
                return medicalRecords
                        .stream()
                        .map(Private::privateInformationDTO)
                        .collect(Collectors.toList());
            }
        }
    }
}
