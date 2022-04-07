package com.ead.authuser.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    public interface UserDtoView {
        interface RegistrationPost {}
        interface UserPut {}
        interface PasswordPut {}
        interface ImagePut {}
    }

    private UUID userId;

    @NotBlank(groups = UserDtoView.RegistrationPost.class)
    @Size(min = 4 , max = 50, groups = UserDtoView.RegistrationPost.class)
    @JsonView(UserDtoView.RegistrationPost.class)
    private String username;

    @NotBlank(groups = {UserDtoView.RegistrationPost.class, UserDtoView.PasswordPut.class})
    @Size(min = 6 , max = 20, groups = {UserDtoView.RegistrationPost.class, UserDtoView.PasswordPut.class})
    @JsonView({UserDtoView.RegistrationPost.class, UserDtoView.PasswordPut.class})
    private String password;

    @NotBlank(groups = UserDtoView.PasswordPut.class)
    @Size(min = 6 , max = 20, groups = UserDtoView.PasswordPut.class)
    @JsonView(UserDtoView.PasswordPut.class)
    private String oldPassword;

    @NotBlank(groups = {UserDtoView.RegistrationPost.class, UserDtoView.UserPut.class})
    @Email(groups = {UserDtoView.RegistrationPost.class, UserDtoView.UserPut.class})
    @JsonView({UserDtoView.RegistrationPost.class, UserDtoView.UserPut.class})
    private String email;

    @JsonView({UserDtoView.RegistrationPost.class, UserDtoView.UserPut.class})
    private String fullname;

    @JsonView({UserDtoView.RegistrationPost.class, UserDtoView.UserPut.class})
    private String phoneNumber;

    @JsonView({UserDtoView.RegistrationPost.class, UserDtoView.UserPut.class})
    private String cpf;

    @NotBlank(groups = UserDtoView.ImagePut.class)
    @JsonView(UserDtoView.ImagePut.class)
    private String imageUrl;
}
