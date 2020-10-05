//import java.sql.*;

import java.sql.*;


public class Mains {

    private static final String url = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC" ;
    private static final String name ="root";
    private static final String pass = "12345";

    private static final String str = "INSERT INTO users(firstName, lastname)" +
            "values(?, ?)";

    private static final String str1 = "Select * from users where lastname = ?";

    private static final String str2 = "delete from users where id = ?";


    public static void main(String[] args) {

        if(testConnect()){

            try {

                Connection connect = DriverManager.getConnection(url, name, pass);
                PreparedStatement statement1 = connect.prepareStatement(str2);
                Statement insSt = connect.createStatement();



                insSt.execute("Select * from users");
                //System.out.println(res);





            } catch (Exception e) {
                e.printStackTrace();
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
