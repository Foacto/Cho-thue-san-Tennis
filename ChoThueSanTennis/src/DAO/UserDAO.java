/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author vvt
 */
public class UserDAO extends DAO{

    public UserDAO() {
        super();
    }
    
    public boolean CheckLogin(User user){
        boolean result = false;
        String sql = "SELECT IdUser, name, role from tblUser WHERE username = ? AND password = ?";

        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                user.setId(rs.getInt("IdUser"));
                user.setName(rs.getString("name"));
                user.setRole(rs.getString("role"));
                result = true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
