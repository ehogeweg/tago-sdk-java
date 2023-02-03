package com.tagoio.sdk.tago;

import com.tagoio.sdk.services.Console;

public interface Listener {

    public abstract void call(Object object, Console console);

}
