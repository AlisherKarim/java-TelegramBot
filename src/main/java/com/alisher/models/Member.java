package com.alisher.models;

import java.util.ArrayList;

import org.bson.Document;
import org.bson.types.ObjectId;

public class Member {
    private ArrayList<ObjectId> taskList;
    private Boolean isOwner;
    private ObjectId id;

    public Member(Boolean isOwner, ArrayList<Task> taskList){
        this.isOwner = isOwner;
        this.id = new ObjectId();
        for(Task t : taskList){
            this.taskList.add(t.getObjectId());
        }
    }

    public ObjectId getId(){
        return id;
    }

    public Document toDocument(){
        return new Document()
            .append("_id", id)
            .append("isOwner", isOwner)
            .append("tasks", taskList);
    }

}

