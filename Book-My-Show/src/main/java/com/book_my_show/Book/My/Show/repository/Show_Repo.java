package com.book_my_show.Book.My.Show.repository;

import com.book_my_show.Book.My.Show.models.Show_ent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface Show_Repo extends JpaRepository<Show_ent, UUID> {

    @Query(value = "select * from show_ent where movie_id =:id", nativeQuery = true)
    public List<Show_ent> getShowBymovieId(UUID id);
}
