/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author ramdh
 */
public class ClassesModel {

    private Integer id;
    private CoursesModel courses;
    private UserModel coach;
    private String className;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer capacity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CoursesModel getCourses() {
        return courses;
    }

    public void setCourses(CoursesModel courses) {
        this.courses = courses;
    }

    public UserModel getCoach() {
        return coach;
    }

    public void setCoach(UserModel coach) {
        this.coach = coach;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
