/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Actioncontroller;

import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import model.PlayerService;

/**
 *
 * @author trilok.sharma
 */
public class Player extends org.apache.struts.action.Action {

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
        String Name = request.getParameter("Name");
        String City = request.getParameter("City");
        String Address = request.getParameter("Address");
        String Province = request.getParameter("Province");
        String Postalcode = request.getParameter("Postalcode");
        List errorMsgs=new LinkedList();
        
        
       if(Name.equals(""))
       {
            errorMsgs.add("Please enter your name");
       }
       if(City.equals(""))
       {
             errorMsgs.add("Please enter your name ");
       }
       if(Address.equals("")) 
       {
              errorMsgs.add("Please enter your address");
       }
       if(Province.equals(""))
       {
               errorMsgs.add("Please enter your Province");
       }
       if(Postalcode.equals(""))
       {
               errorMsgs.add("Please enter your Postal Code");
       }
                 
       if(!errorMsgs.isEmpty())
         {
          
           request.setAttribute("errorMsgs",errorMsgs );
           return mapping.findForward("error");
         }
        else{
           
           model.Player player = new model.Player(Name,Address,City,Province,Postalcode);
           
           HttpSession session =request.getSession();
           
           session.setAttribute("player",player);
           
           new PlayerService().getplayer(player);
           return mapping.findForward("sucess");}
    }
        
        
    
}
