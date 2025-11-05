package co.com.usersapi.model.user;
import lombok.*;
//import lombok.NoArgsConstructor;


@Data
public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String identityNumber;
    private int age;

}
