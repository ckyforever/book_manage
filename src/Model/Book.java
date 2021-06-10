package Model;

import DAO.InsertRequired;
import DAO.PrimaryKey;

/**
 * @author cky
 * @Description: 基本类Book
 * @date 2021.05.24 13:24
 */
public class Book {
    @PrimaryKey
    private int Id;
    @InsertRequired
    private String bookName;
    @InsertRequired
    private String publish;
    @InsertRequired
    private String author;
    @InsertRequired
    private String isbn;
    @InsertRequired
    private String bookDesc;
    @InsertRequired
    private float price;

    public Book(){}

    public Book(int id, String bookName, String publish, String author, String isbn, String bookDesc, float price) {
        Id = id;
        this.bookName = bookName;
        this.publish = publish;
        this.author = author;
        this.isbn = isbn;
        this.bookDesc = bookDesc;
        this.price = price;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String get(String filed){
        switch (filed){
            case "Id" : return String.valueOf(this.getId());
            case "bookName" : return this.getBookName();
            case "publish" : return this.getPublish();
            case "author" : return this.getAuthor();
            case "isbn" : return this.getIsbn();
            case "bookDesc" : return this.getBookDesc();
            case "price" : return String.valueOf(this.getPrice());
            default:return null;
        }
    }

}
