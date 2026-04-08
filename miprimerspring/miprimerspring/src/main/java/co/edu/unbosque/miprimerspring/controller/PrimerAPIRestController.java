package co.edu.unbosque.miprimerspring.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/primerapi") // Indica cual va a ser el endpoint
@CrossOrigin(origins = { "http://localhost:8080", "*" })

public class PrimerAPIRestController {
	// ABRE LA RUTA DE CONEXIÓN

	@GetMapping("/saludar")
	public String getSaludar() {
		return "Buenos días";
	}

	@GetMapping("/saludarpornombre")
	public String getSaludarPorNombre(@RequestParam String nombre) {
		return "Buenos días " + nombre;
	}

	@GetMapping("/sumar")
	public int getSuma(@RequestParam int num1, @RequestParam int num2) {
		return num1 + num2;
	}

	@GetMapping("/restar")
	public int getResta(@RequestParam int num1, @RequestParam int num2) {
		return num1 - num2;
	}

	@GetMapping("/multiplicar")
	public int getMultiplicacion(@RequestParam int num1, @RequestParam int num2) {
		return num1 * num2;
	}

	@GetMapping("/dividir")
	public double getDivision(@RequestParam double num1, @RequestParam double num2) {
		return num1 / num2;
	}

}
