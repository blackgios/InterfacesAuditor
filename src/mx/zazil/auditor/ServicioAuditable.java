/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.zazil.auditor;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.persistence.EntityManager;
import javax.security.auth.login.LoginException;
import mx.zazil.security.UsuarioBalam;
import mx.zazil.service.Pingeable;

/**
 *
 * @author Hector Rodriguez
 */
public interface ServicioAuditable extends Pingeable{
    
    public EntityManager getEntityManager();

    public Queue getAuditaQueue();

    public Long getNextTransaction();

    public ConnectionFactory getQueueFactory();

    public UsuarioBalam getUsuario();

    public UsuarioBalam login(String usuario, String contrasena) throws LoginException;

    public String getModulo();
}
