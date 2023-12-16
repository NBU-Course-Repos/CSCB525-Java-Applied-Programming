package com.example.transportcompany;

import com.example.transportcompany.persistence.model.Request;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static File requestsToJson(List<Request> requests) throws IOException {
        File file = new File("target/requests.json");
        mapper.writeValue(file, requests.stream().map(RequestSummary::new));
        return file; //TODO Fix
    }
}
