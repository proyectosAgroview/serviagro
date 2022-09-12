package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatTransProdNivel4;
import co.com.arcosoft.modelo.dto.DatTransProdNivel4DTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDatTransProdNivel4Logic {
	public List<DatTransProdNivel4> getDatTransProdNivel4() throws Exception;

	/**
	 * Save an new DatTransProdNivel4 entity
	 */
	public void saveDatTransProdNivel4(DatTransProdNivel4 entity) throws Exception;

	/**
	 * Delete an existing DatTransProdNivel4 entity
	 *
	 */
	public void deleteDatTransProdNivel4(DatTransProdNivel4 entity) throws Exception;

	/**
	 * Update an existing DatTransProdNivel4 entity
	 *
	 */
	public void updateDatTransProdNivel4(DatTransProdNivel4 entity) throws Exception;

	/**
	 * Load an existing DatTransProdNivel4 entity
	 *
	 */
	public DatTransProdNivel4 getDatTransProdNivel4(Long datTransProdNivel4Id) throws Exception;

	public List<DatTransProdNivel4> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatTransProdNivel4> findPageDatTransProdNivel4(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatTransProdNivel4() throws Exception;

	public List<DatTransProdNivel4DTO> getDataDatTransProdNivel4() throws Exception;

	public List<DatTransProdNivel4DTO> getDataDatTransProdNivel4ByNivel4Id(Long datTransProdId) throws Exception;
}
