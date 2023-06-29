package dev.patika.week5assignment.configuration;

import dev.patika.week5assignment.entity.*;
import dev.patika.week5assignment.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Date;


@Configuration
public class GeneralConfiguration {
    @Autowired
    AirLineRepository airLineRepository;
    @Autowired
    ChairRepository chairRepository;
    @Autowired
    ChairTypeRepository chairTypeRepository;
    @Autowired
    ExpeditionRepository expeditionRepository;
    @Autowired
    ExpeditionTypeRepository expeditionTypeRepository;
    @Autowired
    TicketRepository ticketRepository;

    @PostConstruct
    private void CreateDatasByPostConstruct() {
        AirLine airLine1 = new AirLine();
        airLine1.setName("THY");
        AirLine airLine2 = new AirLine();
        airLine2.setName("Pegasus");
        airLineRepository.save(airLine1);
        airLineRepository.save(airLine2);

        ExpeditionType expeditionType1 = new ExpeditionType();
        expeditionType1.setName("İç Hatlar");
        expeditionTypeRepository.save(expeditionType1);

        ExpeditionType expeditionType2 = new ExpeditionType();
        expeditionType2.setName("Dış Hatlar");
        expeditionTypeRepository.save(expeditionType2);

        Expedition expedition1 = new Expedition();
        expedition1.setExpeditionDate(new Date(123, 5, 30, 18, 20));
        expedition1.setAirLine(airLine1);
        expedition1.setExpeditionType(expeditionType1);
        expeditionRepository.save(expedition1);

        Expedition expedition2 = new Expedition();
        expedition2.setExpeditionDate(new Date(123, 5, 29, 18, 40));
        expedition2.setAirLine(airLine1);
        expedition2.setExpeditionType(expeditionType2);
        expeditionRepository.save(expedition2);

        Expedition expedition3 = new Expedition();
        expedition3.setExpeditionDate(new Date(123, 5, 30, 18, 20));
        expedition3.setAirLine(airLine2);
        expedition3.setExpeditionType(expeditionType1);
        expeditionRepository.save(expedition3);

        Expedition expedition4 = new Expedition();
        expedition4.setExpeditionDate(new Date(123, 5, 29, 18, 40));
        expedition4.setAirLine(airLine2);
        expedition4.setExpeditionType(expeditionType2);
        expeditionRepository.save(expedition4);

        ChairType chairType1 = new ChairType();
        chairType1.setName("ECO");
        chairTypeRepository.save(chairType1);

        ChairType chairType2 = new ChairType();
        chairType2.setName("BUSINESS");
        chairTypeRepository.save(chairType2);

        Chair chair1 = new Chair();
        chair1.setChairType(chairType1);
        chair1.setExpedition(expedition1);
        chair1.setPrice(120.0);
        chairRepository.save(chair1);

        Chair chair2 = new Chair();
        chair2.setChairType(chairType2);
        chair2.setExpedition(expedition1);
        chair2.setPrice(300.0);
        chairRepository.save(chair2);

        Chair chair3 = new Chair();
        chair3.setChairType(chairType2);
        chair3.setExpedition(expedition2);
        chair3.setPrice(300.0);
        chairRepository.save(chair3);

        Chair chair4 = new Chair();


        Ticket ticket = new Ticket();
        ticket.setChair(chair4);
        ticketRepository.save(ticket);

        chair4.setChairType(chairType1);
        chair4.setExpedition(expedition2);
        chair4.setPrice(120.0);
        chairRepository.save(chair4);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
