/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviles.tags;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author dbavi
 */
public class CopyrightTag extends TagSupport{
    
    @Override
    public int doStartTag() throws JspException {
        Calendar currentDate = new GregorianCalendar();
        int year = currentDate.get(Calendar.YEAR);
        
        try{
            JspWriter out = pageContext.getOut();
            out.print("Copyright &copy; " + year + " ");
        }
        catch(Exception ioe){
            System.out.println(ioe.getMessage());
        }
        
        return SKIP_BODY;
    }
    
}
