package BLL;

import DAO.UserDAO;
import Model.User;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author cky
 * @Description: TODO
 * @date 2021.06.03 6:05
 */
public class User_BLL {
    public boolean login(String account,String pass){
        ArrayList<User> users = new UserDAO().select();
        for (User u : users){
            if (u.getAccount().equals(account) && u.getPassword().equals(pass)){
                return true;
            }
        }
        return false;
    }
    public Boolean register(User user){
        return new UserDAO().insert(user);
    }
    public void edit(JTextField username, JTextField passwd) throws SQLException{
        User user = new User();
        UserDAO userdao=new UserDAO();
        userdao.update(username.getText(),passwd.getText());
    }
    public String getName(String account){
        ArrayList<User> users = new UserDAO().select();
        for (User u : users){
            if(u.getAccount().equals(account))
                return u.getName();
        }
        return null;
    }
}
