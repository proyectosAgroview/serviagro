package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.NivelFertilidad;
import co.com.arcosoft.modelo.dto.NivelFertilidadDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface INivelFertilidadLogic {
	public List<NivelFertilidad> getNivelFertilidad() throws Exception;

	/**
	 * Save an new NivelFertilidad entity
	 */
	public void saveNivelFertilidad(NivelFertilidad entity) throws Exception;

	/**
	 * Delete an existing NivelFertilidad entity
	 *
	 */
	public void deleteNivelFertilidad(NivelFertilidad entity) throws Exception;

	/**
	 * Update an existing NivelFertilidad entity
	 *
	 */
	public void updateNivelFertilidad(NivelFertilidad entity) throws Exception;

	/**
	 * Load an existing NivelFertilidad entity
	 *
	 */
	public NivelFertilidad getNivelFertilidad(Long nivelFertilidadId) throws Exception;

	public List<NivelFertilidad> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<NivelFertilidad> findPageNivelFertilidad(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberNivelFertilidad() throws Exception;

	public List<NivelFertilidadDTO> getDataNivelFertilidad() throws Exception;
}
