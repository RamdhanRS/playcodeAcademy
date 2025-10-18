/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;

import com.toedter.calendar.JDateChooser;
import java.util.Locale;

/**
 *
 * @author Ramdhan
 */
public class DateIndonesiaRenderer {

    public static void applyIndonesianFormat(JDateChooser chooser) {
        chooser.setLocale(new Locale("id", "ID"));
        chooser.setDateFormatString("dd MMMM yyyy");
    }
}
