/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.Koneksi;
import service.LoginService;
import model.LoginModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import library.CapitalizeConverter;
import library.Session;
import main.MenuUtama;
import view.FormLogin;

/**
 *
 * @author ramdhan
 */
public class LoginDAO implements LoginService {

    private final Connection conn;

    public LoginDAO() {
        conn = Koneksi.koneksi();
    }

    @Override
    public void prosesLogin(LoginModel loginModel) {
        PreparedStatement st = null;
        ResultSet rs = null;
        Integer userId = null;
        String username = null;
        String nama = null;
        String level = null;

        String sql = "SELECT * FROM users WHERE username = '" + loginModel.getUsername() + "' "
                + "AND status = 1 "
                + "AND password='" + Encrypt.getmd5java(loginModel.getPassword()) + "'";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if (rs.next()) {
                userId = rs.getInt("id");
                username = rs.getString("username");
                nama = rs.getString("nama");
                level = rs.getString("level");
                
                LoginModel mod = new LoginModel();
                mod.setUserId(userId);
                mod.setUsername(username);
                mod.setName(CapitalizeConverter.capitalizeWords(nama));
                mod.setLevel(level);
                
                Session.getInstance().setUser(mod);

                MenuUtama menu = new MenuUtama(mod);
                menu.setVisible(true);
                menu.revalidate();

                FormLogin.tutup = true;
            } else {
                JOptionPane.showMessageDialog(null, "Username atau Password salah", "Pesan", JOptionPane.INFORMATION_MESSAGE);
                FormLogin.tutup = false;
            }

        } catch (SQLException e) {
        }
    }
}
