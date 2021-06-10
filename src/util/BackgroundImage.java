package util;

import javax.swing.*;
import java.awt.*;

/**
 * 设置背景图片类
 */
public class BackgroundImage {
	
	public BackgroundImage(JFrame frame, Container container, String ImageName) {
		// 限定加载图片路径
		ImageIcon icon= new ImageIcon("res/" + ImageName);	
		
		final JLabel labelBackground = new JLabel();
		ImageIcon iconBookManageSystemBackground = icon;
		labelBackground.setIcon(iconBookManageSystemBackground);
		// 设置label的大小
		labelBackground.setBounds(0,0,iconBookManageSystemBackground.getIconWidth()
				,iconBookManageSystemBackground.getIconHeight());		
		// 将背景图片标签放入桌面面板的最底层
		frame.getLayeredPane().add(labelBackground,new Integer(Integer.MIN_VALUE));
		// 将容器转换为面板设置为透明
		JPanel panel = (JPanel)container;
		panel.setOpaque(false);
		
	}
	

}
