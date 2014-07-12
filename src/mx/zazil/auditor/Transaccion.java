/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.zazil.auditor;

import java.io.Serializable;
import java.util.Date;
import mx.zazil.security.UsuarioBalam;

/**
 *
 * @author Hector Rodriguez
 */
public class Transaccion implements Serializable{
    
    private UsuarioBalam usuario;
    private Date time;
    private Long transaccion;
    private String modulo;

    /**
     * @return the usuario
     */
    public UsuarioBalam getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(UsuarioBalam usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the time
     */
    public Date getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * @return the transaccion
     */
    public Long getTransaccion() {
        return transaccion;
    }

    /**
     * @param transaccion the transaccion to set
     */
    public void setTransaccion(Long transaccion) {
        this.transaccion = transaccion;
    }

    /**
     * @return the modulo
     */
    public String getModulo() {
        return modulo;
    }

    /**
     * @param modulo the modulo to set
     */
    public void setModulo(String modulo) {
        this.modulo = modulo;
    }
}
