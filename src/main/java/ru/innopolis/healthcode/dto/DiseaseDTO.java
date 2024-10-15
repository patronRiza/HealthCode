package ru.innopolis.healthcode.dto;

import lombok.Builder;
import lombok.Data;
import ru.innopolis.healthcode.models.Disease;
import java.util.List;
import java.util.stream.Collectors;


public enum DiseaseDTO {;

    private interface DtoId { Long getId(); }

    private interface DtoName { String getName(); }

    private interface DtoDescription { String getDescription(); }

    public enum Request {;

        @Data
        @Builder
        public static class Create implements DtoId, DtoName, DtoDescription {
            Long id;
            String name;
            String description;

            public static Create toDiseaseDTO (Disease disease) {
                return Create.builder()
                        .id(disease.getId())
                        .name(disease.getName())
                        .description(disease.getDescription())
                        .build();
            }

            public static List<Create> toDiseaseDTO(List<Disease> diseases) {
                return diseases
                        .stream()
                        .map(Create::toDiseaseDTO)
                        .collect(Collectors.toList());
            }
        }
    }

    public enum Response {;

        @Data
        @Builder
        public static class General implements DtoName, DtoDescription {
            String name;
            String description;

            public static General generalInformationDTO (Disease disease) {
                return General.builder()
                        .name(disease.getName())
                        .description(disease.getDescription())
                        .build();
            }

            public static List<General> generalInformationDTO(List<Disease> diseases) {
                return diseases
                        .stream()
                        .map(General::generalInformationDTO)
                        .collect(Collectors.toList());
            }
        }

        @Data
        @Builder
        public static class Private implements DtoId, DtoName, DtoDescription {
            Long id;
            String name;
            String description;

            public static Private privateInformationDTO (Disease disease) {
                return Private.builder()
                        .id(disease.getId())
                        .name(disease.getName())
                        .description(disease.getDescription())
                        .build();
            }

            public static List<Private> privateInformationDTO(List<Disease> diseases) {
                return diseases
                        .stream()
                        .map(Private::privateInformationDTO)
                        .collect(Collectors.toList());
            }
        }
    }
}
