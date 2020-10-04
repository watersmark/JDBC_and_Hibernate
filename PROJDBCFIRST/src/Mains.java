//import java.sql.*;

import com.mysql.cj.jdbc.ConnectionImpl;

import java.sql.*;


public class Mains {

    private static final String url = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC" ;
    private static final String name ="root";
    private static final String pass = "12345";

    private static final String str = "INSERT INTO users(firstName, lastname)" +
            "values(?, ?)";



    public static void main(String[] args) {

        if(testConnect()){

            try {
                Connection connect = DriverManager.getConnection(url, name, pass);
                PreparedStatement st1 = connect.prepareStatement(str);
                Statement st2 = connect.createStatement();


                st1.setString(1,"Tolanka");
                st1.setString(2, "Kolanka");


                st1.execute();


            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

    }


    public static boolean testConnect(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connection success");
            return true;
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
            return false;
        }

    }


}
