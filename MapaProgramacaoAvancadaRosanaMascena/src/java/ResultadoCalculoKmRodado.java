/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class ResultadoCalculoKmRodado extends HttpServlet {

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
        
        String modeloCarro;
        Double valorGasolina;
        Double kmLitro;
        Double valorRevisao;
        Double valorPneus;
        
        Double calculoGasolinaKm;
        Double calculoRevisao;
        Double calculoPneus;
        Double calculoTotal;
        Double calculoAcrescimo;
        
        modeloCarro = request.getParameter("modelo-carro");
        valorGasolina = Double.valueOf(request.getParameter("valor-gasolina"));
        kmLitro = Double.valueOf(request.getParameter("km-litro"));
        valorRevisao = Double.valueOf(request.getParameter("media-revisao"));
        valorPneus = Double.valueOf(request.getParameter("valor-pneus"));
        
        calculoGasolinaKm = valorGasolina / kmLitro;
        calculoRevisao = valorRevisao / 10000;
        calculoPneus = valorPneus / 50000;
        calculoTotal = calculoGasolinaKm + calculoRevisao + calculoPneus;
        calculoAcrescimo = calculoTotal * 1.15;
        
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultado Cálculo Km Rodado</title>");
            out.println("<link rel=\"stylesheet\" href=\"style.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='content-resultado'><p class='p-resultado'>Cálculo Km Rodado para o Modelo <span class='span-resultado'>" + modeloCarro + "</span></p>");
            out.println("<p class='p-resultado'>Valor da Gasolina - <span class='span-resultado'>" + valorGasolina + "</span></p>");
            out.println("<p class='p-resultado'>Média do Veículo - <span class='span-resultado'>" + kmLitro + "</span></p>");
            out.println("<p class='p-resultado'>Revisão 10 mil - <span class='span-resultado'>" + valorRevisao + "</span></p>");
            out.println("<p class='p-resultado'>Pneus 50 mil - <span class='span-resultado'>" + valorPneus + "</span></p>");
            out.println("<p class='p-resultado'>Valor do Km Rodado - <span class='span-resultado'>" + calculoTotal + "</span></p>");
            out.println("<p class='p-resultado'>Com acréscimo de 15% - <span class='span-resultado'>" + calculoAcrescimo + "</span></p></div>");
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
