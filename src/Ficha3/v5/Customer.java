package Ficha3.v5;

import java.util.Vector;

public class Customer {
    private String _name;
    private Vector<Rental> _rentals = new Vector<>();

    public Customer(String name) {
        this._name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public double getTotalAmount(){
        double total = 0.0;
        for(Rental each: _rentals){
            total += each.getAmount();
        }
        return total;
    }

    public int getTotalFrequentRenterPoints(){
        int points = 0;
        for(Rental each: _rentals){
            points += each.getFrequentRentalPoints();
        }
        return points;
    }

    public String statement() {
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
        for (Rental each : _rentals) {
            result.append("\t")
                    .append(each.getMovie().getTitle())
                    .append("\t")
                    .append(each.getAmount())
                    .append("\n");

        }
        result.append("Amount owed is ").append(getTotalAmount()).append("\n");
        result.append("You earned ").append(getTotalFrequentRenterPoints())
                .append(" frequent renter points");
        return result.toString();
    }
}
