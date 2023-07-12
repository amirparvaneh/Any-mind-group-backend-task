package com.anymind.group.service;

import com.anymind.group.model.BTC;
import com.anymind.group.repository.BtcRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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
}
