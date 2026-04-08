package co.edu.unbosque.miprimerspring.service;

import java.util.ArrayList;

import co.edu.unbosque.miprimerspring.dto.JokeDTO;

public class MultipleJokesDTO {
	
	private ArrayList<JokeDTO> lista;
	
	public MultipleJokesDTO() {
		// TODO Auto-generated constructor stub
	}

	public MultipleJokesDTO(ArrayList<JokeDTO> lista) {
		super();
		this.lista = lista;
	}

	public ArrayList<JokeDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<JokeDTO> lista) {
		this.lista = lista;
	}
	
	
	
}
