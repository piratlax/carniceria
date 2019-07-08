
package vista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;
import modelo.modelo;
import org.apache.commons.dbutils.DbUtils;
import static vista.EscritorioPrincipal.desktopPane;


public class integrarNota extends javax.swing.JInternalFrame {

    //al inicio de la clase
    DefaultComboBoxModel modeloCombo,filtradoProveedor;
    
    Conexion con=new Conexion();

    public integrarNota() {
        // esto va antes del initComponents
    modeloCombo  = new DefaultComboBoxModel(new String[]{});
    filtradoProveedor  = new DefaultComboBoxModel(new String[]{});
    initComponents();
    llenaProveedor();
    iniciar();
    mostrarTabla();
    txtId.setVisible(false);
    mostrarTabla.setVisible(false);
    }
    
    private void llenaProveedor(){
        //funcion de llenado de combobox
        
            try {
                    Connection cn=con.conectar();
                    /* Realizamos la consulta a la base de datos*/

                    String sql = "SELECT nombre FROM proveedor";

                    /* Se prepara la consulta */
                    Statement st = cn.createStatement();

                    /* Y se ejecuta en la siguiente línea */
                    ResultSet rs = st.executeQuery(sql);

                 //recorremos el resultado generado por la consulta 
                    while (rs.next()) {

                //fijate como con nuestro modelo y su método addElement vamos a agregar cada resultado a nuestro ComboBox, en lo personal concatene el resultado
                        modeloCombo.addElement(rs.getString("nombre"));
                        filtradoProveedor.addElement(rs.getString("nombre"));
                        
            }
            
        } catch (SQLException ex) {
            System.out.println("Sin poder ejecutar el query a la tabla");
        }
    
    }
    
    private void iniciar(){
        jcProveedor.setEnabled(false);
        txtNota.setEnabled(false);
        txtCantidad.setEnabled(false);
        jdFecha.setEnabled(false);
        jcEstado.setEnabled(false);
        btnIntegrar.setEnabled(false);
        btnActualizar.setEnabled(false);
    }
    
    private void limpiar(){
        txtNota.setText("");
        txtCantidad.setText("");
        jdFecha.setDate(null);
        jcProveedor.setEnabled(false);
        jcEstado.setEnabled(false);
        txtNota.setEnabled(false);
        txtCantidad.setEnabled(false);
        jdFecha.setEnabled(false);
    }
    
