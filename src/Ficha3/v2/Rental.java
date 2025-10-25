package Ficha3.v2;

public class Rental
{
	private Movie _movie;
	private int		_daysRented;

	public Rental(Movie movie, int daysRented)
	{
		_movie = movie;
		_daysRented = daysRented;
	}

	public int getDaysRented()
	{
		return _daysRented;
	}

	public Movie getMovie()
	{
		return _movie;
	}

    /** v2 -> Método movido de Customer (Move Method refactoring) */
    public double getAmount() {
        double result = 0.0;

        switch (_movie.getPriceCode()) {
            case REGULAR:
                result += 2;
                if (_daysRented > 2) {
                    result += (_daysRented - 2) * 1.5;
                }
                break;

            case NEW_RELEASE:
                result += _daysRented * 3;
                break;

            case CHILDRENS:
                result += 1.5;
                if (_daysRented > 3) {
                    result += (_daysRented - 3) * 1.5;
                }
                break;
        }
        return result;
    }
}
