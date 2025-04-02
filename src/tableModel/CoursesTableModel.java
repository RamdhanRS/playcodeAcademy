/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.CoursesModel;

/**
 *
 * @author ramdh
 */
public class CoursesTableModel extends AbstractTableModel {

    private final List<CoursesModel> list;

    public CoursesTableModel() {
        this.list = new ArrayList<>();
    }

    // Interface dari service
    public void addCourses(CoursesModel coursesModel) {
        list.add(coursesModel);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }

    public void editCourses(int id, CoursesModel coursesModel) {
        list.add(id, coursesModel);
        fireTableDataChanged();
        JOptionPane.showMessageDialog(null, "Data Berhasil diperbarui");
    }

    public void deleteCourses(int id) {
        list.remove(id);
        fireTableRowsDeleted(id, id);
        JOptionPane.showMessageDialog(null, "Data Berhasil dihapus");
    }

    public void clear() {
        list.clear();
        fireTableDataChanged();
    }

    public void setData(List<CoursesModel> list) {
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }

    public void setData(int id, CoursesModel coursesModel) {
        list.set(id, coursesModel);
        fireTableRowsUpdated(id, id);
    }

    public CoursesModel getData(int id) {
        return list.get(id);
    }

    // End interface dari service
    @Override
    public int getRowCount() {
        return list.size();
    }

    private final String[] columnNames = {"ID", "No", "Nama Kursus", "Deskripsi", "Durasi (Jam)", "Harga (Rp)"};

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 ->
                list.get(rowIndex).getId();  // ID disimpan tapi akan disembunyikan di JTable
            case 1 ->
                " " + (rowIndex + 1);
            case 2 ->
                list.get(rowIndex).getCourseName();
            case 3 ->
                list.get(rowIndex).getDescription();
            case 4 ->
                list.get(rowIndex).getDuration();
            case 5 ->
                list.get(rowIndex).getPrice();
            default ->
                null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
