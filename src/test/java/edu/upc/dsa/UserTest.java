package edu.upc.dsa;

import edu.upc.dsa.dao.IUserDAO;
import edu.upc.dsa.dao.mapDAOimpl;
import edu.upc.dsa.dao.userDAOimpl;
import edu.upc.dsa.exceptions.UserNotAddedException;
import edu.upc.dsa.exceptions.UserNotFoundException;
import edu.upc.dsa.modelos.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
    private IUserDAO dao;

    @Before
    public void setUp() throws Exception {
        this.dao = userDAOimpl.getInstance();
    }


    @Test
    public void TestRegistro() throws UserNotAddedException {
        User user = this.dao.registro("esteban","1234");
        Assert.assertNotNull(user);
        Assert.assertEquals("esteban", user.getMail());
        Assert.assertEquals("1234", user.getPassword());
    }

    @Test
    public void TestLogin() throws UserNotFoundException {
        User user1 = dao.login("esteban","1234");
        Assert.assertNotNull(user1);
        Assert.assertEquals("esteban", user1.getMail());
        Assert.assertEquals("1234",user1.getPassword());
    }
}
