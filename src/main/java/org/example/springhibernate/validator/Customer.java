package org.example.springhibernate.validator;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Customer {

    private String firstName;

    @NotNull
    @Size(min = 1, message = "is required")
    private String lastName;
}
