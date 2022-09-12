package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DificultadAcceso;
import co.com.arcosoft.modelo.dto.DificultadAccesoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDificultadAccesoLogic {
	public List<DificultadAcceso> getDificultadAcceso() throws Exception;

	/**
	 * Save an new DificultadAcceso entity
	 */
	public void saveDificultadAcceso(DificultadAcceso entity) throws Exception;

	/**
	 * Delete an existing DificultadAcceso entity
	 *
	 */
	public void deleteDificultadAcceso(DificultadAcceso entity) throws Exception;

	/**
	 * Update an existing DificultadAcceso entity
	 *
	 */
	public void updateDificultadAcceso(DificultadAcceso entity) throws Exception;

	/**
	 * Load an existing DificultadAcceso entity
	 *
	 */
	public DificultadAcceso getDificultadAcceso(Long dificultadAccesoId) throws Exception;

	public List<DificultadAcceso> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DificultadAcceso> findPageDificultadAcceso(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDificultadAcceso() throws Exception;

	public List<DificultadAccesoDTO> getDataDificultadAcceso() throws Exception;
}
