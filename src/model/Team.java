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
public class Team {
    private String id;
    private String name;
    private int numOfPlayer;
    private String coach;
    private String sponsor;
    private String stadium;

    public Team(String id, String name, int numOfPlayer, String coach, String sponsor, String stadium) {
        this.id = id;
        this.name = name;
        this.numOfPlayer = numOfPlayer;
        this.coach = coach;
        this.sponsor = sponsor;
        this.stadium = stadium;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumOfPlayer() {
        return numOfPlayer;
    }

    public String getCoach() {
        return coach;
    }

    public String getSponsor() {
        return sponsor;
    }

    public String getStadium() {
        return stadium;
    }
    
    
}
