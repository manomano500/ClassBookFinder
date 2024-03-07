/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.webdepartment.finaljavaeeproject.controllers;

import com.webdepartment.finaljavaeeproject.services.SemesterService;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author mahjouba
 */
import com.webdepartment.finaljavaeeproject.entities.Semester;
import com.webdepartment.finaljavaeeproject.entities.Subject;
import com.webdepartment.finaljavaeeproject.services.SemesterService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;


public class SemestersManagedBean implements Serializable {

    @Inject
    private SemesterService semesterService;

    private List<Semester> semestersList;
    private Semester selectedSemester;
    private List<Subject> subjectsList;
    
   
    public List<Semester> getSemestersList() {
        if (semestersList == null) {
            semestersList = semesterService.getAllSemesters();
        }
        return semestersList;
    }

    public Semester getSelectedSemester() {
        return selectedSemester;
    }

    public void setSelectedSemester(Semester selectedSemester) {
        this.selectedSemester = selectedSemester;
        loadSubjectsForSemester();
    }

    public List<Subject> getSubjectsList() {
        return subjectsList;
    }
  

    private void loadSubjectsForSemester() {
        if (selectedSemester != null) {
            subjectsList = semesterService.getSubjectsForSemester(selectedSemester);
        }
    }
    
    public List<Subject> subjectsForThisSem(Semester sem) {
        return semesterService.getSubjectsForSemester(sem);
    }
    
    
}
