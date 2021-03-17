/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author placideh
 */
@Entity
public class Book implements Serializable {
    @Id
    private String bookId;
    private String title;
    private String author;
    private String publishingHouse;
    private LocalDate publicationDate;
    private int pages;
    private boolean available;
    private String  bookCategory;

    public Book() {
    }

    public Book(String bookId, String title, String author, String publishingHouse, LocalDate publicationDate, int pages, boolean available, String bookCategory) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.publicationDate = publicationDate;
        this.pages = pages;
        this.available = available;
        this.bookCategory = bookCategory;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    @Override
    public String toString() {
        return "Book{" + "bookId=" + bookId + ", title=" + title + ", author=" + author + ", publishingHouse=" + publishingHouse + ", publicationDate=" + publicationDate + ", pages=" + pages + ", available=" + available + ", bookCategory=" + bookCategory + '}';
    }
    
    
    
}
