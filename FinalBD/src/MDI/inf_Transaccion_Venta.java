/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MDI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kievkevin
 */
public class inf_Transaccion_Venta extends javax.swing.JInternalFrame {

    /**
     * Creates new form inf_Transaccion_Venta
     */
    DefaultTableModel model = new DefaultTableModel();
    String subtotal;
    int n = 4;

    public void tablas() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pstt4 = cn.prepareStatement("select * from venta_detalle");
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID Venta");
            modelo.addColumn("ID Servicio");
            modelo.addColumn("Cantidad");
            modelo.addColumn("Precio");

            tabla.setModel(modelo);
            String[] dato = new String[8];
            while (rss4.next()) {
                dato[0] = rss4.getString(2);
                dato[1] = rss4.getString(3);
                dato[2] = rss4.getString(8);
                dato[3] = rss4.getString(5);

                modelo.addRow(dato);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void iniciar_cboxoperacion() {

        //cbox_operacion.removeAllItems();
        cbox_operacion.addItem("Seleccione una opción");
        cbox_operacion.addItem("tipo_habitacion");
        cbox_operacion.addItem("salon");
        cbox_operacion.addItem("servicio_habitacion");

    }

    public void iniciar_vendedor() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement psttt = cn.prepareStatement("select * from vendedor");
            ResultSet rss = psttt.executeQuery();

            cboxId_Vendedor.addItem("Seleccione una opción");
            while (rss.next()) {
                cboxId_Vendedor.addItem(rss.getString("id_vendedor"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //tablas();
    }

    public void iniciar_sucursal() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement psttt = cn.prepareStatement("select * from sucursal");
            ResultSet rss = psttt.executeQuery();

            cbox_sucursal.addItem("Seleccione una opción");
            while (rss.next()) {
                cbox_sucursal.addItem(rss.getString("nombre"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        //tablas();
    }

    public void iniciar_cliente() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement psttt = cn.prepareStatement("select * from cliente");
            ResultSet rss = psttt.executeQuery();

            cbox_cliente.addItem("Seleccione una opción");
            while (rss.next()) {
                cbox_cliente.addItem(rss.getString("nombre_cliente"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        //tablas();
    }

    public void iniciar_impuesto() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement psttt = cn.prepareStatement("select * from impuestos");
            ResultSet rss = psttt.executeQuery();

            cboxImpuesto.addItem("Seleccione una opción");
            while (rss.next()) {
                cboxImpuesto.addItem(rss.getString("nombre_impuesto"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        //tablas();
    }

    public void get_fecha() {
        Calendar c1 = Calendar.getInstance();
        date_fecha.setCalendar(c1);
    }

    public inf_Transaccion_Venta() {
        initComponents();
        iniciar_vendedor();
        iniciar_sucursal();
        iniciar_cliente();
        iniciar_cboxoperacion();
        get_fecha();
        iniciar_impuesto();
        iniciar_moneda();
        txtID_Venta.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtNit.setBackground(new java.awt.Color(0, 0, 0, 1));
        txt_cantidad.setBackground(new java.awt.Color(0, 0, 0, 1));
        txt_precio.setBackground(new java.awt.Color(0, 0, 0, 1));
        txt_subtotal.setBackground(new java.awt.Color(0, 0, 0, 1));
        txt_total.setBackground(new java.awt.Color(0, 0, 0, 1));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbSucursal = new javax.swing.JLabel();
        lbCliente = new javax.swing.JLabel();
        lbImpuesto = new javax.swing.JLabel();
        lbM = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        lbP = new javax.swing.JLabel();
        lbID = new javax.swing.JLabel();
        btn_confirmar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cboxImpuesto = new javax.swing.JComboBox<>();
        txtNit = new javax.swing.JTextField();
        cbox_cliente = new javax.swing.JComboBox<>();
        cbox_sucursal = new javax.swing.JComboBox<>();
        cboxId_Vendedor = new javax.swing.JComboBox<>();
        txtID_Venta = new javax.swing.JTextField();
        date_fecha = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        cbox_operacion = new javax.swing.JComboBox<>();
        cbox_moneda = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_subtotal = new javax.swing.JTextField();
        btnAgregarProducto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        txt_total = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnFinCompra = new javax.swing.JButton();
        txtT = new javax.swing.JLabel();
        cboxServicio = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txt_precio = new javax.swing.JTextField();

        lbSucursal.setText("jLabel8");

        lbCliente.setText("jLabel9");

        lbImpuesto.setText("jLabel3");

        lb1.setText("jLabel3");

        lbP.setText("jLabel3");

        lbID.setText("jLabel3");

        setClosable(true);
        setIconifiable(true);
        setVisible(true);

        btn_confirmar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btn_confirmar.setText("Confirmar");
        btn_confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirmarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel7.setText("Fecha");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel9.setText("ID Venta:");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel5.setText("ID Vendedor:");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel4.setText("ID Sucursal:");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel1.setText("Cliente:");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setText("NIT Cliente:");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel8.setText("Impuesto:");

        cboxImpuesto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cboxImpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxImpuestoActionPerformed(evt);
            }
        });

        txtNit.setEditable(false);
        txtNit.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtNit.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        txtNit.setEnabled(false);
        txtNit.setOpaque(false);
        txtNit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNitActionPerformed(evt);
            }
        });

        cbox_cliente.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbox_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_clienteActionPerformed(evt);
            }
        });

        cbox_sucursal.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbox_sucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_sucursalActionPerformed(evt);
            }
        });

        cboxId_Vendedor.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cboxId_Vendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxId_VendedorActionPerformed(evt);
            }
        });

        txtID_Venta.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtID_Venta.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        txtID_Venta.setOpaque(false);

        date_fecha.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel10.setText("Servicio:");

        cbox_operacion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbox_operacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_operacionActionPerformed(evt);
            }
        });

        cbox_moneda.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbox_moneda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_monedaActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel11.setText("Moneda:");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel12.setText("Cantidad:");

        txt_cantidad.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_cantidad.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        txt_cantidad.setOpaque(false);
        txt_cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cantidadActionPerformed(evt);
            }
        });
        txt_cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cantidadKeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel13.setText("SubTotal:");

        txt_subtotal.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_subtotal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        txt_subtotal.setOpaque(false);

        btnAgregarProducto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnAgregarProducto.setText("Agregar al Carrito");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        tabla.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Venta", "ID Servicio", "Cantidad", "SubTotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        txt_total.setEditable(false);
        txt_total.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_total.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel14.setText("Total:");

        btnFinCompra.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnFinCompra.setText("Finalizar Compra");
        btnFinCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinCompraActionPerformed(evt);
            }
        });

        cboxServicio.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cboxServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxServicioActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel15.setText("Precio Unidad:");

        txt_precio.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_precio.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        txt_precio.setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_cantidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbox_moneda, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbox_sucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel7)
                                .addComponent(jLabel9))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cboxId_Vendedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(date_fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtID_Venta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbox_cliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel10)
                                .addComponent(jLabel13)
                                .addComponent(jLabel12)
                                .addComponent(txtT, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cboxImpuesto, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbox_operacion, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btn_confirmar)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(cboxServicio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnAgregarProducto)
                                            .addComponent(txt_subtotal, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))))
                                .addComponent(txt_precio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnFinCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(date_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtID_Venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxId_Vendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbox_sucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbox_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btn_confirmar)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cbox_operacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboxServicio)
                            .addComponent(txtT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbox_moneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFinCompra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregarProducto)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbox_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_clienteActionPerformed
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);

            PreparedStatement pst2 = cn.prepareStatement("select * from cliente where cliente.nombre_cliente=?");
            pst2.setString(1, cbox_cliente.getSelectedItem().toString());
            ResultSet rss2 = pst2.executeQuery();

            if (rss2.next()) {
                lbCliente.setText(rss2.getString("id_cliente"));
                txtNit.setText(rss2.getString("nit_cliente"));

            } else {
                if (cbox_cliente.getSelectedItem().toString().contains("Seleccione una opción")) {
                    txtNit.setText("");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }//GEN-LAST:event_cbox_clienteActionPerformed

    private void cbox_sucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_sucursalActionPerformed
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);

            PreparedStatement pst2 = cn.prepareStatement("select * from sucursal where sucursal.nombre=?");
            pst2.setString(1, cbox_sucursal.getSelectedItem().toString());
            ResultSet rss2 = pst2.executeQuery();

            if (rss2.next()) {
                lbSucursal.setText(rss2.getString("id_sucursal"));

            } else {
                if (cbox_sucursal.getSelectedItem().toString().contains("Seleccione una opción")) {
                    lbSucursal.setText("");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }//GEN-LAST:event_cbox_sucursalActionPerformed

    public void iniciar_moneda() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement psttt = cn.prepareStatement("select * from moneda");
            ResultSet rss = psttt.executeQuery();

            cbox_moneda.addItem("Seleccione una opción");
            while (rss.next()) {
                cbox_moneda.addItem(rss.getString("nombre_moneda"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //tablas();
    }

    private void cboxId_VendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxId_VendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxId_VendedorActionPerformed

    public void iniciar_cboxservicio() {
        String tabla = cbox_operacion.getSelectedItem().toString().trim();
        String dato = "nombre_" + tabla;

        try {
            cboxServicio.removeAllItems();
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select " + dato + " from " + tabla);

            ResultSet rs = pst.executeQuery();

            cboxServicio.addItem("Seleccione una opción");
            while (rs.next()) {
                cboxServicio.addItem(rs.getString(dato));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cboxImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxImpuestoActionPerformed
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);

            PreparedStatement pst2 = cn.prepareStatement("select * from impuestos where impuestos.nombre_impuesto=?");
            pst2.setString(1, cboxImpuesto.getSelectedItem().toString());
            ResultSet rss2 = pst2.executeQuery();

            if (rss2.next()) {
                lbImpuesto.setText(rss2.getString("id_impuesto"));

            } else {
                if (cboxImpuesto.getSelectedItem().toString().contains("Seleccione una opción")) {
                    lbImpuesto.setText("");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }

    }//GEN-LAST:event_cboxImpuestoActionPerformed

    private void txtNitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNitActionPerformed

    private void btn_confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirmarActionPerformed
        // TODO add your handling code here:
        java.util.Date fechaN = date_fecha.getDate();
        long fecha = fechaN.getTime();
        java.sql.Date dateN = new java.sql.Date(fecha);
        try {
            //Guardando en el encabezado de la compra
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("insert into venta_encabezado values(?,?,?,?,?,?,?)");

            pst.setString(1, txtID_Venta.getText());
            pst.setString(2, cboxId_Vendedor.getSelectedItem().toString());
            pst.setString(3, lbSucursal.getText());
            pst.setString(4, lbCliente.getText());
            pst.setString(5, lbImpuesto.getText());
            pst.setString(6, null);
            pst.setString(7, dateN.toString());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "¡PRIMER REGISTRO EXITOSO!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

            //panel1.setEnabled(false);
            btn_confirmar.setEnabled(false);
            txtID_Venta.setEnabled(false);
            cboxId_Vendedor.setEnabled(false);
            cbox_sucursal.setEnabled(false);
            cbox_cliente.setEnabled(false);
            cboxImpuesto.setEnabled(false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en registro", "Warning", JOptionPane.WARNING_MESSAGE);
            System.out.println(e);
        }
    }//GEN-LAST:event_btn_confirmarActionPerformed

    private void cbox_operacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_operacionActionPerformed
        // TODO add your handling code here:

        String seleccion = cbox_operacion.getSelectedItem().toString();

        if (seleccion.equals("tipo_habitacion")) {
            txtT.setText("");
            lb1.setText("1");
            txtT.setText("Tipo Habitacion");
        } else {
            if (cbox_operacion.getSelectedItem().toString().contains("salon")) {
                txtT.setText("");

                lb1.setText("2");
                txtT.setText("Salon");
            } else {
                if (cbox_operacion.getSelectedItem().toString().contains("servicio_habitacion")) {
                    txtT.setText("");
                    lb1.setText("3");

                    txtT.setText("Servicio habitacion");
                }
            }
        }

        if (cbox_operacion.getSelectedItem().toString().contains("Seleccione una opción")) {
            lb1.setText("");
            txtT.setText("");
        }
        iniciar_cboxservicio();
    }//GEN-LAST:event_cbox_operacionActionPerformed

    private void cbox_monedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_monedaActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);

            PreparedStatement pst2 = cn.prepareStatement("select id_moneda from moneda where moneda.nombre_moneda=?");
            pst2.setString(1, cbox_moneda.getSelectedItem().toString());
            ResultSet rs2 = pst2.executeQuery();

            if (rs2.next()) {
                lbM.setText(rs2.getString("id_moneda"));

            } else {
                if (cbox_moneda.getSelectedItem().toString().contains("Seleccione una opción")) {

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cbox_monedaActionPerformed

    private void txt_cantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantidadKeyReleased

        double intPrecio = 0, intCant, intSubtotal;
        intCant = Double.parseDouble(txt_cantidad.getText());
        intSubtotal = Double.parseDouble(txt_precio.getText());
        intPrecio = (intSubtotal * intCant);

        txt_subtotal.setText(intPrecio + "");

    }//GEN-LAST:event_txt_cantidadKeyReleased

    private void txt_cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cantidadActionPerformed

    public void sumaColumnaPrecio() {
        double total = 0;
        double fila = 0;
        for (int i = 0; i < tabla.getRowCount(); i++) {
            fila = Double.parseDouble(tabla.getValueAt(i, 3).toString());
            total += fila;
        }

        txt_total.setText(total + "");
    }
    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        // TODO add your handling code here:

        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);

            //Guardando en el detalle de la compra
            PreparedStatement pst1 = cn.prepareStatement("insert into venta_detalle values(?,?,?,?,?,?,?,?)");

            //
            pst1.setString(1, "0");
            pst1.setString(2, txtID_Venta.getText().trim());
            pst1.setString(3, lbID.getText().trim());
            pst1.setString(4, cboxServicio.getSelectedItem().toString());
            pst1.setString(5, txt_precio.getText().trim());
            pst1.setString(6, txt_subtotal.getText().trim());
            pst1.setString(7, lbM.getText().trim());
            pst1.setString(8, txt_cantidad.getText().trim());

            pst1.executeUpdate();

            //Llenando la tabla
            this.tabla.setModel(model);
            String titulo[] = {"ID venta", "ID servicio", "Cantidad", "SubTotal"};
            model.setColumnIdentifiers(titulo);

            String registros[] = new String[4];

            registros[0] = txtID_Venta.getText();
            registros[1] = lbID.getText();
            registros[2] = txt_cantidad.getText();
            registros[3] = txt_subtotal.getText();

            model.addRow(registros);

            JOptionPane.showMessageDialog(this, "¡REGISTRO EXITOSO!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            sumaColumnaPrecio();
            txt_cantidad.setText("");
            txt_precio.setText("");
            txt_subtotal.setText("");
            cbox_moneda.setSelectedIndex(0);
            cbox_operacion.setSelectedIndex(0);
            cboxServicio.setSelectedIndex(0);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error en registro", "Warning", JOptionPane.WARNING_MESSAGE);
            System.out.println(e);
        }
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnFinCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinCompraActionPerformed
        // TODO add your handling code here:
        try {
            String id = txtID_Venta.getText();
            //Guardando en el encabezado de la compra
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("update venta_encabezado set  id_vendedor =?, id_sucursal = ?, id_cliente = ?, id_impuesto_aplicado =?, total = ? where id_ventaE = " + id);

            pst.setString(1, cboxId_Vendedor.getSelectedItem().toString());
            pst.setString(2, lbSucursal.getText());
            pst.setString(3, lbCliente.getText());
            pst.setString(4, lbImpuesto.getText());
            pst.setString(5, txt_total.getText());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "¡COMPRA FINALIZADA CON ÉXITO!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            btn_confirmar.setEnabled(true);
            txtID_Venta.setEnabled(true);
            cboxId_Vendedor.setEnabled(true);
            cbox_sucursal.setEnabled(true);
            cbox_cliente.setEnabled(true);
            cboxImpuesto.setEnabled(true);

            txtID_Venta.setText("");
            cboxId_Vendedor.setSelectedIndex(0);
            cbox_sucursal.setSelectedIndex(0);
            cbox_cliente.setSelectedIndex(0);
            txtNit.setText("");
            cboxImpuesto.setSelectedIndex(0);
            /*txt_cantidad.setText("");
            cbox_operacion.setSelectedIndex(0);
            cboxServicio.setSelectedIndex(0);
            cbox_moneda.setSelectedIndex(0);
            txt_cantidad.setText("");*/
            date_fecha.setCalendar(null);

            txt_subtotal.setText("");
            txt_precio.setText("");

            model.setRowCount(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ya existe ése registro", "Warning", JOptionPane.WARNING_MESSAGE);
            System.out.println(e);
        }
        txt_total.setText("");
    }//GEN-LAST:event_btnFinCompraActionPerformed

    private void cboxServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxServicioActionPerformed
        String tabla = cbox_operacion.getSelectedItem().toString().trim();
        String dato = "id_" + tabla;
        String val = "nombre_" + tabla;

        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);

            PreparedStatement pst2 = cn.prepareStatement("select * from " + tabla + " where " + val + "= ?");
            pst2.setString(1, cboxServicio.getSelectedItem().toString());
            ResultSet rs2 = pst2.executeQuery();

            if (rs2.next()) {
                lbID.setText(rs2.getString(dato));

            } else {
                if (cboxServicio.getSelectedItem().toString().contains("Seleccione una opción")) {
                    lbID.setText("");

                }
            }
            PreparedStatement pst = cn.prepareStatement("select * from " + tabla + " where " + val + "= ?");
            pst.setString(1, cboxServicio.getSelectedItem().toString());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txt_precio.setText(rs.getString("precio"));

            } else {
                if (cboxServicio.getSelectedItem().toString().contains("Seleccione una opción")) {
                    txt_precio.setText("");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }


    }//GEN-LAST:event_cboxServicioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnFinCompra;
    private javax.swing.JButton btn_confirmar;
    private javax.swing.JComboBox<String> cboxId_Vendedor;
    private javax.swing.JComboBox<String> cboxImpuesto;
    private javax.swing.JComboBox<String> cboxServicio;
    private javax.swing.JComboBox<String> cbox_cliente;
    private javax.swing.JComboBox<String> cbox_moneda;
    private javax.swing.JComboBox<String> cbox_operacion;
    private javax.swing.JComboBox<String> cbox_sucursal;
    private com.toedter.calendar.JDateChooser date_fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lbCliente;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbImpuesto;
    private javax.swing.JLabel lbM;
    private javax.swing.JLabel lbP;
    private javax.swing.JLabel lbSucursal;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtID_Venta;
    private javax.swing.JTextField txtNit;
    private javax.swing.JLabel txtT;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_precio;
    private javax.swing.JTextField txt_subtotal;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
