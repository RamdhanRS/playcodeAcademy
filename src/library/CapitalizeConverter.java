/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *
 * @author ramdh
 */
public class CapitalizeConverter {

    public static String capitalize(String str) {
        return str == null || str.isEmpty() ? str
                : str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    public static String capitalizeWords(String str) {
        return Arrays.stream(str.split("\\s+"))
                .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }
}
