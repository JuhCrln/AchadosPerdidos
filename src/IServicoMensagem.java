import java.util.List;

public interface IServicoMensagem {
	public void adcionaMensagem(Mensagem mensagem);
	
	public List<Mensagem> buscaMensagens();
}
