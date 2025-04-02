/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.CoursesModel;
import service.CoursesService;

/**
 *
 * @author ramdh
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
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Tambah data gagal");
            System.err.println("Error add courses : " + e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.err.println("Error finally add courses : " + e);
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
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Perbarui data gagal");
            System.err.println("Error edit courses : " + e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.err.println("Error finally edit courses : " + e);
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
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hapus data gagal");
            System.err.println("Error edit courses : " + e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.err.println("Error finally hapus courses : " + e);
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
        throw new UnsupportedOperationException("Not supported yet.");
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
            System.out.println("Error get data courses : " + e);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.out.println("Error close st get data courses : " + e);
                }
            }

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("Error close rs get data courses : " + e);
                }
            }
        }
    }

    @Override
    public List<CoursesModel> searching(String nama) {
        throw new UnsupportedOperationException("Not supported yet.");
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
            System.err.println("Error => " + e);
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
}
