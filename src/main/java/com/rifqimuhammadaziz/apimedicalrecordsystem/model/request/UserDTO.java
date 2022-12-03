package com.rifqimuhammadaziz.apimedicalrecordsystem.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDate;
import java.util.List;

@Data
public class UserDTO {
    private String name;

    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate birthdate;
    private String email;
    private String address;

    private List<String> mailCC;
}
