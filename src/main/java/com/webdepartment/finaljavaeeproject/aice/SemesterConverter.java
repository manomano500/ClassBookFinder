/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webdepartment.finaljavaeeproject.aice;

/**
 *
 * @author mahjouba
 */

import com.webdepartment.finaljavaeeproject.entities.Semester;
import com.webdepartment.finaljavaeeproject.services.SemesterService;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import javax.inject.Inject;

@FacesConverter("semesterConverter")
public class SemesterConverter implements Converter {

    @Inject
    SemesterService semesterService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        // Assuming the string representation is the semester ID
        int semId = Integer.parseInt(value);
        return semesterService.findSemesterById(semId);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value == null || !(value instanceof Semester)) {
            return null;
        }

        // Convert the Semester object to its ID for the string representation
        return String.valueOf(((Semester) value).getSemId());
    }
}
