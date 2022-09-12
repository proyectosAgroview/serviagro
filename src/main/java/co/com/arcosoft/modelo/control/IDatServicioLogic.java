package co.com.arcosoft.modelo.control;

import java.util.List;
import java.util.Map;

import co.com.arcosoft.modelo.DatServicio;
import co.com.arcosoft.modelo.dto.DatServicioDTO;
import co.com.arcosoft.modelo.dto.DatServicioDetDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDatServicioLogic {
	public List<DatServicio> getDatServicio() throws Exception;

	/**
	 * Save an new DatServicio entity
	 */
	public void saveDatServicio(DatServicio entity, List<DatServicioDetDTO> dataDetServicio) throws Exception;

	/**
	 * Delete an existing DatServicio entity
	 *
	 */
	public void deleteDatServicio(DatServicio entity) throws Exception;

	/**
	 * Update an existing DatServicio entity
	 *
	 */
	public void updateDatServicio(DatServicio entity, List<DatServicioDetDTO> dataDetServicio) throws Exception;

	/**
	 * Load an existing DatServicio entity
	 *
	 */
	public DatServicio getDatServicio(Long datServicioId) throws Exception;

	public List<DatServicio> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatServicio> findPageDatServicio(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatServicio() throws Exception;

	public List<DatServicioDTO> getDataDatServicio() throws Exception;

	public List<DatServicioDTO> findByCriteriaPageServicio(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception;

	public Long findTotalNumberServicio(Map<String, Object> filters) throws Exception;

}
