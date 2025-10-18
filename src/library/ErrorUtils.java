/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;

import javax.swing.JOptionPane;

/**
 *
 * @author Ramdhan
 */
public class ErrorUtils {

    // Pesan umum untuk user
    public static void showUserFriendlyError(String action) {
        String message = switch (action.toLowerCase()) {
            case "insert" ->
                "Terjadi kesalahan saat menambahkan data.";
            case "update" ->
                "Terjadi kesalahan saat memperbarui data.";
            case "delete" ->
                "Terjadi kesalahan saat menghapus data.";
            case "get" ->
                "Terjadi kesalahan saat mengambil data.";
            case "count" ->
                "Terjadi kesalahan saat menghitung jumlah data.";
            case "export" ->
                "Terjadi kesalahan saat mengekspor data. Silakan coba lagi nanti";
            default ->
                "Terjadi kesalahan dalam sistem.";
        };

        JOptionPane.showMessageDialog(null, message, "Kesalahan", JOptionPane.ERROR_MESSAGE);
    }

    // Log detail untuk developer
    public static void logError(String context, Exception e) {
        System.err.println("⚠️ [Error] (" + context + "): " + e.getMessage());
    }
}
