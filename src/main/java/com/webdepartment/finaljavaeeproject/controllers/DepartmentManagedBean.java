package com.webdepartment.finaljavaeeproject.controllers;

import com.webdepartment.finaljavaeeproject.entities.Department;
import com.webdepartment.finaljavaeeproject.entities.Semester;
import com.webdepartment.finaljavaeeproject.entities.Subject;
import com.webdepartment.finaljavaeeproject.services.DepartmentsService;
import com.webdepartment.finaljavaeeproject.services.SubjectService;
import java.io.Serializable;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;

/**
 *
 * @author mahjouba
 */
public class DepartmentManagedBean implements Serializable {

    @Inject
    @EJB
    private DepartmentsService departmentsService;
 

    /**
     * Creates a new instance of departmentManagedBean
     */
    private Department selectedDepartment;

    public Department getSelectedDepartment() {
        
        return selectedDepartment;
    }

    public void setSelectedDepartment(Department selected) {
        this.selectedDepartment = selected;
    }

    public String navigateToDepartment() {
        // Optionally, you can perform some logic with the selected department before navigation
        System.out.println("Selected Department: " + selectedDepartment);

        // Construct the URL of the department page with the selected department name
        String departmentPageUrl = "department.xhtml?faces-redirect=true&dept=" + selectedDepartment;

        // Return the URL of the department page
        return departmentPageUrl;
    }
    
    public List<Department> feachDepartments() {
        return departmentsService.getDepartments();

    }

    public List<Subject> feachDepartmentSubjects(Department department) {
        System.err.println(department);
        List<Subject> subjects = departmentsService.getDepartmentSubjects(department);
//        System.err.println("Subjects List: "+subjects);
    return subjects;
    }

//    public List<Subject> fetchSemesterSubjectsForDepartment(Semester semester) {
//        if (selectedDepartment != null && semester != null) {
//            return departmentsService.getSemesterSubjectsForDepartment(semester, selectedDepartment);
//        } else {
//            return null;
//        }
//    }
}
