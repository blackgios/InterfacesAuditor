/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.zazil.auditor;

import java.io.Serializable;

/**
 *
 * @author Hector Rodriguez
 */
public class MensajeAudita implements Serializable{
    
    private Serializable registro;
    private Transaccion transaccion;
    private String mensaje;
    private Tipo tipo;

    /**
     * @return the registro
     */
    public Serializable getRegistro() {
        return registro;
    }

    /**
     * @param registro the registro to set
     */
    public void setRegistro(Serializable registro) {
        this.registro = registro;
    }

    /**
     * @return the transaccion
     */
    public Transaccion getTransaccion() {
        return transaccion;
    }

    /**
     * @param transaccion the transaccion to set
     */
    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the tipo
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    /**
     * Enumarcion de los tipos de transaccion que se audita.
     */
    public enum Tipo {
        alta, baja, cambio, lista
    };
}
