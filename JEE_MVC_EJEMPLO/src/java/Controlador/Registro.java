/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
 

import Modelo.Conexion;
import Modelo.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Cristopher
 */
public class Registro extends HttpServlet {

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

        /* TODO output your page here. You may use following sample code. */
        String rut = request.getParameter("txtRut");
        String nombre = request.getParameter("txtNombre");
        String edad = request.getParameter("txtEdad");

        if (rut.equals("") || nombre.equals("") || edad.equals("")) {
            String error = "Campos vacios...";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);

        } else {
                   int e =0;
            try {
                e = Integer.parseInt(edad);
             
            } catch (NumberFormatException ex) {
                String error = "Ingrese solo numeros";
                request.getSession().setAttribute("error", error);
                request.getRequestDispatcher("error.jsp").forward(request,response);
                
            }
            
            Persona p1 = new Persona (rut, nombre , e); 
            Conexion cn = new Conexion ();
            if(cn.insertar(p1)>0){
                request.getRequestDispatcher("exito.jsp").forward(request, response);
            }else{
                
                String error = "No se pudo insertar";
                request.getSession().setAttribute("error",error);
                request.getRequestDispatcher("error.jsp").forward(request,response);
            }
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

