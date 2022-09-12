package co.com.arcosoft.modelo.control;

import co.com.arcosoft.dataaccess.dao.*;
import co.com.arcosoft.exceptions.*;
import co.com.arcosoft.modelo.*;
import co.com.arcosoft.modelo.dto.PrecioPromMateriaPrimaDTO;
import co.com.arcosoft.utilities.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("PrecioPromMateriaPrimaLogic")
public class PrecioPromMateriaPrimaLogic implements IPrecioPromMateriaPrimaLogic {
    private static final Logger log = LoggerFactory.getLogger(PrecioPromMateriaPrimaLogic.class);

    /**
     * DAO injected by Spring that manages PrecioPromMateriaPrima entities
     *
     */
    @Autowired
    private IPrecioPromMateriaPrimaDAO precioPromMateriaPrimaDAO;

    @Autowired
    IDatOtrosMovInventarioLogic logicDatOtrosMovInventario1;

    @Autowired
    INivel2Logic logicNivel22;

    @Autowired
    INivel4Logic logicNivel43;

    @Autowired
    IPersEmprLogic logicPersEmpr4;

    @Autowired
    IProductoLogic logicProducto5;

    @Autowired
    ITrabajadorLogic logicTrabajador6;

    @Autowired
    IAlmacenLogic logicAlmacen7;

    @Autowired
    IUbicacionesAlmacenLogic logicUbicacionesAlmacen8;

    @Autowired
    IUdadMedLogic logicUdadMed9;

