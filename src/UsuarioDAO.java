
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UsuarioDAO implements IDAOUsuario {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
	private EntityManager manager = factory.createEntityManager();

	public void adciona(Usuario usuario) {
		try {
			manager.getTransaction().begin();
			manager.persist(usuario);
			manager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			manager.getTransaction().rollback();
		}
	}

	public void atualiza(Usuario usuario) {
		try {
			manager.getTransaction().begin();
			manager.merge(usuario);
			manager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			manager.getTransaction().rollback();
		}
	}

	public void remove(int id) {
		try {
			Usuario encontrado = manager.find(Usuario.class, id);
			manager.getTransaction().begin();
			manager.remove(encontrado);
			manager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			manager.getTransaction().rollback();
		}
	}

	public List<Usuario> busca() {
		Query query = manager.createQuery("select t from Usuario as t");
		@SuppressWarnings("unchecked")
		List<Usuario> lista = query.getResultList();
		return lista;
	}

	public List<Usuario> buscaUsuario(String usuario) {
		Query query = manager.createQuery("select t from Usuario as t where t.nomeDeUsuario = :paramnomeDeUsuario");
		query.setParameter("paramnomeDeUsuario", usuario);
		@SuppressWarnings("unchecked")
		List<Usuario> lista = query.getResultList();
		return lista;
	}

	public List<Usuario> buscaUsuarioPorID(int id) {
		Query query = manager.createQuery("select t from Usuario as t where t.id = :paramId");
		query.setParameter("paramId", id);
		@SuppressWarnings("unchecked")
		List<Usuario> lista = query.getResultList();
		return lista;
	}

	@Override
	public List<Usuario> buscaUsuarioPorEmailSenha(String email, String senha) {
		Query query = manager
				.createQuery("select t from Usuario as t where t.email = :paramEmail and t.senha = :paramSenha");
		query.setParameter("paramEmail", email);
		query.setParameter("paramSenha", senha);
		@SuppressWarnings("unchecked")
		List<Usuario> lista = query.getResultList();
		return lista;
	}
}
