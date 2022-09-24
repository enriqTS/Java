package Trabalho1;

import java.util.ArrayList;
import java.util.List;

public class Compra{
	private String buyId;
	private int userId;
	private List<Integer> productId;
	private List<Integer> quantity;
	private String data;
	
	public Compra() {
		this.buyId = "";
		this.userId = -1;
		this.data = "";
		this.productId = new ArrayList<Integer>();
		this.quantity = new ArrayList<Integer>();
	}
	
	public Compra(String buyId, int userId, List<Integer> productId,List<Integer> quantity, String data) {
		this.buyId = buyId;
		this.userId = userId;
		this.data = data;
		this.productId = new ArrayList<Integer>();
		productId.addAll(productId);
		this.quantity = new ArrayList<Integer>();
		quantity.addAll(quantity);		
	}
	
	public String getBuyId() {
		return buyId;
	}

	public void setBuyId(String buyId) {
		this.buyId = buyId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public ArrayList<Integer> getProductId() {
		ArrayList<Integer> ids = new ArrayList<Integer>();
		for (Integer item : this.productId) {
			ids.add(item);
		}

		return ids;
	}

	public void setProductId(ArrayList<Integer> productIds) {
		ArrayList<Integer> productId = new ArrayList<Integer>();
		for(int i = 0; i < productIds.size(); i++){
			productId.add(productIds.get(i));
		}
		this.productId = productId;
	}

	public ArrayList<Integer> getQuantity() {
		ArrayList<Integer> quants = new ArrayList<Integer>();
		for(Integer quant : this.quantity){
			quants.add(quant);
		}
		return quants;
	}

	public void setQuantity(ArrayList<Integer> quantity) {
		ArrayList<Integer> quant = new ArrayList<Integer>();
		for(int i = 0; i < quantity.size(); i++){
			quant.add(quantity.get(i));
		}
		this.quantity = quant;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	//Função toString sobrecarregada para mostrar os dados salvos na classe Compra

	@Override
	public String toString() {
		String productIds = "";
		for (Integer productId : this.productId) {
			productIds = productIds + productId + " | ";
		}

		String quant = "";
		for (Integer quantity : this.quantity) {
			quant = quant + quantity + " | ";
		}

		String compra = "Id da compra: " + this.buyId + System.lineSeparator() + "Id do usuário: " + this.userId
		+ System.lineSeparator() + "Data da compra: " + this.data + System.lineSeparator() + "Quantidade: "
		+ quant + System.lineSeparator() + "Id do produto: " + productIds;
		
		return compra;
	}
}
