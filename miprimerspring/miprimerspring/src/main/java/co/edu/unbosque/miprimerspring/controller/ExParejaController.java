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
import co.edu.unbosque.miprimerspring.entity.ExPareja;
import co.edu.unbosque.miprimerspring.service.ExParejaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/ExPareja") // Indica cual va a ser el endpoint
@CrossOrigin(origins = { "http://localhost:8080", "*" })
public class ExParejaController {

	@Autowired
	private ExParejaService exParejaSer;

	public ExParejaController() {
		// TODO Auto-generated constructor stub
	}

	@PostMapping("/crear")
	public ResponseEntity<String> crearExPareja(@RequestParam String nombre, @RequestParam int edad,
			@RequestParam LocalDateTime fechaNacimiento, @RequestParam LocalDateTime fechaRuptura,
			@RequestParam String motivoRuptura) {

		ExPareja nuevo = new ExPareja(nombre, edad, fechaNacimiento, fechaRuptura, motivoRuptura);
		int status = exParejaSer.create(nuevo);

		if (status == 0) {
			return new ResponseEntity<>("Dato creado con éxito", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Error al crear ExPareja", HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/mostrartodo")
	public ResponseEntity<List<ExPareja>> mostrarTodo() {
		List<ExPareja> exParejas = exParejaSer.getAll();
		if (exParejas.isEmpty()) {
			return new ResponseEntity<List<ExPareja>>(exParejas, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<ExPareja>>(exParejas, HttpStatus.ACCEPTED);
		}
	}

	@DeleteMapping("/eliminar")
	public ResponseEntity<String> eliminarExPareja(@RequestParam Long id) {

		int estado = exParejaSer.deleteById(id);

		if (estado == 0) {
			return new ResponseEntity<>("ExPareja eliminada con éxito", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("ExPareja no encontrada", HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/actualizar")
	public ResponseEntity<String> actualizarExPareja(@RequestParam Long id, @RequestParam String nombre,
			@RequestParam int edad, @RequestParam LocalDateTime fechaNacimiento,
			@RequestParam LocalDateTime fechaRuptura, @RequestParam String motivoRuptura) {

		ExPareja nuevo = new ExPareja(nombre, edad, fechaNacimiento, fechaRuptura, motivoRuptura);

		int estado = exParejaSer.updateById(id, nuevo);

		if (estado == 0) {
			return new ResponseEntity<>("ExPareja actualizada con éxito", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("ExPareja no encontrada", HttpStatus.NOT_FOUND);
		}
	}
}
