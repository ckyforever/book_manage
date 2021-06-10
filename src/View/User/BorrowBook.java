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
import java.util.Objects;

/**
 * @author cky
 * @Description: TODO
 * @date 2021.06.03 8:56
 */
public class BorrowBook {
    JFrame frame = new JFrame("用户");
    Container container = frame.getContentPane();

    // 表格
    JTable table;
    // 显示表格的滚动面板
    JScrollPane scrollPane;
    //借书按钮
    JButton buttonBorrow;
    //筛选图书
    JPanel panel;
    JComboBox comboBox;
    JTextField text;
    JButton buttonSelect;

    Object[][] results;

    public BorrowBook() {
        init();
    }

    private void init() {
        frame.setLayout(null);

        // 添加工具栏以及各组件和监听事件
        new UserMenuBar(frame);

        // 设置窗体表格
        setTable();

        panel = new JPanel();

        setCombox();

        text = new JTextField();
        text.setPreferredSize(new Dimension(200, 25));
        text.setSize(50,20);

        setButtonSelect();

        panel.setLayout(new FlowLayout());
        panel.add(text);
        panel.add(buttonSelect);
        panel.setBounds(20,30,700,40);

        buttonBorrow = new JButton("借书");
        setButtonBorrow();
        container.add(panel);
        container.add(buttonBorrow);
        container.add(scrollPane);

        // 设置窗口大小、位置、可视、默认关闭方式等
        new FrameOption(frame);
    }

    private void setButtonSelect() {
        buttonSelect = new JButton("查询");
        buttonSelect.setSize(100,25);
        buttonSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (Objects.requireNonNull(comboBox.getSelectedItem()).toString()){
                    case "图书名称": setSelectTable("bookName",text.getText());break;
                    case"作者": setSelectTable("author",text.getText());break;
                    case "出版社": setSelectTable("publish",text.getText());break;
                    case "ISBN": setSelectTable("isbn",text.getText());break;
                }
            }
        });
    }

    private void setCombox() {
        String[] listData = new String[]{"图书名称","作者","出版社","ISBN"};
        comboBox = new JComboBox<>(listData);
        comboBox.setSize(70, 30);
        comboBox.setSelectedIndex(0);
        panel.add(comboBox);
    }

    private void setButtonBorrow() {
        buttonBorrow.setBounds(580, 390, 100, 25);
        //buttonBorrow.setIcon(new ImageIcon("res/button_return.jpg"));
        buttonBorrow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!new Borrow_BLL().BorrowBook(table.getValueAt(table.getSelectedRow(), 0).toString())) {
                        JOptionPane.showMessageDialog(null, "借书失败", "失败"
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
        String[] columnNames = {"图书名称", "出版社", "作者", "ISBN", "介绍", "价格"};
        results = new Book_BLL().initTable(columnNames);
        table = new JTable(results, columnNames);
        // 设置表格字段居中
        new SetTableColumnCenter(table);
        scrollPane = new JScrollPane(table);
        scrollPane.setViewportView(table);
        scrollPane.setBounds(20, 80, 760, 190);
    }

    private void setSelectTable(String field,String Condition){
        String[] columnNames = {"图书名称", "出版社", "作者", "ISBN", "介绍", "价格"};
        results = new Book_BLL().initTable(columnNames,field,Condition);
        DefaultTableModel tabModel = new DefaultTableModel(results,columnNames);
        table.setModel(tabModel);
        table.setEnabled(true);
    }
}
