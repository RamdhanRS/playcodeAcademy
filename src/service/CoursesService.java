/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.CoursesModel;

/**
 *
 * @author ramdh
 */
public interface CoursesService {

    void addCourses(CoursesModel coursesModel);

    void editCourses(CoursesModel coursesModel);

    void deleteCourses(CoursesModel coursesModel);

    CoursesModel getById(int id);

    List<CoursesModel> getDataById();

    List<CoursesModel> getData();

    List<CoursesModel> searching(String nama);

    void exportCoursesToExcel();
}
