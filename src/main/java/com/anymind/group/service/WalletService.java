package com.anymind.group.service;

import com.anymind.group.dto.BtcResponseDto;
import com.anymind.group.model.BTC;
import com.anymind.group.repository.BtcRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

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

    private List<BtcResponseDto> prepareBtcResponse(List<BTC> btcList){
       return btcList.stream().map(btc -> BtcResponseDto.builder()
                    .amount(btc.getAmount())
                    .date(btc.getDateTime())
                    .build()).toList();
    }

    public void deleteAll(){
        btcRepo.deleteAll();
    }

    private static final Random random = new Random();

    public Date generateRandomDate() {
        Calendar calendar = new GregorianCalendar();

        // Generate random year between 1900 and 2100
        int year = random.nextInt(21) + 2010;
        calendar.set(Calendar.YEAR, year);

        // Generate random day of year
        int dayOfYear = random.nextInt(calendar.getActualMaximum(Calendar.DAY_OF_YEAR)) + 1;
        calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);

        // Get the generated date as a Date object
        return calendar.getTime();
    }
}
