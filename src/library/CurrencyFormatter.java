package library;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Ramdhan
 */
public class CurrencyFormatter {

    public static final Locale INDONESIA = new Locale("id", "ID");
    public static final NumberFormat RUPIAH_FORMAT = NumberFormat.getCurrencyInstance(INDONESIA);

    // --- format double ---
    public static String formatRupiah(double value) {
        return RUPIAH_FORMAT.format(value);
    }

    // --- format BigDecimal ---
    public static String formatRupiah(BigDecimal value) {
        if (value == null) {
            return "-";
        }
        return RUPIAH_FORMAT.format(value);
    }

    // --- tanpa simbol Rp ---
    public static String formatRupiahWithoutSymbol(BigDecimal value) {
        if (value == null) {
            return "-";
        }
        return RUPIAH_FORMAT.format(value).replace("Rp", "").trim();
    }

    // --- versi double tanpa Rp ---
    public static String formatRupiahWithoutSymbol(double value) {
        return RUPIAH_FORMAT.format(value).replace("Rp", "").trim();
    }
}
