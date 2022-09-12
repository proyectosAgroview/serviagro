package co.com.arcosoft.modelo.control;

import java.util.List;
import java.util.Map;

import co.com.arcosoft.modelo.DatTransProd;
import co.com.arcosoft.modelo.dto.DatTransProdDTO;
import co.com.arcosoft.modelo.dto.DatTransProdDetDTO;
import co.com.arcosoft.modelo.dto.DatTransProdNivel4DTO;
import co.com.arcosoft.modelo.dto.DatTransProdTrabajadoresDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDatTransProdLogic {
	public List<DatTransProd> getDatTransProd() throws Exception;

	/**
	 * Save an new DatTransProd entity
	 * 
	 * @throws Exception
	 */
	public void saveDatTransProd(DatTransProd entity, List<DatTransProdDetDTO> dataDetTransProductos,
			List<DatTransProdNivel4DTO> dataDetTransNivel4,List<DatTransProdTrabajadoresDTO> dataPlanillaDet) throws Exception;

	/**
	 * Delete an existing DatTransProd entity
	 *
	 */
	public void deleteDatTransProd(DatTransProd entity) throws Exception;

	/**
	 * Update an existing DatTransProd entity
	 * 
	 * @throws Exception
	 * 
	 *
	 */
	public void updateDatTransProd(DatTransProd entity, List<DatTransProdDetDTO> dataDetTransProductos,
			List<DatTransProdNivel4DTO> dataDetTransNivel4,List<DatTransProdTrabajadoresDTO> dataPlanillaDet) throws Exception;

	/**
	 * Load an existing DatTransProd entity
	 *
	 */
	public DatTransProd getDatTransProd(Long datTransProdId) throws Exception;

	public List<DatTransProd> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatTransProd> findPageDatTransProd(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatTransProd() throws Exception;

	public List<DatTransProdDTO> getDataDatTransProd() throws Exception;

	public List<DatTransProdDTO> findByCriteriaPageDatTransProd(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception;

	public Long findTotalNumberDatTransProd(Map<String, Object> filters) throws Exception;

}
