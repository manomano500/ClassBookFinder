/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.webdepartment.finaljavaeeproject.xet;

import com.webdepartment.finaljavaeeproject.controllers.DepartmentManagedBean;
import com.webdepartment.finaljavaeeproject.controllers.SubjectsManagedBean;
import com.webdepartment.finaljavaeeproject.controllers.UsersManagedBean;
import com.webdepartment.finaljavaeeproject.services.SubjectService;
import java.io.IOException;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author mahjouba
 */
public class MangedBean {

    /**
     * Creates a new instance of MangedBean
     */
    public MangedBean() {
    }
    
    
    @Inject
    private UsersManagedBean usersManagedBean; 

    public UsersManagedBean getUsersManagedBean() {
        return usersManagedBean;
    }
    
    @Inject
     private DepartmentManagedBean departmentManagedBean;

    public DepartmentManagedBean getDepartmentManagedBean() {
        return departmentManagedBean;
    }

  

//        public void redirectToMainWhenLoadNestedPage() throws IOException {
//        if (departmentManagedBean.getSelectedDepartment() == null) {
//            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
//            externalContext.redirect(externalContext.getRequestContextPath() + "/main.xhtml");
//        }
//     
//    }
        
        public void redirectToLoginIfNotLoggedIn() throws IOException {
        if (usersManagedBean.isLoggedIn()) {
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect(externalContext.getRequestContextPath() + "/admin/login.xhtml");
        }
    }
}
