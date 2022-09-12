package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.dto.UdadMedDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IUdadMedLogic {
	public List<UdadMed> getUdadMed() throws Exception;

	/**
	 * Save an new UdadMed entity
	 */
	public void saveUdadMed(UdadMed entity) throws Exception;

	/**
	 * Delete an existing UdadMed entity
	 *
	 */
	public void deleteUdadMed(UdadMed entity) throws Exception;

	/**
	 * Update an existing UdadMed entity
	 *
	 */
	public void updateUdadMed(UdadMed entity) throws Exception;

	/**
	 * Load an existing UdadMed entity
	 *
	 */
	public UdadMed getUdadMed(Long udadMedId) throws Exception;

	public List<UdadMed> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<UdadMed> findPageUdadMed(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberUdadMed() throws Exception;

	public List<UdadMedDTO> getDataUdadMed() throws Exception;
}
