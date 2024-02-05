package com.helg893.pp_3_1_2_spring_boot_crud.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    @NotEmpty(message = "поле не должно быть пустым")
    @Size(min = 2, max = 30, message = "длина должна быть от 2 до 30 символов")
    private String name;

    @Column(name = "surname")
    @NotEmpty(message = "поле не должно быть пустым")
    @Size(min = 2, max = 30, message = "длина должна быть от 2 до 30 символов")
    private String surname;

    @Column(name = "email")
    @NotEmpty(message = "поле не должно быть пустым")
    @Email(message = "должен быть корректный адрес e-mail")
    private String email;

    public User() { }
    public User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

}
