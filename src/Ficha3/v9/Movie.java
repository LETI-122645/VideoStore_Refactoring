package Ficha3.v9;

public class Movie {

    private final String _title;
    private final Price _price;

    public Movie(String title, Price price) {
        this._title = title;
        this._price = price;
    }

    public Price getPrice() { return _price; }
    public String getTitle()   { return _title; }

}
