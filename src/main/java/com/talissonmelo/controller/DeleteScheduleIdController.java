package com.talissonmelo.controller;

import com.talissonmelo.service.DeleteScheduleIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteScheduleIdController {

    @Autowired
    private DeleteScheduleIdService service;

    @DeleteMapping("/v1/schedule/{scheduleId}/patients/{patientId}")
    public ResponseEntity<Void> execute(@PathVariable String scheduleId,
                                        @PathVariable String patientId) {

        service.execute(scheduleId, patientId);

        return ResponseEntity.noContent().build();

    }
}
