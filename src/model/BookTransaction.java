/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author placideh
 */
@Entity
public class BookTransaction implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bTansId;
    private String firstName;
    private String lastName;
    private String bookName;
    private String transType;
    private LocalDate transactionDate;
    private LocalDate returnDate;

    public BookTransaction() {
    }

    public BookTransaction( String firstName, String lastName, String bookName, String transType, LocalDate transactionDate, LocalDate returnDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bookName = bookName;
        this.transType = transType;
        this.transactionDate = transactionDate;
        this.returnDate = returnDate;
    }

    public int getbTansId() {
        return bTansId;
    }

    public void setbTansId(int bTansId) {
        this.bTansId = bTansId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "BookTransaction{" +" firstName=" + firstName + ", lastName=" + lastName + ", bookName=" + bookName + ", transType=" + transType + ", transactionDate=" + transactionDate + ", returnDate=" + returnDate + '}';
    }
    
    
}
