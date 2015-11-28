import java.util.List;

public interface IServicoItem {
	
	public void adicionaItem(Item item);
	
	public void removeItem(Item item);
	
	public List<Item> buscaItem();
	
	public void atualizaItem(Item item);

}
