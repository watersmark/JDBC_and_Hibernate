package ClassCars;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import InterfaceFactory.Car;
import com.sun.source.doctree.StartElementTree;

public class Cars implements Car {

    private String mark;
    private int money;
    private int horse;

    private String prep1 = "Insert into car(model, price, horse) values(?, ?, ?)";
    private String prep2 = "Delete from car where id = ?";
    private String prep3 = "Update car set price = ? where id = ?";

    Connection connection = null;

    private static String url = "jdbc:mysql://localhost:3306/cars";
    private static String name = "root";
    private static String pass = "12345";

    public Cars(String mark, int money, int horse) {

        this.mark = mark;
        this.money = money;
        this.horse = horse;

        try {
            this.connection = DriverManager.getConnection(url, name, pass);
            System.out.println("Connect Cars");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void mark() {

    }

    @Override
    public void update_price(int money) {
        try {

            PreparedStatement statement = connection.prepareStatement(prep3);

            statement.setInt(1, money);
            statement.setInt(2, 2);

            statement.execute();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void dropCar(InterfaceFactory.Car car) {
        try {

            PreparedStatement statement = connection.prepareStatement(prep2);
            statement.setInt(1, 1);
            statement.execute();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void addCar() {
        try {

            PreparedStatement statement = connection.prepareStatement(prep1);

            statement.setString(1,this.mark);
            statement.setInt(2, this.money);
            statement.setInt(3, this.horse);

            statement.execute();

            statement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public int money(int money) {
        return 0;
    }

    @Override
    public String ownerCar(InterfaceFactory.Car car) {
        return null;
    }

    @Override
    public List<String> allCar() {
        List<String> lst = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * from car");




            while (set.next()){
                String resultString = new String();

                resultString += set.getInt(1) + " ";
                resultString += set.getString(2) + " ";
                resultString += set.getInt(3) + " ";
                resultString += set.getString(4);

                lst.add(resultString);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return lst;
    }


}
