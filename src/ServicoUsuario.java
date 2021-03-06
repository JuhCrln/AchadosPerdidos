import java.util.List;

public class ServicoUsuario implements IServicoUsuario {
	
	private IDAOUsuario dao;
	
	public ServicoUsuario(){
		dao = new UsuarioDAO();
	}

	public void adicionaUsuario(Usuario usuario) {
		dao.adciona(usuario);
	}
	
	public void removeUsuario(Usuario usuario) {
		dao.remove(usuario.getId());
	}

	public List<Usuario> buscaUsuario() {
		return dao.busca();
	}

	public void atualizaUsuario(Usuario usuario) {
		dao.atualiza(usuario);
		
	}
	
	public List<Usuario> buscaUsuario(String usuario){
		return dao.buscaUsuario(usuario);
	}

	@Override
	public List<Usuario> buscaUsuarioPorEmailSenha(String email, String senha) {
		return dao.buscaUsuarioPorEmailSenha(email, senha);
	}

	@Override
	public List<Usuario> buscaUsuarioPorID(int id) {
		return dao.buscaUsuarioPorID(id);
	}
}
