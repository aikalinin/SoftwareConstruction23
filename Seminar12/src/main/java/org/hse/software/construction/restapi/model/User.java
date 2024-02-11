package org.hse.software.construction.restapi.model;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

  private UUID id;

  private String name;

  private LocalDate birthDate;
}
