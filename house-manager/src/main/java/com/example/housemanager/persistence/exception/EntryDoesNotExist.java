package com.example.housemanager.persistence.exception;

public class EntryDoesNotExist extends Exception {
    public EntryDoesNotExist(Object entityId, Class type) {
        super(String.format("Entry of type: %s with id: %s does not exist", type.toString(), entityId.toString()));
    }
}
