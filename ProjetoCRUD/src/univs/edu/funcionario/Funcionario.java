/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package univs.edu.funcionario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import univs.edu.usuario.Usuario;

/**
 *
 * @author LABORATORIO 01
 */
@Entity
public class Funcionario {
   
    @Id
    @GeneratedValue  
    
    private int idFuncionario;
    
     @Column (length = 100, nullable = false)
    private String nomeFuncionario;
    
    @Column (length = 50, nullable = false)
    private String cargo;
    
    @Column (length = 20, nullable = false)
    private String cpf;
    
    @Column (length = 20, nullable = false)
    private double salario;
    
    
    
   
    @OneToOne
    private Usuario usuario;
    
    
    public int getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * @param idFuncionario the idFuncionario to set
     */
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    /**
     * @return the nomeFuncioonario
     */
   

    /**
     * @param nomeFuncioonario the nomeFuncioonario to set
     */
    

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the salario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    Object getNomeFuncionario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Object getCpf() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
