package BLL;

import DAO.AdminDAO;
import Model.Admin;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author cky
 * @Description: TODO
 * @date 2021.05.25 16:47
 */
public class Admin_BLL {
    public boolean login(Admin admin) throws SQLException {
        ArrayList<Admin> adminList = new AdminDAO().select();
        for (Admin ad : adminList){
            if(admin.getAccount().equals(ad.getAccount()) && admin.getPassword().equals(ad.getPassword())){
                return true;
            }
        }
        return false;
    }
    public void edit(JTextField username, JTextField passwd) throws SQLException{
        AdminDAO adminDAO = new AdminDAO();
        adminDAO.update(username.getText(),passwd.getText());
    }
}
