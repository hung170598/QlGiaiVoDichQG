/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

public class UserDAO extends DAO{

    public UserDAO() {
    }
    public boolean checkLogin(User user){
        boolean check = false;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT name , position FROM "
                    + "tbluser WHERE username = ? and password = ? ");
            ps.setString(1, user.getUsename());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                user.setName(rs.getString("name"));
                user.setPosition(rs.getString("position"));
                check =true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check;
    }
    
}
