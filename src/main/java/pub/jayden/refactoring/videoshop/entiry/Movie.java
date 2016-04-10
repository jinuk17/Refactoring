package pub.jayden.refactoring.videoshop.entiry;

/**
 * Created by jaydenuk on 2016. 4. 10..
 */
public class Movie {
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDREN = 2;

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {

        title = title;
        priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }
}
