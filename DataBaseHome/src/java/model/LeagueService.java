/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import DAO.LeagueDao;
import DAO.PlayerDao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 */
public class LeagueService {
    
    public League getLeague(League league)
    {
        
        return null;
    }
 
  public League createleague(League league) {
        

        LeagueDao Dao = new LeagueDao();

      

        try {
            Dao.insert(league);
         
        } catch (NamingException ex) {
            Logger.getLogger(LeagueService.class.getName()).log(Level.SEVERE, null, ex);
        }

      return league;

    }
}
