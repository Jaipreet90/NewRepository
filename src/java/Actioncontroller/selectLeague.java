/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actioncontroller;

import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.LeagueService;
import model.PlayerService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author trilok.sharma
 */
public class selectLeague extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int leagueYear=-1;
        
        
        
        String LeagueTitle = request.getParameter("title1");
        String LeagueSeason = request.getParameter("leagueSeason");
        String LeagueYear = request.getParameter("year");
         List errorMsgs=new LinkedList();
         
        try {
            leagueYear = Integer.parseInt(LeagueYear);
        } catch (Exception e) {
            errorMsgs.add("Please enter a positive integer value for the year");
            //return mapping.findForward("error");
        }

        if (LeagueSeason.equals(""))
        {
         errorMsgs.add("Choose valid Season");
        }
                
        if(LeagueYear.equals("") || (leagueYear < 2000) || (leagueYear > 2010) )
        {
            errorMsgs.add("Please enter a valid Year range between 2001 to 2009");
        }
         
        if(LeagueTitle.equals("")) 
         {
             errorMsgs.add("Please enter the title");
            //return mapping.findForward("error");
        } 
        
        
         if(!errorMsgs.isEmpty())
         {
          
           request.setAttribute("errorMsgs",errorMsgs );
           return mapping.findForward("error");
           
         }
         
        else {
            model.League league = new model.League(leagueYear, LeagueSeason, LeagueTitle);
            
            HttpSession session =request.getSession();
           
            session.setAttribute("league",league);
            
            new LeagueService().createleague(league);
            return mapping.findForward("sucess");
        }
     
        

    }
}
