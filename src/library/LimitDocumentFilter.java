/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author Ramdhan
 */
public class LimitDocumentFilter extends DocumentFilter {

    private final int maxChars;

    public LimitDocumentFilter(int maxChars) {
        this.maxChars = maxChars;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (string == null) {
            return;
        }

        // Hitung karakter yang ada sekarang + input baru
        int currentLength = fb.getDocument().getLength();
        int newLength = string.length();

        if (currentLength + newLength <= maxChars) {
            super.insertString(fb, offset, string, attr);
        }
        // Jika lebih dari max, input ditolak otomatis
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (text == null) {
            return;
        }

        int currentLength = fb.getDocument().getLength();
        int textLength = text.length();
        int finalLength = currentLength - length + textLength;

        if (finalLength <= maxChars) {
            super.replace(fb, offset, length, text, attrs);
        }
    }
}
