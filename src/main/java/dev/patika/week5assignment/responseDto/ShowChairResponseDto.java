package dev.patika.week5assignment.responseDto;

import dev.patika.week5assignment.entity.ChairType;
import lombok.Data;

@Data
public class ShowChairResponseDto {
    private long id;
    private ChairType chairType;
    private double price;
}
