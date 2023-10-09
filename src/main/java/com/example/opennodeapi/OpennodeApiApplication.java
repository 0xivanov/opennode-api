package com.example.opennodeapi;

import com.example.opennodeapi.models.OpenNodeChargeInfo;
import com.example.opennodeapi.models.OpenNodeChargeResponse;
import com.example.opennodeapi.models.OpenNodeCreateCharge;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OpennodeApiApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OpennodeApiApplication.class, args);

        OpenNodeService openNodeService = context.getBean(OpenNodeService.class);

        createCharge(openNodeService);
        //getCharge(openNodeService, "aef7cc29-ccf9-404e-a2ca-64edc273bba9");
        //listCharges(openNodeService);
    }

    private static void createCharge(OpenNodeService openNodeService) {
        OpenNodeCreateCharge charge = OpenNodeCreateCharge.builder().amount(1).build();

        OpenNodeChargeResponse createdCharge = openNodeService.createCharge(charge);
        System.out.println("Created Charge: " + createdCharge);
    }

    private static void getCharge(OpenNodeService openNodeService, String chargeId) {
        OpenNodeChargeInfo chargeInfo = openNodeService.getCharge(chargeId);
        System.out.println("Charge Info: " + chargeInfo);
    }

    private static void listCharges(OpenNodeService openNodeService) {
        var chargeList = openNodeService.listPaidCharges();
        System.out.println("Charge List: " + chargeList);
    }
}
