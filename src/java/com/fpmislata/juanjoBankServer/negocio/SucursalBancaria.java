/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.juanjoBankServer.negocio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jj
 */
public class SucursalBancaria {

    private int idSucursalBancaria;
    private String codigoSucursalBancaria;
    private String nombreSucursalBancaria;

    public SucursalBancaria(int idSucursalBancaria, String codigoSucursalBancaria, String nombreSucursalBancaria) {
        this.idSucursalBancaria = idSucursalBancaria;
        this.codigoSucursalBancaria = codigoSucursalBancaria;
        this.nombreSucursalBancaria = nombreSucursalBancaria;

    }

    public SucursalBancaria() {
        //this.cuentasBancarias = new ArrayList<>();
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

    /**
     * @return the nombreSucursalBancaria
     */
    public String getNombreSucursalBancaria() {
        return nombreSucursalBancaria;
    }

    /**
     * @param nombreSucursalBancaria the nombreSucursalBancaria to set
     */
    public void setNombreSucursalBancaria(String nombreSucursalBancaria) {
        this.nombreSucursalBancaria = nombreSucursalBancaria;
    }
    /**
     * @return the entidadBancaria
     */
}