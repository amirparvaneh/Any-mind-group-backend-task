package com.anymind.group.repository;

import com.anymind.group.model.BTC;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BtcRepo extends MongoRepository<BTC,Long> {

    List<BTC> findAllByDateTimeBetween(Date startDate,Date endTime);
}
