package pub.jayden.refactoring.videoshop.entiry;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by jaydenuk on 2016. 4. 10..
 */
public class Customer {

    private String name;
    private Vector<Rental> rentals = new Vector<Rental>();

    public Customer(String name) {
        name = name;
    }

    public void addRentals(Rental arg){
        rentals.addElement(arg);
    }

    public String getName(){
        return name;
    }


    public String statement(){
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        Enumeration<Rental> rentalEnumeration = rentals.elements();

        String result = getName() + " 고객님의 대여 기록\n";

        while (rentalEnumeration.hasMoreElements()) {

            double thisAmount = 0d;
            Rental each = rentalEnumeration.nextElement();

            switch (each.getMovie().getPriceCode()) {

                case Movie.REGULAR:
                    thisAmount += 2;
                    if(each.getDaysRented() > 2){
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    }

                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;

                case Movie.CHILDREN:
                    thisAmount += 1.5;
                    if(each.getDaysRented() > 3)
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    break;
            }
            frequentRenterPoints ++;

            if((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                    each.getDaysRented() >1)
                frequentRenterPoints ++;

            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }

        result += "누적 대여료 : " + String.valueOf(totalAmount) + "\n";
        result += "적립 포인트 : " + String.valueOf(frequentRenterPoints);
        return result;
    }
}
