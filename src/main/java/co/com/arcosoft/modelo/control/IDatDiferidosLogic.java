package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatDiferidos;
import co.com.arcosoft.modelo.dto.DatDiferidosCuotasDTO;
import co.com.arcosoft.modelo.dto.DatDiferidosDTO;
import co.com.arcosoft.modelo.dto.DatDiferidosDetDTO;
import co.com.arcosoft.modelo.informes.dto.ListaEquiposCategoriaDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatDiferidosLogic {
    public List<DatDiferidos> getDatDiferidos() throws Exception;

    /**
         * Save an new DatDiferidos entity
         */

    /**
         * Delete an existing DatDiferidos entity
         *
         */
    public void deleteDatDiferidos(DatDiferidos entity)
        throws Exception;

 

    public void saveDatDiferidos(DatDiferidos entity,  List<DatDiferidosDetDTO> dataDet, List<DatDiferidosCuotasDTO> dataCuotas) throws Exception ;
    public void updateDatDiferidos(DatDiferidos entity,  List<DatDiferidosDetDTO> dataDet, List<DatDiferidosCuotasDTO> dataCuotas) throws Exception ;
    		   	   
    	
    /**
         * Load an existing DatDiferidos entity
         *
         */
    public DatDiferidos getDatDiferidos(Long datDiferidosId)
        throws Exception;

    public List<DatDiferidos> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatDiferidos> findPageDatDiferidos(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberDatDiferidos() throws Exception;

    public List<DatDiferidosDTO> getDataDatDiferidos()
        throws Exception;
    
    public void saveDatDiferidosVer2(DatDiferidos entity,   List<ListaEquiposCategoriaDTO> dataDistr,
       		List<DatDiferidosCuotasDTO> dataCuotas
       		
       		) throws Exception ;
    
    
    public void updateDatDiferidosVer2(DatDiferidos entity,   List<ListaEquiposCategoriaDTO> dataDistr,
       		List<DatDiferidosCuotasDTO> dataCuotas
       		
       		) throws Exception ;
}
