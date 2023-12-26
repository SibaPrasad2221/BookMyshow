package com.book_my_show.Book.My.Show.service;

import com.book_my_show.Book.My.Show.dto.request.HallOwner_SignUp_DTO;
import com.book_my_show.Book.My.Show.models.ApplicationUser;
import com.book_my_show.Book.My.Show.models.Hall;
import com.book_my_show.Book.My.Show.repository.ApplicationUser_Repo;
import com.book_my_show.Book.My.Show.repository.Hall_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;


@Service
public class HallService {

    @Autowired
    ApplicationUser_Repo applicationUser_repo;

    @Autowired
    Hall_Repo hall_repo;
    public ApplicationUser signUp(HallOwner_SignUp_DTO hallOwnerSignUpDto){

        ApplicationUser hallowner = new ApplicationUser();
        hallowner.setName(hallOwnerSignUpDto.getName());
        hallowner.setEmail(hallOwnerSignUpDto.getEmail());
        hallowner.setPassword(hallOwnerSignUpDto.getPassword());
        hallowner.setType(hallOwnerSignUpDto.getType().toString());
        hallowner.setPhoneNumber(hallOwnerSignUpDto.getPhoneNumber());
        hallowner.setAge(hallOwnerSignUpDto.getCompanyAge());
        List<Hall> halls = hallOwnerSignUpDto.getHalls();
//        System.out.println(hallowner.getId());
        applicationUser_repo.save(hallowner);
//        System.out.println(hallowner.getId());
//        Logger.getLogger(hallowner.getName());
        for(Hall hall: halls){
            hall.setOwner(hallowner);
            hall_repo.save(hall);
        }

        return hallowner;
    }
}
