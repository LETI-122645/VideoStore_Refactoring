package Ficha3.v9;

public class Rental {
    private final Movie _movie;
    private final int _daysRented;

    public Rental(Movie movie, int daysRented) {
        this._movie = movie;
        this._daysRented = daysRented;
    }

    public int getDaysRented() { return _daysRented; }
    public Movie getMovie()    { return _movie; }
}
