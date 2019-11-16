package com.arpax.ARPA.mapper;

import com.arpax.ARPA.dto.StockDto;
import com.arpax.ARPA.model.Stock;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class StockDTOMapper {

    public static List<StockDto> mapper(List<Stock> stockList, Map<Integer,Integer> randomPrices){
        List<StockDto> stockDtos = new ArrayList<StockDto>();
         stockList.forEach(ls->{
           StockDto stockDto = new StockDto(ls);
           if(randomPrices.containsKey(ls.getId())){
               stockDto.setPrice(randomPrices.get(ls.getId()));;
           }
             stockDtos.add(stockDto);
       });
    return stockDtos;
    }
}
