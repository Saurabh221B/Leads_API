package com.example.demo;



import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;


@Entity
@Table(name="LeadTable")
public class Lead {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lead_id")
    private Long leadId;
    @NotNull
    @Column(name = "Customer_firstName")
    private String firstName;
    @Column(name = "Customer_middleName")
    private String middleName;
    @NotNull
    @Column(name = "Customer_lastName")
    private String lastName;
    @Column(name = "Customer_emailId")
    @Email
    private String emailId;
    @NotNull
    @Column(name = "gender")
    private String gender;
    @Pattern(regexp ="^[6-9]\\d{9}$", message = "Invalid mobile number.")
    @NotNull
    @Column(name = "mobileNumber")
    private String mobileNumber;
    @Column(name = "dateOfBirth")
    @NotNull
    @DateTimeFormat(pattern = "DD/MM/YYYY")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;


    public Lead() {
    }

    public Lead(Long leadId, String firstName, String middleName, String lastName, String emailId, String gender, String mobileNumber, LocalDate dateOfBirth) {
        this.leadId = leadId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getLeadId() {
        return leadId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getGender() {
        return gender;
    }

    public void setLeadId(Long leadId) {
        this.leadId = leadId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }


}
