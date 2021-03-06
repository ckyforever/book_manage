package DAO;

import Model.User;
import View.Notice;

import java.util.ArrayList;

/**
 * @author cky
 * @Description: TODO
 * @date 2021.06.03 6:08
 */
public class UserDAO {

    public ArrayList<User> select() {
        ArrayList<User> list = DataMysql.INSTANCE.query(User.class,"select * from user");
        if(list == null) {
            new Notice("查询异常");
        }
        return list;
    }

    public void update(User user) {
        String sql = "update user set account='"+user.getAccount()+"'" +
                ", name='"+user.getName()+"', password='"+user.getPassword()+"'" +
                " where Id="+user.getId();
        DataMysql.INSTANCE.executeSql(sql);
    }

    public Boolean insert(User user) {
        String sql = "insert into user (account,name,password)values"+"('"+
                user.getAccount() +
                "','"+user.getName()+
                "','"+user.getPassword()+"')";
        if(!DataMysql.INSTANCE.executeSql(sql)) {
            new Notice("插入执行异常");
        }
        return true;
    }

    public void delete(int Id) {
        String sql = "delete from user where Id = "+Id;
        DataMysql.INSTANCE.executeSql(sql);
    }

    public void update(String account, String pass) {
        String sql = "update user set password = '"+pass+"' where account = ‘" + account + "'";
        DataMysql.INSTANCE.executeSql(sql);

    }
}
