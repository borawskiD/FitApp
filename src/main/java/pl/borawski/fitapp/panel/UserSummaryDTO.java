package pl.borawski.fitapp.panel;

public class UserSummaryDTO {
    private String gender;
    private double weight;
    private double height;
    private double weeklyProgress;
    private double totalProgress;
    private double bmi;
    private double bmr;

    @Override
    public String toString() {
        return "UserSummaryDTO{" +
                "gender='" + gender + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", weeklyProgress=" + weeklyProgress +
                ", totalProgress=" + totalProgress +
                ", bmi=" + bmi +
                ", bmr=" + bmr +
                '}';
    }

    public UserSummaryDTO(String gender, double weight, double height, double weeklyProgress, double totalProgress, double bmi, double bmr) {
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.weeklyProgress = weeklyProgress;
        this.totalProgress = totalProgress;
        this.bmi = bmi;
        this.bmr = bmr;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public double getWeeklyProgress() {
        return weeklyProgress;
    }

    public void setWeeklyProgress(double weeklyProgress) {
        this.weeklyProgress = weeklyProgress;
    }

    public double getTotalProgress() {
        return totalProgress;
    }

    public void setTotalProgress(double totalProgress) {
        this.totalProgress = totalProgress;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public double getBmr() {
        return bmr;
    }

    public void setBmr(double bmr) {
        this.bmr = bmr;
    }
}
