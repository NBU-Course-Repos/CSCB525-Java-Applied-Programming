package com.example.transportcompany.service;

import com.example.transportcompany.model.Request;
import com.example.transportcompany.repository.RequestRepository;
import org.springframework.stereotype.Service;

@Service
public class RequestService extends AbstractService<Request, Long, RequestRepository> {
    @Override
    Long getId(Request entity) {
        return entity.getRequestId();
    }
}
