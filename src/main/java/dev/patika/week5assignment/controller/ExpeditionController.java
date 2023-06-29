package dev.patika.week5assignment.controller;

import dev.patika.week5assignment.responseDto.GetAllExpeditionResponseDto;
import dev.patika.week5assignment.service.ExpeditionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/expedition")
@RequiredArgsConstructor
public class ExpeditionController {
    private final ExpeditionService expeditionService;

    @GetMapping("/show")
    public List<GetAllExpeditionResponseDto> getAllExpeditionResponseDtoList(
            @RequestParam(name = "expedition_type", defaultValue = "") String expeditionTypeId,
            @RequestParam(name = "airline", defaultValue = "") String airLine) {
        return expeditionService.getAllExpeditionResponseDtoList(expeditionTypeId, airLine);
    }
}
