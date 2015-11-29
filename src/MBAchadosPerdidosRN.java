
public class MBAchadosPerdidosRN {
	private Item item;
	private Usuario usuario;
	private IServicoItem servItem;
	private IServicoUsuario servUsuario;
	
	public MBAchadosPerdidosRN() {
		item = new Item();
		usuario = new Usuario();
		servItem = new ServicoItem();
		servUsuario = new ServicoUsuario();
	}
	
	public void salvarItem(){
		servItem.adicionaItem(item);
		item = new Item();
	}
	
	public void salvarUsuario(){
		servUsuario.adicionaUsuario(usuario);
		usuario = new Usuario();
	}
	
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
