package Trabalho1;

import java.util.ArrayList;
import java.util.List;

public class Compra {
	private String buyId;
	private String userId;
	private List<Integer> productId;
	private List<Integer> quantity;
	private String data;
	
	public Compra() {
		this.buyId = "";
		this.userId = "";
		this.data = "";
		this.productId = new ArrayList<Integer>();
		this.quantity = new ArrayList<Integer>();
	}
	
	public Compra(String buyId, String userId, List<Integer> productId,List<Integer> quantity, String data) {
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductId() {
		String itens = "";
		for (Integer item : this.productId) {
			itens = itens + item + " | ";
		}

		return itens;
	}

	public void setProductId(ArrayList<Integer> productIds) {
		ArrayList<Integer> productId = new ArrayList<Integer>();
		for(int i = 0; i < productIds.size(); i++){
			productId.add(productIds.get(i));
		}
		this.productId = productId;
	}

	public String getQuantity() {
		String itens = "";
		for (Integer item : this.quantity) {
			itens = itens + item + " | ";
		}

		return itens;
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
