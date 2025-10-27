package Ficha3.v9;

public class Main {
    public static void main(String[] args) {

        Price regularPrice = new Price(Price.Code.REGULAR);
        Price childrensPrice = new Price(Price.Code.CHILDRENS);
        Price newReleasePrice = new Price(Price.Code.NEW_RELEASE);

        Customer who = new Customer("Barack Obama");
        Movie m1 = new Movie("Life of Amalia", regularPrice);
        Movie m2 = new Movie("Peter Pan", childrensPrice);
        Movie m3 = new Movie("Donna del Lago", newReleasePrice);

        who.addRental(new Rental(m1, 1)); // 2.0
        who.addRental(new Rental(m2, 2)); // 1.5
        who.addRental(new Rental(m3, 3)); // 9.0 (+1 ponto)

        System.out.println(who.statement());
    }
}
