package com.example.opennodeapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response when creating charge
 * @author 0xivanov
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpenNodeChargeResponse {
    private Data data;

    @lombok.Data
    public static class Data {
        private String id;
        private String description;
        @JsonProperty("desc_hash")
        private boolean descHash;
        @JsonProperty("created_at")
        private long createdAt;
        private OpenNodeChargeStatus status;
        private int amount;
        @JsonProperty("callback_url")
        private String callbackUrl;
        @JsonProperty("success_url")
        private String successUrl;
        @JsonProperty("hosted_checkout_url")
        private String hostedCheckoutUrl;
        @JsonProperty("order_id")
        private String orderId;
        private OpenNodeCurrency currency;
        @JsonProperty("source_fiat_value")
        private int sourceFiatValue;
        @JsonProperty("fiat_value")
        private int fiatValue;
        @JsonProperty("auto_settle")
        private boolean autoSettle;
        @JsonProperty("notif_email")
        private String notifEmail;
        private String address;
        private ChainInvoice chainInvoice;
        private String uri;
        private int ttl;
        private LightningInvoice lightningInvoice;
    }

    @lombok.Data
    public static class ChainInvoice {
        private String address;
    }

    @lombok.Data
    public static class LightningInvoice {
        @JsonProperty("expires_at")
        private long expiresAt;
        private String payreq;
    }
}
