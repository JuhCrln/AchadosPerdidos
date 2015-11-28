
public class MBAchadosPerdidosRN {
	private Item item;
	private IServicoItem servItem;
	
	public MBAchadosPerdidosRN() {
		item = new Item();
		servItem = new ServicoItem();
	}
	
	public void salvarItem(){
		servItem.adicionaItem(item);
		item = new Item();
	}
	
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
}
