/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.UserModel;

/**
 *
 * @author ramdh
 */
public class UserTableModel extends AbstractTableModel {

    private final List<UserModel> list;

    public UserTableModel() {
        this.list = new ArrayList<>();
    }

    // Interface dari service
    public void addUser(UserModel userModel) {
        list.add(userModel);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }

    public void editUser(int id, UserModel userModel) {
        list.add(id, userModel);
        fireTableDataChanged();
        JOptionPane.showMessageDialog(null, "Data Berhasil diperbarui");
    }

    public void deleteUser(int id) {
        list.remove(id);
        fireTableRowsDeleted(id, id);
        JOptionPane.showMessageDialog(null, "Data Berhasil dihapus");
    }

    public void clear() {
        list.clear();
        fireTableDataChanged();
    }

    public void setData(List<UserModel> list) {
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }

    public void setData(int id, UserModel userModel) {
        list.set(id, userModel);
        fireTableRowsUpdated(id, id);
    }

    public UserModel getData(int id) {
        return list.get(id);
    }

    // End interface dari service
    @Override
    public int getRowCount() {
        return list.size();
    }

    private final String[] columnNames = {"No", "Nama", "No Hp", "Alamat", "Tgl Lahir", "Level", "Status"};

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return " " + (rowIndex + 1);
        } else {
            return switch (columnIndex - 1) {
                case 0 ->
                    list.get(rowIndex).getNama();
                case 1 ->
                    list.get(rowIndex).getNoHp();
                case 2 ->
                    list.get(rowIndex).getAlamat();
                case 3 ->
                    list.get(rowIndex).getTglLahir();
                case 4 ->
                    list.get(rowIndex).getLevel();
                case 5 ->
                    list.get(rowIndex).getStatus();
                default ->
                    null;
            };
        }
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return " " + columnNames[column];
        } else {
            return columnNames[column];
        }
    }
}
