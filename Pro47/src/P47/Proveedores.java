package P47;

import P47.*;
import java.util.*;

public class Proveedores {  
    private String NomProveedor;
    private String IdProveedor;
    private String Telefono;
    private String Email;
    private String Contacto;
    private String Nulidad;
    private ArrayList<Pagos> Pago = new ArrayList<Pagos>();
    private String ListaPagos;



    public Proveedores(String nomProveedor, String idProveedor, String telefono, String email, String contacto, String nulidad, String pago, String idPago) { 
        this.NomProveedor = nomProveedor;
        this.IdProveedor = idProveedor;
        this.Telefono = telefono;
        this.Nulidad = nulidad;
        this.Email = email;
        this.setContacto(contacto);
        this.pagoCompleto(pago, idPago);
    }



	public String getNomProveedor() {
		return NomProveedor;
	}



	public void setNomProveedor(String nomProveedor) {
		NomProveedor = nomProveedor;
	}



	public String getIdProveedor() {
		return IdProveedor;
	}



	public void setIdProveedor(String idProveedor) {
		IdProveedor = idProveedor;
	}



	public String getTelefono() {
		return Telefono;
	}



	public void setTelefono(String telefono) {
		Telefono = telefono;
	}



	public String getEmail() {
		return Email;
	}



	public void setEmail(String email) {
		Email = email;
	}



	public String getContacto() {
		return Contacto;
	}



	public void setContacto(String contacto) {
		String RegEx = ("Contacto[0-9]{1,},\\s*");
        this.Contacto = contacto.replaceAll(RegEx, "");
	}

	public String getNulidad() {
		return Nulidad;
	}



	public void setNulidad(String nulidad) {
		Nulidad = nulidad;
	}



	public ArrayList<Pagos> getPago() {
		return Pago;
	}



	public void setPago(ArrayList<Pagos> pago) {
		Pago = pago;
	}



	public String getlistaPagos() {
	    String listaPagos = "";
	    for (int i = 0; i < this.Pago.size(); i++) {
	        listaPagos += "Total de factura: " + this.Pago.get(i).getId() + " es:" + this.Pago.get(i).getCantidad() + "\n";
	    }
	    this.ListaPagos = listaPagos;
	    return this.ListaPagos;
	}



	public void setListaPagos(String listaPagos) {
		ListaPagos = listaPagos;
	}
	
	public String getTotalPago(){
	    double n = 0;
	    for (Pagos pago : this.Pago) {
	        n += pago.getCantidad();
	    }
	    String total = String.valueOf(n);
	    return total;
	}
	
	public void pagoCompleto(String Pago, String idP) {
	    String RegEx = ("[0-9]*");
	    String idPago = idP.replaceAll(RegEx, "");
	    double P = Double.parseDouble(Pago.replace(".","").replace(",", "."));
	    Pagos newPago = new Pagos(P, idPago);
	    this.Pago.add(newPago);
	}
	
	
   
}
