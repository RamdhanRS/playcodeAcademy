/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalTime;

/**
 *
 * @author ramdh
 */
public class ClassScheduleModel {

    private Integer id;
    private ClassesModel classes;
    private CoursesModel courses;
    private UserModel coach;
    private String dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

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

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
