package co.edu.unbosque.miprimerspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.miprimerspring.entity.ExPareja;
import co.edu.unbosque.miprimerspring.repository.ExParejaRepository;

@Service
public class ExParejaService implements CRUDOPERATION<ExPareja> {

	@Autowired // inicializa el objeto
	private ExParejaRepository exParejaRep;

	public ExParejaService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int create(ExPareja data) { // Si necesito validar, lo hago acá
		exParejaRep.save(data);
		return 0;
	}

	@Override
	public List<ExPareja> getAll() {
		// TODO Auto-generated method stub
		return (List<ExPareja>) exParejaRep.findAll();
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		Optional<ExPareja> encontrado = exParejaRep.findById(id);
		if (encontrado.isPresent()) {
			exParejaRep.delete(encontrado.get());
			return 0;
		}
		return 1;
	}

	@Override
	public int updateById(Long id, ExPareja data) {
		// TODO Auto-generated method stub
		Optional<ExPareja> encontrado = exParejaRep.findById(id);
		if (encontrado.isPresent()) {
			ExPareja temp = encontrado.get();
			temp.setNombre(data.getNombre());
			temp.setEdad(data.getEdad());
			temp.setFechaNacimiento(data.getFechaNacimiento());
			temp.setFechaRuptura(data.getFechaRuptura());
			temp.setMotivoRuptura(data.getMotivoRuptura());
			exParejaRep.save(temp);
			return 0;
		}
		return 1;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return exParejaRep.count();
	}

	@Override
	public boolean exist(Long id) {
		// TODO Auto-generated method stub
		return exParejaRep.existsById(id) ? true : false;
	}

}
