import java.util.List;

public interface IServicoUsuario {
	
	public void adicionaUsuario(Usuario usuario);
	
	public void removeUsuario(Usuario usuario);
	
	public List<Usuario> buscaUsuario();
	
	public void atualizaUsuario(Usuario usuario);

}
