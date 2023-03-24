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
@Table(name = "Users")
// TODO: 23.03.2023 dodać implement UserDetails
public class AppUser {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "FirstName")
    @Nonnull
    private String firstName;
    @Column(name = "LastName")
    @Nonnull
    private String lastName;
    @Column(name = "NickName")
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
}
