/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClassRegist/Class.java to edit this template
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
import model.ClassRegistModel;
import model.ClassesModel;
import model.CoursesModel;
import model.UserModel;
import service.ClassRegistService;

/**
 *
 * @author ramdh
 */
public class ClassRegistDAO implements ClassRegistService {

    private final Connection conn;

    public ClassRegistDAO() {
        conn = Koneksi.koneksi();
    }

    @Override
    public void addClassRegist(ClassRegistModel classRegistModel) {
        PreparedStatement st = null;
        String sql = "INSERT INTO class_registrations(class_id, student_id, registered_date, created_at) VALUES (?,?,?,?)";

        try {
            st = conn.prepareStatement(sql);

            st.setInt(1, classRegistModel.getClasses().getId());
            st.setInt(2, classRegistModel.getStudent().getId());
            st.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            st.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));

            st.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Tambah data gagal");
            System.err.println("Error add classRegist : " + e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.err.println("Error finally add classRegist : " + e);
                }
            }
        }
    }

    @Override
    public void deleteClassRegist(ClassRegistModel classRegistModel) {
        PreparedStatement st = null;
        String sql = "DELETE FROM class_registrations WHERE class_id=?";

        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, classRegistModel.getId());

            st.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hapus data gagal");
            System.err.println("Error delete classRegist : " + e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.err.println("Error finally hapus classRegist : " + e);
                }
            }
        }
    }

    @Override
    public ClassRegistModel getById(int id) {
        String sql = "SELECT cr.id, cr.registered_date,"
                + " c.id AS class_id, c.class_name, c.start_date as class_start_period, c.end_date as class_end_period,"
                + " s.id AS student_id, s.nama as student_name, s.jenis_kelamin as student_gender, s.level as student_level, s.tgl_lahir as student_date_of_birth, s.no_hp as student_number, s.email as student_email,"
                + " co.id AS courses_id, co.courses_name,"
                + " ch.id AS coach_id, ch.nama AS coach_name"
                + " FROM class_registrations cr"
                + " INNER JOIN classes c ON c.id = cr.class_id"
                + " INNER JOIN users s ON s.id = cr.student_id"
                + " INNER JOIN courses co ON co.id = c.courses_id"
                + " INNER JOIN users ch ON ch.id = c.coach_id"
                + " WHERE cr.id = ?";

        return getClassRegistByQuery(sql, id);
    }

    @Override
    public List<ClassRegistModel> getDataById(int id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT cr.id, cr.registered_date,"
                + " c.id AS class_id, c.class_name, c.start_date as class_start_period, c.end_date as class_end_period,"
                + " s.id AS student_id, s.nama as student_name, s.jenis_kelamin as student_gender, s.level as student_level, s.tgl_lahir as student_date_of_birth, s.no_hp as student_number, s.email as student_email,"
                + " co.id AS courses_id, co.courses_name,"
                + " ch.id AS coach_id, ch.nama AS coach_name"
                + " FROM class_registrations cr"
                + " INNER JOIN classes c ON c.id = cr.class_id"
                + " INNER JOIN users s ON s.id = cr.student_id"
                + " INNER JOIN courses co ON co.id = c.courses_id"
                + " INNER JOIN users ch ON ch.id = c.coach_id"
                + " WHERE cr.id = ?";

        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            while (rs.next()) {
                // Masukkan data relasi class
                ClassesModel classesModel = new ClassesModel();
                classesModel.setId(rs.getInt("class_id"));
                classesModel.setClassName(rs.getString("class_name"));
                classesModel.setStartDate(rs.getDate("class_start_period").toLocalDate());
                classesModel.setEndDate(rs.getDate("class_end_period").toLocalDate());

                // Masukkan data relasi courseModel
                CoursesModel coursesModel = new CoursesModel();
                coursesModel.setId(rs.getInt("courses_id"));
                coursesModel.setCourseName(rs.getString("courses_name"));

                // Masukkan data relasi coachModel
                UserModel coachModel = new UserModel();
                coachModel.setId(rs.getInt("coach_id"));
                coachModel.setNama(rs.getString("coach_name"));

                // Masukkan data studentModel
                UserModel studentModel = new UserModel();
                studentModel.setId(rs.getInt("student_id"));
                studentModel.setNama(rs.getString("student_name"));
                studentModel.setJenisKelamin(rs.getString("student_gender"));
                studentModel.setTglLahir(rs.getDate("student_date_of_birth").toLocalDate());
                studentModel.setNoHp(rs.getString("student_number"));
                studentModel.setEmail(rs.getString("student_email"));
                studentModel.setLevel(rs.getString("student_level"));

                // Masukkan data hasil akhir
                ClassRegistModel classRegistModel = new ClassRegistModel();
                classRegistModel.setId(rs.getInt("id"));
                classRegistModel.setClasses(classesModel);
                classRegistModel.setCourses(coursesModel);
                classRegistModel.setCoach(coachModel);
                classRegistModel.setStudent(studentModel);
                classRegistModel.setRegisteredDate(rs.getDate("registered_date").toLocalDate());

                list.add(classRegistModel);
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Error get data classRegist : " + e);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.out.println("Error close st get data classRegist : " + e);
                }
            }

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("Error close rs get data classRegist : " + e);
                }
            }
        }
    }

    @Override
    public List<UserModel> getDataStudentById(int id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT s.id AS student_id, s.nama as student_name, s.jenis_kelamin as student_gender,"
                + " s.level as student_level, s.tgl_lahir as student_date_of_birth,"
                + " s.no_hp as student_number, s.email as student_email"
                + " FROM class_registrations cr"
                + " INNER JOIN users s ON s.id = cr.student_id"
                + " INNER JOIN classes c ON c.id = cr.class_id"
                + " WHERE c.id = ? AND s.level = 'siswa'";

        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            while (rs.next()) {
                UserModel studentModel = new UserModel();
                studentModel.setId(rs.getInt("student_id"));
                studentModel.setNama(rs.getString("student_name"));
                studentModel.setJenisKelamin(rs.getString("student_gender"));
                studentModel.setLevel(rs.getString("student_level"));
                studentModel.setTglLahir(rs.getDate("student_date_of_birth").toLocalDate());
                studentModel.setNoHp(rs.getString("student_number"));
                studentModel.setEmail(rs.getString("student_email"));

                list.add(studentModel);
            }

            return list;
        } catch (SQLException e) {
            System.out.println("Error get data classRegist : " + e);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.out.println("Error close st get data classRegist : " + e);
                }
            }

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("Error close rs get data classRegist : " + e);
                }
            }
        }
    }

    @Override
    public List<ClassRegistModel> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT cr.id, cr.registered_date,"
                + " c.id as class_id, c.class_name,"
                + " s.id as student_id, s.nama as student_name,"
                + " co.id as courses_id, co.courses_name,"
                + " ch.id as coach_id, ch.nama as coach_name"
                + " FROM class_registrations cr"
                + " INNER JOIN classes c ON c.id = cr.class_id"
                + " INNER JOIN users s ON s.id = cr.student_id"
                + " INNER JOIN courses co ON co.id = c.courses_id"
                + " INNER JOIN users ch ON ch.id = c.coach_id"
                + " GROUP BY c.class_name";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                // Masukkan data relasi class
                ClassesModel classesModel = new ClassesModel();
                classesModel.setId(rs.getInt("class_id"));
                classesModel.setClassName(rs.getString("class_name"));

                // Masukkan data relasi courseModel
                CoursesModel coursesModel = new CoursesModel();
                coursesModel.setId(rs.getInt("courses_id"));
                coursesModel.setCourseName(rs.getString("courses_name"));

                // Masukkan data relasi coachModel
                UserModel coachModel = new UserModel();
                coachModel.setId(rs.getInt("coach_id"));
                coachModel.setNama(rs.getString("coach_name"));

                // Masukkan data studentModel
                UserModel studentModel = new UserModel();
                studentModel.setId(rs.getInt("student_id"));
                studentModel.setNama(rs.getString("student_name"));

                // Masukkan data hasil akhir
                ClassRegistModel classRegistModel = new ClassRegistModel();
                classRegistModel.setId(rs.getInt("id"));
                classRegistModel.setClasses(classesModel);
                classRegistModel.setCourses(coursesModel);
                classRegistModel.setCoach(coachModel);
                classRegistModel.setStudent(studentModel);
                classRegistModel.setRegisteredDate(rs.getDate("registered_date").toLocalDate());

                list.add(classRegistModel);
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Error get data classRegist : " + e);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.out.println("Error close st get data classRegist : " + e);
                }
            }

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("Error close rs get data classRegist : " + e);
                }
            }
        }
    }

    @Override
    public List<ClassRegistModel> searching(String nama) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private ClassRegistModel getClassRegistByQuery(String sql, Object... params) {
        ClassRegistModel classRegistModel = null;
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                st.setObject(i + 1, params[i]);
            }
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                classRegistModel = mapClassRegist(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error => " + e);
        }
        return classRegistModel;
    }

    private ClassRegistModel mapClassRegist(ResultSet rs) throws SQLException {
        // Masukkan data relasi class
        ClassesModel classesModel = new ClassesModel();
        classesModel.setId(rs.getInt("class_id"));
        classesModel.setClassName(rs.getString("class_name"));
        classesModel.setStartDate(rs.getDate("class_start_period").toLocalDate());
        classesModel.setEndDate(rs.getDate("class_end_period").toLocalDate());

        // Masukkan data relasi courseModel
        CoursesModel coursesModel = new CoursesModel();
        coursesModel.setId(rs.getInt("courses_id"));
        coursesModel.setCourseName(rs.getString("courses_name"));

        // Masukkan data relasi coachModel
        UserModel coachModel = new UserModel();
        coachModel.setId(rs.getInt("coach_id"));
        coachModel.setNama(rs.getString("coach_name"));

        // Masukkan data studentModel
        UserModel studentModel = new UserModel();
        studentModel.setId(rs.getInt("student_id"));
        studentModel.setNama(rs.getString("student_name"));

        // Masukkan data hasil akhir
        ClassRegistModel classRegistModel = new ClassRegistModel();
        classRegistModel.setId(rs.getInt("id"));
        classRegistModel.setClasses(classesModel);
        classRegistModel.setCourses(coursesModel);
        classRegistModel.setCoach(coachModel);
        classRegistModel.setStudent(studentModel);
        classRegistModel.setRegisteredDate(rs.getDate("registered_date").toLocalDate());

        return classRegistModel;
    }
}
