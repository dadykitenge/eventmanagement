package com.kumojin.eventmanagement.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kumojin.eventmanagement.constants.Constant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min = 2, max = 32)
    @NotBlank(message = "Please add the event name!")
    private String eventName;
    private String eventDescription;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = Constant.LOCAL_DATE_TIME_FORMAT)
    private LocalDateTime startDate;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = Constant.LOCAL_DATE_TIME_FORMAT)
    private LocalDateTime endDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private ZoneOffset zoneOffset;

}
