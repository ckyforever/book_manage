package View.Admin;

import Model.User;

import javax.swing.*;
import java.awt.*;
/*
 * Created by JFormDesigner on Thu Jun 10 09:42:36 CST 2021
 */



/**
 * @author xuankai
 */
public class EditUserPanel extends JPanel {
    public EditUserPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textFieldAccount = new JTextField();
        label2 = new JLabel();
        textFieldName = new JTextField();
        label3 = new JLabel();
        textFieldPassword = new JTextField();

        //======== this ========
        setLayout(null);

        //---- label1 ----
        label1.setText("account");
        add(label1);
        label1.setBounds(15, 15, 60, 15);
        add(textFieldAccount);
        textFieldAccount.setBounds(80, 15, 75, 20);

        //---- label2 ----
        label2.setText("name");
        add(label2);
        label2.setBounds(15, 55, 60, 15);
        add(textFieldName);
        textFieldName.setBounds(80, 55, 75, 20);

        //---- label3 ----
        label3.setText("password");
        add(label3);
        label3.setBounds(15, 90, 70, 15);
        add(textFieldPassword);
        textFieldPassword.setBounds(80, 90, 75, 20);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < getComponentCount(); i++) {
                Rectangle bounds = getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            setMinimumSize(preferredSize);
            setPreferredSize(preferredSize);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textFieldAccount;
    private JLabel label2;
    private JTextField textFieldName;
    private JLabel label3;
    private JTextField textFieldPassword;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public User get(){
        User user = new User();
        user.setAccount(String.valueOf(textFieldAccount.getText()));
        user.setPassword(String.valueOf(textFieldPassword.getText()));
        user.setName(String.valueOf(textFieldName.getText()));
        return user;
    }
    public void set(User user){
        textFieldAccount.setText(user.getAccount());
        textFieldName.setText(user.getName());
        textFieldPassword.setText(user.getPassword());
    }
}
