/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.juanjoBankServer.presentacion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpmislata.juanjoBankServer.datos.BussinessException;
import com.fpmislata.juanjoBankServer.datos.dao.SucursalBancariaDAO;
import com.fpmislata.juanjoBankServer.datos.hibernate.dao.SucursalBancariaDAOImplHibernate;
import com.fpmislata.juanjoBankServer.negocio.SucursalBancaria;
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
public class SucursalBancariaController {

    //@Autowired
    //SucursalBancariaDAO sucursalBancariaDAO;
    @RequestMapping(value = {"/SucursalBancaria/{idSucursalBancaria}"}, method = RequestMethod.GET)
    public void get(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("idSucursalBancaria") int idSucursalBancaria) {
        try {
       
           SucursalBancariaDAO sucursalBancariaDAO = new SucursalBancariaDAOImplHibernate();
            SucursalBancaria sucursalBancaria = sucursalBancariaDAO.get(idSucursalBancaria);

            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(sucursalBancaria);

            httpServletResponse.getWriter().println(json);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);

        } catch (Exception ex) {
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (Exception ex1) {
                Logger.getLogger(SucursalBancariaController.class.getName()).log(Level.SEVERE, null, ex1);
            }
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = {"/SucursalBancaria/{idSucursalBancaria}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("idSucursalBancaria") int idSucursalBancaria) {
        try {
         
            SucursalBancariaDAO sucursalBancariaDAO = new SucursalBancariaDAOImplHibernate();
            SucursalBancaria sucursalBancaria = sucursalBancariaDAO.get(idSucursalBancaria);

            if (sucursalBancaria != null) {

                sucursalBancariaDAO.delete(idSucursalBancaria);
                httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }


        } catch (Exception ex) {
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (Exception ex1) {
                Logger.getLogger(SucursalBancariaController.class.getName()).log(Level.SEVERE, null, ex1);
            }
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = {"/SucursalBancaria"}, method = RequestMethod.POST,consumes="application/json")
    public void save(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) {
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            SucursalBancaria sucursalBancaria = objectMapper.readValue(jsonEntrada, SucursalBancaria.class);

            SucursalBancariaDAO sucursalBancariaDAO = new SucursalBancariaDAOImplHibernate();
            sucursalBancariaDAO.saveOrUpdate(sucursalBancaria);


            String jsonSalida = objectMapper.writeValueAsString(sucursalBancaria);
            httpServletResponse.getWriter().println(jsonSalida);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");


        } catch (Exception ex) {
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (Exception ex1) {
                Logger.getLogger(SucursalBancariaController.class.getName()).log(Level.SEVERE, null, ex1);
            }
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = {"/SucursalBancaria/{idSucursalBancaria}"}, method = RequestMethod.PUT,consumes="application/json")
    public void update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada, @PathVariable("idSucursalBancaria") int idSucursalBancaria) {
        try {

            SucursalBancariaDAO sucursalBancariaDAO = new SucursalBancariaDAOImplHibernate();
            SucursalBancaria sucursalBancariaLeida = sucursalBancariaDAO.get(idSucursalBancaria);

            ObjectMapper objectMapper = new ObjectMapper();
            SucursalBancaria sucursalBancariaUpdate = (SucursalBancaria) objectMapper.readValue(jsonEntrada, SucursalBancaria.class);

            sucursalBancariaLeida.setCodigoSucursalBancaria(sucursalBancariaUpdate.getCodigoSucursalBancaria());
            sucursalBancariaLeida.setNombreSucursalBancaria(sucursalBancariaUpdate.getNombreSucursalBancaria());
            

            sucursalBancariaDAO.saveOrUpdate(sucursalBancariaLeida);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(httpServletResponse.SC_OK);

            String jsonSalida = objectMapper.writeValueAsString(sucursalBancariaLeida);
            httpServletResponse.getWriter().println(jsonSalida);
        } catch (Exception ex) {
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                Logger.getLogger(SucursalBancariaController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    @RequestMapping(value = {"/SucursalBancaria"}, method = RequestMethod.GET)
    public void findAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws BussinessException, IOException {
        try {
            SucursalBancariaDAO sucursalBancariaDAO = new SucursalBancariaDAOImplHibernate();
            List<SucursalBancaria> sucursalesBancarias = sucursalBancariaDAO.findAll();


            ObjectMapper objectMapper = new ObjectMapper();
            String jsonSalida = objectMapper.writeValueAsString(sucursalesBancarias);

            httpServletResponse.setStatus(httpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset = UTF-8");

            httpServletResponse.getWriter().println(jsonSalida);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(SucursalBancariaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
