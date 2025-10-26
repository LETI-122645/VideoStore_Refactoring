package Ficha3.v4;

public class Main {
    public static void main(String[] args) {
        Customer who = new Customer("Barack Obama");
        Movie m1 = new Movie("Life of Amalia", Movie.Code.REGULAR);
        Movie m2 = new Movie("Peter Pan", Movie.Code.CHILDRENS);
        Movie m3 = new Movie("Donna del Lago", Movie.Code.NEW_RELEASE);

        who.addRental(new Rental(m1, 1)); // 2.0
        who.addRental(new Rental(m2, 2)); // 1.5
        who.addRental(new Rental(m3, 3)); // 9.0 (+1 ponto)

        System.out.println(who.statement());
    }
}
