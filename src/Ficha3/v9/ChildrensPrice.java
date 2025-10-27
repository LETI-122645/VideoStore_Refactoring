package Ficha3.v9;

public class ChildrensPrice extends Price{

    public  ChildrensPrice() {}

    public double getRentalAmount(int duration){
        double rentalAmount = 1.5;
        if(duration > 3 )
            rentalAmount += (duration - 3) * 1.5;
        return  rentalAmount;
    }

    public int getFrequentRentalPoints(int duration){
        return 1;
    }


}
