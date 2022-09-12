package co.com.arcosoft.modelo.control;

import co.com.arcosoft.modelo.DatCheckListEquipo;
import co.com.arcosoft.modelo.dto.DatCheckListEquipoDTO;
import co.com.arcosoft.modelo.dto.DatCheckListEquipoDetDTO;
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
public interface IDatCheckListEquipoLogic {
    public List<DatCheckListEquipo> getDatCheckListEquipo()
        throws Exception;

    /**
         * Save an new DatCheckListEquipo entity
         */
    public void saveDatCheckListEquipo(DatCheckListEquipo entity, List<DatCheckListEquipoLaborDTO> dataDatCheckListEquipoLabor,
    		List<DatCheckListEquipoDetDTO> dataDatCheckListEquipoDet)
        throws Exception;

    /**
         * Delete an existing DatCheckListEquipo entity
         *
         */
    public void deleteDatCheckListEquipo(DatCheckListEquipo entity)
        throws Exception;

    /**
        * Update an existing DatCheckListEquipo entity
        *
        */
    public void updateDatCheckListEquipo(DatCheckListEquipo entity, List<DatCheckListEquipoLaborDTO> dataDatCheckListEquipoLabor,
    		List<DatCheckListEquipoDetDTO> dataDatCheckListEquipoDet)
        throws Exception;

    /**
         * Load an existing DatCheckListEquipo entity
         *
         */
    public DatCheckListEquipo getDatCheckListEquipo(Long datCheckListEquipoId)
        throws Exception;

    public List<DatCheckListEquipo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatCheckListEquipo> findPageDatCheckListEquipo(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatCheckListEquipo() throws Exception;

    public List<DatCheckListEquipoDTO> getDataDatCheckListEquipo()
        throws Exception;
}
