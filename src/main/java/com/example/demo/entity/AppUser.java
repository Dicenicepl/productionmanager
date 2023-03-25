package com.example.demo.entity;

import com.example.demo.role.Role;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
// TODO: 23.03.2023 dodać implement UserDetails
public class AppUser {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "First_Name")
    @Nonnull
    private String firstName;
    @Column(name = "Last_Name")
    @Nonnull
    private String lastName;
    @Column(name = "Nick_Name")
    @Nonnull
    private String nickname;
    @Column(name = "Email")
    @Nonnull
    private String email;
    @Column(name = "Password")
    @Nonnull
    private String password;
    @Column(name = "Role")
    @Nonnull
    private Role role;

    public AppUser(String firstName, String lastName, String nickname, String email, String password, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.role = role;
    }

}
