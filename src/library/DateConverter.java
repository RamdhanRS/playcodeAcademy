/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ramdh
 */
public class DateConverter {

    public static LocalDate convertToLocalDate(Object dateObj) {
        if (dateObj == null) {
            return null;
        }

        if (dateObj instanceof LocalDate) {
            return (LocalDate) dateObj;
        }

        // Jika SQL Date, konversi ke LocalDate
        if (dateObj instanceof Date) {
            return ((Date) dateObj).toLocalDate();
        }

        // Jika java.util.Date, konversi ke LocalDate
        if (dateObj instanceof java.util.Date) {
            return new java.sql.Date(((java.util.Date) dateObj).getTime()).toLocalDate();
        }

        // Jika String, coba parsing dengan berbagai format
        if (dateObj instanceof String) {
            return parseStringToLocalDate((String) dateObj);
        }

        throw new IllegalArgumentException("Format tanggal tidak dikenali: " + dateObj);
    }

    private static LocalDate parseStringToLocalDate(String dateStr) {
        List<String> patterns = Arrays.asList(
                "yyyy-MM-dd", // 2025-03-29
                "dd-MM-yyyy", // 29-03-2025
                "MM/dd/yyyy", // 03/29/2025
                "dd/MM/yyyy", // 29/03/2025
                "yyyy/MM/dd", // 2025/03/29
                "d MMM yyyy", // 29 Mar 2025
                "MMMM d, yyyy" // March 29, 2025
        );

        for (String pattern : patterns) {
            try {
                return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
            } catch (DateTimeParseException ignored) {
            }
        }

        throw new IllegalArgumentException("Format tanggal tidak dikenali: " + dateStr);
    }

    public static void main(String[] args) {
        System.out.println(convertToLocalDate("29-03-2025"));  // 2025-03-29
        System.out.println(convertToLocalDate("03/29/2025"));  // 2025-03-29
        System.out.println(convertToLocalDate("2025-03-29"));  // 2025-03-29
        System.out.println(convertToLocalDate(java.sql.Date.valueOf("2025-03-29"))); // 2025-03-29
    }
}
