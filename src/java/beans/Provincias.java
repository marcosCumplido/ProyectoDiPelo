/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


public class Provincias {

    private int codProvincia;
    private String provincia;
    
    public Provincias() {
    }

    public Provincias(int codProvincia, String provincia) {
        this.codProvincia = codProvincia;
        this.provincia = provincia;
    }

    public int getCodProvincia() {
        return codProvincia;
    }

    public void setCodProvincia(int codProvincia) {
        this.codProvincia = codProvincia;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
    
    
}
