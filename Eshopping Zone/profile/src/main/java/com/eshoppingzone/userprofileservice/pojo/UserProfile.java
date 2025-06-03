package com.eshoppingzone.userprofileservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {
    private int profileId;
    private String fullName;
    private String image;
    private String emailId;
    private long mobileNumber;
    private String about;
    private LocalDate dateOfBirth;
    private String gender;
    private String role;
    private String password;
}