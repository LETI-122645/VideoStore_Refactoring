package Ficha3.v9;

public class RegularPrice extends Price {

    public RegularPrice() {}

    public double getRentalAmount(int duration){
        double rentalAmount = 2;
        if(duration > 2 )
            rentalAmount += (duration - 2) * 1.5;
        return  rentalAmount;
    }

    public int getFrequentRentalPoints(int duration){
        return 1;
    }
}
