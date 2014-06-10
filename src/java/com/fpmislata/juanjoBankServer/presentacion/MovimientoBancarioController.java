/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.juanjoBankServer.presentacion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpmislata.juanjoBankServer.datos.BussinessException;
import com.fpmislata.juanjoBankServer.datos.dao.MovimientoBancarioDAO;
import com.fpmislata.juanjoBankServer.datos.hibernate.dao.MovimientoBancarioDAOImplHibernate;
import com.fpmislata.juanjoBankServer.negocio.MovimientoBancario;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author profesor
 */
@Controller
public class MovimientoBancarioController {

    //@Autowired
    //MovimientoBancarioDAO movimientoBancarioDAO;
    @RequestMapping(value = {"/MovimientoBancario/{idMovimientoBancario}"}, method = RequestMethod.GET)
    public void get(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("idMovimientoBancario") int idMovimientoBancario) {
        try {
       
            MovimientoBancarioDAO movimientoBancarioDAO = new MovimientoBancarioDAOImplHibernate();
            MovimientoBancario movimientoBancario = movimientoBancarioDAO.get(idMovimientoBancario);

            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(movimientoBancario);

            httpServletResponse.getWriter().println(json);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);

        } catch (Exception ex) {
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (Exception ex1) {
                Logger.getLogger(MovimientoBancarioController.class.getName()).log(Level.SEVERE, null, ex1);
            }
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = {"/MovimientoBancario/{idMovimientoBancario}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("idMovimientoBancario") int idMovimientoBancario) {
        try {
         
            MovimientoBancarioDAO movimientoBancarioDAO = new MovimientoBancarioDAOImplHibernate();
            MovimientoBancario movimientoBancario = movimientoBancarioDAO.get(idMovimientoBancario);

            if (movimientoBancario != null) {

                movimientoBancarioDAO.delete(idMovimientoBancario);
                httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }


        } catch (Exception ex) {
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (Exception ex1) {
                Logger.getLogger(MovimientoBancarioController.class.getName()).log(Level.SEVERE, null, ex1);
            }
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = {"/MovimientoBancario"}, method = RequestMethod.POST,consumes="application/json")
    public void save(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) {
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            MovimientoBancario movimientoBancario = objectMapper.readValue(jsonEntrada, MovimientoBancario.class);

            MovimientoBancarioDAO movimientoBancarioDAO = new MovimientoBancarioDAOImplHibernate();
            movimientoBancarioDAO.saveOrUpdate(movimientoBancario);


            String jsonSalida = objectMapper.writeValueAsString(movimientoBancario);
            httpServletResponse.getWriter().println(jsonSalida);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");


        } catch (Exception ex) {
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (Exception ex1) {
                Logger.getLogger(MovimientoBancarioController.class.getName()).log(Level.SEVERE, null, ex1);
            }
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = {"/MovimientoBancario/{idMovimientoBancario}"}, method = RequestMethod.PUT,consumes="application/json")
    public void update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada, @PathVariable("idMovimientoBancario") int idMovimientoBancario) {
        try {

            MovimientoBancarioDAO movimientoBancarioDAO = new MovimientoBancarioDAOImplHibernate();
            MovimientoBancario movimientoBancarioLeido = movimientoBancarioDAO.get(idMovimientoBancario);

            ObjectMapper objectMapper = new ObjectMapper();
            MovimientoBancario movimientoBancarioUpdate = (MovimientoBancario) objectMapper.readValue(jsonEntrada, MovimientoBancario.class);

            movimientoBancarioLeido.setTipoMovimientoBancario(movimientoBancarioUpdate.getTipoMovimientoBancario());
            movimientoBancarioLeido.setImporte(movimientoBancarioUpdate.getImporte());
            movimientoBancarioLeido.setFecha(movimientoBancarioUpdate.getFecha());
            movimientoBancarioLeido.setSaldoTotal(movimientoBancarioUpdate.getSaldoTotal());
            movimientoBancarioLeido.setConcepto(movimientoBancarioUpdate.getConcepto());
            




            movimientoBancarioDAO.saveOrUpdate(movimientoBancarioLeido);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(httpServletResponse.SC_OK);

            String jsonSalida = objectMapper.writeValueAsString(movimientoBancarioLeido);
            httpServletResponse.getWriter().println(jsonSalida);
        } catch (Exception ex) {
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                Logger.getLogger(MovimientoBancarioController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    @RequestMapping(value = {"/MovimientoBancario"}, method = RequestMethod.GET)
    public void findAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws BussinessException, IOException {
        try {
            MovimientoBancarioDAO movimientoBancarioDAO = new MovimientoBancarioDAOImplHibernate();
            List<MovimientoBancario> movimientosBancarios = movimientoBancarioDAO.findAll();
 

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonSalida = objectMapper.writeValueAsString(movimientosBancarios);

            httpServletResponse.setStatus(httpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset = UTF-8");

            httpServletResponse.getWriter().println(jsonSalida);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MovimientoBancarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
