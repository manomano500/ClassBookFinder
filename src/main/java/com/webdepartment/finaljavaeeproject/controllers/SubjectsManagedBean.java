package com.webdepartment.finaljavaeeproject.controllers;
import com.webdepartment.finaljavaeeproject.aice.SemesterEnum;
import com.webdepartment.finaljavaeeproject.entities.Book;
import com.webdepartment.finaljavaeeproject.entities.Department;
import com.webdepartment.finaljavaeeproject.entities.Semester;
import com.webdepartment.finaljavaeeproject.entities.Subject;
import com.webdepartment.finaljavaeeproject.services.SubjectService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.transaction.Transactional;


public class SubjectsManagedBean implements Serializable{

    @Inject
    @EJB
    private SubjectService subjectsService;

 
   
 
    private List<Subject> subjectsList;
    
    private String subject_name;
    private Semester selectedSemester; // Updated to Long type to store semester ID
    
    private Subject selectedSubject;

    public void setSelectedSubject(Subject selectedSubject) {
        this.selectedSubject = selectedSubject;
    }

    public Subject getSelectedSubject() {
        return selectedSubject;
    }


    public List<Subject> getSubjectsList() {

        if (subjectsList==null) {
            subjectsList = subjectsService.getAllSubjects();

            
        }else{
            subjectsList.clear();
            subjectsList = subjectsService.getAllSubjects();
        }
        return subjectsList;
    }



    // Updated addSubject method to set selectedSem
    @Transactional
    public void addSubject() {
        Subject subject = new Subject();
        subject.setSubjectName(subject_name);
        subject.setSemesterID(selectedSemester);
        subjectsService.addSubject(subject);
    }
    public void deleteSubject(int subject_id) {

        subjectsService.deleteSubject(subject_id);

    }

    // Getters and setters for selectedSem
    public Semester getSelectedSem() {
        return selectedSemester;
    }

    public void setSelectedSem(Semester selectedSem) {
        this.selectedSemester = selectedSem;
    }

    // Getters and setters for subject_name
    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }
    
    
    
    
    public List<Subject> getSubjectsForSemesterDepartment(Semester semester,Department department) {

       return subjectsService.getSubjectsForSemesterDepartment(semester, department);
    }
    
    public List<Subject> getSubjectsForDepartment( Department department) {
        return subjectsService.getSubjectsForDepartment(department);
    }

    // Existing code...
    

    
    
    
    
    
    
    
    
}
