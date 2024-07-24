package org.lorenzo.departmentservice.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;


@Getter
@Setter
public class Employee {

    private UUID id;
    private String name;
    private UUID departmentId;

}
