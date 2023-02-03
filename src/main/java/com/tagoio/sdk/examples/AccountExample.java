package com.tagoio.sdk.examples;

import com.tagoio.sdk.model.Account;
import java.util.Map;
import com.github.nkzawa.emitter.Emitter;
import com.tagoio.sdk.domain.Result;

public class AccountExample {

    public static void main(String[] args) {
        Account myacc = new Account("e6cd5a0f-3a7c-46d9-9e2b-84f4d2a4e698");

        Result accinfo = myacc.info();
        Map<String, String> map = (Map<String, String>) accinfo.result;
        System.out.println("Company: " + map.get("company"));
        // accinfo.result.get("company")
        Object data = new Object() {
            public String name = "OpenSource Test";
        };

        Result deviceCreate = myacc.device.create(data);

        Emitter.Listener listener = new Emitter.Listener() {
            @Override
            public void call(Object... info) {
                System.out.println(info);
            }
        };

        // myacc.dashboard.listening(listener, "556388ea791aa76a07f0ba43");
    }

}
