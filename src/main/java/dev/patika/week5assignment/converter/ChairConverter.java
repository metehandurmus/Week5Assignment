package dev.patika.week5assignment.converter;

import dev.patika.week5assignment.entity.Chair;
import dev.patika.week5assignment.responseDto.ShowChairResponseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ChairConverter {
    private final ModelMapper modelMapper;

    public ShowChairResponseDto ConvertToShowChairResponseDtoByChair(Chair chair) {
        return modelMapper.map(chair, ShowChairResponseDto.class);
    }

    public List<ShowChairResponseDto> ConvertToShowChairResponseDtoListByChairList(List<Chair> chairList) {
        List<ShowChairResponseDto> showChairResponseDtoList = new ArrayList<>();
        for(Chair chair:chairList){
            showChairResponseDtoList.add(ConvertToShowChairResponseDtoByChair(chair));
        }
        return showChairResponseDtoList;
    }
}
