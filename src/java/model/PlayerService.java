/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.DivisionDao;
import DAO.PlayerDao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 *
 */
public class PlayerService {

    private String name = null;
    private String address = null;
    private String city = null;
    private String province = null;
    private String postalcode = null;
    
    public Player registration(Player player,League l,String division) throws NamingException
    {
        DivisionDao dao = new DivisionDao();
        dao.insert(player,l,division);
        return player;
    
    }

    public Player getplayer(Player player) {
        

        PlayerDao Dao = new PlayerDao();

      

        try {
            Dao.insert(player);
            
        } catch (NamingException ex) {
            Logger.getLogger(PlayerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return player;

      

    }
}
