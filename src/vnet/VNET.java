/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vnet;

import Connection.CommonConnection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author thanhtuan
 */
public class VNET {
    Connection connection = null;
    public VNET()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Server Name");
        String serverName = scanner.nextLine();
        System.out.println("Database Name");
        String dbName = scanner.nextLine();
        System.out.println("User Name");
        String userName = scanner.nextLine();
        System.out.println("Password");
        String password = scanner.nextLine();
        connection = CommonConnection.GetConnection(serverName, dbName , userName, password);
    }
    
    public void UpdateRows() {
        if (connection == null)
        {
            System.out.println("Stop");
            return;
        }
        try {
            File f = new File("D:/VNET/SqlFile.txt");
            BufferedReader br;
            try (FileReader fr = new FileReader(f)) {
                br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null) {
                    PreparedStatement ps = connection.prepareStatement(line);
                    ps.executeUpdate();
                }
            }
            br.close();
            connection.close();
        } catch (IOException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void main(String[] args) {
        VNET vnet = new VNET();
        vnet.UpdateRows();
    }
}
