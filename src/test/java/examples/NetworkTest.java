package examples;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.tagoio.sdk.domain.Result;
import com.tagoio.sdk.model.Network;

public class NetworkTest {
    String DATANET_TOKEN = "f4f30a8a-a8a2-41fc-a235-e0859610e85c";
    String NORTHMEN_DEVICE_TOKEN = "at9dcdffcf9e13459ab86c0040b36bf2c7";

    private Network network;

    @Before
    public void setup() {
        network = new Network(DATANET_TOKEN);
    }

    @Test
    public void testCreate() {
        assertNotNull(network);
    }

    @Test
    public void testResolveToken() {
        String serialNumber = "597853";
        Result result = network.resolveToken(serialNumber, NORTHMEN_DEVICE_TOKEN);
        assertNotNull(result);
        String token = (String) result.result;
        assertEquals("53e72eaa-17ee-4993-9b59-c115d8bee742", token);
    }

}
