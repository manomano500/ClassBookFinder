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
@Table(name = "semesters")
@NamedQueries({
    @NamedQuery(name = "Semester.findAll", query = "SELECT s FROM Semester s"),
    @NamedQuery(name = "Semester.findBySemId", query = "SELECT s FROM Semester s WHERE s.semId = :semId"),
    @NamedQuery(name = "Semester.findBySemName", query = "SELECT s FROM Semester s WHERE s.semName = :semName")})
public class Semester implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sem_id")
    private Integer semId;
    @Size(max = 50)
    @Column(name = "sem_name")
    private String semName;
    @OneToMany(mappedBy = "semId")
    private List<Subject> subjectList;

    public Semester() {
    }

    public Semester(Integer semId) {
        this.semId = semId;
    }
    public Semester(Integer semId,String semName) {
        this.semId = semId;
        this.semName = semName;
    }

    public Integer getSemId() {
        return semId;
    }

    public void setSemId(Integer semId) {
        this.semId = semId;
    }

    public String getSemName() {
        return semName;
    }

    public void setSemName(String semName) {
        this.semName = semName;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (semId != null ? semId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Semester)) {
            return false;
        }
        Semester other = (Semester) object;
        if ((this.semId == null && other.semId != null) || (this.semId != null && !this.semId.equals(other.semId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.webdepartment.finaljavaeeproject.entities.Semester[ semId=" + semId + " ]";
    }
    
    public String getSemIdAsString() {
        return (semId != null) ? semId.toString(): "8";
    }
    
    public int getSemIdAInt() {
        return (semId != null) ? semId : 8;
    }
    
    
}
