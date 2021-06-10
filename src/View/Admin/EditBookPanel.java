package View.Admin;

import javax.swing.*;
import java.awt.*;
/*
 * Created by JFormDesigner on Fri Jun 04 14:04:01 CST 2021
 */



/**
 * @author xuankai
 */
public class EditBookPanel extends JPanel {
    public EditBookPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textFieldBookName = new JTextField();
        textFieldISBN = new JTextField();
        label2 = new JLabel();
        textFieldPrice = new JTextField();
        label3 = new JLabel();
        textFieldAuthor = new JTextField();
        label4 = new JLabel();
        textFieldPublish = new JTextField();
        label5 = new JLabel();
        textFieldBookDesc = new JTextField();
        label6 = new JLabel();

        //======== this ========
        setLayout(null);

        //---- label1 ----
        label1.setText("\u4e66\u540d");
        add(label1);
        label1.setBounds(new Rectangle(new Point(25, 40), label1.getPreferredSize()));
        add(textFieldBookName);
        textFieldBookName.setBounds(55, 35, 100, 25);
        add(textFieldISBN);
        textFieldISBN.setBounds(210, 40, 105, 25);

        //---- label2 ----
        label2.setText("ISBN");
        add(label2);
        label2.setBounds(175, 40, 40, 20);
        add(textFieldPrice);
        textFieldPrice.setBounds(370, 40, 85, 25);

        //---- label3 ----
        label3.setText("\u4ef7\u683c");
        add(label3);
        label3.setBounds(340, 45, 40, 17);
        add(textFieldAuthor);
        textFieldAuthor.setBounds(55, 70, 100, 25);

        //---- label4 ----
        label4.setText("\u4f5c\u8005");
        add(label4);
        label4.setBounds(25, 75, 40, 17);
        add(textFieldPublish);
        textFieldPublish.setBounds(210, 70, 110, 25);

        //---- label5 ----
        label5.setText("\u51fa\u7248\u793e");
        add(label5);
        label5.setBounds(170, 75, 50, 20);
        add(textFieldBookDesc);
        textFieldBookDesc.setBounds(50, 110, 320, 35);

        //---- label6 ----
        label6.setText("\u4ecb\u7ecd");
        add(label6);
        label6.setBounds(20, 115, 40, 17);

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
    private JTextField textFieldBookName;
    private JTextField textFieldISBN;
    private JLabel label2;
    private JTextField textFieldPrice;
    private JLabel label3;
    private JTextField textFieldAuthor;
    private JLabel label4;
    private JTextField textFieldPublish;
    private JLabel label5;
    private JTextField textFieldBookDesc;
    private JLabel label6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public String getTextFieldBookName() {
        return textFieldBookName.getText();
    }

    public void setTextFieldBookName(String textFieldBookName) {
        this.textFieldBookName.setText(textFieldBookName);
    }

    public String getTextFieldISBN() {
        return textFieldISBN.getText();
    }

    public void setTextFieldISBN(String textFieldISBN) {
        this.textFieldISBN.setText(textFieldISBN);
    }

    public String getTextFieldPrice() {
        return textFieldPrice.getText();
    }

    public void setTextFieldPrice(String textFieldPrice) {
        this.textFieldPrice.setText(textFieldPrice);
    }

    public String getTextFieldAuthor() {
        return textFieldAuthor.getText();
    }

    public void setTextFieldAuthor(String textFieldAuthor) {
        this.textFieldAuthor.setText(textFieldAuthor);
    }

    public String getTextFieldPublish() {
        return textFieldPublish.getText();
    }

    public void setTextFieldPublish(String textField5) {
        this.textFieldPublish.setText(textField5);
    }

    public String getTextFieldBooKDesc() {
        return textFieldBookDesc.getText();
    }

    public void setTextFieldBooKDesc(String textFieldBookDesc) {
        this.textFieldBookDesc.setText(textFieldBookDesc);
    }
}
