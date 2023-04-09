package pl.borawski.fitapp.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "application_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String mail;
    private String password;
    private String name;
    private LocalDate birthDate;
    private double weight;
    private double height;
    private String Gender;
    private String activityLevel;
    private LocalDateTime registrationDate;

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
