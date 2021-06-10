package BLL;

import DAO.BookDAO;
import Model.Book;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author cky
 * @Description: TODO
 * @date 2021.05.25 23:06
 */
public class Book_BLL {
    public static void deleteBook(String BookName) throws SQLException {
        new BookDAO().deleteBook(BookName);
    }

    public static void changeBookInformation(String isbn,String bookName,String price,
                                             String author,String publish,String bookDesc,String Id) {
        Book book = new Book();
        book.setBookDesc(bookDesc);
        book.setBookName(bookName);
        book.setAuthor(author);
        book.setIsbn(isbn);
        book.setPublish(publish);
        book.setPrice(Float.parseFloat(price));
        book.setId(Integer.parseInt(Id));
        new BookDAO().updateBook(book);

    }

    public static void addBookInformation(String bookName,String isbn,String bookDesc,String publish,String author,String price) {
        Book book = new Book();
        book.setBookDesc(bookDesc);
        book.setBookName(bookName);
        book.setAuthor(author);
        book.setIsbn(isbn);
        book.setPublish(publish);
        book.setPrice(Float.parseFloat(price));
        new BookDAO().insertBook(book);
    }

    public java.util.ArrayList<Model.Book> select(String filed, String condition) {
        return new BookDAO().selectBook(filed,condition);
    }


    public Object[][] initTable(String[] columnNames) {
        ArrayList<Book> books = new BookDAO().selectBook();
        Object[][] results = new Object[books.size()][columnNames.length];
        int i = 0;
        for (Book b : books){
            results[i][0] = b.getBookName();
            results[i][1] = b.getPublish();
            results[i][2] = b.getAuthor();
            results[i][3] = b.getIsbn();
            results[i][4] = b.getBookDesc();
            results[i][5] = b.getPrice();
            i++;
        }
        return results;
    }
    public Object[][] initTable(String[] columnNames,String field,String condition) {
        ArrayList<Book> books = new BookDAO().selectBook(field,condition);
        Object[][] results = new Object[books.size()][columnNames.length];
        int i = 0;
        for (Book b : books){
            results[i][0] = b.getBookName();
            results[i][1] = b.getPublish();
            results[i][2] = b.getAuthor();
            results[i][3] = b.getIsbn();
            results[i][4] = b.getBookDesc();
            results[i][5] = b.getPrice();
            i++;
        }
        return results;
    }

    public Object[][] initTableID(String[] columnNames) {
        ArrayList<Book> books = new BookDAO().selectBook();
        Object[][] results = new Object[books.size()][columnNames.length];
        int i = 0;
        for (Book b : books){
            results[i][0] = b.getId();
            results[i][1] = b.getBookName();
            results[i][2] = b.getPublish();
            results[i][3] = b.getAuthor();
            results[i][4] = b.getIsbn();
            results[i][5] = b.getBookDesc();
            results[i][6] = b.getPrice();
            i++;
        }
        return results;
    }
}
