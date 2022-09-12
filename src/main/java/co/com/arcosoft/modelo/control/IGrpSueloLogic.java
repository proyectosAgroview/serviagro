package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.GrpSuelo;
import co.com.arcosoft.modelo.LaraEdad;
import co.com.arcosoft.modelo.dto.GrpSueloDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IGrpSueloLogic {
	public List<GrpSuelo> getGrpSuelo() throws Exception;

	/**
	 * Save an new GrpSuelo entity
	 */
	public void saveGrpSuelo(GrpSuelo entity, LaraEdad entity2) throws Exception;

	/**
	 * Delete an existing GrpSuelo entity
	 *
	 */
	public void deleteGrpSuelo(GrpSuelo entity) throws Exception;

	/**
	 * Update an existing GrpSuelo entity
	 *
	 */
	public void updateGrpSuelo(GrpSuelo entity, LaraEdad entity2) throws Exception;

	/**
	 * Load an existing GrpSuelo entity
	 *
	 */
	public GrpSuelo getGrpSuelo(Long grupoSuelo) throws Exception;

	public List<GrpSuelo> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<GrpSuelo> findPageGrpSuelo(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberGrpSuelo() throws Exception;

	public List<GrpSueloDTO> getDataGrpSuelo() throws Exception;
}
