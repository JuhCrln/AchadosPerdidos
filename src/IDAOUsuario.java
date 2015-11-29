import java.util.List;

public interface IDAOUsuario {
	
	public void adciona(Usuario usuario);

	public void atualiza(Usuario usuario);

	public void remove(int id);
	
	public List<Usuario> busca();
}
