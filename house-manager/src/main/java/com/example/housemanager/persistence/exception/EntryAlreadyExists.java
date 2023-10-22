package com.example.housemanager.persistence.exception;

import com.sun.jdi.ClassType;

public class EntryAlreadyExists extends Exception {

    public EntryAlreadyExists(Object entityId, Class type) {
        super(String.format("Entry of type: %s with id: %s already exists", type.toString(), entityId.toString()));
    }
}
