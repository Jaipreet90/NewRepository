/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Actioncontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.League;
import model.Player;
import model.PlayerService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author jaipreet
 */
public class Division extends org.apache.struts.action.Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
          
       String division = request.getParameter("Division");
        HttpSession session =request.getSession();
        
        Player player=(Player)session.getAttribute("player");
        League league=(League)session.getAttribute("league");
        
       
       if(division.equals(""))
        {
        String errorMsg="Please enter the division";
        request.setAttribute("errorMsg", errorMsg);
        return mapping.findForward("error");
        }
       
       
       else{
           
       
        
        new PlayerService().registration (player,league,division);
        return mapping.findForward("sucess");}
        
    }
}
