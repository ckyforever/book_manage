package View;

import BLL.Admin_BLL;
import BLL.User_BLL;
import Model.Admin;
import util.Config;
import util.KeyListener;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

/**
 * @author cky
 * @Description: TODO
 * @date 2021.05.24 22:13
 */
public class Login {
    JTextField text_name;
    JPasswordField text_password;
    JFrame frame;
    JComboBox<String> comboBox;
    int i = 3;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //在主函数中，实例化Login类的对象，调用初始化界面的方法
        Login login = new Login();
        login.initUI();
    }

    public void initUI() {
        //在initUI中实例化JFrame类的对象
        frame = new JFrame();
        //设置窗体对象的属性值
        frame.setTitle("Login");//设置窗体标题
        frame.setSize(400, 250);//设置窗体大小，只对顶层容器生效
        frame.setDefaultCloseOperation(3);//设置窗体关闭操作，3表示关闭窗体退出程序
        frame.setLocationRelativeTo(null);//设置窗体相对于另一组间的居中位置，参数null表示窗体相对于屏幕的中央位置
        frame.setResizable(false);//禁止调整窗体大小
        frame.setFont(new Font("宋体", Font.PLAIN, 14));//设置字体，显示格式正常，大小

        //实例化用户选择的身份（管理员或者学生）
        JPanel choose = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel label = new JLabel("用户类型");
        choose.add(label);
        String[] listData = new String[]{"管理员", "用户"};
        comboBox = new JComboBox<>(listData);
        comboBox.setSize(70, 30);
        comboBox.setSelectedIndex(1);
        choose.add(comboBox);

        //实例化FlowLayout流式布局类的对象，指定对齐方式为居中对齐组件之间的间隔为10个像素
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 15, 10);
        //实例化流式布局类的对象
        frame.setLayout(fl);

        frame.add(choose);
        //实例化JLabel标签对象，该对象显示“账号”
        JLabel labname = new JLabel("账号：");
        labname.setFont(new Font("宋体", Font.PLAIN, 14));
        //将labname标签添加到窗体上

        //实例化JTextField标签对象化
        text_name = new JTextField();
        Dimension dim1 = new Dimension(250, 30);
        text_name.setPreferredSize(dim1);//设置除顶级容器组件以外其他组件的大小
        //将textName标签添加到窗体上
        JPanel name = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        name.add(labname);
        name.add(text_name);
        frame.add(name);

        //实例化JLabel标签对象，该对象显示“密码”
        JLabel labpass = new JLabel("密码：");
        labpass.setFont(new Font("宋体", Font.PLAIN, 14));
        //将labpass添加到窗体上


        //实例化JPasswordField
        text_password = new JPasswordField();
        //设置大小
        text_password.setPreferredSize(dim1);
        //添加到窗体

        JPanel password = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        password.add(labpass);
        password.add(text_password);
        frame.add(password);

        //实例化JButton组件
        JButton button1 = new JButton();
        //设置按键的显示内容
        Dimension dim2 = new Dimension(100, 30);
        button1.setText("登录");
        button1.setFont(new Font("宋体", Font.PLAIN, 14));
        //设置按键大小
        button1.setSize(dim2);
        frame.add(button1);
        new KeyListener(text_name,button1);
        new KeyListener(text_password,button1);

        JButton button2 = new JButton();
        //设置按键的显示内容
        button2.setText("注册");
        button2.setFont(new Font("宋体", Font.PLAIN, 14));
        //设置按键大小
        button2.setSize(dim2);
        frame.add(button2);

        frame.setVisible(true);//窗体可见，一定要放在所有组件加入窗体后

        button1.addActionListener(e -> {
            try {
                login();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        });
        button2.addActionListener(e -> register());
    }

    private void register() {
        new Register();
    }

    private void login() throws SQLException {
        if (comboBox.getSelectedIndex() == 0) {
            if (new Admin_BLL().login(new Admin(text_name.getText(), new String(text_password.getPassword())))) {
                frame.dispose();
                new View.Admin.MainFrame();
                Config.account = text_name.getText().trim();
                Config.passWord = String.valueOf(text_password.getPassword());
            } else if (i >= 2) {
                new Notice("账号或密码错误,您今天还有" + (i - 1) + "次机会");
                i--;
            } else if (i == 1) {
                new Notice("账号已锁定，请明天再试");
                frame.dispose();
            }
        } else{
            if (new User_BLL().login(text_name.getText(),new  String(text_password.getPassword()))) {
                frame.dispose();
                new View.User.MainFrame();
                Config.account = text_name.getText().trim();
                Config.passWord = String.valueOf(text_password.getPassword());
            } else if (i >= 2) {
                new Notice("账号或密码错误,您今天还有" + (i - 1) + "次机会");
                i--;
            } else if (i == 1) {
                new Notice("账号已锁定，请明天再试");
                frame.dispose();
            }
        }

    }

}
