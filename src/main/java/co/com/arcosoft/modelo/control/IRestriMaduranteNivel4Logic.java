package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.RestriMaduranteNivel4;
import co.com.arcosoft.modelo.RestriMaduranteNivel4Id;
import co.com.arcosoft.modelo.dto.RestriMaduranteNivel4DTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IRestriMaduranteNivel4Logic {
	public List<RestriMaduranteNivel4> getRestriMaduranteNivel4() throws Exception;

	/**
	 * Save an new RestriMaduranteNivel4 entity
	 */
	public void saveRestriMaduranteNivel4(RestriMaduranteNivel4 entity) throws Exception;

	/**
	 * Delete an existing RestriMaduranteNivel4 entity
	 *
	 */
	public void deleteRestriMaduranteNivel4(RestriMaduranteNivel4 entity) throws Exception;

	/**
	 * Update an existing RestriMaduranteNivel4 entity
	 *
	 */
	public void updateRestriMaduranteNivel4(RestriMaduranteNivel4 entity) throws Exception;

	/**
	 * Load an existing RestriMaduranteNivel4 entity
	 *
	 */
	public RestriMaduranteNivel4 getRestriMaduranteNivel4(RestriMaduranteNivel4Id id) throws Exception;

	public List<RestriMaduranteNivel4> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<RestriMaduranteNivel4> findPageRestriMaduranteNivel4(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberRestriMaduranteNivel4() throws Exception;

	public List<RestriMaduranteNivel4DTO> getDataRestriMaduranteNivel4() throws Exception;
}
