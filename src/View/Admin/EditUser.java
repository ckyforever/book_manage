package View.Admin;

import BLL.User_BLL;
import Model.User;
import util.FrameOption;
import util.SetTableColumnCenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author cky
 * @Description: TODO
 * @date 2021.06.03 15:19
 */
public class EditUser {
    JFrame frame = new JFrame("管理员");
    Container container = frame.getContentPane();

    // 表格
    JTable table;
    // 显示表格的滚动面板
    JScrollPane scrollPane;

    Object[][] results;

    // 增加、删除、修改按钮
    JButton buttonAdd, buttonDel, buttonChange,buttonReset;

    EditUserPanel editPanel;
    public static void main(String[] args){
        new EditUser();
    }
    public EditUser(){
        frame.setLayout(null);

        // 添加工具栏以及各组件和监听事件
        new AdminMenuBar(frame);
        setTable();

        editPanel = new EditUserPanel();
        buttonChange = new JButton();
        buttonAdd = new JButton();
        buttonDel = new JButton();
        buttonReset = new JButton();
        setEditPanel();
        setButtonChange();
        setButtonAdd();
        setButtonDel();
        setButtonReset();

        container.add(buttonAdd);
        container.add(buttonChange);
        container.add(buttonDel);
        container.add(buttonReset);
        container.add(scrollPane);
        container.add(editPanel);

        new FrameOption(frame);
    }
    private void setEditPanel() {
        editPanel.setBounds(0,200,600,400);
    }
    private void setTable(){
        String[] columnNames = {"Id","账户","姓名","密码"};
        results = new User_BLL().initTableID(columnNames);
        table = new JTable(results, columnNames);
        // 设置表格字段居中
        new SetTableColumnCenter(table);
        scrollPane = new JScrollPane(table);
        scrollPane.setViewportView(table);
        scrollPane.setBounds(20, 30, 760, 190);
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                User user = new User();
                user.setAccount(table.getValueAt(table.getSelectedRow(),1).toString());
                user.setName(table.getValueAt(table.getSelectedRow(),2).toString());
                user.setPassword(table.getValueAt(table.getSelectedRow(),3).toString());
                editPanel.set(user);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
    private void setButtonChange() {
        buttonChange.setBounds(470,390,60,25);
        buttonChange.setIcon(new ImageIcon("res/button_change.jpg"));
        buttonChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    User user = editPanel.get();
                    user.setId((Integer) table.getValueAt(table.getSelectedRow(),0));
                    User_BLL.changeUserInformation(user);
                    frame.setVisible(false);
                    new EditUser();
                }catch(Exception e1) {
                    JOptionPane.showMessageDialog(null,"表中没有该数据","错误"
                            , JOptionPane.PLAIN_MESSAGE);
                }

            }
        });
    }


    /**
     * 设置删除按钮
     */
    private void setButtonDel() {
        buttonDel.setBounds(580,390,60,25);
        buttonDel.setIcon(new ImageIcon("res/button_del.jpg"));
        buttonDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                User_BLL.deleteUser((Integer) table.getValueAt(table.getSelectedRow(),0));
                frame.setVisible(false);
                new EditUser();
            }
        });
    }

    /**
     * 设置文本框重置按钮
     */
    private void setButtonReset() {
        buttonReset.setBounds(270,390,150,25);
        buttonReset.setIcon(new ImageIcon("res/button_textReset.jpg"));
        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                editPanel.set(new User());
            }
        });
    }


    /**
     * 设置添加按钮
     */
    private void setButtonAdd() {
        buttonAdd.setBounds(700,390,60,25);
        buttonAdd.setIcon(new ImageIcon("res/button_add.jpg"));
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                    try {
                        User_BLL.addUser(editPanel.get());
                        frame.setVisible(false);
                        new EditUser();
                    }catch(Exception e1) {
                        e1.printStackTrace();
                        JOptionPane.showMessageDialog(null, "用户添加失败", "错误"
                                , JOptionPane.PLAIN_MESSAGE);
                    }
                }

        });
    }
}
