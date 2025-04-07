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
import model.UserModel;
import service.UserService;

/**
 *
 * @author ramdh
 */
public class UserDAO implements UserService {

    private final Connection conn;

    public UserDAO() {
        conn = Koneksi.koneksi();
    }

    @Override
    public void addUser(UserModel userModel) {
        PreparedStatement st = null;
        String sql = "INSERT INTO users(username, password, nama, email, no_hp, alamat, tgl_lahir, level, status, created_at) VALUES (?,?,?,?,?,?,?,?,?,?)";

        try {
            st = conn.prepareStatement(sql);

            st.setString(1, userModel.getUsername());
            st.setString(2, userModel.getPassword());
            st.setString(3, userModel.getNama());
            st.setString(4, userModel.getEmail());
            st.setString(5, userModel.getNoHp());
            st.setString(6, userModel.getAlamat());
            st.setDate(7, java.sql.Date.valueOf(userModel.getTglLahir()));
            st.setString(8, userModel.getLevel());
            st.setString(9, "1");
            st.setTimestamp(10, Timestamp.valueOf(LocalDateTime.now()));

            st.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Tambah data gagal");
            System.err.println("Error add user : " + e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.err.println("Error finally add user : " + e);
                }
            }
        }
    }

    @Override
    public void editUser(UserModel userModel) {
        PreparedStatement st = null;
        String sql = "UPDATE users SET username=?, password=?, nama=?, email=?, no_hp=?, alamat=?, tgl_lahir=?, level=? WHERE id=?";

        try {
            st = conn.prepareStatement(sql);

            st.setString(1, userModel.getUsername());
            st.setString(2, userModel.getPassword());
            st.setString(3, userModel.getNama());
            st.setString(4, userModel.getEmail());
            st.setString(5, userModel.getNoHp());
            st.setString(6, userModel.getAlamat());
            st.setDate(7, java.sql.Date.valueOf(userModel.getTglLahir())); // Pastikan format tanggal sesuai
            st.setString(8, userModel.getLevel());
            st.setInt(9, userModel.getId()); // ID harus tipe integer sesuai DB

            st.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Perbarui data gagal");
            System.err.println("Error edit user : " + e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.err.println("Error finally edit user : " + e);
                }
            }
        }
    }

    @Override
    public void deleteUser(UserModel userModel) {
        PreparedStatement st = null;
        String sql = "DELETE FROM users WHERE id=?";

        try {
            st = conn.prepareStatement(sql);

            st.setInt(1, userModel.getId());

            st.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hapus data gagal");
            System.err.println("Error edit user : " + e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.err.println("Error finally hapus user : " + e);
                }
            }
        }
    }

    @Override
    public UserModel getById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return getUserByQuery(sql, id);
    }

    @Override
    public List<UserModel> getDataById() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<UserModel> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM users";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                UserModel userModel = new UserModel();

                userModel.setId(rs.getInt("id"));
                userModel.setUsername(rs.getString("username"));
                userModel.setPassword(rs.getString("password"));
                userModel.setNama(rs.getString("nama"));
                userModel.setEmail(rs.getString("email"));
                userModel.setNoHp(rs.getString("no_hp"));
                userModel.setAlamat(rs.getString("alamat"));
                userModel.setJenisKelamin(rs.getString("jenis_kelamin"));
                userModel.setTglLahir(rs.getDate("tgl_lahir").toLocalDate());
                userModel.setLevel(rs.getString("level"));
                userModel.setStatus(rs.getInt("status"));

                list.add(userModel);
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Error get data user : " + e);
            return null;
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

    @Override
    public List<UserModel> searching(String nama) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM users WHERE nama LIKE '&" + nama + "&'";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                UserModel userModel = new UserModel();

                userModel.setId(rs.getInt("id"));
                userModel.setUsername(rs.getString("username"));
                userModel.setPassword(rs.getString("password"));
                userModel.setNama(rs.getString("nama"));
                userModel.setEmail(rs.getString("email"));
                userModel.setNoHp(rs.getString("no_hp"));
                userModel.setAlamat(rs.getString("alamat"));
                userModel.setTglLahir(rs.getDate("tgl_lahir").toLocalDate());
                userModel.setLevel(rs.getString("level"));
                userModel.setStatus(rs.getInt("status"));

                list.add(userModel);
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Error get data user : " + e);
            return null;
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

    @Override
    public List<UserModel> searchingCoach(String nama) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM users WHERE level = 'pengajar' nama LIKE '&" + nama + "&'";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                UserModel userModel = new UserModel();

                userModel.setId(rs.getInt("id"));
                userModel.setUsername(rs.getString("username"));
                userModel.setPassword(rs.getString("password"));
                userModel.setNama(rs.getString("nama"));
                userModel.setEmail(rs.getString("email"));
                userModel.setNoHp(rs.getString("no_hp"));
                userModel.setAlamat(rs.getString("alamat"));
                userModel.setTglLahir(rs.getDate("tgl_lahir").toLocalDate());
                userModel.setLevel(rs.getString("level"));
                userModel.setStatus(rs.getInt("status"));

                list.add(userModel);
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Error get data user : " + e);
            return null;
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

    private UserModel getUserByQuery(String sql, Object... params) {
        UserModel userModel = null;
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                st.setObject(i + 1, params[i]);
            }
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                userModel = mapUser(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error => " + e);
        }
        return userModel;
    }

    private UserModel mapUser(ResultSet rs) throws SQLException {
        UserModel user = new UserModel();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setNama(rs.getString("nama"));
        user.setEmail(rs.getString("email"));
        user.setNoHp(rs.getString("no_hp"));
        user.setAlamat(rs.getString("alamat"));
        user.setTglLahir(rs.getDate("tgl_lahir").toLocalDate());
        user.setJenisKelamin(rs.getString("jenis_kelamin"));
        user.setLevel(rs.getString("level"));
        user.setStatus(rs.getInt("status"));
        user.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
        return user;
    }
}
