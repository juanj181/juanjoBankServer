/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.juanjoBankServer.presentacion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpmislata.juanjoBankServer.datos.dao.EntidadBancariaDAO;
import com.fpmislata.juanjoBankServer.datos.hibernate.dao.EntidadBancariaDAOImplHibernate;
import com.fpmislata.juanjoBankServer.datos.hibernate.util.HibernateUtil;
import com.fpmislata.juanjoBankServer.negocio.EntidadBancaria;
import com.fpmislata.juanjoBankServer.negocio.TipoEntidadBancaria;
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
public class EntidadBancariaController {

    //@Autowired
    //EntidadBancariaDAO entidadBancariaDAO;
    @RequestMapping(value = {"/EntidadBancaria/{idEntidadBancaria}"}, method = RequestMethod.GET, consumes = "application/json")
    public void get(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("idEntidadBancaria") int idEntidadBancaria) {
        try {
            if (idEntidadBancaria == 3) {
                throw new RuntimeException("El numero no puede ser 3");
            }
            EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAOImplHibernate();
            EntidadBancaria entidadBancaria = entidadBancariaDAO.get(idEntidadBancaria);

            //String json="{ idEntidadBancaria:" +entidadBancaria.getIdEntidadBancaria()  + ",nombre:\"" + entidadBancaria.getNombre() + "\"}";
            ObjectMapper objectMapper = new ObjectMapper();

            String json = objectMapper.writeValueAsString(entidadBancaria);

            httpServletResponse.getWriter().println(json);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);

        } catch (Exception ex) {
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (Exception ex1) {
                Logger.getLogger(EntidadBancariaController.class.getName()).log(Level.SEVERE, null, ex1);
            }
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = {"/EntidadBancaria/{idEntidadBancaria}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("idEntidadBancaria") int idEntidadBancaria) {
        try {
            if (idEntidadBancaria == 3) {
                throw new RuntimeException("El numero no puede ser 3");
            }
            EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAOImplHibernate();
            EntidadBancaria entidadBancaria = entidadBancariaDAO.get(idEntidadBancaria);

            if (entidadBancaria != null) {

                entidadBancariaDAO.delete(idEntidadBancaria);
                httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }




            //   httpServletResponse.setContentType("application/json; charset=UTF-8");


        } catch (Exception ex) {
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (Exception ex1) {
                Logger.getLogger(EntidadBancariaController.class.getName()).log(Level.SEVERE, null, ex1);
            }
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = {"/EntidadBancaria"}, method = RequestMethod.POST)
    public void save(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) {
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            EntidadBancaria entidadBancaria = objectMapper.readValue(jsonEntrada, EntidadBancaria.class);

            EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAOImplHibernate();
            entidadBancariaDAO.saveOrUpdate(entidadBancaria);


            String jsonSalida = objectMapper.writeValueAsString(entidadBancaria);
            httpServletResponse.getWriter().println(jsonSalida);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");


        } catch (Exception ex) {
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (Exception ex1) {
                Logger.getLogger(EntidadBancariaController.class.getName()).log(Level.SEVERE, null, ex1);
            }
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = {"/EntidadBancaria/{idEntidadBancaria}"}, method = RequestMethod.PUT)
    public void update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada, @PathVariable("idEntidadBancaria") int idEntidadBancaria) {
        try {

            EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAOImplHibernate();
            EntidadBancaria entidadBancariaLeida = entidadBancariaDAO.get(idEntidadBancaria);

            ObjectMapper objectMapper = new ObjectMapper();
            EntidadBancaria entidadBancariaUpdate = (EntidadBancaria) objectMapper.readValue(jsonEntrada, EntidadBancaria.class);

            entidadBancariaLeida.setCodigoEntidadBancaria(entidadBancariaUpdate.getCodigoEntidadBancaria());
            entidadBancariaLeida.setNombre(entidadBancariaUpdate.getNombre());
            entidadBancariaLeida.setTipoEntidadBancaria(entidadBancariaUpdate.getTipoEntidadBancaria());

            entidadBancariaDAO.saveOrUpdate(entidadBancariaLeida);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(httpServletResponse.SC_OK);

            String jsonSalida = objectMapper.writeValueAsString(entidadBancariaLeida);
            httpServletResponse.getWriter().println(jsonSalida);
        } catch (Exception ex) {
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                Logger.getLogger(EntidadBancariaController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

 /*   @RequestMapping(value = {"/EntidadBancaria"}, method = RequestMethod.GET)
    public void find(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAOImplHibernate();

            List<EntidadBancaria> entidadesBancarias;
            String nombre = httpServletRequest.getParameter("nombre");
            if (nombre != null) {
              //  entidadesBancarias = entidadBancariaDAO.findByNombre(nombre);
            } else {
                entidadesBancarias = entidadBancariaDAO.findAll();
            }

            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(httpServletResponse.SC_OK);
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(entidadesBancarias);
            httpServletResponse.getWriter().println(json);
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
            }
        }
    } */
}
