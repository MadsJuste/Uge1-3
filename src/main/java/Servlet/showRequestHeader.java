package Servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juste
 */
@WebServlet(urlPatterns = {"/showRequestHeader"})
public class showRequestHeader extends HttpServlet {



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

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String tempa = request.getHeader("Accept");
        String tempae = request.getHeader("Accept-Encoding");
        String templ = request.getHeader("Accept-Language");
        String tempca = request.getHeader("Cache-Control");
        String tempco = request.getHeader("Connection");
        String temph = request.getHeader("Host");
        String tempup = request.getHeader("Upgrade-Insecure-Request");
        String tempu = request.getHeader("User-Agent");

        /***** Print The Response *****/
        PrintWriter out = response.getWriter();
        String docType = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n";
        out.println(docType +

               "<h1 align = \"center\">" + "Accept: " +  tempa + "</h1>\n" +
               "<h1 align = \"center\">" + "Accept-Encoding: " +  tempae + "</h1>\n" +
               "<h1 align = \"center\">"+  "Accept-Language: " +  templ + "</h1>\n" +
               "<h1 align = \"center\">"+ "Cache: " +  tempca + "</h1>\n" +
               "<h1 align = \"center\">"+ "Connection: " +  tempco + "</h1>\n" +
               "<h1 align = \"center\">"+ "Host: " +  temph + "</h1>\n" +
               "<h1 align = \"center\">"+ "Upgrade: " +  tempup + "</h1>\n" +
               "<h1 align = \"center\">"+ "User: " +  tempu + "</h1>\n" 
               );
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
