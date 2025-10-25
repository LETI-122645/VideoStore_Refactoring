package Ficha3.v2;

import java.util.Vector;

public class Customer {
    private String _name;
    private Vector<Rental> _rentals = new Vector<Rental>();

    public Customer(String name) {
        this._name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    /** V1: Long Method -> Extract Method (mantém getAmount em Customer) */
    public String statement() {
        double totalAmount = 0.0;
        int frequentRenterPoints = 0;

        String result = "Rental Record for " + getName() + "\n";

        for (Rental each : _rentals) {
            // valor desta locação (método extraído em V1)
            double thisAmount = each.getAmount();

            // pontos de cliente frequente (lógica mantém-se no statement)
            frequentRenterPoints++;
            if (each.getMovie().getPriceCode() == Movie.Code.NEW_RELEASE
                    && each.getDaysRented() > 1) {
                frequentRenterPoints++;
            }

            // linha desta locação
            result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }

        // footer
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;
    }


}
