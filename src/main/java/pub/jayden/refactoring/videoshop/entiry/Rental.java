package pub.jayden.refactoring.videoshop.entiry;

/**
 * Created by jaydenuk on 2016. 4. 10..
 */
public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented){
        movie = movie;
        daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    double getCharge() {

        double result = 0;

        switch (getMovie().getPriceCode()) {

            case Movie.REGULAR:
                result += 2;
                if(getDaysRented() > 2){
                    result += (getDaysRented() - 2) * 1.5;
                }

                break;
            case Movie.NEW_RELEASE:
                result += getDaysRented() * 3;
                break;

            case Movie.CHILDREN:
                result += 1.5;
                if(getDaysRented() > 3)
                    result += (getDaysRented() - 3) * 1.5;
                break;
        }
        return result;
    }
}
