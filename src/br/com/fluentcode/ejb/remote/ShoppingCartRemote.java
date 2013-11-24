package br.com.fluentcode.ejb.remote;

import java.util.List;

public interface ShoppingCartRemote {

	void addItem(String item);

	List<String> getItems();

	void finishShopping();

}
