/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webdepartment.finaljavaeeproject.aice;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author mahjouba
 */
public enum SemesterEnum {
    FIRST_SEMESTER(1, "First Semester"),
    SECOND_SEMESTER(2, "Second Semester"),
    THIRD_SEMESTER(3, "Third Semester"),
    FOURTH_SEMESTER(4, "Fourth Semester"),
    FIFTH_SEMESTER(5, "Fifth Semester"),
    SIXTH_SEMESTER(6, "Sixth Semester"),
    SEVENTH_SEMESTER(7, "Seventh Semester"),
    Eight_Semester(8, "Eight Semester");

    private final int id;
    private final String displayName;
    private List<SemesterEnum>  allSemesterEnums;

    public void setAllSemesterEnums(List<SemesterEnum> allSemesterEnums) {
        this.allSemesterEnums = allSemesterEnums;
    }

    public List<SemesterEnum> getAllSemesterEnums() {
        return allSemesterEnums;
    }

    SemesterEnum(int id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public int getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }
    public static SemesterEnum convertStringToSemesterEnum(String semester) {
        switch (semester) {
            case "First Semester":
                return SemesterEnum.FIRST_SEMESTER;
            case "Second Semester":
                return SemesterEnum.SECOND_SEMESTER;
            case "Third Semester":
                return SemesterEnum.THIRD_SEMESTER;
            case "Fourth Semester":
                return SemesterEnum.FOURTH_SEMESTER;
            case "Fifth Semester":
                return SemesterEnum.FIFTH_SEMESTER;
            case "Sixth Semester":
                return SemesterEnum.SIXTH_SEMESTER;
            case "Seventh Semester":
                return SemesterEnum.SEVENTH_SEMESTER;
            case "Eight_Semester":
                return SemesterEnum.Eight_Semester;
            default:
                throw new IllegalArgumentException("Unknown semester: " + semester);
        }
    }
    
    
    
    public static int convertStringToInt(String semesterName) {
        for (SemesterEnum semester : SemesterEnum.values()) {
            if (semester.getDisplayName().equalsIgnoreCase(semesterName)) {
                return semester.getId();
            }
        }
        throw new IllegalArgumentException("Invalid semester name: " + semesterName);
    }
    
    
    public static String convertIntToSemesterName(int semesterId) {
        for (SemesterEnum semester : SemesterEnum.values()) {
            if (semester.getId() == semesterId) {
                return semester.getDisplayName();
            }
        }
        throw new IllegalArgumentException("Invalid semester ID: " + semesterId);
    }

    
  


}
