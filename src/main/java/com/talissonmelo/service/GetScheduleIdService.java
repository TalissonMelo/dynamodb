package com.talissonmelo.service;

import com.talissonmelo.entity.Schedule;
import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;

import java.util.List;

@Service
public class GetScheduleIdService {

    private final DynamoDbTemplate dynamoDbTemplate;

    public GetScheduleIdService(DynamoDbTemplate dynamoDbTemplate) {
        this.dynamoDbTemplate = dynamoDbTemplate;
    }

    public List<Schedule> execute(String id) {

        var key = Key.builder().partitionValue(id).build();

        var conditional = QueryConditional.keyEqualTo(key);

        var schedules = dynamoDbTemplate.query(QueryEnhancedRequest.builder()
                        .queryConditional(conditional).build(),
                Schedule.class);

        return schedules.items().stream().toList();

    }
}
