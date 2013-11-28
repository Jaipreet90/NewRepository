/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Actioncontroller;


import java.util.jar.Attributes.Name;
import javax.servlet.ServletContext;
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
          
       HttpSession session=request.getSession();
       Player player=(Player)session.getAttribute("player");
       League league=(League)session.getAttribute("league");
       String division=request.getParameter("Division");
        
        
        new PlayerService().registration (player,league,division);
       
       if(division.equals(""))
        {
        return mapping.findForward("error");
        }
       
       
       else{
           
       
        
        
        
        return mapping.findForward("sucess");}
        
    }
}
