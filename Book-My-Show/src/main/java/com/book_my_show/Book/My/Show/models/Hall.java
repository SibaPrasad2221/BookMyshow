package com.book_my_show.Book.My.Show.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String name;
    String address;
    @Column(unique = true)
    String email;
    String password;
    long contactNumber;

    @OneToMany(mappedBy = "hall")
    List<Screen> screen; //because particular hall have multiple screen

    @ManyToOne(mappedBy="hal")
    List<Show> shows;
}