    @Transactional(readOnly = true)
    public List<PrecioPromMateriaPrima> getPrecioPromMateriaPrima()
        throws Exception {
        log.debug("finding all PrecioPromMateriaPrima instances");

        List<PrecioPromMateriaPrima> list = new ArrayList<PrecioPromMateriaPrima>();

        try {
            list = precioPromMateriaPrimaDAO.findAll();
        } catch (Exception e) {
            log.error("finding all PrecioPromMateriaPrima failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "PrecioPromMateriaPrima");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void savePrecioPromMateriaPrima(PrecioPromMateriaPrima entity)
        throws Exception {
        log.debug("saving PrecioPromMateriaPrima instance");

        try {

            if ((entity.getCantidadCompra() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getCantidadCompra(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "cantidadCompra");
            }

            if ((entity.getCostoTotal() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getCostoTotal(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "costoTotal");
            }

            if ((entity.getDiferido() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDiferido(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException("diferido");
            }

            if ((entity.getHorometroAbastecimiento() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getHorometroAbastecimiento(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "horometroAbastecimiento");
            }

            if ((entity.getInfoAdicional() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getInfoAdicional(), 1000) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "infoAdicional");
            }

            if ((entity.getInfoAdicional2() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getInfoAdicional2(), 1000) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "infoAdicional2");
            }

            if ((entity.getLoteCompraProducto() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getLoteCompraProducto(), 90) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "loteCompraProducto");
            }

            if ((entity.getOrigenDatos() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getOrigenDatos(), 60) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "origenDatos");
            }

            if ((entity.getPorcIva() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getPorcIva(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException("porcIva");
            }

            if ((entity.getRegistroIca() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getRegistroIca(), 90) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "registroIca");
            }

            if ((entity.getTipoMovimiento() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTipoMovimiento(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "tipoMovimiento");
            }

            if ((entity.getTransportadoraFactura() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTransportadoraFactura(), 300) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "transportadoraFactura");
            }

            if ((entity.getTransportadoraNguia() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTransportadoraNguia(), 300) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "transportadoraNguia");
            }

            if ((entity.getTransportadoraValorFlete() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getTransportadoraValorFlete(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "transportadoraValorFlete");
            }

            if ((entity.getValorIva() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorIva(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException("valorIva");
            }

            if ((entity.getValorUnitario() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorUnitario(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorUnitario");
            }

            precioPromMateriaPrimaDAO.save(entity);

            log.debug("save PrecioPromMateriaPrima successful");
        } catch (Exception e) {
            log.error("save PrecioPromMateriaPrima failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deletePrecioPromMateriaPrima(PrecioPromMateriaPrima entity)
        throws Exception {
        log.debug("deleting PrecioPromMateriaPrima instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "PrecioPromMateriaPrima");
        }

        if (entity.getPrecioPromMateriaPrimaId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "precioPromMateriaPrimaId");
        }

        try {
            precioPromMateriaPrimaDAO.delete(entity);

            log.debug("delete PrecioPromMateriaPrima successful");
        } catch (Exception e) {
            log.error("delete PrecioPromMateriaPrima failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updatePrecioPromMateriaPrima(PrecioPromMateriaPrima entity)
        throws Exception {
        log.debug("updating PrecioPromMateriaPrima instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "PrecioPromMateriaPrima");
            }

            if ((entity.getCantidadCompra() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getCantidadCompra(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "cantidadCompra");
            }

            if ((entity.getCostoTotal() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getCostoTotal(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "costoTotal");
            }

            if ((entity.getDiferido() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDiferido(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException("diferido");
            }

            if ((entity.getHorometroAbastecimiento() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getHorometroAbastecimiento(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "horometroAbastecimiento");
            }

            if ((entity.getInfoAdicional() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getInfoAdicional(), 1000) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "infoAdicional");
            }

            if ((entity.getInfoAdicional2() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getInfoAdicional2(), 1000) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "infoAdicional2");
            }

            if ((entity.getLoteCompraProducto() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getLoteCompraProducto(), 90) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "loteCompraProducto");
            }

            if ((entity.getOrigenDatos() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getOrigenDatos(), 60) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "origenDatos");
            }

            if ((entity.getPorcIva() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getPorcIva(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException("porcIva");
            }

            if ((entity.getRegistroIca() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getRegistroIca(), 90) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "registroIca");
            }

            if ((entity.getTipoMovimiento() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTipoMovimiento(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "tipoMovimiento");
            }

            if ((entity.getTransportadoraFactura() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTransportadoraFactura(), 300) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "transportadoraFactura");
            }

            if ((entity.getTransportadoraNguia() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTransportadoraNguia(), 300) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "transportadoraNguia");
            }

            if ((entity.getTransportadoraValorFlete() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getTransportadoraValorFlete(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "transportadoraValorFlete");
            }

            if ((entity.getValorIva() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorIva(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException("valorIva");
            }

            if ((entity.getValorUnitario() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorUnitario(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorUnitario");
            }

            precioPromMateriaPrimaDAO.update(entity);

            log.debug("update PrecioPromMateriaPrima successful");
        } catch (Exception e) {
            log.error("update PrecioPromMateriaPrima failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<PrecioPromMateriaPrimaDTO> getDataPrecioPromMateriaPrima()
        throws Exception {
        try {
            List<PrecioPromMateriaPrima> precioPromMateriaPrima = precioPromMateriaPrimaDAO.findAll();

            List<PrecioPromMateriaPrimaDTO> precioPromMateriaPrimaDTO = new ArrayList<PrecioPromMateriaPrimaDTO>();

            for (PrecioPromMateriaPrima precioPromMateriaPrimaTmp : precioPromMateriaPrima) {
                PrecioPromMateriaPrimaDTO precioPromMateriaPrimaDTO2 = new PrecioPromMateriaPrimaDTO();

                precioPromMateriaPrimaDTO2.setPrecioPromMateriaPrimaId(precioPromMateriaPrimaTmp.getPrecioPromMateriaPrimaId());
                precioPromMateriaPrimaDTO2.setAlmacenId((precioPromMateriaPrimaTmp.getAlmacenId() != null)
                    ? precioPromMateriaPrimaTmp.getAlmacenId() : null);
                precioPromMateriaPrimaDTO2.setCantidadCompra((precioPromMateriaPrimaTmp.getCantidadCompra() != null)
                    ? precioPromMateriaPrimaTmp.getCantidadCompra() : null);
                precioPromMateriaPrimaDTO2.setCompania((precioPromMateriaPrimaTmp.getCompania() != null)
                    ? precioPromMateriaPrimaTmp.getCompania() : null);
                precioPromMateriaPrimaDTO2.setConceptoGastoId((precioPromMateriaPrimaTmp.getConceptoGastoId() != null)
                    ? precioPromMateriaPrimaTmp.getConceptoGastoId() : null);
                precioPromMateriaPrimaDTO2.setConceptoKardexId((precioPromMateriaPrimaTmp.getConceptoKardexId() != null)
                    ? precioPromMateriaPrimaTmp.getConceptoKardexId() : null);
                precioPromMateriaPrimaDTO2.setConsecutivo((precioPromMateriaPrimaTmp.getConsecutivo() != null)
                    ? precioPromMateriaPrimaTmp.getConsecutivo() : null);
                precioPromMateriaPrimaDTO2.setCostoTotal((precioPromMateriaPrimaTmp.getCostoTotal() != null)
                    ? precioPromMateriaPrimaTmp.getCostoTotal() : null);
                precioPromMateriaPrimaDTO2.setDatCompraMateriaPrimaId((precioPromMateriaPrimaTmp.getDatCompraMateriaPrimaId() != null)
                    ? precioPromMateriaPrimaTmp.getDatCompraMateriaPrimaId() : null);
                precioPromMateriaPrimaDTO2.setDatServRealizadosEquipoId((precioPromMateriaPrimaTmp.getDatServRealizadosEquipoId() != null)
                    ? precioPromMateriaPrimaTmp.getDatServRealizadosEquipoId()
                    : null);
                precioPromMateriaPrimaDTO2.setDiferido((precioPromMateriaPrimaTmp.getDiferido() != null)
                    ? precioPromMateriaPrimaTmp.getDiferido() : null);
                precioPromMateriaPrimaDTO2.setEquipoId((precioPromMateriaPrimaTmp.getEquipoId() != null)
                    ? precioPromMateriaPrimaTmp.getEquipoId() : null);
                precioPromMateriaPrimaDTO2.setEtapaId((precioPromMateriaPrimaTmp.getEtapaId() != null)
                    ? precioPromMateriaPrimaTmp.getEtapaId() : null);
                precioPromMateriaPrimaDTO2.setFechaCreacion(precioPromMateriaPrimaTmp.getFechaCreacion());
                precioPromMateriaPrimaDTO2.setFechaFinal(precioPromMateriaPrimaTmp.getFechaFinal());
                precioPromMateriaPrimaDTO2.setFechaInicial(precioPromMateriaPrimaTmp.getFechaInicial());
                precioPromMateriaPrimaDTO2.setFechaModificacion(precioPromMateriaPrimaTmp.getFechaModificacion());
                precioPromMateriaPrimaDTO2.setFechaVencimiento(precioPromMateriaPrimaTmp.getFechaVencimiento());
                precioPromMateriaPrimaDTO2.setHorometroAbastecimiento((precioPromMateriaPrimaTmp.getHorometroAbastecimiento() != null)
                    ? precioPromMateriaPrimaTmp.getHorometroAbastecimiento()
                    : null);
                precioPromMateriaPrimaDTO2.setIdInsumo((precioPromMateriaPrimaTmp.getIdInsumo() != null)
                    ? precioPromMateriaPrimaTmp.getIdInsumo() : null);
                precioPromMateriaPrimaDTO2.setIdMaquinaria((precioPromMateriaPrimaTmp.getIdMaquinaria() != null)
                    ? precioPromMateriaPrimaTmp.getIdMaquinaria() : null);
                precioPromMateriaPrimaDTO2.setIdalmacen((precioPromMateriaPrimaTmp.getIdalmacen() != null)
                    ? precioPromMateriaPrimaTmp.getIdalmacen() : null);
                precioPromMateriaPrimaDTO2.setIndicadorVueltaMedidor((precioPromMateriaPrimaTmp.getIndicadorVueltaMedidor() != null)
                    ? precioPromMateriaPrimaTmp.getIndicadorVueltaMedidor() : null);
                precioPromMateriaPrimaDTO2.setInfoAdicional((precioPromMateriaPrimaTmp.getInfoAdicional() != null)
                    ? precioPromMateriaPrimaTmp.getInfoAdicional() : null);
                precioPromMateriaPrimaDTO2.setInfoAdicional2((precioPromMateriaPrimaTmp.getInfoAdicional2() != null)
                    ? precioPromMateriaPrimaTmp.getInfoAdicional2() : null);
                precioPromMateriaPrimaDTO2.setLoteCompraProducto((precioPromMateriaPrimaTmp.getLoteCompraProducto() != null)
                    ? precioPromMateriaPrimaTmp.getLoteCompraProducto() : null);
                precioPromMateriaPrimaDTO2.setNivel2ClientesmqId((precioPromMateriaPrimaTmp.getNivel2ClientesmqId() != null)
                    ? precioPromMateriaPrimaTmp.getNivel2ClientesmqId() : null);
                precioPromMateriaPrimaDTO2.setNivel4ClientesmqId((precioPromMateriaPrimaTmp.getNivel4ClientesmqId() != null)
                    ? precioPromMateriaPrimaTmp.getNivel4ClientesmqId() : null);
                precioPromMateriaPrimaDTO2.setNumFacturaCompra((precioPromMateriaPrimaTmp.getNumFacturaCompra() != null)
                    ? precioPromMateriaPrimaTmp.getNumFacturaCompra() : null);
                precioPromMateriaPrimaDTO2.setOperarioEquipoId((precioPromMateriaPrimaTmp.getOperarioEquipoId() != null)
                    ? precioPromMateriaPrimaTmp.getOperarioEquipoId() : null);
                precioPromMateriaPrimaDTO2.setOrigenDatos((precioPromMateriaPrimaTmp.getOrigenDatos() != null)
                    ? precioPromMateriaPrimaTmp.getOrigenDatos() : null);
                precioPromMateriaPrimaDTO2.setPorcIva((precioPromMateriaPrimaTmp.getPorcIva() != null)
                    ? precioPromMateriaPrimaTmp.getPorcIva() : null);
                precioPromMateriaPrimaDTO2.setRegistroIca((precioPromMateriaPrimaTmp.getRegistroIca() != null)
                    ? precioPromMateriaPrimaTmp.getRegistroIca() : null);
                precioPromMateriaPrimaDTO2.setTipoMovimiento((precioPromMateriaPrimaTmp.getTipoMovimiento() != null)
                    ? precioPromMateriaPrimaTmp.getTipoMovimiento() : null);
                precioPromMateriaPrimaDTO2.setTransportadoraFactura((precioPromMateriaPrimaTmp.getTransportadoraFactura() != null)
                    ? precioPromMateriaPrimaTmp.getTransportadoraFactura() : null);
                precioPromMateriaPrimaDTO2.setTransportadoraNguia((precioPromMateriaPrimaTmp.getTransportadoraNguia() != null)
                    ? precioPromMateriaPrimaTmp.getTransportadoraNguia() : null);
                precioPromMateriaPrimaDTO2.setTransportadoraValorFlete((precioPromMateriaPrimaTmp.getTransportadoraValorFlete() != null)
                    ? precioPromMateriaPrimaTmp.getTransportadoraValorFlete()
                    : null);
                precioPromMateriaPrimaDTO2.setUbicacionAlmacen((precioPromMateriaPrimaTmp.getUbicacionAlmacen() != null)
                    ? precioPromMateriaPrimaTmp.getUbicacionAlmacen() : null);
                precioPromMateriaPrimaDTO2.setUbicacionesAlmacenId((precioPromMateriaPrimaTmp.getUbicacionesAlmacenId() != null)
                    ? precioPromMateriaPrimaTmp.getUbicacionesAlmacenId() : null);
                precioPromMateriaPrimaDTO2.setUnidadMedida((precioPromMateriaPrimaTmp.getUnidadMedida() != null)
                    ? precioPromMateriaPrimaTmp.getUnidadMedida() : null);
                precioPromMateriaPrimaDTO2.setUsuarioDigitacion((precioPromMateriaPrimaTmp.getUsuarioDigitacion() != null)
                    ? precioPromMateriaPrimaTmp.getUsuarioDigitacion() : null);
                precioPromMateriaPrimaDTO2.setValorIva((precioPromMateriaPrimaTmp.getValorIva() != null)
                    ? precioPromMateriaPrimaTmp.getValorIva() : null);
                precioPromMateriaPrimaDTO2.setValorUnitario((precioPromMateriaPrimaTmp.getValorUnitario() != null)
                    ? precioPromMateriaPrimaTmp.getValorUnitario() : null);
                precioPromMateriaPrimaDTO2.setVariedId((precioPromMateriaPrimaTmp.getVariedId() != null)
                    ? precioPromMateriaPrimaTmp.getVariedId() : null);
                precioPromMateriaPrimaDTO2.setDatOtrosMovInventarioId_DatOtrosMovInventario((precioPromMateriaPrimaTmp.getDatOtrosMovInventario()
                                                                                                                      .getDatOtrosMovInventarioId() != null)
                    ? precioPromMateriaPrimaTmp.getDatOtrosMovInventario()
                                               .getDatOtrosMovInventarioId()
                    : null);

                if (precioPromMateriaPrimaTmp.getNivel2() != null) {
                    precioPromMateriaPrimaDTO2.setNivel2Id_Nivel2(precioPromMateriaPrimaTmp.getNivel2()
                                                                                           .getNivel2Id());
                } else {
                    precioPromMateriaPrimaDTO2.setNivel2Id_Nivel2(null);
                }

                if (precioPromMateriaPrimaTmp.getNivel4() != null) {
                    precioPromMateriaPrimaDTO2.setNivel4Id_Nivel4(precioPromMateriaPrimaTmp.getNivel4()
                                                                                           .getNivel4Id());
                } else {
                    precioPromMateriaPrimaDTO2.setNivel4Id_Nivel4(null);
                }

                precioPromMateriaPrimaDTO2.setPersEmprId_PersEmpr((precioPromMateriaPrimaTmp.getPersEmpr()
                                                                                            .getPersEmprId() != null)
                    ? precioPromMateriaPrimaTmp.getPersEmpr().getPersEmprId()
                    : null);

                if (precioPromMateriaPrimaTmp.getProducto() != null) {
                    precioPromMateriaPrimaDTO2.setProductoId_Producto(precioPromMateriaPrimaTmp.getProducto()
                                                                                               .getProductoId());
                } else {
                    precioPromMateriaPrimaDTO2.setProductoId_Producto(null);
                }

                if (precioPromMateriaPrimaTmp.getTrabajador() != null) {
                    precioPromMateriaPrimaDTO2.setTrabId_Trabajador(precioPromMateriaPrimaTmp.getTrabajador()
                                                                                             .getTrabId());
                } else {
                    precioPromMateriaPrimaDTO2.setTrabId_Trabajador(null);
                }

                precioPromMateriaPrimaDTO.add(precioPromMateriaPrimaDTO2);
            }

            return precioPromMateriaPrimaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public PrecioPromMateriaPrima getPrecioPromMateriaPrima(
        Long precioPromMateriaPrimaId) throws Exception {
        log.debug("getting PrecioPromMateriaPrima instance");

        PrecioPromMateriaPrima entity = null;

        try {
            entity = precioPromMateriaPrimaDAO.findById(precioPromMateriaPrimaId);
        } catch (Exception e) {
            log.error("get PrecioPromMateriaPrima failed", e);
            throw new ZMessManager().new FindingException(
                "PrecioPromMateriaPrima");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<PrecioPromMateriaPrima> findPagePrecioPromMateriaPrima(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<PrecioPromMateriaPrima> entity = null;

        try {
            entity = precioPromMateriaPrimaDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "PrecioPromMateriaPrima Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberPrecioPromMateriaPrima()
        throws Exception {
        Long entity = null;

        try {
            entity = precioPromMateriaPrimaDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "PrecioPromMateriaPrima Count");
        } finally {
        }

        return entity;
    }

    /**
    *
    * @param varibles
    *            este arreglo debera tener:
    *
    * [0] = String variable = (String) varibles[i]; representa como se llama la
    * variable en el pojo
    *
    * [1] = Boolean booVariable = (Boolean) varibles[i + 1]; representa si el
    * valor necesita o no ''(comillas simples)usado para campos de tipo string
    *
    * [2] = Object value = varibles[i + 2]; representa el valor que se va a
    * buscar en la BD
    *
    * [3] = String comparator = (String) varibles[i + 3]; representa que tipo
    * de busqueda voy a hacer.., ejemplo: where nombre=william o where nombre<>william,
        * en este campo iria el tipo de comparador que quiero si es = o <>
            *
            * Se itera de 4 en 4..., entonces 4 registros del arreglo representan 1
            * busqueda en un campo, si se ponen mas pues el continuara buscando en lo
            * que se le ingresen en los otros 4
            *
            *
            * @param variablesBetween
            *
            * la diferencia son estas dos posiciones
            *
            * [0] = String variable = (String) varibles[j]; la variable ne la BD que va
            * a ser buscada en un rango
            *
            * [1] = Object value = varibles[j + 1]; valor 1 para buscar en un rango
            *
            * [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en un rango
            * ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria value2
                *
                * [3] = String comparator1 = (String) varibles[j + 3]; comparador 1
                * ejemplo: a comparator1 1 and a < 5
                    *
                    * [4] = String comparator2 = (String) varibles[j + 4]; comparador 2
                    * ejemplo: a comparador1>1  and a comparador2<5  (el original: a > 1 and a <
                            * 5) *
                            * @param variablesBetweenDates(en
                            *            este caso solo para mysql)
                            *  [0] = String variable = (String) varibles[k]; el nombre de la variable que hace referencia a
                            *            una fecha
                            *
                            * [1] = Object object1 = varibles[k + 2]; fecha 1 a comparar(deben ser
                            * dates)
                            *
                            * [2] = Object object2 = varibles[k + 3]; fecha 2 a comparar(deben ser
                            * dates)
                            *
                            * esto hace un between entre las dos fechas.
                            *
                            * @return lista con los objetos que se necesiten
                            * @throws Exception
                            */
    @Transactional(readOnly = true)
    public List<PrecioPromMateriaPrima> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<PrecioPromMateriaPrima> list = new ArrayList<PrecioPromMateriaPrima>();
        String where = new String();
        String tempWhere = new String();

        if (variables != null) {
            for (int i = 0; i < variables.length; i++) {
                if ((variables[i] != null) && (variables[i + 1] != null) &&
                        (variables[i + 2] != null) &&
                        (variables[i + 3] != null)) {
                    String variable = (String) variables[i];
                    Boolean booVariable = (Boolean) variables[i + 1];
                    Object value = variables[i + 2];
                    String comparator = (String) variables[i + 3];

                    if (booVariable.booleanValue()) {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " \'" +
                            value + "\' )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " \'" + value + "\' )");
                    } else {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " " +
                            value + " )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " " + value + " )");
                    }
                }

                i = i + 3;
            }
        }

        if (variablesBetween != null) {
            for (int j = 0; j < variablesBetween.length; j++) {
                if ((variablesBetween[j] != null) &&
                        (variablesBetween[j + 1] != null) &&
                        (variablesBetween[j + 2] != null) &&
                        (variablesBetween[j + 3] != null) &&
                        (variablesBetween[j + 4] != null)) {
                    String variable = (String) variablesBetween[j];
                    Object value = variablesBetween[j + 1];
                    Object value2 = variablesBetween[j + 2];
                    String comparator1 = (String) variablesBetween[j + 3];
                    String comparator2 = (String) variablesBetween[j + 4];
                    tempWhere = (tempWhere.length() == 0)
                        ? ("(" + value + " " + comparator1 + " " + variable +
                        " and " + variable + " " + comparator2 + " " + value2 +
                        " )")
                        : (tempWhere + " AND (" + value + " " + comparator1 +
                        " " + variable + " and " + variable + " " +
                        comparator2 + " " + value2 + " )");
                }

                j = j + 4;
            }
        }

        if (variablesBetweenDates != null) {
            for (int k = 0; k < variablesBetweenDates.length; k++) {
                if ((variablesBetweenDates[k] != null) &&
                        (variablesBetweenDates[k + 1] != null) &&
                        (variablesBetweenDates[k + 2] != null)) {
                    String variable = (String) variablesBetweenDates[k];
                    Object object1 = variablesBetweenDates[k + 1];
                    Object object2 = variablesBetweenDates[k + 2];
                    String value = null;
                    String value2 = null;

                    try {
                        Date date1 = (Date) object1;
                        Date date2 = (Date) object2;
                        value = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date1);
                        value2 = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date2);
                    } catch (Exception e) {
                        list = null;
                        throw e;
                    }

                    tempWhere = (tempWhere.length() == 0)
                        ? ("(model." + variable + " between \'" + value +
                        "\' and \'" + value2 + "\')")
                        : (tempWhere + " AND (model." + variable +
                        " between \'" + value + "\' and \'" + value2 + "\')");
                }

                k = k + 2;
            }
        }

        if (tempWhere.length() == 0) {
            where = null;
        } else {
            where = "(" + tempWhere + ")";
        }

        try {
            list = precioPromMateriaPrimaDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = true)
    public List<PrecioPromMateriaPrimaDTO> getDataPrecioPromMateriaPrimaByCompra(Long datCompraMateriaPrimaId)
        throws Exception {
        try {
            List<PrecioPromMateriaPrima> precioPromMateriaPrima = precioPromMateriaPrimaDAO.findByCriteria("datCompraMateriaPrimaId = " + datCompraMateriaPrimaId);

            List<PrecioPromMateriaPrimaDTO> precioPromMateriaPrimaDTO = new ArrayList<PrecioPromMateriaPrimaDTO>();

            for (PrecioPromMateriaPrima precioPromMateriaPrimaTmp : precioPromMateriaPrima) {
                PrecioPromMateriaPrimaDTO precioPromMateriaPrimaDTO2 = new PrecioPromMateriaPrimaDTO();

                precioPromMateriaPrimaDTO2.setPrecioPromMateriaPrimaId(precioPromMateriaPrimaTmp.getPrecioPromMateriaPrimaId());
                
                precioPromMateriaPrimaDTO2.setAlmacenId((precioPromMateriaPrimaTmp.getAlmacenId() != null)
                    ? precioPromMateriaPrimaTmp.getAlmacenId() : null);                
                precioPromMateriaPrimaDTO2.setCodAlmacen((precioPromMateriaPrimaTmp.getAlmacenId() != null)
                    ? logicAlmacen7.getAlmacen(precioPromMateriaPrimaTmp.getAlmacenId()).getCodigo() : null);
                
                precioPromMateriaPrimaDTO2.setCantidadCompra((precioPromMateriaPrimaTmp.getCantidadCompra() != null)
                    ? precioPromMateriaPrimaTmp.getCantidadCompra() : null);
                precioPromMateriaPrimaDTO2.setCompania((precioPromMateriaPrimaTmp.getCompania() != null)
                    ? precioPromMateriaPrimaTmp.getCompania() : null);
                precioPromMateriaPrimaDTO2.setConceptoGastoId((precioPromMateriaPrimaTmp.getConceptoGastoId() != null)
                    ? precioPromMateriaPrimaTmp.getConceptoGastoId() : null);
                precioPromMateriaPrimaDTO2.setConceptoKardexId((precioPromMateriaPrimaTmp.getConceptoKardexId() != null)
                    ? precioPromMateriaPrimaTmp.getConceptoKardexId() : null);
                precioPromMateriaPrimaDTO2.setConsecutivo((precioPromMateriaPrimaTmp.getConsecutivo() != null)
                    ? precioPromMateriaPrimaTmp.getConsecutivo() : null);
                precioPromMateriaPrimaDTO2.setCostoTotal((precioPromMateriaPrimaTmp.getCostoTotal() != null)
                    ? precioPromMateriaPrimaTmp.getCostoTotal() : null);
                precioPromMateriaPrimaDTO2.setDatCompraMateriaPrimaId((precioPromMateriaPrimaTmp.getDatCompraMateriaPrimaId() != null)
                    ? precioPromMateriaPrimaTmp.getDatCompraMateriaPrimaId() : null);
                precioPromMateriaPrimaDTO2.setDatServRealizadosEquipoId((precioPromMateriaPrimaTmp.getDatServRealizadosEquipoId() != null)
                    ? precioPromMateriaPrimaTmp.getDatServRealizadosEquipoId()
                    : null);
                precioPromMateriaPrimaDTO2.setDiferido((precioPromMateriaPrimaTmp.getDiferido() != null)
                    ? precioPromMateriaPrimaTmp.getDiferido() : null);
                precioPromMateriaPrimaDTO2.setEquipoId((precioPromMateriaPrimaTmp.getEquipoId() != null)
                    ? precioPromMateriaPrimaTmp.getEquipoId() : null);
                precioPromMateriaPrimaDTO2.setEtapaId((precioPromMateriaPrimaTmp.getEtapaId() != null)
                    ? precioPromMateriaPrimaTmp.getEtapaId() : null);
                precioPromMateriaPrimaDTO2.setFechaCreacion(precioPromMateriaPrimaTmp.getFechaCreacion());
                precioPromMateriaPrimaDTO2.setFechaFinal(precioPromMateriaPrimaTmp.getFechaFinal());
                precioPromMateriaPrimaDTO2.setFechaInicial(precioPromMateriaPrimaTmp.getFechaInicial());
                precioPromMateriaPrimaDTO2.setFechaModificacion(precioPromMateriaPrimaTmp.getFechaModificacion());
                precioPromMateriaPrimaDTO2.setFechaVencimiento(precioPromMateriaPrimaTmp.getFechaVencimiento());
                precioPromMateriaPrimaDTO2.setHorometroAbastecimiento((precioPromMateriaPrimaTmp.getHorometroAbastecimiento() != null)
                    ? precioPromMateriaPrimaTmp.getHorometroAbastecimiento()
                    : null);
                precioPromMateriaPrimaDTO2.setIdInsumo((precioPromMateriaPrimaTmp.getIdInsumo() != null)
                    ? precioPromMateriaPrimaTmp.getIdInsumo() : null);
                precioPromMateriaPrimaDTO2.setIdMaquinaria((precioPromMateriaPrimaTmp.getIdMaquinaria() != null)
                    ? precioPromMateriaPrimaTmp.getIdMaquinaria() : null);
                precioPromMateriaPrimaDTO2.setIdalmacen((precioPromMateriaPrimaTmp.getIdalmacen() != null)
                    ? precioPromMateriaPrimaTmp.getIdalmacen() : null);
                precioPromMateriaPrimaDTO2.setIndicadorVueltaMedidor((precioPromMateriaPrimaTmp.getIndicadorVueltaMedidor() != null)
                    ? precioPromMateriaPrimaTmp.getIndicadorVueltaMedidor() : null);
                precioPromMateriaPrimaDTO2.setInfoAdicional((precioPromMateriaPrimaTmp.getInfoAdicional() != null)
                    ? precioPromMateriaPrimaTmp.getInfoAdicional() : null);
                precioPromMateriaPrimaDTO2.setInfoAdicional2((precioPromMateriaPrimaTmp.getInfoAdicional2() != null)
                    ? precioPromMateriaPrimaTmp.getInfoAdicional2() : null);
                precioPromMateriaPrimaDTO2.setLoteCompraProducto((precioPromMateriaPrimaTmp.getLoteCompraProducto() != null)
                    ? precioPromMateriaPrimaTmp.getLoteCompraProducto() : null);
                precioPromMateriaPrimaDTO2.setNivel2ClientesmqId((precioPromMateriaPrimaTmp.getNivel2ClientesmqId() != null)
                    ? precioPromMateriaPrimaTmp.getNivel2ClientesmqId() : null);
                precioPromMateriaPrimaDTO2.setNivel4ClientesmqId((precioPromMateriaPrimaTmp.getNivel4ClientesmqId() != null)
                    ? precioPromMateriaPrimaTmp.getNivel4ClientesmqId() : null);
                precioPromMateriaPrimaDTO2.setNumFacturaCompra((precioPromMateriaPrimaTmp.getNumFacturaCompra() != null)
                    ? precioPromMateriaPrimaTmp.getNumFacturaCompra() : null);
                precioPromMateriaPrimaDTO2.setOperarioEquipoId((precioPromMateriaPrimaTmp.getOperarioEquipoId() != null)
                    ? precioPromMateriaPrimaTmp.getOperarioEquipoId() : null);
                precioPromMateriaPrimaDTO2.setOrigenDatos((precioPromMateriaPrimaTmp.getOrigenDatos() != null)
                    ? precioPromMateriaPrimaTmp.getOrigenDatos() : null);
                precioPromMateriaPrimaDTO2.setPorcIva((precioPromMateriaPrimaTmp.getPorcIva() != null)
                    ? precioPromMateriaPrimaTmp.getPorcIva() : null);
                precioPromMateriaPrimaDTO2.setRegistroIca((precioPromMateriaPrimaTmp.getRegistroIca() != null)
                    ? precioPromMateriaPrimaTmp.getRegistroIca() : null);
                precioPromMateriaPrimaDTO2.setTipoMovimiento((precioPromMateriaPrimaTmp.getTipoMovimiento() != null)
                    ? precioPromMateriaPrimaTmp.getTipoMovimiento() : null);
                precioPromMateriaPrimaDTO2.setTransportadoraFactura((precioPromMateriaPrimaTmp.getTransportadoraFactura() != null)
                    ? precioPromMateriaPrimaTmp.getTransportadoraFactura() : null);
                precioPromMateriaPrimaDTO2.setTransportadoraNguia((precioPromMateriaPrimaTmp.getTransportadoraNguia() != null)
                    ? precioPromMateriaPrimaTmp.getTransportadoraNguia() : null);
                precioPromMateriaPrimaDTO2.setTransportadoraValorFlete((precioPromMateriaPrimaTmp.getTransportadoraValorFlete() != null)
                    ? precioPromMateriaPrimaTmp.getTransportadoraValorFlete() : null);
                precioPromMateriaPrimaDTO2.setUbicacionAlmacen((precioPromMateriaPrimaTmp.getUbicacionAlmacen() != null)
                    ? precioPromMateriaPrimaTmp.getUbicacionAlmacen() : null);
                
                precioPromMateriaPrimaDTO2.setUbicacionesAlmacenId((precioPromMateriaPrimaTmp.getUbicacionesAlmacenId() != null)
                    ? precioPromMateriaPrimaTmp.getUbicacionesAlmacenId() : null);                
                precioPromMateriaPrimaDTO2.setNomUbicacionesAlmacen((precioPromMateriaPrimaTmp.getUbicacionesAlmacenId() != null)
                    ? logicUbicacionesAlmacen8.getUbicacionesAlmacen(precioPromMateriaPrimaTmp.getUbicacionesAlmacenId()).getNombre() : null);
                
                precioPromMateriaPrimaDTO2.setUnidadMedida((precioPromMateriaPrimaTmp.getUnidadMedida() != null)
                    ? precioPromMateriaPrimaTmp.getUnidadMedida() : null);                
                precioPromMateriaPrimaDTO2.setNombreUnidadMedida((precioPromMateriaPrimaTmp.getUnidadMedida() != null)
                    ? logicUdadMed9.getUdadMed(precioPromMateriaPrimaTmp.getUnidadMedida()).getNombre() : null);
                
                precioPromMateriaPrimaDTO2.setUsuarioDigitacion((precioPromMateriaPrimaTmp.getUsuarioDigitacion() != null)
                    ? precioPromMateriaPrimaTmp.getUsuarioDigitacion() : null);
                precioPromMateriaPrimaDTO2.setValorIva((precioPromMateriaPrimaTmp.getValorIva() != null)
                    ? precioPromMateriaPrimaTmp.getValorIva() : null);
                precioPromMateriaPrimaDTO2.setValorUnitario((precioPromMateriaPrimaTmp.getValorUnitario() != null)
                    ? precioPromMateriaPrimaTmp.getValorUnitario() : null);
                precioPromMateriaPrimaDTO2.setVariedId((precioPromMateriaPrimaTmp.getVariedId() != null)
                    ? precioPromMateriaPrimaTmp.getVariedId() : null);
                precioPromMateriaPrimaDTO2.setDatOtrosMovInventarioId_DatOtrosMovInventario((precioPromMateriaPrimaTmp.getDatOtrosMovInventario() != null)
                    ? precioPromMateriaPrimaTmp.getDatOtrosMovInventario().getDatOtrosMovInventarioId() : null);

                if (precioPromMateriaPrimaTmp.getNivel2() != null) {
                    precioPromMateriaPrimaDTO2.setNivel2Id_Nivel2(precioPromMateriaPrimaTmp.getNivel2().getNivel2Id());
                } else {
                    precioPromMateriaPrimaDTO2.setNivel2Id_Nivel2(null);
                }

                if (precioPromMateriaPrimaTmp.getNivel4() != null) {
                    precioPromMateriaPrimaDTO2.setNivel4Id_Nivel4(precioPromMateriaPrimaTmp.getNivel4().getNivel4Id());
                } else {
                    precioPromMateriaPrimaDTO2.setNivel4Id_Nivel4(null);
                }

                precioPromMateriaPrimaDTO2.setPersEmprId_PersEmpr((precioPromMateriaPrimaTmp.getPersEmpr() != null)
                    ? precioPromMateriaPrimaTmp.getPersEmpr().getPersEmprId() : null);

                if (precioPromMateriaPrimaTmp.getProducto() != null) {
                    precioPromMateriaPrimaDTO2.setProductoId_Producto(precioPromMateriaPrimaTmp.getProducto().getProductoId());
                    precioPromMateriaPrimaDTO2.setNomProducto(precioPromMateriaPrimaTmp.getProducto().getNombre());
                } else {
                    precioPromMateriaPrimaDTO2.setProductoId_Producto(null);
                    precioPromMateriaPrimaDTO2.setNomProducto(null);
                }

                if (precioPromMateriaPrimaTmp.getTrabajador() != null) {
                    precioPromMateriaPrimaDTO2.setTrabId_Trabajador(precioPromMateriaPrimaTmp.getTrabajador().getTrabId());
                } else {
                    precioPromMateriaPrimaDTO2.setTrabId_Trabajador(null);
                }

                precioPromMateriaPrimaDTO.add(precioPromMateriaPrimaDTO2);
            }

            return precioPromMateriaPrimaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<PrecioPromMateriaPrimaDTO> getDataPrecioPromMateriaPrimaByInventario(Long datOtrosMovInventarioId)
        throws Exception {
        try {
            List<PrecioPromMateriaPrima> precioPromMateriaPrima = precioPromMateriaPrimaDAO.findByCriteria("datOtrosMovInventarioId = " + datOtrosMovInventarioId);

            List<PrecioPromMateriaPrimaDTO> precioPromMateriaPrimaDTO = new ArrayList<PrecioPromMateriaPrimaDTO>();

            for (PrecioPromMateriaPrima precioPromMateriaPrimaTmp : precioPromMateriaPrima) {
                PrecioPromMateriaPrimaDTO precioPromMateriaPrimaDTO2 = new PrecioPromMateriaPrimaDTO();

                precioPromMateriaPrimaDTO2.setPrecioPromMateriaPrimaId(precioPromMateriaPrimaTmp.getPrecioPromMateriaPrimaId());
                precioPromMateriaPrimaDTO2.setAlmacenId((precioPromMateriaPrimaTmp.getAlmacenId() != null)
                    ? precioPromMateriaPrimaTmp.getAlmacenId() : null);
                precioPromMateriaPrimaDTO2.setCantidadCompra((precioPromMateriaPrimaTmp.getCantidadCompra() != null)
                    ? precioPromMateriaPrimaTmp.getCantidadCompra() : null);
                precioPromMateriaPrimaDTO2.setCompania((precioPromMateriaPrimaTmp.getCompania() != null)
                    ? precioPromMateriaPrimaTmp.getCompania() : null);
                precioPromMateriaPrimaDTO2.setConceptoGastoId((precioPromMateriaPrimaTmp.getConceptoGastoId() != null)
                    ? precioPromMateriaPrimaTmp.getConceptoGastoId() : null);
                precioPromMateriaPrimaDTO2.setConceptoKardexId((precioPromMateriaPrimaTmp.getConceptoKardexId() != null)
                    ? precioPromMateriaPrimaTmp.getConceptoKardexId() : null);
                precioPromMateriaPrimaDTO2.setConsecutivo((precioPromMateriaPrimaTmp.getConsecutivo() != null)
                    ? precioPromMateriaPrimaTmp.getConsecutivo() : null);
                precioPromMateriaPrimaDTO2.setCostoTotal((precioPromMateriaPrimaTmp.getCostoTotal() != null)
                    ? precioPromMateriaPrimaTmp.getCostoTotal() : null);
                precioPromMateriaPrimaDTO2.setDatCompraMateriaPrimaId((precioPromMateriaPrimaTmp.getDatCompraMateriaPrimaId() != null)
                    ? precioPromMateriaPrimaTmp.getDatCompraMateriaPrimaId() : null);
                precioPromMateriaPrimaDTO2.setDatServRealizadosEquipoId((precioPromMateriaPrimaTmp.getDatServRealizadosEquipoId() != null)
                    ? precioPromMateriaPrimaTmp.getDatServRealizadosEquipoId()
                    : null);
                precioPromMateriaPrimaDTO2.setDiferido((precioPromMateriaPrimaTmp.getDiferido() != null)
                    ? precioPromMateriaPrimaTmp.getDiferido() : null);
                precioPromMateriaPrimaDTO2.setEquipoId((precioPromMateriaPrimaTmp.getEquipoId() != null)
                    ? precioPromMateriaPrimaTmp.getEquipoId() : null);
                precioPromMateriaPrimaDTO2.setEtapaId((precioPromMateriaPrimaTmp.getEtapaId() != null)
                    ? precioPromMateriaPrimaTmp.getEtapaId() : null);
                precioPromMateriaPrimaDTO2.setFechaCreacion(precioPromMateriaPrimaTmp.getFechaCreacion());
                precioPromMateriaPrimaDTO2.setFechaFinal(precioPromMateriaPrimaTmp.getFechaFinal());
                precioPromMateriaPrimaDTO2.setFechaInicial(precioPromMateriaPrimaTmp.getFechaInicial());
                precioPromMateriaPrimaDTO2.setFechaModificacion(precioPromMateriaPrimaTmp.getFechaModificacion());
                precioPromMateriaPrimaDTO2.setFechaVencimiento(precioPromMateriaPrimaTmp.getFechaVencimiento());
                precioPromMateriaPrimaDTO2.setHorometroAbastecimiento((precioPromMateriaPrimaTmp.getHorometroAbastecimiento() != null)
                    ? precioPromMateriaPrimaTmp.getHorometroAbastecimiento()
                    : null);
                precioPromMateriaPrimaDTO2.setIdInsumo((precioPromMateriaPrimaTmp.getIdInsumo() != null)
                    ? precioPromMateriaPrimaTmp.getIdInsumo() : null);
                precioPromMateriaPrimaDTO2.setIdMaquinaria((precioPromMateriaPrimaTmp.getIdMaquinaria() != null)
                    ? precioPromMateriaPrimaTmp.getIdMaquinaria() : null);
                precioPromMateriaPrimaDTO2.setIdalmacen((precioPromMateriaPrimaTmp.getIdalmacen() != null)
                    ? precioPromMateriaPrimaTmp.getIdalmacen() : null);
                precioPromMateriaPrimaDTO2.setIndicadorVueltaMedidor((precioPromMateriaPrimaTmp.getIndicadorVueltaMedidor() != null)
                    ? precioPromMateriaPrimaTmp.getIndicadorVueltaMedidor() : null);
                precioPromMateriaPrimaDTO2.setInfoAdicional((precioPromMateriaPrimaTmp.getInfoAdicional() != null)
                    ? precioPromMateriaPrimaTmp.getInfoAdicional() : null);
                precioPromMateriaPrimaDTO2.setInfoAdicional2((precioPromMateriaPrimaTmp.getInfoAdicional2() != null)
                    ? precioPromMateriaPrimaTmp.getInfoAdicional2() : null);
                precioPromMateriaPrimaDTO2.setLoteCompraProducto((precioPromMateriaPrimaTmp.getLoteCompraProducto() != null)
                    ? precioPromMateriaPrimaTmp.getLoteCompraProducto() : null);
                precioPromMateriaPrimaDTO2.setNivel2ClientesmqId((precioPromMateriaPrimaTmp.getNivel2ClientesmqId() != null)
                    ? precioPromMateriaPrimaTmp.getNivel2ClientesmqId() : null);
                precioPromMateriaPrimaDTO2.setNivel4ClientesmqId((precioPromMateriaPrimaTmp.getNivel4ClientesmqId() != null)
                    ? precioPromMateriaPrimaTmp.getNivel4ClientesmqId() : null);
                precioPromMateriaPrimaDTO2.setNumFacturaCompra((precioPromMateriaPrimaTmp.getNumFacturaCompra() != null)
                    ? precioPromMateriaPrimaTmp.getNumFacturaCompra() : null);
                precioPromMateriaPrimaDTO2.setOperarioEquipoId((precioPromMateriaPrimaTmp.getOperarioEquipoId() != null)
                    ? precioPromMateriaPrimaTmp.getOperarioEquipoId() : null);
                precioPromMateriaPrimaDTO2.setOrigenDatos((precioPromMateriaPrimaTmp.getOrigenDatos() != null)
                    ? precioPromMateriaPrimaTmp.getOrigenDatos() : null);
                precioPromMateriaPrimaDTO2.setPorcIva((precioPromMateriaPrimaTmp.getPorcIva() != null)
                    ? precioPromMateriaPrimaTmp.getPorcIva() : null);
                precioPromMateriaPrimaDTO2.setRegistroIca((precioPromMateriaPrimaTmp.getRegistroIca() != null)
                    ? precioPromMateriaPrimaTmp.getRegistroIca() : null);
                precioPromMateriaPrimaDTO2.setTipoMovimiento((precioPromMateriaPrimaTmp.getTipoMovimiento() != null)
                    ? precioPromMateriaPrimaTmp.getTipoMovimiento() : null);
                precioPromMateriaPrimaDTO2.setTransportadoraFactura((precioPromMateriaPrimaTmp.getTransportadoraFactura() != null)
                    ? precioPromMateriaPrimaTmp.getTransportadoraFactura() : null);
                precioPromMateriaPrimaDTO2.setTransportadoraNguia((precioPromMateriaPrimaTmp.getTransportadoraNguia() != null)
                    ? precioPromMateriaPrimaTmp.getTransportadoraNguia() : null);
                precioPromMateriaPrimaDTO2.setTransportadoraValorFlete((precioPromMateriaPrimaTmp.getTransportadoraValorFlete() != null)
                    ? precioPromMateriaPrimaTmp.getTransportadoraValorFlete()
                    : null);
                precioPromMateriaPrimaDTO2.setUbicacionAlmacen((precioPromMateriaPrimaTmp.getUbicacionAlmacen() != null)
                    ? precioPromMateriaPrimaTmp.getUbicacionAlmacen() : null);
                precioPromMateriaPrimaDTO2.setUbicacionesAlmacenId((precioPromMateriaPrimaTmp.getUbicacionesAlmacenId() != null)
                    ? precioPromMateriaPrimaTmp.getUbicacionesAlmacenId() : null);
                precioPromMateriaPrimaDTO2.setUnidadMedida((precioPromMateriaPrimaTmp.getUnidadMedida() != null)
                    ? precioPromMateriaPrimaTmp.getUnidadMedida() : null);
                precioPromMateriaPrimaDTO2.setUsuarioDigitacion((precioPromMateriaPrimaTmp.getUsuarioDigitacion() != null)
                    ? precioPromMateriaPrimaTmp.getUsuarioDigitacion() : null);
                precioPromMateriaPrimaDTO2.setValorIva((precioPromMateriaPrimaTmp.getValorIva() != null)
                    ? precioPromMateriaPrimaTmp.getValorIva() : null);
                precioPromMateriaPrimaDTO2.setValorUnitario((precioPromMateriaPrimaTmp.getValorUnitario() != null)
                    ? precioPromMateriaPrimaTmp.getValorUnitario() : null);
                precioPromMateriaPrimaDTO2.setVariedId((precioPromMateriaPrimaTmp.getVariedId() != null)
                    ? precioPromMateriaPrimaTmp.getVariedId() : null);
                precioPromMateriaPrimaDTO2.setDatOtrosMovInventarioId_DatOtrosMovInventario((precioPromMateriaPrimaTmp.getDatOtrosMovInventario()
                                                                                                                      .getDatOtrosMovInventarioId() != null)
                    ? precioPromMateriaPrimaTmp.getDatOtrosMovInventario()
                                               .getDatOtrosMovInventarioId()
                    : null);

                if (precioPromMateriaPrimaTmp.getNivel2() != null) {
                    precioPromMateriaPrimaDTO2.setNivel2Id_Nivel2(precioPromMateriaPrimaTmp.getNivel2()
                                                                                           .getNivel2Id());
                } else {
                    precioPromMateriaPrimaDTO2.setNivel2Id_Nivel2(null);
                }

                if (precioPromMateriaPrimaTmp.getNivel4() != null) {
                    precioPromMateriaPrimaDTO2.setNivel4Id_Nivel4(precioPromMateriaPrimaTmp.getNivel4()
                                                                                           .getNivel4Id());
                } else {
                    precioPromMateriaPrimaDTO2.setNivel4Id_Nivel4(null);
                }

                precioPromMateriaPrimaDTO2.setPersEmprId_PersEmpr((precioPromMateriaPrimaTmp.getPersEmpr()
                                                                                            .getPersEmprId() != null)
                    ? precioPromMateriaPrimaTmp.getPersEmpr().getPersEmprId()
                    : null);

                if (precioPromMateriaPrimaTmp.getProducto() != null) {
                    precioPromMateriaPrimaDTO2.setProductoId_Producto(precioPromMateriaPrimaTmp.getProducto()
                                                                                               .getProductoId());
                } else {
                    precioPromMateriaPrimaDTO2.setProductoId_Producto(null);
                }

                if (precioPromMateriaPrimaTmp.getTrabajador() != null) {
                    precioPromMateriaPrimaDTO2.setTrabId_Trabajador(precioPromMateriaPrimaTmp.getTrabajador()
                                                                                             .getTrabId());
                } else {
                    precioPromMateriaPrimaDTO2.setTrabId_Trabajador(null);
                }

                
                
                precioPromMateriaPrimaDTO.add(precioPromMateriaPrimaDTO2);
            }

            return precioPromMateriaPrimaDTO;
        } catch (Exception e) {
            throw e;
        }
    }
}
