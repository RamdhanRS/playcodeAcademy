/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClassSchedule/Class.java to edit this template
 */
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.ClassScheduleModel;

/**
 *
 * @author ramdh
 */
public class ClassScheduleTableModel extends AbstractTableModel {

    private final List<ClassScheduleModel> list;

    public ClassScheduleTableModel() {
        this.list = new ArrayList<>();
    }

    // Interface dari service
    public void addClassSchedule(ClassScheduleModel classScheduleModel) {
        list.add(classScheduleModel);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }

    public void editClassSchedule(int id, ClassScheduleModel classScheduleModel) {
        list.add(id, classScheduleModel);
        fireTableDataChanged();
        JOptionPane.showMessageDialog(null, "Data Berhasil diperbarui");
    }

    public void deleteClassSchedule(int id) {
        list.remove(id);
        fireTableRowsDeleted(id, id);
        JOptionPane.showMessageDialog(null, "Data Berhasil dihapus");
    }

    public void clear() {
        list.clear();
        fireTableDataChanged();
    }

    public void setData(List<ClassScheduleModel> list) {
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }

    public void setData(int id, ClassScheduleModel classScheduleModel) {
        list.set(id, classScheduleModel);
        fireTableRowsUpdated(id, id);
    }

    public ClassScheduleModel getData(int id) {
        return list.get(id);
    }

    // End interface dari service
    @Override
    public int getRowCount() {
        return list.size();
    }

    private final String[] columnNames = {"Id", "No", "Nama Kelas", "Nama Kursus", "Nama Pengajar", "Hari", "Jam Mulai", "Jam Selesai"};

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
                list.get(rowIndex).getClasses() == null ? "-" : list.get(rowIndex).getClasses().getClassName();
            case 3 ->
                list.get(rowIndex).getCourses() == null ? "-" : list.get(rowIndex).getCourses().getCourseName();
            case 4 ->
                list.get(rowIndex).getCoach() == null ? "-" : list.get(rowIndex).getCoach().getNama();
            case 5 ->
                list.get(rowIndex).getDayOfWeek();
            case 6 ->
                list.get(rowIndex).getStartTime();
            case 7 ->
                list.get(rowIndex).getEndTime();
            default ->
                null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
