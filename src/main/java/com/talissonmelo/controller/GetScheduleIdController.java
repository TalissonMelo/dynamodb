package com.talissonmelo.controller;

import com.talissonmelo.entity.Schedule;
import com.talissonmelo.service.DeleteScheduleIdService;
import com.talissonmelo.service.GetScheduleIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetScheduleIdController {

    @Autowired
    private GetScheduleIdService service;

    @GetMapping("/v1/schedule/{scheduleId}")
    public ResponseEntity<List<Schedule>> execute(@PathVariable String scheduleId) {

        List<Schedule> schedules = service.execute(scheduleId);

        return ResponseEntity.status(200).body(schedules);

    }
}
