/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.Koneksi;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
import model.ClassesModel;
import model.CoursesModel;
import model.UserModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import service.ClassesService;

/**
 *
 * @author ramdh
 */
public class ClassesDAO implements ClassesService {

    private final Connection conn;

    public ClassesDAO() {
        conn = Koneksi.koneksi();
    }

    @Override
    public void addClasses(ClassesModel classesModel) {
        PreparedStatement st = null;
        String sql = "INSERT INTO classes(courses_id, class_name, start_date, end_date, capacity, coach_id, created_at) VALUES (?,?,?,?,?,?,?)";

        try {
            st = conn.prepareStatement(sql);

            st.setInt(1, classesModel.getCourses().getId());
            st.setString(2, classesModel.getClassName());
            st.setDate(3, java.sql.Date.valueOf(classesModel.getStartDate()));
            st.setDate(4, java.sql.Date.valueOf(classesModel.getEndDate()));
            st.setInt(5, classesModel.getCapacity());
            st.setInt(6, classesModel.getCoach().getId());
            st.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));
            st.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Tambah data gagal");
            System.err.println("Error add classes : " + e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.err.println("Error finally add classes : " + e);
                }
            }
        }
    }

    @Override
    public void editClasses(ClassesModel classesModel) {
        PreparedStatement st = null;
        String sql = "UPDATE classes SET courses_id=?, class_name=?, start_date=?, end_date=?, capacity=?, coach_id=? WHERE id=?";

        try {
            st = conn.prepareStatement(sql);

            st.setInt(1, classesModel.getCourses().getId());
            st.setString(2, classesModel.getClassName());
            st.setDate(3, java.sql.Date.valueOf(classesModel.getStartDate()));
            st.setDate(4, java.sql.Date.valueOf(classesModel.getEndDate()));
            st.setInt(5, classesModel.getCapacity());
            st.setInt(6, classesModel.getCoach().getId());
            st.setInt(7, classesModel.getId()); // ID harus tipe integer sesuai DB

            st.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Perbarui data gagal");
            System.err.println("Error edit classes : " + e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.err.println("Error finally edit classes : " + e);
                }
            }
        }
    }

    @Override
    public void deleteClasses(ClassesModel classesModel) {
        PreparedStatement st = null;
        String sql = "DELETE FROM classes WHERE id=?";

        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, classesModel.getId());

            st.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hapus data gagal");
            System.err.println("Error delete classes : " + e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.err.println("Error finally hapus classes : " + e);
                }
            }
        }
    }

    @Override
    public ClassesModel getById(int id) {
        String sql = "SELECT cl.id, cl.class_name, cl.start_date, cl.end_date, cl.capacity,"
                + " cs.id as courses_id, cs.courses_name, u.id as coach_id, u.nama as coach_name"
                + " FROM classes cl"
                + " INNER JOIN courses as cs on cs.id = cl.courses_id"
                + " INNER JOIN users as u on u.id = cl.coach_id"
                + " WHERE cl.id = ?";
        return getClassesByQuery(sql, id);
    }

    @Override
    public List<ClassesModel> getDataById() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ClassesModel> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT cl.id, cl.class_name, cl.start_date, cl.end_date, cl.capacity,"
                + " cs.id as courses_id, cs.courses_name, u.id as coach_id, u.nama as coach_name"
                + " FROM classes cl"
                + " INNER JOIN courses as cs on cs.id = cl.courses_id"
                + " INNER JOIN users as u on u.id = cl.coach_id";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                // Masukkan data relasi coachModel
                UserModel coachModel = new UserModel();
                coachModel.setId(rs.getInt("coach_id"));
                coachModel.setNama(rs.getString("coach_name"));

                // Masukkan data relasi courseModel
                CoursesModel coursesModel = new CoursesModel();
                coursesModel.setId(rs.getInt("courses_id"));
                coursesModel.setCourseName(rs.getString("courses_name"));

                // Masukkan data hasil akhir
                ClassesModel classesModel = new ClassesModel();
                classesModel.setId(rs.getInt("id"));
                classesModel.setClassName(rs.getString("class_name"));
                classesModel.setCourses(coursesModel);
                classesModel.setCoach(coachModel);
                classesModel.setStartDate(rs.getDate("start_date").toLocalDate());
                classesModel.setEndDate(rs.getDate("end_date").toLocalDate());
                classesModel.setCapacity(rs.getInt("capacity"));

                list.add(classesModel);
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Error get data classes : " + e);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.out.println("Error close st get data classes : " + e);
                }
            }

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("Error close rs get data classes : " + e);
                }
            }
        }
    }

    @Override
    public List<ClassesModel> searching(String nama) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private ClassesModel getClassesByQuery(String sql, Object... params) {
        ClassesModel classesModel = null;
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                st.setObject(i + 1, params[i]);
            }
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                classesModel = mapClasses(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error => " + e);
        }
        return classesModel;
    }

    private ClassesModel mapClasses(ResultSet rs) throws SQLException {
        // Masukkan data relasi coachModel
        UserModel coachModel = new UserModel();
        coachModel.setId(rs.getInt("coach_id"));
        coachModel.setNama(rs.getString("coach_name"));

        // Masukkan data relasi courseModel
        CoursesModel coursesModel = new CoursesModel();
        coursesModel.setId(rs.getInt("courses_id"));
        coursesModel.setCourseName(rs.getString("courses_name"));

        // Masukkan data hasil akhir
        ClassesModel classesModel = new ClassesModel();
        classesModel.setId(rs.getInt("id"));
        classesModel.setClassName(rs.getString("class_name"));
        classesModel.setCourses(coursesModel);
        classesModel.setCoach(coachModel);
        classesModel.setStartDate(rs.getDate("start_date").toLocalDate());
        classesModel.setEndDate(rs.getDate("end_date").toLocalDate());
        classesModel.setCapacity(rs.getInt("capacity"));
        return classesModel;
    }

    @Override
    public void exportClassesToExcel() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT c.class_name, c.start_date, c.end_date, c.capacity, u.nama as coach_name FROM classes c INNER JOIN users u ON u.id = c.coach_id;";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Data");
            Row header = sheet.createRow(0);

            int columnCount = rs.getMetaData().getColumnCount();

            // Header
            for (int i = 1; i <= columnCount; i++) {
                Cell cell = header.createCell(i - 1);
                cell.setCellValue(rs.getMetaData().getColumnName(i));
            }

            // Insert Data to cell
            int rowNum = 1;
            while (rs.next()) {
                Row row = sheet.createRow(rowNum++);
                for (int i = 1; i <= columnCount; i++) {
                    row.createCell(i - 1).setCellValue(rs.getString(i));
                }
            }

            // Filepath
            File downloadFolder = FileSystemView.getFileSystemView().getDefaultDirectory();
            String filePath = downloadFolder.getAbsolutePath() + File.separator + "data_classes.xlsx";

            try (FileOutputStream out = new FileOutputStream(filePath)) {
                workbook.write(out);
                workbook.close();
                JOptionPane.showMessageDialog(null, "Export to excel success \nDownloaded on : " + filePath);
            } catch (IOException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Failed Export to excel");
            }
        } catch (SQLException e) {
            System.out.println("Error get data user : " + e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.out.println("Error close st get data user : " + e);
                }
            }

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("Error close rs get data user : " + e);
                }
            }
        }
    }
}
