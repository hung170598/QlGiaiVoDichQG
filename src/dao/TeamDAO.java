/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.con;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Team;
/**
 *
 * @author hung1
 */
public class TeamDAO extends DAO{

    public TeamDAO() {
    }
    
    public Team getTeamById(int id){
        Team team = null;
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select tblteam.id, tblteam.name, tblteam.numberofplayer,  \n" 
                    + "tblcoach.name, tblstadium.name, tblsponsor.name\n" 
                    + "from tblteam, tblcoach, tblsponsor, tblstadium\n" 
                    + "where tblteam.id = " + id +" and tblcoach.id = tblteam.coach_id and \n" 
                    + "tblsponsor.id = tblteam.sponsor_id and tblstadium.id = tblteam.stadium_id");
            if(rs.next()){
                int teamId = rs.getInt(1);
                String teamName = rs.getString(2);
                int numOfPlayer = rs.getInt(3);
                String coach = rs.getString(4);
                String sponsor = rs.getString(5);
                String stadium = rs.getString(6);
                team = new Team(teamId, teamName, numOfPlayer, coach, sponsor, stadium);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return team;
    }
    
    public Team[] getListTeam(){
        ArrayList<Team> listTeam = new ArrayList<Team>();
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select tblteam.id, tblteam.name, tblteam.numberofplayer,  \n" 
                    + "tblcoach.name, tblstadium.name, tblsponsor.name\n" 
                    + "from tblteam, tblcoach, tblsponsor, tblstadium\n" 
                    + "where tblcoach.id = tblteam.coach_id and \n" 
                    + "tblsponsor.id = tblteam.sponsor_id and tblstadium.id = tblteam.stadium_id");
            while(rs.next()){
                int teamId = rs.getInt(1);
                String teamName = rs.getString(2);
                int numOfPlayer = rs.getInt(3);
                String coach = rs.getString(4);
                String sponsor = rs.getString(5);
                String stadium = rs.getString(6);
                Team team = new Team(teamId, teamName, numOfPlayer, coach, sponsor, stadium);
                listTeam.add(team);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        Team[] teams = new Team[listTeam.size()];
        listTeam.toArray(teams);
        return teams;
    }
}
