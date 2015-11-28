import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Tarefa {

	@Id
	@GeneratedValue
	private Long id;

	private String descricao;
	private boolean finalizado;

	@Temporal(TemporalType.DATE)
	private Calendar dataFinalizacao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(Calendar dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	
	@Override
	public String toString() {
		return "(" + descricao + ", " + finalizado + ", " + (dataFinalizacao.get(Calendar.YEAR)) + "-" + dataFinalizacao.get(Calendar.MONTH) + "-" + dataFinalizacao.get(Calendar.DAY_OF_MONTH) + ")";
	}
}