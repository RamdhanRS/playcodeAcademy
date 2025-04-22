/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClassRegist/Class.java to edit this template
 */
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.ClassRegistModel;

/**
 *
 * @author ramdh
 */
public class ClassRegistTableModel extends AbstractTableModel {

    private final List<ClassRegistModel> list;

    public ClassRegistTableModel() {
        this.list = new ArrayList<>();
    }

    // Interface dari service
    public void addClassRegist(ClassRegistModel classRegistModel) {
        list.add(classRegistModel);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }

    public void editClassRegist(int id, ClassRegistModel classRegistModel) {
        list.add(id, classRegistModel);
        fireTableDataChanged();
        JOptionPane.showMessageDialog(null, "Data Berhasil diperbarui");
    }

    public void deleteClassRegist(int id) {
        list.remove(id);
        fireTableRowsDeleted(id, id);
        JOptionPane.showMessageDialog(null, "Data Berhasil dihapus");
    }

    public void clear() {
        list.clear();
        fireTableDataChanged();
    }

    public void setData(List<ClassRegistModel> list) {
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }

    public void setData(int id, ClassRegistModel classRegistModel) {
        list.set(id, classRegistModel);
        fireTableRowsUpdated(id, id);
    }

    public ClassRegistModel getData(int id) {
        return list.get(id);
    }

    // End interface dari service
    @Override
    public int getRowCount() {
        return list.size();
    }

    private final String[] columnNames = {"Id", "No", "Nama Kelas", "Nama Kursus", "Nama Pengajar"};

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 ->
                list.get(rowIndex).getClasses() == null ? "0" : list.get(rowIndex).getClasses().getId();  // ID disimpan tapi akan disembunyikan di JTable
            case 1 ->
                " " + (rowIndex + 1);
            case 2 ->
                list.get(rowIndex).getClasses() == null ? "-" : list.get(rowIndex).getClasses().getClassName();
            case 3 ->
                list.get(rowIndex).getCourses() == null ? "-" : list.get(rowIndex).getCourses().getCourseName();
            case 4 ->
                list.get(rowIndex).getCoach() == null ? "-" : list.get(rowIndex).getCoach().getNama();
            default ->
                null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
