package org.example.userClasses;

import java.io.Serializable;
import org.joda.time.LocalDate;
public class Book implements Serializable {
    private String bookName ;
    private LocalDate dateWhenTook;
    private int days;

    public Book(String bookName, String dateWhenTook, int days){
        super();
        this.bookName = bookName;
        this.dateWhenTook = LocalDate.parse(dateWhenTook);
        this.days = days;
    }

    public void setBookName(String bookName){
        this.bookName = bookName;
    }

    public void setDateWhenTook(String dateWhenTook){
        this.dateWhenTook = LocalDate.parse(dateWhenTook);
    }

    public void setDays(int days){
        this.days = days;
    }

    public String getBookName(){
        return  this.bookName;
    }

    public LocalDate getDateWhenTook(){
        return this.dateWhenTook;
    }

    public int getDays(){
        return this.days;
    }

}
