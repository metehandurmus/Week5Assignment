package dev.patika.week5assignment.responseDto;

import lombok.Data;

@Data
public class VerifyPhoneResponseDto {
    private String phone;
    private String country;
    private String country_prefix;
    private boolean phone_valid;
}