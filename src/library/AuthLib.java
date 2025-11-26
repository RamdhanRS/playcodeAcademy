/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;

/**
 *
 * 
 */
public class AuthLib {

    public static boolean isAdmin() {
        return "admin".equalsIgnoreCase(Session.getInstance().getUser().getLevel());
    }

    public static boolean isStaff() {
        String level = Session.getInstance().getUser().getLevel();
        return "staff".equalsIgnoreCase(level) || "admin".equalsIgnoreCase(level);
    }

    public static boolean isUser() {
        return Session.getInstance().getUser() != null;
    }
}
