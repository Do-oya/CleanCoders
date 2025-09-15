package tyrant;

import org.junit.jupiter.api.Test;

import java.io.IOException;

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
}
