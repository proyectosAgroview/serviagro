package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.Servicio;
import co.com.arcosoft.modelo.dto.ServicioDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IServicioLogic {
	public List<Servicio> getServicio() throws Exception;

	/**
	 * Save an new Servicio entity
	 */
	public void saveServicio(Servicio entity) throws Exception;

	/**
	 * Delete an existing Servicio entity
	 *
	 */
	public void deleteServicio(Servicio entity) throws Exception;

	/**
	 * Update an existing Servicio entity
	 *
	 */
	public void updateServicio(Servicio entity) throws Exception;

	/**
	 * Load an existing Servicio entity
	 *
	 */
	public Servicio getServicio(Long servicioId) throws Exception;

	public List<Servicio> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Servicio> findPageServicio(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberServicio() throws Exception;

	public List<ServicioDTO> getDataServicio() throws Exception;
}
