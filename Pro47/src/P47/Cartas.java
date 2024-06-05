package P47;
 
import java.io.*;
import java.util.*;

public class  Cartas {
	private static final String RutaMC = "Pro47/src/ModeloCartas";
    private static final String RutaNulidad = "Pro47/src/Nulidades";

        public void Borrar(){
            File cartas = new File(RutaNulidad);
            File[] nulidad = cartas.listFiles();
            for(int i = 0; i < nulidad.length; i++){
                nulidad[i].delete();
            }
        }

        public ArrayList<String> Carpeta(Empresas empresa) {
            ArrayList<String> nombreNulidad = new ArrayList<String>();
            File nulidades = new File(RutaNulidad);
            File[] nulidad = nulidades.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.getName().endsWith(empresa.getCodEmpresa() + ".txt");
                }
            });
            if (nulidad != null) { 
                for (int i = 0; i < nulidad.length; i++) {
                    nombreNulidad.add(nulidad[i].getName().toString());
                }
            }
			return nombreNulidad;
        }


        public String CartaS(Empresas nombre){
            StringBuilder carta = new StringBuilder();
            try(FileReader reader = new FileReader(RutaMC + nombre.getTipoCarta() + ".txt");
            BufferedReader LeerArchivo = new BufferedReader(reader)){
                String linea;
                while((linea = LeerArchivo.readLine())!= null){
                    carta.append(linea+"\n");
                }
            } catch (IOException e) {
                System.out.println("No se encontro el archivo y el nombre de la carta fue " + nombre.getTipoCarta());
                
            }
            String c =carta.toString();
            return c;  
        }


        public ArrayList<Proveedores> crear_proveedores(String NombreNulidad){
            ArrayList<Proveedores> listaProveedores = new ArrayList<Proveedores>();
            try(FileReader reader = new FileReader(RutaMC + NombreNulidad);
            BufferedReader LeerArchivo = new BufferedReader(reader)){
                String linea;
                while((linea = LeerArchivo.readLine())!= null){
                    Boolean encontrado = false;
                    String[] nulidadtxt = linea.split("\t");
                    String codFactura = nulidadtxt[0];
                    String nombreProveedor = nulidadtxt[1];
                    String cuantia = nulidadtxt[2];
                    String codProveedor = nulidadtxt[4];
                    String nulidad = nulidadtxt[5];
                    String telefono = nulidadtxt[6];
                    String email = nulidadtxt[7];
                    String nombrecontacto = nulidadtxt[8];
                    for (Proveedores proveedor: listaProveedores){
                        if (proveedor.getIdProveedor().equals(codProveedor)){
                            encontrado = true;
                            proveedor.pagoCompleto((cuantia), codFactura);
                        }
                    }
                    if (encontrado == false){
                        listaProveedores.add(new Proveedores(nombreProveedor, codProveedor, telefono, email, nombrecontacto, cuantia, codFactura, nulidad));
                    }   
                } 
            } catch (IOException e) {
                System.out.println("No se encontro el archivo");
            }
            return listaProveedores;
        }

        public void crear_cartas(ArrayList<Proveedores> listaProveedores, Empresas empresa, String carta){
            for (Proveedores proveedor: listaProveedores){
                String CPro = carta;
                CPro = CPro.replace("[Nombre_cliente]", proveedor.getContacto());
                CPro = CPro.replace("[Numero_nulidad]", proveedor.getNulidad());
                CPro = CPro.replace("[nombre_empresa]", proveedor.getNomProveedor());
                CPro = CPro.replace("[total_servicios]", proveedor.getTotalPago());
                CPro = CPro.replace("[Lista_pago_servicios]", proveedor.getlistaPagos());
                CPro = CPro.replace("[correo_empresa_nulidad]", empresa.getEmail());
                CPro = CPro.replace("[Su_nombre]", empresa.getNomEmpleado());
                CPro = CPro.replace("[Su_cargo]", empresa.getCargoEmpleado());
                CPro = CPro.replace("[Su_empresa]", empresa.getNomEmpresa());
                try(FileWriter fw = new FileWriter("src/Nulidades/Nul" 
                + proveedor.getNulidad() + "_"+ proveedor.getNomProveedor() + empresa.getCodEmpresa() + ".txt");
                BufferedWriter bw = new BufferedWriter(fw)){
                    bw.write(CPro);
                    if (proveedor.getEmail().equals("0")){
                        System.out.println("Se ha enviado la carta de la nulidad" + proveedor.getNulidad() + " a la empresa " 
                        + proveedor.getNomProveedor() + "mediante el número fax " + proveedor.getTelefono() + " por parte de la empresa " 
                        + empresa.getNomEmpresa());
                    } else {
                        System.out.println("Se ha enviado la carta de la nulidad" + proveedor.getNulidad() + " a la empresa " 
                        + proveedor.getNomProveedor() + "mediante el email " + proveedor.getEmail() + " por parte de la empresa " 
                        + empresa.getNomEmpresa());
                    }
                } catch (IOException e){
                    System.out.println("No se pudo crear el archivo");
                }
            }   
        }
    }