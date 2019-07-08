
package vista;

import com.mxrck.autocompleter.TextAutoCompleter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;
import modelo.Ventana;
import modelo.modelo;
import modelo.n2t;
import org.apache.commons.dbutils.DbUtils;

public class Venta4 extends javax.swing.JInternalFrame {

    Conexion con= new Conexion();
    float precio=0;
    public Venta4() {
        initComponents();
        autoCompletadoCliente();
        autoCompletadoProducto();
        //se establece el boton default
        SwingUtilities.getRootPane(btnIntegrar).setDefaultButton(btnIntegrar);
        mostrarTabla();
        txtCliente.requestFocus();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnBorrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnFocusRecibido = new javax.swing.JButton();
        btnCantidad = new javax.swing.JButton();
        btnDinero = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JLabel();
        btnIntegrar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDinero = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtKilos = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtSIgno = new javax.swing.JLabel();
        btnCobrar = new javax.swing.JButton();
        txtTotal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtRecibo = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        txtCantidadLetra = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de compras"));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        jButton1.setMnemonic('q');
        jButton1.setText("Quitar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnFocusRecibido.setMnemonic('r');
        btnFocusRecibido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFocusRecibidoActionPerformed(evt);
            }
        });

        btnCantidad.setMnemonic('a');
        btnCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCantidadActionPerformed(evt);
            }
        });

        btnDinero.setMnemonic('d');
        btnDinero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDineroActionPerformed(evt);
            }
        });

        jButton2.setMnemonic('e');
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFocusRecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDinero, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBorrar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBorrar)
                        .addComponent(jButton1)
                        .addComponent(btnFocusRecibido)
                        .addComponent(btnCantidad)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDinero, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        jLabel1.setText("Nombre:");

        txtCliente.setMaximumSize(new java.awt.Dimension(6, 210));

        jLabel2.setText("Producto");

        txtProducto.setToolTipText("Presiona alt+e para escribir producto");
        txtProducto.setMaximumSize(new java.awt.Dimension(6, 218));
        txtProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProductoFocusLost(evt);
            }
        });

        jLabel3.setText("Cantidad");

        txtCantidad.setToolTipText("Presiona alt+a para escribir producto");
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadKeyReleased(evt);
            }
        });

        txtPrecio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPrecio.setText("_");
        txtPrecio.setMaximumSize(new java.awt.Dimension(10, 55));
        txtPrecio.setMinimumSize(new java.awt.Dimension(10, 55));

        btnIntegrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIntegrarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("$");

        jLabel4.setText("Dinero:");

        txtDinero.setToolTipText("Presiona alt+d para escribir producto");
        txtDinero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDineroKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("K");

        txtKilos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtKilos.setText("_");
        txtKilos.setMaximumSize(new java.awt.Dimension(10, 55));
        txtKilos.setMinimumSize(new java.awt.Dimension(10, 55));
        txtKilos.setPreferredSize(new java.awt.Dimension(10, 55));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIntegrar, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDinero, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKilos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnIntegrar)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtDinero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtKilos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)))
                .addGap(20, 20, 20))
        );

        txtSIgno.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtSIgno.setText("$");

        btnCobrar.setMnemonic('c');
        btnCobrar.setText("Cobrar");
        btnCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCobrarActionPerformed(evt);
            }
        });

        txtTotal.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtTotal.setText("_");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel5.setText("Venta 4");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Recibo:");

        txtRecibo.setToolTipText("Presiona Alt+r para escribir cifra");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtSIgno, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSIgno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCobrar)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtCantidadLetra.setText("$");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtCantidadLetra, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCantidadLetra)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtProductoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductoFocusLost
        Connection cn = con.conectar();
        String producto=txtProducto.getText();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM inventario WHERE nombre=?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, producto);
            rs = ps.executeQuery();
            while (rs.next()) {
                precio=rs.getInt("publico");
            }            
        } catch (SQLException ex) {
            System.out.println(ex);;
        } finally {
            DbUtils.closeQuietly(rs);
            DbUtils.closeQuietly(ps);
            DbUtils.closeQuietly(cn);
            
        }
    }//GEN-LAST:event_txtProductoFocusLost

    private void txtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyReleased
      String presionado=txtCantidad.getText();
        try {
            float valor=Float.valueOf(presionado);
            float resultado=(precio/100)*valor;
            //DecimalFormat formato = new DecimalFormat("#.00");
            String preliminar=String.valueOf(resultado);
            txtPrecio.setText(preliminar);
        } catch (Exception e) {
            System.out.println(e);
            if (e.equals("empty String")){
                txtPrecio.setText("$");
            }
        }
    }//GEN-LAST:event_txtCantidadKeyReleased

    private void btnIntegrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIntegrarActionPerformed
       if (txtRecibo.getText().equals("")){
        
        if (txtProducto.getText().equals("")){
           JOptionPane.showMessageDialog(this, "No hay producto a integrar al ticket");
       }else{
           Conexion con = new Conexion();
           Connection cn = con.conectar();
           PreparedStatement ps = null;
           modelo mod=new modelo();
           int idCliente=mod.idCliente(txtCliente.getText());
           int idProducto=mod.idProducto(txtProducto.getText());
           int producto=0;
           int precio=0;
           if (txtDinero.getText().equals("")){
           producto=mod.retornaInt(txtCantidad.getText());
           precio=mod.retornaInt(txtPrecio.getText());
           }else{
           producto=mod.retornaInt(txtKilos.getText());
           precio=mod.retornaInt(txtDinero.getText());
           }
           try {
               //se prepara a insertarlo en la tabla   
               String sql = "INSERT INTO cuarta (cliente,producto,cantidad,precio)"
                       + " VALUES (?,?,?,?)";
               ps = cn.prepareStatement(sql);
               ps.setInt(1, idCliente);
               ps.setInt(2, idProducto);
               ps.setInt(3, producto);
               ps.setInt(4, precio);
               ps.execute();
           } catch (SQLException ex) {
               System.out.println(ex);
           } finally {
               DbUtils.closeQuietly(ps);
               DbUtils.closeQuietly(cn);
               
           }
           mostrarTabla();
           txtProducto.setText("");
           txtCantidad.setText("");
           txtPrecio.setText("");
           txtDinero.setText("");
           txtKilos.setText("");
           txtProducto.requestFocus();
       }
       }else{
           btnCobrar.doClick();
       }
    }//GEN-LAST:event_btnIntegrarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            String id = tabla.getValueAt(fila, 0).toString();
            
                Connection cn = con.conectar();
                Statement st = null;
                try {
                    String sql = "DELETE FROM cuarta where idcuarta="+ id;
                    System.out.println(sql);
                    st = cn.createStatement();
                    st.execute(sql);
                    mostrarTabla();
                } catch (SQLException ex) {
                    System.out.println(ex);
                } finally {
                    DbUtils.closeQuietly(st);
                    DbUtils.closeQuietly(cn);
                }
            
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un elemento a borrar");
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Ventana.setVenta4(false);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobrarActionPerformed
        double recibo=0;
        try {
            recibo=Double.valueOf(txtRecibo.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Coloca una cifra de cobro correcta");
            txtRecibo.setText("");
        }
        if (txtCliente.getText().equals("") || txtTotal.getText().equals("0.0") || recibo<1 ){
           JOptionPane.showMessageDialog(this, "Faltan datos");
           txtRecibo.setText("");
       }else{
            
          //  mostramos lo que hay que devolver
            Double vuelto=recibo-Double.valueOf(txtTotal.getText());
            JOptionPane.showMessageDialog(this, "El cambio es de "+vuelto);
           //obtenemos el valor del ultimo ticket
           modelo mod=new modelo();
           int ticket=mod.ultimoTicket();
           Connection cn = con.conectar();
           PreparedStatement ps = null;
           ResultSet rs = null;
           try {
               String sql = "SELECT * FROM cuarta";
               ps = cn.prepareStatement(sql);
               rs = ps.executeQuery();
               while (rs.next()) {
                   
                   PreparedStatement psTicket = null;
                   try {
                       //se prepara a insertarlo en la tabla   
                       String sqlTicket = "INSERT INTO ticket (numero,cliente,inventario,cantidad)"
                               + " VALUES (?,?,?,?)";
                       psTicket = cn.prepareStatement(sqlTicket);
                       psTicket.setInt(1, ticket );
                       psTicket.setInt(2, rs.getInt("cliente") );
                       psTicket.setInt(3, rs.getInt("producto") );
                       psTicket.setInt(4, rs.getInt("cantidad"));
                       psTicket.execute();
                       
                       int cantidad=rs.getInt("cantidad");
                       int inventario=rs.getInt("producto");
                           String resta = "UPDATE inventario set cantidad=cantidad-"+cantidad+" "
                                   + "where idinventario="+inventario;
                           Statement st = cn.createStatement();
                           st.execute(resta);
                       
                       
                   } catch (SQLException ex) {
                       System.out.println(ex);
                     
                   }
               }               
           } catch (SQLException ex) {
               System.out.println(ex);;
           }
           
           //borramos la lista de compras
          
                   Statement st = null;
                   try {
                       String sql = "DELETE FROM cuarta";
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
            //imprimimos ticket
            
            if (txtTotal.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "no hay nada para generar el ticket");
        } else {
                Ventana.setVenta4(false);
                mod.impresionTicket(ticket, txtCliente.getText(),recibo);
                this.dispose();

        }
       }
    
    }//GEN-LAST:event_btnCobrarActionPerformed

    private void txtDineroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDineroKeyReleased
       String presionado=txtDinero.getText();
        try {
            float valor=Float.valueOf(presionado);
            float resultado=(valor*100)/precio;
            //DecimalFormat formato = new DecimalFormat("#.00");
            String preliminar=String.valueOf(resultado);
            txtKilos.setText(preliminar);
        } catch (Exception e) {
            System.out.println(e);
            if (e.equals("empty String")){
                txtKilos.setText("K");
            }
        }
    }//GEN-LAST:event_txtDineroKeyReleased

    private void btnFocusRecibidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFocusRecibidoActionPerformed
       txtRecibo.requestFocus();
    }//GEN-LAST:event_btnFocusRecibidoActionPerformed

    private void btnCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCantidadActionPerformed
       txtCantidad.requestFocus();
    }//GEN-LAST:event_btnCantidadActionPerformed

    private void btnDineroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDineroActionPerformed
       txtDinero.requestFocus();
    }//GEN-LAST:event_btnDineroActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       txtProducto.requestFocus();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void mostrarTabla(){
        DefaultTableModel modelo;
        Statement st = null;
        ResultSet rs = null;
        String[] cabecera = {"Id","Producto","Cantidad","Precio"};
        String[] registros = new String[4];
        String sql = "SELECT cuarta.idcuarta as id,cuarta.producto,cuarta.cantidad as cantidad,cuarta.precio as precio,inventario.publico,inventario.nombre as nombre FROM cuarta INNER JOIN inventario on cuarta.producto=inventario.idinventario";
        //establecemos los anchos en pixeles de las columnas
        int[] anchos = {0, 100,50,50};
        
        modelo = new DefaultTableModel(null, cabecera);
        Connection cn = con.conectar();
        
        //valor del ticket
        float total=0;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Double dPrecio=Double.valueOf(rs.getString("precio"))/100;
                Double dCantidad=Double.valueOf(rs.getString("cantidad"))/100;
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("nombre");
                registros[2] = String.valueOf(dCantidad);
                registros[3] = String.valueOf(dPrecio);
                
                modelo.addRow(registros);
                total+=dPrecio;
            }
            tabla.setModel(modelo);
            for (int i = 0; i < cabecera.length; i++) {
                tabla.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
                tabla.setFont(new java.awt.Font("Tahoma", 0, 10));
            }
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
            
            //establecemos el precio
            txtTotal.setText(String.valueOf(total));
            

            //colocamos el valor con letra
            n2t numero;
             BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int num;
            String res;

        num = (int) Double.parseDouble(txtTotal.getText());
        numero = new n2t(num);
        res = numero.convertirLetras(num).toUpperCase();
        BigDecimal number = new BigDecimal(String.valueOf(total)+"0");
        BigDecimal fraccion = number.remainder(BigDecimal.ONE);
        txtCantidadLetra.setText(res + " PESOS ");
        } catch (SQLException ex) {
            System.out.println("Sin poder ejecutar el query a la tabla" + ex);
        } finally {
            DbUtils.closeQuietly(rs);
            DbUtils.closeQuietly(st);
            DbUtils.closeQuietly(cn);
        }
    }
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
            java.util.logging.Logger.getLogger(Venta4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Venta4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Venta4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Venta4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Venta4().setVisible(true);
                
            }
        });
    }
    private void autoCompletadoProducto(){
        TextAutoCompleter textAutoCompleter = new TextAutoCompleter(txtProducto);
        textAutoCompleter.setMode(0); // infijo
        textAutoCompleter.setCaseSensitive(false); //No sensible a mayúsculas
        Connection cn = con.conectar();
        Statement st = null;
        ResultSet rs = null;
        //iniciamos
        try {
            String sql = "SELECT nombre FROM inventario";
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                textAutoCompleter.addItem(rs.getString("nombre"));
                
            }
            
        } catch (SQLException ex) {
            System.out.println("Sin poder ejecutar el query al autocomplete");
        } finally {
            DbUtils.closeQuietly(st);
            DbUtils.closeQuietly(rs);
            DbUtils.closeQuietly(cn);
        }
    }
    private void autoCompletadoCliente(){
        TextAutoCompleter textAutoCompleter = new TextAutoCompleter(txtCliente);
        textAutoCompleter.setMode(0); // infijo
        textAutoCompleter.setCaseSensitive(false); //No sensible a mayúsculas
        Connection cn=con.conectar();
        Statement st=null;
        ResultSet rs=null;
        //iniciamos
        try {
            String sql = "SELECT nombre FROM cliente ";
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                textAutoCompleter.addItem(rs.getString("nombre"));

            }

        } catch (SQLException ex) {
            System.out.println("Sin poder ejecutar el query al autocomplete");
        } finally {
            DbUtils.closeQuietly(st);
            DbUtils.closeQuietly(rs);
            DbUtils.closeQuietly(cn);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCantidad;
    private javax.swing.JButton btnCobrar;
    private javax.swing.JButton btnDinero;
    private javax.swing.JButton btnFocusRecibido;
    private javax.swing.JButton btnIntegrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JLabel txtCantidadLetra;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtDinero;
    private javax.swing.JLabel txtKilos;
    private javax.swing.JLabel txtPrecio;
    public static javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtRecibo;
    private javax.swing.JLabel txtSIgno;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}
