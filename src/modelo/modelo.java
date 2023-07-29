
package modelo;

import br.com.adilson.util.Extenso;
import br.com.adilson.util.PrinterMatrix;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import org.apache.commons.dbutils.DbUtils;

public class modelo {
Conexion con=new Conexion();
static String idNota;

    public static String getIdNota() {
        return idNota;
    }

    public static void setIdNota(String idNota) {
        modelo.idNota = idNota;
    }


//funcion para obtener la id del proveedor
public String idProveedor (String proveedor){
        String Proveedor=proveedor;
        String id=null;
        Connection cn=con.conectar();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            String sql = "SELECT idproveedor FROM proveedor WHERE nombre=?";
            ps=cn.prepareStatement(sql);
            ps.setString(1,Proveedor);
            rs = ps.executeQuery();
            while (rs.next()) {
                id=rs.getString("idproveedor");
            }         
            } catch (SQLException ex) {
            System.out.println(ex);;
        }finally {
            DbUtils.closeQuietly(rs);
            DbUtils.closeQuietly(ps);
            DbUtils.closeQuietly(cn);
       
        }
    
    return id;
}

// retorna el ultimo ticket
public int ultimoTicket (){
        int ticket=1;
        Connection cn=con.conectar();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            String sql = "SELECT numero FROM ticket ORDER BY numero DESC limit 1";
            ps=cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ticket=Integer.valueOf(rs.getString("numero"));
                ticket++;
            }         
            } catch (SQLException ex) {
            System.out.println(ex);;
        }finally {
            DbUtils.closeQuietly(rs);
            DbUtils.closeQuietly(ps);
            DbUtils.closeQuietly(cn);
       
        }
    
    return ticket;
}
public int idCliente (String cliente){
        int id=0;
        Connection cn=con.conectar();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            String sql = "SELECT idcliente FROM cliente WHERE nombre=?";
            ps=cn.prepareStatement(sql);
            ps.setString(1,cliente);
            rs = ps.executeQuery();
            while (rs.next()) {
                id=rs.getInt("idcliente");
            }         
            } catch (SQLException ex) {
            System.out.println(ex);;
        }finally {
            DbUtils.closeQuietly(rs);
            DbUtils.closeQuietly(ps);
            DbUtils.closeQuietly(cn);
       
        }
    
    return id;
}

public int idProducto (String producto){
        int id=0;
        Connection cn=con.conectar();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            String sql = "SELECT idinventario FROM inventario WHERE nombre=?";
            ps=cn.prepareStatement(sql);
            ps.setString(1,producto);
            rs = ps.executeQuery();
            while (rs.next()) {
                id=Integer.valueOf(rs.getString("idinventario"));
            }         
            } catch (SQLException ex) {
            System.out.println(ex);;
        }finally {
            DbUtils.closeQuietly(rs);
            DbUtils.closeQuietly(ps);
            DbUtils.closeQuietly(cn);
       
        }
    
    return id;
}

public int idMayoreo (String producto){
        int id=0;
        Connection cn=con.conectar();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            String sql = "SELECT idmayoreo FROM mayoreo WHERE nombre=?";
            ps=cn.prepareStatement(sql);
            ps.setString(1,producto);
            rs = ps.executeQuery();
            while (rs.next()) {
                id=Integer.valueOf(rs.getString("idmayoreo"));
            }         
            } catch (SQLException ex) {
            System.out.println(ex);;
        }finally {
            DbUtils.closeQuietly(rs);
            DbUtils.closeQuietly(ps);
            DbUtils.closeQuietly(cn);
       
        }
    
    return id;
}


// funcion para integrar nueva nota

public boolean insertarNota (String idProveedor, String nota,float Cantidad, String Fecha, String Estado){
    boolean resultado=false;
    
    Conexion con = new Conexion();
    Connection cn = con.conectar();
    PreparedStatement ps = null;
    try {
        //se prepara a insertarlo en la tabla   
        String sql = "INSERT INTO nota (idproveedor,fecha,numero,cantidad,estado)"
                + " VALUES (?,?,?,?,?)";
        ps = cn.prepareStatement(sql);
        ps.setString(1, idProveedor);
        ps.setString(2, Fecha);
        ps.setString(3, nota);
        ps.setFloat(4, Cantidad);
        ps.setString(5, Estado);
        ps.execute();
        resultado=true;
    } catch (SQLException ex) {
        System.out.println(ex);
    } finally {
        DbUtils.closeQuietly(ps);
        DbUtils.closeQuietly(cn);
        
    }
    
    return resultado;
}

public int retornaInt(String numero){
    Double dvalor=Double.valueOf(numero)*100;
    int valor=dvalor.intValue();
    return valor;
}

