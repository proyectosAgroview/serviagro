package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatOtrosCostos;
import co.com.arcosoft.modelo.dto.DatOtrosCostosDTO;
import co.com.arcosoft.modelo.dto.DatOtrosCostosDetalleDTO;
import co.com.arcosoft.modelo.dto.DatOtrosCostosNivel4DTO;
import co.com.arcosoft.modelo.informes.dto.ListaNivel4DTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDatOtrosCostosLogic {
	public List<DatOtrosCostos> getDatOtrosCostos() throws Exception;

	/**
	 * Save an new DatOtrosCostos entity
	 */
	public void saveDatOtrosCostos(DatOtrosCostos entity, List<DatOtrosCostosNivel4DTO> dataNivel4,
			List<DatOtrosCostosDetalleDTO> dataDetalle) throws Exception;

	/**
	 * Delete an existing DatOtrosCostos entity
	 *
	 */
	public void deleteDatOtrosCostos(DatOtrosCostos entity) throws Exception;

	/**
	 * Update an existing DatOtrosCostos entity
	 *
	 */
	public void updateDatOtrosCostos(DatOtrosCostos entity, List<DatOtrosCostosNivel4DTO> dataNivel4,
			List<DatOtrosCostosDetalleDTO> dataDetalle) throws Exception;

	/**
	 * Load an existing DatOtrosCostos entity
	 *
	 */
	public DatOtrosCostos getDatOtrosCostos(Long datOtrosCostosId) throws Exception;

	public List<DatOtrosCostos> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatOtrosCostos> findPageDatOtrosCostos(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatOtrosCostos() throws Exception;

	public List<DatOtrosCostosDTO> getDataDatOtrosCostos() throws Exception;

	public void saveDatOtrosCostosVer2(DatOtrosCostos entity, List<ListaNivel4DTO> dataLotes,
			List<DatOtrosCostosDetalleDTO> dataDetalle) throws Exception;

	public void updateDatOtrosCostosVer2(DatOtrosCostos entity, List<ListaNivel4DTO> dataLotes,
			List<DatOtrosCostosDetalleDTO> dataDetalle) throws Exception;

}
