package tyrant;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.assertj.core.api.Assertions.assertThat;

public class TyrantMap {
    public static final int OPERATION_PREFIX = 0xC8;
    public static final int OPERATION_PUT = 0x10;
    public static final int OPERATION_GET = 0x30;
    private Socket socket;
    private DataOutputStream writer;
    private DataInputStream reader;

    public void open() throws IOException {
        socket = new Socket("localhost", 1978);
        writer = new DataOutputStream(socket.getOutputStream());
        reader = new DataInputStream(socket.getInputStream());
    }

    public void put(String key, String value) throws IOException {
        writeHeader(OPERATION_PUT);
        writeKeyValue(key, value);
        verifyStatus();
    }

    public byte[] get(String key) throws IOException {
        writeHeader(OPERATION_GET);
        writeKey(key);
        verifyStatus();
        return readResults();
    }

    private byte[] readResults() throws IOException {
        int length = reader.readInt();
        byte[] result = new byte[length];
        reader.read(result);
        return result;
    }

    private void writeKey(String key) throws IOException {
        writer.writeInt(key.length());
        writer.write(key.getBytes());
    }

    public void close() throws IOException {
        socket.close();
    }

    private void verifyStatus() throws IOException {
        int status = reader.read();
        assertThat(status).isEqualTo(0);
    }

    private void writeKeyValue(String key, String value) throws IOException {
        writer.writeInt(key.length());
        writeKey(value);
        writer.write(value.getBytes());
    }

    private void writeHeader(int operationCode) throws IOException {
        writer.write(OPERATION_PREFIX);
        writer.write(operationCode);
    }
}
