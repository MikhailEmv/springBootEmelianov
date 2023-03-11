package com.example.springBootEmelianov.beans.taxi;

import com.example.springBootEmelianov.beans.user.User;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Primary
@Component
@FieldDefaults(level = AccessLevel.PROTECTED)
public class EcoTaxi implements ITaxi {

    @NonNull
    private User user;

    Boolean inStock = true;

    @Autowired
    public void setUser(@Qualifier(value = "insolventUser") User user) {
        this.user = user;
    }

    public EcoTaxi() {
        user = null;
    }

    @Override
    @PostConstruct
    public void postConstruct() {
        user.pay();
        System.out.printf("User of eco-class has paid for the trip: %s%n", user.getIsReadyToPay());
        System.out.println(user.getState());
    }

    @Override
    @PreDestroy
    public void preDestroy() {
        user.finish();
        System.out.printf("User of eco-class has finished the trip: %s%n", user.getIsReadyToPay());
        System.out.println(user.getState());
    }
}
