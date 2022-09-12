package co.com.arcosoft.modelo.control;

import co.com.arcosoft.modelo.DatCheckListEquipoLabor;
import co.com.arcosoft.modelo.dto.DatCheckListEquipoLaborDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatCheckListEquipoLaborLogic {
    public List<DatCheckListEquipoLabor> getDatCheckListEquipoLabor()
        throws Exception;

    /**
         * Save an new DatCheckListEquipoLabor entity
         */
    public void saveDatCheckListEquipoLabor(DatCheckListEquipoLabor entity)
        throws Exception;

    /**
         * Delete an existing DatCheckListEquipoLabor entity
         *
         */
    public void deleteDatCheckListEquipoLabor(DatCheckListEquipoLabor entity)
        throws Exception;

    /**
        * Update an existing DatCheckListEquipoLabor entity
        *
        */
    public void updateDatCheckListEquipoLabor(DatCheckListEquipoLabor entity)
        throws Exception;

    /**
         * Load an existing DatCheckListEquipoLabor entity
         *
         */
    public DatCheckListEquipoLabor getDatCheckListEquipoLabor(
        Long datCheckListEquipoLabor) throws Exception;

    public List<DatCheckListEquipoLabor> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatCheckListEquipoLabor> findPageDatCheckListEquipoLabor(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatCheckListEquipoLabor()
        throws Exception;

    public List<DatCheckListEquipoLaborDTO> getDataDatCheckListEquipoLabor()
        throws Exception;
    
    public List<DatCheckListEquipoLaborDTO> getDataDatCheckListEquipoLaborByEquipo(Long checkListEquipoId)
        throws Exception;
}
