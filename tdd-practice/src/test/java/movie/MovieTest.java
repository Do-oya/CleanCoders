package movie;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MovieTest {
    @Test
    void canCreateMovie() {
        Movie movie = new Movie();
        assertThat(movie.averageRating()).isEqualTo(0);
    }
}
