package co.edu.unbosque.miprimerspring.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.edu.unbosque.miprimerspring.entity.Pareja;
import co.edu.unbosque.miprimerspring.service.ParejaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/pareja") // Indica cual va a ser el endpoint
@CrossOrigin(origins = { "http://localhost:8080", "*" })
public class ParejaController {

	@Autowired
	private ParejaService parejaSer;

	public ParejaController() {
		// TODO Auto-generated constructor stub
	}

	@PostMapping("/crear")
	public ResponseEntity<String> crearPareja(@RequestParam String nombre, @RequestParam int edad,
			@RequestParam String carrera, @RequestParam LocalDateTime fechaAniversario) {

		Pareja nuevo = new Pareja(nombre, edad, carrera, fechaAniversario);
		int status = parejaSer.create(nuevo);

		if (status == 0) {
			return new ResponseEntity<>("Dato creado con éxito", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Error al crear pareja", HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/mostrartodo")
	public ResponseEntity<List<Pareja>> mostrarTodo() {
		List<Pareja> parejas = parejaSer.getAll();
		if (parejas.isEmpty()) {
			return new ResponseEntity<List<Pareja>>(parejas, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Pareja>>(parejas, HttpStatus.ACCEPTED);
		}
	}
	
	@DeleteMapping("/eliminar")
	public ResponseEntity<String> eliminarPareja(@RequestParam Long id) {

		int estado = parejaSer.deleteById(id);

		if (estado == 0) {
			return new ResponseEntity<>("Pareja eliminada con éxito", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Pareja no encontrada", HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/actualizar")
	public ResponseEntity<String> actualizarPareja(@RequestParam Long id, @RequestParam String nombre,
			@RequestParam int edad, @RequestParam String carrera, @RequestParam LocalDateTime fechaAniversario) {

		Pareja nuevo = new Pareja(nombre, edad, carrera, fechaAniversario);

		int estado = parejaSer.updateById(id, nuevo);

		if (estado == 0) {
			return new ResponseEntity<>("Pareja actualizada con éxito", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Pareja no encontrada", HttpStatus.NOT_FOUND);
		}
	}
}
