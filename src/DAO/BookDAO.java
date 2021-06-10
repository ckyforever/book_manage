package DAO;

import Model.Book;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author cky
 * @Description: Book读写数据库的实现
 * @date 2021.05.24 23:12
 */
public class BookDAO {

    public ArrayList<Book> selectBook() {
        DataMysql dataMysql = DataMysql.INSTANCE;
        String sql = "select * from book";
        ArrayList<Book> bookList = null;
        bookList = dataMysql.query(Book.class, sql);
        return bookList;
    }

    public ArrayList<Book> selectBook(String field, String condition) {
        DataMysql dataMysql = DataMysql.INSTANCE;
        StringBuilder a = new StringBuilder(new String(""));
        for(int i = 0;i < condition.length();i++){
            a.append("%");
            a.append(condition.charAt(i));
        }
        a.append("%");
        String sql = "select * from book" + " where " + field + " like '" + a +"'";
        ArrayList<Book> bookList = null;
        bookList = dataMysql.query(Book.class, sql);
        return bookList;
    }

    public void insertBook(Book book) {
        //DataMysql.INSTANCE.insert(book);
        String sql = "insert into book (bookName,publish,author,isbn,bookDesc,price)values('" +
                book.getBookName()+"','" +
                book.getPublish()+"','" +
                book.getAuthor()+"','" +
                book.getIsbn()+"','" +
                book.getBookDesc()+"'," +
                book.getPrice()+")";
        DataMysql.INSTANCE.executeSql(sql);
    }

    public void updateBook(Book book) {
        DataMysql dataMysql = DataMysql.INSTANCE;
        String sql = "update book set bookName='" + book.getBookName() +
                "',publish='" + book.getPublish() +
                "',author='" + book.getAuthor() +
                "',isbn='" + book.getIsbn() +
                "',price=" + book.getPrice() +
                ",bookDesc='" + book.getBookDesc() +
                "' where Id = " + book.getId();
        dataMysql.executeSql(sql);
//        dataMysql.update(book);
    }

    public void deleteBook(String bookName) throws SQLException {
        DataMysql dataMysql = DataMysql.INSTANCE;
        String sql = "delete from book where bookName ='" + bookName + "'";
        dataMysql.executeSql(sql);
    }
}
