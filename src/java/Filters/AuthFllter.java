/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filters;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.registry.infomodel.User;

public class AuthFllter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       HttpServletRequest req = (HttpServletRequest)request;
        HttpSession s = req.getSession();
       User user = (User)s.getAttribute("user");
       if (user != null){
           System.out.println("Logged In");
       }else{
           System.out.println("Not Logged In, Please do sign in first");
           response.setContentType("text/html");
           response.getWriter().println("Not Logged In, Please do sign in first");
       }
       
       System.out.print("Before Calling Filter");
       
       chain.doFilter(request, response);
       
       System.out.print("After Calling Filter");
    }

    @Override
    public void destroy() {
//        Filter.super.destroy(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
