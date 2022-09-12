package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatPlanServiciosMqdetEjec;
import co.com.arcosoft.modelo.dto.DatPlanServiciosMqdetEjecDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatPlanServiciosMqdetEjecLogic {
    public List<DatPlanServiciosMqdetEjec> getDatPlanServiciosMqdetEjec()
        throws Exception;

    /**
         * Save an new DatPlanServiciosMqdetEjec entity
         */
    public void saveDatPlanServiciosMqdetEjec(DatPlanServiciosMqdetEjec entity)
        throws Exception;

    /**
         * Delete an existing DatPlanServiciosMqdetEjec entity
         *
         */
    public void deleteDatPlanServiciosMqdetEjec(
        DatPlanServiciosMqdetEjec entity) throws Exception;

    /**
        * Update an existing DatPlanServiciosMqdetEjec entity
        *
        */
    public void updateDatPlanServiciosMqdetEjec(
        DatPlanServiciosMqdetEjec entity) throws Exception;

    /**
         * Load an existing DatPlanServiciosMqdetEjec entity
         *
         */
    public DatPlanServiciosMqdetEjec getDatPlanServiciosMqdetEjec(
        Long datPlanServiciosMqdetEjecId) throws Exception;

    public List<DatPlanServiciosMqdetEjec> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatPlanServiciosMqdetEjec> findPageDatPlanServiciosMqdetEjec(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatPlanServiciosMqdetEjec()
        throws Exception;

    public List<DatPlanServiciosMqdetEjecDTO> getDataDatPlanServiciosMqdetEjec()
        throws Exception;
}
