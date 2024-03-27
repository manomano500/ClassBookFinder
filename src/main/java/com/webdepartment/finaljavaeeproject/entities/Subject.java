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
    @NamedQuery(name = "Subject.findBySubjectId", query = "SELECT s FROM Subject s WHERE s.subjectId = :subjectId"),
    @NamedQuery(name = "Subject.findBySubjectName", query = "SELECT s FROM Subject s WHERE s.subjectName = :subjectName"),
    @NamedQuery(name = "Subject.findByCode", query = "SELECT s FROM Subject s WHERE s.code = :code"),
    @NamedQuery(name = "Subject.findByUnit", query = "SELECT s FROM Subject s WHERE s.unit = :unit")})
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "subject_id")
    private Integer subjectId;
    @Size(max = 255)
    @Column(name = "subject_name")
    private String subjectName;
    @Size(max = 10)
    @Column(name = "code")
    private String code;
    @Column(name = "unit")
    private Integer unit;
    @OneToMany(mappedBy = "subjectId")
    private List<Book> bookList;
    @JoinColumn(name = "semester_id", referencedColumnName = "semester_Id")
    @ManyToOne
    private Semester semesterId;
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    @ManyToOne
    private Department departmentId;

    public Subject() {
    }

    public Subject(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Semester getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Semester semesterId) {
        this.semesterId = semesterId;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subjectId != null ? subjectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subject)) {
            return false;
        }
        Subject other = (Subject) object;
        if ((this.subjectId == null && other.subjectId != null) || (this.subjectId != null && !this.subjectId.equals(other.subjectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return subjectName +"";
    }
    
}
