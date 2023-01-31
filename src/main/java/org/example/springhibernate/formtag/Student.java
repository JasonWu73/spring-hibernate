package org.example.springhibernate.formtag;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.LinkedHashMap;

@Data
public class Student {

    private String firstName;
    private String lastName;
    private String country;

    @Setter(AccessLevel.NONE)
    private LinkedHashMap<String, String> countryOptions;

    public Student() {
        // ISO country code to country name
        countryOptions = new LinkedHashMap<>();
        countryOptions.put("BR", "Brazil");
        countryOptions.put("FR", "France");
        countryOptions.put("DE", "Germany");
        countryOptions.put("IN", "India");
        countryOptions.put("US", "Unite States of America");
    }
}
