package com.talissonmelo.controller;

import com.talissonmelo.entity.Schedule;
import com.talissonmelo.service.GetScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetScheduleController {

    @Autowired
    private GetScheduleService service;

    @GetMapping("/v1/schedule")
    public ResponseEntity<List<Schedule>> execute() {

        List<Schedule> response = service.execute();

        return ResponseEntity.status(200).body(response);

    }
}
