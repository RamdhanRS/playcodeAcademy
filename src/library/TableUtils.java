package library;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * Utility modern untuk JTable dengan auto wrap, auto width, auto height.
 */
public class TableUtils {

    /**
     * Renderer dengan text wrapping & tinggi otomatis.
     */
    public static class TextAreaRenderer extends JTextArea implements TableCellRenderer {

        public TextAreaRenderer() {
            setLineWrap(true);
            setWrapStyleWord(true);
            setOpaque(true);
            setBorder(null);
            setMargin(new Insets(4, 6, 4, 6));
        }

        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            setText(value == null ? "" : value.toString());

            if (isSelected) {
                setBackground(new Color(200, 220, 255));
                setForeground(Color.BLACK);
            } else {
                // zebra row (warna selang-seling)
                setBackground(row % 2 == 0 ? Color.WHITE : new Color(247, 249, 255));
                setForeground(Color.BLACK);
            }

            // Hitung tinggi ideal
            int columnWidth = table.getColumnModel().getColumn(column).getWidth();
            setSize(new Dimension(columnWidth, Integer.MAX_VALUE));
            int preferredHeight = getPreferredSize().height + table.getRowMargin();

            // Hanya ubah jika lebih tinggi
            if (table.getRowHeight(row) < preferredHeight) {
                table.setRowHeight(row, preferredHeight);
            }

            return this;
        }
    }

    public static void unifyRowHeights(JTable table) {
        int maxHeight = table.getRowHeight();
        for (int row = 0; row < table.getRowCount(); row++) {
            int height = table.getRowHeight(row);
            if (height > maxHeight) {
                maxHeight = height;
            }
        }
        table.setRowHeight(maxHeight);
    }

    /**
     * Terapkan tampilan modern dengan zebra row & header lembut.
     */
    public static void applyModernStyle(JTable table) {
        table.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        table.setRowHeight(28);
        table.setGridColor(new Color(220, 220, 220));
        table.setShowGrid(true);
        table.setIntercellSpacing(new Dimension(6, 6));
        table.setBackground(Color.WHITE);
        table.setSelectionBackground(new Color(180, 205, 250));
        table.setSelectionForeground(Color.BLACK);
        table.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        header.setBackground(new Color(230, 240, 255));
        header.setForeground(new Color(40, 60, 90));
        header.setOpaque(true);
        header.setReorderingAllowed(false);
    }

    /**
     * Aktifkan wrapping text di semua kolom (auto height).
     */
    public static void enableTextWrap(JTable table) {
        TableCellRenderer renderer = new TextAreaRenderer();
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
    }

    /**
     * Hitung lebar kolom otomatis (tanpa batas 300px).
     */
    public static void autoResizeColumns(JTable table) {
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        for (int column = 0; column < table.getColumnCount(); column++) {
            TableColumn tableColumn = table.getColumnModel().getColumn(column);
            int preferredWidth = 75;

            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                int width = comp.getPreferredSize().width + table.getIntercellSpacing().width;
                preferredWidth = Math.max(preferredWidth, width);
            }

            tableColumn.setPreferredWidth(preferredWidth);
        }
    }

    /**
     * Kombinasi modern style + wrap + auto width.
     */
    public static void enhanceTable(JTable table) {
        applyModernStyle(table);
        enableTextWrap(table);
        autoResizeColumns(table);
    }
}
