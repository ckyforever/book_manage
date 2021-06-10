package View.User;

import BLL.Book_BLL;
import BLL.Borrow_BLL;
import util.FrameOption;
import util.SetTableColumnCenter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author cky
 * @Description: TODO
 * @date 2021.06.03 8:09
 */
public class ReturnBook {

    JFrame frame = new JFrame("用户");
    Container container = frame.getContentPane();

    // 表格
    JTable table;
    // 显示表格的滚动面板
    JScrollPane scrollPane;
    //还书按钮
    JButton returnBook;
    //筛选未还
    JButton selectNot;
    //筛选已还
    JButton selectYes;

    public ReturnBook(){
        init();
    }
    private void init(){
        frame.setLayout(null);

        // 添加工具栏以及各组件和监听事件
        new UserMenuBar(frame);

        // 设置窗体表格
        setTable();
        returnBook = new JButton("还书");
        selectNot = new JButton("查找未还");
        selectYes = new JButton("查找已还");
        setReturnBook();
        setSelectNot();
        setSelectYes();
        container.add(scrollPane);
        container.add(returnBook);

        // 设置窗口大小、位置、可视、默认关闭方式等
        new FrameOption(frame);
    }

    private void setSelectYes() {
        selectYes.setBounds(450,390,100,25);
        selectYes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTableYes();
            }
        });
    }

    private void setTableYes() {
        String[] columnNames = {"图书名称","用户名","时间","状态"};
        Object[][] results = new Book_BLL().initTable(columnNames,"status","归还");
        DefaultTableModel tabModel = new DefaultTableModel(results,columnNames);
        table.setModel(tabModel);
        table.setEnabled(true);
    }

    private void setSelectNot() {
        selectYes.setBounds(300,390,100,25);
        selectNot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTableNot();
            }
        });
    }

    private void setTableNot() {
        String[] columnNames = {"图书名称","用户名","时间","状态"};
        Object[][] results = new Book_BLL().initTable(columnNames,"status","未还");
        DefaultTableModel tabModel = new DefaultTableModel(results,columnNames);
        table.setModel(tabModel);
        table.setEnabled(true);
    }

    private void setReturnBook() {
        returnBook.setBounds(580, 390, 100, 25);
        //buttonBorrow.setIcon(new ImageIcon("res/button_return.jpg"));
        returnBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!new Borrow_BLL().returnBook(table.getValueAt(table.getSelectedRow(), 0).toString())) {
                        JOptionPane.showMessageDialog(null, "还书失败", "失败"
                                , JOptionPane.PLAIN_MESSAGE);
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "请先选中要归还的表格项", "错误"
                            , JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
    }

    private void setTable() {
        String[] columnNames = {"图书名称","用户名","时间","状态"};
        Object[][] results = new Borrow_BLL().initTable(columnNames);
        table = new JTable(results,columnNames);
        // 设置表格字段居中
        new SetTableColumnCenter(table);
        scrollPane = new JScrollPane(table);
        scrollPane.setViewportView(table);
        scrollPane.setBounds(20,80,760,190);
    }

}
