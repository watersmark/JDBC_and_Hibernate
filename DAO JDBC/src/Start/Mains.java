package Start;

import ClassCars.*;

import java.util.Arrays;
import java.util.Collections;


public class Mains {
    public static void main(String[] args) {

        Cars car1 = new Cars("Reno", 120000, 230);
        car1.addCar();

        car1.dropCar(car1);

        car1.update_price(100);

        for(String elem : car1.allCar()){
            System.out.println(elem);
        }

        System.out.println();

        System.out.println(Arrays.toString(car1.allCar().toArray(new String[0])));


    }
}
