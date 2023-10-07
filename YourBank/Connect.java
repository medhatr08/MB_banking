//steps in JDBC connectivity
// 1.Register the Driver
// 2.Create Connection
// 3.Create Statement
// 4.Executive Query
// 5.Close Connection

package YourBank;
import java.sql.*;

public class Connect {

    Connection c;
    Statement s;

    public Connect(){
        try{
           
            c=DriverManager.getConnection("jdbc:mysql:///bankingmanagementsystem","root","Medha123@");  //to make the connection with sql
            s=c.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
}
