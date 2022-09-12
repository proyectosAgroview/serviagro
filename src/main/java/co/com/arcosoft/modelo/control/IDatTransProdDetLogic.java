package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatTransProdDet;
import co.com.arcosoft.modelo.dto.DatTransProdDetDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDatTransProdDetLogic {
	public List<DatTransProdDet> getDatTransProdDet() throws Exception;

	/**
	 * Save an new DatTransProdDet entity
	 */
	public void saveDatTransProdDet(DatTransProdDet entity) throws Exception;

	/**
	 * Delete an existing DatTransProdDet entity
	 *
	 */
	public void deleteDatTransProdDet(DatTransProdDet entity) throws Exception;

	/**
	 * Update an existing DatTransProdDet entity
	 *
	 */
	public void updateDatTransProdDet(DatTransProdDet entity) throws Exception;

	/**
	 * Load an existing DatTransProdDet entity
	 *
	 */
	public DatTransProdDet getDatTransProdDet(Long datTransProdDetId) throws Exception;

	public List<DatTransProdDet> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatTransProdDet> findPageDatTransProdDet(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatTransProdDet() throws Exception;

	public List<DatTransProdDetDTO> getDataDatTransProdDet() throws Exception;

	public List<DatTransProdDetDTO> getDataDetTransProductosByDatTransProdId(Long datTransProdId) throws Exception;

}
