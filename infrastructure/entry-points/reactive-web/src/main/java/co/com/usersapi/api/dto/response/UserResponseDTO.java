package co.com.usersapi.api.dto.response;

public record UserResponseDTO(
        Long id,
        String firstName,
        String lastName,
        String identityNumber,
        int age
) {
}
