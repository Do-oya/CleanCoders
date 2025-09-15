package movie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MovieTest {
    private Movie movie;

    @BeforeEach
    void setUp() {
        movie = new Movie();
    }

    @Test
    void should_return_0_when_just_created() {
        assertThat(movie.averageRating()).isEqualTo(0);
    }

    @Test
    void should_return_1_when_1_was_rated() {
        movie.rate(1);
        assertThat(movie.averageRating()).isEqualTo(1);
    }
}
