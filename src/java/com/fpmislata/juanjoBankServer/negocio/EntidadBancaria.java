/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.juanjoBankServer.negocio;

/**
 *
 * @author profesor
 */
public class EntidadBancaria {
    
    private int idEntidadBancaria;
    private String nombre;
    private String codigoEntidadBancaria;
    private TipoEntidadBancaria tipoEntidadBancaria;
    
    
   public EntidadBancaria(int idEntidadBancaria, String nombre, String codigoEntidadBancaria, TipoEntidadBancaria tipoEntidadBancaria){
   this.idEntidadBancaria = idEntidadBancaria;
   this.nombre = nombre;
   this.codigoEntidadBancaria = codigoEntidadBancaria;
   this.tipoEntidadBancaria = tipoEntidadBancaria;
    }
   
   public EntidadBancaria(){
   
   }

    /**
     * @return the idEntidadBancaria
     */
    public int getIdEntidadBancaria() {
        return idEntidadBancaria;
    }

    /**
     * @param idEntidadBancaria the idEntidadBancaria to set
     */
    public void setIdEntidadBancaria(int idEntidadBancaria) {
        this.idEntidadBancaria = idEntidadBancaria;
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
     * @return the codigoEntidadBancaria
     */
    public String getCodigoEntidadBancaria() {
        return codigoEntidadBancaria;
    }

    /**
     * @param codigoEntidadBancaria the codigoEntidadBancaria to set
     */
    public void setCodigoEntidadBancaria(String codigoEntidadBancaria) {
        this.codigoEntidadBancaria = codigoEntidadBancaria;
    }

    /**
     * @return the tipoEntidadBancaria
     */
    public TipoEntidadBancaria getTipoEntidadBancaria() {
        return tipoEntidadBancaria;
    }

    /**
     * @param tipoEntidadBancaria the tipoEntidadBancaria to set
     */
    public void setTipoEntidadBancaria(TipoEntidadBancaria tipoEntidadBancaria) {
        this.tipoEntidadBancaria = tipoEntidadBancaria;
    }
    
    
}
