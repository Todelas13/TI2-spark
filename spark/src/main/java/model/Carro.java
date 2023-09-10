package model;

public class Carro {
	private int id;
	private String fabricante;
	private String modelo;
	private int ano;
	private String placa;
	
	public Carro() {
		this.id = -1;
		this.fabricante = "";
		this.modelo = "";
		this.ano = -1;
		this.placa = "";
	}
	
	public Carro(int id, String fabricante, String modelo, int ano, String placa) {
		this.id = id;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.ano = ano;
		this.placa = placa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	@Override
	public String toString() {
		return "Carro [id=" + id + ", fabricante=" + fabricante + ", modelo=" + modelo + ", ano=" + ano + ", placa=" + placa + "]";
	}	
}
