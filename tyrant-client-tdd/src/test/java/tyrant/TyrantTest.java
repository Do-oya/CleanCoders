package tyrant;

import org.junit.jupiter.api.Test;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import static org.assertj.core.api.Assertions.assertThat;

class TyrantTest {
    @Test
    void getRetrievesWhatWasPut() throws IOException {
//        Tyrant t = new Tyrant();
//        t.put("key", "value");
//        assertThat(t.get("key")).isEqualTo("value");

        new TyrantMap().put();
    }

    private static class TyrantMap {

        public static final int OPERATION_PREFIX = 0xC8;
        public static final int OPERATION_PUT = 0x10;
        private Socket socket;
        private DataOutputStream writer;
        private InputStream reader;

        public void put() throws IOException {
            String key = "key";
            String value = "value";

            open();

            writer.write(OPERATION_PREFIX);
            writer.write(OPERATION_PUT);
            writer.writeInt(key.length());
            writer.writeInt(value.length());
            writer.write(key.getBytes());
            writer.write(value.getBytes());
            int status = reader.read();
            assertThat(status).isEqualTo(0);
        }

        private void open() throws IOException {
            socket = new Socket("localhost", 1978);
            writer = new DataOutputStream(socket.getOutputStream());
            reader = socket.getInputStream();
        }
    }
}
