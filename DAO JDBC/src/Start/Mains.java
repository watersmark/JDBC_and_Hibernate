package Start;

import ClassCars.*;


public class Mains {
    public static void main(String[] args) {

        Cars car1 = new Cars("Reno", 120000, 230);
        car1.addCar();

        car1.dropCar(car1);

        car1.update_price(100);

        System.out.println("End work");

    }
}
