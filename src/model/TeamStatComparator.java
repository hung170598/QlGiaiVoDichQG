/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Comparator;

/**
 *
 * @author hung1
 */
public class TeamStatComparator implements Comparator<TeamStat>{

    @Override
    public int compare(TeamStat o1, TeamStat o2) {
        if(o1.getPoint() != o2.getPoint()) 
            return Integer.compare(o2.getPoint(), o1.getPoint());
        if(o1.getNumGoals()!= o2.getNumGoals()) 
            return Integer.compare(o2.getNumGoals(), o1.getNumGoals());
        if(o1.getNumConceded()!= o2.getNumConceded()) 
            return Integer.compare(o1.getNumConceded(), o2.getNumConceded());
        return Integer.compare(o1.getTotalMatches(), o2.getTotalMatches());
        
    }

    
    
}
