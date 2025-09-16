import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void canRoll() {
        game.roll(0);
    }

    @Test
    void gutterGame() {
        rollMany(0, 20);
        assertThat(game.getScore()).isEqualTo(0);
    }

    @Test
    void allOnes() {
        rollMany(1, 20);
        assertThat(game.getScore()).isEqualTo(20);
    }

//    @Test
//    void oneSpare() {
//        game.roll(5);
//        game.roll(5); // spare
//        game.roll(3);
//        rollMany(0, 17);
//        assertThat(game.getScore()).isEqualTo(16);
//    }

    private void rollMany(int pins, int frames) {
        for (int i = 0; i < frames; i++) {
            game.roll(pins);
        }
    }
}
