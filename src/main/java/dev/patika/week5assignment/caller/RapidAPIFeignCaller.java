package dev.patika.week5assignment.caller;

import dev.patika.week5assignment.responseDto.VerifyPhoneResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "rapid", url = "https://veriphone.p.rapidapi.com/")
public interface RapidAPIFeignCaller {
    @GetMapping(value = "/verify")
    VerifyPhoneResponseDto verifyPhoneNumber(@RequestHeader("X-RapidAPI-Host") String apiHost, @RequestHeader("X-RapidAPI-Key") String apiKey, @RequestParam String phone);
}
