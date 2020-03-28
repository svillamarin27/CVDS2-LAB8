/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao;

public class PersistenceException extends Exception {

    /**
     * Creates a new instance of <code>PersistenceException</code> without
     * detail message.
     */
    public PersistenceException() {
    }

    /**
     * Constructs an instance of <code>PersistenceException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PersistenceException(String msg) {
        super(msg);
    }

    public PersistenceException(String msg, Exception e) {
        super(msg);
    }
}
