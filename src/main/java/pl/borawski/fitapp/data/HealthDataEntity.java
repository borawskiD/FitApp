package pl.borawski.fitapp.data;

import jakarta.persistence.*;
import pl.borawski.fitapp.user.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "health_data")
public class HealthDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rowId;
    private double weight;
    private double height;
    private String gender;
    private String activityLevel;
    private LocalDateTime updateDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public HealthDataEntity(double weight, double height, String gender, String activityLevel, LocalDateTime updateDate, User user) {
        this.weight = weight;
        this.height = height;
        this.gender = gender;
        this.activityLevel = activityLevel;
        this.updateDate = updateDate;
        this.user = user;
    }

    public HealthDataEntity() {
    }

    public Long getRowId() {
        return rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
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
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
