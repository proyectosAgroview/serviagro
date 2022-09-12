package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatOtrosCostosMq;
import co.com.arcosoft.modelo.dto.DatOtrosCostosMqDTO;
import co.com.arcosoft.modelo.dto.DatOtrosCostosMqdetDTO;
import co.com.arcosoft.modelo.dto.DatOtrosCostosMqdetDistribuccionDTO;
import co.com.arcosoft.modelo.informes.dto.ListaEquiposCategoriaDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatOtrosCostosMqLogic {
    public List<DatOtrosCostosMq> getDatOtrosCostosMq()
        throws Exception;

    /**
         * Save an new DatOtrosCostosMq entity
         */
    public void saveDatOtrosCostosMq(DatOtrosCostosMq entity,  List<DatOtrosCostosMqdetDTO> dataMqdet ,  List<DatOtrosCostosMqdetDistribuccionDTO> dataDistr)
        throws Exception;

    /**
         * Delete an existing DatOtrosCostosMq entity
         *
         */
    public void deleteDatOtrosCostosMq(DatOtrosCostosMq entity)
        throws Exception;

    /**
        * Update an existing DatOtrosCostosMq entity
        *
        */
    public void updateDatOtrosCostosMq(DatOtrosCostosMq entity,  List<DatOtrosCostosMqdetDTO> dataMqdet,  List<DatOtrosCostosMqdetDistribuccionDTO> dataDistr)
        throws Exception;

    /**
         * Load an existing DatOtrosCostosMq entity
         *
         */
    public DatOtrosCostosMq getDatOtrosCostosMq(Long datOtrosCostosMqId)
        throws Exception;

    public List<DatOtrosCostosMq> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatOtrosCostosMq> findPageDatOtrosCostosMq(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatOtrosCostosMq() throws Exception;


	public List<DatOtrosCostosMqDTO> getDataDatOtrosCostosMq() throws Exception;
	
	 public void saveDatOtrosCostosMqVer2(DatOtrosCostosMq entity, List<DatOtrosCostosMqdetDTO> dataMqdet, List<ListaEquiposCategoriaDTO> dataDistr)
	           throws Exception;
	 public void updateDatOtrosCostosMqVer2(DatOtrosCostosMq entity,  List<DatOtrosCostosMqdetDTO> dataMqdet, List<ListaEquiposCategoriaDTO> dataDistr)
	           throws Exception;

}
