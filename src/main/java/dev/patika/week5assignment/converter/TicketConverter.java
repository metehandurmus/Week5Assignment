package dev.patika.week5assignment.converter;

import dev.patika.week5assignment.entity.Ticket;
import dev.patika.week5assignment.responseDto.ShowTicketResponseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TicketConverter {
    private final ModelMapper modelMapper;

    public ShowTicketResponseDto ConvertToShowTicketResponseDtoByTicket(Ticket ticket) {
        return modelMapper.map(ticket, ShowTicketResponseDto.class);
    }
}
