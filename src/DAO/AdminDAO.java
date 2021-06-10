package DAO;

import Model.Admin;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author cky
 * @Description: TODO
 * @date 2021.05.24 23:50
 */
public class AdminDAO {
    public ArrayList<Admin> select() throws SQLException {
        DataMysql dataMysql = DataMysql.INSTANCE;
            return dataMysql.query(Admin.class,"select * from admin");
    }

    public void insert(Admin admin) {

    }

    public void updateAdmin(Admin admin) {

    }

    public void update(String account,String pass) {
        DataMysql.INSTANCE.executeSql("update admin set password='"+pass+"' where account = '"+account+"'");
    }

    public void deleteAdmin(int Id) {

    }
}
