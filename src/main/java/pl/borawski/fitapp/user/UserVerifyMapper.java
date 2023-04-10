package pl.borawski.fitapp.user;

public class UserVerifyMapper {
    public static UserVerifyDTO map(User user) {
        String mail = user.getMail();
        String password = user.getPassword();
        return new UserVerifyDTO(mail, password);
    }
}
