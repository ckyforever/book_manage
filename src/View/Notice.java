package View;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author cky
 * @Description: TODO
 * @date 2021.05.25 19:06
 */
public class Notice extends JFrame {
    public Notice(String message) {
        init(message);
        this.setSize(400, 200);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);
        this.setFont(new Font("宋体", Font.PLAIN, 14));  //宋体，正常风格，14号字体
        this.setResizable(false);
        this.setVisible(true);
    }

    private void init(String message) {
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        Dimension dim3 = new Dimension(300, 30);
        JLabel messageLabel = new JLabel(message);
        messageLabel.setFont(new Font("宋体", Font.PLAIN, 14));  //宋体，正常风格，14号字体
        messageLabel.setPreferredSize(dim3);
        jp1.add(messageLabel);
        this.add(jp1, BorderLayout.CENTER);

        JButton close = new JButton("确定");
        close.setFont(new Font("宋体", Font.PLAIN, 14));
        //设置按键大小
        close.setSize(dim3);
        jp2.add(close);
        this.add(jp2, BorderLayout.SOUTH);
        close.addActionListener(e -> close());
    }

    private void close() {
        this.dispose();
    }
}
