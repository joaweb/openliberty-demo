package com.tcs.demo.api.users.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author joaquinmartinezgutierrez
 */
@Data
public class UserDto {

    public static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";

    private int id;
    @NotBlank(message = "The Bank Name is required.")
    private String bankName;
    @NotBlank(message = "The Account Holder Name is required.")
    private String accountHolderName;
    @NotBlank(message = "The Account Number is required.")
    private String accountNumber;
    @NotBlank(message = "The Account Holder Email is required.")
    @Email(regexp = EMAIL_REGEX, message = "The Account Holder Email is invalid.")
    private String accountHolderEmail;

}
