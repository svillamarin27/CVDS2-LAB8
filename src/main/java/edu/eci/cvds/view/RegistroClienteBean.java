package edu.eci.cvds.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import java.sql.Date;

@ManagedBean(name = "AlquilerItemsBean")
@SessionScoped

public class RegistroClienteBean extends BasePageBean {

    @Inject
    private ServiciosAlquiler serviciosAlquiler;

    public void registrarCliente(String nombre, long documento, String telefono, String direccion, String email){
        try {
            serviciosAlquiler.registrarCliente(new Cliente(nombre, documento, telefono,direccion,email));
        } catch (ExcepcionServiciosAlquiler excepcionServiciosAlquiler) {
            excepcionServiciosAlquiler.printStackTrace();
        }
    }

    public List<Cliente> consultarClientes(){
        List<Cliente> clientes = null;
        try {
            clientes = serviciosAlquiler.consultarClientes();
        } catch (ExcepcionServiciosAlquiler excepcionServiciosAlquiler) {
            excepcionServiciosAlquiler.printStackTrace();
        }
        return clientes;
    }

    public Cliente consultarCliente(long documento){
        Cliente cliente = null;
        try {
            cliente = serviciosAlquiler.consultarCliente(documento);
        } catch (ExcepcionServiciosAlquiler excepcionServiciosAlquiler) {
            excepcionServiciosAlquiler.printStackTrace();
        }
        return cliente;
    }

    public List<ItemRentado> consultarItemsCliente(long id){
        List<ItemRentado> itemsDelCliente = null;
        try {
            itemsDelCliente = serviciosAlquiler.consultarItemsCliente(id);
        } catch (ExcepcionServiciosAlquiler excepcionServiciosAlquiler) {
            excepcionServiciosAlquiler.printStackTrace();
        }
        return itemsDelCliente;
    }


    public void registrarAlquilerItem(Date date, long documento, Item item, int numdias){

        try {
            serviciosAlquiler.registrarAlquilerCliente(date, documento, item, numdias);
        } catch (ExcepcionServiciosAlquiler excepcionServiciosAlquiler) {
            excepcionServiciosAlquiler.printStackTrace();
        }

    }
}
