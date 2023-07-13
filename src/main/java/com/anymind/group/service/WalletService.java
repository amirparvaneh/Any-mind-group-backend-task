package com.anymind.group.service;

import com.anymind.group.dto.BtcResponseDto;
import com.anymind.group.model.BTC;
import com.anymind.group.repository.BtcRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WalletService {

    private final BtcRepo btcRepo;

    public WalletService(BtcRepo btcRepo){
        this.btcRepo = btcRepo;
    }

    public BTC saveBtc(BTC btc){
        return btcRepo.save(btc);
    }

    public List<BTC> getAllBtc(){
        return btcRepo.findAll();
    }

    public List<BtcResponseDto> getBtcByTime(Date startTime, Date endTime){
        List<BTC> allByDateTimeBetween = btcRepo.findAllByDateTimeBetween(startTime, endTime);
        return prepareBtcResponse(allByDateTimeBetween);
    }

    private List<BtcResponseDto> prepareBtcResponse(List<BTC> btcs){
       return btcs.stream().map(btc -> BtcResponseDto.builder()
                    .amount(btc.getAmount())
                    .date(btc.getDateTime())
                    .build()).toList();
    }
}
