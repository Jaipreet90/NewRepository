/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytags;

import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author jaipreet
 */
public class test extends SimpleTagSupport {

    private String name;
   
   
    private List optionlist;
    
    public void setName(String name) {
        this.name = name;
    }

    public void setOptionlist(List optionlist) {
        this.optionlist = optionlist;
    }

    
 
    
    
    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        PageContext pageContext = (PageContext) getJspContext();
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        String selectedValue = request.getParameter("leagueSeason");
        optionlist=(List)request.getAttribute("arrayList");
        
        try {

            String nameAttr = "";
            if (name != null) {
                nameAttr = "name=\"" + name + "\"";
            }
             String options="";
           Iterator items=optionlist.iterator();
           while(items.hasNext())
           {
               String seasons=(String)items.next();
           
           
           
            //for(int i=0;i<SEASONS.length;i++){
                String option="<option ";
                if(seasons.equals(selectedValue)){
                    option=option+" selected ";
                }
                option=option+" value=\""+seasons+"\">"+seasons+"</option>";
                options = options+option;
            }
            out.print("<select " + nameAttr + ">\n"
                    + options
                    + "</select>");
    }
        catch (java.io.IOException ex) {
            throw new JspException("Error in test tag", ex);
        }
    }

}
