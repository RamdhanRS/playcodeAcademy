/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import dao.ClassesDAO;
import dao.CoursesDAO;
import dao.UserDAO;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import model.UserModel;
import service.UserService;
import tableModel.UserTableModel;
import javax.swing.JOptionPane;
import model.ClassesModel;
import model.CoursesModel;
import service.ClassesService;
import service.CoursesService;
import tableModel.ClassesTableModel;

/**
 *
 * @author ramdh
 */
public class FormClasses extends javax.swing.JPanel {

    private final UserService userService = new UserDAO();
    private final UserTableModel userTableModel = new UserTableModel();
    private final CoursesService coursesService = new CoursesDAO();
    private final ClassesService classesService = new ClassesDAO();
    private final ClassesTableModel classesTableModel = new ClassesTableModel();

    public FormClasses() {
        initComponents();

        txtCoursesId.setVisible(false);
        txtCoachId.setVisible(false);
        tblClasses.setModel(classesTableModel);
        loadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        dataClasses = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClasses = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        addClasses = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnBatalTambah = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtCoach = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCapacity = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dtStartDate = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        dtEndDate = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        btnSelectCoach = new javax.swing.JButton();
        txtCourses = new javax.swing.JTextField();
        btnSelectCourse = new javax.swing.JButton();
        txtCoursesId = new javax.swing.JTextField();
        txtCoachId = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(899, 620));
        setLayout(new java.awt.CardLayout());

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(new java.awt.CardLayout());

