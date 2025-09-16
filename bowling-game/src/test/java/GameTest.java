import org.junit.jupiter.api.Test;

class GameTest {
    @Test
    void canCreate() {
        Game game = new Game();
    }

    @Test
    void canRoll() {
        Game game = new Game();
        game.roll(0);
    }
}
