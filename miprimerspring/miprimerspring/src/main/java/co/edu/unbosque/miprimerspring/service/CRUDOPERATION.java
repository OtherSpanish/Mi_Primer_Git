package co.edu.unbosque.miprimerspring.service;

import java.util.List;

import co.edu.unbosque.miprimerspring.entity.Pareja;

public interface CRUDOPERATION<T> {

	public int create(T data);

	public List<T> getAll();

	public int deleteById(Long id);

	public int updateById(Long id, T data);

	public long count();

	public boolean exist(Long id);


}
