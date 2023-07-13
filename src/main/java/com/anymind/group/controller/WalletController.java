package com.anymind.group.controller;


import com.anymind.group.dto.BtcNewRequestDto;
import com.anymind.group.dto.BtcResponseDto;
import com.anymind.group.model.BTC;
import com.anymind.group.service.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/wallet")
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping
    public ResponseEntity<String> saveBtc(@RequestParam BtcNewRequestDto btcNewRequestDto){
        BTC btc = BTC.builder()
                .amount(btcNewRequestDto.getAmount())
                .dateTime(btcNewRequestDto.getDateTime())
                .build();
        walletService.saveBtc(btc);
        return ResponseEntity.ok("saved!");
    }

    @GetMapping(value = "/history")
    public ResponseEntity<List<BtcResponseDto>> getWalletHistory(@RequestParam Date startDateTime,
                                                           @RequestParam Date endDateTime){
        List<BtcResponseDto> btcListByTime = walletService.getBtcByTime(startDateTime, endDateTime);
        return ResponseEntity.ok(btcListByTime);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<BTC>> getAllBtc(){
        List<BTC> allBtc = walletService.getAllBtc();
        return ResponseEntity.ok(allBtc);
    }
}
