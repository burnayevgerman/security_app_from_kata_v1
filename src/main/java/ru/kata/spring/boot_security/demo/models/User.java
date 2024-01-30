package ru.kata.spring.boot_security.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    public enum Gender {
        MALE("Male"),
        FEMALE("Female"),
        NOT_DEFINED("Not Defined");

        private final String text;

        Gender(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;
    private String name;

    @Column(columnDefinition = "ENUM('MALE', 'FEMALE', 'NOT_DEFINED')")
    @Enumerated(EnumType.STRING)
    private Gender gender = Gender.NOT_DEFINED;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    private String role;

    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
}
