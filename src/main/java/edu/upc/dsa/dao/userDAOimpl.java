package edu.upc.dsa.dao;

import edu.upc.dsa.exceptions.UserNotAddedException;
import edu.upc.dsa.exceptions.UserNotFoundException;
import edu.upc.dsa.modelos.User;
import edu.upc.dsa.util.Condition;

import java.util.HashMap;

public class userDAOimpl implements IUserDAO {
    private static IUserDAO instance;

    private userDAOimpl(){}

    public static IUserDAO getInstance(){
        if(instance == null){
            instance = new userDAOimpl();
        }
        return instance;
    }

    public User registro(String mail, String password) throws UserNotAddedException {
        Session session = FactorySession.openSession();
        User user = new User(0, mail, password);
        try {
            session.save(user);
        }
        catch (Exception e) {
            throw new UserNotAddedException();
        }
        finally {
            session.close();
        }

        return user;
    }

    public User login(String mail, String password) throws UserNotFoundException {
        Session session = FactorySession.openSession();
        User user = null;

        try {
            final HashMap<String, Condition> params = new HashMap<>();
            params.put("mail", new Condition("=", mail));
            params.put("password", new Condition("=", password));

            user = (User) session.findOne(User.class, params);
        }
        catch (Exception e) {
            // LOG
            e.printStackTrace();
        }
        finally {
            session.close();
        }

        if (user == null) {
            throw new UserNotFoundException();
        } else {
            return user;
        }
    }


    public void clear(){
        instance = null;
    }

    /*public void updateUser(String mail, String password, int userId) {
        User user = this.getUser(userId);
       user.setIdUser(userId);
       user.setMail(mail);
       user.setPassword(password);
        Session session = null;
        try {
            session = FactorySession.openSession();
            session.update(User.class, userId);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
    }*/


    /*public void deleteUser(int userId) {
        User user = this.getUser(userId);
        Session session = null;
        try {
            session = FactorySession.openSession();
            session.delete(user, userId);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

    }*/


    /*public List<User> getUsers() {
        Session session = null;
        List<User> userList =null;
        try {
            session = FactorySession.openSession();
            userList = session.findAll(User.class);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
        return userList;
    }*/


    /*public List<User> getEmployeeByDept(int deptID) {

        Session session = null;
        List<User> userList =null;
        try {
            session = FactorySession.openSession();

            HashMap<String, Integer> params = new HashMap<String, Integer>();
            params.put("deptID", deptID);

            userList = session.findAll(User.class, params);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
        return userList;
    }*/


}
