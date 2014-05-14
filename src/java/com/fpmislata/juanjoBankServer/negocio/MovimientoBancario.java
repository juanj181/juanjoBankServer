/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.juanjoBankServer.negocio;

/**
 *
 * @author Jj
 */
public class MovimientoBancario {
    
    private int idMovimientoBancario;
    private String nombre;
    private String codigoMovimientoBancario;
    
    public MovimientoBancario (int idMovimientoBancario, String nombre, String codigoMovimientoBancario){
        this.idMovimientoBancario = idMovimientoBancario;
        this.nombre = nombre;
        this.codigoMovimientoBancario = codigoMovimientoBancario;
              
    }
    
    public MovimientoBancario(){
        
    }

    /**
     * @return the idMovimientoBancario
     */
    public int getIdMovimientoBancario() {
        return idMovimientoBancario;
    }

    /**
     * @param idMovimientoBancario the idMovimientoBancario to set
     */
    public void setIdMovimientoBancario(int idMovimientoBancario) {
        this.idMovimientoBancario = idMovimientoBancario;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the codigoMovimientoBancario
     */
    public String getCodigoMovimientoBancario() {
        return codigoMovimientoBancario;
    }

    /**
     * @param codigoMovimientoBancario the codigoMovimientoBancario to set
     */
    public void setCodigoMovimientoBancario(String codigoMovimientoBancario) {
        this.codigoMovimientoBancario = codigoMovimientoBancario;
    }
}
