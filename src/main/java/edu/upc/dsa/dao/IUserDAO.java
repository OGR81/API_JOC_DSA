package edu.upc.dsa.dao;

import edu.upc.dsa.exceptions.UserNotAddedException;
import edu.upc.dsa.exceptions.UserNotFoundException;
import edu.upc.dsa.modelos.User;

public interface IUserDAO {
    User registro(String mail, String password) throws UserNotAddedException;
    User login(String mail, String password ) throws UserNotFoundException;
    // public void updateUser(String mail, String password, int userId);
   // public void deleteUser(int userID);
   // public List<User> getUsers();
  //  public List <User> getEmployeeByDept(int deptId);

    void clear();
}
