
import java.util.List;

public interface IDAOItem {
	
	public void adciona(Item item);

	public void atualiza(Item item);

	public void remove(int id);

	public List<Item> buscaMarca(String marca);
	
	public List<Item> buscaModelo(String modelo);
	
	public List<Item> buscaCor(String cor);
	
	public List<Item> buscaItemCidade(String cidade);

	public Item buscaID(int id);
	
	public List<Item> buscaItens();
}
