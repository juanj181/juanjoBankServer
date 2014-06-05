/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.juanjoBankServer.negocio;

import java.math.BigDecimal;

/**
 *
 * @author Jj
 */
public class CuentaBancaria {
    
    private int idCuentaBancaria;
    private String nombre;
    private String codigoCuentaBancaria;
    private BigDecimal saldo;
    
    public CuentaBancaria (int idCuentaBancaria, String nombre, String codigoCuentaBancaria, BigDecimal saldo){
        this.idCuentaBancaria = idCuentaBancaria;
        this.nombre = nombre;
        this.codigoCuentaBancaria = codigoCuentaBancaria;
        this.saldo = saldo;
    }
    
    public CuentaBancaria(){
        
    }

    /**
     * @return the idCuentaBancaria
     */
    public int getIdCuentaBancaria() {
        return idCuentaBancaria;
    }

    /**
     * @param idCuentaBancaria the idCuentaBancaria to set
     */
    public void setIdCuentaBancaria(int idCuentaBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
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
     * @return the codigoCuentaBancaria
     */
    public String getCodigoCuentaBancaria() {
        return codigoCuentaBancaria;
    }

    /**
     * @param codigoCuentaBancaria the codigoCuentaBancaria to set
     */
    public void setCodigoCuentaBancaria(String codigoCuentaBancaria) {
        this.codigoCuentaBancaria = codigoCuentaBancaria;
    }
    
    public BigDecimal getSaldo(){
        return saldo;
    }
    
    public void setSaldo(BigDecimal saldo){
        this.saldo = saldo;
    }
}
