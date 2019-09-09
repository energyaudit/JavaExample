package src.main.Java2;


import java.sql.*;
class Database2{
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mysql","root","pass");
//here mysql is database name, root is username and password is
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("use sugarcrm;\n" +
                    "select * from accounts where billing_address_postalcode=20607;");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}