/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Models.entidades.detalle_comida_factura;
import Models.entidades.factura;
import controllers.facturaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sergio
 */
public class CartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     factura fact = new factura();
     facturaController _facController = new facturaController();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
                HttpSession session = request.getSession();
                Map<String, String[]> v =   request.getParameterMap();
               List<detalle_comida_factura> _carrito;
                if(session.getAttribute("_carrito")!= null){
                 _carrito = (List<detalle_comida_factura>) session.getAttribute("_carrito");
                }else{
                  _carrito = new ArrayList<detalle_comida_factura>();
                }
                String action = request.getParameter("action");
                String _usuario = "";
                if(session.getAttribute("idusuario")!= null){
                    _usuario = session.getAttribute("idusuario").toString();
                }

              if ((!"".equals(action))){
                  
                  if (action.equals("AddCarrito")){
                      
                      detalle_comida_factura item = new detalle_comida_factura();
                      item.setComidas_idcomidas(request.getParameter("codcomida"));                     
                      item.setCantidad((Integer.parseInt(request.getParameter("cantidad").toString())));
                    
                      item.setPreciounitario(Integer.parseInt(request.getParameter("precio").toString()));
                      item.setNombreComida(request.getParameter("nombrecomida").toString());
                      item.setPrecio(item.getCantidad()*item.getPreciounitario());
                      _carrito.add(item);
                      request.getSession().setAttribute("_carrito",_carrito);
                     response.sendRedirect("carrito.jsp");
                    
                  }if (action.equals("RemoveCarrito")){
                     // out.println(_facController.MostrarCarrito());
                  }if (action.equals("RegistrarFactura")){
                      if(_usuario!=""){
                            fact.setDetalle(_carrito);
                            fact.setDireccion("Calle 5b sur # 11a-23");
                            fact.setFecha_pedido("2017-04-25");
                            fact.setIdfactura(_facController.ConsultarCodigoFactura());
                            int acum= 0;
                            for (detalle_comida_factura object : _carrito) {
                               acum += object.getPrecio();
                            }
                            fact.setSubtotal(acum);
                            fact.setTotal(acum);
                            fact.setTransporte("NO");
                            fact.setUsuarios_idUsuarios(_usuario);
                            fact.setValor_transporte(0);

                            if(_facController.registraFactura(fact)){
                                session.removeAttribute("_carrito");
                                out.print("si");
                            }else{
                                out.print("no");
                            }
                      }else{
                          out.print("nologeo");
                      }
                  }
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
