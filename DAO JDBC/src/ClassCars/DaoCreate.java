package ClassCars;

import InterfaceFactory.Car;
import InterfaceFactory.FactoryDAO;


public class DaoCreate implements FactoryDAO {
    private static DaoCreate usualDao;

    static {
        usualDao = new DaoCreate();
    }

    private DaoCreate(){

        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connection success");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }

    public static DaoCreate createDao(DaoCreate dao){

        if(dao == null){
            dao = new DaoCreate();
        }

        return dao;
    }

    @Override
    public Car createCar(String model, int price, int horce) {
        return new Cars(model, price, horce);

    }
}
