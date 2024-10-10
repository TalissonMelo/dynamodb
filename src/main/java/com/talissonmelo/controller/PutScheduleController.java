package com.talissonmelo.controller;

import com.talissonmelo.controller.request.ScheduleRequest;
import com.talissonmelo.service.PutScheduleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PutScheduleController {

    @Autowired
    private PutScheduleService service;

    @PutMapping("/v1/schedule/{scheduleId}/patients/{patientId}")
    public ResponseEntity<Void> execute(@PathVariable String scheduleId,
                                        @PathVariable String patientId,
                                        @Valid @RequestBody ScheduleRequest request) {

        service.execute(scheduleId, patientId, request);

        return ResponseEntity.status(200).body(null);

    }
}
