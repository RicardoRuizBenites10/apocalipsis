/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import dao.dto.hibernate.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SISTEMAS
 */
@WebFilter(filterName = "FRolCliente", urlPatterns = {"/view/intranet/inicio.jsp","/view/rrhh/*"})
public class FNavegabilidad implements Filter{
    
    private FilterConfig filterConfig;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;
        HttpSession session = req.getSession(true);
        
        String requestUrl = req.getRequestURL().toString();
        Usuario usuario = (Usuario)session.getAttribute("ssUsuario");
        
        if(usuario==null){
            res.sendRedirect("../intranet/login.jsp");
        }else{
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        filterConfig = null;
    }
    
}
