package com.tcs.demo.api.users.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;

/**
 * @author joaquinmartinezgutierrez
 */
@Data
public class UserUpdateDto {

    public static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";

    private int id;
    private String accountNumber;
    @Email( regexp = EMAIL_REGEX, message = "The Account Holder Email is invalid.")
    private String accountHolderEmail;

}
