/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webdepartment.finaljavaeeproject.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author mahjouba
 */
@Entity
@Table(name = "subjects")
@NamedQueries({
    @NamedQuery(name = "Subject.findAll", query = "SELECT s FROM Subject s"),
    @NamedQuery(name = "Subject.findBySubId", query = "SELECT s FROM Subject s WHERE s.subId = :subId"),
    @NamedQuery(name = "Subject.findBySubName", query = "SELECT s FROM Subject s WHERE s.subName = :subName")})
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sub_id")
    private Integer subId;
    @Size(max = 50)
    @Column(name = "sub_name")
    private String subName;
    @OneToMany(mappedBy = "subId")
    private List<Book> bookList;
    @JoinColumn(name = "sem_id", referencedColumnName = "sem_id")
    @ManyToOne
    private Semester semId;
  
    public Subject() {
    }

    public Subject(Integer subId) {
        this.subId = subId;
    }

    public Subject(String subject_name, Semester sem) {

        this.subName=subject_name;
        this.semId =sem;
    }

  

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Semester getSemId() {
        return semId;
    }

    public void setSemId(Semester semId) {
        this.semId = semId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subId != null ? subId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subject)) {
            return false;
        }
        Subject other = (Subject) object;
        if ((this.subId == null && other.subId != null) || (this.subId != null && !this.subId.equals(other.subId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.webdepartment.finaljavaeeproject.entities.Subject[ subId=" + subId + " ]";
    }
    
    public int getIdAsInt() {
        return (subId != null) ? subId.intValue() : 0;
    }

    public String getSemIdAsString() {
        return (semId != null) ? semId.toString() : "8";
    }
}

