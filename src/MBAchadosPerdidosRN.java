import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.*;

import org.primefaces.context.RequestContext;

public class MBAchadosPerdidosRN {
	// Atributos da tela de Login
	private String email_login;
	private String senha_login;
	private Usuario usuario_login;

	private Item item;
	private Usuario usuario;
	private IServicoItem servItem;
	private IServicoUsuario servUsuario;
	private IServicoMensagem servMensagem;
	private boolean checkMarca;
	private boolean checkModelo;
	private boolean checkCor;
	private boolean checkCidade;
	private String palavraChave;
	private String nome;
	private String telefone;
	private String cidade;
	private String estado;
	private String nomeDeUsuario;
	private List<Item> lista_itens;
	private Item selectedItem;
	private Item selectedItem_busca;
	private Usuario selectedUsuario;
	private Usuario selectedUsuario_busca;
	private String para_mensagem;
	private String assunto_mensagem;
	private String corpo_mensagem;
	private List<Item> lista_item_busca;

	public MBAchadosPerdidosRN() {
		item = new Item();
		usuario = new Usuario();
		servItem = new ServicoItem();
		servUsuario = new ServicoUsuario();
		servMensagem = new ServicoMensagem();
		lista_itens = servItem.buscaItem();
	}

	public void login() {
		List<Usuario> result = servUsuario.buscaUsuarioPorEmailSenha(this.email_login, this.senha_login);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		if (result.size() == 0) {
			FacesMessage facesMessage = new FacesMessage("Login e/ou Senha errados!");
			facesContext.addMessage("aviso", facesMessage);
		} else {
			this.usuario_login = result.get(0);
			System.out.println(this.usuario_login.getNome() + " " + this.usuario.getEmail());
			//Criacao da sessao
			HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
			session.setAttribute("usuario", this.usuario_login);
			facesContext.addMessage("bem-vindo",
					new FacesMessage("Be m-vindo, " + this.usuario_login.getNome().toUpperCase()));
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("TelaUsuario.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void salvarItem() {
		Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario"); 
		item.setId_usuario(user.getId());
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
		List<Item> lista = servItem.buscaItem();
		for (Item e : lista) {
			System.out.println(e);
		}
	}

	public void filtro() {
		if (checkMarca == true) {
			lista_item_busca = servItem.buscaMarca(palavraChave);
		}

		else if (checkModelo == true) {
			lista_item_busca = servItem.buscaModelo(palavraChave);
		}

		else if (checkCor == true) {
			lista_item_busca = servItem.buscaCor(palavraChave);
		}

		else if (checkCidade == true) {
			lista_item_busca = servItem.buscaCidade(palavraChave);
		}
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("BuscaObjeto.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void salvarUsuario() {
		servUsuario.adicionaUsuario(usuario);
		usuario = new Usuario();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("TelaInicial.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void removerUsuario() {
		servUsuario.removeUsuario(usuario);
	}

	public void atualizarUsuario() {
		servUsuario.atualizaUsuario(usuario);
	}

	public void buscarUsuario() {
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

	public String getEmail_login() {
		return email_login;
	}

	public void setEmail_login(String email_login) {
		this.email_login = email_login;
	}

	public String getSenha_login() {
		return senha_login;
	}

	public void setSenha_login(String senha_login) {
		this.senha_login = senha_login;
	}

	public Usuario getUsuario_login() {
		return usuario_login;
	}

	public void setUsuario_login(Usuario usuario_login) {
		this.usuario_login = usuario_login;
	}

	public List<Item> getLista_itens() {
		return lista_itens;
	}

	public void setLista_itens(List<Item> lista_itens) {
		this.lista_itens = lista_itens;
	}

	public Item getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(Item selectedItem) {
		this.selectedItem = selectedItem;
	}

	public Usuario getSelectedUsuario() {
		return selectedUsuario = servUsuario.buscaUsuarioPorID(selectedItem.getId_usuario()).get(0);
	}

	public void setSelectedUsuario(Usuario selectedUsuario) {
		this.selectedUsuario = selectedUsuario;
	}
	
	public void paraMensagem() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("Mensagem.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getPara_mensagem() {
		return para_mensagem;
	}

	public void setPara_mensagem(String para_mensagem) {
		this.para_mensagem = para_mensagem;
	}

	public String getAssunto_mensagem() {
		return assunto_mensagem;
	}

	public void setAssunto_mensagem(String assunto_mensagem) {
		this.assunto_mensagem = assunto_mensagem;
	}

	public String getCorpo_mensagem() {
		return corpo_mensagem;
	}

	public void setCorpo_mensagem(String corpo_mensagem) {
		this.corpo_mensagem = corpo_mensagem;
	}
	
	public void salvarMensagem() {
		Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
		Mensagem msg = new Mensagem();
		msg.setAssunto(assunto_mensagem);
		msg.setDe(user.getNomeDeUsuario());
		msg.setId_de(user.getId());
		msg.setCorpo(corpo_mensagem);
		msg.setPara(para_mensagem);
		servMensagem.adcionaMensagem(msg);
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("TelaUsuario.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Item> getLista_item_busca() {
		return lista_item_busca;
	}

	public void setLista_item_busca(List<Item> lista_item_busca) {
		this.lista_item_busca = lista_item_busca;
	}

	public Item getSelectedItem_busca() {
		return selectedItem_busca;
	}

	public void setSelectedItem_busca(Item selectedItem_busca) {
		this.selectedItem_busca = selectedItem_busca;
	}

	public Usuario getSelectedUsuario_busca() {
		return servUsuario.buscaUsuarioPorID(selectedItem_busca.getId_usuario()).get(0);
	}

	public void setSelectedUsuario_busca(Usuario selectedUsuario_busca) {
		this.selectedUsuario_busca = selectedUsuario_busca;
	}
}
