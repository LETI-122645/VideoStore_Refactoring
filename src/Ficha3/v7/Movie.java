package Ficha3.v7;

public class Movie {
    public enum Code { REGULAR, CHILDRENS, NEW_RELEASE }

    private final String _title;
    private final Code _priceCode;

    public Movie(String title, Code priceCode) {
        this._title = title;
        this._priceCode = priceCode;
    }

    public Code getPriceCode() { return _priceCode; }
    public String getTitle()   { return _title; }

    // v7: cálculo do montante passou para Movie
    public double getRentalAmount(int daysRented) {
        double result = 0.0;
        switch (_priceCode) {
            case REGULAR:
                result += 2;
                if (daysRented > 2) result += (daysRented - 2) * 1.5;
                break;
            case NEW_RELEASE:
                result += daysRented * 3;
                break;
            case CHILDRENS:
                result += 1.5;
                if (daysRented > 3) result += (daysRented - 3) * 1.5;
                break;
        }
        return result;
    }

    // v7: pontos também calculados em Movie
    public int getFrequentRentalPoints(int daysRented) {
        int points = 1;
        if (_priceCode == Code.NEW_RELEASE && daysRented > 1) points += 1;
        return points;
    }
}
