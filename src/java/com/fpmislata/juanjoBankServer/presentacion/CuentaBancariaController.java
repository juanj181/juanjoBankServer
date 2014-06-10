
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.juanjoBankServer.presentacion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpmislata.juanjoBankServer.datos.dao.CuentaBancariaDAO;
import com.fpmislata.juanjoBankServer.datos.hibernate.dao.CuentaBancariaDAOImplHibernate;
import com.fpmislata.juanjoBankServer.negocio.CuentaBancaria;
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
 * @author Jj
 */
@Controller
public class CuentaBancariaController {

    @RequestMapping(value = {"/CuentaBancaria/{idCuentaBancaria}"}, method = RequestMethod.GET)
    public void get(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("idCuentaBancaria") int idCuentaBancaria) {
        try {
            CuentaBancariaDAO cuentaBancariaDAO = new CuentaBancariaDAOImplHibernate();
            CuentaBancaria cuentaBancaria = cuentaBancariaDAO.get(idCuentaBancaria);

            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(cuentaBancaria);

            httpServletResponse.getWriter().println(json);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);

        } catch (Exception ex) {
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (Exception ex1) {
                Logger.getLogger(CuentaBancariaController.class.getName()).log(Level.SEVERE, null, ex1);
            }
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = {"/CuentaBancaria/{idCuentaBancaria}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("idCuentaBancaria") int idCuentaBancaria) {
        try {

            CuentaBancariaDAO CuentaBancariaDAO = new CuentaBancariaDAOImplHibernate();
            CuentaBancaria cuentaBancaria = CuentaBancariaDAO.get(idCuentaBancaria);

            if (cuentaBancaria != null) {

                CuentaBancariaDAO.delete(idCuentaBancaria);
                httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }


        } catch (Exception ex) {
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (Exception ex1) {
                Logger.getLogger(CuentaBancariaController.class.getName()).log(Level.SEVERE, null, ex1);
            }
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = {"/CuentaBancaria"}, method = RequestMethod.POST)
    public void save(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) {
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            CuentaBancaria cuentaBancaria = objectMapper.readValue(jsonEntrada, CuentaBancaria.class);

            CuentaBancariaDAO cuentaBancariaDAO = new CuentaBancariaDAOImplHibernate();
            cuentaBancariaDAO.saveOrUpdate(cuentaBancaria);


            String jsonSalida = objectMapper.writeValueAsString(cuentaBancaria);
            httpServletResponse.getWriter().println(jsonSalida);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");


        } catch (Exception ex) {
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (Exception ex1) {
                Logger.getLogger(CuentaBancariaController.class.getName()).log(Level.SEVERE, null, ex1);
            }
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = {"/CuentaBancaria/{idCuentaBancaria}"}, method = RequestMethod.PUT)
    public void update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada, @PathVariable("idCuentaBancaria") int idCuentaBancaria) {
        try {

            CuentaBancariaDAO cuentaBancariaDAO = new CuentaBancariaDAOImplHibernate();
            CuentaBancaria cuentaBancariaLeida = cuentaBancariaDAO.get(idCuentaBancaria);

            ObjectMapper objectMapper = new ObjectMapper();
            CuentaBancaria cuentaBancariaUpdate = (CuentaBancaria) objectMapper.readValue(jsonEntrada, CuentaBancaria.class);


            cuentaBancariaLeida.setNumeroCuenta(cuentaBancariaUpdate.getNumeroCuenta());
            cuentaBancariaLeida.setDc(cuentaBancariaUpdate.getDc());
            cuentaBancariaLeida.setSaldo(cuentaBancariaUpdate.getSaldo());
            cuentaBancariaLeida.setCif(cuentaBancariaUpdate.getCif());



            cuentaBancariaDAO.saveOrUpdate(cuentaBancariaLeida);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(httpServletResponse.SC_OK);

            String jsonSalida = objectMapper.writeValueAsString(cuentaBancariaLeida);
            httpServletResponse.getWriter().println(jsonSalida);
        } catch (Exception ex) {
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                Logger.getLogger(CuentaBancariaController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    @RequestMapping(value = {"/CuentaBancaria"}, method = RequestMethod.GET)
    public void findAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();


            CuentaBancariaDAO cuentaBancariaDAO = new CuentaBancariaDAOImplHibernate();
            List<CuentaBancaria> cuentasBancarias;
            cuentasBancarias = cuentaBancariaDAO.findAll();

            String jsonSalida = objectMapper.writeValueAsString(cuentaBancariaDAO.findAll());
            httpServletResponse.getWriter().println(jsonSalida);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");






        } catch (Exception ex) {
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                Logger.getLogger(CuentaBancariaController.class.getName()).log(Level.SEVERE, null, ex1);
            }
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        }

    }
}
