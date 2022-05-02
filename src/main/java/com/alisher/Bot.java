package com.alisher;

import java.util.ArrayList;

import com.alisher.models.Member;
import com.alisher.models.Room;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot{

    private DataBase db;

    public Bot(){
        db = new DataBase();
        System.out.println("Database initialized...");
    }

    public void startFunction(Update update){
        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId().toString());
        message.setText("Hello!");

        try{
            MongoCollection<Document> users = db.getCollection("users");
            users.insertOne(new Document()
                .append("_id", new ObjectId())
                .append("isAddingRoom", new Boolean(false))
                .append("isAddingTask", new Boolean(false))
            );

        } catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText() && update.getMessage().getText().equals("/start")){
            startFunction(update);
            return;
        }



        if(update.hasMessage() && update.getMessage().hasText()){

            String text = update.getMessage().getText();

            if(text.equals("/create private")){
                ArrayList<Member> members = new ArrayList<>();

                Member owner = new Member(true, new ArrayList<>());

                Room room = new Room(true, new ArrayList<Member>());




            } else if(text.equals("/create")){
                
            }


            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText(update.getMessage().getText());

            try{
                execute(message);
            } catch(TelegramApiException e){
                e.printStackTrace();
            }
        }
    } 

    @Override
    public String getBotUsername() {
        return "deadlines-bot";
    }

    @Override
    public String getBotToken() {
        return "5390754394:AAHNedsj-bWOPUoGNFpKnJLhl3oQN6fChKI";
    }


}
