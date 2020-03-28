package edu.eci.cvds.samples.services;


public class ExcepcionServiciosAlquiler extends Exception {

    /**
     * Creates a new instance of <code>ExcepcionServiciosAlquiler</code> without
     * detail message.
     */
    public ExcepcionServiciosAlquiler() {
    }

    /**
     * Constructs an instance of <code>ExcepcionServiciosAlquiler</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ExcepcionServiciosAlquiler(String msg) {
        super(msg);
    }

    public ExcepcionServiciosAlquiler(String msg, Exception e) {
        super(msg);
    }
}