        dataClasses.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tblClasses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblClasses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClassesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClasses);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setText("Data Kelas");

        btnTambah.setText("Tambah");
        btnTambah.setPreferredSize(new java.awt.Dimension(85, 30));
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.setPreferredSize(new java.awt.Dimension(85, 30));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.setPreferredSize(new java.awt.Dimension(85, 30));
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dataClassesLayout = new javax.swing.GroupLayout(dataClasses);
        dataClasses.setLayout(dataClassesLayout);
        dataClassesLayout.setHorizontalGroup(
            dataClassesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 902, Short.MAX_VALUE)
            .addGroup(dataClassesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataClassesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        dataClassesLayout.setVerticalGroup(
            dataClassesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataClassesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(dataClassesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainPanel.add(dataClasses, "card2");

        addClasses.setBackground(new java.awt.Color(255, 255, 255));
        addClasses.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel2.setText("Tambah Data Kelas");
        addClasses.add(jLabel2);
        jLabel2.setBounds(6, 6, 269, 41);

        btnSimpan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSimpan.setText("Tambah");
        btnSimpan.setPreferredSize(new java.awt.Dimension(74, 30));
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        addClasses.add(btnSimpan);
        btnSimpan.setBounds(708, 73, 85, 30);

        btnBatalTambah.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBatalTambah.setText("Batal");
        btnBatalTambah.setPreferredSize(new java.awt.Dimension(85, 30));
        btnBatalTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalTambahActionPerformed(evt);
            }
        });
        addClasses.add(btnBatalTambah);
        btnBatalTambah.setBounds(811, 73, 85, 30);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setText("Nama Kelas");

        txtCoach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCoach.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(76, 122, 227)));
        txtCoach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCoachActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setText("Jenis Kursus");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setText("Tanggal Mulai");

        txtCapacity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCapacity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(76, 122, 227)));
        txtCapacity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCapacityActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setText("Kapasitas Kelas");

        dtStartDate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(76, 122, 227)));
        dtStartDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel12.setText("Tanggal Selesai");

        dtEndDate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(76, 122, 227)));
        dtEndDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel13.setText("Pengajar / Pelatih");

        txtNama.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNama.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(76, 122, 227)));
        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });

        btnSelectCoach.setText("Pilih");
        btnSelectCoach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectCoachActionPerformed(evt);
            }
        });

        txtCourses.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCourses.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(76, 122, 227)));
        txtCourses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCoursesActionPerformed(evt);
            }
        });

        btnSelectCourse.setText("Pilih");
        btnSelectCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectCourseActionPerformed(evt);
            }
        });

        txtCoursesId.setText("coursesId");

        txtCoachId.setText("coachId");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCoursesId, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCoachId))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSelectCourse, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCoach, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSelectCoach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel5)
                    .addComponent(txtNama)
                    .addComponent(dtStartDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dtEndDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCapacity))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSelectCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSelectCoach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCoach, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCoursesId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCoachId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(274, Short.MAX_VALUE))
        );

        addClasses.add(jPanel1);
        jPanel1.setBounds(0, 121, 902, 830);

        mainPanel.add(addClasses, "card2");

        add(mainPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void dataTabel() {
        dataClasses.setVisible(false);
        addClasses.setVisible(true);

        int row = tblClasses.getSelectedRow();
        jLabel2.setText("Perbarui Data Kelas");

        int classId = (int) tblClasses.getModel().getValueAt(row, 0);
        ClassesModel classesModel = classesService.getById(classId);

        txtNama.setText(classesModel.getClassName());
        txtCourses.setText(classesModel.getCourses().getCourseName());
        txtCoursesId.setText(classesModel.getCourses().getId().toString());
        txtCoach.setText(classesModel.getCoach().getNama());
        txtCoachId.setText(classesModel.getCoach().getId().toString());
        dtStartDate.setDate(Date.from(classesModel.getStartDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        dtEndDate.setDate(Date.from(classesModel.getEndDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        txtCapacity.setText(classesModel.getCapacity().toString());

        active();
        btnSimpan.setText("Perbarui");
        btnBatalTambah.setVisible(true);
    }

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        mainPanel.add(addClasses);
        mainPanel.repaint();
        mainPanel.revalidate();

        btnSimpan.setText("Simpan");
        if (btnTambah.getText().equals("Ubah")) {
            dataTabel();
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        deleteData();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        showPanel();
        loadData();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnBatalTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalTambahActionPerformed
        showPanel();
        loadData();
        resetForm();
    }//GEN-LAST:event_btnBatalTambahActionPerformed

    private void txtCoachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCoachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCoachActionPerformed

    private void txtCapacityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCapacityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCapacityActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        switch (btnSimpan.getText()) {
            case "Tambah" ->
                btnSimpan.setText("Simpan");
            case "Simpan" ->
                createData();
            case "Perbarui" ->
                updateData();
            default -> {
            }
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void tblClassesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClassesMouseClicked
        if (btnTambah.getText().equals("Tambah")) {
            btnTambah.setText("Ubah");
        }

        btnHapus.setVisible(true);
        btnBatal.setVisible(true);
    }//GEN-LAST:event_tblClassesMouseClicked

    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaActionPerformed

    private void btnSelectCoachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectCoachActionPerformed
        boolean closable = true;
        DataCoach dc = new DataCoach(null, closable);
        dc.setVisible(true);

        txtCoachId.setText(dc.userModel.getId().toString());
        txtCoach.setText(dc.userModel.getNama());
    }//GEN-LAST:event_btnSelectCoachActionPerformed

    private void txtCoursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCoursesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCoursesActionPerformed

    private void btnSelectCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectCourseActionPerformed
        boolean closable = true;
        DataCourses dc = new DataCourses(null, closable);
        dc.setVisible(true);

        txtCoursesId.setText(dc.coursesModel.getId().toString());
        txtCourses.setText(dc.coursesModel.getCourseName());
    }//GEN-LAST:event_btnSelectCourseActionPerformed

    private void active() {
        txtCoach.setEnabled(true);
        txtCourses.setEnabled(true);
        txtCoach.setEnabled(true);
        dtStartDate.setEnabled(true);
        dtEndDate.setEnabled(true);
        txtCapacity.setEnabled(true);
    }

    private void loadData() {
        btnHapus.setVisible(false);
        btnBatal.setVisible(false);
        List<ClassesModel> list = classesService.getData();
        classesTableModel.setData(list);

        tblClasses.getColumnModel().getColumn(0).setMinWidth(0);
        tblClasses.getColumnModel().getColumn(0).setMaxWidth(0);
        tblClasses.getColumnModel().getColumn(0).setWidth(0);
    }

    private void createData() {
        if (validasiInput() == true) {
            String className = txtNama.getText();
            int coursesId = Integer.parseInt(txtCoursesId.getText());
            int coachId = Integer.parseInt(txtCoachId.getText());
            Date startDate = dtStartDate.getDate();
            Date endDate = dtEndDate.getDate();
            int capacity = Integer.parseInt(txtCapacity.getText());

            // Mengambil hasil relasi nya
            CoursesModel getCoursesModel = coursesService.getById(coursesId);
            UserModel getCoachModel = userService.getById(coachId);

            ClassesModel classesModel = new ClassesModel();
            classesModel.setClassName(className);
            classesModel.setCourses(getCoursesModel);
            classesModel.setCoach(getCoachModel);
            classesModel.setStartDate(library.DateConverter.convertToLocalDate(startDate));
            classesModel.setEndDate(library.DateConverter.convertToLocalDate(endDate));
            classesModel.setCapacity(capacity);

            classesService.addClasses(classesModel);
            classesTableModel.addClasses(classesModel);

            loadData();
            resetForm();
            showPanel();
            btnSimpan.setText("Tambah");
        }
    }

    private void updateData() {
        int row = tblClasses.getSelectedRow();
        if (row != -1) {
            if (validasiInput() == true) {
                String className = txtNama.getText();
                int coursesId = Integer.parseInt(txtCoursesId.getText());
                int coachId = Integer.parseInt(txtCoachId.getText());
                Date startDate = dtStartDate.getDate();
                Date endDate = dtEndDate.getDate();
                int capacity = Integer.parseInt(txtCapacity.getText());

                // Mengambil hasil relasi nya
                CoursesModel getCoursesModel = coursesService.getById(coursesId);
                UserModel getCoachModel = userService.getById(coachId);

                ClassesModel classesModel = new ClassesModel();
                classesModel.setId((int) tblClasses.getModel().getValueAt(row, 0));
                classesModel.setClassName(className);
                classesModel.setCourses(getCoursesModel);
                classesModel.setCoach(getCoachModel);
                classesModel.setStartDate(library.DateConverter.convertToLocalDate(startDate));
                classesModel.setEndDate(library.DateConverter.convertToLocalDate(endDate));
                classesModel.setCapacity(capacity);

                classesService.editClasses(classesModel);
                classesTableModel.editClasses(row, classesModel);
                loadData();
                resetForm();
                showPanel();
            }
        }
    }

    private void deleteData() {
        int index = tblClasses.getSelectedRow();
        if (index != -1) {
            int classId = (int) tblClasses.getModel().getValueAt(index, 0);
            ClassesModel getClass = classesService.getById(classId);

            ClassesModel classesModel = getClass;

            if (JOptionPane.showConfirmDialog(null, "Yakin data akan dihapus?", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                classesService.deleteClasses(classesModel);
                classesTableModel.deleteClasses(index);
                loadData();
                resetForm();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pilih dahulu record yang akan dihapus");
        }
    }

    private boolean validasiInput() {
        boolean valid = false;
        if (txtNama.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong");
        } else {
            valid = true;
        }

        return valid;
    }

    private void showPanel() {
        mainPanel.removeAll();
        mainPanel.add(new FormClasses());
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    private void resetForm() {
        btnTambah.requestFocus();
        btnTambah.setText("Tambah");
        txtCourses.setText("");
        txtCoach.setText("");
        dtStartDate.setDateFormatString("");
        dtEndDate.setDateFormatString("");
        txtCapacity.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addClasses;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnBatalTambah;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSelectCoach;
    private javax.swing.JButton btnSelectCourse;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JPanel dataClasses;
    private com.toedter.calendar.JDateChooser dtEndDate;
    private com.toedter.calendar.JDateChooser dtStartDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTable tblClasses;
    private javax.swing.JTextField txtCapacity;
    private javax.swing.JTextField txtCoach;
    private javax.swing.JTextField txtCoachId;
    private javax.swing.JTextField txtCourses;
    private javax.swing.JTextField txtCoursesId;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables
}
