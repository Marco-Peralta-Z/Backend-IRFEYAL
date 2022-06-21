package com.irfeyal.modelo.inventarios;

import java.util.ArrayList;
import java.util.List;

public class StockArticulo {

	int cantidad;
	String categoria;
	List<Articulo> listaArticulos = new ArrayList<>();
	
	public StockArticulo() {
		super();
	}
	public StockArticulo(int cantidad, String categoria, List<Articulo> listaArticulos) {
		super();
		this.cantidad = cantidad;
		this.categoria = categoria;
		this.listaArticulos = listaArticulos;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public List<Articulo> getListaArticulos() {
		return listaArticulos;
	}
	public void setListaArticulos(List<Articulo> listaArticulos) {
		this.listaArticulos = listaArticulos;
	}
	@Override
	public String toString() {
		return "StockArticulo [cantidad=" + cantidad + ", categoria=" + categoria + ", listaArticulos=" + listaArticulos
				+ "]";
	}
	
	
	
	
}
