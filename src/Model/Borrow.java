package Model;

import DAO.InsertRequired;
import DAO.PrimaryKey;

import java.sql.Date;

/**
 * @author cky
 * @Description: TODO
 * @date 2021.06.03 8:19
 */
public class Borrow {
    @PrimaryKey
    int Id;
    @InsertRequired
    String bookName;
    @InsertRequired
    String userAccount;
    @InsertRequired
    Date time;
    @InsertRequired
    String status;

    public Borrow() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
