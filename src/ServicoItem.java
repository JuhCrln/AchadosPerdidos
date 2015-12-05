import java.util.List;

public class ServicoItem implements IServicoItem {
	
	private IDAOItem dao;
	
	public ServicoItem(){
		dao = new ItemDAO();
	}

	public void adicionaItem(Item item) {
		dao.adciona(item);
	}

	public void removeItem(Item item) {
		dao.remove(item.getId());
	}

	public List<Item> buscaItem() {
		return dao.buscaItens();
	}
	
	public void atualizaItem(Item item) {
		dao.atualiza(item);
		
	}

	public List<Item> buscaMarca(String marca) {
		return dao.buscaMarca(marca);
	}

	public List<Item> buscaModelo(String modelo) {
		return dao.buscaModelo(modelo);
	}

	public List<Item> buscaCor(String cor) {
		return dao.buscaCor(cor);
	}

	public List<Item> buscaCidade(String cidade) {
		return dao.buscaItemCidade(cidade);
	}

}
