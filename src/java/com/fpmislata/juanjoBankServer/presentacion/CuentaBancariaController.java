/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.juanjoBankServer.presentacion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpmislata.juanjoBankServer.datos.BussinessException;
import com.fpmislata.juanjoBankServer.datos.dao.CuentaBancariaDAO;
import com.fpmislata.juanjoBankServer.datos.hibernate.dao.CuentaBancariaDAOImplHibernate;
import com.fpmislata.juanjoBankServer.negocio.CuentaBancaria;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Jj
 */
public class CuentaBancariaController {
    
    @RequestMapping(value= {"/CuentaBancaria/{idCuentaBancaria}"}, method = RequestMethod.GET)
    public void get(HttpServletRequest httpServletREquest, HttpServletResponse httpServletResponse, @PathVariable("idCuentaBancaria") int idCuentaBancaria) throws BussinessException, JsonProcessingException, IOException{
        try{
            CuentaBancariaDAO cuentaBancariaDAO = new CuentaBancariaDAOImplHibernate();
            CuentaBancaria cuentaBancaria = cuentaBancariaDAO.get(idCuentaBancaria);
            
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(cuentaBancaria);
            
            httpServletResponse.getWriter().println(json);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            
        }catch (Exception ex){
            try{
                ex.printStackTrace(httpServletResponse.getWriter());
            }catch (Exception ex1){
                
            }
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        
    }
    
        @RequestMapping(value = {"/EntidadBancaria"}, method = RequestMethod.POST)
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
                Logger.getLogger(EntidadBancariaController.class.getName()).log(Level.SEVERE, null, ex1);
            }
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
    
    
    
}
