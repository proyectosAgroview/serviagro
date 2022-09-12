package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.EstructSiemb;
import co.com.arcosoft.modelo.dto.EstructSiembDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IEstructSiembLogic {
	public List<EstructSiemb> getEstructSiemb() throws Exception;

	/**
	 * Save an new EstructSiemb entity
	 */
	public void saveEstructSiemb(EstructSiemb entity) throws Exception;

	/**
	 * Delete an existing EstructSiemb entity
	 *
	 */
	public void deleteEstructSiemb(EstructSiemb entity) throws Exception;

	/**
	 * Update an existing EstructSiemb entity
	 *
	 */
	public void updateEstructSiemb(EstructSiemb entity) throws Exception;

	/**
	 * Load an existing EstructSiemb entity
	 *
	 */
	public EstructSiemb getEstructSiemb(Long estrSiembId) throws Exception;

	public List<EstructSiemb> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<EstructSiemb> findPageEstructSiemb(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberEstructSiemb() throws Exception;

	public List<EstructSiembDTO> getDataEstructSiemb() throws Exception;
}
