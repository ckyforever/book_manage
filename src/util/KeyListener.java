package util;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author cky
 * @Description: 键盘事件类，按下回车则模拟鼠标点击登录、确认按钮（用在登录窗体和更改密码窗体）
 * @date 2021.06.02 6:14
 */
public class KeyListener {
    public KeyListener(JTextField text,final JButton button) {

        // 键盘事件，如果按下回车则模拟鼠标点击登录按钮
        text.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent paramKeyEvent) {
                if(paramKeyEvent.getKeyChar()=='\n'){
                    button.doClick();
                }
            }
        });
    }

    public KeyListener(JPasswordField passwd,final JButton button) {
        // 键盘事件，如果按下回车则模拟鼠标点击登录按钮
        passwd.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent paramKeyEvent) {
                if(paramKeyEvent.getKeyChar()=='\n'){
                    button.doClick();
                }
            }
        });
    }
}
