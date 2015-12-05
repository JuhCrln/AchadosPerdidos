import java.util.List;

public class MBAchadosPerdidosRN {
	private Item item;
	private Usuario usuario;
	private IServicoItem servItem;
	private IServicoUsuario servUsuario;
	private boolean checkMarca;
	private boolean checkModelo;
	private boolean checkCor;
	private boolean checkCidade;
	private String palavraChave;
	private String nome;
	private String email;
	private String senha;
	private String telefone;
	private String cidade;
	private String estado;
	private String nomeDeUsuario;
	
	
	public MBAchadosPerdidosRN() {
		item = new Item();
		usuario = new Usuario();
		servItem = new ServicoItem();
		servUsuario = new ServicoUsuario();
	}

	public void salvarItem() {
		servItem.adicionaItem(item);
		item = new Item();
	}

	public void removeItem() {
		servItem.removeItem(item);
	}

	public void atualizaItem() {
		servItem.atualizaItem(item);
	}

	public void buscaItem() {
		List <Item> lista =  servItem.buscaItem();
		for (Item e : lista){
			System.out.println(e);
		}
	}
	
	public void filtro(){
		List<Item> lista = null;
		
		if (checkMarca == true){
			lista = servItem.buscaMarca(palavraChave);
		}
		
		else if(checkModelo == true){
			lista = servItem.buscaModelo(palavraChave);
		}
		
		else if(checkCor == true){
			lista = servItem.buscaCor(palavraChave);
		}
		
		else if(checkCidade == true){
			lista = servItem.buscaCidade(palavraChave);
		}
		
		for(Item a : lista){
			System.out.println(a);
		}
	}
	
	public void salvarUsuario() {
		servUsuario.adicionaUsuario(usuario);
		usuario = new Usuario();
	}
	
	public void removerUsuario(){
		servUsuario.removeUsuario(usuario);
	}
	
	public void atualizarUsuario(){
		servUsuario.atualizaUsuario(usuario);
	}
	
	public void buscarUsuario(){
		servUsuario.buscaUsuario();
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

	public boolean isCheckMarca() {
		return checkMarca;
	}

	public void setCheckMarca(boolean checkMarca) {
		this.checkMarca = checkMarca;
	}

	public boolean isCheckModelo() {
		return checkModelo;
	}

	public void setCheckModelo(boolean checkModelo) {
		this.checkModelo = checkModelo;
	}

	public boolean isCheckCor() {
		return checkCor;
	}

	public void setCheckCor(boolean checkCor) {
		this.checkCor = checkCor;
	}

	public boolean isCheckCidade() {
		return checkCidade;
	}

	public void setCheckCidade(boolean checkCidade) {
		this.checkCidade = checkCidade;
	}

	public String getPalavraChave() {
		return palavraChave;
	}

	public void setPalavraChave(String palavraChave) {
		this.palavraChave = palavraChave;
	}

	public IServicoItem getServItem() {
		return servItem;
	}

	public void setServItem(IServicoItem servItem) {
		this.servItem = servItem;
	}

	public IServicoUsuario getServUsuario() {
		return servUsuario;
	}

	public void setServUsuario(IServicoUsuario servUsuario) {
		this.servUsuario = servUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNomeDeUsuario() {
		return nomeDeUsuario;
	}

	public void setNomeDeUsuario(String nomeDeUsuario) {
		this.nomeDeUsuario = nomeDeUsuario;
	}
}
