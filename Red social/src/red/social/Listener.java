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
                            grupoReceptor = parameter.split("\\{")[2].replace("}","").split(",")[2].split(":")[1];
                            grupoEmisor = parameter.split("\\{")[2].replace("}","").split(",")[1].split(":")[1];                           
                            boolean existe = false;
                            
                            if(grupoReceptor.equals("4")){
                                //si es para mi enviar el update con la respuesta
                                Singleton.getInstancia().setMensaje("El grupo " + grupoReceptor + " te ha enviado un mensaje." );
                                not = new Notificacion();
                                not.setVisible(true);
                             
                                //si es para mi enviar el update con la respuesta de que el usuario existe
                                
                                if(existe){
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
                            grupoEmisor = parameter.split("\\{")[2].replace("}","").split(",")[1].split(":")[1];
                            grupoReceptor = parameter.split("\\{")[2].replace("}","").split(",")[2].split(":")[1];
                            
                            if(grupoEmisor.equals("1")){
                                 String respuesta = parameter.split("\\{")[2].replace("}","").split(",")[7].split(":")[1];
                                 //Comprobar cual fue la respuesta
                                 if(respuesta.equals("false")){
                                    Singleton.getInstancia().setMensaje("El grupo " + grupoReceptor + " dice que no encontro el usuario." );
                                    not = new Notificacion();
                                    not.setVisible(true);
                                 }else{
                                    Singleton.getInstancia().setMensaje("El grupo " + grupoReceptor + " dice que ha recibido el mensaje." );
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
