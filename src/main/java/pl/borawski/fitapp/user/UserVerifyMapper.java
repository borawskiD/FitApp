package pl.borawski.fitapp.user;
import pl.borawski.fitapp.user.User;
import pl.borawski.fitapp.user.UserVerifyDTO;

public class UserVerifyMapper {
    public static UserVerifyDTO map(User user) {
        String mail = user.getMail();
        String password = user.getPassword();
        return new UserVerifyDTO(mail, password);
    }
}
