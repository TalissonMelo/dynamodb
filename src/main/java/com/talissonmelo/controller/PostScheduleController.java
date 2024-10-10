package com.talissonmelo.controller;

import com.talissonmelo.controller.request.ScheduleRequest;
import com.talissonmelo.service.PostScheduleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostScheduleController {

    @Autowired
    private PostScheduleService service;

    @PostMapping("/v1/schedule")
    public ResponseEntity<Void> execute(@Valid @RequestBody ScheduleRequest request) {

        service.execute(request);

        return ResponseEntity.status(201).body(null);

    }
}
