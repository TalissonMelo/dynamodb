package com.talissonmelo.service;

import com.talissonmelo.controller.request.ScheduleRequest;
import com.talissonmelo.entity.Schedule;
import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PostScheduleService {

    private final DynamoDbTemplate dynamoDbTemplate;

    public PostScheduleService(DynamoDbTemplate dynamoDbTemplate) {
        this.dynamoDbTemplate = dynamoDbTemplate;
    }

    public void execute(ScheduleRequest request) {

        Schedule schedule = Schedule.to(UUID.randomUUID(), request);
        dynamoDbTemplate.save(schedule);

    }
}
