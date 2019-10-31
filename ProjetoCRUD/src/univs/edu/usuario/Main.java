/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package univs.edu.usuario;

/**
 *
 * @author victo
 */
public class Main {

    public static void main(String[] args) {

        Usuario usuario = new Usuario();

        UsuarioDAO dao = new UsuarioDAO();
        
        usuario.setLogin("ui");
        usuario.setSenha("ui");
        
        dao.salvar(usuario);
        
//        usuario.setLogin("admin");
//        usuario.setSenha("admin");
//        dao.editar(usuario);
        
//        usuario = dao.pesquisar(1);
//        System.out.println(usuario.getIdUsuario());
//        System.out.println(usuario.getLogin());
//        System.out.println(usuario.getSenha());
    }

}
