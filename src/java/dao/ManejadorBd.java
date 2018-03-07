/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Cliente;
import beans.Factura;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



/**
 *
 * @author Alumno
 */
public class ManejadorBd {
    private final String bajaCp = "B";
    private final int bajaCli = 0;
    

    private EntityManager em;
    private EntityManagerFactory emf;
    
    
    
    public ManejadorBd() {
        
        emf = 
              Persistence.createEntityManagerFactory("ProyectoDIPeloPU");
        em = emf.createEntityManager();
        
    }
    
//Valida-Usuario Ini    
    public int altaUsuario(Usuarios u){
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();           
         } catch (EntityExistsException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }        
        return 0;
                
    }
    
    
    public boolean validar(String user, String password)
            throws SQLException {
           
       try {
       Usuarios u;
       Query q = null;
       q = em.createNamedQuery("Usuarios.findByUsuario"); 
       u=(Usuarios) q.getSingleResult();
        if (u.getPaswword().equals(password)){
            
//            if(u.getEstado().equals("A"))
//            return true;
            
        return false;
        }        
    } catch (Exception ex) {
        return false;
          
    }
       return false;
                    
}  
//Valida-Usuario Fin
    
//Cliente-Ini Alta - Buscar -Actualizar - Baja     

    public int grabarCliente(Cliente c) {
       try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();           
        } catch (EntityExistsException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
        
        return 0;
    }

   public List<Cliente> buscarCliente(String dni) {
        List<Cliente> listadoClientes;
        try {
            Query q;
            if (dni.equals("")) {
                q = em.createNamedQuery("Cliente.findAll");
            } else {
                q = em.createNamedQuery("Cliente.findByLike");
                q.setParameter("dni","'"+ dni+"%'");
            }
            listadoClientes = q.getResultList();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return listadoClientes;
    }
   
    public int actualizarCliente(Cliente c) {
        
        try {
            em.getTransaction().begin();
            Cliente clienteOld = em.find(Cliente.class, c.getDni());
            clienteOld.setCodCliente(c.getCodCliente());
            clienteOld.setNombre(c.getNombre());
            clienteOld.setApellido1(c.getApellido1());
            clienteOld.setApellido2(c.getApellido2());
            clienteOld.setCodigoPostal(c.getCodigoPostal());
            clienteOld.setMunicipio(c.getMunicipio());
            clienteOld.setTelefono(c.getTelefono());
            clienteOld.setEmail(c.getEmail());
            clienteOld.setEstado(c.getEstado());
            em.getTransaction().commit();
            return 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }
    
        public int bajaCliente(String dni) {
        try {
            em.getTransaction().begin();
            Cliente c = em.find(Cliente.class, dni);
            c.setEstado(bajaCli);
//            em.remove(c);
            em.getTransaction().commit();
            return 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return -1;
        }

    }

//Cliente-Fin Alta - Buscar -Actualizar - Baja  
        
//Impuesto-Ini Alta - Actualizar - Borrar        
        
       public int altaImpuesto(Impuesto i){
        try {
            em.getTransaction().begin();
            em.persist(i);
            em.getTransaction().commit();           
        } catch (EntityExistsException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
        return 0;  
           
       } 
  
       public int actualizarImpuesto(Impuesto i){
          try {
            em.getTransaction().begin();
            Impuesto impuestoOld = em.find(Impuesto.class, i.getCodIva());
            impuestoOld.setCodIva(i.getCodIva());
            impuestoOld.setValorIva(i.getValorIva());
            impuestoOld.setDescripcion(i.getDescripcion());                        
            em.getTransaction().commit();
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
        return 0;
           
       }
       
        public int borrarImpuesto(int codIva) {
        try {
            em.getTransaction().begin();
            Impuesto i = em.find(Impuesto.class,codIva);
            em.remove(i);
            em.getTransaction().commit();
            return 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return -1;
        }

    }

//Impuesto-Fin Alta - Actualizar - Borrar          

//Conceptos-Ini Alta - Actualizar - Baja        
        public int altaConceptos(Conceptos cp){
        try {
            em.getTransaction().begin();
            em.persist(cp);
            em.getTransaction().commit();           
        } catch (EntityExistsException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
        return 0;   
            
        }
       
        public int actualizarConceptos(Conceptos cp){
          try {
            em.getTransaction().begin();
            Conceptos conceptoOld = em.find(Conceptos.class,cp.getCodConcepto());
            conceptoOld.setCodConcepto(cp.getCodConcepto());
            conceptoOld.setDescripcion(cp.getDescripcion());
            conceptoOld.setImporte(cp.getImporte());
            conceptoOld.setDescuento(cp.getDescuento());
            conceptoOld.setCodIva(cp.getCodIva());
            conceptoOld.setEstado(cp.getEstado());            
            em.getTransaction().commit();
            return 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return -1;
        } 
           
       }
 
        public int bajaConceptos(int codCp) {
        try {
            em.getTransaction().begin();
            Conceptos cp = em.find(Conceptos.class,codCp);
            cp.setEstado(bajaCp);
//            em.remove(cp);
            em.getTransaction().commit();
            return 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return -1;
        }

    }

//Conceptos-Fin Alta - Actualizar - Baja

//Presupuestos-Ini Alta -Buscar(codCli,codPresupuesto,Fechas)  
        
        public int altaPresupuestos(Presupuesto pr){
               try {
            em.getTransaction().begin();            
            em.persist(pr);
            em.getTransaction().commit();           
               } catch (EntityExistsException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }       
        return 0;           
        
    }
             
   public List<Presupuesto> buscarPresupuesto(int codCli) {
        List<Presupuesto> listadoPresupuesto;
        try {
            Query q;
            
                q = em.createNamedQuery("Presupuesto.findByCodCliente");
                q.setParameter("codCliente",codCli);
            
            listadoPresupuesto = q.getResultList();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return listadoPresupuesto;
    }   
   
      public List<Presupuesto> buscarPresupuestoConcept(int codPresupuesto ) {
        List<Presupuesto> listadoPresupuesto;
        try {
            Query q;
            
                q = em.createNamedQuery("Presupuesto.findByCodPresupuesto");
                q.setParameter("codPresupuesto",codPresupuesto);
                
            listadoPresupuesto = q.getResultList();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return listadoPresupuesto;
    }  
   
     public List<Presupuesto> buscarPresupuestoFechas(Date fechaIni,Date fechaFin) {
        List<Presupuesto> listadoPresupuesto;
        try {
            Query q;
            
                q = em.createNamedQuery("Presupuesto.findByFechas");
                q .setParameter("fechaIni",fechaIni);
                q .setParameter("fechaIni",fechaFin);
                
            listadoPresupuesto = q.getResultList();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return listadoPresupuesto;
    }  
//Presupuestos-Fin Alta -Buscar(codCli,codPresupuesto,Fechas)

//Factura-Ini  Alta - Buscar(codCli,codFactura,Fechas)   
    public int altaFactura(Factura f){
        try {
            em.getTransaction().begin();            
            em.persist(f);
            em.getTransaction().commit();           
        } catch (EntityExistsException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }       
        return 0; 
        
    } 
     
    public List<Factura> buscarFactura(String codFac) {
        List<Factura> listadoFacturas;
        try {
            Query q;
            
                q = em.createNamedQuery("Factura.findByCodFactura");
                q.setParameter("codFactura",codFac);
            
            listadoFacturas = q.getResultList();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return listadoFacturas;
    }   
    
    public List<Factura> buscarFacturaCli(int codCli) {
        List<Factura> listadoFacturas;
        try {
            Query q;
            
                q = em.createNamedQuery("Factura.findByCodCliente");
                q.setParameter("codCliente",codCli);
            
            listadoFacturas = q.getResultList();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return listadoFacturas;
    }   
       
//final     
}
