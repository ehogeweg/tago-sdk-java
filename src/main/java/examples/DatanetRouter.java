package examples;

import java.net.*;
import java.io.*;

// import org.json.JSONObject;

// import { Network, Device } from "@tago-io/sdk";
// import model.Device;
// import * as net from "net";
import model.Network;

public class DatanetRouter {

    static final int PORT = 3001;

    Network network = new Network("e65d739f-7a12-4a87-b15c-4ed60594c902");

    // initialize socket and input stream
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;

    // constructor with port
    public DatanetRouter(int port) {
        // starts server and waits for a connection
        try {
            server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            socket = server.accept();
            System.out.println("Client accepted");

            // takes input from the client socket
            in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));

            String line = "";

            int sync1 = in.read();
            int sync2 = in.read();
            int msgType = in.read();
            short payloadLength = in.readShort();
            byte[] data = new byte[payloadLength];
            in.read(data);

            dataReceived(null);
            // ...
            socket.write(new HelloResponse().getBytes());

            // reads message from client until "Over" is sent
            // while (!line.equals("Over")) {
            // try {
            // line = in.readUTF();
            // System.out.println(line);

            // } catch (IOException i) {
            // System.out.println(i);
            // }
            // }
            System.out.println("Closing connection");

            // close connection
            socket.close();
            in.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    void dataReceived(byte[] msg) {
        // // try {
        // const data = parsePayload(msg);
        // console.info("data ", data);
        // const serial_var = data.find((e) => e.variable == "serial");
        // if (serial_var) {
        // const serial = serial_var.value.toString();

        // const token = await network.resolveToken(serial).catch(() => null);
        // if (!token) {
        // return console.log(`Token not found, serie: ${serial}`);
        // }

        // const device = new Device({ token });
        // device.sendData(data).then(console.log, console.log);
        // }
        // // } catch (error) {
        // // console.log(error);
        // // }
    }

    public static void main(String args[]) {
        DatanetRouter server = new DatanetRouter(PORT);
    }

    JSONObject parsePayload(Byte[] payload) {
        JSONObject data;
        // const data = [
        // {
        // variable: "serial",
        // value: payload.readUInt32LE(1),
        // },
        // {
        // variable: "timestamp",
        // value: payload.readUInt32LE(5),
        // },
        // {
        // variable: "external_supply_voltage",
        // value: payload.readUInt8(9) + payload.readUInt8(10) * 0.01,
        // },
        // {
        // variable: "supply_voltage",
        // value: payload.readUInt8(11) + payload.readUInt8(12) * 0.01,
        // },
        // {
        // variable: "battery_voltage",
        // value: payload.readUInt8(13) + payload.readUInt8(14) * 0.01,
        // },
        // {
        // variable: "temperature",
        // value: payload.readInt8(15) + payload.readUInt8(16) * 0.01,
        // },
        // {
        // variable: "gsm_level",
        // value: payload.readInt8(17),
        // },
        // ];

        return data;
    }

    private class HelloResponse {

        byte[] getBytes() {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            try {
                bos.write(0x02);
                bos.write(0x55);
                bos.write(0x01);
                bos.write(0x08);
                byte[] dateTime = new byte[4];
                bos.write(dateTime);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
            }
            return bos.toByteArray();
        }
    }
}