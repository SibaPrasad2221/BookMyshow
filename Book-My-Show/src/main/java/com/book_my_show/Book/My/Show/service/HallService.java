package com.book_my_show.Book.My.Show.service;

import com.book_my_show.Book.My.Show.dto.request.AddScreenDTO;
import com.book_my_show.Book.My.Show.dto.request.HallOwner_SignUp_DTO;
import com.book_my_show.Book.My.Show.exception.ResourceNotExistException;
import com.book_my_show.Book.My.Show.exception.UnAuthorizedException;
import com.book_my_show.Book.My.Show.exception.UserDoesNotExistException;
import com.book_my_show.Book.My.Show.models.ApplicationUser;
import com.book_my_show.Book.My.Show.models.Hall;
import com.book_my_show.Book.My.Show.models.Screen;
import com.book_my_show.Book.My.Show.repository.ApplicationUser_Repo;
import com.book_my_show.Book.My.Show.repository.Hall_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;


@Service
public class HallService {

    @Autowired
    ApplicationUser_Repo applicationUser_repo;

    @Autowired
    RegularUserService regularUserService;

    @Autowired
    Hall_Repo hall_repo;

    @Autowired
    ScreenService screenService;
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

    public Hall getHallById(UUID id){
        return hall_repo.findById(id).orElse(null);
    }


    public void addScreens(AddScreenDTO addScreenDTO, String email){
        List<Screen> screens = addScreenDTO.getScreens();
        UUID hallId = addScreenDTO.getHallId();
        ApplicationUser user = regularUserService.getUserByEmail(email);
        if(user==null){
            throw new UserDoesNotExistException("User with this email doesn't exist");
        }
        if(!user.getType().equals("HallOwner")){ //this is a eg of authorization you are valid user but you are not allowed to perform some action
            throw new UnAuthorizedException("This user is not allowed to perform this task");
        }
        //now check this hall owner owns this hall or not
        Hall hall = getHallById(hallId);
        if(hall == null){
            throw new ResourceNotExistException(String.format("Hall with id %s doesn't exist in system", hallId.toString())); //this hallid is the variable which is passing through postman
        }
        if(hall.getOwner().getId() != user.getId()){
            throw new UnAuthorizedException("User does not own this hall id");
        }


        //the user who reach here that means that's a valid user
        for(Screen screen: screens){
            screen.setHall(hall);
            screenService.registerScreen(screen);
        }
    }

}
