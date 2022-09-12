package co.com.arcosoft.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.arcosoft.dataaccess.dao.IDatCompraProductosDAO;
import co.com.arcosoft.dataaccess.dao.IPrecioPromProdDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatCompraProductos;
import co.com.arcosoft.modelo.PrecioPromProd;
import co.com.arcosoft.modelo.dto.DatCompraProductosDTO;
import co.com.arcosoft.modelo.dto.PrecioPromProdDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("DatCompraProductosLogic")
public class DatCompraProductosLogic implements IDatCompraProductosLogic {
	private static final Logger log = LoggerFactory.getLogger(DatCompraProductosLogic.class);

	/**
	 * DAO injected by Spring that manages DatCompraProductos entities
	 *
	 */
	@Autowired
	private IDatCompraProductosDAO datCompraProductosDAO;

	/**
	 * Logic injected by Spring that manages PersEmpr entities
	 *
	 */
	@Autowired
	IPersEmprLogic logicPersEmpr1;

	@Autowired
	private IPrecioPromProdDAO precioPromProdDAO;

	@Transactional(readOnly = true)
	public List<DatCompraProductos> getDatCompraProductos() throws Exception {
		log.debug("finding all DatCompraProductos instances");

		List<DatCompraProductos> list = new ArrayList<DatCompraProductos>();

		try {
			list = datCompraProductosDAO.findAll();
		} catch (Exception e) {
			log.error("finding all DatCompraProductos failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "DatCompraProductos");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDatCompraProductos(DatCompraProductos entity, List<PrecioPromProdDTO> dataDetPrecioProductos, Double valorFactura, Double totalSuma)
			throws Exception {
		log.debug("saving DatCompraProductos instance");

		try {
			if (entity.getPersEmpr() == null) {
				throw new ZMessManager().new ForeignException("persEmpr");
			}

			if ((entity.getDetalleNota() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getDetalleNota(), 3900) == false)) {
				throw new ZMessManager().new NotValidFormatException("detalleNota");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 3900) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacionAnularReg");
			}

			if ((entity.getTasaConversionTrm() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTasaConversionTrm(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("tasaConversionTrm");
			}

			if ((entity.getTipoMoneda() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTipoMoneda(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoMoneda");
			}

			if (entity.getPersEmpr().getPersEmprId() == null) {
				throw new ZMessManager().new EmptyFieldException("persEmprId_PersEmpr");
			}

			datCompraProductosDAO.save(entity);
			if (dataDetPrecioProductos != null) {
				Double subTotalProductoConIva =0.0;
				Double valorFacturaProductoConIva=0.0;
				for (PrecioPromProdDTO valorDto : dataDetPrecioProductos) {
					if(valorDto.getValorIva()!=null && valorDto.getValorIva()>0) {
					subTotalProductoConIva+=valorDto.getCostoTotal() - valorDto.getValorIva();
					valorFacturaProductoConIva+=valorDto.getCostoTotal();
					}
				}
				for (PrecioPromProdDTO valorDto : dataDetPrecioProductos) {

					if (valorDto.getPrecioProdId() == null) {

						PrecioPromProd valor = new PrecioPromProd();
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
						valor.setTransportadora_nguia(entity.getTransportadora_nguia());
						valor.setTransportadora_valor_flete(entity.getTransportadora_valor_flete());

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
									Double subTotalFacturaMasDescuento =subTotalProductoConIva ;//+ entity.getValorDescuento();
									Double costoProductoSinIva = valorDto.getCostoTotal() - valorDto.getValorIva();
									Double porcentajeCostoProducto = costoProductoSinIva / subTotalFacturaMasDescuento;
									Double valorDescuentoProducto = porcentajeCostoProducto * entity.getValorDescuento();
									Double costoTotalProductoMenosDescuento = costoProductoSinIva - valorDescuentoProducto;
									
									valor.setCostoTotal((costoTotalProductoMenosDescuento * valorFacturaProductoConIva) /subTotalProductoConIva);
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
						
						if (totalSuma != null && totalSuma > 0) {
							/***valor total**/
							Double valSinProv = valorFactura - totalSuma;
							Double porcEquiv = (valor.getCostoTotal() * 100)/ valSinProv;
							Double parteCor = (totalSuma * porcEquiv) / 100;
							valor.setCostoTotal(valor.getCostoTotal() + parteCor);
						
							/**val unitario**/
							
						
							valor.setValorUnitario( (double) Math.round((valor.getCostoTotal()/valor.getCantidadCompra())*100)/100);
							
						
						}

						valor.setCompania(valorDto.getCompania());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setPersEmpr(valorDto.getPersEmprId_PersEmpr());
						valor.setEquipoId(valorDto.getEquipoId());
						valor.setConceptoKardexId(valorDto.getConceptoKardexId());
						valor.setProducto(valorDto.getProducto());
						valor.setTrabajador(valorDto.getTrabajador());
						valor.setPorcIva(valorDto.getPorcIva());
						valor.setUbicacionesAlmacen(valorDto.getUbicacionesAlmacen());

						valor.setTipoMovimiento(valorDto.getTipoMovimiento());
						valor.setNumFacturaCompra(valorDto.getNumFacturaCompra());
						valor.setInfoAdicional(valorDto.getInfoAdicional());

						valor.setUsuarioDigitacion(entity.getUsuarioDigitacion());
						valor.setDatCompraProductosId(entity);

						precioPromProdDAO.save(valor);
					}
				}
			}
			
			log.debug("save DatCompraProductos successful");
		} catch (Exception e) {
			log.error("save DatCompraProductos failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDatCompraProductos(DatCompraProductos entity) throws Exception {
		log.debug("deleting DatCompraProductos instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DatCompraProductos");
		}

		if (entity.getDatCompraProductosId() == null) {
			throw new ZMessManager().new EmptyFieldException("datCompraProductosId");
		}

		try {
			datCompraProductosDAO.delete(entity);

			log.debug("delete DatCompraProductos successful");
		} catch (Exception e) {
			log.error("delete DatCompraProductos failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDatCompraProductos(DatCompraProductos entity, List<PrecioPromProdDTO> dataDetPrecioProductos)
			throws Exception {
		log.debug("updating DatCompraProductos instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("DatCompraProductos");
			}

			if (entity.getPersEmpr() == null) {
				throw new ZMessManager().new ForeignException("persEmpr");
			}

			if ((entity.getDetalleNota() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getDetalleNota(), 3900) == false)) {
				throw new ZMessManager().new NotValidFormatException("detalleNota");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 3900) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacionAnularReg");
			}

			if ((entity.getTasaConversionTrm() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTasaConversionTrm(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("tasaConversionTrm");
			}

			if ((entity.getTipoMoneda() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTipoMoneda(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoMoneda");
			}

			if (entity.getPersEmpr().getPersEmprId() == null) {
				throw new ZMessManager().new EmptyFieldException("persEmprId_PersEmpr");
			}

			datCompraProductosDAO.update(entity);
			if (dataDetPrecioProductos != null) {

				for (PrecioPromProdDTO valorDto : dataDetPrecioProductos) {

					if (valorDto.getPrecioProdId() == null) {

						PrecioPromProd valor = new PrecioPromProd();
						valor.setConsecutivo(entity.getConsecutivo());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaVencimiento(valorDto.getFechaVencimiento());
						valor.setCantidadCompra(valorDto.getCantidadCompra());
						valor.setUnidadMedida(valorDto.getUnidadMedida());
						valor.setLoteCompraProducto(valorDto.getLoteCompraProducto());
						valor.setRegistroIca(valorDto.getRegistroIca());
						valor.setAlmacenId(valorDto.getAlmacenId());
						valor.setTransportadoraFactura(entity.getTransportadoraFactura());
						valor.setTransportadora_nguia(entity.getTransportadora_nguia());
						valor.setTransportadora_valor_flete(entity.getTransportadora_valor_flete());
						valor.setOrigenDatos(valorDto.getOrigenDatos());

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
						valor.setPersEmpr(valorDto.getPersEmprId_PersEmpr());
						valor.setUbicacionesAlmacen(valorDto.getUbicacionesAlmacen());
						valor.setEquipoId(valorDto.getEquipoId());
						valor.setConceptoKardexId(valorDto.getConceptoKardexId());
						valor.setProducto(valorDto.getProducto());
						valor.setTrabajador(valorDto.getTrabajador());
						valor.setPorcIva(valorDto.getPorcIva());
						valor.setTipoMovimiento(valorDto.getTipoMovimiento());
						valor.setNumFacturaCompra(valorDto.getNumFacturaCompra());
						valor.setInfoAdicional(valorDto.getInfoAdicional());
						valor.setDatCompraProductosId(entity);

						precioPromProdDAO.save(valor);
						
					} else {
						
						PrecioPromProd valor = precioPromProdDAO.findById(valorDto.getPrecioProdId());
						
						valor.setConsecutivo(entity.getConsecutivo());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaVencimiento(valorDto.getFechaVencimiento());
						valor.setCantidadCompra(valorDto.getCantidadCompra());
						valor.setUnidadMedida(valorDto.getUnidadMedida());
						valor.setLoteCompraProducto(valorDto.getLoteCompraProducto());
						valor.setRegistroIca(valorDto.getRegistroIca());
						valor.setAlmacenId(valorDto.getAlmacenId());
						valor.setTransportadoraFactura(entity.getTransportadoraFactura());
						valor.setTransportadora_nguia(entity.getTransportadora_nguia());
						valor.setTransportadora_valor_flete(entity.getTransportadora_valor_flete());

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
						valor.setPersEmpr(valorDto.getPersEmprId_PersEmpr());
						valor.setEquipoId(valorDto.getEquipoId());
						valor.setConceptoKardexId(valorDto.getConceptoKardexId());
						valor.setProducto(valorDto.getProducto());
						valor.setUbicacionesAlmacen(valorDto.getUbicacionesAlmacen());
						valor.setTrabajador(valorDto.getTrabajador());
						valor.setPorcIva(valorDto.getPorcIva());
						valor.setTipoMovimiento(valorDto.getTipoMovimiento());
						valor.setNumFacturaCompra(valorDto.getNumFacturaCompra());
						valor.setInfoAdicional(valorDto.getInfoAdicional());
						valor.setDatCompraProductosId(entity);

						precioPromProdDAO.update(valor);
					}

				}
			}

			log.debug("update DatCompraProductos successful");
		} catch (Exception e) {
			log.error("update DatCompraProductos failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<DatCompraProductosDTO> getDataDatCompraProductos() throws Exception {
		try {
			List<DatCompraProductos> datCompraProductos = datCompraProductosDAO.findAll();

			List<DatCompraProductosDTO> datCompraProductosDTO = new ArrayList<DatCompraProductosDTO>();

			for (DatCompraProductos datCompraProductosTmp : datCompraProductos) {
				DatCompraProductosDTO datCompraProductosDTO2 = new DatCompraProductosDTO();

				datCompraProductosDTO2.setDatCompraProductosId(datCompraProductosTmp.getDatCompraProductosId());
				datCompraProductosDTO2.setCompania(
						(datCompraProductosTmp.getCompania() != null) ? datCompraProductosTmp.getCompania() : null);
				datCompraProductosDTO2.setConsecutivo(
						(datCompraProductosTmp.getConsecutivo() != null) ? datCompraProductosTmp.getConsecutivo()
								: null);
				datCompraProductosDTO2.setDetalleNota(
						(datCompraProductosTmp.getDetalleNota() != null) ? datCompraProductosTmp.getDetalleNota()
								: null);
				datCompraProductosDTO2.setEstado(
						(datCompraProductosTmp.getEstado() != null) ? datCompraProductosTmp.getEstado() : null);
				datCompraProductosDTO2.setFechaAnulacion(datCompraProductosTmp.getFechaAnulacion());
				datCompraProductosDTO2.setFechaCreacion(datCompraProductosTmp.getFechaCreacion());
				datCompraProductosDTO2.setFechaModificacion(datCompraProductosTmp.getFechaModificacion());
				datCompraProductosDTO2.setFechaRegistro(datCompraProductosTmp.getFechaRegistro());
				datCompraProductosDTO2.setNumFactura(
						(datCompraProductosTmp.getNumFactura() != null) ? datCompraProductosTmp.getNumFactura() : null);
				datCompraProductosDTO2.setObservacion(
						(datCompraProductosTmp.getObservacion() != null) ? datCompraProductosTmp.getObservacion()
								: null);
				datCompraProductosDTO2.setObservacionAnularReg((datCompraProductosTmp.getObservacionAnularReg() != null)
						? datCompraProductosTmp.getObservacionAnularReg()
						: null);
				datCompraProductosDTO2.setTasaConversionTrm((datCompraProductosTmp.getTasaConversionTrm() != null)
						? datCompraProductosTmp.getTasaConversionTrm()
						: null);
				datCompraProductosDTO2.setTipoMoneda(
						(datCompraProductosTmp.getTipoMoneda() != null) ? datCompraProductosTmp.getTipoMoneda() : null);
				datCompraProductosDTO2.setUsuarioDigitacion((datCompraProductosTmp.getUsuarioDigitacion() != null)
						? datCompraProductosTmp.getUsuarioDigitacion()
						: null);
				datCompraProductosDTO2.setValorDescuento(
						(datCompraProductosTmp.getValorDescuento() != null) ? datCompraProductosTmp.getValorDescuento()
								: null);
				datCompraProductosDTO2.setValorFactura(
						(datCompraProductosTmp.getValorFactura() != null) ? datCompraProductosTmp.getValorFactura()
								: null);
				datCompraProductosDTO2.setValorIva(
						(datCompraProductosTmp.getValorIva() != null) ? datCompraProductosTmp.getValorIva() : null);

				if (datCompraProductosTmp.getPersEmpr() != null) {
					datCompraProductosDTO2.setPersEmprId_PersEmpr(datCompraProductosTmp.getPersEmpr().getPersEmprId());
				} else {
					datCompraProductosDTO2.setPersEmprId_PersEmpr(null);
				}

				if (datCompraProductosTmp.getPersEmpr() != null) {
					datCompraProductosDTO2.setNomProveedor(datCompraProductosTmp.getPersEmpr().getNombre());
				} else {
					datCompraProductosDTO2.setNomProveedor(null);
				}
				datCompraProductosDTO2.setSubTotalFactura((datCompraProductosTmp.getSubTotalFactura() != null)
						? datCompraProductosTmp.getSubTotalFactura()
						: null);

				datCompraProductosDTO2.setValorDescuento(
						(datCompraProductosTmp.getValorDescuento() != null) ? datCompraProductosTmp.getValorDescuento()
								: null);

				datCompraProductosDTO2.setValorAdicional(
						(datCompraProductosTmp.getValorAdicional() != null) ? datCompraProductosTmp.getValorAdicional()
								: null);

				datCompraProductosDTO2
						.setTransportadoraFactura((datCompraProductosTmp.getTransportadoraFactura() != null)
								? datCompraProductosTmp.getTransportadoraFactura()
								: null);

				datCompraProductosDTO2.setTransportadora_nguia((datCompraProductosTmp.getTransportadora_nguia() != null)
						? datCompraProductosTmp.getTransportadora_nguia()
						: null);

				datCompraProductosDTO2.setTransportadora_valor_flete((datCompraProductosTmp.getTransportadora_valor_flete() != null)
						? datCompraProductosTmp.getTransportadora_valor_flete()
						: null);

				if (datCompraProductosTmp.getDatMantenimientoEquipoId() != null) {
					datCompraProductosDTO2.setDatMantenimientoEquipoId(
							datCompraProductosTmp.getDatMantenimientoEquipoId().getDatMantenimientoEquipoId());
				} else {
					datCompraProductosDTO2.setDatMantenimientoEquipoId(null);
				}

				if (datCompraProductosTmp.getDatMantenimientoEquipoId() != null) {
					datCompraProductosDTO2.setNumeroOrdenTrabajo(
							datCompraProductosTmp.getDatMantenimientoEquipoId().getConsecutivo());
				} else {
					datCompraProductosDTO2.setNumeroOrdenTrabajo(null);
				}

				datCompraProductosDTO2.setProvTransporteFlete((datCompraProductosTmp.getProvTransporteFlete() != null)
						? datCompraProductosTmp.getProvTransporteFlete() : null);
				datCompraProductosDTO2.setProvGastosNacionales((datCompraProductosTmp.getProvGastosNacionales() != null)
						? datCompraProductosTmp.getProvGastosNacionales() : null);
				datCompraProductosDTO2.setProvImpuestosAranceles((datCompraProductosTmp.getProvImpuestosAranceles() != null)
						? datCompraProductosTmp.getProvImpuestosAranceles() : null);
				datCompraProductosDTO2.setProvComisiones((datCompraProductosTmp.getProvComisiones() != null)
						? datCompraProductosTmp.getProvComisiones() : null);
				datCompraProductosDTO2.setProvOtros((datCompraProductosTmp.getProvOtros() != null)
						? datCompraProductosTmp.getProvOtros() : null);

				datCompraProductosDTO2.setValTransporteFlete((datCompraProductosTmp.getValTransporteFlete() != null)
						? datCompraProductosTmp.getValTransporteFlete() : null);
				datCompraProductosDTO2.setValGastosNacionales((datCompraProductosTmp.getValGastosNacionales() != null)
						? datCompraProductosTmp.getValGastosNacionales() : null);
				datCompraProductosDTO2.setValImpuestosAranceles((datCompraProductosTmp.getValImpuestosAranceles() != null)
						? datCompraProductosTmp.getValImpuestosAranceles() : null);
				datCompraProductosDTO2.setValComisiones((datCompraProductosTmp.getValComisiones() != null)
						? datCompraProductosTmp.getValComisiones() : null);
				datCompraProductosDTO2.setValOtros((datCompraProductosTmp.getValOtros() != null)
						? datCompraProductosTmp.getValOtros() : null);
				datCompraProductosDTO2.setValSumaProvs((datCompraProductosTmp.getValSumaProvs() != null)
						? datCompraProductosTmp.getValSumaProvs() : null);

				datCompraProductosDTO2.setReferenciaCompraMp((datCompraProductosTmp.getReferenciaCompraMp() != null)
						? datCompraProductosTmp.getReferenciaCompraMp() : null);

				datCompraProductosDTO2.setTipoCompra((datCompraProductosTmp.getTipoCompra() != null)
						? datCompraProductosTmp.getTipoCompra() : null);

				 
				datCompraProductosDTO.add(datCompraProductosDTO2);
			}

			return datCompraProductosDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public DatCompraProductos getDatCompraProductos(Long datCompraProductosId) throws Exception {
		log.debug("getting DatCompraProductos instance");

		DatCompraProductos entity = null;

		try {
			entity = datCompraProductosDAO.findById(datCompraProductosId);
		} catch (Exception e) {
			log.error("get DatCompraProductos failed", e);
			throw new ZMessManager().new FindingException("DatCompraProductos");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<DatCompraProductos> findPageDatCompraProductos(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		List<DatCompraProductos> entity = null;

		try {
			entity = datCompraProductosDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatCompraProductos Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberDatCompraProductos() throws Exception {
		Long entity = null;

		try {
			entity = datCompraProductosDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatCompraProductos Count");
		} finally {
		}

		return entity;
	}

	/**
	 *
	 * @param varibles                 este arreglo debera tener:
	 *
	 *                                 [0] = String variable = (String) varibles[i];
	 *                                 representa como se llama la variable en el
	 *                                 pojo
	 *
	 *                                 [1] = Boolean booVariable = (Boolean)
	 *                                 varibles[i + 1]; representa si el valor
	 *                                 necesita o no ''(comillas simples)usado para
	 *                                 campos de tipo string
	 *
	 *                                 [2] = Object value = varibles[i + 2];
	 *                                 representa el valor que se va a buscar en la
	 *                                 BD
	 *
	 *                                 [3] = String comparator = (String) varibles[i
	 *                                 + 3]; representa que tipo de busqueda voy a
	 *                                 hacer.., ejemplo: where nombre=william o
	 *                                 where nombre<>william, en este campo iria el
	 *                                 tipo de comparador que quiero si es = o <>
	 *
	 *                                 Se itera de 4 en 4..., entonces 4 registros
	 *                                 del arreglo representan 1 busqueda en un
	 *                                 campo, si se ponen mas pues el continuara
	 *                                 buscando en lo que se le ingresen en los
	 *                                 otros 4
	 *
	 *
	 * @param variablesBetween
	 *
	 *                                 la diferencia son estas dos posiciones
	 *
	 *                                 [0] = String variable = (String) varibles[j];
	 *                                 la variable ne la BD que va a ser buscada en
	 *                                 un rango
	 *
	 *                                 [1] = Object value = varibles[j + 1]; valor 1
	 *                                 para buscar en un rango
	 *
	 *                                 [2] = Object value2 = varibles[j + 2]; valor
	 *                                 2 para buscar en un rango ejempolo: a > 1 and
	 *                                 a < 5 --> 1 seria value y 5 seria value2
	 *
	 *                                 [3] = String comparator1 = (String)
	 *                                 varibles[j + 3]; comparador 1 ejemplo: a
	 *                                 comparator1 1 and a < 5
	 *
	 *                                 [4] = String comparator2 = (String)
	 *                                 varibles[j + 4]; comparador 2 ejemplo: a
	 *                                 comparador1>1 and a comparador2<5 (el
	 *                                 original: a > 1 and a < 5) *
	 * @param variablesBetweenDates(en este caso solo para mysql) [0] = String
	 *                                 variable = (String) varibles[k]; el nombre de
	 *                                 la variable que hace referencia a una fecha
	 *
	 *                                 [1] = Object object1 = varibles[k + 2]; fecha
	 *                                 1 a comparar(deben ser dates)
	 *
	 *                                 [2] = Object object2 = varibles[k + 3]; fecha
	 *                                 2 a comparar(deben ser dates)
	 *
	 *                                 esto hace un between entre las dos fechas.
	 *
	 * @return lista con los objetos que se necesiten
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public List<DatCompraProductos> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<DatCompraProductos> list = new ArrayList<DatCompraProductos>();
		String where = new String();
		String tempWhere = new String();

		if (variables != null) {
			for (int i = 0; i < variables.length; i++) {
				if ((variables[i] != null) && (variables[i + 1] != null) && (variables[i + 2] != null)
						&& (variables[i + 3] != null)) {
					String variable = (String) variables[i];
					Boolean booVariable = (Boolean) variables[i + 1];
					Object value = variables[i + 2];
					String comparator = (String) variables[i + 3];

					if (booVariable.booleanValue()) {
						tempWhere = (tempWhere.length() == 0)
								? ("(model." + variable + " " + comparator + " \'" + value + "\' )")
								: (tempWhere + " AND (model." + variable + " " + comparator + " \'" + value + "\' )");
					} else {
						tempWhere = (tempWhere.length() == 0)
								? ("(model." + variable + " " + comparator + " " + value + " )")
								: (tempWhere + " AND (model." + variable + " " + comparator + " " + value + " )");
					}
				}

				i = i + 3;
			}
		}

		if (variablesBetween != null) {
			for (int j = 0; j < variablesBetween.length; j++) {
				if ((variablesBetween[j] != null) && (variablesBetween[j + 1] != null)
						&& (variablesBetween[j + 2] != null) && (variablesBetween[j + 3] != null)
						&& (variablesBetween[j + 4] != null)) {
					String variable = (String) variablesBetween[j];
					Object value = variablesBetween[j + 1];
					Object value2 = variablesBetween[j + 2];
					String comparator1 = (String) variablesBetween[j + 3];
					String comparator2 = (String) variablesBetween[j + 4];
					tempWhere = (tempWhere.length() == 0)
							? ("(" + value + " " + comparator1 + " " + variable + " and " + variable + " " + comparator2
									+ " " + value2 + " )")
							: (tempWhere + " AND (" + value + " " + comparator1 + " " + variable + " and " + variable
									+ " " + comparator2 + " " + value2 + " )");
				}

				j = j + 4;
			}
		}

		if (variablesBetweenDates != null) {
			for (int k = 0; k < variablesBetweenDates.length; k++) {
				if ((variablesBetweenDates[k] != null) && (variablesBetweenDates[k + 1] != null)
						&& (variablesBetweenDates[k + 2] != null)) {
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
							? ("(model." + variable + " between \'" + value + "\' and \'" + value2 + "\')")
							: (tempWhere + " AND (model." + variable + " between \'" + value + "\' and \'" + value2
									+ "\')");
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
			list = datCompraProductosDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
