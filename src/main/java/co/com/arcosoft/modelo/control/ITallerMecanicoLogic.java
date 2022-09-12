package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.TallerMecanico;
import co.com.arcosoft.modelo.dto.TallerMecanicoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ITallerMecanicoLogic {
	public List<TallerMecanico> getTallerMecanico() throws Exception;

	/**
	 * Save an new TallerMecanico entity
	 */
	public void saveTallerMecanico(TallerMecanico entity) throws Exception;

	/**
	 * Delete an existing TallerMecanico entity
	 *
	 */
	public void deleteTallerMecanico(TallerMecanico entity) throws Exception;

	/**
	 * Update an existing TallerMecanico entity
	 *
	 */
	public void updateTallerMecanico(TallerMecanico entity) throws Exception;

	/**
	 * Load an existing TallerMecanico entity
	 *
	 */
	public TallerMecanico getTallerMecanico(Long tallerMecanicoId) throws Exception;

	public List<TallerMecanico> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TallerMecanico> findPageTallerMecanico(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTallerMecanico() throws Exception;

	public List<TallerMecanicoDTO> getDataTallerMecanico() throws Exception;
}
