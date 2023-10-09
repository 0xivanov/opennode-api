package com.example.opennodeapi.models;

import com.example.opennodeapi.models.OpenNodeChargeInfo.Lightning;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
public class OpenNodeChangeInfoList {
    private Data data;
    @lombok.Data
    public static class Data {
        private List<OpenNodeChargeData> items;
    }
    @lombok.Data
    public static class OpenNodeChargeData {
        private String id;
        private String description;
        private int price;
        private OpenNodeChargeStatus status;

        @JsonProperty("created_at")
        private String createdAt;

        private int fee;

        @JsonProperty("fiat_value")
        private int fiatValue;

        private Object notes;

        @JsonProperty("order_id")
        private Object orderId;

        private Object[] onchain;
        private Lightning lightning;
        private Object metadata;
        private String address;
        private boolean exchanged;

        @JsonProperty("net_fiat_value")
        private int netFiatValue;

        @JsonProperty("missing_amt")
        private int missingAmt;

        @JsonProperty("settled_at")
        private Object settledAt;

        @JsonProperty("payment_method")
        private Object paymentMethod;

        private int ttl;

        @JsonProperty("desc_hash")
        private boolean descHash;

        @JsonProperty("hosted_checkout_url")
        private String hostedCheckoutUrl;
    }
}
