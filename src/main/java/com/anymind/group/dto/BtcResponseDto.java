package com.anymind.group.dto;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
public class BtcResponseDto implements Serializable {

    private Long amount;
    private Date date;
}
