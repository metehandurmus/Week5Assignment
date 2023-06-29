package dev.patika.week5assignment.responseDto;

import dev.patika.week5assignment.entity.AirLine;
import dev.patika.week5assignment.entity.ExpeditionType;

import lombok.Data;

import java.util.Date;

@Data
public class GetAllExpeditionResponseDto {
    private long id;
    private ExpeditionType expeditionType;
    private AirLine airLine;
    private Date expeditionDate;
}
