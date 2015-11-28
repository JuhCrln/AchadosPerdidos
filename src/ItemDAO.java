import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ItemDAO {
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
	private EntityManager manager = factory.createEntityManager();
	
	public void adciona (Item item){
		manager.getTransaction().begin();
		manager.persist(item);
		manager.getTransaction().commit();
	}
	
	public void atualiza(Item item){
		manager.getTransaction().begin();
		manager.merge(item);
		manager.getTransaction().commit();
	}
	
	public void remove (int id){
		Item encontrado = manager.find(Item.class, id);
		manager.getTransaction().begin();
		manager.remove(encontrado);
		manager.getTransaction().commit();
	}
	
	public List<Item> buscaOutrasCaracteristicas(String outascaracteristicas){
		Query query = manager.createQuery("select t from itens as t where t.outrascaracteristicas = :paramOutrasCaracteristicas");
		query.setParameter("paramOutrasCaracteristicas", outascaracteristicas);
		@SuppressWarnings("unchecked")
		List<Item> lista = query.getResultList();
		return lista;
	}
	
	public Item buscaID(int id){
		Item encontrado = manager.find(Item.class, id);
		return encontrado;
	}
}