    public void mostrarTabla(){
        float pendiente=0f;
        float pagada=0f;
        float cancelada=0f;
        DefaultTableModel modelo;
        Statement st=null;
        ResultSet rs=null;
        String[] cabecera = {"Id","Nota","Proveedor","Cantidad","Estado","Fecha"};
        String[] registros = new String[6];
        String sql = "SELECT nota.idnota as idnota,nota.numero as numero,nota.idproveedor,nota.cantidad as cantidad,nota.estado as estado,"
                + "nota.fecha as fecha,proveedor.nombre as proveedor FROM nota INNER JOIN proveedor on nota.idproveedor=proveedor.idproveedor";
        //establecemos los anchos en pixeles de las columnas
        int[] anchos = {0, 30,150,50,70,70};

        modelo = new DefaultTableModel(null, cabecera);
        Connection cn=con.conectar();
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("idnota");
                registros[1] = rs.getString("numero");
                registros[2] = rs.getString("proveedor");
                registros[3] = rs.getString("cantidad");
                registros[4] = rs.getString("estado");
                registros[5] = rs.getString("fecha");
                
                modelo.addRow(registros);
                if (rs.getString("estado").equals("Pendiente")){
                    pendiente=pendiente+Float.parseFloat(rs.getString("cantidad"));
                }
                if (rs.getString("estado").equals("Pagada")){
                    pagada=pagada+Float.parseFloat(rs.getString("cantidad"));
                }
                if (rs.getString("estado").equals("Cancelada")){
                    cancelada=cancelada+Float.parseFloat(rs.getString("cantidad"));
                }

            }
            tabla.setModel(modelo);
            for (int i = 0; i < cabecera.length; i++) {
                tabla.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
                tabla.setFont(new java.awt.Font("Tahoma", 0, 10));
            }
            txtPendiente.setText(String.valueOf(pendiente));
            txtPagada.setText(String.valueOf(pagada));
            txtCancelada.setText(String.valueOf(cancelada));
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
        } catch (SQLException ex) {
            System.out.println("Sin poder ejecutar el query a la tabla"+ex);
        }finally {
            DbUtils.closeQuietly(rs);
            DbUtils.closeQuietly(st);
            DbUtils.closeQuietly(cn);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jcProveedor = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNota = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jcEstado = new javax.swing.JComboBox<>();
        btnIntegrar = new javax.swing.JButton();
        txtId = new javax.swing.JLabel();
        jdFecha = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jcFiltradoProveedor = new javax.swing.JComboBox<>();
        btnProveedor = new javax.swing.JButton();
        jcFiltrarEstado = new javax.swing.JComboBox<>();
        btnEstado = new javax.swing.JButton();
        btnAbonar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPendiente = new javax.swing.JLabel();
        txtPagada = new javax.swing.JLabel();
        txtCancelada = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnNueva = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        mostrarTabla = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Menu de Notas"));

        jcProveedor.setModel(modeloCombo);

        jLabel1.setText("Proveedor");

        jLabel2.setText("Nota No.");

        jLabel3.setText("Cantidad:");

        jLabel4.setText("Fecha:");

        jLabel5.setText("Estado:");

        jcEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente", "Pagada", "Cancelada" }));

        btnIntegrar.setMnemonic('i');
        btnIntegrar.setText("Integrar");
        btnIntegrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIntegrarActionPerformed(evt);
            }
        });

        txtId.setText("_");

        jdFecha.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jcEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jdFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(32, 32, 32)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnIntegrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtId)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4))
                    .addComponent(txtId)
                    .addComponent(jdFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIntegrar))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de notas"));

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

        jcFiltradoProveedor.setModel(filtradoProveedor);

        btnProveedor.setText("Filtrar");
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });

        jcFiltrarEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente", "Pagada", "Cancelada" }));

        btnEstado.setText("Filtrar");
        btnEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadoActionPerformed(evt);
            }
        });

        btnAbonar.setText("Abonar Pago");
        btnAbonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbonarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jcFiltradoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnProveedor)
                        .addGap(18, 18, 18)
                        .addComponent(jcFiltrarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAbonar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcFiltradoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProveedor)
                    .addComponent(jcFiltrarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEstado)
                    .addComponent(btnAbonar))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultados"));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Pendientes: $");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Pagadas: $");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Canceladas: $");

        txtPendiente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPendiente.setText("0");

        txtPagada.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPagada.setText("0");

        txtCancelada.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCancelada.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPendiente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPagada, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCancelada, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPendiente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtPagada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCancelada)))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));

        btnNueva.setMnemonic('n');
        btnNueva.setText("Nueva");
        btnNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaActionPerformed(evt);
            }
        });

        btnEditar.setMnemonic('e');
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnActualizar.setMnemonic('a');
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setMnemonic('l');
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNueva)
                .addGap(18, 18, 18)
                .addComponent(btnEditar)
                .addGap(18, 18, 18)
                .addComponent(btnActualizar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jButton1.setMnemonic('s');
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        mostrarTabla.setText("_");
        mostrarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarTablaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(mostrarTabla)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(mostrarTabla)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaActionPerformed
        jcProveedor.setEnabled(true);
        txtNota.setEnabled(true);
        txtCantidad.setEnabled(true);
        jdFecha.setEnabled(true);
        jcEstado.setEnabled(true);
        btnIntegrar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }//GEN-LAST:event_btnNuevaActionPerformed

    private void btnIntegrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIntegrarActionPerformed
        float cantidad=0f;
        boolean paso=false;
        try {
            try {
                cantidad = Float.parseFloat(txtCantidad.getText());
                paso = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "coloca una cifra correcta");
            }
        } catch (Exception e) {
        }
        
        if (txtNota.getText().equals("")){
           JOptionPane.showMessageDialog(this, "Favor de colocar el numero de la nota");
           txtNota.requestFocus();
       }else if (txtCantidad.getText().equals("")){
           JOptionPane.showMessageDialog(this, "Favor de colocar la cantidad de la nota");
           txtCantidad.requestFocus();
       }else if (jdFecha.getDate()==null){
           JOptionPane.showMessageDialog(this, "Favor de seleccionar una fecha");
           jdFecha.requestFocus();
       }else{
           if (paso){ 
               
               String proveedor = jcProveedor.getSelectedItem().toString();
               
               modelo mod= new modelo();
               String id=mod.idProveedor(proveedor);
               String nota=txtNota.getText();
               cantidad=Float.parseFloat(txtCantidad.getText());
               
               java.util.Date d =jdFecha.getDate();
               java.sql.Date date = new java.sql.Date(d.getTime());
               
               String fecha=date.toString();
               
               String estado=jcEstado.getSelectedItem().toString();
               //insertamos la nota
               boolean resultado=mod.insertarNota(id, nota, cantidad, fecha, estado);
               if (resultado){
                   JOptionPane.showMessageDialog(this, "Nota correctamente integrada");
               }else{
                   JOptionPane.showMessageDialog(this, "Error en la bd, Nota no integrada");
               }
               limpiar();
               mostrarTabla();
               btnIntegrar.setEnabled(false);
               btnEditar.setEnabled(true);
               btnEliminar.setEnabled(true);
               
               
           }
       }
    }//GEN-LAST:event_btnIntegrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
       int fila = tabla.getSelectedRow();

        if (fila >= 0) {
            
            txtNota.setEnabled(true);
            txtCantidad.setEnabled(true);
            jcProveedor.setEnabled(true);
            jcEstado.setEnabled(true);
            jdFecha.setEnabled(true);
            btnActualizar.setEnabled(true);
            btnEditar.setEnabled(false);
            btnNueva.setEnabled(false);
            btnEliminar.setEnabled(false);
            
            Connection cn=con.conectar();
            Statement st=null;
            ResultSet rs=null;
            try {
                String id = tabla.getValueAt(fila, 0).toString();
                String sql = "SELECT * FROM nota  where idnota='" + id + "'";
                st = cn.createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    txtCantidad.setText(rs.getString("cantidad"));
                    txtNota.setText(rs.getString("numero"));
                    //jdFecha.setDate(rs.getDate("fecha"));
                    jcProveedor.setSelectedIndex(rs.getInt("idproveedor")-1);
                    txtId.setText(rs.getString("idnota"));
                }
                mostrarTabla();
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                DbUtils.closeQuietly(rs);
                DbUtils.closeQuietly(st);
                DbUtils.closeQuietly(cn);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un elemento de la tabla");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        String id=txtId.getText();
        String proveedor=jcProveedor.getSelectedItem().toString();
        String estado=jcEstado.getSelectedItem().toString();
        String nota=txtNota.getText();
        float cantidad=0f;
        boolean paso=false;
        try {
            cantidad = Float.parseFloat(txtCantidad.getText());
            paso=true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Verifica la cantidad");
            txtCantidad.requestFocus();
        }
        java.util.Date d = jdFecha.getDate();
        System.out.println(d);
        java.sql.Date date = new java.sql.Date(d.getTime());
        System.out.println(date);
        String fecha=date.toString();
        System.out.println(fecha);
        modelo mod=new modelo();
        
        String idProveedor=mod.idProveedor(proveedor);
        if (paso){
        Conexion con = new Conexion();
        Connection cn = con.conectar();
        PreparedStatement ps = null;
        try {
            //se prepara a insertarlo en la tabla   
            String sql = "UPDATE nota set numero=?,cantidad=?,fecha=?,idproveedor=?,estado=? WHERE idnota=?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, nota);
            ps.setFloat(2, cantidad);
            ps.setString(3, fecha);
            ps.setString(4, idProveedor);
            ps.setString(5, estado);
            ps.setString(6, id);
            ps.execute();
            JOptionPane.showMessageDialog(this, "Nota "+nota+" corecctamente actualizada");
            mostrarTabla();
            btnActualizar.setEnabled(false);
            btnNueva.setEnabled(true);
            btnEditar.setEnabled(true);
            btnEliminar.setEnabled(true);
            limpiar();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            DbUtils.closeQuietly(ps);
            DbUtils.closeQuietly(cn);
            
        }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            String id = tabla.getValueAt(fila, 0).toString();
            String nota = tabla.getValueAt(fila, 1).toString();
            String proveedor= tabla.getValueAt(fila, 2).toString();
            String cantidad = tabla.getValueAt(fila, 3).toString();
           
           int respuesta=JOptionPane.showConfirmDialog(this, "Estas seguro de eliminar la nota "+nota+"\nDel proveedor "+proveedor+"\npor la cantidad de "+cantidad, "Atencion", 0);
            if (respuesta==0){
            Connection cn = con.conectar();
            Statement st = null;
            ResultSet rs = null;
            try {
                String sql = "DELETE FROM nota  where idnota='" + id + "'";
                st = cn.createStatement();
                st.execute(sql);
                mostrarTabla();
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                DbUtils.closeQuietly(rs);
                DbUtils.closeQuietly(st);
                DbUtils.closeQuietly(cn);
            }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un nota a eliminar");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        modelo mod=new modelo();
        String proveedor=jcFiltradoProveedor.getSelectedItem().toString();
        String id = mod.idProveedor(proveedor);
        float pendiente=0f;
        float pagada=0f;
        float cancelada=0f;
        DefaultTableModel modelo;
        Statement st=null;
        ResultSet rs=null;
        String[] cabecera = {"Id","Nota","Proveedor","Cantidad","Estado","Fecha"};
        String[] registros = new String[6];
        String sql = "SELECT nota.idnota as idnota,nota.numero as numero,nota.cantidad as cantidad,nota.estado as estado,"
                + "nota.fecha as fecha,proveedor.nombre as proveedor FROM nota INNER JOIN proveedor on nota.idproveedor=proveedor.idproveedor WHERE proveedor='"+proveedor+"'";
        //establecemos los anchos en pixeles de las columnas
        int[] anchos = {0, 30,150,50,70,70};

        modelo = new DefaultTableModel(null, cabecera);
        Connection cn=con.conectar();
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("idnota");
                registros[1] = rs.getString("numero");
                registros[2] = rs.getString("proveedor");
                registros[3] = rs.getString("cantidad");
                registros[4] = rs.getString("estado");
                registros[5] = rs.getString("fecha");
                
                modelo.addRow(registros);
                if (rs.getString("estado").equals("Pendiente")){
                    pendiente=pendiente+Float.parseFloat(rs.getString("cantidad"));
                }
                if (rs.getString("estado").equals("Pagada")){
                    pagada=pagada+Float.parseFloat(rs.getString("cantidad"));
                }
                if (rs.getString("estado").equals("Cancelada")){
                    cancelada=cancelada+Float.parseFloat(rs.getString("cantidad"));
                }

            }
            tabla.setModel(modelo);
            for (int i = 0; i < cabecera.length; i++) {
                tabla.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
                tabla.setFont(new java.awt.Font("Tahoma", 0, 10));
            }
            txtPendiente.setText(String.valueOf(pendiente));
            txtPagada.setText(String.valueOf(pagada));
            txtCancelada.setText(String.valueOf(cancelada));
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
        } catch (SQLException ex) {
            System.out.println("Sin poder ejecutar el query a la tabla"+ex);
        }finally {
            DbUtils.closeQuietly(rs);
            DbUtils.closeQuietly(st);
            DbUtils.closeQuietly(cn);
        }
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void btnEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadoActionPerformed
      String estado=jcFiltrarEstado.getSelectedItem().toString();
      float pendiente=0f;
        float pagada=0f;
        float cancelada=0f;
        DefaultTableModel modelo;
        Statement st=null;
        ResultSet rs=null;
        String[] cabecera = {"Id","Nota","Proveedor","Cantidad","Estado","Fecha"};
        String[] registros = new String[6];
        String sql = "SELECT nota.idnota as idnota,nota.numero as numero,nota.cantidad as cantidad,nota.estado as estado,"
                + "nota.fecha as fecha,proveedor.nombre as proveedor FROM nota INNER JOIN proveedor on nota.idproveedor=proveedor.idproveedor WHERE nota.estado='"+estado+"'";
        //establecemos los anchos en pixeles de las columnas
        int[] anchos = {0, 30,150,50,70,70};

        modelo = new DefaultTableModel(null, cabecera);
        Connection cn=con.conectar();
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("idnota");
                registros[1] = rs.getString("numero");
                registros[2] = rs.getString("proveedor");
                registros[3] = rs.getString("cantidad");
                registros[4] = rs.getString("estado");
                registros[5] = rs.getString("fecha");
                
                modelo.addRow(registros);
                if (rs.getString("estado").equals("Pendiente")){
                    pendiente=pendiente+Float.parseFloat(rs.getString("cantidad"));
                }
                if (rs.getString("estado").equals("Pagada")){
                    pagada=pagada+Float.parseFloat(rs.getString("cantidad"));
                }
                if (rs.getString("estado").equals("Cancelada")){
                    cancelada=cancelada+Float.parseFloat(rs.getString("cantidad"));
                }

            }
            tabla.setModel(modelo);
            for (int i = 0; i < cabecera.length; i++) {
                tabla.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
                tabla.setFont(new java.awt.Font("Tahoma", 0, 10));
            }
            txtPendiente.setText(String.valueOf(pendiente));
            txtPagada.setText(String.valueOf(pagada));
            txtCancelada.setText(String.valueOf(cancelada));
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
        } catch (SQLException ex) {
            System.out.println("Sin poder ejecutar el query a la tabla"+ex);
        }finally {
            DbUtils.closeQuietly(rs);
            DbUtils.closeQuietly(st);
            DbUtils.closeQuietly(cn);
        }
    }//GEN-LAST:event_btnEstadoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAbonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbonarActionPerformed
        int fila = tabla.getSelectedRow();
        
        if (fila >= 0) {
            modelo mod=new modelo();
            mod.setIdNota(tabla.getValueAt(fila, 0).toString());
            Abonar abonar = new Abonar();
            desktopPane.add(abonar);
            abonar.setLocation(500, 200);
            abonar.setVisible(true);
            
                
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un elemento de la tabla");
        }
    }//GEN-LAST:event_btnAbonarActionPerformed

    private void mostrarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarTablaActionPerformed
       mostrarTabla();
    }//GEN-LAST:event_mostrarTablaActionPerformed

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
            java.util.logging.Logger.getLogger(integrarNota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(integrarNota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(integrarNota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(integrarNota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new integrarNota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbonar;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEstado;
    private javax.swing.JButton btnIntegrar;
    private javax.swing.JButton btnNueva;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcEstado;
    private javax.swing.JComboBox<String> jcFiltradoProveedor;
    private javax.swing.JComboBox<String> jcFiltrarEstado;
    private javax.swing.JComboBox<String> jcProveedor;
    private com.toedter.calendar.JDateChooser jdFecha;
    public static javax.swing.JButton mostrarTabla;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel txtCancelada;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JLabel txtId;
    private javax.swing.JTextField txtNota;
    private javax.swing.JLabel txtPagada;
    private javax.swing.JLabel txtPendiente;
    // End of variables declaration//GEN-END:variables
}
