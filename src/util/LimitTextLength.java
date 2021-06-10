package util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * 限定文本框允许输入的字符串长度类
 */
@SuppressWarnings("serial")
public class LimitTextLength extends PlainDocument {
	
	int maxLength;
	
	// 有参构造，参数为文本框输入字符最大长度
	public LimitTextLength(int newMaxLength) {
		super();
		 maxLength = newMaxLength; 		
	}

	/**
	 * 重载父类方法
	 */
	public void insertString(int offset,String str, AttributeSet a) throws BadLocationException{
		if (getLength() + str.length() > maxLength) {
			return;
		} else {
			super.insertString(offset, str, a);
		}
	}
	
	
	
}
