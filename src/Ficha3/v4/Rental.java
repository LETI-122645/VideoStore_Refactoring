package Ficha3.v4;

public class Rental {
    private final Movie _movie;
    private final int _daysRented;

    public Rental(Movie movie, int daysRented) {
        this._movie = movie;
        this._daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    /** v4: Move Method — cálculo do montante vive no Rental */
    public double getAmount() {
        double result = 0.0;
        switch (_movie.getPriceCode()) {
            case REGULAR:
                result += 2;
                if (_daysRented > 2) result += (_daysRented - 2) * 1.5;
                break;
            case NEW_RELEASE:
                result += _daysRented * 3;
                break;
            case CHILDRENS:
                result += 1.5;
                if (_daysRented > 3) result += (_daysRented - 3) * 1.5;
                break;
        }
        return result;
    }

    /** v4: Move Method — pontos de cliente frequente também no Rental */
    public int getFrequentRentalPoints() {
        // 1 ponto base + bónus de 1 se NEW_RELEASE por mais de 1 dia
        int points = 1;
        if (_movie.getPriceCode() == Movie.Code.NEW_RELEASE && _daysRented > 1) {
            points += 1;
        }
        return points;
    }
}
