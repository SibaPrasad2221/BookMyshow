package com.book_my_show.Book.My.Show.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String screenName;
    @OneToMany() // from hall point of view one hall can have multiple screen
    Hall hall; //we need hall id field in screen entity
    int screenCapacity;
    boolean status;
    String type; //2d screen or 3d screen

}
