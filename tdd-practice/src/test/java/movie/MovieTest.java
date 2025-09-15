package movie;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MovieTest {
    @Test
    void should_return_0_when_just_created() {
        Movie movie = new Movie();
        assertThat(movie.averageRating()).isEqualTo(0);
    }

    @Test
    void should_return_1_when_1_was_rated() {
        Movie movie = new Movie();
        movie.rate(1);
        assertThat(movie.averageRating()).isEqualTo(1);
    }
}
