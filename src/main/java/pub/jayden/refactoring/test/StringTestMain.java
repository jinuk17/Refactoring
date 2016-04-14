package pub.jayden.refactoring.test;

/**
 * Created by jaydenuk on 2016. 4. 11..
 */
public class StringTestMain {

    public static void main(String[] args) {

        String barcode_1 = "AAAAAA";
        String barcode_2 = "AAAAAA";
        String barcode_3 = new String("AAAAAA");
        String emptyBarcode_1 = "";
        String emptyBarcode_2 = "";


        if(barcode_1 == "AAAAAA"){

            System.out.println("barcode_1 == \"AAAAAA\"");
        }

        if(barcode_1 == barcode_2){
            System.out.println("barcode_1 == barcode_2");
        }

        if(barcode_1 == barcode_3){
            System.out.println("barcode_1 == barcode_3");
        }

        if("AAAAAA".equals(barcode_1)){
            System.out.println("barcode_1.equals(\"AAAAAA\")");
        }

        if(barcode_1.equals(barcode_2)){
            System.out.println("barcode_1.equals(barcode_2)");
        }

        if(emptyBarcode_1 == ""){
            System.out.println("emptyBarcode_1 == \"\"");
        }

        if(emptyBarcode_1 == emptyBarcode_2){
            System.out.println("emptyBarcode_1 == emptyBarcode_2");
        }

        if("".equals(emptyBarcode_1)){
            System.out.println("\"\".equals(emptyBarcode_1)");
        }

        if(emptyBarcode_1.equals(emptyBarcode_2)){
            System.out.println("emptyBarcode_1.equals(emptyBarcode_2)");
        }


    }
}
