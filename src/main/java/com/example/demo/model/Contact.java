package com.example.demo.model;


import com.example.demo.model.util.Label;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Data
@ToString
@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String surname;

    private String phone;

    @Enumerated(EnumType.STRING)
    private Label phoneLabel;


    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private Label emailLabel;
}
