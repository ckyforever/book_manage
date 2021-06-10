package View.Admin;

import BLL.Admin_BLL;
import View.Login;
import util.BackgroundImage;
import util.FrameOption;
import util.KeyListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @author cky
 * @Description: TODO
 * @date 2021.06.03 15:01
 */
public class ChangeAdminInformation {
    JFrame frame = new JFrame("管理员");
    Container container = frame.getContentPane();

    private JTextField textFieldUserName = new JTextField();
    private JTextField textFieldPasswd = new JTextField();
    private JButton buttonYes = new JButton();
    private JButton buttonReset = new JButton();

    public ChangeAdminInformation() {

        frame.setLayout(null);

        // 设置背景图片
        new BackgroundImage(frame,container,"changeUser.jpg");
        // 添加工具栏以及各组件和监听事件
        new AdminMenuBar(frame);

        // 用户名框
        setUserTextField();
        // 密码框
        setPasswordField();
        // 确认按钮
        setButtonYes();
        // 重置按钮
        setButtonReset();


        container.add(textFieldPasswd);
        container.add(textFieldUserName);
        container.add(buttonReset);
        container.add(buttonYes);

        // 设置窗口大小、位置、可视、默认关闭方式等
        new FrameOption(frame);
    }



    /**
     * 设置重置按钮
     */
    private void setButtonReset() {
        buttonReset.setIcon(new ImageIcon("res/button_reset.jpg"));
        buttonReset.setBounds(420,325,90,30);
        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                textFieldUserName.setText("");
                textFieldPasswd.setText("");
            }
        });
    }


    /**
     * 设置确认按钮，添加操作数据库更改用户名密码事件
     */
    public void setButtonYes(){
        buttonYes.setIcon(new ImageIcon("res/button_ok.jpg"));
        buttonYes.setBounds(200,325,90,30);
        buttonYes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                Admin_BLL AdminAction = new Admin_BLL();
                try {
                    AdminAction.edit(textFieldUserName,textFieldPasswd);
                    JOptionPane.showMessageDialog(null,"用户名和密码修改成功","成功"
                            ,JOptionPane.PLAIN_MESSAGE);
                    frame.setVisible(false);
                    new Login().initUI();
                } catch (SQLException throwables) {
                    JOptionPane.showMessageDialog(null,"用户名和密码修改失败","失败"
                            ,JOptionPane.PLAIN_MESSAGE);
                    throwables.printStackTrace();
                }

            }
        });
    }

    /**
     * 设置密码框
     */
    public void setPasswordField() {
        textFieldPasswd.setBounds(380,235,200,30);
        new KeyListener(textFieldPasswd,buttonYes);
    }

    /**
     * 用户框
     */
    public void setUserTextField() {
        textFieldUserName.setBounds(380,145,200,30);
        new KeyListener(textFieldUserName,buttonYes);
    }
}
