package View.Admin;

import util.BackgroundImage;
import util.FrameOption;

import javax.swing.*;
import java.awt.*;

/**
 * @author cky
 * @Description: TODO
 * @date 2021.06.02 6:23
 */
public class MainFrame {
    JFrame frame = new JFrame("管理员");
    Container container = frame.getContentPane();

    public MainFrame() {

        // 设置背景图片
        new BackgroundImage(frame,container,"mainFrame.jpg");
        // 添加工具栏以及各组件和监听事件
        new AdminMenuBar(frame);

        // 设置窗口大小、位置、可视、默认关闭方式等
        new FrameOption(frame);
    }
}
