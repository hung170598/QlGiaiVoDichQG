/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.util.Pair;

/**
 *
 * @author hung1
 */
public class Match {
    private int round;
    private Team homeTeam;
    private Team visitorTeam;
    private String score;
    private String stadium;
    private int numOfSpectator;

    public Match(int round, Team homeTeam, Team visitorTeam, String score, String stadium, int numOfSpectator) {
        this.round = round;
        this.homeTeam = homeTeam;
        this.visitorTeam = visitorTeam;
        this.score = score;
        this.stadium = stadium;
        this.numOfSpectator = numOfSpectator;
    }

    public int getRound() {
        return round;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getVisitorTeam() {
        return visitorTeam;
    }

    public String getScore() {
        return score;
    }

    public String getStadium() {
        return stadium;
    }

    public int getNumOfSpectator() {
        return numOfSpectator;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public void setVisitorTeam(Team visitorTeam) {
        this.visitorTeam = visitorTeam;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public void setNumOfSpectator(int numOfSpectator) {
        this.numOfSpectator = numOfSpectator;
    }
    
    
    
    
}
