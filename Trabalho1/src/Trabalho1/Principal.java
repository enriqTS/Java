package Trabalho1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Principal {

	public static void main(String[] args) throws IOException {
		//Leitura inicial dos arquivos e criação das variáveis que recebrão as informações

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
		
		// Os for loops seguinte iteram pelo arquivo JSON e salvam as informações necessárias deles em arrays das classes respectivas a cada arquivo JSON
		// Foi utilizado uma biblioteca externa para manipular o JSON

		for (int i = 0; i < productJson.length(); i++) {
			JSONObject jsonObj = productJson.getJSONObject(i);
			String nome = jsonObj.getString("title");
			int idProduto = jsonObj.getInt("id");
			double preco = jsonObj.getDouble("price");
			String descricao = jsonObj.getString("description");
			
			Produto p = new Produto();
			
			p.setProdNome(nome);
			p.setIdProduto(idProduto);
			p.setPreco(preco);
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
			p.setIdUsuario(idUsuario);
			p.setEmail(email);
			
			listaUsuario.add(p);
		}

		//Neste for foi necessário criar um JSONArray para tratar do array de objetos no arquivo de compra e criar um array para quantidade e um para o id da compra

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
			
			p.setProductId(productIds);
			p.setQuantity(quantity);
			p.setBuyId(buyId);
			p.setUserId(idUsuario);
			p.setData(date);
			
			listaCompra.add(p);
		}

		System.out.println("\n");

		//Este try-catch cria o arquivo caso ele não exista e envia uma mensagem quando o mesmo já existe

		try{
			File myObj = new File("Arquivo_final.txt");
			if(myObj.createNewFile()){
				System.out.println("Arquivo criado: " + myObj.getName());
			}else{
				System.out.println("Arquivo já existe.");
			}
		}catch (IOException e) {
			System.out.println("Um erro ocorreu.");
			e.printStackTrace();
		}

		//Criação do escritor de arquivos

		FileWriter myWriter = new FileWriter("Arquivo_final.txt");

		//Este for itera por toda a lista de compras para conseguir as informações necessárias

		for(int i = 0; i < listaCompra.size(); i++) {
			
			Compra buy = listaCompra.get(i);
			Usuario user = listaUsuario.get(i);
			Produto prod = listaProdutos.get(i);

			myWriter.write("Venda " + buy.getBuyId() + " na data " + buy.getData() + System.lineSeparator());

			//Este for consegue o nome do comprador de acordo com o id da compra atual

			for(int j = 0; j < listaUsuario.size(); j++){
				user = listaUsuario.get(j);
				if(buy.getUserId() == user.getIdUsuario()){
					myWriter.write("Usuário " + user.getNome() 
					+ " comprou os seguintes produtos: " + System.lineSeparator());
				}
			}

			//Este for consegue o nome dos produtos comprados por determinados usuários

			for(int j = 0; j < listaProdutos.size(); j++){
				prod = listaProdutos.get(j);
				for(int k = 0; k < buy.getProductId().size(); k++){
					if(buy.getProductId().get(k) == prod.getIdProduto()){
						myWriter.write(prod.getProdNome() + "\n");
					}
				}
			}

			//Este for serve para pegar o valor total da compra de determinado usuário e salva na variável soma

			double soma = 0;
			for(int j = 0; j < listaProdutos.size(); j++){
				prod = listaProdutos.get(j);
				for(int k = 0; k < buy.getProductId().size(); k++){
					if(buy.getProductId().get(k) == prod.getIdProduto()){
						soma += buy.getQuantity().get(k)*prod.getPreco();
					}
				}
			}

			myWriter.write("Total da compra: " + soma + System.lineSeparator());
			
			myWriter.write(System.lineSeparator());
						
		}

		myWriter.close();
		
	}

	
	

}
