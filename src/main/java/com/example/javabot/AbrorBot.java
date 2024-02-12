package com.example.javabot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

/**
 * User:t.me/supermatematikuz
 * Date:09.02.2024 11:10
 */
public class AbrorBot extends TelegramLongPollingBot {

    ArrayList<TelegramUser> telegramUsers = new ArrayList<>();

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update);

        if (update.hasMessage()) {
            Message message = update.getMessage();
            User from = message.getFrom();
            if (message.hasText()) {
                String text = message.getText();
                if (text.equalsIgnoreCase("/start")) {
                    // todo array ichida user bormi yoki yoqmi aniqlash
                    Long id = from.getId();
                    boolean isExist = false;
                    for (TelegramUser telegramUser : telegramUsers) {
                        if (telegramUser.getId().equals(id)) {
                            isExist = true;
                            break;
                        }
                    }
                    //todo array ichida user bo'lmasa saqlaymiz, qo'shamiz
                    if (isExist == false) {
                        TelegramUser telegramUser = new TelegramUser();
                        telegramUser.setId(from.getId());
                        telegramUser.setFirstName(from.getFirstName());
                        String userName = from.getUserName();
                        if (userName != null) {
                            telegramUser.setUsername(userName);
                        }
                        telegramUsers.add(telegramUser);//user qo'shish
                    }

                    SendMessage sendMessage = new SendMessage(
                            update.getMessage().getChatId().toString(),
//                            "6063733584",
                            telegramUsers.toString()
                    );

                    // Create an inline reply keyboard
                    InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

                    // Create a row for the keyboard
                    List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();
                    InlineKeyboardButton button1 = new InlineKeyboardButton();
                    button1.setText("Text 1");
                    button1.setCallbackData("1");
                    keyboardButtonsRow.add(button1);
                    InlineKeyboardButton button2 = new InlineKeyboardButton();
                    button2.setText("Text 2");
                    button2.setCallbackData("2");
                    keyboardButtonsRow.add(button2);

                    InlineKeyboardButton button3 = new InlineKeyboardButton();
                    button3.setText("Text 3");
                    button3.setCallbackData("3");
                    keyboardButtonsRow.add(button3);
                    //
                    List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
                    InlineKeyboardButton button4 = new InlineKeyboardButton();
                    button4.setText("Text 4");
                    button4.setCallbackData("4");
                    keyboardButtonsRow2.add(button4);


                    // Add the row to the keyboard
                    List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
                    rowList.add(keyboardButtonsRow);
                    rowList.add(keyboardButtonsRow2);
                    inlineKeyboardMarkup.setKeyboard(rowList);

                    sendMessage.setReplyMarkup(inlineKeyboardMarkup);
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } else if (update.hasCallbackQuery()) {
            SendMessage sendMessage = new SendMessage(
                    update.getCallbackQuery().getFrom().getId().toString(),
                    update.getCallbackQuery().getData()
            );

            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }

        }


    }

    @Override
    public String getBotUsername() {
        return "@abrortelegram_bot";
    }

    public String getBotToken() {
        return "6907046896:AAE3JBlHyHRk9EFbgUW0316QbrzAbg6v1Lc";
    }
}
