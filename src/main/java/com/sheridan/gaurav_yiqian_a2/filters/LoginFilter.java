/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
@author Gaurav Tayade
*/
package com.sheridan.gaurav_yiqian_a2.filters;

/**
 *
 * @author tayad
 */
import java.io.*;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tayad
 */
public class LoginFilter implements Filter{
    
    private ServletContext context;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
        this.context = filterConfig.getServletContext();
    }
    
    @Override
    public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain)
              throws java.io.IOException, ServletException{
        
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
	
        String uriParts[] = servletRequest.getRequestURI().split("/");
	this.context.log("Requested Resource::"+uriParts[uriParts.length-1]);
		
	HttpSession userSession = servletRequest.getSession(false);
        context.log(uriParts[uriParts.length-1]);
        if((uriParts[uriParts.length-1].equals("addAvenger.jsp") &&
                userSession.getAttribute("user") == null)||
                (uriParts[uriParts.length-1].equals("addAvenger.do") &&
                userSession.getAttribute("user") == null)||
                (uriParts[uriParts.length-2].equals("editAvenger.do") &&
                userSession.getAttribute("user") == null)||
                (uriParts[uriParts.length-2].equals("deleteAvenger.do") &&
                userSession.getAttribute("user") == null)||
                (uriParts[uriParts.length-2].equals("updateAvenger.do") &&
                userSession.getAttribute("user") == null)){
                this.context.log("session checked");
            servletResponse.sendRedirect("index.jsp");
            return;
        }else if((uriParts[uriParts.length-1].equals("displayAvengers.jsp") &&
                userSession.getAttribute("user") == null) || 
                (uriParts[uriParts.length-1].equals("getAvengers.do")&&
                userSession.getAttribute("user") == null)){
            this.context.log("it happened twice");
            servletResponse.sendRedirect("index.jsp");
            return;
        }
        chain.doFilter(request, response);
    }
    
    @Override
    public void destroy(){
    
    }
    
}
