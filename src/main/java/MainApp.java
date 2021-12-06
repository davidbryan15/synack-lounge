import com.aviles.entity.Credentials;
import com.aviles.entity.Product;
import com.aviles.entity.User;
import com.aviles.service.EmfService;
import com.aviles.util.CredentialsDbUtil;
import com.aviles.util.ProductDBUtil;
import com.aviles.util.UserDbUtil;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("begin");

        EntityManager emf = EmfService.getEntityManagerFactory().createEntityManager();

        List<Product> products = ProductDBUtil.getProducts();

        System.out.println("Products: " + products.toString());

        System.out.println("the end");
    }
}
