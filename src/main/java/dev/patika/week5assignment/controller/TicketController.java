package dev.patika.week5assignment.controller;

import dev.patika.week5assignment.requestDto.BuyTicketRequestDto;
import dev.patika.week5assignment.responseDto.ShowTicketResponseDto;
import dev.patika.week5assignment.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/ticket")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    @PostMapping("/buy")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@Valid @RequestBody BuyTicketRequestDto buyTicketRequestDto) {
        ticketService.buy(buyTicketRequestDto);
    }

    @GetMapping("/show")
    public ShowTicketResponseDto show(@RequestParam long ticket_id) {
        return ticketService.showTicket(ticket_id);
    }
}
