/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package red.social;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Derek
 */
public class Listener extends Thread {
    private Connection conn;
    private org.postgresql.PGConnection pgconn;
    private String id;
    private String grupoReceptor;
    private String grupoEmisor;
    private Notificacion not;  

    Listener(Connection conn) throws SQLException {
            this.conn = conn;
            this.pgconn = (org.postgresql.PGConnection)conn;
            Statement stmt = conn.createStatement();
            stmt.execute("LISTEN q_event");
            stmt.close();
    }

    public void run() {
        while (true) {
            try {
                //Escucha en la base de ddatos
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT 1"); 
                rs.close();
                stmt.close();

                org.postgresql.PGNotification notifications[] = pgconn.getNotifications();
                if (notifications != null) {
                    for (int i=0; i<notifications.length; i++) {
                        //Descomponer que accion es en esta parte
                        String parameter = notifications[i].getParameter().replace("\\","");
                        String action = parameter.split("\\{")[1].split(",")[1].split(":")[1].substring(2,8);
                                          
                        if(action.equals("INSERT")){
                            //comprobar si es para mi
                            
                            id = parameter.split("\\{")[2].replace("}","").split(",")[0].split(":")[1];
                            grupoReceptor = parameter.split("\\{")[2].replace("}","").split(",")[2].split(":")[1].replace("\"", "");
                            grupoEmisor = parameter.split("\\{")[2].replace("}","").split(",")[1].split(":")[1].replace("\"", "");
                            String usuarioEmisor = parameter.split("\\{")[2].replace("}","").split(",")[3].split(":")[1].replace("\"", "");
                            String usuarioReceptor = parameter.split("\\{")[2].replace("}","").split(",")[4].split(":")[1].replace("\"", "");
                            String mensaje = parameter.split("\\{")[2].replace("}","").split(",")[6].split(":")[1].replace("\"", "");
                            String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
                            
                            if (mensaje.length() > 140){
                                mensaje = mensaje.substring(0, 139);
                            }
                            
                            if(grupoReceptor.equals("4")){
                                //si es para mi enviar el update con la respuesta
                                Singleton.getInstancia().setMensaje(usuarioEmisor + " del grupo " + grupoEmisor + " le ha enviado un mensaje al usuario: " + usuarioReceptor);
                                
                                not = new Notificacion();
                                not.setVisible(true);
                             
                                //si es para mi enviar el update con la respuesta de que el usuario existe
                                //AQUI VA A LA BUSQUEDA EN NNUESTROS ARCHIVOS
                                boolean existe = FileManager.SearchUser(usuarioReceptor) != (null);
                                if(existe){
                                    //se guarda mensaje para el usuario receptor
                                FileManager.WriteFile(FileManager.MESSAGE_FILE, FileManager.FixSize(usuarioEmisor  + " (grupo "+ grupoEmisor +")" + FileManager.SEPARADOR + usuarioReceptor + FileManager.SEPARADOR + date + FileManager.SEPARADOR + mensaje + FileManager.SEPARADOR + "1" +FileManager.SEPARADOR+ "1" + FileManager.SEPARADOR, 210));
                                    Singleton.getInstancia().Update(id, existe);
                                }else{
                                    Singleton.getInstancia().Update(id, existe);
                                }                                        
                            }
                        }else{
                            //UPDATE
                            
                            //comprobar si yo fui el que envie la solicitud
                            //Descomponer id, grupo emisor y grupo receptor en esta parte
                            id = parameter.split("\\{")[2].replace("}","").split(",")[0].split(":")[1];
                            grupoReceptor = parameter.split("\\{")[2].replace("}","").split(",")[2].split(":")[1].replace("\"", "");
                            grupoEmisor = parameter.split("\\{")[2].replace("}","").split(",")[1].split(":")[1].replace("\"", "");
                            String usuarioEmisor = parameter.split("\\{")[2].replace("}","").split(",")[3].split(":")[1].replace("\"", "");
                            String usuarioReceptor = parameter.split("\\{")[2].replace("}","").split(",")[4].split(":")[1].replace("\"", "");
                            String mensaje = parameter.split("\\{")[2].replace("}","").split(",")[6].split(":")[1].replace("\"", "");
                            String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
                            
                            if (mensaje.length() > 140){
                                mensaje = mensaje.substring(0, 139);
                            }
                            
                            if(grupoEmisor.equals("4")){
                                 String respuesta = parameter.split("\\{")[2].replace("}","").split(",")[7].split(":")[1];
                                 //Comprobar cual fue la respuesta
                                 if(respuesta.equals("false")){
                                    Singleton.getInstancia().setMensaje("El grupo " + grupoReceptor + " dice que no encontro el usuario: " + usuarioReceptor );
                                    not = new Notificacion();
                                    not.setVisible(true);
                                 }else{
                                    Singleton.getInstancia().setMensaje("El grupo " + grupoReceptor + " dice que ha recibido el mensaje." );
                                    //se guarda mensaje para el usuario receptor
                                    FileManager.WriteFile(FileManager.MESSAGE_FILE, FileManager.FixSize(usuarioEmisor  + FileManager.SEPARADOR + usuarioReceptor + " (grupo "+ grupoEmisor +")" + FileManager.SEPARADOR + date + FileManager.SEPARADOR + mensaje + FileManager.SEPARADOR + "1" +FileManager.SEPARADOR+ "1" + FileManager.SEPARADOR, 210));
                                    not = new Notificacion();
                                    not.setVisible(true);
                                 }
                                 //Eliminar la solicitud
                                 Singleton.getInstancia().Delete(id);
                            }
                        }                                             
                    }
                }
                //Espera para la siguiente notifiacion
                Thread.sleep(500);
            } catch (SQLException | InterruptedException sqle) {
                    sqle.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
