package org.example.userClasses;
import java.io.Serializable;

public class Readers implements Serializable {
    private String surname;
    private String name;
    private String address;
    private Book[]books;//problems
    private int numOfBooks;
    private int amountOfBook;

    public Readers(String name, String surname, String address, int amountOfBook){
        super();
        this.amountOfBook = amountOfBook;
        this.numOfBooks = 0;
        this.surname = surname;
        this.name = name;
        this.address = address;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAddress (String address) {
        this.address = address;
    }

    public void setBooks (String bookName, String dateWhenTook, int days) {
        if (this.books == null) {
            this.books = new Book[this.amountOfBook];
            this.books[0] = new Book(bookName,dateWhenTook,days);
        }
        else
            this.books[this.numOfBooks]  = new Book(bookName,dateWhenTook,days);
        numOfBooks++;
    }

    public String getSurname(){
        return this.surname;
    }

    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

    public Book[] getBook(){
        return this.books;
    }

    public int getNumOfBooks(){
        return this.numOfBooks;
    }


    public String toString () {
        String ret =
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'';

        for (int i = 0; i < this.numOfBooks; i++){
            ret = ret + '\n' + " book: '" + books[i].getBookName() + '\'' +
                    " Date when took: '" + books[i].getDateWhenTook() + '\'' +
                    " Days: '" + books[i].getDays() + '\'';
        }
    return ret;
    }
}