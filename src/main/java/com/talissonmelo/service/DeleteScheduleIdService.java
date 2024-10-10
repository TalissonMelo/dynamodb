package com.talissonmelo.service;

import com.talissonmelo.entity.Schedule;
import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.enhanced.dynamodb.Key;

@Service
public class DeleteScheduleIdService {

    private final DynamoDbTemplate dynamoDbTemplate;

    public DeleteScheduleIdService(DynamoDbTemplate dynamoDbTemplate) {
        this.dynamoDbTemplate = dynamoDbTemplate;
    }

    public void execute(String id, String patientId) {
        var key = Key.builder()
                .partitionValue(id)
                .sortValue(patientId)
                .build();

        var player = dynamoDbTemplate.load(key, Schedule.class);

        if (player == null) {
            return;
        }

        dynamoDbTemplate.delete(key, Schedule.class);
    }


}
