package com.webdepartment.finaljavaeeproject.controllers;
import com.webdepartment.finaljavaeeproject.aice.SemesterConverter;
import com.webdepartment.finaljavaeeproject.entities.Semester;
import com.webdepartment.finaljavaeeproject.entities.Subject;
import com.webdepartment.finaljavaeeproject.services.SemesterService;
import com.webdepartment.finaljavaeeproject.services.SubjectService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;


public class SubjectsManagedBean implements Serializable {

    @Inject
    private SubjectService subjectsService;

    @Inject
    private SemesterService semesterService;
 
    private List<Subject> subjectsList;

    private String subject_name;
    private int selectedSem; // Updated to Long type to store semester ID

    // Existing code...
    public List<Semester> getSemesters() {
        return semesterService.getAllSemesters();
    }

    // Updated addSubject method to set selectedSem
    public void addSubject() {
        Subject subject = new Subject();
        subject.setSubName(subject_name);
        subject.setSemId(semesterService.findSemesterById(selectedSem));
        subjectsService.addSubject(subject);
    }

    // Getters and setters for selectedSem
    public int getSelectedSem() {
        return selectedSem;
    }

    public void setSelectedSem(int selectedSem) {
        this.selectedSem = selectedSem;
    }

    // Getters and setters for subject_name
    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    // Existing code...
}
