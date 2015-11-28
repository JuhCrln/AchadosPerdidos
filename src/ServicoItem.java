import java.util.List;

public class ServicoItem implements IServicoItem {
	
	private IDAOItem dao;
	
	public ServicoItem(){
		dao = new ItemDAO();
	}

	@Override
	public void adicionaItem(Item item) {
		dao.adciona(item);
	}

	@Override
	public void removeItem(Item item) {
		dao.remove(item.getId());
	}

	@Override
	public List<Item> buscaItem() {
		return dao.buscaItens();
	}

	@Override
	public void atualizaItem(Item item) {
		dao.atualiza(item);
		
	}

}
