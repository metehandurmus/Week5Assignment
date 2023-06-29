package dev.patika.week5assignment.service;

import dev.patika.week5assignment.converter.ExpeditionConverter;
import dev.patika.week5assignment.entity.Expedition;
import dev.patika.week5assignment.exception.ExpeditionException;
import dev.patika.week5assignment.repository.ExpeditionRepository;
import dev.patika.week5assignment.responseDto.GetAllExpeditionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpeditionService {
    private final ExpeditionRepository expeditionRepository;
    private final ExpeditionConverter expeditionConverter;

    public List<GetAllExpeditionResponseDto> getAllExpeditionResponseDtoList(String expeditionTypeId, String airLine) {
        List<Expedition> expeditionList;
        expeditionList = (List<Expedition>) expeditionRepository.findAll();

        if (expeditionTypeId.length() > 0) {
            try {
                Long typeId = Long.valueOf(expeditionTypeId);
                expeditionList = expeditionList
                        .stream()
                        .filter(expedition -> expedition.getExpeditionType().getId() == typeId)
                        .toList();

            } catch (Exception e) {
                throw new ExpeditionException("Lütfen doğru bir sefer tipi girin.");
            }
        }

        if (airLine.length() > 0) {
            try {
                Long airlineId = Long.valueOf(airLine);
                expeditionList = expeditionList
                        .stream()
                        .filter(expedition -> expedition.getAirLine().getId() == airlineId)
                        .toList();

            } catch (Exception e) {
                throw new ExpeditionException("Lütfen doğru bir hava yolu tipi girin.");
            }
        }

        return expeditionConverter.ConvertToGetAllExpeditionResponseDtoByExpedition(expeditionList);
    }
}
