package co.com.arcosoft.modelo.control;

import co.com.arcosoft.modelo.DatMantenimientoEquipoPlanRevision;
import co.com.arcosoft.modelo.dto.DatMantenimientoEquipoPlanRevisionDTO;

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
public interface IDatMantenimientoEquipoPlanRevisionLogic {
    public List<DatMantenimientoEquipoPlanRevision> getDatMantenimientoEquipoPlanRevision()
        throws Exception;

    /**
         * Save an new DatMantenimientoEquipoPlanRevision entity
         */
    public void saveDatMantenimientoEquipoPlanRevision(
        DatMantenimientoEquipoPlanRevision entity) throws Exception;

    /**
         * Delete an existing DatMantenimientoEquipoPlanRevision entity
         *
         */
    public void deleteDatMantenimientoEquipoPlanRevision(
        DatMantenimientoEquipoPlanRevision entity) throws Exception;

    /**
        * Update an existing DatMantenimientoEquipoPlanRevision entity
        *
        */
    public void updateDatMantenimientoEquipoPlanRevision(
        DatMantenimientoEquipoPlanRevision entity) throws Exception;

    /**
         * Load an existing DatMantenimientoEquipoPlanRevision entity
         *
         */
    public DatMantenimientoEquipoPlanRevision getDatMantenimientoEquipoPlanRevision(
        Long datManPlanRevivionId) throws Exception;

    public List<DatMantenimientoEquipoPlanRevision> findByCriteria(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<DatMantenimientoEquipoPlanRevision> findPageDatMantenimientoEquipoPlanRevision(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatMantenimientoEquipoPlanRevision()
        throws Exception;

    public List<DatMantenimientoEquipoPlanRevisionDTO> getDataDatMantenimientoEquipoPlanRevision()
        throws Exception;
    
    public List<DatMantenimientoEquipoPlanRevisionDTO> getDataDatMantenimientoEquipoPlanRevisionByMec(Long mantenimientoEquipoId)
        throws Exception;
}
