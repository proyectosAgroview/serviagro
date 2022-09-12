package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatSanVeg;
import co.com.arcosoft.modelo.dto.DatSanVegDTO;
import co.com.arcosoft.modelo.dto.ValorVarDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDatSanVegLogic {
	public List<DatSanVeg> getDatSanVeg() throws Exception;

	/**
	 * Save an new DatSanVeg entity
	 */
	public void saveDatSanVeg(DatSanVeg entity, List<ValorVarDTO> dataValor) throws Exception;

	/**
	 * Delete an existing DatSanVeg entity
	 *
	 */
	public void deleteDatSanVeg(DatSanVeg entity) throws Exception;

	/**
	 * Update an existing DatSanVeg entity
	 *
	 */
	public void updateDatSanVeg(DatSanVeg entity, List<ValorVarDTO> dataValor) throws Exception;

	/**
	 * Load an existing DatSanVeg entity
	 *
	 */
	public DatSanVeg getDatSanVeg(Long datSanVegId) throws Exception;

	public List<DatSanVeg> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<DatSanVeg> findPageDatSanVeg(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberDatSanVeg() throws Exception;

	public List<DatSanVegDTO> getDataDatSanVeg(Long idAnalisis) throws Exception;
}
