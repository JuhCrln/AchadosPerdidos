import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ItemDAO implements IDAOItem {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
	private EntityManager manager = factory.createEntityManager();

	public void adciona(Item item) {
		manager.getTransaction().begin();
		manager.persist(item);
		manager.getTransaction().commit();
	}

	public void atualiza(Item item) {
		manager.getTransaction().begin();
		manager.merge(item);
		manager.getTransaction().commit();
	}

	public void remove(int id) {
		Item encontrado = manager.find(Item.class, id);
		manager.getTransaction().begin();
		manager.remove(encontrado);
		manager.getTransaction().commit();
	}

	public List<Item> buscaItens() {
		Query query = manager
				.createQuery("select t from Item as t");
		@SuppressWarnings("unchecked")
		List<Item> lista = query.getResultList();;
		return lista;
	}

	public Item buscaID(int id) {
		Item encontrado = manager.find(Item.class, id);
		return encontrado;
	}
	
	public List<Item> buscaMarca(String marca) {
		Query query = manager
				.createQuery("select t from Item as t where t.marca = :paramMarca");
		query.setParameter("paramMarca", marca);
		@SuppressWarnings("unchecked")
		List<Item> listaMarca = query.getResultList();
		return listaMarca;
	}

	public List<Item> buscaModelo(String modelo) {
		Query query = manager
				.createQuery("select t from Item as t where t.modelo = :paramModelo");
		query.setParameter("paramModelo", modelo);
		@SuppressWarnings("unchecked")
		List<Item> listaModelo = query.getResultList();
		return listaModelo;
	}
	
	public List<Item> buscaCor(String cor) {
		Query query = manager
				.createQuery("select t from Item as t where t.cor = :paramCor");
		query.setParameter("paramCor", cor);
		@SuppressWarnings("unchecked")
		List<Item> listaCor = query.getResultList();
		return listaCor;
		
	}

	public List<Item> buscaItemCidade(String cidade) {
		Query query = manager
				.createQuery("select t from Item as t where t.cidade= :paramCidade");
		query.setParameter("paramCidade", cidade);
		@SuppressWarnings("unchecked")
		List<Item> listaCidade = query.getResultList();
		return listaCidade;
	}
}
