package com.talissonmelo.entity;

import com.talissonmelo.controller.request.ScheduleRequest;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@DynamoDbBean
public class Schedule {


    private String id;

    private String name;

    private UUID patientId;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    private Instant createdAt;

    private Schedule(UUID patientId, String name, LocalDate date, LocalTime startTime, LocalTime endTime) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.date = date;
        this.endTime = endTime;
        this.patientId = patientId;
        this.startTime = startTime;
        this.setCreatedAt(Instant.now());
    }


    public static Schedule to(UUID patientId, ScheduleRequest request) {
        return new Schedule(patientId, request.name(), request.date(), request.startTime(), request.endTime());
    }

    @DynamoDbPartitionKey
    @DynamoDbAttribute("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDbAttribute("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DynamoDbSortKey
    @DynamoDbAttribute("patient_id")
    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    @DynamoDbAttribute("date")
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @DynamoDbAttribute("start_time")
    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    @DynamoDbAttribute("end_time")
    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }


    @DynamoDbAttribute("created_at")
    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
