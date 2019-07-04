package hw6.entities;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class User {

    private String userName = "PITER CHAILOVSKII";
    private String login = "epam";
    private String password = "1234";

    public User(String userName, String login, String password) {
        this.userName = userName;
        this.login = login;
        this.password = password;
    }
}
