package Trabalho1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Principal {

	public static void main(String[] args) throws IOException {
		Path buypath = Path.of("D:\\Coisas\\Prog\\Java\\Trabalho1\\src\\ComprasFormat.json");
		Path userpath = Path.of("D:\\Coisas\\Prog\\Java\\Trabalho1\\src\\UsuarioFormat.json");
		Path productpath = Path.of("D:\\Coisas\\Prog\\Java\\Trabalho1\\src\\ProdutoFormat.json");
		
		String buycontent = Files.readString(buypath);
		String usercontent = Files.readString(userpath);
		String productcontent = Files.readString(productpath);
		
		JSONArray buyJson = new JSONArray(buycontent);
		JSONArray userJson = new JSONArray(usercontent);
		JSONArray productJson = new JSONArray(productcontent);
		
		ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
		ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
		ArrayList<Compra> listaCompra = new ArrayList<Compra>();
		
		for (int i = 0; i < productJson.length(); i++) {
			JSONObject jsonObj = productJson.getJSONObject(i);
			String nome = jsonObj.getString("title");
			int idProduto = jsonObj.getInt("id");
			int preco = jsonObj.getInt("price");
			String descricao = jsonObj.getString("description");
			
			Produto p = new Produto();
			
			p.setNome(nome);
			String idProdutos = "" + idProduto;
			p.setIdProduto(idProdutos);
			String precos = "" + preco;
			p.setPreco(precos);
			p.setDescricao(descricao);
			
			listaProdutos.add(p);
									
		}
		
		for (int i = 0; i < userJson.length(); i++) {
			JSONObject jsonObj = userJson.getJSONObject(i);
			JSONObject nomes = jsonObj.getJSONObject("name");
			String nome = nomes.getString("firstname")+ " " +nomes.getString("lastname");
			int idUsuario = jsonObj.getInt("id");
			String email = jsonObj.getString("email");
			
			Usuario p = new Usuario();
			
			p.setNome(nome);
			String idUsuarios = "" + idUsuario;
			p.setIdUsuario(idUsuarios);
			p.setEmail(email);
			
			listaUsuario.add(p);
		}

		for (int i = 0; i < buyJson.length(); i++) {
			JSONObject jsonObj = buyJson.getJSONObject(i);
			JSONArray productsarray = jsonObj.getJSONArray("products");
			ArrayList<Integer> productIds = new ArrayList<Integer>();
			ArrayList<Integer> quantity = new ArrayList<Integer>();
			for(int j = 0; j < productsarray.length(); j++){
				JSONObject iterator = productsarray.getJSONObject(j);
				productIds.add(iterator.getInt("productId"));
				quantity.add(iterator.getInt("quantity")); 
			}
			int idCompra = jsonObj.getInt("id");
			int idUsuario = jsonObj.getInt("userId");
			String date = jsonObj.getString("date");
			
			Compra p = new Compra();

			String buyId = "" + idCompra;
			String userId = "" + idUsuario;

			p.setProductId(productIds);
			p.setQuantity(quantity);
			p.setBuyId(buyId);
			p.setUserId(userId);
			p.setData(date);
			
			listaCompra.add(p);
		}

		for(Produto prod : listaProdutos) {
			System.out.println(prod.toString());
		}

		System.out.println("\n");
		
		for(Usuario user : listaUsuario) {
			System.out.println(user.toString());
		}

		System.out.println("\n");

		for(Compra buy : listaCompra) {
			System.out.println(buy.toString());
		}
		
	}
	

}
