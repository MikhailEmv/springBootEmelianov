package com.example.springBootEmelianov.beans.payment;

import com.example.springBootEmelianov.beans.taxi.ITaxi;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NonCash {

    @Autowired
    List<ITaxi> availableTaxi;

    @PostConstruct
    public void postConstruct() {
        availableTaxi.forEach(
                e -> System.out.printf("Car %s is available with non-cash payment %n", e.hashCode())
        );
    }
}
