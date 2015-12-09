import java.util.List;

public interface IServicoUsuario {
	
	public void adicionaUsuario(Usuario usuario);
	
	public void removeUsuario(Usuario usuario);
	
	public List<Usuario> buscaUsuario();
	
	public void atualizaUsuario(Usuario usuario);
	
	public List<Usuario> buscaUsuario(String usuario);
	
	public List<Usuario> buscaUsuarioPorID(int id);
	
	public List<Usuario> buscaUsuarioPorEmailSenha(String email, String senha);
}
