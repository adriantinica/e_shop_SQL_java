package student.example;
import java.sql.SQLException;
import student.example.orm.entities.Product;
import student.example.orm.repositories.ProductRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException{


    
      ProductRepository pr = new ProductRepository.getInstance(); 
      pr.create(new Product(2,"Mango","2.jpg")); 
      pr.create(new Product(3, "Tomato", "3.jpg"));     
      

      Product product = pr.readById(1);
      System.out.println(product);
      System.out.println();
      System.out.println(pr.readAll());
      pr.deleteById(2);
      System.out.println(pr.readAll());
      pr.update("Avocado","4.jpg",3);
      System.out.println(pr.readAll());


      
       
    }

    
}
