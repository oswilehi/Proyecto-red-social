/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package red.social;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Derek
 */
public class Notifier extends Thread {
    private Connection conn;

    public Notifier(Connection conn) {
            this.conn = conn;
    }

    public void run() {
        while (true) {
            try {
                    Statement stmt = conn.createStatement();
                    stmt.execute("NOTIFY mymessage");
                    stmt.close();
                    Thread.sleep(2000);
            } catch (SQLException | InterruptedException sqle) {
                    sqle.printStackTrace();
            }
        }
    }
}
