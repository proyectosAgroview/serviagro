package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatServRealizadosEquipo;
import co.com.arcosoft.modelo.dto.DatServRealizadosEquipoDTO;
import co.com.arcosoft.modelo.dto.DatServRealizadosEquipoDetDTO;
import co.com.arcosoft.modelo.dto.PrecioPromProdDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatServRealizadosEquipoLogic {
    public List<DatServRealizadosEquipo> getDatServRealizadosEquipo()
        throws Exception;

    /**
         * Save an new DatServRealizadosEquipo entity
         */
    public void saveDatServRealizadosEquipo(DatServRealizadosEquipo entity, List<DatServRealizadosEquipoDetDTO> dataServDet,
    		List<PrecioPromProdDTO> dataDetPrecioProductos)
        throws Exception;

    /**
         * Delete an existing DatServRealizadosEquipo entity
         *
         */
    public void deleteDatServRealizadosEquipo(DatServRealizadosEquipo entity)
        throws Exception;

    /**
        * Update an existing DatServRealizadosEquipo entity
        *
        */
    public void updateDatServRealizadosEquipo(DatServRealizadosEquipo entity, List<DatServRealizadosEquipoDetDTO> dataServDet,
    		List<PrecioPromProdDTO> dataDetPrecioProductos)
        throws Exception;

    /**
         * Load an existing DatServRealizadosEquipo entity
         *
         */
    public DatServRealizadosEquipo getDatServRealizadosEquipo(
        Long datServRealizadosEquipoId) throws Exception;

    public List<DatServRealizadosEquipo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatServRealizadosEquipo> findPageDatServRealizadosEquipo(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatServRealizadosEquipo()
        throws Exception;

    public List<DatServRealizadosEquipoDTO> getDataDatServRealizadosEquipo()
        throws Exception;
    
    
    
}
