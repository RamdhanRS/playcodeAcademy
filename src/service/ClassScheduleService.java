/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClassSchedule/Class.java to edit this template
 */
package service;

import java.util.List;
import model.ClassScheduleModel;

/**
 *
 * @author ramdh
 */
public interface ClassScheduleService {

    void addClassSchedule(ClassScheduleModel classesModel);

    void editClassSchedule(ClassScheduleModel classesModel);

    void deleteClassSchedule(ClassScheduleModel classesModel);

    ClassScheduleModel getById(int id);

    List<ClassScheduleModel> getDataById();

    List<ClassScheduleModel> getData();

    List<ClassScheduleModel> searching(String nama);
}
