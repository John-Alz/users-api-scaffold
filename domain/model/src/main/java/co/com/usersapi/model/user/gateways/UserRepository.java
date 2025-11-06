package co.com.usersapi.model.user.gateways;

import co.com.usersapi.model.user.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository {

    Mono<User> saveUser(User user);
    Mono<User> getUser(Long id);
    Flux<User> getUsers();
    Flux<User> getUsersByName(String name);
    Mono<User> updateUser(User user);
    Mono<Void> deleteUser(Long id);

}
