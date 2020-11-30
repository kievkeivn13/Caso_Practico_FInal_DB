/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MDI;

import static MDI.mdi_Principal.labelusuario;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kevin
 */
public class inf_Mantenimiento_Salon extends javax.swing.JInternalFrame {

    /**
     * Creates new form inf_Salon
     */
    public void tablas() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pstt4 = cn.prepareStatement("select * from salon");
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Id Salón");
            modelo.addColumn("Nombre");
            modelo.addColumn("Capacidad");
            modelo.addColumn("Nivel");
            modelo.addColumn("Precio");
            modelo.addColumn("Estatus");
            tbl.setModel(modelo);
            String[] dato = new String[6];
            while (rss4.next()) {
                dato[0] = rss4.getString(1);
                dato[1] = rss4.getString(2);
                dato[2] = rss4.getString(3);
                dato[3] = rss4.getString(4);
                dato[4] = rss4.getString(5);
                dato[5] = rss4.getString(6);

                modelo.addRow(dato);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void get_fecha() {
        //Obtenemos la fecha
        Calendar c1 = Calendar.getInstance();
        fecha.setCalendar(c1);
    }

    public void get_usuario() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from usuario_hoteleria where nombre_usuario = ?");
            pst.setString(1, labelusuario.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                lbusu.setText(rs.getString("id_usuario"));

            }
        } catch (Exception e) {

        }
    }

    public void bitacora_guardar() {
        String prov = txt_Nombre.getText();
        String descrip = "Registró el salón " + prov;
        //Desciframos la fecha
        java.util.Date fechaN = fecha.getDate();
        long fecha = fechaN.getTime();
        java.sql.Date dateN = new java.sql.Date(fecha);

        //Obtenemos la hora
        Calendar timec = Calendar.getInstance();

        int hora = timec.get(Calendar.HOUR_OF_DAY);
        int minutos = timec.get(Calendar.MINUTE);
        int segundos = timec.get(Calendar.SECOND);

        String time = hora + ":" + minutos + ":" + segundos;

        try {

            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, lbusu.getText().trim());
            pst.setString(3, descrip);
            pst.setString(4, dateN.toString().trim());
            pst.setString(5, time.trim());

            pst.executeUpdate();

        } catch (SQLException e) {
        }
    }

    public void bitacora_modificar() {
        String prov = txt_Nombre.getText();
        String descrip = "Modificó el salón " + prov;
        //Desciframos la fecha
        java.util.Date fechaN = fecha.getDate();
        long fecha = fechaN.getTime();
        java.sql.Date dateN = new java.sql.Date(fecha);

        //Obtenemos la hora
        Calendar timec = Calendar.getInstance();

        int hora = timec.get(Calendar.HOUR_OF_DAY);
        int minutos = timec.get(Calendar.MINUTE);
        int segundos = timec.get(Calendar.SECOND);

        String time = hora + ":" + minutos + ":" + segundos;

        try {

            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, lbusu.getText().trim());
            pst.setString(3, descrip);
            pst.setString(4, dateN.toString().trim());
            pst.setString(5, time.trim());

            pst.executeUpdate();

        } catch (SQLException e) {
        }
    }

    public void bitacora_eliminar() {
        String prov = txt_Nombre.getText();
        String descrip = "Eliminó el salón " + prov;
        //Desciframos la fecha
        java.util.Date fechaN = fecha.getDate();
        long fecha = fechaN.getTime();
        java.sql.Date dateN = new java.sql.Date(fecha);

        //Obtenemos la hora
        Calendar timec = Calendar.getInstance();

        int hora = timec.get(Calendar.HOUR_OF_DAY);
        int minutos = timec.get(Calendar.MINUTE);
        int segundos = timec.get(Calendar.SECOND);

        String time = hora + ":" + minutos + ":" + segundos;

        try {

            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, lbusu.getText().trim());
            pst.setString(3, descrip);
            pst.setString(4, dateN.toString().trim());
            pst.setString(5, time.trim());

            pst.executeUpdate();

        } catch (SQLException e) {
        }
    }

    public void bitacora_buscar() {
        String prov = txt_Nombre.getText();
        String descrip = "Buscó el salón " + prov;
        //Desciframos la fecha
        java.util.Date fechaN = fecha.getDate();
        long fecha = fechaN.getTime();
        java.sql.Date dateN = new java.sql.Date(fecha);

        //Obtenemos la hora
        Calendar timec = Calendar.getInstance();

        int hora = timec.get(Calendar.HOUR_OF_DAY);
        int minutos = timec.get(Calendar.MINUTE);
        int segundos = timec.get(Calendar.SECOND);

        String time = hora + ":" + minutos + ":" + segundos;

        try {

            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, lbusu.getText().trim());
            pst.setString(3, descrip);
            pst.setString(4, dateN.toString().trim());
            pst.setString(5, time.trim());

            pst.executeUpdate();

        } catch (SQLException e) {
        }
    }

    public inf_Mantenimiento_Salon() {
        initComponents();
        tablas();
        get_fecha();
        get_usuario();
        txt_idSalon.setBackground(new java.awt.Color(0, 0, 0, 1));
        txt_Nombre.setBackground(new java.awt.Color(0, 0, 0, 1));
        txt_Capacidad.setBackground(new java.awt.Color(0, 0, 0, 1));
        txt_Nivel.setBackground(new java.awt.Color(0, 0, 0, 1));
        txt_Precio.setBackground(new java.awt.Color(0, 0, 0, 1));
        txt_Estatus.setBackground(new java.awt.Color(0, 0, 0, 1));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fecha = new com.toedter.calendar.JDateChooser();
        lbusu = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        txt_Precio = new javax.swing.JTextField();
        label4 = new javax.swing.JLabel();
        txt_Nombre = new javax.swing.JTextField();
        label5 = new javax.swing.JLabel();
        label6 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txtbuscado = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        label3 = new javax.swing.JLabel();
        txt_idSalon = new javax.swing.JTextField();
        label7 = new javax.swing.JLabel();
        txt_Capacidad = new javax.swing.JTextField();
        txt_Nivel = new javax.swing.JTextField();
        label9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        activo = new javax.swing.JRadioButton();
        inactivo = new javax.swing.JRadioButton();
        txt_Estatus = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Mantenimiento Salón");
        setVisible(true);

        tbl.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Salón", "Nombre", "Capacidad", "Nivel", "Precio ", "Estatus"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl);

        txt_Precio.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_Precio.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        txt_Precio.setOpaque(false);
        txt_Precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_PrecioKeyPressed(evt);
            }
        });

        label4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label4.setText("Nombre:");

        txt_Nombre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_Nombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        txt_Nombre.setOpaque(false);
        txt_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NombreActionPerformed(evt);
            }
        });
        txt_Nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_NombreKeyPressed(evt);
            }
        });

        label5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label5.setText("Capacidad:");

        label6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label6.setText("Nivel:");

        btnBuscar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtbuscado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        btnLimpiar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRegistrar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        label3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label3.setText("Id Salón:");

        txt_idSalon.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_idSalon.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        txt_idSalon.setEnabled(false);
        txt_idSalon.setOpaque(false);
        txt_idSalon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idSalonActionPerformed(evt);
            }
        });

        label7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label7.setText("Precio:");

        txt_Capacidad.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_Capacidad.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        txt_Capacidad.setOpaque(false);
        txt_Capacidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_CapacidadKeyPressed(evt);
            }
        });

        txt_Nivel.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_Nivel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        txt_Nivel.setOpaque(false);
        txt_Nivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NivelActionPerformed(evt);
            }
        });

        label9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label9.setText("Estado:");

        jPanel1.setOpaque(false);

        activo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        activo.setText("Disponible");
        activo.setOpaque(false);
        activo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activoActionPerformed(evt);
            }
        });

        inactivo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        inactivo.setText("Reservado");
        inactivo.setOpaque(false);
        inactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inactivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(activo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(inactivo)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(activo)
                    .addComponent(inactivo)))
        );

        txt_Estatus.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_Estatus.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Estatus.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        txt_Estatus.setEnabled(false);
        txt_Estatus.setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label6)
                            .addComponent(label5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_Capacidad, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(txt_Nivel)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtbuscado, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label9)
                                .addGap(22, 22, 22)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_Estatus, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label7)
                                .addGap(18, 18, 18)
                                .addComponent(txt_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(label3)
                        .addComponent(label4))
                    .addGap(23, 23, 23)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txt_Nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                        .addComponent(txt_idSalon))
                    .addContainerGap(602, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addComponent(label5))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txt_Capacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label6)
                            .addComponent(txt_Nivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label7)
                            .addComponent(txt_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(label9))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Estatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrar)
                            .addComponent(btnEliminar)
                            .addComponent(btnModificar))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtbuscado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar)
                            .addComponent(btnLimpiar))))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_idSalon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label4))
                    .addContainerGap(265, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NombreActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        String buscar = txtbuscado.getText().trim();
        if (buscar.isEmpty()) {
            JOptionPane.showMessageDialog(this, "¡No se ingreso el campo de busqueda!", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from salon where id_salon =?");
            pst.setString(1, txtbuscado.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txt_idSalon.setText(rs.getString("id_salon"));
                txt_Nombre.setText(rs.getString("nombre_salon"));
                txt_Capacidad.setText(rs.getString("capacidad"));
                txt_Nivel.setText(rs.getString("nivel"));
                txt_Precio.setText(rs.getString("precio"));
                txt_Estatus.setText(rs.getString("estatus"));

                btnModificar.setEnabled(true);
                btnEliminar.setEnabled(true);
                btnRegistrar.setEnabled(false);
                tablas();
                bitacora_buscar();

            } else {
                JOptionPane.showMessageDialog(this, "Salón no registrado.", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {

        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

        txt_idSalon.setText("");
        txt_Nombre.setText("");
        txt_Capacidad.setText("");
        txt_Nivel.setText("");
        txt_Precio.setText("");
        txt_Estatus.setText("");
        inactivo.setSelected(false);
        activo.setSelected(false);
        txtbuscado.setText("");
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("delete from salon where id_salon = ?");
            pst.setString(1, txtbuscado.getText().trim());
            pst.executeUpdate();

            bitacora_eliminar();

            JOptionPane.showMessageDialog(this, "¡ELIMINACION EXITOSA!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txt_idSalon.setText("");
            txt_Nombre.setText("");
            txt_Capacidad.setText("");
            txt_Nivel.setText("");
            txt_Precio.setText("");
            txt_Estatus.setText("");
            txtbuscado.setText("");
            inactivo.setSelected(false);
            activo.setSelected(false);
            btnRegistrar.setEnabled(true);
            btnModificar.setEnabled(false);
            btnEliminar.setEnabled(false);
            tablas();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error en Eliminación", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into salon values(?,?,?,?,?,?)");
            pst.setString(1, "0");
            pst.setString(2, txt_Nombre.getText());
            pst.setString(3, txt_Capacidad.getText());
            pst.setString(4, txt_Nivel.getText());
            pst.setString(5, txt_Precio.getText());
            pst.setString(6, txt_Estatus.getText());

            pst.executeUpdate();

            bitacora_guardar();

            JOptionPane.showMessageDialog(this, "¡REGISTRO EXITOSO!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txt_idSalon.setText("");
            txt_Nombre.setText("");
            txt_Capacidad.setText("");
            txt_Nivel.setText("");
            txt_Precio.setText("");
            txt_Estatus.setText("");
            txtbuscado.setText("");
            activo.setSelected(false);
            inactivo.setSelected(false);

            tablas();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error en registro", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        try {
            String ID = txtbuscado.getText().trim();

            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("update salon set  nombre_salon = ?, capacidad = ?, nivel= ?, precio = ?, estatus = ?  where id_salon =" + ID);
            pst.setString(1, txt_Nombre.getText());
            pst.setString(2, txt_Capacidad.getText());
            pst.setString(3, txt_Nivel.getText());
            pst.setString(4, txt_Precio.getText());
            String mensaje = "";
            if (activo.isSelected()) {
                mensaje = "D";
            } else if (inactivo.isSelected()) {
                mensaje = "R";

            }
            pst.setString(5, mensaje);
            pst.executeUpdate();

            bitacora_modificar();

            JOptionPane.showMessageDialog(this, "¡MODIFICACION EXITOSA!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txt_idSalon.setText("");
            txt_Nombre.setText("");
            txt_Capacidad.setText("");
            txt_Nivel.setText("");
            txt_Precio.setText("");
            txt_Estatus.setText("");
            txtbuscado.setText("");
            activo.setSelected(false);
            inactivo.setSelected(false);
            btnRegistrar.setEnabled(true);
            btnModificar.setEnabled(false);
            btnEliminar.setEnabled(false);
            tablas();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error en Modificacion", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txt_NivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NivelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NivelActionPerformed

    private void txt_idSalonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idSalonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idSalonActionPerformed

    private void activoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activoActionPerformed
        if (activo.isSelected()) {

            txt_Estatus.setText("D");
            inactivo.setSelected(false);
        }
    }//GEN-LAST:event_activoActionPerformed

    private void inactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inactivoActionPerformed
        if (inactivo.isSelected()) {

            txt_Estatus.setText("R");
            activo.setSelected(false);
        }
    }//GEN-LAST:event_inactivoActionPerformed

    private void txt_NombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NombreKeyPressed
  if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txt_Capacidad.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NombreKeyPressed

    private void txt_CapacidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CapacidadKeyPressed
 if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txt_Nivel.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CapacidadKeyPressed

    private void txt_PrecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PrecioKeyPressed
if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            activo.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PrecioKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton activo;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JRadioButton inactivo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label9;
    private javax.swing.JLabel lbusu;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txt_Capacidad;
    private javax.swing.JTextField txt_Estatus;
    private javax.swing.JTextField txt_Nivel;
    protected static javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_Precio;
    protected static javax.swing.JTextField txt_idSalon;
    private javax.swing.JTextField txtbuscado;
    // End of variables declaration//GEN-END:variables
}
