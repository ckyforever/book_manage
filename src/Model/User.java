package Model;

import DAO.InsertRequired;
import DAO.PrimaryKey;

/**
 * @author cky
 * @Description: TODO
 * @date 2021.06.03 5:46
 */
public class User {
    @PrimaryKey
    private int Id;
    @InsertRequired
    private String account;
    @InsertRequired
    private String name;
    @InsertRequired
    private String password;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
