public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title) {
        super(title, Movie.NEW_RELEASE);
    }

    @Override
    double determineAmount(int daysRented) {
        double rentalAmount = daysRented * 3;
        return rentalAmount;
    }

    @Override
    int determineFrequentRentalPoint(int daysRented) {
        if (daysRented > 1)
            return 2;
        return 1;
    }
}
