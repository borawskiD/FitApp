package pl.borawski.fitapp.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import pl.borawski.fitapp.data.HealthDataEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "application_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String mail;
    private String password;
    private String name;
    private LocalDate birthDate;
    private LocalDateTime registrationDate;
    @OneToMany(mappedBy = "user")
    private List<HealthDataEntity> healthData = new ArrayList<>();

    public User(String mail, String password, String name, LocalDate birthDate, LocalDateTime registrationDate) {
        this.mail = mail;
        this.password = password;
        this.name = name;
        this.birthDate = birthDate;
        this.registrationDate = registrationDate;
    }
    public User(){
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public List<HealthDataEntity> getHealthData() {
        return healthData;
    }

    public void setHealthData(List<HealthDataEntity> healthData) {
        this.healthData = healthData;
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
