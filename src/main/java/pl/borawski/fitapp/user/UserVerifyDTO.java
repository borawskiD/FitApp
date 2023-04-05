package pl.borawski.fitapp.user;

import org.springframework.stereotype.Service;

public class UserVerifyDTO {
    private final String email;
    private final String password;

    public UserVerifyDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
