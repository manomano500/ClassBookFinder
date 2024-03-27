/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.webdepartment.finaljavaeeproject.controllers;

import com.webdepartment.finaljavaeeproject.entities.Book;
import com.webdepartment.finaljavaeeproject.entities.Department;
import com.webdepartment.finaljavaeeproject.entities.Semester;
import com.webdepartment.finaljavaeeproject.entities.Subject;
import com.webdepartment.finaljavaeeproject.services.BooksService;
import jakarta.annotation.PostConstruct;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import jdk.jfr.Name;
import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author mahjouba
 */
@Named
@SessionScoped
public class CrudView implements Serializable {

    
    
    
    private String title;
    
    
    
    private String author;

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    
    
    
    
    
    
    
    
    
    
//    private static final long serialVersionUID = 1L;

    private List<Book> books;

    private Book selectedBook;

    private List<Book> selectedBooks;
    private static final Logger logger = Logger.getLogger(CrudView.class.getName());


    @Inject
    private BooksService booksService;
    @Inject
    private UsersManagedBean usersManagedBean;

    public void setUsersManagedBean(UsersManagedBean usersManagedBean) {
        this.usersManagedBean = usersManagedBean;
    }

    public UsersManagedBean getUsersManagedBean() {
        return usersManagedBean;
    }
    public void openNew() {
        selectedBook = new Book();
    }

    //    
    //    @PostConstruct
    //    public void init() {
    //        this.books = this.booksService.getAllBooks();
    //        this.selectedBooks = new ArrayList<>();
    //         
    //
    //   
    //        selectedBook = new Book();
    //    
    ////        this.selectedBook = new Book();
    //
    //    }
    
    @PostConstruct
    public void init() {
        logger.info("Initializing CrudView bean...");
        // Other initialization code
        this.books = this.booksService.getAllBooks();
        this.selectedBooks = new ArrayList<>();
        selectedBook = new Book();
        logger.info("CrudView bean initialized successfully.");
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getSelectedBook() {
        return selectedBook;
    }

    public void setSelectedBook(Book selectedBook) {
        this.selectedBook = new Book( title, author);
    }

    public List<Book> getSelectedBooks() {
        return selectedBooks;
    }

    public void setSelectedBooks(List<Book> selectedBooks) {
        this.selectedBooks = selectedBooks;
    }
//Department department,Subject subject
 
    @Transactional

    public void saveBook() {
        booksService.addBook(selectedBook);
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Book Added"));
//        PrimeFaces.current().executeScript("PF('manageBookDialog').hide()");
//        PrimeFaces.current().ajax().update("form:messages", "form:dt-books");
    }

    public void deleteBook() {
        booksService.deleteBook(selectedBook);
        books.remove(selectedBook);
        selectedBook = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Book Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-books");
    }

    public void handlePdfUpload(FileUploadEvent event) {
        try (InputStream input = event.getFile().getInputStream()) {
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
            selectedBook.setContent(output.toByteArray());
            FacesMessage message = new FacesMessage("PDF uploaded successfully");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (IOException e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error uploading PDF", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            e.printStackTrace();
        }
    }
    // Other methods for handling selection and deletion of multiple books
}
