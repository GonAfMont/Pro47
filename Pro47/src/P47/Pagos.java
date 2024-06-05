package P47;

public class Pagos {
	private double Cantidad;
    private String Id;

    public Pagos (double cantidad, String id){
    	this.Cantidad=cantidad;
    	this.Id=id;
    }

	public double getCantidad() {
		return Cantidad;
	}

	public void setCantidad(double cantidad) {
		Cantidad = cantidad;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}
 }
