/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClassRegist/Class.java to edit this template
 */
package service;

import java.util.List;
import model.ClassRegistModel;
import model.UserModel;

/**
 *
 * @author ramdh
 */
public interface ClassRegistService {

    void addClassRegist(ClassRegistModel classesModel);

    void deleteClassRegist(ClassRegistModel classesModel);

    ClassRegistModel getById(int id);

    List<ClassRegistModel> getDataById(int id);

    List<UserModel> getDataStudentById(int id);

    List<ClassRegistModel> getData();

    List<ClassRegistModel> searching(String nama);
}
