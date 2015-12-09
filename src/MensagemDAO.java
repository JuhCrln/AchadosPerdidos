import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MensagemDAO implements IDAOMensagem {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
	private EntityManager manager = factory.createEntityManager();

	@Override
	public void adciona(Mensagem mensagem) {
		try {
			manager.getTransaction().begin();
			manager.persist(mensagem);
			manager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			manager.getTransaction().rollback();
		}
	}

	@Override
	public List<Mensagem> buscaMensagens() {
		Query query = manager.createQuery("select t from Mensagem as t");
		@SuppressWarnings("unchecked")
		List<Mensagem> lista = query.getResultList();
		return lista;
	}
}
