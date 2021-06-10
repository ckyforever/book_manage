package DAO;

import Model.Borrow;

import java.util.ArrayList;

/**
 * @author cky
 * @Description: TODO
 * @date 2021.06.03 8:22
 */
public class BorrowDAO {
    public ArrayList<Borrow> select() {
        return DataMysql.INSTANCE.query(Borrow.class, "select * from borrow");
    }

    public ArrayList<Borrow> select(String account) {
        return DataMysql.INSTANCE.query(Borrow.class, "select * from borrow where userAccount = " + account);
    }

    public boolean insert(Borrow borrow) {
        String sql = "insert into borrow (bookName,userAccount,time,status)values('" +
                borrow.getBookName() + "','" +
                borrow.getUserAccount() + "'," +
                borrow.getTime() + ",'" +
                borrow.getStatus() + "')";
        return DataMysql.INSTANCE.executeSql(sql);
        //return true;
    }

    public boolean update(String bookName) {
        String sql = "update borrow set status = '归还' where bookName = '" + bookName + "'";
        return DataMysql.INSTANCE.executeSql(sql);
        //return true;
    }
}
