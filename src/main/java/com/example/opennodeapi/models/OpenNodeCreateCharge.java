package com.example.opennodeapi.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Charge Data for creation
 * @author 0xivanov
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpenNodeCreateCharge {

    /**
     * Charge's price in satoshis, unless currency parameter is used.
     */
    private double amount;
    private String description;


    private OpenNodeCurrency currency;

    /**
     * External order ID (use your platform ID)
     */
    @JsonProperty("order_id")
    private String orderId;

    @JsonProperty("customer_email")
    private String customerEmail;

    @JsonProperty("customer_name")
    private String customerName;

    @JsonProperty("fiat_value")
    private double fiatValue;

    @JsonProperty("callback_url")
    private String callbackUrl;

    @JsonProperty("success_url")
    private String successUrl;

    @JsonProperty("auto_settle")
    private boolean autoSettle;
}
