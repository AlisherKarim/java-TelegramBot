package com.alisher.models;

import org.bson.Document;
import org.bson.types.ObjectId;

public class Task {
    private Boolean isNumerical;
    private Boolean done;
    private Integer value;
    private ObjectId id;


    public Task(){
        id = new ObjectId();
        this.isNumerical = false;
        this.done = false;
    }

    public Task(Integer x){
        id = new ObjectId();
        this.isNumerical = true;
        this.value = x;
    }

    public ObjectId getObjectId(){
        return id;
    }

    public Integer getValue(){
        return this.value;
    }

    public void setValue(Integer x){
        if(!this.isNumerical){
            this.isNumerical = true;
        }
        this.value = x;
    }

    public Boolean isDone(){
        return this.done;
    }

    public void setDone(Boolean b){
        this.done = b;
    }

    public Document toDocument(){
        return new Document().append("_id", id)
            .append("isNumerical", isNumerical)
            .append("done", done)
            .append("value", value);
    }
}
