package com.talissonmelo.controller.request;

import java.time.LocalDate;
import java.time.LocalTime;

public record ScheduleRequest(String name, LocalDate date, LocalTime startTime, LocalTime endTime) {
}
