package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.IngrActivProd;
import co.com.arcosoft.modelo.IngrActivProdId;
import co.com.arcosoft.modelo.dto.IngrActivProdDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IIngrActivProdLogic {
	public List<IngrActivProd> getIngrActivProd() throws Exception;

	/**
	 * Save an new IngrActivProd entity
	 */
	public void saveIngrActivProd(IngrActivProd entity) throws Exception;

	/**
	 * Delete an existing IngrActivProd entity
	 *
	 */
	public void deleteIngrActivProd(IngrActivProd entity) throws Exception;

	/**
	 * Update an existing IngrActivProd entity
	 *
	 */
	public void updateIngrActivProd(IngrActivProd entity) throws Exception;

	/**
	 * Load an existing IngrActivProd entity
	 *
	 */
	public IngrActivProd getIngrActivProd(IngrActivProdId id) throws Exception;

	public List<IngrActivProd> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<IngrActivProd> findPageIngrActivProd(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberIngrActivProd() throws Exception;

	public List<IngrActivProdDTO> getDataIngrActivProd() throws Exception;
}
