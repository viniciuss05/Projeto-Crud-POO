package univs.edu.funcionario;

import univs.edu.usuario.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import univs.edu.util.HibernateUtil;

public class FuncionarioDAO {

    private Session sessao;
    private Transaction transacao;

    public void salvar(Funcionario funcionario) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        if(funcionario.getIdFuncionario()== 0){
            sessao.save(funcionario);
            JOptionPane.showMessageDialog(null, "FUNCIONARIO CADASTRADO");
        }else{
            editar(funcionario);
            JOptionPane.showMessageDialog(null, "USUARIO EDITADO");
        }
        
        transacao.commit();
        sessao.close();
    }
    
    public void excluir(Funcionario funcionario) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.delete(funcionario);
        transacao.commit();
        sessao.close();
    }
    
    public void editar(Funcionario funcionario) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.update(funcionario);
        transacao.commit();
        sessao.close();
    }
    
    public Funcionario pesquisar(int id) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        Funcionario funcionario = (Funcionario) sessao.createCriteria(Usuario.class).add(Restrictions.eq("idFuncionario", id)).uniqueResult();
        sessao.close();
        return funcionario;
    }
    
    
    
        public List<Funcionario> listarFuncionarios() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        List<Funcionario> funcionarios = sessao.createCriteria(Funcionario.class).list();
        sessao.close();
        return funcionarios;
    }
        
   

}
