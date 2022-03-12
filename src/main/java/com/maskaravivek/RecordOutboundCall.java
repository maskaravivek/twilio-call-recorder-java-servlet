package com.maskaravivek;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;

import java.net.URI;

public class RecordOutboundCall {
    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Call call = Call.creator(
                        new com.twilio.type.PhoneNumber("+1XXXXXXXXXX"),
                        new com.twilio.type.PhoneNumber("+1YYYYYYYYYY"),
                        URI.create("http://localhost:8080/outbound"))
                .setRecord(true).create();

        System.out.println(call.getSid());
    }
}
