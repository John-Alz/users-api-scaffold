package co.com.usersapi.r2dbc;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "users")
public class UserEntity {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String identityNumber;
    private int age;

}
