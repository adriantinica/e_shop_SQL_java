package student.example.orm.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class  Repository {
    
    private final String url = "jdbc:postgresql://localhost/e_shop_java?user=postgres&password=Laser112&ssl=false";
    Connection conn; 

    public Repository (){
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
                      e.printStackTrace();
        }
    }
    
}


