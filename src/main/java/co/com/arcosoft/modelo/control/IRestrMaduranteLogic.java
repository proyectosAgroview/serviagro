package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.RestrMadurante;
import co.com.arcosoft.modelo.dto.RestrMaduranteDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IRestrMaduranteLogic {
	public List<RestrMadurante> getRestrMadurante() throws Exception;

	/**
	 * Save an new RestrMadurante entity
	 */
	public void saveRestrMadurante(RestrMadurante entity) throws Exception;

	/**
	 * Delete an existing RestrMadurante entity
	 *
	 */
	public void deleteRestrMadurante(RestrMadurante entity) throws Exception;

	/**
	 * Update an existing RestrMadurante entity
	 *
	 */
	public void updateRestrMadurante(RestrMadurante entity) throws Exception;

	/**
	 * Load an existing RestrMadurante entity
	 *
	 */
	public RestrMadurante getRestrMadurante(Long restMaduId) throws Exception;

	public List<RestrMadurante> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<RestrMadurante> findPageRestrMadurante(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberRestrMadurante() throws Exception;

	public List<RestrMaduranteDTO> getDataRestrMadurante() throws Exception;
}
