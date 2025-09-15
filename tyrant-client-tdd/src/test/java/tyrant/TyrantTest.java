package tyrant;

import org.junit.jupiter.api.Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.assertj.core.api.Assertions.assertThat;

class TyrantTest {
    @Test
    void getRetrievesWhatWasPut() throws IOException {
//        Tyrant t = new Tyrant();
//        t.put("key", "value");
//        assertThat(t.get("key")).isEqualTo("value");

        TyrantMap tyrantMap = new TyrantMap();
        tyrantMap.open();
        tyrantMap.put("key", "value");
        assertThat(tyrantMap.get("key")).isEqualTo("value".getBytes());
        tyrantMap.close();
    }

    private static class TyrantMap {

        public static final int OPERATION_PREFIX = 0xC8;
        public static final int OPERATION_PUT = 0x10;
        public static final int OPERATION_GET = 0x30;
        private Socket socket;
        private DataOutputStream writer;
        private DataInputStream reader;

        public void put(String key, String value) throws IOException {
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
            reader = new DataInputStream(socket.getInputStream());
        }

        public void close() throws IOException {
            socket.close();
        }

        public byte[] get(String key) throws IOException {
            writer.write(OPERATION_PREFIX);
            writer.write(OPERATION_GET);
            writer.writeInt(key.length());
            writer.write(key.getBytes());
            int status = reader.read();
            assertThat(status).isEqualTo(0);
            int length = reader.readInt();
            byte[] result = new byte[length];
            reader.read(result);
            return result;
        }
    }
}
