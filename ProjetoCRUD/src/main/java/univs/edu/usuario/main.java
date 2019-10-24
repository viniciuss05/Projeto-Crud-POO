/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package univs.edu.usuario;

/**
 *
 * @author Vinicius
 */
public class main {
    
    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        
        UsuarioDAO dao = new UsuarioDAO();
        
        usuario = dao.pesquisarPorId(1);
        usuario.setLogin("admin2");
        usuario.setSenha("TripaChico");
        
        dao.editar(usuario);
        
        
    }
}
