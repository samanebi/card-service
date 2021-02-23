package com.cardservice.demo.repository;

import com.cardservice.demo.models.Card;
import com.cardservice.demo.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface UserRepository extends CrudRepository<User , Long> {

    User findUserByCardsContains(String card);

}
