/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.juanjoBankServer.negocio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jj
 */
public class CuentaBancaria {

    private int idCuentaBancaria;
    private String numeroCuenta;
    private String dc;
    private String cif;
    private BigDecimal saldo;

    public CuentaBancaria(int idCuentaBancaria, String numeroCuenta, String dc, String cif, BigDecimal saldo) {
        this.idCuentaBancaria = idCuentaBancaria;
        this.numeroCuenta = numeroCuenta;
        this.dc = dc;
        this.cif = cif;
        this.saldo = saldo;
    }

    public CuentaBancaria() {
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
     * @return the sucursalBancaria
     */
    /**
     * @return the numeroCuenta
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * @param numeroCuenta the numeroCuenta to set
     */
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    /**
     * @return the dc
     */
    public String getDc() {
        return dc;
    }

    /**
     * @param dc the dc to set
     */
    public void setDc(String dc) {
        this.dc = dc;
    }

    /**
     * @return the cif
     */
    public String getCif() {
        return cif;
    }

    /**
     * @param cif the cif to set
     */
    public void setCif(String cif) {
        this.cif = cif;
    }

    /**
     * @return the saldo
     */
    public BigDecimal getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
    /**
     * @return the listaMovimiento
     */
}
