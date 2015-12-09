import java.util.List;

public class ServicoMensagem implements IServicoMensagem {
	private IDAOMensagem dao;
	
	public ServicoMensagem(){
		dao = new MensagemDAO();
	}

	@Override
	public void adcionaMensagem(Mensagem mensagem) {
		dao.adciona(mensagem);
	}

	@Override
	public List<Mensagem> buscaMensagens() {
		return dao.buscaMensagens();
	}
}
