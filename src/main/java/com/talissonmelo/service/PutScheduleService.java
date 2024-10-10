package com.talissonmelo.service;

import com.talissonmelo.controller.request.ScheduleRequest;
import com.talissonmelo.entity.Schedule;
import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;

@Service
public class PutScheduleService {

    private final DynamoDbTemplate dynamoDbTemplate;

    public PutScheduleService(DynamoDbTemplate dynamoDbTemplate) {
        this.dynamoDbTemplate = dynamoDbTemplate;
    }

    public void execute(String id, String patientId, ScheduleRequest request) {

        var key = Key.builder()
                .partitionValue(id)
                .sortValue(patientId)
                .build();

        var schedule = dynamoDbTemplate.load(key, Schedule.class);

        if (schedule == null) {
            return;
        }

        schedule.setName(request.name());
        schedule.setDate(request.date());
        schedule.setStartTime(request.startTime());
        schedule.setEndTime(request.endTime());

        dynamoDbTemplate.save(schedule);
    }

}
