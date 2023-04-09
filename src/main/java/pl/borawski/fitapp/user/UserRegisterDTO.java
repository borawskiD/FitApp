package pl.borawski.fitapp.user;

import jakarta.validation.constraints.*;
import pl.borawski.fitapp.config.Unique;

import java.time.LocalDate;

public class UserRegisterDTO {
    @Email(message = "Put full mail address")
    @NotEmpty(message = "Field cannot be empty")
    @Unique(message = "This e-mail has been already connected with other account. Try to log in or use other")
    private String mail;
    @Size(min=8, max = 50, message = "Length of this field must be between 8 and 50 characters")
    private String password;
    @Size(min=2, max = 30, message = "Length of this field must be between 2 and 30 characters")
    private String name;
    @Past(message = "Date should be in the past :-)")
    @NotNull(message = "Choose correct date!")
    private LocalDate birthDate;
    @Positive(message = "Weight must be above 0")
    private double weight;
    @Positive(message = "Height must be above 0")
    private double height;
    @NotEmpty
    private String Gender;
    @Size(min=1, max = 10)
    private String activityLevel;

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
}
