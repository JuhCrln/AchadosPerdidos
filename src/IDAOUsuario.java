
import java.util.List;

public interface IDAOUsuario {
	
	public void adciona(Usuario usuario);

	public void atualiza(Usuario usuario);

	public void remove(int id);
	
	public List<Usuario> busca();
	
	public List<Usuario> buscaUsuario(String usuario);
	
	public List<Usuario> buscaUsuarioPorID(int id);

	public List<Usuario> buscaUsuarioPorEmailSenha(String email, String senha);
}
