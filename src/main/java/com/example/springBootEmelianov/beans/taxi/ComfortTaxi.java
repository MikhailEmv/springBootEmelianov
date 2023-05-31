package com.example.springBootEmelianov.beans.taxi;

import com.example.springBootEmelianov.beans.user.User;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@FieldDefaults(level = AccessLevel.PROTECTED)
public class ComfortTaxi implements ITaxi {

    @Autowired
    @Qualifier(value = "insolventUser")
    private User user;

    Boolean inStock = true;

    public ComfortTaxi() {}

    @Override
    @PostConstruct
    public void postConstruct() {
        user.pay();
        System.out.printf("User of comfort-class has paid for the trip: %s%n", user.getIsReadyToPay());
        System.out.println(user.getState());
    }

    @Override
    @PreDestroy
    public void preDestroy() {
        user.finish();
        System.out.printf("User of comfort-class has finished the trip: %s%n", user.getIsReadyToPay());
        System.out.println(user.getState());
    }
}
