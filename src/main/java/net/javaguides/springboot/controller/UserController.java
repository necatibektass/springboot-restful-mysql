package net.javaguides.springboot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "CRUD REST APIs for User Resource", description = "Create user, Update user, Delete user and Get user APIs")
@RestController
@AllArgsConstructor
// http://localhost:8080/api/users
@RequestMapping("api/users")
public class UserController {
    private UserService userService;

    @Operation(summary = "Create new user", description = "Create User REST API is user to save user in a database")
    @ApiResponse(responseCode = "201", description = "User created successfully")
    // build create User REST API
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user) {
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @Operation(summary = "Get user by id", description = "Get User By Id REST API is used to fetch user from database using user id")
    @ApiResponse(responseCode = "200", description = "User fetched successfully")
    // build get User by id REST API
    // http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId) {
        UserDto user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Operation(summary = "Get all users", description = "Get All Users REST API is used to fetch all users from database")
    @ApiResponse(responseCode = "200", description = "Users fetched successfully")
    // build get all Users REST API
    // http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Operation(summary = "Update user by id", description = "Update User By Id REST API is used to update user in database using user id")
    @ApiResponse(responseCode = "200", description = "User updated successfully")
    // build update User REST API
    // http://localhost:8080/api/users/1
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId, @RequestBody @Valid UserDto user) {
        user.setId(userId);
        UserDto updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @Operation(summary = "Delete user by id", description = "Delete User By Id REST API is used to delete user from database using user id")
    @ApiResponse(responseCode = "200", description = "User deleted successfully")
    // build delete User REST API
    // http://localhost:8080/api/users/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!",HttpStatus.OK);
    }

    //@ExceptionHandler(ResourceNotFoundException.class)
    //public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {
    //    ErrorDetails errorDetails = new ErrorDetails(
    //            LocalDateTime.now(),
    //            exception.getMessage(),
    //            webRequest.getDescription(false),
    //            "USER_NOT_FOUND"
    //    );
//
    //    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    //}
}
