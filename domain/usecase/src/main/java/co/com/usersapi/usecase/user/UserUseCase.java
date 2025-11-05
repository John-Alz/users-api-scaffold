package co.com.usersapi.usecase.user;

import co.com.usersapi.model.user.User;
import co.com.usersapi.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
public class UserUseCase {

    private final UserRepository userRepository;

    public Mono<User> saveUser(User user) {
        return userRepository.saveUser(user);
    }

    public Mono<User> getUser(Long id) {
        return userRepository.getUser(id);
    }

    public Mono<User> updateUser(User user) {
        return userRepository.updateUser(user);
    }

    public Mono<Void> deleteUser(Long id) {
        return userRepository.deleteUser(id);
    }
}
