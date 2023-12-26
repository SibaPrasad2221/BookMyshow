package com.book_my_show.Book.My.Show.controller;

import com.book_my_show.Book.My.Show.dto.request.HallOwner_SignUp_DTO;
import com.book_my_show.Book.My.Show.dto.request.MovieOwner_SignUp_DTO;
import com.book_my_show.Book.My.Show.models.ApplicationUser;
import com.book_my_show.Book.My.Show.service.HallService;
import com.book_my_show.Book.My.Show.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hall")
public class HallController {

    @Autowired
    HallService hallService;

    @PostMapping(value = "/signup_hall", consumes = {"*/*"})
    public ResponseEntity signUp(@RequestBody HallOwner_SignUp_DTO hallOwnerSignUpDto){
        ApplicationUser hallOwner = hallService.signUp(hallOwnerSignUpDto);
        return new ResponseEntity(hallOwner, HttpStatus.CREATED);
    }
}
