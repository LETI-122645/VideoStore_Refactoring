package Ficha3.v1;

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
            double thisAmount = getAmount(each);

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

    /** V1: método extraído — usa estado de Rental/Movie (Feature Envy, como no slide) */
    public double getAmount(Rental aRental) {
        double result = 0.0;

        switch (aRental.getMovie().getPriceCode()) {
            case REGULAR:
                result += 2;
                if (aRental.getDaysRented() > 2) {
                    result += (aRental.getDaysRented() - 2) * 1.5;
                }
                break;

            case NEW_RELEASE:
                result += aRental.getDaysRented() * 3;
                break;

            case CHILDRENS:
                result += 1.5;
                if (aRental.getDaysRented() > 3) {
                    result += (aRental.getDaysRented() - 3) * 1.5;
                }
                break;
        }
        return result;
        // (notar que ainda “inveja” dados de Rental/Movie: é o *Feature Envy* que
        // vamos tratar no V2 com Move Method para Rental.)
    }
}
