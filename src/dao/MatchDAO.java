/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Match;
import model.Team;
/**
 *
 * @author hung1
 */
public class MatchDAO extends DAO{

    public MatchDAO() {
    }
    
    public Match[] getMatches(int team_id){
        
        int numOfMatch = 0;
        ArrayList<Match> listMatch = new ArrayList<Match>();
    
        TeamDAO teamDAO = new TeamDAO();
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT tblmatch.score, tblmatch.numberofspectator, \n" 
                    + "tblschedule.team1_id, tblschedule.team2_id, tblstadium.name \n" +
                    "FROM tblmatch, tblschedule, tblstadium\n" +
                    "WHERE tblmatch.schedule_id = tblschedule.id and\n" +
                    "tblschedule.stadium_id = tblstadium.id " +
                    "and (tblschedule.team1_id = " + team_id + " or tblschedule.team2_id = " +
                    team_id +");");
            while(rs.next()){
                numOfMatch++;
                String score = rs.getString(1);
                int numOfSpactator = rs.getInt(2);
                Team homeTeam = teamDAO.getTeamById(rs.getInt(3));
                Team visitorTeam = teamDAO.getTeamById(rs.getInt(4));
                System.out.println(homeTeam.getId() + " " + homeTeam.getId());
                String stadium = rs.getString(5);
                Match match = new Match(numOfMatch, homeTeam, visitorTeam, score, stadium, numOfSpactator);
                listMatch.add(match);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        Match[] matches = new Match[listMatch.size()];
        listMatch.toArray(matches);
        return matches;
    }

}