public String valorInt(String numero){
    Double dValor=Double.valueOf(numero)/100;
    String valor=String.valueOf(dValor);
    return valor;
}

public void impresionTicket(int ticket,String cliente,Double recibo){
    int filas=22;
    int linea=0;
    Double cuenta=0.00;
    //contamos cuantas lineas tiene la venta
    Connection cn = con.conectar();
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
        String sql = "SELECT count(*)as contar FROM ticket WHERE numero=?";
        ps = cn.prepareStatement(sql);
        ps.setInt(1, 1);
        rs = ps.executeQuery();
        while (rs.next()) {
            filas+=rs.getInt("contar");
        }        
    } catch (SQLException ex) {
        System.out.println(ex);;
    }

            PrinterMatrix printer = new PrinterMatrix();

            Extenso e = new Extenso();

            e.setNumber(20.30);
              printer.setOutSize(filas, 32);
    
            java.util.Date fecha = new java.util.Date();
            DateFormat horaYfecha = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
//Imprimir = 1ra linea de la columa de 1 a 32
            printer.printTextWrap(linea, 1, 0, 32, "================================");
            linea++;
            printer.printTextWrap(linea, 1, 0, 32, "       Carniceria KARSAD ");
            linea++;
            printer.printTextWrap(linea, 1, 0, 32, "================================");
            linea++;
            printer.printTextWrap(linea, 1, 0, 32, "     RFC: CACM8409235Y9");
            linea++;
            printer.printTextWrap(linea, 1, 0, 32, "Ingenieros 38, Loma Bonita");
            linea++;
            printer.printTextWrap(linea, 1, 0, 32, "Tel. 246 228 597");
            linea++;
            printer.printTextWrap(linea, 1, 0, 10, "Hora,Fecha");
            printer.printTextWrap(linea, 1, 11, 32, horaYfecha.format(fecha).toString());
            linea++;
            printer.printTextWrap(linea, 1, 0, 32, "Numero de Ticket: " + ticket);
            linea++;
            printer.printTextWrap(linea, 1, 0, 32, "Cliente: " + cliente);
            linea++;
            printer.printTextWrap(linea, 1, 0, 32, "--------------------------------");
            linea++;
            printer.printTextWrap(linea, 1, 0, 32, "DESCRIPCION PRECIO CANT IMPORTE");
            linea++;
            printer.printTextWrap(linea, 1, 0, 32, " ");
            linea++;
        //acomulamos lo del ticket
        
        
        try {
            String sql = "SELECT inventario.nombre as producto, inventario.publico as precio," +
            "ticket.cantidad as cantidad from ticket " +
            "INNER JOIN inventario on ticket.inventario = inventario.idinventario" +
            " where ticket.numero=?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, ticket);
            rs = ps.executeQuery();
            while (rs.next()) {
            String precio=valorInt(rs.getString("precio"));    
            String cantidad=valorInt(rs.getString("cantidad"));
            
            Double vCantidad=Double.valueOf(cantidad);
            Double vprecio=Double.valueOf(precio);
            
            Double total=Math.ceil(vCantidad*vprecio);
            cuenta+=total;
            String str = rs.getString("producto");
            String descripcion = null;
            if (str != null && str.length() > 12) {
            descripcion = str.substring(0, 12);
            } else {
            descripcion = str;
            }
            
            printer.printTextWrap(linea , 1, 0, 12 ,descripcion);
            printer.printTextWrap(linea , 1, 13, 17,precio);
            String pre= printer.alinharADireita(5, cantidad);
            printer.printTextWrap(linea , 1, 18, 24, pre);
            String inp= printer.alinharADireita(7,total.toString());
            printer.printTextWrap(linea , 1, 25, 32, inp);
            linea++;
            }            
        
        }
         catch (SQLException ex) {
            System.out.println(ex);;
        }
        //final de ticket
        printer.printTextWrap(linea, 1, 0, 32, "--------------------------------");
        linea++;
        printer.printTextWrap(linea, 1, 0, 32, "Total de compra         " + cuenta);
        linea++;
        printer.printTextWrap(linea, 1, 0, 32, "Dinero recibido         " + recibo);
        linea++;
        printer.printTextWrap(linea, 1, 0, 32, "Dinero devuelto         " + (recibo-cuenta));
        linea++;
        printer.printTextWrap(linea, 1, 0, 32, "================================");
        linea++;
        printer.printTextWrap(linea, 1, 0, 32, " !Gracias por su preferencia! ");
        linea++;
        printer.printTextWrap(linea, 1, 0, 32, "================================");
        linea++;
        printer.printTextWrap(linea, 1, 0, 32, " ");
        linea++;
        printer.printTextWrap(linea, 1, 0, 32, " ");
        linea++;
        printer.printTextWrap(linea, 1, 0, 32, " ");
        linea++;
        
