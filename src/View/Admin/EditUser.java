package View.Admin;

import BLL.Book_BLL;
import util.FrameOption;
import util.SetTableColumnCenter;

import javax.swing.*;
import java.awt.*;
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
    private void setTable(){
        String[] columnNames = {"Id","账户","",""};
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
//                editPanel.setTextFieldAccount(table.getValueAt(table.getSelectedRow(),2).toString());
//                editPanel.setTextFieldISBN(table.getValueAt(table.getSelectedRow(),4).toString());
//                editPanel.setTextFieldAuthor(table.getValueAt(table.getSelectedRow(),3).toString());
//                editPanel.setTextFieldBooKDesc(table.getValueAt(table.getSelectedRow(),5).toString());
//                editPanel.setTextFieldBookName(table.getValueAt(table.getSelectedRow(),1).toString());
//                editPanel.setTextFieldPrice(table.getValueAt(table.getSelectedRow(),6).toString());
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
}
