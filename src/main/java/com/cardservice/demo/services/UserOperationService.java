package com.cardservice.demo.services;


import com.cardservice.demo.interfaces.EntityOperationService;
import com.cardservice.demo.models.Card;
import com.cardservice.demo.models.User;
import com.cardservice.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserOperationService implements EntityOperationService<User> {

    @Autowired
    private UserRepository userRepository;


    @Override
    public boolean add(User entity) {
        User temp = userRepository.save(entity);
        return temp != null;
    }

    @Override
    public boolean addAll(Iterable<User> entities) {
        Iterable<User> temp = userRepository.saveAll(entities);
        return temp != null;
    }

    @Override
    public void delete(User entity) {
        // todo

        Integer result  = 100;
        try {
            userRepository.delete(entity);
        }
        catch (Exception e){
            result = 120;
            e.printStackTrace();
        }

    }

    @Override
    public void deleteAll(Iterable<User> entities) {
        // todo

        Integer result  = 100;
        try {
            userRepository.deleteAll(entities);
        }
        catch (Exception e){
            result = 120;
            e.printStackTrace();
        }


    }

    @Override
    public Boolean update(User entity, User value) {
        // todo

        Integer result  = 100;
        try {
            entity.overwrite(value);
        }
        catch (Exception e){
            result = 120;
            e.printStackTrace();

        }

        return true;
    }


    public User findUserByCard(String card){

        return userRepository.findUserByCardsContains(card);
    }

    public  User findUserByPhone(String phone){
        return userRepository.findUserByPhoneNumber(phone);
    }



}
