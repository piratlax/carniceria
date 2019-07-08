package vista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;
import modelo.modelo;
import org.apache.commons.dbutils.DbUtils;

public class adm_Inventario extends javax.swing.JInternalFrame {

    // Se instancia una conexion de la clase conecta
    Conexion con = new Conexion();
 //al inicio de la clase
    DefaultComboBoxModel modeloCombo;
    DefaultTableModel modelo;
    int total = 0;
    Double dOrigen=0.0;

    public adm_Inventario() {
        // esto va antes del initComponents
        modeloCombo  = new DefaultComboBoxModel(new String[]{});
        initComponents();
        mostrarTabla();
        inicio();
        txtIdProveedor.setVisible(false);
        llenaComboBox();
        txtCantidad.setVisible(false);
        txtId.setVisible(false);
    }
    
   



//funcion de llenado de combobox
    private void llenaComboBox() {
        Connection cn=con.conectar();
        try {
            /* Realizamos la consulta a la base de datos*/
            
            String sql = "SELECT nombre FROM mayoreo WHERE estado='SI'";

            /* Se prepara la consulta */
            Statement st = cn.createStatement();

            /* Y se ejecuta en la siguiente línea */
            ResultSet rs = st.executeQuery(sql);

//recorremos el resultado generado por la consulta 
            while (rs.next()) {

//fijate como con nuestro modelo y su método addElement vamos a agregar cada resultado a nuestro ComboBox, en lo personal concatene el resultado
                modeloCombo.addElement(rs.getString("nombre"));
                
            }
            
        } catch (SQLException ex) {
            System.out.println("Sin poder ejecutar el query a la tabla "+ex);
        }

//acaba llenaComboBox
    }

