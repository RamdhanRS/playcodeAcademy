/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;

import com.toedter.calendar.JDateChooser;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author Ramdhan
 */
public class DateIndonesiaRenderer {

    private static final DateTimeFormatter ID_FORMATTER = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("id", "ID"));

    public static void applyIndonesianFormat(JDateChooser chooser) {
        chooser.setLocale(new Locale("id", "ID"));
        chooser.setDateFormatString("dd MMMM yyyy");
    }

    public static String format(Object dateObj) {
        LocalDate tgl = DateConverter.convertToLocalDate(dateObj);
        return (tgl == null) ? "-" : tgl.format(ID_FORMATTER);
    }

}
