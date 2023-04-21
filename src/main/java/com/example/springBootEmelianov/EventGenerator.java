package com.example.springBootEmelianov;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventGenerator implements CommandLineRunner {

    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void run(String... args) {
        eventPublisher.publishEvent(new SpringBootEmelianovApplication.MyEvent(this, "normal"));
        eventPublisher.publishEvent(new SpringBootEmelianovApplication.MyEvent(this, "async"));
        eventPublisher.publishEvent(new SpringBootEmelianovApplication.MyEvent(this, "success"));
        eventPublisher.publishEvent(new SpringBootEmelianovApplication.MyEvent(this, "fail"));
    }
}
