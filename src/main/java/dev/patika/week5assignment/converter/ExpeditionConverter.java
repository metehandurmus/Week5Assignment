package dev.patika.week5assignment.converter;

import dev.patika.week5assignment.entity.Expedition;
import dev.patika.week5assignment.responseDto.GetAllExpeditionResponseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ExpeditionConverter {
    private final ModelMapper modelMapper;

    public List<GetAllExpeditionResponseDto> ConvertToGetAllExpeditionResponseDtoByExpedition(List<Expedition> expeditionList) {
        List<GetAllExpeditionResponseDto> getAllExpeditionResponseDtoList = new ArrayList<>();
        for (Expedition expedition:expeditionList) {
            getAllExpeditionResponseDtoList.add(modelMapper.map(expedition, GetAllExpeditionResponseDto.class));
        }
        return getAllExpeditionResponseDtoList;
    }
}