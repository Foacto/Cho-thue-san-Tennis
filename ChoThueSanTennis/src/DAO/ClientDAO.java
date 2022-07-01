/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import Model.Client;
import java.util.ArrayList;

/**
 *
 * @author vvt
 */
public class ClientDAO extends DAO{
    public ArrayList<Client> SearchClient(String name){
        ArrayList<Client> result = new ArrayList<>();
        String sql = "SELECT * FROM tblClient WHERE name LIKE ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Client client = new Client();
                client.setId(rs.getInt("IdClient"));
                client.setName(rs.getString("name"));
                client.setAddress(rs.getString("address"));
                client.setMail(rs.getString("mail"));
                client.setTel(rs.getString("tel"));
                client.setNote(rs.getString("note"));
                
                result.add(client);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return result;
    }
}
