/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.zazil.auditor;

import mx.zazil.excepcion.OperacionInvalidaException;
import mx.zazil.security.UsuarioBalam;
import mx.zazil.service.Pingeable;

/**
 *
 * @author Hector Rodriguez
 */
public interface Audita extends Pingeable{
    /**
     * Registra el alta de una clase.
     * @param usr el usuario que hace la modificacion.
     * @param registro Objeto a modificar
     * @throws OperacionInvalidaException Si la clase no es auditable.
     */
    public void alta(MensajeAudita msj) throws OperacionInvalidaException;
    
    public void baja(MensajeAudita msj) throws OperacionInvalidaException;
    
    public void cambio(MensajeAudita msj) throws OperacionInvalidaException;
    
    public void lista(UsuarioBalam usr, Class clase) throws OperacionInvalidaException;
    
    public void log(UsuarioBalam usr, String msj) throws OperacionInvalidaException;
    
}
