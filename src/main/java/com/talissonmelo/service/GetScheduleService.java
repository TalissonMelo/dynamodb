package com.talissonmelo.service;

import com.talissonmelo.entity.Schedule;
import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;

import java.util.List;

@Service
public class GetScheduleService {

    private final DynamoDbTemplate dynamoDbTemplate;

    public GetScheduleService(DynamoDbTemplate dynamoDbTemplate) {
        this.dynamoDbTemplate = dynamoDbTemplate;
    }

    public List<Schedule> execute() {

        var schedules = dynamoDbTemplate.scanAll(Schedule.class);

        return schedules.items().stream().toList();
    }
}
