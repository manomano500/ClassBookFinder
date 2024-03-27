/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.webdepartment.finaljavaeeproject.controllers;

import com.webdepartment.finaljavaeeproject.entities.Department;
import com.webdepartment.finaljavaeeproject.entities.Semester;
import com.webdepartment.finaljavaeeproject.services.SemestersService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;

/**
 *
 * @author mahjouba
 */
public class SemestersManagedBean implements Serializable{

    @Inject
    @EJB
    private SemestersService semestersService;
 

    /**
     * Creates a new instance of SemestersManagedBean
     */
    public SemestersManagedBean() {
    }
    
    private Department selectedDepartment;
    
    
    
//    private Semester selectedSemester ;
    private List<Semester> semesterList ;

    public void setSemesterList(List<Semester> semesterList) {
        this.semesterList = semesterList;
    }

    public List<Semester> getSemesterList() {
        return semestersService.feachAllSemesters();
    }


    
  

   
}
