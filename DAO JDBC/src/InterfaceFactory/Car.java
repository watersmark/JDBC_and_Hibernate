package InterfaceFactory;

import java.util.List;

public interface Car {

    void mark();
    void update_price(int money);
    void dropCar(Car car);
    void addCar();

    int money(int money);
    String ownerCar(Car car);

    List<String> allCar();





}
