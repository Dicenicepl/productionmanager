package com.example.demo.entity;

import com.example.demo.role.Role;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class AppUser {
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(name = "id")
    private Long id;
    @Column(name = "First_Name",nullable = false)
    private String firstName;
    @Column(name = "Last_Name",nullable = false)
    private String lastName;
    @Column(name = "Nick_Name",nullable = false)
    private String nickname;
    @Column(name = "Email",nullable = false)
    private String email;
    @Column(name = "Password",nullable = false)
    private String password;
    @Column(name = "Role",nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    public AppUser(String firstName, String lastName, String nickname, String email, String password, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.role = selectRole(String.valueOf(role));
    }
    private Role selectRole(String role){
        if (!role.isBlank()) {
            switch (role) {
                case "ADMIN" -> {
                    return Role.ADMIN;
                }
                case "USER" -> {
                    return Role.USER;
                }
            }
        }
        return null;
    }

}
