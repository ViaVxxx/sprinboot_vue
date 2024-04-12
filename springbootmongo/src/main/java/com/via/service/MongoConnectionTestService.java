package com.via.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class MongoConnectionTestService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public boolean testConnection() {
        try {
            mongoTemplate.getDb().listCollectionNames();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}