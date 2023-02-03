package com.tagoio.sdk.examples;

import com.tagoio.sdk.domain.Result;
import com.tagoio.sdk.model.Device;

public class DeviceExample {

    public static void main(String[] args) {
        Device mydevice = new Device("44e50244-1985-4c15-8ec0-5855c474aeb0");

        Object myData = new Object() {
            public String variable = "Java";
            public Integer value = 11;
        };

        Result insertResul = mydevice.insert(myData);

        Object filter = new Object() {
            public String query = "count";
        };

        Result findResult = mydevice.find(filter);

        String a = "";
    }

}
