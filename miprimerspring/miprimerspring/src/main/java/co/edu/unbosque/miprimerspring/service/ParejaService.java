package co.edu.unbosque.miprimerspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.miprimerspring.entity.Pareja;
import co.edu.unbosque.miprimerspring.repository.ParejaRepository;

@Service
public class ParejaService implements CRUDOPERATION<Pareja> {

	@Autowired // inicializa el objeto
	private ParejaRepository ParejaRep;

	public ParejaService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int create(Pareja data) { // Si necesito validar, lo hago acá
		ParejaRep.save(data);
		return 0;
	}

	@Override
	public List<Pareja> getAll() {
		// TODO Auto-generated method stub
		return (List<Pareja>) ParejaRep.findAll();
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		Optional<Pareja> encontrado = ParejaRep.findById(id);
		if (encontrado.isPresent()) {
			ParejaRep.delete(encontrado.get());
			return 0;
		}
		return 1;
	}

	@Override
	public int updateById(Long id, Pareja data) {
		// TODO Auto-generated method stub
		Optional<Pareja> encontrado = ParejaRep.findById(id);
		if (encontrado.isPresent()) {
			Pareja temp = encontrado.get();
			temp.setNombre(data.getNombre());
			temp.setEdad(data.getEdad());
			temp.setFechaAniversario(data.getFechaAniversario());
			ParejaRep.save(temp);
			return 0;
		}
		return 1;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return ParejaRep.count();
	}

	@Override
	public boolean exist(Long id) {
		// TODO Auto-generated method stub
		return ParejaRep.existsById(id) ? true : false;
	}

}
