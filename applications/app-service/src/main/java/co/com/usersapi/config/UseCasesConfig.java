package co.com.usersapi.config;

import co.com.usersapi.api.Handler;
import co.com.usersapi.model.user.gateways.UserRepository;
import co.com.usersapi.usecase.user.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

//@Configuration
//@ComponentScan(
//        basePackages = "co.com.usersapi.usecase",
//        includeFilters = @ComponentScan.Filter(
//                type = FilterType.REGEX,
//                pattern = "co\\.com\\.usersapi\\.usecase\\..*UseCase$"
//        ),
//        useDefaultFilters = false
//)
//public class UseCasesConfig {}

@Configuration
public class UseCasesConfig {

        @Bean
        public UserUseCase userUseCase(UserRepository userRepository) {
                return new UserUseCase(userRepository);
        }

        @Bean
        public Handler handler(UserUseCase userUseCase) {
                return new Handler(userUseCase);
        }

}