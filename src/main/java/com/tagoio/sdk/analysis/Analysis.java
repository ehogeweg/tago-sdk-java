package com.tagoio.sdk.analysis;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.tagoio.sdk.model.TagoModel;
import com.tagoio.sdk.services.Console;
import com.tagoio.sdk.services.Email;
import com.tagoio.sdk.services.Sms;
import com.tagoio.sdk.tago.Listener;

import java.net.URISyntaxException;

public class Analysis extends TagoModel {

    public Sms sms;
    public Email email;
    public com.tagoio.sdk.services.Socket socket;
    public Console console;

    Analysis analysis;

    public Analysis() {
        super("");
        initClasses(token);
    }

    public Analysis(String token) {
        super(token);
        initClasses(token);
    }

    public Analysis(Analysis analysis, String token) {
        super(token);
        this.analysis = analysis;
        initClasses(token);
    }

    private void initClasses(String token) {
        sms = new Sms(token);
        email = new Email(token);
        socket = new com.tagoio.sdk.services.Socket(token);
        console = new Console(token);
    }

    private Socket socketIo;

    public void listening(final Listener listener, final String token) {
        if (this.socketIo == null || !this.socketIo.connected()) {
            try {
                this.socketIo = IO.socket(config.realtime_url);

                socketIo.on("run:analysis", new Emitter.Listener() {
                    @Override
                    public void call(Object... os) {
                        Console console = new Console(token);
                        if (listener != null) {
                            listener.call(os, console);
                        }
                    }
                });

                socketIo.on("connect", new Emitter.Listener() {

                    @Override
                    public void call(Object... os) {
                        socketIo.emit("register:analysis", token);
                    }
                });

                socketIo.connect();
            } catch (URISyntaxException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void stopListening(String analysisId) {
        if (this.socketIo != null || this.socketIo.connected()) {
            this.socketIo.off(analysisId);
        }
    }
}
