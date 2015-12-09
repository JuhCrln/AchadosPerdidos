import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Mensagem {
	@Id
	@GeneratedValue
	private int id;
	private String assunto;
	private String para;
	private String de;
	private int id_de;
	private String corpo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getPara() {
		return para;
	}
	public void setPara(String para) {
		this.para = para;
	}
	public String getDe() {
		return de;
	}
	public void setDe(String de) {
		this.de = de;
	}
	public String getCorpo() {
		return corpo;
	}
	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}
	public int getId_de() {
		return id_de;
	}
	public void setId_de(int id_de) {
		this.id_de = id_de;
	}
}
