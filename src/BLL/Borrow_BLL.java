package BLL;

import DAO.BorrowDAO;
import Model.Borrow;
import util.Config;

import java.sql.Date;
import java.util.ArrayList;

/**
 * @author cky
 * @Description: TODO
 * @date 2021.06.03 8:25
 */
public class Borrow_BLL {
    public Object[][] initTable(String[] columnNames){
        ArrayList<Borrow> borrows = new BorrowDAO().select(Config.account);
        Object[][] results = new Object[borrows.size()][columnNames.length];
        int i = 0;
        for (Borrow b : borrows){
            results[i][0] = b.getBookName();
            results[i][1] = new User_BLL().getName(b.getUserAccount());
            results[i][2] = b.getTime();
            results[i][3] = b.getStatus();
            i++;
        }
        return results;
    }

    public boolean BorrowBook(String BookName) {
        Borrow borrow = new Borrow();
        borrow.setBookName(BookName);
        borrow.setStatus("未还");
        borrow.setUserAccount(Config.account);
        borrow.setTime(new Date(new java.util.Date().getTime()));
        return new BorrowDAO().insert(borrow);
    }

    public boolean returnBook(String BookName) {
        return new BorrowDAO().update(BookName);
    }
}
