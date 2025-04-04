/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.ClassesModel;

/**
 *
 * @author ramdh
 */
public class ClassesTableModel extends AbstractTableModel {

    private final List<ClassesModel> list;

    public ClassesTableModel() {
        this.list = new ArrayList<>();
    }

    // Interface dari service
    public void addClasses(ClassesModel classesModel) {
        list.add(classesModel);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }

    public void editClasses(int id, ClassesModel classesModel) {
        list.add(id, classesModel);
        fireTableDataChanged();
        JOptionPane.showMessageDialog(null, "Data Berhasil diperbarui");
    }

    public void deleteClasses(int id) {
        list.remove(id);
        fireTableRowsDeleted(id, id);
        JOptionPane.showMessageDialog(null, "Data Berhasil dihapus");
    }

    public void clear() {
        list.clear();
        fireTableDataChanged();
    }

    public void setData(List<ClassesModel> list) {
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }

    public void setData(int id, ClassesModel classesModel) {
        list.set(id, classesModel);
        fireTableRowsUpdated(id, id);
    }

    public ClassesModel getData(int id) {
        return list.get(id);
    }

    // End interface dari service
    @Override
    public int getRowCount() {
        return list.size();
    }

    private final String[] columnNames = {"Id", "No", "Nama kelas", "kursus", "Pengajar", "Tgl Mulai", "Tgl Selesai", "Capacity"};

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
                list.get(rowIndex).getClassName();
            case 3 ->
                list.get(rowIndex).getCourses() == null ? "-" : list.get(rowIndex).getCourses().getCourseName();
            case 4 ->
                list.get(rowIndex).getCoach()== null ? "-" : list.get(rowIndex).getCoach().getNama();
            case 5 ->
                list.get(rowIndex).getStartDate();
            case 6 ->
                list.get(rowIndex).getEndDate();
            case 7 ->
                list.get(rowIndex).getCapacity();
            default ->
                null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
