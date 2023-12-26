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
public class Ticket {
    @Id //to mark this column as prim key
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @ManyToOne
    ApplicationUser user;

    @ManyToOne
    Movie movie;

    @ManyToOne //as multiple tickets are there for one hall
    Hall hall;

    @ManyToOne //many people tickets can have one same show
    Show_ent show;
}

