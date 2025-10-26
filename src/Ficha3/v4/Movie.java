package Ficha3.v4;

public class Movie {
    public enum Code { REGULAR, CHILDRENS, NEW_RELEASE }

    private final String _title;
    private final Code _priceCode;

    public Movie(String title, Code priceCode) {
        this._title = title;
        this._priceCode = priceCode;
    }

    public Code getPriceCode() {
        return _priceCode;
    }

    public String getTitle() {
        return _title;
    }
}
