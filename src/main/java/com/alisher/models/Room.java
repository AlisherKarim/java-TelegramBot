package com.alisher.models;

import java.util.ArrayList;
import java.util.Random;

import org.bson.Document;
import org.bson.types.ObjectId;

public class Room {
    private Boolean isPrivate;
    private String roomId; // for users
    private ObjectId id;
    private ArrayList<ObjectId> members;


    public Room(Boolean isPrivate, ArrayList<Member> memberList){
        this.isPrivate = isPrivate;
        this.id = new ObjectId();
        roomId = generateRoomId();
        for(Member m : memberList){
            this.members.add(m.getId());
        }
    }

    private String generateRoomId(){
        int left = 97;
        int right = 122;
        int size = 6;
        String randomString = new String();

        for(int i = 0; i < size; i++){
            Random random = new Random();
            int current = random.nextInt(right + 1 - left) + left;
            randomString = randomString + ((char) 'a' + current);
        }

        return randomString;
    }

    public Document toDocument(){
        return new Document()
            .append("_id", id)
            .append("isPrivate", isPrivate)
            .append("roomId", roomId)
            .append("members", members);
    }

}
