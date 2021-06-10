package Model;

import DAO.InsertRequired;
import DAO.PrimaryKey;

/**
 * @author cky
 * @Description: admin基本类
 * @date 2021.05.24 22:50
 */
public class Admin {
    @PrimaryKey
    private int Id;
    @InsertRequired
    private String account;
    @InsertRequired
    private String password;
    @InsertRequired
    private String name;
    @InsertRequired
    private String telephone;
    @InsertRequired
    private String address;

    public Admin(){

    }
    public Admin(int id, String account, String password, String name, String telephone, String address) {
        Id = id;
        this.account = account;
        this.password = password;
        this.name = name;
        this.telephone = telephone;
        this.address = address;
    }

    public Admin(String account, String password) {
        this.account = account;
        this.password = password;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
