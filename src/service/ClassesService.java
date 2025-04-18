/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.ClassesModel;

/**
 *
 * @author ramdh
 */
public interface ClassesService {

    void addClasses(ClassesModel classesModel);

    void editClasses(ClassesModel classesModel);

    void deleteClasses(ClassesModel classesModel);

    ClassesModel getById(int id);

    List<ClassesModel> getDataById();

    List<ClassesModel> getData();

    List<ClassesModel> searching(String nama);
   
    void exportClassesToExcel();
}
