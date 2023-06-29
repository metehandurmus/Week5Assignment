package dev.patika.week5assignment.responseDto;

import lombok.Data;

@Data
public class FeignExceptionResponseDto {
    private String status;
    private int code;
    private String type;
    private String message;
}
