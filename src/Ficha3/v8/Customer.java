package Ficha3.v8;

import java.util.Vector;

public class Customer {
    private String _name;
    private Vector<Rental> _rentals = new Vector<>();

    public Customer(String name) { this._name = name; }
    public void addRental(Rental arg) { _rentals.addElement(arg); }
    public String getName() { return _name; }

    // v7 helpers do slide
    public double getTotalAmount() {
        double total = 0.0;
        for (Rental r : _rentals)
            total += r.getMovie().getPrice().getRentalAmount(r.getDaysRented());
        return total;
    }

    public int getTotalFrequentRenterPoints() {
        int pts = 0;
        for (Rental r : _rentals)
            pts += r.getMovie().getPrice().getFrequentRentalPoints(r.getDaysRented());
        return pts;
    }

    public String statement() {
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
        for (Rental each : _rentals) {
            double amount = each.getMovie().getPrice().getRentalAmount(each.getDaysRented());
            result.append("\t")
                    .append(each.getMovie().getTitle())
                    .append("\t")
                    .append(amount)
                    .append("\n");
        }
        result.append("Amount owed is ").append(getTotalAmount()).append("\n");
        result.append("You earned ").append(getTotalFrequentRenterPoints())
                .append(" frequent renter points");
        return result.toString();
    }

    public String htmlStatement() {
        StringBuilder result = new StringBuilder("<h1>Rentals for <em>")
                .append(getName()).append("</em></h1>\n<ul>\n");
        for (Rental each : _rentals) {
            double amount = each.getMovie().getPrice().getRentalAmount(each.getDaysRented());
            result.append("<li>").append(each.getMovie().getTitle())
                    .append(": ").append(amount).append("</li>\n");
        }
        result.append("</ul>\n<p>Amount owed is <em>")
                .append(getTotalAmount()).append("</em></p>\n<p>You earned <em>")
                .append(getTotalFrequentRenterPoints())
                .append("</em> frequent renter points</p>");
        return result.toString();
    }
}
