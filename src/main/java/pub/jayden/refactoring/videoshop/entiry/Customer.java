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

        Enumeration<Rental> rentalEnumeration = rentals.elements();

        String result = getName() + " 고객님의 대여 기록\n";

        while (rentalEnumeration.hasMoreElements()) {

            Rental each = rentalEnumeration.nextElement();

            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        result += "누적 대여료 : " + String.valueOf(getTotalCharge()) + "\n";
        result += "적립 포인트 : " + String.valueOf(getTotalFrequentRenterPoints());
        return result;
    }

    public String htmlStatement(){
        Enumeration<Rental> rentalEnumeration = rentals.elements();

        String result = "<H1><EM>" + getName() + " 고객님의 대여 기록</EM></H1><P>\n";
        while (rentalEnumeration.hasMoreElements()) {
            Rental each = rentalEnumeration.nextElement();

            result += each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "<BR>\n";
        }
        result += "<P>누적 대여료: <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
        result += "적립 포인트: <EM>" + String.valueOf(getTotalFrequentRenterPoints()) + "</EM><P>";
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration<Rental> rentalEnumeration = rentals.elements();
        while (rentalEnumeration.hasMoreElements()) {

            Rental each = rentalEnumeration.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration<Rental> rentalEnumeration = rentals.elements();
        while (rentalEnumeration.hasMoreElements()) {

            Rental each = rentalEnumeration.nextElement();
            result += each.getCharge();
        }
        return result;
    }
}
