package com.book_my_show.Book.My.Show.service;


import com.book_my_show.Book.My.Show.models.Show_ent;
import com.book_my_show.Book.My.Show.repository.Show_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowService {
    @Autowired
    Show_Repo showRepo;

    public void createShow(Show_ent show){
        showRepo.save(show);
    }
}
