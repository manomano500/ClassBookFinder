/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.webdepartment.finaljavaeeproject.controllers;

import com.webdepartment.finaljavaeeproject.entities.Book;
import com.webdepartment.finaljavaeeproject.services.BooksService;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author mahjouba
 */

import com.webdepartment.finaljavaeeproject.services.BooksService;
import com.webdepartment.finaljavaeeproject.services.SubjectService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.inject.Inject;
import com.webdepartment.finaljavaeeproject.services.BooksService;
import com.webdepartment.finaljavaeeproject.entities.Subject;
import com.webdepartment.finaljavaeeproject.entities.Subject;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;


public class BooksManagedBean implements Serializable {

    @Inject
    private BooksService booksService;

    @Inject
    private SubjectService subjectService; // Added

    private String book_name;
    private Subject book_subject;

    // ... other methods
    public List<Book> fetchAllBooks() {
        return booksService.getAllBooks();
    }

    public void addBook() {
        Book book = new Book(book_name, book_subject);
        booksService.addBook(book);
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public void setBook_subject(Subject book_subject) {
        this.book_subject = book_subject;
    }

    public String getBook_name() {
        return book_name;
    }

    public Subject getBook_subject() {
        return book_subject;
    }

    public List<Subject> getSubjects() { // New method
        return subjectService.getAllSubjects();
    }
}
