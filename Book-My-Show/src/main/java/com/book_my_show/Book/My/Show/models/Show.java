package com.book_my_show.Book.My.Show.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @ManyToOne
    Hall hall; //one hall could have multiple shows let's see Sarathcity mall has one hall that has many show

    @ManyToOne
    Movie movie;
    int availableTickets;
    Date startTime;
    Date endTime;
    int ticketPrice;

}
