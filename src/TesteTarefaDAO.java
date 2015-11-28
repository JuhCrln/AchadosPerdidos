
public class TesteTarefaDAO {
	public static void main(String[] args) {
		ItemDAO dao = new ItemDAO();
		Item item  = new Item();
		item.setCor("Preto");
		dao.adciona(item);
		//System.out.println(item);
	}
}
