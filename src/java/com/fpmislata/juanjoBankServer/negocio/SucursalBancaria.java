/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.juanjoBankServer.negocio;

/**
 *
 * @author Jj
 */
public class SucursalBancaria {

    private int idSucursalBancaria;
    private String nombre;
    private String codigoSucursalBancaria;

    public SucursalBancaria(int idSucursalBancaria, String nombre, String codigoSucursalBancaria) {
        this.idSucursalBancaria = idSucursalBancaria;
        this.nombre = nombre;
        this.codigoSucursalBancaria = codigoSucursalBancaria;
    }

    /**
     * @return the idSucursalBancaria
     */
    public int getIdSucursalBancaria() {
        return idSucursalBancaria;
    }

    /**
     * @param idSucursalBancaria the idSucursalBancaria to set
     */
    public void setIdSucursalBancaria(int idSucursalBancaria) {
        this.idSucursalBancaria = idSucursalBancaria;
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
     * @return the codigoSucursalBancaria
     */
    public String getCodigoSucursalBancaria() {
        return codigoSucursalBancaria;
    }

    /**
     * @param codigoSucursalBancaria the codigoSucursalBancaria to set
     */
    public void setCodigoSucursalBancaria(String codigoSucursalBancaria) {
        this.codigoSucursalBancaria = codigoSucursalBancaria;
    }
}