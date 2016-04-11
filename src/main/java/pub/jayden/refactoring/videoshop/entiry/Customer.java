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

            Rental each = rentalEnumeration.nextElement();

            frequentRenterPoints += each.getFrequentRenterPoints();

            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
            totalAmount += each.getCharge();
        }

        result += "누적 대여료 : " + String.valueOf(totalAmount) + "\n";
        result += "적립 포인트 : " + String.valueOf(frequentRenterPoints);
        return result;
    }
}
