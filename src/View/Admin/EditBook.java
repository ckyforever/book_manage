package View.Admin;

import BLL.Book_BLL;
import util.FrameOption;
import util.SetTableColumnCenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

/**
 * @author cky
 * @Description: TODO
 * @date 2021.06.03 15:18
 */
public class EditBook {
    JFrame frame = new JFrame("管理员");
    Container container = frame.getContentPane();

    // 表格
    JTable table;
    // 显示表格的滚动面板
    JScrollPane scrollPane;

    Object[][] results;

    // 增加、删除、修改按钮
    JButton buttonAdd, buttonDel, buttonChange,buttonReset;

    EditBookPanel editPanel;

    public static void main(String[] args){
        new EditBook();
    }
    EditBook(){

        frame.setLayout(null);

        // 添加工具栏以及各组件和监听事件
        new AdminMenuBar(frame);
        setTable();

        editPanel = new EditBookPanel();
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

    private void setTextId() {
    }

    private void setTable(){
        String[] columnNames = {"Id","图书名称", "出版社", "作者", "ISBN", "介绍", "价格"};
        results = new Book_BLL().initTableID(columnNames);
        table = new JTable(results, columnNames);
        // 设置表格字段居中
        new SetTableColumnCenter(table);
        scrollPane = new JScrollPane(table);
        scrollPane.setViewportView(table);
        scrollPane.setBounds(20, 30, 760, 190);
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                editPanel.setTextFieldPublish(table.getValueAt(table.getSelectedRow(),2).toString());
                editPanel.setTextFieldISBN(table.getValueAt(table.getSelectedRow(),4).toString());
                editPanel.setTextFieldAuthor(table.getValueAt(table.getSelectedRow(),3).toString());
                editPanel.setTextFieldBooKDesc(table.getValueAt(table.getSelectedRow(),5).toString());
                editPanel.setTextFieldBookName(table.getValueAt(table.getSelectedRow(),1).toString());
                editPanel.setTextFieldPrice(table.getValueAt(table.getSelectedRow(),6).toString());
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


    /**
     * 设置修改按钮
     */
    private void setButtonChange() {
        buttonChange.setBounds(470,390,60,25);
        buttonChange.setIcon(new ImageIcon("res/button_change.jpg"));
        buttonChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Book_BLL.changeBookInformation(editPanel.getTextFieldISBN(),editPanel.getTextFieldBookName(),
                            editPanel.getTextFieldPrice(),editPanel.getTextFieldAuthor(),editPanel.getTextFieldPublish(),
                            editPanel.getTextFieldBooKDesc(), table.getValueAt(table.getSelectedRow(),0).toString());
                    frame.setVisible(false);
                    new EditBook();
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
                try {
                    Book_BLL.deleteBook(table.getValueAt(table.getSelectedRow(),1).toString());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    JOptionPane.showMessageDialog(null,"删除图书失败","错误"
                            , JOptionPane.PLAIN_MESSAGE);
                }
                frame.setVisible(false);
                new EditBook();
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
                editPanel.setTextFieldAuthor("");
                editPanel.setTextFieldBooKDesc("");
                editPanel.setTextFieldBookName("");
                editPanel.setTextFieldISBN("");
                editPanel.setTextFieldPrice("");
                editPanel.setTextFieldPublish("");
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
                if(editPanel.getTextFieldISBN().length() == 0) {
                    JOptionPane.showMessageDialog(null,"ISBN号不能为空","错误"
                            , JOptionPane.PLAIN_MESSAGE);
                }

                else if(editPanel.getTextFieldISBN().length() != 17) {
                    JOptionPane.showMessageDialog(null,"ISBN号位数必须是13位","错误"
                            , JOptionPane.PLAIN_MESSAGE);
                }
                else if(editPanel.getTextFieldBookName().length() == 0) {
                    JOptionPane.showMessageDialog(null, "图书名称不能为空", "错误"
                            , JOptionPane.PLAIN_MESSAGE);
                }
                else if(editPanel.getTextFieldAuthor().length() == 0) {
                    JOptionPane.showMessageDialog(null, "图书作者不能为空", "错误"
                            , JOptionPane.PLAIN_MESSAGE);
                }
                else if(editPanel.getTextFieldPrice().length() == 0) {
                    JOptionPane.showMessageDialog(null, "图书价格不能为空", "错误"
                            , JOptionPane.PLAIN_MESSAGE);
                }
                else if(editPanel.getTextFieldPublish().length() == 0) {
                    JOptionPane.showMessageDialog(null, "出版社不能为空", "错误"
                            , JOptionPane.PLAIN_MESSAGE);
                }
                else if(editPanel.getTextFieldPrice().length() > 4) {
                    JOptionPane.showMessageDialog(null, "图书价格不能超过4位数", "错误"
                            , JOptionPane.PLAIN_MESSAGE);
                }
                else {
                    try {
                        Book_BLL.addBookInformation(editPanel.getTextFieldBookName(),editPanel.getTextFieldISBN(),
                                editPanel.getTextFieldBooKDesc(),editPanel.getTextFieldPublish(),editPanel.getTextFieldAuthor(),
                                editPanel.getTextFieldPrice());
                        frame.setVisible(false);
                        new EditBook();
                    }catch(Exception e1) {
                        e1.printStackTrace();
                        JOptionPane.showMessageDialog(null, "图书添加失败", "错误"
                                , JOptionPane.PLAIN_MESSAGE);
                    }
                }

            }
        });
    }
}
