package co.com.arcosoft.modelo.control;

import co.com.arcosoft.dataaccess.dao.*;
import co.com.arcosoft.exceptions.*;
import co.com.arcosoft.modelo.*;
import co.com.arcosoft.modelo.dto.DatCompraMateriaPrimaDTO;
import co.com.arcosoft.modelo.dto.PrecioPromMateriaPrimaDTO;
import co.com.arcosoft.modelo.dto.PrecioPromProdDTO;
import co.com.arcosoft.utilities.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("DatCompraMateriaPrimaLogic")
public class DatCompraMateriaPrimaLogic implements IDatCompraMateriaPrimaLogic {
    private static final Logger log = LoggerFactory.getLogger(DatCompraMateriaPrimaLogic.class);

    /**
     * DAO injected by Spring that manages DatCompraMateriaPrima entities
     *
     */
    @Autowired
    private IDatCompraMateriaPrimaDAO datCompraMateriaPrimaDAO;
    @Autowired
    private IPrecioPromMateriaPrimaDAO precioPromMateriaPrimaDAO;

    /**
    * Logic injected by Spring that manages PersEmpr entities
    *
    */
    @Autowired
    IPersEmprLogic logicPersEmpr1;
    @Autowired
    IProductoLogic logicProducto2;
    @Autowired
    ITrabajadorLogic logicTrabajador3;

