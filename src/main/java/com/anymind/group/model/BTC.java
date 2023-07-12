package com.anymind.group.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("BTC")
@Data
@Builder
@AllArgsConstructor
public class BTC {

    @Id
    private Long id;
    @Indexed(unique = true)
    private String btc;
    private Date dateTime;
    private Long amount;
}
