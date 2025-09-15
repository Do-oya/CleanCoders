package tyrant;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.Socket;

class TyrantTest {
    @Test
    void getRetrievesWhatWasPut() throws IOException {
//        Tyrant t = new Tyrant();
//        t.put("key", "value");
//        assertThat(t.get("key")).isEqualTo("value");

        new Socket("localhost", 1978);
    }
}
