package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.Recurso;
import co.com.arcosoft.modelo.dto.RecursoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IRecursoLogic {
	public List<Recurso> getRecurso() throws Exception;

	/**
	 * Save an new Recurso entity
	 */
	public void saveRecurso(Recurso entity) throws Exception;

	/**
	 * Delete an existing Recurso entity
	 *
	 */
	public void deleteRecurso(Recurso entity) throws Exception;

	/**
	 * Update an existing Recurso entity
	 *
	 */
	public void updateRecurso(Recurso entity) throws Exception;

	/**
	 * Load an existing Recurso entity
	 *
	 */
	public Recurso getRecurso(Long recursoId) throws Exception;

	public List<Recurso> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Recurso> findPageRecurso(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberRecurso() throws Exception;

	public List<RecursoDTO> getDataRecurso() throws Exception;
}
