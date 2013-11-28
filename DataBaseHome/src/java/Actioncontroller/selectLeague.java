/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actioncontroller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.LeagueService;
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
        int leagueYear;
        
        String LeagueTitle = request.getParameter("title1");
        String LeagueSeason = request.getParameter("leagueSeason");
        String LeagueYear = request.getParameter("year");
        try {
            leagueYear = Integer.parseInt(LeagueYear);
        } catch (Exception e) {
            return mapping.findForward("error");
        }

        if (LeagueSeason.equals("") || LeagueYear.equals("") || LeagueTitle.equals("")) {
            return mapping.findForward("error");
        } 
        else {
            model.League league = new model.League(leagueYear, LeagueSeason, LeagueTitle);
           
           HttpSession session=request.getSession();
           session.setAttribute("league", league);
           
            
            new LeagueService().createleague(league);
            return mapping.findForward("sucess");
        }

    }
}
