package com.example.javabot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class JavaBotApplication {

    public static void main(String[] args) throws TelegramApiException {
        SpringApplication.run(JavaBotApplication.class, args);
        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(new AbrorBot());
        System.out.println("Bot ishladi");
    }

}
