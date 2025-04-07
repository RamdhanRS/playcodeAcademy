/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import view.FormClassRegist;
import view.FormClassSchedule;
import view.FormClasses;
import view.FormCourses;
import view.FormUser;

/**
 *
 * @author ramdh
 */
public class MenuUtama extends javax.swing.JFrame {

    /**
     * Creates new form menuUtama
     *
     */
    public MenuUtama(String username, String name, String level) {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        executed();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        pnl_sidebar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnl_menu = new javax.swing.JPanel();
        pnl_navbar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnl_content = new javax.swing.JPanel();
        pnl_utama = new javax.swing.JPanel();

        label1.setText("label1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnl_sidebar.setBackground(new java.awt.Color(255, 255, 255));
        pnl_sidebar.setPreferredSize(new java.awt.Dimension(250, 468));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        pnl_menu.setBackground(new java.awt.Color(255, 255, 255));
        pnl_menu.setLayout(new javax.swing.BoxLayout(pnl_menu, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(pnl_menu);

        javax.swing.GroupLayout pnl_sidebarLayout = new javax.swing.GroupLayout(pnl_sidebar);
        pnl_sidebar.setLayout(pnl_sidebarLayout);
        pnl_sidebarLayout.setHorizontalGroup(
            pnl_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_sidebarLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnl_sidebarLayout.setVerticalGroup(
            pnl_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );

        getContentPane().add(pnl_sidebar, java.awt.BorderLayout.LINE_START);

        pnl_navbar.setBackground(new java.awt.Color(76, 122, 227));
        pnl_navbar.setPreferredSize(new java.awt.Dimension(946, 70));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PlayCode Academy");

        javax.swing.GroupLayout pnl_navbarLayout = new javax.swing.GroupLayout(pnl_navbar);
        pnl_navbar.setLayout(pnl_navbarLayout);
        pnl_navbarLayout.setHorizontalGroup(
            pnl_navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_navbarLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addContainerGap(738, Short.MAX_VALUE))
        );
        pnl_navbarLayout.setVerticalGroup(
            pnl_navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_navbarLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getContentPane().add(pnl_navbar, java.awt.BorderLayout.PAGE_START);

        pnl_content.setBackground(new java.awt.Color(255, 255, 255));

        pnl_utama.setBackground(new java.awt.Color(255, 255, 255));
        pnl_utama.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout pnl_contentLayout = new javax.swing.GroupLayout(pnl_content);
        pnl_content.setLayout(pnl_contentLayout);
        pnl_contentLayout.setHorizontalGroup(
            pnl_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_contentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_utama, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE))
        );
        pnl_contentLayout.setVerticalGroup(
            pnl_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_utama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(pnl_content, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(962, 547));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        pnl_utama.add(new ContentBg());
        pnl_utama.repaint();
        pnl_utama.revalidate();
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MenuUtama("username", "nama", "level").setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private javax.swing.JPanel pnl_content;
    private javax.swing.JPanel pnl_menu;
    private javax.swing.JPanel pnl_navbar;
    private javax.swing.JPanel pnl_sidebar;
    private javax.swing.JPanel pnl_utama;
    // End of variables declaration//GEN-END:variables

    private void executed() {
        // Icon Master
        ImageIcon masterIcon = new ImageIcon(getClass().getResource("/asset/img/master_icon.png"));
        ImageIcon dashboardIcon = new ImageIcon(getClass().getResource("/asset/img/dashboard_icon.png"));
        ImageIcon reportIcon = new ImageIcon(getClass().getResource("/asset/img/report_icon.png"));
        ImageIcon registIcon = new ImageIcon(getClass().getResource("/asset/img/regist_icon.png"));
        ImageIcon scheduleIcon = new ImageIcon(getClass().getResource("/asset/img/schedule_icon.png"));
        ImageIcon subIcon = new ImageIcon(getClass().getResource("/asset/img/sort_icon.png"));

        MenuItem menuDashboard = new MenuItem(dashboardIcon, false, null, "Dashboard", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnl_utama.removeAll();
                pnl_utama.add(new ContentBg(), BorderLayout.CENTER);
                pnl_utama.repaint();
                pnl_utama.revalidate();
            }
        });

        MenuItem menuClassSchedule = new MenuItem(scheduleIcon, false, null, "Jadwal Kelas", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnl_utama.removeAll();
                pnl_utama.add(new FormClassSchedule(), BorderLayout.CENTER);
                pnl_utama.repaint();
                pnl_utama.revalidate();
            }
        });

        MenuItem menuClassRegist = new MenuItem(registIcon, false, null, "Daftar Kelas", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnl_utama.removeAll();
                pnl_utama.add(new FormClassRegist(), BorderLayout.CENTER);
                pnl_utama.repaint();
                pnl_utama.revalidate();
            }
        });

        // SubMenu dan Master Data
        MenuItem masterUser = new MenuItem(null, true, subIcon, "User", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnl_utama.removeAll();
                pnl_utama.add(new FormUser(), BorderLayout.CENTER);
                pnl_utama.repaint();
                pnl_utama.revalidate();
            }
        });
        MenuItem masterCourses = new MenuItem(null, true, subIcon, "Kursus", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnl_utama.removeAll();
                pnl_utama.add(new FormCourses(), BorderLayout.CENTER);
                pnl_utama.repaint();
                pnl_utama.revalidate();
            }
        });
        MenuItem masterClass = new MenuItem(null, true, subIcon, "Kelas", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnl_utama.removeAll();
                pnl_utama.add(new FormClasses(), BorderLayout.CENTER);
                pnl_utama.repaint();
                pnl_utama.revalidate();
            }
        });
        MenuItem menuMaster = new MenuItem(masterIcon, false, null, "Master", null, masterUser, masterCourses, masterClass);

        // SubMenu dan Master Report
        MenuItem masterAttendance = new MenuItem(null, true, subIcon, "Absensi", null);
        MenuItem menuReport = new MenuItem(reportIcon, false, null, "Report", null, masterAttendance);

        addMenu(menuDashboard, menuClassSchedule, menuClassRegist, menuMaster, menuReport
        );
    }

    private void addMenu(MenuItem... menu) {
        for (MenuItem menu1 : menu) {
            pnl_menu.add(menu1);
            ArrayList<MenuItem> subMenu = menu1.getSubMenu();
            for (MenuItem m : subMenu) {
                addMenu(m);
            }
        }
        pnl_menu.revalidate();
    }
}
