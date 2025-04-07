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
public class ClassRegistModel {

    private Integer id;
    private ClassesModel classes;
    private CoursesModel courses;
    private UserModel coach;
    private UserModel student;
    private LocalDate registeredDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClassesModel getClasses() {
        return classes;
    }

    public void setClasses(ClassesModel classes) {
        this.classes = classes;
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

    public UserModel getStudent() {
        return student;
    }

    public void setStudent(UserModel student) {
        this.student = student;
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }
}
