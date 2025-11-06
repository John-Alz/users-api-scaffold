package co.com.usersapi.r2dbc;

import co.com.usersapi.model.user.User;
import co.com.usersapi.model.user.gateways.UserRepository;
import co.com.usersapi.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class MyReactiveRepositoryAdapter extends ReactiveAdapterOperations<User, UserEntity, String, MyReactiveRepository> implements UserRepository {

    public MyReactiveRepositoryAdapter(MyReactiveRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, User.class));
    }

    @Override
    public Mono<User> saveUser(User user) {
        return this.save(user);
    }

    @Override
    public Mono<User> getUser(Long id) {
        return this.findById(String.valueOf(id));
    }

    @Override
    public Flux<User> getUsers() {
        return this.findAll();
    }

    @Override
    public Flux<User> getUsersByName(String name) {
        return this.repository.findByFirstNameContainingIgnoreCase(name)
                .map(this::toEntity);
    }

    @Override
    public Mono<User> updateUser(User user) {
        return this.save(user);
    }

    @Override
    public Mono<Void> deleteUser(Long id) {
        return this.repository.deleteById(String.valueOf(id));
    }
}
