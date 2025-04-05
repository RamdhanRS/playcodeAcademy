/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClassSchedule/Class.java to edit this template
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
import model.ClassScheduleModel;
import model.ClassesModel;
import model.CoursesModel;
import model.UserModel;
import service.ClassScheduleService;

/**
 *
 * @author ramdh
 */
public class ClassScheduleDAO implements ClassScheduleService {

    private final Connection conn;

    public ClassScheduleDAO() {
        conn = Koneksi.koneksi();
    }

    @Override
    public void addClassSchedule(ClassScheduleModel classScheduleModel) {
        PreparedStatement st = null;
        String sql = "INSERT INTO class_schedules(class_id, day_of_week, start_time, end_time, created_at) VALUES (?,?,?,?,?)";

        try {
            st = conn.prepareStatement(sql);

            st.setInt(1, classScheduleModel.getClasses().getId());
            st.setString(2, classScheduleModel.getDayOfWeek());
            st.setTime(3, java.sql.Time.valueOf(classScheduleModel.getStartTime()));
            st.setTime(4, java.sql.Time.valueOf(classScheduleModel.getEndTime()));
            st.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));

            st.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Tambah data gagal");
            System.err.println("Error add classSchedule : " + e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.err.println("Error finally add classSchedule : " + e);
                }
            }
        }
    }

    @Override
    public void editClassSchedule(ClassScheduleModel classScheduleModel) {
        PreparedStatement st = null;
        String sql = "UPDATE class_schedules SET class_id=?, day_of_week=?, start_time=?, end_time=? WHERE id=?";

        try {
            st = conn.prepareStatement(sql);

            st.setInt(1, classScheduleModel.getClasses().getId());
            st.setString(2, classScheduleModel.getDayOfWeek());
            st.setTime(3, java.sql.Time.valueOf(classScheduleModel.getStartTime()));
            st.setTime(4, java.sql.Time.valueOf(classScheduleModel.getEndTime()));
            st.setInt(5, classScheduleModel.getId()); // ID harus tipe integer sesuai DB

            st.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Perbarui data gagal");
            System.err.println("Error edit classSchedule : " + e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.err.println("Error finally edit classSchedule : " + e);
                }
            }
        }
    }

    @Override
    public void deleteClassSchedule(ClassScheduleModel classScheduleModel) {
        PreparedStatement st = null;
        String sql = "DELETE FROM class_schedules WHERE id=?";

        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, classScheduleModel.getId());

            st.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hapus data gagal");
            System.err.println("Error delete classSchedule : " + e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.err.println("Error finally hapus classSchedule : " + e);
                }
            }
        }
    }

    @Override
    public ClassScheduleModel getById(int id) {
        String sql = "SELECT cs.id, cs.day_of_week, cs.start_time, cs.end_time,"
                + " u.id as coach_id, u.nama as coach_name,"
                + " cr.id as courses_id, cr.courses_name,"
                + " c.id as class_id, c.class_name"
                + " FROM class_schedules cs"
                + " INNER JOIN classes as c ON c.id = cs.class_id"
                + " INNER JOIN courses as cr ON cr.id = c.courses_id"
                + " INNER JOIN users as u ON u.id = c.coach_id"
                + " WHERE cs.id = ?";
        return getClassScheduleByQuery(sql, id);
    }

    @Override
    public List<ClassScheduleModel> getDataById() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ClassScheduleModel> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT cs.id, cs.day_of_week, cs.start_time, cs.end_time,"
                + " u.id as coach_id, u.nama as coach_name,"
                + " cr.id as courses_id, cr.courses_name,"
                + " c.id as class_id, c.class_name"
                + " FROM class_schedules cs"
                + " INNER JOIN classes as c ON c.id = cs.class_id"
                + " INNER JOIN courses as cr ON cr.id = c.courses_id"
                + " INNER JOIN users as u ON u.id = c.coach_id";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                // Masukkan data relasi class
                ClassesModel classesModel = new ClassesModel();
                classesModel.setId(rs.getInt("class_id"));
                classesModel.setClassName(rs.getString("class_name"));

                // Masukkan data relasi coachModel
                UserModel coachModel = new UserModel();
                coachModel.setId(rs.getInt("coach_id"));
                coachModel.setNama(rs.getString("coach_name"));

                // Masukkan data relasi courseModel
                CoursesModel coursesModel = new CoursesModel();
                coursesModel.setId(rs.getInt("courses_id"));
                coursesModel.setCourseName(rs.getString("courses_name"));

                // Masukkan data hasil akhir
                ClassScheduleModel classScheduleModel = new ClassScheduleModel();
                classScheduleModel.setId(rs.getInt("id"));
                classScheduleModel.setClasses(classesModel);
                classScheduleModel.setCourses(coursesModel);
                classScheduleModel.setCoach(coachModel);
                classScheduleModel.setDayOfWeek(rs.getString("day_of_week"));
                classScheduleModel.setStartTime(rs.getTime("start_time").toLocalTime());
                classScheduleModel.setEndTime(rs.getTime("end_time").toLocalTime());

                list.add(classScheduleModel);
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Error get data classSchedule : " + e);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.out.println("Error close st get data classSchedule : " + e);
                }
            }

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("Error close rs get data classSchedule : " + e);
                }
            }
        }
    }

    @Override
    public List<ClassScheduleModel> searching(String nama) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private ClassScheduleModel getClassScheduleByQuery(String sql, Object... params) {
        ClassScheduleModel classScheduleModel = null;
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                st.setObject(i + 1, params[i]);
            }
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                classScheduleModel = mapClassSchedule(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error => " + e);
        }
        return classScheduleModel;
    }

    private ClassScheduleModel mapClassSchedule(ResultSet rs) throws SQLException {
        // Masukkan data relasi class
        ClassesModel classesModel = new ClassesModel();
        classesModel.setId(rs.getInt("class_id"));
        classesModel.setClassName(rs.getString("class_name"));

        // Masukkan data relasi coachModel
        UserModel coachModel = new UserModel();
        coachModel.setId(rs.getInt("coach_id"));
        coachModel.setNama(rs.getString("coach_name"));

        // Masukkan data relasi courseModel
        CoursesModel coursesModel = new CoursesModel();
        coursesModel.setId(rs.getInt("courses_id"));
        coursesModel.setCourseName(rs.getString("courses_name"));

        // Masukkan data hasil akhir
        ClassScheduleModel classScheduleModel = new ClassScheduleModel();
        classScheduleModel.setId(rs.getInt("id"));
        classScheduleModel.setClasses(classesModel);
        classScheduleModel.setCourses(coursesModel);
        classScheduleModel.setCoach(coachModel);
        classScheduleModel.setDayOfWeek(rs.getString("day_of_week"));
        classScheduleModel.setStartTime(rs.getTime("start_time").toLocalTime());
        classScheduleModel.setEndTime(rs.getTime("end_time").toLocalTime());

        return classScheduleModel;
    }
}
