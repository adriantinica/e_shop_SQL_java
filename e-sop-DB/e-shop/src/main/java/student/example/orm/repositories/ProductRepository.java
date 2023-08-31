package student.example.orm.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import student.example.orm.entities.Product;

//HW2: make sure that there is ONLY ONE object of type ProductRepository !!!! (Singleton)
public class ProductRepository extends Repository {

    
    private static ProductRepository instance;

    // Private constructor to prevent direct instantiation from outside the class.
    private ProductRepository() {
        super();
    }

    
    public static ProductRepository getInstance() {
        if (instance == null) {
            instance = new ProductRepository();
        }
        return instance;
    }
    
    


        public void create (Product product){
            Statement st;
            try {
                st = conn.createStatement();
                st.executeUpdate("INSERT INTO products VALUES ("
                + product.getId()+ ", '"
                + product.getName()+ "','"
                + product.getImage()+"'"+
                ") ");
            } catch (SQLException e) {
                
                e.printStackTrace();
            }
        }

        public Product readById(int id){
         Statement st;
         Product product= null;
            try {
                st = conn.createStatement();
                ResultSet rs= st.executeQuery("SELECT *FROM products where id="+ id);
                rs.next();
                product = new Product(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3));
                } catch (SQLException e) {
               
                e.printStackTrace();
            }
            return product;
        }

        public List<Product> readAll(){
            List<Product> products = new ArrayList<>();
            Statement st = null;
            ResultSet rs = null;

        
                try {
                   st = conn.createStatement();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    rs = st.executeQuery("SELECT * FROM products");
                } catch (SQLException e) {
                    e.printStackTrace();
                }

               try {
                   while (rs.next()) {
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        String image = rs.getString("image");

                        Product product = new Product(id, name, image);
                     products.add(product);
                    }
                } catch (SQLException e) {
                
                    e.printStackTrace();
                }
            return products;
        }
        // UPDATE
        public void update(String name, String image, int id){
           
            Statement st;
            try {
                st = conn.createStatement();
                st.executeUpdate("UPDATE products SET name ='"+ name+ "', image ='"+ image + "' WHERE id = " +id);
            } catch (SQLException e) {
                
                e.printStackTrace();
            }
        }

    
    
        //DELETE

        public void deleteById(int id){
            Statement st;
            try {
                st = conn.createStatement();
                st.executeUpdate("DELETE FROM products WHERE id ="+ id);
            } catch (SQLException e) {
                
                e.printStackTrace();
            }
        }
   



       
        
    
    
}
