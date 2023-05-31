package com.example.springBootEmelianov.beans.taxi;

import com.example.springBootEmelianov.beans.user.User;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@FieldDefaults(level = AccessLevel.PROTECTED)
@Component
public class ComfortPlusTaxi implements ITaxi {

    @NonNull
    private final User user;

    Boolean inStock = true;

    public ComfortPlusTaxi(@Qualifier(value = "solventUser") User user) {
        this.user = user;
    }

    @Override
    @PostConstruct
    public void postConstruct() {
        user.pay();
        System.out.printf("User of comfortPlus-class has paid for the trip: %s%n", user.getIsReadyToPay());
        System.out.println(user.getState());
    }

    @Override
    @PreDestroy
    public void preDestroy() {
        user.finish();
        System.out.printf("User of comfortPlus-class has finished the trip: %s%n", user.getIsReadyToPay());
        System.out.println(user.getState());
    }
}
