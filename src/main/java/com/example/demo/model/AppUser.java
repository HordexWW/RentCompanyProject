package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    @Enumerated(value = EnumType.STRING)
    private Department department;

    @JsonBackReference
    @OneToMany(mappedBy = "sender")
    private List<Message> messages;

}
