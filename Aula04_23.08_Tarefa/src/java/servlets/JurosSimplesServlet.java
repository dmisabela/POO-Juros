/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author isabe
 */
@WebServlet(name = "JurosSimplesServlet", urlPatterns = {"/juros-simples.html"})
public class JurosSimplesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>JurosSimplesServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div style='text-align:center'>");
            out.println("<h2>Resultado</h2>");
            
            try {
                   double vp = Float.parseFloat(request.getParameter("vp"));
                   out.println("<h4><b>Valor presente: </b> " + vp + "</h4>");
                   double j = Float.parseFloat(request.getParameter("j"));
                   out.println("<h4><b>Juros em %:</b> " + j + "</h4>");
                   double n = Float.parseFloat(request.getParameter("n"));
                   out.println("<h4><b>Tempo em meses:</b> " + n + "</h4>");
                   out.println("<br/>");
                   
                   double result = vp*(1+(j/100)*n);                    
                                  
                   out.println("<h4><b>Valor futuro com juros simples:</b> " + result + "</h4>");                               
                    
            }            
                catch (Exception ex) { 
                      out.println("<p style = 'color:red'>"+ex.getMessage()+"</p>");
                }
            
            
            out.println("</br>");
            out.println("</br>");
            out.println("<h3><a href ='index.html'>Voltar</a></h3>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
