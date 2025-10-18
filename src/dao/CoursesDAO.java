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
import library.ErrorUtils;
import model.CoursesModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import service.CoursesService;

/**
 *
 * @author ramdhan
 */
public class CoursesDAO implements CoursesService {

    private final Connection conn;

    public CoursesDAO() {
        conn = Koneksi.koneksi();
    }

    @Override
    public void addCourses(CoursesModel coursesModel) {
        PreparedStatement st = null;
        String sql = "INSERT INTO courses(courses_name, description, duration, price, created_at) VALUES (?,?,?,?,?)";

        try {
            st = conn.prepareStatement(sql);

            st.setString(1, coursesModel.getCourseName());
            st.setString(2, coursesModel.getDescription());
            st.setInt(3, coursesModel.getDuration());
            st.setBigDecimal(4, coursesModel.getPrice());
            st.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
            st.executeUpdate();

            JOptionPane.showMessageDialog(null, "✅ Data kursus berhasil ditambahkan!", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            ErrorUtils.showUserFriendlyError("insert");
            ErrorUtils.logError("add course", e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    ErrorUtils.logError("finally add course", e);
                }
            }
        }
    }

    @Override
    public void editCourses(CoursesModel coursesModel) {
        PreparedStatement st = null;
        String sql = "UPDATE courses SET courses_name=?, description=?, duration=?, price=? WHERE id=?";

        try {
            st = conn.prepareStatement(sql);

            st.setString(1, coursesModel.getCourseName());
            st.setString(2, coursesModel.getDescription());
            st.setInt(3, coursesModel.getDuration());
            st.setBigDecimal(4, coursesModel.getPrice());
            st.setInt(5, coursesModel.getId()); // ID harus tipe integer sesuai DB

            st.executeUpdate();

            JOptionPane.showMessageDialog(null, "✅ Data kursus berhasil diperbarui!", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            ErrorUtils.showUserFriendlyError("update");
            ErrorUtils.logError("edit course", e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    ErrorUtils.logError("finally edit course", e);
                }
            }
        }
    }

    @Override
    public void deleteCourses(CoursesModel coursesModel) {
        PreparedStatement st = null;
        String sql = "DELETE FROM courses WHERE id=?";

        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, coursesModel.getId());
            st.executeUpdate();

            JOptionPane.showMessageDialog(null, "✅ Data kursus berhasil dihapus!", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            ErrorUtils.showUserFriendlyError("delete");
            ErrorUtils.logError("delete course", e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    ErrorUtils.logError("finally delete course", e);
                }
            }
        }
    }

    @Override
    public CoursesModel getById(int id) {
        String sql = "SELECT * FROM courses WHERE id = ?";
        return getCoursesByQuery(sql, id);
    }

    @Override
    public List<CoursesModel> getDataById() {
        throw new UnsupportedOperationException("Belum didukung saat ini.");
    }

    @Override
    public List<CoursesModel> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM courses";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                CoursesModel coursesModel = new CoursesModel();

                coursesModel.setId(rs.getInt("id"));
                coursesModel.setCourseName(rs.getString("courses_name"));
                coursesModel.setDescription(rs.getString("description"));
                coursesModel.setDuration(rs.getInt("duration"));
                coursesModel.setPrice(rs.getBigDecimal("price"));

                list.add(coursesModel);
            }
            return list;
        } catch (SQLException e) {
            ErrorUtils.logError("get data course", e);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    ErrorUtils.logError("close st data course", e);
                }
            }

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    ErrorUtils.logError("close rs data course", e);
                }
            }
        }
    }

    @Override
    public List<CoursesModel> searching(String nama) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM courses WHERE courses_name LIKE '%" + nama + "%'";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                CoursesModel coursesModel = new CoursesModel();

                coursesModel.setId(rs.getInt("id"));
                coursesModel.setCourseName(rs.getString("courses_name"));
                coursesModel.setDescription(rs.getString("description"));
                coursesModel.setDuration(rs.getInt("duration"));
                coursesModel.setPrice(rs.getBigDecimal("price"));

                list.add(coursesModel);
            }
            return list;
        } catch (SQLException e) {
            ErrorUtils.logError("get data course", e);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    ErrorUtils.logError("close st data course", e);
                }
            }

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    ErrorUtils.logError("close rs data course", e);
                }
            }
        }
    }

    private CoursesModel getCoursesByQuery(String sql, Object... params) {
        CoursesModel coursesModel = null;
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                st.setObject(i + 1, params[i]);
            }
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                coursesModel = mapCourses(rs);
            }
        } catch (SQLException e) {
            ErrorUtils.logError("get data", e);
        }
        return coursesModel;
    }

    private CoursesModel mapCourses(ResultSet rs) throws SQLException {
        CoursesModel courses = new CoursesModel();
        courses.setId(rs.getInt("id"));
        courses.setCourseName(rs.getString("courses_name"));
        courses.setDescription(rs.getString("description"));
        courses.setDuration(rs.getInt("duration"));
        courses.setPrice(rs.getBigDecimal("price"));
        courses.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
        return courses;
    }

    @Override
    public void exportCoursesToExcel() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT courses_name, description, duration, price FROM courses";

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
            String filePath = downloadFolder.getAbsolutePath() + File.separator + "data_courses.xlsx";

            try (FileOutputStream out = new FileOutputStream(filePath)) {
                workbook.write(out);
                workbook.close();
                JOptionPane.showMessageDialog(null, "✅ Ekspor ke Excel berhasil!\n\nFile tersimpan di:\n" + filePath, "Ekspor Berhasil", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                ErrorUtils.showUserFriendlyError("export");
            }
        } catch (SQLException e) {
            ErrorUtils.logError("get data course", e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    ErrorUtils.logError("close st get data course", e);
                }
            }

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    ErrorUtils.logError("close rs get data user", e);
                }
            }
        }
    }

    @Override
    public Long countCourses() {
        PreparedStatement st = null;
        Long count = 0L;
        ResultSet rs = null;
        String sql = "SELECT COUNT(*) FROM courses";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if (rs.next()) {
                count = rs.getLong(1);
            }
            return count;
        } catch (SQLException e) {
            ErrorUtils.showUserFriendlyError("count");
            ErrorUtils.logError("get courses count", e);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    ErrorUtils.logError("close st get data course", e);
                }
            }

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    ErrorUtils.logError("close rs count data course", e);
                }
            }
        }
    }
}
