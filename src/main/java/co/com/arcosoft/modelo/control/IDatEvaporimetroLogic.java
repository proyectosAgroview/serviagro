package co.com.arcosoft.modelo.control;

import java.util.List;
import java.util.Map;

import co.com.arcosoft.modelo.DatEvaporimetro;
import co.com.arcosoft.modelo.dto.DatEvaporimetroDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDatEvaporimetroLogic {
	public List<DatEvaporimetro> getDatEvaporimetro() throws Exception;

	/**
	 * Save an new DatEvaporimetro entity
	 */
	public void saveDatEvaporimetro(DatEvaporimetro entity) throws Exception;

	/**
	 * Delete an existing DatEvaporimetro entity
	 *
	 */
	public void deleteDatEvaporimetro(DatEvaporimetro entity) throws Exception;

	/**
	 * Update an existing DatEvaporimetro entity
	 *
	 */
	public void updateDatEvaporimetro(DatEvaporimetro entity) throws Exception;

	/**
	 * Load an existing DatEvaporimetro entity
	 *
	 */
	public DatEvaporimetro getDatEvaporimetro(Long datEvaporimetroId) throws Exception;

	public List<DatEvaporimetro> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatEvaporimetro> findPageDatEvaporimetro(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatEvaporimetro() throws Exception;

	public List<DatEvaporimetroDTO> getDataDatEvaporimetro() throws Exception;

	public List<DatEvaporimetroDTO> findByCriteriaPageDatEvaporimetro(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception;

	public Long findTotalNumberDatEvaporimetro(Map<String, Object> filters) throws Exception;

}
