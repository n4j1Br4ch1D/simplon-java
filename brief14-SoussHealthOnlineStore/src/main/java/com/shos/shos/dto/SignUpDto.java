package com.shos.shos.dto;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Valid
public class SignUpDto {
    @NotNull
    @Column(length = 20)//
    private String fullName;
    @NotEmpty
    @Size(min = 2, message = "Fulltime should have at least 2 characters")
    private String userName;
    @NotEmpty
    private String email;
    @NotEmpty
    @Schema(type = "string", format = "password")
    @Size(min = 4, max = 8 , message = "Must have characters & number at least 8")//
    private String password;
}
