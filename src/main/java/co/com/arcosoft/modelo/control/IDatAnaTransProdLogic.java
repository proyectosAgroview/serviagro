package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatAnaTransProd;
import co.com.arcosoft.modelo.dto.DatAnaTransProdDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDatAnaTransProdLogic {
	public List<DatAnaTransProd> getDatAnaTransProd() throws Exception;

	/**
	 * Save an new DatAnaTransProd entity
	 */
	public void saveDatAnaTransProd(DatAnaTransProd entity) throws Exception;

	/**
	 * Delete an existing DatAnaTransProd entity
	 *
	 */
	public void deleteDatAnaTransProd(DatAnaTransProd entity) throws Exception;

	/**
	 * Update an existing DatAnaTransProd entity
	 *
	 */
	public void updateDatAnaTransProd(DatAnaTransProd entity) throws Exception;

	/**
	 * Load an existing DatAnaTransProd entity
	 *
	 */
	public DatAnaTransProd getDatAnaTransProd(Long datAnaTransProdId) throws Exception;

	public List<DatAnaTransProd> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatAnaTransProd> findPageDatAnaTransProd(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatAnaTransProd() throws Exception;

	public List<DatAnaTransProdDTO> getDataDatAnaTransProd() throws Exception;
}
