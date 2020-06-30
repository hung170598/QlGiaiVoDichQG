/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hung1
 */
public class TeamStat {
    private Team team;
    private int totalMatches;
    private int won;
    private int loss;
    private int draw;
    private int point;
    private int numGoals;
    private int numConceded;

    public TeamStat(Team team, int totalMatches, int won, int loss, int draw, int point, int numGoals, int numConceded) {
        this.team = team;
        this.totalMatches = totalMatches;
        this.won = won;
        this.loss = loss;
        this.draw = draw;
        this.point = point;
        this.numGoals = numGoals;
        this.numConceded = numConceded;
    }

    

    public Team getTeam() {
        return team;
    }

    public int getTotalMatches() {
        return totalMatches;
    }

    public int getWon() {
        return won;
    }

    public int getLoss() {
        return loss;
    }

    public int getDraw() {
        return draw;
    }

    public int getPoint() {
        return point;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setTotalMatches(int totalMatches) {
        this.totalMatches = totalMatches;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getNumGoals() {
        return numGoals;
    }

    public int getNumConceded() {
        return numConceded;
    }

    public void setNumGoals(int numGoals) {
        this.numGoals = numGoals;
    }

    public void setNumConceded(int numConceded) {
        this.numConceded = numConceded;
    }
    
    
    
}
