package com.webdepartment.finaljavaeeproject.controllers;

import com.webdepartment.finaljavaeeproject.entities.Book;
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
 

    private Department selectedDepartment;

    

    public String navigateToDepartment() {

        return "toSubjectsPage";
    }
    
    public List<Department> feachDepartments() {
        return departmentsService.getDepartments();

    }


/////////////////////////////////Getters And Setters////////////////////////////

       public Department getSelectedDepartment() {

        return selectedDepartment;
    }

    public void setSelectedDepartment(Department selected) {
//        subjectsManagedBean.setSelectedSubject(null);
        this.selectedDepartment = selected;
    }
}
