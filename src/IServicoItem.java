import java.util.List;

public interface IServicoItem {
	
	public void adicionaItem(Item item);
	
	public void removeItem(Item item);
	
	public List<Item> buscaItem();
	
	public List<Item> buscaMarca(String marca);
	
	public List<Item> buscaModelo(String modelo);
	
	public List<Item> buscaCor(String cor);
	
	public List<Item> buscaCidade(String cor);
	
	public void atualizaItem(Item item);

}
