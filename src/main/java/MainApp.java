import com.aviles.entity.Credentials;
import com.aviles.entity.User;
import com.aviles.service.EmfService;
import com.aviles.util.CredentialsDbUtil;
import com.aviles.util.UserDbUtil;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("begin");

        EntityManager emf = EmfService.getEntityManagerFactory().createEntityManager();

        String username = "jdoe";
        String pass = "testpass";

        User tempUser = CredentialsDbUtil.getUserFromCreds(username, pass);

        System.out.println("TempUser: " + tempUser);

        System.out.println("the end");
    }
}
