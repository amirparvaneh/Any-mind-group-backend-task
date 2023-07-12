package com.anymind.group.repository;

import com.anymind.group.model.BTC;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BtcRepo extends MongoRepository<BTC,Long> {
}
