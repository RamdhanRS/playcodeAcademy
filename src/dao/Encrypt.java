/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.lang.System.Logger;

/**
 *
 * @author ramdh
 */
public class Encrypt {

    private static final Logger LOGGER = System.getLogger(Encrypt.class.getName());

    public static String getmd5java(String message) {
        String digest = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(message.getBytes("UTF-8"));

            // Merubah byte array ke dalam String Hexadesimal
            StringBuilder sb = new StringBuilder(2 * hash.length);
            for (byte b : hash) {
                sb.append(String.format("%02x", b & 0xff));
            }
            digest = sb.toString();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            LOGGER.log(System.Logger.Level.ERROR, "An error occurred", e);
        }
        return digest;
    }
}
