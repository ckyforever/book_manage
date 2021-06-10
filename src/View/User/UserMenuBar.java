package View.User;

import View.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author cky
 * @Description: TODO
 * @date 2021.06.03 6:57
 */
public class UserMenuBar {
    JMenuBar menuBar;
    JMenuItem menuItemBookBorrow;
    JMenuItem menuItemReturnBook;
    JMenuItem menuItemChangUser;
    JMenuItem menuItemExit;

    public UserMenuBar(JFrame frame){
        menuBar = new JMenuBar();

        // 图书信息借阅菜单项
        menuItemBookBorrow = new JMenuItem("借书");
        setMenuItemBookBorrow(frame);

        // 图书借阅管理菜单项
        menuItemReturnBook = new JMenuItem("还书");
        setMenuItemReturnBook(frame);

        // 用户信息更改菜单项
        menuItemChangUser = new JMenuItem("更改密码");
        ImageIcon icon = new ImageIcon("res/密码.png");
        icon.setImage(icon.getImage().getScaledInstance(25,25, Image.SCALE_DEFAULT));
        menuItemChangUser.setIcon(icon);
        menuItemChangUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new ChangeUserInformation();
            }
        });

        // 退出系统菜单项
        menuItemExit = new JMenuItem("退出");
        setMenuItemExit(frame);

        menuBar.add(menuItemBookBorrow);
        menuBar.add(menuItemReturnBook);
        menuBar.add(menuItemChangUser);
        menuBar.add(menuItemExit);

        frame.setJMenuBar(menuBar);
    }

    private void setMenuItemReturnBook(JFrame frame) {
        ImageIcon icon = new ImageIcon("res/图书类别.png");
        icon.setImage(icon.getImage().getScaledInstance(25,25, Image.SCALE_DEFAULT));
        menuItemReturnBook.setIcon(icon);
        menuItemReturnBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new ReturnBook();
            }
        });
    }


    /**
     * 设置图书借阅菜单项
     */
    private void setMenuItemBookBorrow(JFrame frame) {
        ImageIcon icon = new ImageIcon("res/图书信息.png");
        icon.setImage(icon.getImage().getScaledInstance(25,25, Image.SCALE_DEFAULT));
        menuItemBookBorrow.setIcon(icon);
        menuItemBookBorrow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BorrowBook();
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
