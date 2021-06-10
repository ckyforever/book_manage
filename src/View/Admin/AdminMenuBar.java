package View.Admin;

import View.Login;
import View.User.ReturnBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author cky
 * @Description: TODO
 * @date 2021.06.03 14:56
 */
public class AdminMenuBar {
    JMenuBar menuBar;
    JMenuItem menuItemEditBook;
    JMenuItem menuItemEditUser;
    JMenuItem menuItemChangUser;
    JMenuItem menuItemExit;

    public AdminMenuBar(JFrame frame){
        menuBar = new JMenuBar();

        // 管理图书菜单项
        menuItemEditBook = new JMenuItem("管理书籍信息");
        setMenuItemEditBook(frame);

        // 管理用户菜单项
        menuItemEditUser = new JMenuItem("管理用户");
        setMenuItemEditUser(frame);

        // 用户信息更改菜单项
        menuItemChangUser = new JMenuItem("更改密码");
        ImageIcon icon = new ImageIcon("res/密码.png");
        icon.setImage(icon.getImage().getScaledInstance(25,25, Image.SCALE_DEFAULT));
        menuItemChangUser.setIcon(icon);
        menuItemChangUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new ChangeAdminInformation();
            }
        });

        // 退出系统菜单项
        menuItemExit = new JMenuItem("退出");
        setMenuItemExit(frame);

        menuBar.add(menuItemEditBook);
        menuBar.add(menuItemEditUser);
        menuBar.add(menuItemChangUser);
        menuBar.add(menuItemExit);

        frame.setJMenuBar(menuBar);
    }

    private void setMenuItemEditUser(JFrame frame) {
        ImageIcon icon = new ImageIcon("res/图书类别.png");
        icon.setImage(icon.getImage().getScaledInstance(25,25, Image.SCALE_DEFAULT));
        menuItemEditUser.setIcon(icon);
        menuItemEditUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new EditUser();
            }
        });
    }


    /**
     * 设置图书借阅菜单项
     */
    private void setMenuItemEditBook(JFrame frame) {
        ImageIcon icon = new ImageIcon("res/图书信息.png");
        icon.setImage(icon.getImage().getScaledInstance(25,25, Image.SCALE_DEFAULT));
        menuItemEditBook.setIcon(icon);
        menuItemEditBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditBook();
            }
        });
    }

    /**
     * 设置退出系统菜单项
     */
    private void setMenuItemExit(final JFrame frame) {
        ImageIcon icon = new ImageIcon("res/退出.png");
        icon.setImage(icon.getImage().getScaledInstance(25,25, Image.SCALE_DEFAULT));
        menuItemExit.setIcon(icon);
        menuItemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 使父窗体不可见
                frame.setVisible(false);
                new Login().initUI();
            }
        });
    }
}
