package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatTransProdTrabajadores;
import co.com.arcosoft.modelo.dto.DatTransProdTrabajadoresDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDatTransProdTrabajadoresLogic {
	public List<DatTransProdTrabajadores> getDatTransProdTrabajadores() throws Exception;

	/**
	 * Save an new DatTransProdTrabajadores entity
	 */
	public void saveDatTransProdTrabajadores(DatTransProdTrabajadores entity) throws Exception;

	/**
	 * Delete an existing DatTransProdTrabajadores entity
	 *
	 */
	public void deleteDatTransProdTrabajadores(DatTransProdTrabajadores entity) throws Exception;

	/**
	 * Update an existing DatTransProdTrabajadores entity
	 *
	 */
	public void updateDatTransProdTrabajadores(DatTransProdTrabajadores entity) throws Exception;

	/**
	 * Load an existing DatTransProdTrabajadores entity
	 *
	 */
	public DatTransProdTrabajadores getDatTransProdTrabajadores(Long datTransProdTrabajadoresId) throws Exception;

	public List<DatTransProdTrabajadores> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatTransProdTrabajadores> findPageDatTransProdTrabajadores(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatTransProdTrabajadores() throws Exception;

	public List<DatTransProdTrabajadoresDTO> getDataDatTransProdTrabajadores() throws Exception;
	public List<DatTransProdTrabajadoresDTO> getDataDatTransProdTrabajadoresByTrabajador(Long  datTransProdId) throws Exception;

}
