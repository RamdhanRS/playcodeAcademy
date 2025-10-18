/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

/**
 *
 * @author ramdhan
 */
public class DateConverter {

    private static final Locale LOCALE_ID = new Locale("id", "ID");

    // ✅ Konversi berbagai jenis objek menjadi LocalDate
    public static LocalDate convertToLocalDate(Object dateObj) {
        if (dateObj == null) {
            return null;
        }

        if (dateObj instanceof LocalDate localDate) {
            return localDate;
        }
        if (dateObj instanceof java.sql.Date date) {
            return date.toLocalDate();
        }
        if (dateObj instanceof java.util.Date date) {
            return new java.sql.Date(date.getTime()).toLocalDate();
        }
        if (dateObj instanceof String string) {
            return parseStringToLocalDate(string);
        }

        throw new IllegalArgumentException("Format tanggal tidak dikenali: " + dateObj);
    }

    // Parse String ke LocalDate dengan berbagai format
    private static LocalDate parseStringToLocalDate(String dateStr) {
        List<String> patterns = Arrays.asList(
                "yyyy-MM-dd", "dd-MM-yyyy", "MM/dd/yyyy", "dd/MM/yyyy",
                "yyyy/MM/dd", "d MMM yyyy", "dd MMMM yyyy", "MMMM d, yyyy"
        );
        for (String pattern : patterns) {
            try {
                return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern, LOCALE_ID));
            } catch (DateTimeParseException ignored) {
            }
        }
        throw new IllegalArgumentException("Format tanggal tidak dikenali: " + dateStr);
    }

    // Format LocalDate menjadi “07 Oktober 2025”
    public static String toIndonesianFormat(LocalDate date) {
        if (date == null) {
            return "";
        }
        return date.format(DateTimeFormatter.ofPattern("dd MMMM yyyy", LOCALE_ID));
    }

    // Format LocalDate menjadi format database (YYYY-MM-DD)
    public static String toDatabaseFormat(LocalDate date) {
        if (date == null) {
            return null;
        }
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
