package co.com.usersapi.api;

import co.com.usersapi.api.dto.request.UserRequestDTO;
import co.com.usersapi.api.dto.response.UserResponseDTO;
import co.com.usersapi.api.mapper.UserMapper;
import co.com.usersapi.usecase.user.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Component
@RequiredArgsConstructor
public class Handler {

    private final UserUseCase userUseCase;
    private final UserMapper userMapper;

    public Mono<ServerResponse> saveUser(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(UserRequestDTO.class)
                .map(userMapper::toModel)
                .flatMap(userUseCase::saveUser)
                .map(userMapper::toResponse)
                .flatMap(result -> ServerResponse
                        .status(HttpStatus.CREATED)
                        .bodyValue(result));
    }

    public Mono<ServerResponse> getUser(ServerRequest serverRequest) {
        Long id = Long.valueOf(serverRequest.pathVariable("id"));
        return userUseCase.getUser(id)
                .map(userMapper::toResponse)
                .flatMap(user -> ServerResponse.ok().bodyValue(user));
    }

    public Mono<ServerResponse> getUsers(ServerRequest serverRequest) {
        String name = serverRequest.queryParam("name").orElse(null);
        var flux =  (name == null || name.isBlank())
                ? userUseCase.getUsers()
                : userUseCase.getUserByName(name)
                .map(userMapper::toResponse);
        return ServerResponse.ok()
                .body(flux, UserResponseDTO.class);
    }

    public Mono<ServerResponse> updateUser(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(UserRequestDTO.class)
                .map(userMapper::toModel)
                .flatMap(userUseCase::updateUser)
                .map(userMapper::toResponse)
                .flatMap(user -> ServerResponse
                        .ok().bodyValue(user));
    }

    public Mono<ServerResponse> deleteUser(ServerRequest serverRequest) {
        Long id = Long.valueOf(serverRequest.pathVariable("id"));
        return userUseCase.deleteUser(id)
                .then(Mono.defer(() -> ServerResponse.ok().bodyValue("Usuario eliminado.")));
    }

}