///CREAR CARPETA tmp EN UNIDAD C
printer.toFile("impresion.txt");

FileInputStream inputStream = null;
try {
inputStream = new FileInputStream("impresion.txt");
} catch (FileNotFoundException ex) {
ex.printStackTrace();
    System.out.println(ex);

}
if (inputStream == null) {
return;
}

DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
Doc document = new SimpleDoc(inputStream, docFormat, null);

PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();

PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

if (defaultPrintService != null) {
DocPrintJob printJob = defaultPrintService.createPrintJob();
try {
printJob.print(document, attributeSet);

} catch (Exception ex) {
ex.printStackTrace();
}
} else {
System.err.println("No existen impresoras instaladas");
}

    try {
        inputStream.close();
    } catch (IOException ex) {
        Logger.getLogger(modelo.class.getName()).log(Level.SEVERE, null, ex);
    }
    
}

public void impresionRecibo(){
    int filas=21;
    int linea=0;
    
    String nota=null,cantidad=null,fecha=null,recibe=null,numero=null;
    //contamos cuantas lineas tiene la venta
    Connection cn = con.conectar();
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
        String sql = "SELECT * FROM abono ORDER BY idabono DESC LIMIT 1";
        ps = cn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
        nota=rs.getString("nota");
        cantidad=rs.getString("cantidad");
        fecha=rs.getString("fecha");
        recibe=rs.getString("recibe");
        numero=rs.getString("idabono");
        System.out.println(numero);
        }        
    } catch (SQLException ex) {
        System.out.println(ex);;
    }

            PrinterMatrix printer = new PrinterMatrix();

            Extenso e = new Extenso();

            e.setNumber(20.30);
              printer.setOutSize(filas, 32);
    
            //Imprimir = 1ra linea de la columa de 1 a 32
            printer.printTextWrap(linea, 1, 0, 32, "================================");
            linea++;
            printer.printTextWrap(linea, 1, 0, 32, "       Carniceria KARSAD ");
            linea++;
            printer.printTextWrap(linea, 1, 0, 32, "================================");
            linea++;
            printer.printTextWrap(linea, 1, 0, 32, " Calle  ");
            linea++;
            printer.printTextWrap(linea, 1, 0, 32, " Tel. ");
            linea++;
            printer.printTextWrap(linea, 1, 0, 10, "Hora,Fecha");
            printer.printTextWrap(linea, 1, 11, 32, fecha);
            linea++;
            printer.printTextWrap(linea, 1, 0, 32, "Numero de recibo: " + numero);
            linea++;
            printer.printTextWrap(linea, 1, 0, 32, "Recibe: " + recibe);
            linea++;
            printer.printTextWrap(linea, 1, 0, 32, "--------------------------------");
            linea++;
            printer.printTextWrap(linea, 1, 0, 32, "Recibi la cantidad de "+cantidad);
            linea++;
            printer.printTextWrap(linea, 1, 0, 32, " ");
            linea++;
            printer.printTextWrap(linea, 1, 0, 32, "Como pago de la nota "+nota);
            linea++;
        //final de ticket
        printer.printTextWrap(linea, 1, 0, 32, "--------------------------------");
        linea++;
        
        printer.printTextWrap(linea, 1, 0, 32, "================================");
        linea++;
        printer.printTextWrap(linea, 1, 0, 32, " ");
        linea++;
        printer.printTextWrap(linea, 1, 0, 32, " ");
        linea++;
        printer.printTextWrap(linea, 1, 0, 32, " ");
        linea++;
        printer.printTextWrap(linea, 1, 0, 32, "================================");
        linea++;
        printer.printTextWrap(linea, 1, 0, 32, " Firma de recibido ");
        linea++;
        printer.printTextWrap(linea, 1, 0, 32, " ");
        linea++;
        printer.printTextWrap(linea, 1, 0, 32, " ");
        linea++;
        
///CREAR CARPETA tmp EN UNIDAD C
printer.toFile("impresion.txt");

FileInputStream inputStream = null;
try {
inputStream = new FileInputStream("impresion.txt");
} catch (FileNotFoundException ex) {
ex.printStackTrace();
    System.out.println(ex);

}
if (inputStream == null) {
return;
}

DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
Doc document = new SimpleDoc(inputStream, docFormat, null);

PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();

PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

if (defaultPrintService != null) {
DocPrintJob printJob = defaultPrintService.createPrintJob();
try {
printJob.print(document, attributeSet);

} catch (Exception ex) {
ex.printStackTrace();
}
} else {
System.err.println("No existen impresoras instaladas");
}

    try {
        inputStream.close();
    } catch (IOException ex) {
        Logger.getLogger(modelo.class.getName()).log(Level.SEVERE, null, ex);
    }
    
}

}



