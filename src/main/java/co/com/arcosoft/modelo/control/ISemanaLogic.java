package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.Semana;
import co.com.arcosoft.modelo.dto.SemanaDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ISemanaLogic {
	public List<Semana> getSemana() throws Exception;

	/**
	 * Save an new Semana entity
	 */
	public void saveSemana(Semana entity) throws Exception;

	/**
	 * Delete an existing Semana entity
	 *
	 */
	public void deleteSemana(Semana entity) throws Exception;

	/**
	 * Update an existing Semana entity
	 *
	 */
	public void updateSemana(Semana entity) throws Exception;

	/**
	 * Load an existing Semana entity
	 *
	 */
	public Semana getSemana(Long semanaId) throws Exception;

	public List<Semana> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Semana> findPageSemana(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberSemana() throws Exception;

	public List<SemanaDTO> getDataSemana() throws Exception;
}
