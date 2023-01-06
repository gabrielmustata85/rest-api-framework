package org.example.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {


    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;

}
