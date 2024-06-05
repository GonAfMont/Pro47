package P47;

public class Empresas {
    private String CodEmpresa;
    private String NomEmpresa;
    private String NomEmpleado;
    private String CargoEmpleado;
    private String TipoCarta;
    private String Email;
    

    public Empresas(String codigoEmpresa,String nomEmpresa, String nomEmpleado, String cargoEmpleado, String tipoCarta, String email) {
        this.CodEmpresa = codigoEmpresa;
        this.NomEmpresa = nomEmpresa;
        this.NomEmpleado = nomEmpleado;
        this.CargoEmpleado = cargoEmpleado;
        this.TipoCarta = tipoCarta;
        this.Email = email;
    }


	public String getCodEmpresa() {
		return CodEmpresa;
	}


	public void setCodEmpresa(String codEmpresa) {
		CodEmpresa = codEmpresa;
	}


	public String getNomEmpresa() {
		return NomEmpresa;
	}


	public void setNomEmpresa(String nomEmpresa) {
		NomEmpresa = nomEmpresa;
	}


	public String getNomEmpleado() {
		return NomEmpleado;
	}


	public void setNomEmpleado(String nomEmpleado) {
		NomEmpleado = nomEmpleado;
	}


	public String getCargoEmpleado() {
		return CargoEmpleado;
	}


	public void setCargoEmpleado(String cargoEmpleado) {
		CargoEmpleado = cargoEmpleado;
	}


	public String getTipoCarta() {
		return TipoCarta;
	}


	public void setTipoCarta(String tipoCarta) {
		TipoCarta = tipoCarta;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}

}
