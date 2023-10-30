package net.javaguides.springboot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(name = "UserDto Model Information")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    @Schema(description = "User first name should not be null or empty", example = "John")
    // User first name should not be null or empty
    @NotEmpty(message = "User first name should not be null or empty")
    private String firstName;

    @Schema(description = "User last name should not be null or empty", example = "Doe")
    // User last name should not be null or empty
    @NotEmpty(message = "User last name should not be null or empty")
    private String lastName;

    @Schema(description = "User email should not be null or empty", example = "jhon.doe@gmail.com")
    // User email should not be null or empty
    // Email adress should be valid
    @NotEmpty(message = "User email should not be null or empty")
    @Email(message = "Email adress should be valid")
    private String email;
}
