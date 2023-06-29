package dev.patika.week5assignment.decoder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.patika.week5assignment.exception.TicketException;
import dev.patika.week5assignment.responseDto.FeignExceptionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FeignErrorDecoder {
    private final ObjectMapper objectMapper;

    public FeignExceptionResponseDto feignExceptionResponseDto(String exceptionContent) {
        try {
            return objectMapper.readValue(exceptionContent, FeignExceptionResponseDto.class);
        } catch (JsonProcessingException e) {
            throw new TicketException("Şu anda tanımlanamayan bir hata oluştu.");
        }
    }
}
