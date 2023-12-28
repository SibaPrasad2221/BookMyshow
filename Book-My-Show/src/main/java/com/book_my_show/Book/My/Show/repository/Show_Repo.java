package com.book_my_show.Book.My.Show.repository;

import com.book_my_show.Book.My.Show.models.Show_ent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface Show_Repo extends JpaRepository<Show_ent, UUID> {

}
