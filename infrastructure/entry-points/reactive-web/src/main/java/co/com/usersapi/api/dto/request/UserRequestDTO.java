package co.com.usersapi.api.dto.request;

public record UserRequestDTO(
        String firstName,
        String lastName,
        String identityNumber,
        int age
) {
}
