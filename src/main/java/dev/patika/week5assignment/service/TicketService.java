package dev.patika.week5assignment.service;

import dev.patika.week5assignment.caller.RapidAPIFeignCaller;
import dev.patika.week5assignment.converter.TicketConverter;
import dev.patika.week5assignment.entity.Ticket;
import dev.patika.week5assignment.exception.TicketException;
import dev.patika.week5assignment.repository.ChairRepository;
import dev.patika.week5assignment.repository.TicketRepository;
import dev.patika.week5assignment.requestDto.BuyTicketRequestDto;
import dev.patika.week5assignment.responseDto.ShowTicketResponseDto;
import dev.patika.week5assignment.responseDto.VerifyPhoneResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final RapidAPIFeignCaller rapidAPIFeignCaller;
    private final TicketRepository ticketRepository;
    private final ChairRepository chairRepository;
    private final TicketConverter ticketConverter;

    @Transactional
    public void buy(BuyTicketRequestDto buyTicketRequestDto) {
        if (!validatePhoneNumber(buyTicketRequestDto.phone())) {
            throw new TicketException("Bu telefon numarası hatalı.");
        }
        if (chairRepository.findById(buyTicketRequestDto.chair_id()).isEmpty()) {
            throw new TicketException("Böyle bir koltuk mevcut değil.");
        }
        if (!ticketRepository.findByChairId(buyTicketRequestDto.chair_id()).isEmpty()) {
            throw new TicketException("Bu koltuk zaten dolu.");
        }

        Ticket ticket = new Ticket();
        ticket.setChair(chairRepository.findById(buyTicketRequestDto.chair_id()).get());
        ticketRepository.save(ticket);
    }

    private boolean validatePhoneNumber(String phoneNumber) {
        VerifyPhoneResponseDto verifyPhoneResponseDto = rapidAPIFeignCaller.verifyPhoneNumber("veriphone.p.rapidapi.com", "BURAYA API KEY GIRIN", phoneNumber);

        return verifyPhoneResponseDto.isPhone_valid();
    }

    public ShowTicketResponseDto showTicket(long ticketId) {
        return ticketConverter.ConvertToShowTicketResponseDtoByTicket(ticketRepository.findById(ticketId).get());
    }
}
