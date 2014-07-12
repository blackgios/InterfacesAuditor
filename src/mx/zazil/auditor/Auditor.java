/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.zazil.auditor;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

/**
 *
 * @author Hector Rodriguez
 */
public class Auditor {
    public static void baja(Serializable obj, Transaccion transaccion, String mensaje, ServicioAuditable sa) throws JMSException{
        MensajeAudita ma = generaMensajeAudita(mensaje,obj,transaccion);
        ma.setTipo(MensajeAudita.Tipo.baja);
    }
    
    private static MensajeAudita generaMensajeAudita(String mensaje, Serializable obj, Transaccion transaccion){
        MensajeAudita ma = new MensajeAudita();
        ma.setMensaje(mensaje);
        ma.setRegistro(obj);
        ma.setTransaccion(transaccion);
        return ma;
    }
    
    private static void sendJMSMessageToAuditaQueue(MensajeAudita msjData, ConnectionFactory auditaQueueFactory, Destination auditaQueue) throws JMSException{
        Connection conexion = null;
        Session sesion = null;
        try{
            conexion = auditaQueueFactory.createConnection();
            sesion = conexion.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer mesaMessageProducer = sesion.createProducer(auditaQueue);
            //mesaMessageProducer.send(creat);
        }finally{
            if(sesion != null){
                try{
                    sesion.close();
                }catch(JMSException ex){
                    Logger.getLogger("Auditor").log(Level.WARNING, "Cannot close session", ex);
                }
            }
            if(conexion != null){
                conexion.close();
            }
        }
        
    }
    
    private static void createJMSMessageForAuditaQueue(Session sesion, MensajeAudita msjData) throws JMSException{
        
        ObjectMessage tm = sesion.createObjectMessage();
        try{
            tm.setObject(msjData);
        }catch(Exception ex){
            
        }
        
    }
    
    public static final Object clone(Serializable in)throws IOException{
        try{
            ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
            ObjectOutputStream outStream = new ObjectOutputStream(byteOutStream);
            outStream.writeObject(in);
            ByteArrayInputStream byteInStream = new ByteArrayInputStream(byteOutStream.toByteArray());
            ObjectInputStream inStream = new ObjectInputStream(byteInStream);
            return inStream.readObject();
        } catch (OptionalDataException e) {
            throw new RuntimeException("Optional data found. " + e.getMessage()); //$NON-NLS-1$
        } catch (StreamCorruptedException e) {
            throw new RuntimeException("Serialized object got corrupted. " + e.getMessage()); //$NON-NLS-1$
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("A class could not be found during deserialization. " + e.getMessage()); //$NON-NLS-1$
        } catch (NotSerializableException ex) {
            ex.printStackTrace();
            throw new IllegalArgumentException("Object is not serializable: " + ex.getMessage()); //$NON-NLS-1$
        } catch (IOException e) {
            throw new RuntimeException("IO operation failed during serialization. " + e.getMessage()); //$NON-NLS-1$
        }
    }
}