    void mostrarTabla() {
        // desde aqui mandamos a llamar a todos los usuarios y los listamos en la tabla
        // se crea una matriz para almacenar los datos
        total = 0;
        String[] cabecera = {"id", "Producto", "Origen", "Cantidad", "Minimo", "Costo", "Publico"};
        // se definen los registros que llevara la tabla
        String[] registros = new String[7];
        // se hace el llamado sql de todos los usuarios
        String sql = "SELECT inventario.idinventario, inventario.origen,inventario.nombre as inventario,"
                + "mayoreo.nombre as mayoreo,inventario.cantidad,inventario.minimo,inventario.costo,inventario.publico"
                + " FROM inventario inner join mayoreo on mayoreo.idmayoreo=inventario.origen";
        //establecemos los anchos en pixeles de las columnas
        int[] anchos = {0, 250, 250, 100, 100, 100, 100};
        modelo = new DefaultTableModel(null, cabecera);
        Connection cn = con.conectar();
        ResultSet rs = null;
        Statement st = null;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                
                Double cantidad=Double.valueOf(rs.getString("cantidad"))/100;
                Double minimo=Double.valueOf(rs.getString("minimo"))/100;
                Double costo=Double.valueOf(rs.getString("costo"))/100;
                Double publico=Double.valueOf(rs.getString("publico"))/100;
                registros[0] = rs.getString("idinventario");
                registros[1] = rs.getString("inventario");
                registros[2] = rs.getString("mayoreo");
                registros[3] = String.valueOf(cantidad);
                registros[4] = String.valueOf(minimo);
                registros[5] = String.valueOf(costo);
                registros[6] = String.valueOf(publico);
                total++;

                modelo.addRow(registros);

            }
            tabla.setModel(modelo);
            for (int i = 0; i < cabecera.length; i++) {
                tabla.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
                tabla.setFont(new java.awt.Font("Tahoma", 0, 12));
            }
            // asignamos la columna 0 para esconderla
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
            txtTotal.setText(Integer.toString(total));
        } catch (SQLException ex) {
            System.out.println("Sin poder ejecutar el query a la tabla "+ex);
        }

    }

    void inicio() {
        txtNombre.setEnabled(false);
        jcMayoreo.setEnabled(false);
        txtExistencia.setEnabled(false);
        btnEditar.setEnabled(true);
        btnGrabar.setEnabled(false);
        btnActualizar.setEnabled(false);
        btnCancelar.setEnabled(false);
        txtMinimo.setEnabled(false);
        txtCosto.setEnabled(false);
        txtPublico.setEnabled(false);
        txtPuntos.setEnabled(false);
        jrActivo.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        panelMaterial = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtExistencia = new javax.swing.JTextField();
        txtId = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMinimo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        txtPublico = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jrActivo = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        txtPuntos = new javax.swing.JTextField();
        jcMayoreo = new javax.swing.JComboBox<>();
        txtRestante = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtBNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtBuscaProveedor = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        txtIdProveedor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado"));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        panelMaterial.setBackground(new java.awt.Color(204, 204, 204));
        panelMaterial.setBorder(javax.swing.BorderFactory.createTitledBorder("Menu Carnes"));

        jLabel6.setText("Nombre");

        jLabel7.setText("Mayoreo");

        jLabel8.setText("Cantidad");

        txtId.setFont(new java.awt.Font("Lucida Grande", 0, 5)); // NOI18N
        txtId.setText("CVE");

        jLabel11.setText("Minimo");

        jLabel12.setText("Precio X Kilo");

        jLabel13.setText("Publico X Kilo");

        jLabel1.setText("$");

        jLabel2.setText("$");

        jrActivo.setText("Activo");

        jLabel3.setText("Puntos:");

        jcMayoreo.setModel(modeloCombo);
        jcMayoreo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcMayoreoItemStateChanged(evt);
            }
        });

        txtRestante.setText("_");

        txtCantidad.setFont(new java.awt.Font("Lucida Grande", 0, 5)); // NOI18N
        txtCantidad.setText("CVE");

        javax.swing.GroupLayout panelMaterialLayout = new javax.swing.GroupLayout(panelMaterial);
        panelMaterial.setLayout(panelMaterialLayout);
        panelMaterialLayout.setHorizontalGroup(
            panelMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMaterialLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addGroup(panelMaterialLayout.createSequentialGroup()
                        .addComponent(txtId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCantidad)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelMaterialLayout.createSequentialGroup()
                        .addComponent(txtNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(panelMaterialLayout.createSequentialGroup()
                        .addGroup(panelMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcMayoreo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelMaterialLayout.createSequentialGroup()
                                .addComponent(txtRestante, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrActivo)))
                        .addGap(17, 17, 17)))
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMaterialLayout.createSequentialGroup()
                        .addGroup(panelMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtExistencia)
                            .addComponent(jLabel12)
                            .addComponent(txtCosto))
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(panelMaterialLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(66, 66, 66)))
                .addGroup(panelMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtPuntos)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMinimo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPublico, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        panelMaterialLayout.setVerticalGroup(
            panelMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMaterialLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMaterialLayout.createSequentialGroup()
                        .addGroup(panelMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtId)
                            .addComponent(txtCantidad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMaterialLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(9, 9, 9)
                        .addGroup(panelMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPublico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(jcMayoreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel13))
                .addGroup(panelMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMaterialLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jrActivo)
                            .addComponent(jLabel3)
                            .addComponent(txtPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelMaterialLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtRestante)))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Operaciones"));

        btnNuevo.setMnemonic('n');
        btnNuevo.setText("Nuevo");
        btnNuevo.setInheritsPopupMenu(true);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnActualizar.setMnemonic('a');
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEditar.setMnemonic('e');
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnGrabar.setMnemonic('g');
        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnCancelar.setMnemonic('c');
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGrabar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGrabar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(21, 21, 21))
        );

        jLabel10.setText("Total de Productos:");

        txtTotal.setText("0");

        btnMenu.setMnemonic('c');
        btnMenu.setText("Cerrar");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Busqueda"));

        jLabel4.setText("Nombre:");

        jLabel5.setText("Proveedor:");

        btnBuscar.setMnemonic('b');
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtIdProveedor.setText("_");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtBNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscaProveedor))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtIdProveedor)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtBuscaProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdProveedor)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelMaterial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(16, 16, 16)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(384, 384, 384)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnMenu)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtTotal))
                    .addComponent(btnMenu))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        //Boton nuevo
        btnBuscar.setEnabled(false);
        btnNuevo.setEnabled(false);
        btnGrabar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnActualizar.setEnabled(false);
        btnCancelar.setEnabled(true);
        txtNombre.setEnabled(true);
        jcMayoreo.setEnabled(true);
        txtMinimo.setEnabled(true);
        txtExistencia.setEnabled(true);
        txtCosto.setEnabled(true);
        txtPublico.setEnabled(true);
        jrActivo.setEnabled(true);
        jrActivo.setSelected(true);
        txtPuntos.setEnabled(true);
        txtNombre.requestFocus();
        txtPuntos.setText("1");

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        //se cancela todo
        inicio();
        mostrarTabla();
        btnNuevo.setEnabled(true);
        btnCancelar.setEnabled(false);
        txtNombre.setText("");
        txtExistencia.setText("");
        txtMinimo.setText("");
        btnBuscar.setEnabled(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        //empezamos a grabar un nuevo registro a la bd de Inventarios
        //verificamos que no esten vacios los campos
        if (txtNombre.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Falta escribir el Nombre", "Atencion", 1);
        } else if (txtExistencia.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Falta escribir las existencias iniciales", "Atencion", 1);
        } else {
            // se verifica la informacion
            int respuesta = JOptionPane.showConfirmDialog(this, "Se va a introducir la siguiente informacion\n"
                    + "\nNombre:"
                    + txtNombre.getText() + "\ndel Origen:"
                    + jcMayoreo.getSelectedItem().toString() + "\n con "
                    + txtExistencia.getText() + " tantas existencias ", "Confirmacion", 2);
            //verificamos que informacion se va a agregar y si lo acepta se integra a la BD
            if (respuesta == 0) {
                //verificamos que el codigo no este repetido
                int contador = 0;
                Connection cn = con.conectar();
                ResultSet rs = null;
                Statement st = null;
                PreparedStatement ps= null;

                try {
                    String checar = "SELECT * FROM inventario WHERE nombre='" + txtNombre.getText() + "'";
                    st = cn.createStatement();
                    rs = st.executeQuery(checar);
                    while (rs.next()) {
                        contador++;
                        JOptionPane.showMessageDialog(null, "Producto repetido", "Alerta", 0);
                    }
                    if (contador == 0) {
                        try {
                            modelo mod=new modelo();
                            int idMayoreo=mod.idMayoreo(jcMayoreo.getSelectedItem().toString());
                            int Existencia = 0;
                            int Minimo = 0;
                            int Puntos=0;
                            int Costo=0;
                            int Publico=0;
                            try {
                                Double DCosto=Double.parseDouble(txtCosto.getText())*100;
                                Costo = DCosto.intValue();
                                Double DPublico=Double.parseDouble(txtPublico.getText())*100;
                                Publico = DPublico.intValue();
                                Double DExistencia=Double.parseDouble(txtExistencia.getText())*100;
                                Existencia = DExistencia.intValue();
                                Double DMinimo=Double.parseDouble(txtMinimo.getText())*100;
                                Minimo = DMinimo.intValue();
                                Puntos=Integer.parseInt(txtPuntos.getText());
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(this, "Escribe bien la cantidad\nejemplo: 7.32");
                                
                            }
                            
                            String sql = "INSERT INTO inventario (nombre,origen,costo,publico"
                                    + ",cantidad,minimo,puntos,estado) "
                                    + "VALUES (?,?,?,?,?,?,?,?)";
                            ps= cn.prepareStatement(sql);
                            ps.setString(1, txtNombre.getText().toUpperCase());
                            ps.setInt(2, idMayoreo);
                            ps.setInt(3, Costo);
                            ps.setInt(4, Publico);
                            ps.setInt(5, Existencia);
                            ps.setInt(6, Minimo);
                            ps.setInt(7, Puntos);
                            ps.setString(8, "SI");
                            ps.executeUpdate();
                            
                            //descontamos de la carne origen
                            Double dExistencia=Double.parseDouble(txtExistencia.getText())*100;
                            Double dOrigen=this.dOrigen*100;
                            
                            Double dResultado=dOrigen-dExistencia;
                            int resultado=dResultado.intValue();
                            
                                                      
                                //se prepara a actualizar la tabla mayoreo su nueva cantidad   
                                String origin = "UPDATE mayoreo set cantidad=? where idmayoreo=?";
                                ps = cn.prepareStatement(origin);
                                ps.setInt(1,resultado);
                                ps.setInt(2,idMayoreo);
                                ps.execute();
                              mostrarOrigen();
                            
                            
                            JOptionPane.showMessageDialog(null, "Producto Correctamente integrado");
                            inicio();
                            btnNuevo.setEnabled(true);
                            btnBuscar.setEnabled(true);
                            txtNombre.setText("");
                            txtExistencia.setText("");
                            txtMinimo.setText("");
                            txtPuntos.setText("");
                            txtCosto.setText("");
                            txtPublico.setText("");
                            
                            mostrarTabla();
                        } catch (SQLException ex) {
                            System.out.println(ex);
                        }
                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                }finally {
                    DbUtils.closeQuietly(st);
                    DbUtils.closeQuietly(rs);
                    DbUtils.closeQuietly(cn);
                }
            }
    }//GEN-LAST:event_btnGrabarActionPerformed
    }
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        //editando un producto
        int fila = tabla.getSelectedRow();
                Connection cn = con.conectar();
                ResultSet rs = null;
                Statement st = null;
                PreparedStatement ps= null;
        if (fila >= 0) {
            String id;
            id = tabla.getValueAt(fila, 0).toString();

            try {
                Statement buscar = cn.createStatement();
                ResultSet resultado = buscar.executeQuery("SELECT * FROM inventario WHERE idInventario='" + id + "'");
                while (resultado.next()) {
                    txtNombre.setText(resultado.getString("nombre"));
                    txtExistencia.setText("0");
                    txtId.setText(String.valueOf(resultado.getInt("idInventario")));
                    txtCantidad.setText(String.valueOf(resultado.getInt("cantidad")));
                    txtMinimo.setText(String.valueOf(resultado.getDouble("minimo")/100));
                    txtPuntos.setText(String.valueOf(resultado.getDouble("puntos")));
                    txtCosto.setText(String.valueOf(resultado.getDouble("costo")/100));
                    txtPublico.setText(String.valueOf(resultado.getDouble("publico")/100));
                    jrActivo.setSelected(true);
                }
            } catch (SQLException ex) {
                System.out.println("Sin poder ejecutar el query a la tabla"+ex);
            }
        }
        //aqui reviso que si se pasaron datos a la clave y activo el boton editar;
        if (txtNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Selecciona un campo de la Tabla");
        } else {
            btnBuscar.setEnabled(false);
            txtNombre.setEnabled(true);
            jcMayoreo.setEnabled(true);
            txtExistencia.setEnabled(true);
            btnNuevo.setEnabled(false);
            btnEditar.setEnabled(false);
            btnActualizar.setEnabled(true);
            btnCancelar.setEnabled(true);
            txtMinimo.setEnabled(true);
            txtCosto.setEnabled(true);
            txtPublico.setEnabled(true);
            jrActivo.setEnabled(true);
            txtPuntos.setEnabled(true);

        }

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        //Actualizamos la informacion
        // se verifica la informacion
        int respuesta = JOptionPane.showConfirmDialog(this, "Se va a actualizar la siguiente informacion"
                + "\nNombre:"
                + txtNombre.getText() + "\nOrigen:"
                + jcMayoreo.getSelectedItem().toString() + " con "
                + txtExistencia.getText(),"Confirmacion", 2);
        //verificamos que informacion se va a agregar y si lo acepta se integra a la BD
        if (respuesta == 0) {
            Connection cn = con.conectar();
                Statement st = null;
            try {
                int costo=0;
                int publico=0;
                int existencia=0;
                int minimo=0;
                int cantidadPrevia=0;
                try {
                    Double dcosto = Double.parseDouble(txtCosto.getText())*100;
                    Double dpublico = Double.parseDouble(txtPublico.getText())*100;
                    Double dexistencia = Double.parseDouble(txtExistencia.getText())*100;
                    Double dminimo = Double.parseDouble(txtMinimo.getText())*100;
                    costo=dcosto.intValue();
                    publico=dpublico.intValue();
                    cantidadPrevia=Integer.valueOf(txtCantidad.getText());
                    existencia=dexistencia.intValue()+cantidadPrevia;
                    minimo=dminimo.intValue();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Escribe bien la cantidad\nejemplo: 7.32");
                }
                modelo mod=new modelo();
                int idProveedor=mod.idMayoreo(jcMayoreo.getSelectedItem().toString());
                if (jrActivo.isSelected()){
                
                st = cn.createStatement();
                String sql = "UPDATE inventario SET nombre='" + txtNombre.getText().toUpperCase() + "',origen='" + idProveedor
                        + "',costo='"+costo+"',publico='"+publico+"',cantidad='"+existencia+
                        "',minimo='"+minimo+"',puntos='"+txtPuntos.getText()+"',estado='SI'  WHERE idinventario=" + txtId.getText() + ";";
                st.executeUpdate(sql);
                }else{
                    
                st = cn.createStatement();
                String sql = "UPDATE inventario SET nombre='" + txtNombre.getText().toUpperCase() + "', origen='" + idProveedor
                        + "',costo='"+costo+"',publico='"+publico+"',cantidad='"+existencia+
                        "',minimo='"+minimo+"',puntos='"+txtPuntos.getText()+"',estado='NO'  WHERE idinventario=" + txtId.getText() + ";";
                st.executeUpdate(sql);
                }
                //descontamos de la carne origen
                            
                Double dOrigen=this.dOrigen*100;
                Double cantidad=Double.valueOf(txtExistencia.getText());
                Double dResultado=dOrigen-cantidad*100;
                int resultado=dResultado.intValue();
                    System.out.println("nueva cantidad de mayoreo "+resultado);
                                //se prepara a actualizar la tabla mayoreo su nueva cantidad   
                                String origin = "UPDATE mayoreo set cantidad=? where idmayoreo=?";
                                PreparedStatement ps = cn.prepareStatement(origin);
                                ps.setInt(1,resultado);
                                ps.setInt(2,idProveedor);
                                ps.execute();
                                mostrarOrigen();
                
                JOptionPane.showMessageDialog(null, "Producto Correctamente actualizado");
                inicio();
                mostrarTabla();
                btnBuscar.setEnabled(true);
                btnNuevo.setEnabled(true);
                txtNombre.setText("");
                txtExistencia.setText("");
                txtMinimo.setText("");
                txtCosto.setText("");
                txtPublico.setText("");
                txtPuntos.setText("");
            } catch (SQLException ex) {
                Logger.getLogger(adm_Inventario.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_btnActualizarActionPerformed
    
    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
    
        this.dispose();

    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        int total = 0;
        String[] cabecera = {"id", "Producto", "Marca", "Cantidad", "Minimo", "Costo", "Publico"};
        String[] registros = new String[7];
        String txt = txtBNombre.getText();
        String sql = "SELECT inventario.idinventario, inventario.idproveedor,inventario.nombre,"
                + "proveedor.marca,inventario.cantidad,inventario.minimo,inventario.costo,inventario.publico"
                + " FROM inventario inner join proveedor on proveedor.idproveedor=inventario.idproveedor where inventario.nombre like '%"+txt+"%';";

        //establecemos los anchos en pixeles de las columnas
        int[] anchos = {0, 250, 250, 100, 100, 100, 100};
        modelo = new DefaultTableModel(null, cabecera);
        Connection cn = con.conectar();
        ResultSet rs = null;
        Statement st = null;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("idinventario");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("proveedor.marca");
                registros[3] = rs.getString("cantidad");
                registros[4] = rs.getString("minimo");
                registros[5] = rs.getString("costo");
                registros[6] = rs.getString("publico");
                total++;

                modelo.addRow(registros);

            }
            tabla.setModel(modelo);
            for (int i = 0; i < cabecera.length; i++) {
                tabla.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
                tabla.setFont(new java.awt.Font("Tahoma", 0, 12));
            }
            // asignamos la columna 0 para esconderla
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
            txtTotal.setText(Integer.toString(total));
        } catch (SQLException ex) {
            System.out.println("Sin poder ejecutar el query a la tabla "+ex);
        } finally {
            DbUtils.closeQuietly(st);
            DbUtils.closeQuietly(rs);
            DbUtils.closeQuietly(cn);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void mostrarOrigen(){
        String combo=jcMayoreo.getSelectedItem().toString();
        Connection cn = con.conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT cantidad FROM mayoreo WHERE nombre=?;";
            ps = cn.prepareStatement(sql);
            ps.setString(1, combo);
            rs = ps.executeQuery();
            while (rs.next()) {
                Double dcantidad=rs.getDouble("cantidad")/100;
                this.dOrigen=dcantidad;
                txtRestante.setText("Te quedan "+dcantidad+" Kilos");
            }            
        } catch (SQLException ex) {
            System.out.println(ex);;
        } finally {
            DbUtils.closeQuietly(rs);
            DbUtils.closeQuietly(ps);
            DbUtils.closeQuietly(cn);
            
        }
    }
    private void jcMayoreoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcMayoreoItemStateChanged
        mostrarOrigen();
        
    }//GEN-LAST:event_jcMayoreoItemStateChanged

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
            java.util.logging.Logger.getLogger(adm_Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adm_Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adm_Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adm_Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adm_Inventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcMayoreo;
    private javax.swing.JRadioButton jrActivo;
    private javax.swing.JPanel panelMaterial;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtBNombre;
    private javax.swing.JTextField txtBuscaProveedor;
    private javax.swing.JLabel txtCantidad;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtExistencia;
    private javax.swing.JLabel txtId;
    public static javax.swing.JLabel txtIdProveedor;
    private javax.swing.JTextField txtMinimo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPublico;
    private javax.swing.JTextField txtPuntos;
    private javax.swing.JLabel txtRestante;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}
