package com.example.springBootEmelianov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootApplication
public class SpringBootEmelianovApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEmelianovApplication.class, args);
    }

    @EventListener
    public void handleNormalEvent(MyEvent event) {
        log("Normal Event Listener handling event: " + event.getMessage());
    }

    @Async
    @EventListener
    public void handleAsyncEvent(MyEvent event) {
        log("Async Event Listener handling event: " + event.getMessage());
    }

    @Transactional
    @EventListener
    public void handleTransactionalEvent(MyEvent event) {
        log("Transactional Event Listener handling event: " + event.getMessage());
        if (event.getMessage().equals("fail")) {
            throw new RuntimeException("Event failed");
        }
    }

    @EventListener
    public void handleAnotherTransactionalEvent(MyEvent event) {
        log("Another Transactional Event Listener handling event: " + event.getMessage());
    }

    public static class MyEvent extends ApplicationEvent {

        private final String message;

        public MyEvent(Object source, String message) {
            super(source);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    private static void log(String message) {
        System.out.println(LocalDateTime.now() + " - " + message);
    }
}
