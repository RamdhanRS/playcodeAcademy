/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.UserModel;

/**
 *
 * @author ramdh
 */
public interface UserService {

    void addUser(UserModel userModel);

    void editUser(UserModel userModel);

    void deleteUser(UserModel userModel);

    UserModel getById(int id);

    List<UserModel> getDataById();

    List<UserModel> getData();

    List<UserModel> searching(String nama);
}
