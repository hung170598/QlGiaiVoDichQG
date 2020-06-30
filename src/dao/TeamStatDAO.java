/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import static dao.DAO.con;
import java.util.Arrays;
import java.sql.ResultSet;
import java.sql.Statement;
import model.Match;
import model.TeamStat;
import model.Team;
import model.TeamStatComparator;
/**
 *
 * @author hung1
 */
public class TeamStatDAO extends DAO{

    public TeamStatDAO() {
    }
    
    public TeamStat[] getListTeamStat(){
        TeamDAO teamDAO = new TeamDAO();
        Team[] listTeam = teamDAO.getListTeam();
        TeamStat[] listTeamStat = new TeamStat[listTeam.length];
        for(int i=0; i<listTeamStat.length; i++){
            listTeamStat[i] = getTeamStatByTeam(listTeam[i]);
        }
        Arrays.sort(listTeamStat, new TeamStatComparator());
        
        return listTeamStat;
    }
    
    public TeamStat getTeamStatByTeam(Team team){
        int totalMatches = 0;
        int won = 0;
        int loss = 0;
        int draw = 0;
        int point = 0;
        int numGoals = 0;
        int numConceded = 0;
        
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT tblmatch.score, tblmatch.numberofspectator, \n" 
                    + "tblschedule.team1_id, tblschedule.team2_id, tblstadium.name \n" +
                    "FROM tblmatch, tblschedule, tblstadium\n" +
                    "WHERE tblmatch.schedule_id = tblschedule.id and\n" +
                    "tblschedule.stadium_id = tblstadium.id and" + 
                    "(tblschedule.team1_id = " + team.getId() + 
                    " or tblschedule.team2_id = " + team.getId() + ");");
            while(rs.next()){
                totalMatches++;
                String score = rs.getString(1);
                String[] tmp = score.split("-");
                int team1Score = Integer.valueOf(tmp[0]);
                int team2Score = Integer.valueOf(tmp[1]);
                if(rs.getInt(3) == team.getId()){
                    won += (team1Score > team2Score?1:0);
                    loss += (team1Score < team2Score?1:0);
                    draw += (team1Score == team2Score?1:0);
                    point =won*3 + draw;
                    numGoals += team1Score;
                    numConceded += team2Score;
                } else{
                    won += (team1Score < team2Score?1:0);
                    loss += (team1Score > team2Score?1:0);
                    draw += (team1Score == team2Score?1:0);
                    point =won*3 + draw;
                    numGoals += team2Score;
                    numConceded += team1Score;
                }        
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        TeamStat teamStat = new TeamStat(team, totalMatches, won, loss, draw, point, numGoals, numConceded);
        return teamStat;
    }
}
