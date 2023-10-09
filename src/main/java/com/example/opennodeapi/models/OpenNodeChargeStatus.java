package com.example.opennodeapi.models;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Status of a charge
 * @author 0xivanov
 *
 */
public enum OpenNodeChargeStatus {

    @JsonProperty("paid")
    PAID,
    
    @JsonProperty("unpaid")
    UNPAID,
    
    @JsonProperty("pending")
    PENDING;
}
