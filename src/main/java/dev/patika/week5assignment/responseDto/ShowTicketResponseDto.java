package dev.patika.week5assignment.responseDto;

import dev.patika.week5assignment.entity.Chair;
import lombok.Data;

@Data
public class ShowTicketResponseDto {
    private long id;
    private Chair chair;
}
