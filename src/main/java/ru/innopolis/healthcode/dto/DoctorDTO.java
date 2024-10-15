package ru.innopolis.healthcode.dto;

import lombok.*;
import ru.innopolis.healthcode.models.Doctor;
import java.util.List;
import java.util.stream.Collectors;

public enum DoctorDTO {;

    private interface DtoId { Long getId();}

    private interface DtoFirstName { String getFirstName(); }

    private interface DtoLastName { String getLastName(); }

    private interface DtoEmail { String getEmail(); }

    private interface DtoPhoneNumber { String getPhoneNumber(); }

    private interface DtoPosition { String getPosition(); }

    public enum Request{;
        @Data
        @Builder
        public static class Create implements DtoId, DtoFirstName, DtoLastName, DtoEmail, DtoPhoneNumber, DtoPosition {
            Long id;
            String firstName;
            String lastName;
            String email;
            String phoneNumber;
            String position;

            public static Create toDoctorDTO (Doctor doctor) {
                return Create.builder()
                        .id(doctor.getId())
                        .firstName(doctor.getFirstName())
                        .lastName(doctor.getLastName())
                        .email(doctor.getEmail())
                        .phoneNumber(doctor.getPhoneNumber())
                        .position(doctor.getPosition())
                        .build();
            }

            public static List<Create> toDoctorDTO(List<Doctor> doctors) {
                return doctors
                        .stream()
                        .map(Create::toDoctorDTO)
                        .collect(Collectors.toList());
            }
        }
    }

    public enum Response{;

        @Data
        @Builder
        public static class Brief implements DtoFirstName, DtoLastName, DtoPosition {
            String firstName;
            String lastName;
            String position;

            public static Brief briefInformationDTO (Doctor doctor) {
                return Brief.builder()
                        .firstName(doctor.getFirstName())
                        .lastName(doctor.getLastName())
                        .position(doctor.getPosition())
                        .build();
            }

            public static List<Brief> briefInformationDTO(List<Doctor> doctors) {
                return doctors
                        .stream()
                        .map(Brief::briefInformationDTO)
                        .collect(Collectors.toList());
            }
        }

        @Data
        @Builder
        public static class General implements DtoFirstName, DtoLastName, DtoEmail, DtoPhoneNumber, DtoPosition {
            String firstName;
            String lastName;
            String email;
            String phoneNumber;
            String position;

            public static General generalInformationDTO (Doctor doctor) {
                return General.builder()
                        .firstName(doctor.getFirstName())
                        .lastName(doctor.getLastName())
                        .email(doctor.getEmail())
                        .phoneNumber(doctor.getPhoneNumber())
                        .position(doctor.getPosition())
                        .build();
            }

            public static List<General> generalInformationDTO(List<Doctor> doctors) {
                return doctors
                        .stream()
                        .map(General::generalInformationDTO)
                        .collect(Collectors.toList());
            }
        }

        @Data
        @Builder
        public static class Private implements DtoId, DtoFirstName, DtoLastName, DtoEmail, DtoPhoneNumber, DtoPosition {
            Long id;
            String firstName;
            String lastName;
            String email;
            String phoneNumber;
            String position;

            public static Private privateInformationDTO (Doctor doctor) {
                return Private.builder()
                        .id(doctor.getId())
                        .firstName(doctor.getFirstName())
                        .lastName(doctor.getLastName())
                        .email(doctor.getEmail())
                        .phoneNumber(doctor.getPhoneNumber())
                        .position(doctor.getPosition())
                        .build();
            }

            public static List<Private> privateInformationDTO(List<Doctor> doctors) {
                return doctors
                        .stream()
                        .map(Private::privateInformationDTO)
                        .collect(Collectors.toList());
            }
        }
    }
}