    @Transactional(readOnly = true)
    public List<DatCompraMateriaPrima> getDatCompraMateriaPrima()
        throws Exception {
        log.debug("finding all DatCompraMateriaPrima instances");

        List<DatCompraMateriaPrima> list = new ArrayList<DatCompraMateriaPrima>();

        try {
            list = datCompraMateriaPrimaDAO.findAll();
        } catch (Exception e) {
            log.error("finding all DatCompraMateriaPrima failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "DatCompraMateriaPrima");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveDatCompraMateriaPrima(DatCompraMateriaPrima entity, List<PrecioPromMateriaPrimaDTO> dataDetPrecioProductos)
        throws Exception {
        log.debug("saving DatCompraMateriaPrima instance");

        try {

            if ((entity.getDetalleNota() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDetalleNota(), 3900) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "detalleNota");
            }

            if ((entity.getEstado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException("estado");
            }

            if ((entity.getObservacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacion(), 3900) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacion");
            }

            if ((entity.getObservacionAnularReg() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacionAnularReg(), 500) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacionAnularReg");
            }

            if ((entity.getSubTotalFactura() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getSubTotalFactura(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "subTotalFactura");
            }

            if ((entity.getTasaConversionTrm() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getTasaConversionTrm(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "tasaConversionTrm");
            }

            if ((entity.getTipoMoneda() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTipoMoneda(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "tipoMoneda");
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

            if ((entity.getValComisiones() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValComisiones(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valComisiones");
            }

            if ((entity.getValGastosNacionales() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValGastosNacionales(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valGastosNacionales");
            }

            if ((entity.getValImpuestosAranceles() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValImpuestosAranceles(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valImpuestosAranceles");
            }

            if ((entity.getValOtros() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValOtros(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException("valOtros");
            }

            if ((entity.getValSumaProvs() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValSumaProvs(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valSumaProvs");
            }

            if ((entity.getValTransporteFlete() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValTransporteFlete(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valTransporteFlete");
            }

            if ((entity.getValorAdicional() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorAdicional(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorAdicional");
            }

            if ((entity.getValorDescuento() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorDescuento(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorDescuento");
            }

            if ((entity.getValorFactura() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorFactura(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorFactura");
            }

            if ((entity.getValorIva() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorIva(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException("valorIva");
            }

            datCompraMateriaPrimaDAO.save(entity);
			if (dataDetPrecioProductos != null) {

				for (PrecioPromMateriaPrimaDTO valorDto : dataDetPrecioProductos) {

					if (valorDto.getPrecioPromMateriaPrimaId() == null) {

						PrecioPromMateriaPrima valor = new PrecioPromMateriaPrima();
						valor.setConsecutivo(entity.getConsecutivo());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaVencimiento(valorDto.getFechaVencimiento());
						valor.setCantidadCompra(valorDto.getCantidadCompra());
						valor.setUnidadMedida(valorDto.getUnidadMedida());
						valor.setLoteCompraProducto(valorDto.getLoteCompraProducto());
						valor.setRegistroIca(valorDto.getRegistroIca());
						valor.setAlmacenId(valorDto.getAlmacenId());
						valor.setOrigenDatos(valorDto.getOrigenDatos());
						valor.setTransportadoraFactura(entity.getTransportadoraFactura());
						valor.setTransportadoraNguia(entity.getTransportadoraNguia());
						valor.setTransportadoraValorFlete(entity.getTransportadoraValorFlete());

						if (entity.getValorDescuento() == null) {

							valor.setCostoTotal(valorDto.getCostoTotal());
							valor.setValorIva(valorDto.getValorIva());
							if (valorDto.getCantidadCompra() != 0) {
								valor.setValorUnitario(valorDto.getCostoTotal() / valorDto.getCantidadCompra());
							}
						}
						
						if (entity.getValorAdicional() == null) {

							valor.setCostoTotal(valorDto.getCostoTotal());
							valor.setValorIva(valorDto.getValorIva());
							if (valorDto.getCantidadCompra() != 0) {
								valor.setValorUnitario(valorDto.getCostoTotal() / valorDto.getCantidadCompra());
							}
						}

						if (entity.getValorDescuento() != null) {

							if (entity.getSubTotalFactura() != null && entity.getValorFactura() != null
									&& valorDto.getCostoTotal() != null && valorDto.getCantidadCompra() != null) {
								if( valorDto.getValorIva()!=0) {
									Double subTotalFacturaMasDescuento = entity.getSubTotalFactura() + entity.getValorDescuento();
									Double costoProductoSinIva = valorDto.getCostoTotal() - valorDto.getValorIva();
									Double porcentajeCostoProducto = costoProductoSinIva / subTotalFacturaMasDescuento;
									Double valorDescuentoProducto = porcentajeCostoProducto * entity.getValorDescuento();
									Double costoTotalProductoMenosDescuento = costoProductoSinIva - valorDescuentoProducto;
									
									valor.setCostoTotal((costoTotalProductoMenosDescuento * entity.getValorFactura()) / entity.getSubTotalFactura());
									valor.setValorIva(valor.getCostoTotal() - costoTotalProductoMenosDescuento);
									valor.setValorUnitario(valor.getCostoTotal() / valorDto.getCantidadCompra());
								}else {
									valor.setCostoTotal(valorDto.getCostoTotal());
									valor.setValorIva(valorDto.getValorIva());
									if (valorDto.getCantidadCompra() != 0) {
										valor.setValorUnitario(valorDto.getCostoTotal() / valorDto.getCantidadCompra());
									}
								}
								
							}
						}

						if (entity.getValorAdicional() != null) {

							if (entity.getSubTotalFactura() != null && entity.getValorFactura() != null
									&& valorDto.getCostoTotal() != null && valorDto.getCantidadCompra() != null) {
								
								Double valorAdicionalPesos = entity.getValorAdicional() * entity.getTasaConversionTrm();
								Double subTotalFacturaMenosAdicional = entity.getSubTotalFactura() - valorAdicionalPesos;
								Double costoProductoSinIva = valorDto.getCostoTotal() - valorDto.getValorIva();
								Double porcentajeCostoProducto = costoProductoSinIva / subTotalFacturaMenosAdicional;
								Double valorAdicionalProducto = porcentajeCostoProducto * valorAdicionalPesos;
								Double costoTotalProductoMasAdicional = costoProductoSinIva + valorAdicionalProducto;
								
								valor.setCostoTotal((costoTotalProductoMasAdicional * entity.getValorFactura()) / entity.getSubTotalFactura());
								valor.setValorIva(valor.getCostoTotal() - costoTotalProductoMasAdicional);
								valor.setValorUnitario(valor.getCostoTotal() / valorDto.getCantidadCompra());
							}
						}

						valor.setCompania(valorDto.getCompania());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setPersEmpr(valorDto.getPersEmprId_PersEmpr() != null ? logicPersEmpr1.getPersEmpr(valorDto.getPersEmprId_PersEmpr()) : null);
						valor.setEquipoId(valorDto.getEquipoId());
						valor.setConceptoKardexId(valorDto.getConceptoKardexId());
						valor.setProducto(valorDto.getProductoId_Producto() != null ? logicProducto2.getProducto(valorDto.getProductoId_Producto()) : null);
						valor.setTrabajador(valorDto.getTrabId_Trabajador() != null ? logicTrabajador3.getTrabajador(valorDto.getTrabId_Trabajador()) : null);
						valor.setPorcIva(valorDto.getPorcIva());
						valor.setUbicacionesAlmacenId(valorDto.getUbicacionesAlmacenId());

						valor.setTipoMovimiento(valorDto.getTipoMovimiento());
						valor.setNumFacturaCompra(valorDto.getNumFacturaCompra());
						valor.setInfoAdicional(valorDto.getInfoAdicional());

						valor.setUsuarioDigitacion(entity.getUsuarioDigitacion());
						valor.setDatCompraMateriaPrimaId(entity.getDatCompraMateriaPrimaId());

						precioPromMateriaPrimaDAO.save(valor);
					}
				}
			}

            log.debug("save DatCompraMateriaPrima successful");
        } catch (Exception e) {
            log.error("save DatCompraMateriaPrima failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteDatCompraMateriaPrima(DatCompraMateriaPrima entity)
        throws Exception {
        log.debug("deleting DatCompraMateriaPrima instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "DatCompraMateriaPrima");
        }

        if (entity.getDatCompraMateriaPrimaId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "datCompraMateriaPrimaId");
        }

        try {
            datCompraMateriaPrimaDAO.delete(entity);

            log.debug("delete DatCompraMateriaPrima successful");
        } catch (Exception e) {
            log.error("delete DatCompraMateriaPrima failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDatCompraMateriaPrima(DatCompraMateriaPrima entity, List<PrecioPromMateriaPrimaDTO> dataDetPrecioProductos)
        throws Exception {
        log.debug("updating DatCompraMateriaPrima instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "DatCompraMateriaPrima");
            }

            if ((entity.getDetalleNota() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDetalleNota(), 3900) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "detalleNota");
            }

            if ((entity.getEstado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException("estado");
            }

            if ((entity.getObservacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacion(), 3900) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacion");
            }

            if ((entity.getObservacionAnularReg() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacionAnularReg(), 500) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacionAnularReg");
            }

            if ((entity.getSubTotalFactura() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getSubTotalFactura(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "subTotalFactura");
            }

            if ((entity.getTasaConversionTrm() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getTasaConversionTrm(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "tasaConversionTrm");
            }

            if ((entity.getTipoMoneda() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTipoMoneda(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "tipoMoneda");
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

            if ((entity.getValComisiones() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValComisiones(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valComisiones");
            }

            if ((entity.getValGastosNacionales() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValGastosNacionales(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valGastosNacionales");
            }

            if ((entity.getValImpuestosAranceles() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValImpuestosAranceles(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valImpuestosAranceles");
            }

            if ((entity.getValOtros() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValOtros(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException("valOtros");
            }

            if ((entity.getValSumaProvs() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValSumaProvs(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valSumaProvs");
            }

            if ((entity.getValTransporteFlete() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValTransporteFlete(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valTransporteFlete");
            }

            if ((entity.getValorAdicional() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorAdicional(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorAdicional");
            }

            if ((entity.getValorDescuento() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorDescuento(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorDescuento");
            }

            if ((entity.getValorFactura() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorFactura(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorFactura");
            }

            if ((entity.getValorIva() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorIva(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException("valorIva");
            }

            if (entity.getPersEmpr().getPersEmprId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "persEmprId_PersEmpr");
            }

            datCompraMateriaPrimaDAO.update(entity);
			if (dataDetPrecioProductos != null) {

				for (PrecioPromMateriaPrimaDTO valorDto : dataDetPrecioProductos) {

					if (valorDto.getPrecioPromMateriaPrimaId() == null) {

						PrecioPromMateriaPrima valor = new PrecioPromMateriaPrima();
						valor.setConsecutivo(entity.getConsecutivo());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaVencimiento(valorDto.getFechaVencimiento());
						valor.setCantidadCompra(valorDto.getCantidadCompra());
						valor.setUnidadMedida(valorDto.getUnidadMedida());
						valor.setLoteCompraProducto(valorDto.getLoteCompraProducto());
						valor.setRegistroIca(valorDto.getRegistroIca());
						valor.setAlmacenId(valorDto.getAlmacenId());
						valor.setOrigenDatos(valorDto.getOrigenDatos());
						valor.setTransportadoraFactura(entity.getTransportadoraFactura());
						valor.setTransportadoraNguia(entity.getTransportadoraNguia());
						valor.setTransportadoraValorFlete(entity.getTransportadoraValorFlete());

						if (entity.getValorAdicional() != null) {

							if (entity.getSubTotalFactura() != null && entity.getValorFactura() != null
									&& valorDto.getCostoTotal() != null && valorDto.getCantidadCompra() != null) {
								
								Double valorAdicionalPesos = entity.getValorAdicional() * entity.getTasaConversionTrm();
								Double subTotalFacturaMenosAdicional = entity.getSubTotalFactura() - valorAdicionalPesos;
								Double costoProductoSinIva = valorDto.getCostoTotal() - valorDto.getValorIva();
								Double porcentajeCostoProducto = costoProductoSinIva / subTotalFacturaMenosAdicional;
								Double valorAdicionalProducto = porcentajeCostoProducto * valorAdicionalPesos;
								Double costoTotalProductoMasAdicional = costoProductoSinIva + valorAdicionalProducto;
								
								valor.setCostoTotal((costoTotalProductoMasAdicional * entity.getValorFactura()) / entity.getSubTotalFactura());
								valor.setValorIva(valor.getCostoTotal() - costoTotalProductoMasAdicional);
								valor.setValorUnitario(valor.getCostoTotal() / valorDto.getCantidadCompra());
							}
							
						} else {

							valor.setCostoTotal(valorDto.getCostoTotal());
							valor.setValorIva(valorDto.getValorIva());
							valor.setValorUnitario(valorDto.getValorUnitario());
						}

						valor.setCompania(valorDto.getCompania());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setPersEmpr(valorDto.getPersEmprId_PersEmpr() != null ? logicPersEmpr1.getPersEmpr(valorDto.getPersEmprId_PersEmpr()) : null);
						valor.setUbicacionesAlmacenId(valorDto.getUbicacionesAlmacenId());
						valor.setEquipoId(valorDto.getEquipoId());
						valor.setConceptoKardexId(valorDto.getConceptoKardexId());
						valor.setProducto(valorDto.getProductoId_Producto() != null ? logicProducto2.getProducto(valorDto.getProductoId_Producto()) : null);
						valor.setTrabajador(valorDto.getTrabId_Trabajador() != null ? logicTrabajador3.getTrabajador(valorDto.getTrabId_Trabajador()) : null);
						valor.setPorcIva(valorDto.getPorcIva());
						valor.setTipoMovimiento(valorDto.getTipoMovimiento());
						valor.setNumFacturaCompra(valorDto.getNumFacturaCompra());
						valor.setInfoAdicional(valorDto.getInfoAdicional());
						valor.setDatCompraMateriaPrimaId(entity.getDatCompraMateriaPrimaId());

						precioPromMateriaPrimaDAO.save(valor);
						
					} else {
						
						PrecioPromMateriaPrima valor = precioPromMateriaPrimaDAO.findById(valorDto.getPrecioPromMateriaPrimaId());
						
						valor.setConsecutivo(entity.getConsecutivo());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaVencimiento(valorDto.getFechaVencimiento());
						valor.setCantidadCompra(valorDto.getCantidadCompra());
						valor.setUnidadMedida(valorDto.getUnidadMedida());
						valor.setLoteCompraProducto(valorDto.getLoteCompraProducto());
						valor.setRegistroIca(valorDto.getRegistroIca());
						valor.setAlmacenId(valorDto.getAlmacenId());
						valor.setTransportadoraFactura(entity.getTransportadoraFactura());
						valor.setTransportadoraNguia(entity.getTransportadoraNguia());
						valor.setTransportadoraValorFlete(entity.getTransportadoraValorFlete());

						if (entity.getValorAdicional() != null) {

							if (entity.getSubTotalFactura() != null && entity.getValorFactura() != null
									&& valorDto.getCostoTotal() != null && valorDto.getCantidadCompra() != null) {
								
								Double valorAdicionalPesos = entity.getValorAdicional() * entity.getTasaConversionTrm();
								Double subTotalFacturaMenosAdicional = entity.getSubTotalFactura() - valorAdicionalPesos;
								Double costoProductoSinIva = valorDto.getCostoTotal() - valorDto.getValorIva();
								Double porcentajeCostoProducto = costoProductoSinIva / subTotalFacturaMenosAdicional;
								Double valorAdicionalProducto = porcentajeCostoProducto * valorAdicionalPesos;
								Double costoTotalProductoMasAdicional = costoProductoSinIva + valorAdicionalProducto;
								
								valor.setCostoTotal((costoTotalProductoMasAdicional * entity.getValorFactura()) / entity.getSubTotalFactura());
								valor.setValorIva(valor.getCostoTotal() - costoTotalProductoMasAdicional);
								valor.setValorUnitario(valor.getCostoTotal() / valorDto.getCantidadCompra());								
							}
							
						} else {

							valor.setCostoTotal(valorDto.getCostoTotal());
							valor.setValorIva(valorDto.getValorIva());
							valor.setValorUnitario(valorDto.getValorUnitario());
						}

						valor.setCompania(valorDto.getCompania());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setPersEmpr(valorDto.getPersEmprId_PersEmpr() != null ? logicPersEmpr1.getPersEmpr(valorDto.getPersEmprId_PersEmpr()) : null);
						valor.setUbicacionesAlmacenId(valorDto.getUbicacionesAlmacenId());
						valor.setEquipoId(valorDto.getEquipoId());
						valor.setConceptoKardexId(valorDto.getConceptoKardexId());
						valor.setProducto(valorDto.getProductoId_Producto() != null ? logicProducto2.getProducto(valorDto.getProductoId_Producto()) : null);
						valor.setTrabajador(valorDto.getTrabId_Trabajador() != null ? logicTrabajador3.getTrabajador(valorDto.getTrabId_Trabajador()) : null);
						valor.setPorcIva(valorDto.getPorcIva());
						valor.setTipoMovimiento(valorDto.getTipoMovimiento());
						valor.setNumFacturaCompra(valorDto.getNumFacturaCompra());
						valor.setInfoAdicional(valorDto.getInfoAdicional());
						valor.setDatCompraMateriaPrimaId(entity.getDatCompraMateriaPrimaId());

						precioPromMateriaPrimaDAO.update(valor);
						
					}
				}
			}

            log.debug("update DatCompraMateriaPrima successful");
        } catch (Exception e) {
            log.error("update DatCompraMateriaPrima failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<DatCompraMateriaPrimaDTO> getDataDatCompraMateriaPrima()
        throws Exception {
        try {
            List<DatCompraMateriaPrima> datCompraMateriaPrima = datCompraMateriaPrimaDAO.findAll();

            List<DatCompraMateriaPrimaDTO> datCompraMateriaPrimaDTO = new ArrayList<DatCompraMateriaPrimaDTO>();

            for (DatCompraMateriaPrima datCompraMateriaPrimaTmp : datCompraMateriaPrima) {
                DatCompraMateriaPrimaDTO datCompraMateriaPrimaDTO2 = new DatCompraMateriaPrimaDTO();

                datCompraMateriaPrimaDTO2.setDatCompraMateriaPrimaId(datCompraMateriaPrimaTmp.getDatCompraMateriaPrimaId());
                datCompraMateriaPrimaDTO2.setCompania((datCompraMateriaPrimaTmp.getCompania() != null)
                    ? datCompraMateriaPrimaTmp.getCompania() : null);
                datCompraMateriaPrimaDTO2.setConsecutivo((datCompraMateriaPrimaTmp.getConsecutivo() != null)
                    ? datCompraMateriaPrimaTmp.getConsecutivo() : null);
                datCompraMateriaPrimaDTO2.setDatMantenimientoEquipoId((datCompraMateriaPrimaTmp.getDatMantenimientoEquipoId() != null)
                    ? datCompraMateriaPrimaTmp.getDatMantenimientoEquipoId()
                    : null);
                datCompraMateriaPrimaDTO2.setDetalleNota((datCompraMateriaPrimaTmp.getDetalleNota() != null)
                    ? datCompraMateriaPrimaTmp.getDetalleNota() : null);
                datCompraMateriaPrimaDTO2.setEstado((datCompraMateriaPrimaTmp.getEstado() != null)
                    ? datCompraMateriaPrimaTmp.getEstado() : null);
                datCompraMateriaPrimaDTO2.setFechaAnulacion(datCompraMateriaPrimaTmp.getFechaAnulacion());
                datCompraMateriaPrimaDTO2.setFechaCreacion(datCompraMateriaPrimaTmp.getFechaCreacion());
                datCompraMateriaPrimaDTO2.setFechaModificacion(datCompraMateriaPrimaTmp.getFechaModificacion());
                datCompraMateriaPrimaDTO2.setFechaRegistro(datCompraMateriaPrimaTmp.getFechaRegistro());
                datCompraMateriaPrimaDTO2.setNumFactura((datCompraMateriaPrimaTmp.getNumFactura() != null)
                    ? datCompraMateriaPrimaTmp.getNumFactura() : null);
                datCompraMateriaPrimaDTO2.setObservacion((datCompraMateriaPrimaTmp.getObservacion() != null)
                    ? datCompraMateriaPrimaTmp.getObservacion() : null);
                datCompraMateriaPrimaDTO2.setObservacionAnularReg((datCompraMateriaPrimaTmp.getObservacionAnularReg() != null)
                    ? datCompraMateriaPrimaTmp.getObservacionAnularReg() : null);
                datCompraMateriaPrimaDTO2.setProvComisiones((datCompraMateriaPrimaTmp.getProvComisiones() != null)
                    ? datCompraMateriaPrimaTmp.getProvComisiones() : null);
                datCompraMateriaPrimaDTO2.setProvGastosNacionales((datCompraMateriaPrimaTmp.getProvGastosNacionales() != null)
                    ? datCompraMateriaPrimaTmp.getProvGastosNacionales() : null);
                datCompraMateriaPrimaDTO2.setProvImpuestosAranceles((datCompraMateriaPrimaTmp.getProvImpuestosAranceles() != null)
                    ? datCompraMateriaPrimaTmp.getProvImpuestosAranceles() : null);
                datCompraMateriaPrimaDTO2.setProvOtros((datCompraMateriaPrimaTmp.getProvOtros() != null)
                    ? datCompraMateriaPrimaTmp.getProvOtros() : null);
                datCompraMateriaPrimaDTO2.setProvTransporteFlete((datCompraMateriaPrimaTmp.getProvTransporteFlete() != null)
                    ? datCompraMateriaPrimaTmp.getProvTransporteFlete() : null);
                datCompraMateriaPrimaDTO2.setSubTotalFactura((datCompraMateriaPrimaTmp.getSubTotalFactura() != null)
                    ? datCompraMateriaPrimaTmp.getSubTotalFactura() : null);
                datCompraMateriaPrimaDTO2.setTasaConversionTrm((datCompraMateriaPrimaTmp.getTasaConversionTrm() != null)
                    ? datCompraMateriaPrimaTmp.getTasaConversionTrm() : null);
                datCompraMateriaPrimaDTO2.setTipoMoneda((datCompraMateriaPrimaTmp.getTipoMoneda() != null)
                    ? datCompraMateriaPrimaTmp.getTipoMoneda() : null);
                datCompraMateriaPrimaDTO2.setTransportadoraFactura((datCompraMateriaPrimaTmp.getTransportadoraFactura() != null)
                    ? datCompraMateriaPrimaTmp.getTransportadoraFactura() : null);
                datCompraMateriaPrimaDTO2.setTransportadoraNguia((datCompraMateriaPrimaTmp.getTransportadoraNguia() != null)
                    ? datCompraMateriaPrimaTmp.getTransportadoraNguia() : null);
                datCompraMateriaPrimaDTO2.setTransportadoraValorFlete((datCompraMateriaPrimaTmp.getTransportadoraValorFlete() != null)
                    ? datCompraMateriaPrimaTmp.getTransportadoraValorFlete()
                    : null);
                datCompraMateriaPrimaDTO2.setUsuarioDigitacion((datCompraMateriaPrimaTmp.getUsuarioDigitacion() != null)
                    ? datCompraMateriaPrimaTmp.getUsuarioDigitacion() : null);
                datCompraMateriaPrimaDTO2.setValComisiones((datCompraMateriaPrimaTmp.getValComisiones() != null)
                    ? datCompraMateriaPrimaTmp.getValComisiones() : null);
                datCompraMateriaPrimaDTO2.setValGastosNacionales((datCompraMateriaPrimaTmp.getValGastosNacionales() != null)
                    ? datCompraMateriaPrimaTmp.getValGastosNacionales() : null);
                datCompraMateriaPrimaDTO2.setValImpuestosAranceles((datCompraMateriaPrimaTmp.getValImpuestosAranceles() != null)
                    ? datCompraMateriaPrimaTmp.getValImpuestosAranceles() : null);
                datCompraMateriaPrimaDTO2.setValOtros((datCompraMateriaPrimaTmp.getValOtros() != null)
                    ? datCompraMateriaPrimaTmp.getValOtros() : null);
                datCompraMateriaPrimaDTO2.setValSumaProvs((datCompraMateriaPrimaTmp.getValSumaProvs() != null)
                    ? datCompraMateriaPrimaTmp.getValSumaProvs() : null);
                datCompraMateriaPrimaDTO2.setValTransporteFlete((datCompraMateriaPrimaTmp.getValTransporteFlete() != null)
                    ? datCompraMateriaPrimaTmp.getValTransporteFlete() : null);
                datCompraMateriaPrimaDTO2.setValorAdicional((datCompraMateriaPrimaTmp.getValorAdicional() != null)
                    ? datCompraMateriaPrimaTmp.getValorAdicional() : null);
                datCompraMateriaPrimaDTO2.setValorDescuento((datCompraMateriaPrimaTmp.getValorDescuento() != null)
                    ? datCompraMateriaPrimaTmp.getValorDescuento() : null);
                datCompraMateriaPrimaDTO2.setValorFactura((datCompraMateriaPrimaTmp.getValorFactura() != null)
                    ? datCompraMateriaPrimaTmp.getValorFactura() : null);
                datCompraMateriaPrimaDTO2.setValorIva((datCompraMateriaPrimaTmp.getValorIva() != null)
                    ? datCompraMateriaPrimaTmp.getValorIva() : null);
                datCompraMateriaPrimaDTO2.setPersEmprId_PersEmpr((datCompraMateriaPrimaTmp.getPersEmpr()
                                                                                          .getPersEmprId() != null)
                    ? datCompraMateriaPrimaTmp.getPersEmpr().getPersEmprId()
                    : null);
                datCompraMateriaPrimaDTO.add(datCompraMateriaPrimaDTO2);
            }

            return datCompraMateriaPrimaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public DatCompraMateriaPrima getDatCompraMateriaPrima(
        Long datCompraMateriaPrimaId) throws Exception {
        log.debug("getting DatCompraMateriaPrima instance");

        DatCompraMateriaPrima entity = null;

        try {
            entity = datCompraMateriaPrimaDAO.findById(datCompraMateriaPrimaId);
        } catch (Exception e) {
            log.error("get DatCompraMateriaPrima failed", e);
            throw new ZMessManager().new FindingException(
                "DatCompraMateriaPrima");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<DatCompraMateriaPrima> findPageDatCompraMateriaPrima(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<DatCompraMateriaPrima> entity = null;

        try {
            entity = datCompraMateriaPrimaDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatCompraMateriaPrima Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberDatCompraMateriaPrima()
        throws Exception {
        Long entity = null;

        try {
            entity = datCompraMateriaPrimaDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatCompraMateriaPrima Count");
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
    public List<DatCompraMateriaPrima> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<DatCompraMateriaPrima> list = new ArrayList<DatCompraMateriaPrima>();
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
            list = datCompraMateriaPrimaDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
