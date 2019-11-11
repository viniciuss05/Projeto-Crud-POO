package univs.edu.usuario;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import univs.edu.util.HibernateUtil;

public class UsuarioDAO {

    private Session sessao;
    private Transaction transacao;

    public void salvar(Usuario usuario) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        if(usuario.getIdUsuario() == 0){
            sessao.save(usuario);
            JOptionPane.showMessageDialog(null, "USUARIO CADASTRADO");
        }else{
            editar(usuario);
            JOptionPane.showMessageDialog(null, "USUARIO EDITADO");
        }
        
        transacao.commit();
        sessao.close();
    }
    
    public void excluir(Usuario usuario) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.delete(usuario);
        transacao.commit();
        sessao.close();
    }
    
    public void editar(Usuario usuario) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.update(usuario);
        transacao.commit();
        sessao.close();
    }
    
    public Usuario pesquisar(int id) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        Usuario usuario = (Usuario) sessao.createCriteria(Usuario.class).add(Restrictions.eq("idUsuario", id)).uniqueResult();
        sessao.close();
        return usuario;
    }
    
    public Usuario autenticarUsuario(String login, String senha) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        Usuario usuario = (Usuario) sessao.createCriteria(Usuario.class).add(Restrictions.eq("login", login))
                .add(Restrictions.eq("senha", senha)).uniqueResult();
        sessao.close();
        
        return usuario != null ? usuario : null; // SE O USUARIO FOR DIFERENTE DE NULO, RETORNE O USUARIO 
    }
    
        public List<Usuario> listarUsuarios() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        List<Usuario> usuarios = sessao.createCriteria(Usuario.class).list();
        sessao.close();
        return usuarios;
    }
        
   

}
