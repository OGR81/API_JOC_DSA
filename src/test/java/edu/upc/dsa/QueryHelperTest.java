package edu.upc.dsa;


import edu.upc.dsa.dao.IUserDAO;
import edu.upc.dsa.modelos.User;
import edu.upc.dsa.util.QueryHelper;
import org.junit.Assert;
import org.junit.Test;

public class QueryHelperTest {

    private IUserDAO dao;

    @Test
    public void testQueryINSERT() {
        Assert.assertEquals("INSERT INTO User (idUser, mail, password) VALUES (?, ?, ?)",
                QueryHelper.createQueryINSERT(new User(0, "Juan", "lopez")));
    }
}