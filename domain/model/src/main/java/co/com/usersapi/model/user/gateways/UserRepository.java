package co.com.usersapi.model.user.gateways;

import co.com.usersapi.model.user.User;
import reactor.core.publisher.Mono;

public interface UserRepository {

    Mono<User> saveUser(User user);
    Mono<User> getUser(Long id);
    Mono<User> updateUser(User user);
    Mono<Void> deleteUser(Long id);

}
