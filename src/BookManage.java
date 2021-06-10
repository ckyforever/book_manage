import View.Login;

import javax.swing.*;

/**
 * @author cky
 * @Description: 主程序类
 * @date 2021.06.02 6:05
 */
public class BookManage extends JFrame {

    public BookManage() {

        new Login().initUI();
    }


    public static void main(String[] args) {

        new BookManage();

    }
}
