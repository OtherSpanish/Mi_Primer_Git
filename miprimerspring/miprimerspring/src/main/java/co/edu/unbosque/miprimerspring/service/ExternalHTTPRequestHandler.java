package co.edu.unbosque.miprimerspring.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;

import com.google.gson.Gson;

import co.edu.unbosque.miprimerspring.dto.JokeDTO;

public class ExternalHTTPRequestHandler {

	private static final HttpClient HTTP_CLIENT = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2)
			.connectTimeout(Duration.ofSeconds(10)).build();
	/*Toda solicitud HTTP tiene un tiempo de vida, TTL (time to live) -> indica cuando tiempo maximo se mantiene la 
	solicitud antes de descartarla
	
	Error 0, el recurso no existe o se demoró demasiado en contestar
	
	Devuelve codigo de estado y header
	*/
	
	
	public static String doGet(String url) {
		HttpRequest solicitud = HttpRequest.newBuilder().GET().uri(URI.create(url)).setHeader("User-Agent", "Java 11 HttpClient Bot").build();
		HttpResponse<String> respuesta = null;
		try {
			respuesta= HTTP_CLIENT.send(solicitud, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Status code -> " + respuesta.statusCode());
		
		return respuesta.body();
		
	}
	
	public static JokeDTO doGetJokeDTO(String url) {
		HttpRequest solicitud = HttpRequest.newBuilder().GET().uri(URI.create(url)).setHeader("User-Agent", "Java 11 HttpClient Bot").build();
		HttpResponse<String> respuesta = null;
		try {
			respuesta= HTTP_CLIENT.send(solicitud, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Status code -> " + respuesta.statusCode());
		Gson gson = new Gson();
		return gson.fromJson(respuesta.body(), JokeDTO.class);
	}
	
	public static MultipleJokesDTO doGetVarJokesDTO(String url) {
		HttpRequest solicitud = HttpRequest.newBuilder().GET().uri(URI.create(url)).setHeader("User-Agent", "Java 11 HttpClient Bot").build();
		HttpResponse<String> respuesta = null;
		try {
			respuesta= HTTP_CLIENT.send(solicitud, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Status code -> " + respuesta.statusCode());
		Gson gson = new Gson();
		return gson.fromJson(respuesta.body(), MultipleJokesDTO.class);
	}
	
	/*Todo lo que llegue en JSON metido en corchetes hace parte de un objeto
	 * y las comas separan las variables de sus valores
	ej: {
    "error": false,
    "category": "Programming",
    "type": "twopart",
    "setup": "Why does no one like SQLrillex?",
    "delivery": "He keeps dropping the database.",
    "flags": {
        "nsfw": false,
        "religious": false,
        "political": false,
        "racist": false,
        "sexist": false,
        "explicit": false
    },
    "id": 13,
    "safe": true,
    "lang": "en"
}
	*
	*Se debe crear un DTO por objeto
	*
	*Se puede hacer composicion, un objeto que funcione como atributo de otro objeto ej: flags es un objeto y se pone como atributo de joke
	*
	*No tiene entidad ni repositorio(no necesita persistir porque ya esta almacenado de donde viene la API)
	*
	*SI TIENE Controller, service y DTO, nada más
	*
	*
	*
	*/
	public static void main(String[] args) {
//		JokeDTO chiste = doGetJokeDTO("https://v2.jokeapi.dev/joke/Programming");
//		System.out.println(chiste.toString());
		
		MultipleJokesDTO chistes = doGetVarJokesDTO("https://v2.jokeapi.dev/joke/Programming?amount=4");
		ArrayList<JokeDTO> list = chistes.getLista();
		for (JokeDTO jokeDTO : list) {
			System.out.println(jokeDTO.toString());
		}
	}
}
