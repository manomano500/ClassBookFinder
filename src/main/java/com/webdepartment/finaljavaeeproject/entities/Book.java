/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webdepartment.finaljavaeeproject.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author mahjouba
 */
@Entity
@Table(name = "books")
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
    @NamedQuery(name = "Book.findByBookId", query = "SELECT b FROM Book b WHERE b.bookId = :bookId"),
    @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title"),
    @NamedQuery(name = "Book.findByAuthor", query = "SELECT b FROM Book b WHERE b.author = :author")})
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "book_id")
    private Integer bookId;
    @Size(max = 255)
    @Column(name = "title")
    private String title;
    @Size(max = 255)
    @Column(name = "author")
    private String author;
    @Lob
    @Column(name = "content")
    private byte[] content;
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    @ManyToOne
    private Department departmentId;
    @JoinColumn(name = "semester_id", referencedColumnName = "semester_Id")
    @ManyToOne
    private Semester semesterId;
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    @ManyToOne
    private Subject subjectId;

    public Book() {
    }

    public Book(Integer bookId) {
        this.bookId = bookId;
    }

    public Book(Integer bookId,String title) {
        this.bookId = bookId;
        this.title = title;
    }
    public Book(Department department, Subject subject, Semester semester) {
        this.subjectId =subject;
        this.semesterId = semester;
        this.departmentId = department;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
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

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
    }

    public Semester getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Semester semesterId) {
        this.semesterId = semesterId;
    }

    public Subject getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Subject subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookId != null ? bookId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.bookId == null && other.bookId != null) || (this.bookId != null && !this.bookId.equals(other.bookId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return title +" ";
    }
    
}
