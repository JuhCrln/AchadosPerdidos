import java.util.List;

public interface IDAOItem {
	
	public void adciona(Item item);

	public void atualiza(Item item);

	public void remove(int id);

	public List<Item> buscaOutrasCaracteristicas(String outascaracteristicas);

	public Item buscaID(int id);
	
	public List<Item> buscaItens();
}
