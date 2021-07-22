package pl.indexpz.charity.controller.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserDTO {
    @Email
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
