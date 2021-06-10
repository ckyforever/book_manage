/*
 * Created by JFormDesigner on Tue May 25 21:16:20 CST 2021
 */

package View;

import BLL.User_BLL;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author cky
 */
public class Register {
    public Register() {
        initComponents();
    }

    private void register(ActionEvent e) {
        User user = new User();
        user.setName(textname.getText());
        user.setAccount(textaccount.getText());
        user.setPassword(textpass.getText());
        if (new User_BLL().register(user)){
            JOptionPane.showMessageDialog(null,"注册成功","成功"
                    ,JOptionPane.PLAIN_MESSAGE);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        root = new JFrame();
        name = new JPanel();
        label = new JLabel();
        textname = new JTextField();
        rid = new JPanel();
        label3 = new JLabel();
        textaccount = new JTextField();
        password = new JPanel();
        label4 = new JLabel();
        textpass = new JTextField();
        button1 = new JButton();

        //======== root ========
        {
            root.setVisible(true);
            root.setResizable(false);
            root.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Container rootContentPane = root.getContentPane();
            rootContentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));

            //======== name ========
            {
                name.setLayout(new FlowLayout());

                //---- label ----
                label.setText("name");
                name.add(label);

                //---- textname ----
                textname.setPreferredSize(new Dimension(150, 30));
                name.add(textname);
            }
            rootContentPane.add(name);

            //======== rid ========
            {
                rid.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));

                //---- label3 ----
                label3.setText("account");
                rid.add(label3);

                //---- textaccount ----
                textaccount.setPreferredSize(new Dimension(150, 30));
                rid.add(textaccount);
            }
            rootContentPane.add(rid);

            //======== password ========
            {
                password.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));

                //---- label4 ----
                label4.setText("password");
                password.add(label4);

                //---- textpass ----
                textpass.setPreferredSize(new Dimension(150, 30));
                password.add(textpass);
            }
            rootContentPane.add(password);

            //---- button1 ----
            button1.setText("\u6ce8\u518c");
            button1.addActionListener(e -> register(e));
            rootContentPane.add(button1);
            root.setSize(290, 400);
            root.setLocationRelativeTo(root.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JFrame root;
    private JPanel name;
    private JLabel label;
    private JTextField textname;
    private JPanel rid;
    private JLabel label3;
    private JTextField textaccount;
    private JPanel password;
    private JLabel label4;
    private JTextField textpass;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
