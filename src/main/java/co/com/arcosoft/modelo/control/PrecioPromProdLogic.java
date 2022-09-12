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

import co.com.arcosoft.dataaccess.dao.IPrecioPromProdDAO;
import co.com.arcosoft.dataaccess.dao.IValorVarDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.CentCost;
import co.com.arcosoft.modelo.PrecioPromProd;
import co.com.arcosoft.modelo.dto.PrecioPromProdDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("PrecioPromProdLogic")
public class PrecioPromProdLogic implements IPrecioPromProdLogic {
	private static final Logger log = LoggerFactory.getLogger(PrecioPromProdLogic.class);

	/**
	 * DAO injected by Spring that manages PrecioPromProd entities
	 *
	 */
	@Autowired
	private IPrecioPromProdDAO precioPromProdDAO;

	/**
	 * Logic injected by Spring that manages Producto entities
	 *
	 */
	@Autowired
	private ICentCostLogic logicCentCost;
	
	@Autowired
	private IEquipoLogic logicImplemento;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<PrecioPromProd> getPrecioPromProd() throws Exception {
		log.debug("finding all PrecioPromProd instances");

		List<PrecioPromProd> list = new ArrayList<PrecioPromProd>();

		try {
			list = precioPromProdDAO.findAll();
		} catch (Exception e) {
			log.error("finding all PrecioPromProd failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "PrecioPromProd");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void savePrecioPromProd(PrecioPromProd entity) throws Exception {
		log.debug("saving PrecioPromProd instance");

		try {
			if (entity.getProducto() == null) {
				throw new ZMessManager().new ForeignException("producto");
			}

		
			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 1000) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 1000) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if ((entity.getPrecioProdId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getPrecioProdId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("precioProdId");
			}

	

			if (entity.getProducto().getProductoId() == null) {
				throw new ZMessManager().new EmptyFieldException("productoId_Producto");
			}

			if ((entity.getProducto().getProductoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getProducto().getProductoId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("productoId_Producto");
			}

		

			precioPromProdDAO.save(entity);

			log.debug("save PrecioPromProd successful");
		} catch (Exception e) {
			log.error("save PrecioPromProd failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deletePrecioPromProd(PrecioPromProd entity) throws Exception {
		log.debug("deleting PrecioPromProd instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("PrecioPromProd");
		}

		if (entity.getPrecioProdId() == null) {
			throw new ZMessManager().new EmptyFieldException("precioProdId");
		}

		try {
			precioPromProdDAO.delete(entity);

			log.debug("delete PrecioPromProd successful");
		} catch (Exception e) {
			log.error("delete PrecioPromProd failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updatePrecioPromProd(PrecioPromProd entity) throws Exception {
		log.debug("updating PrecioPromProd instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("PrecioPromProd");
			}

			if (entity.getProducto() == null) {
				throw new ZMessManager().new ForeignException("producto");
			}

	
			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 1000) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 1000) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if (entity.getPrecioProdId() == null) {
				throw new ZMessManager().new EmptyFieldException("precioProdId");
			}

			if ((entity.getPrecioProdId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getPrecioProdId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("precioProdId");
			}

		

			if (entity.getProducto().getProductoId() == null) {
				throw new ZMessManager().new EmptyFieldException("productoId_Producto");
			}

			if ((entity.getProducto().getProductoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getProducto().getProductoId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("productoId_Producto");
			}

			precioPromProdDAO.update(entity);

			log.debug("update PrecioPromProd successful");
		} catch (Exception e) {
			log.error("update PrecioPromProd failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<PrecioPromProdDTO> getDataPrecioPromProd(Double cantidadCompra) throws Exception {
		try {
			
			
			List<PrecioPromProd> precioPromProd = precioPromProdDAO
					.findByCriteria("cantidadCompra > " + cantidadCompra );

			List<PrecioPromProdDTO> precioPromProdDTO = new ArrayList<PrecioPromProdDTO>();
				for (PrecioPromProd precioPromProdTmp : precioPromProd) {
				PrecioPromProdDTO precioPromProdDTO2 = new PrecioPromProdDTO();

				precioPromProdDTO2.setPrecioProdId(precioPromProdTmp.getPrecioProdId());
				precioPromProdDTO2.setAlmacenId(
						(precioPromProdTmp.getAlmacenId() != null) ? precioPromProdTmp.getAlmacenId() : null);
				precioPromProdDTO2.setCompania(
						(precioPromProdTmp.getCompania() != null) ? precioPromProdTmp.getCompania() : null);
				precioPromProdDTO2.setFechaCreacion(precioPromProdTmp.getFechaCreacion());
				precioPromProdDTO2.setFechaFinal(precioPromProdTmp.getFechaFinal());
				precioPromProdDTO2.setFechaInicial(precioPromProdTmp.getFechaInicial());
				precioPromProdDTO2.setFechaModificacion(precioPromProdTmp.getFechaModificacion());
				precioPromProdDTO2.setOrigenDatos(precioPromProdTmp.getOrigenDatos());
				precioPromProdDTO2.setInfoAdicional(
						(precioPromProdTmp.getInfoAdicional() != null) ? precioPromProdTmp.getInfoAdicional() : null);
				precioPromProdDTO2.setInfoAdicional2(
						(precioPromProdTmp.getInfoAdicional2() != null) ? precioPromProdTmp.getInfoAdicional2() : null);
				precioPromProdDTO2.setValorUnitario(
						(precioPromProdTmp.getValorUnitario() != null) ? precioPromProdTmp.getValorUnitario() : null);
				
				precioPromProdDTO2.setEtapaId((precioPromProdTmp.getEtapaId() != null) ?
						precioPromProdTmp.getEtapaId() : null);
				precioPromProdDTO2.setVariedId((precioPromProdTmp.getVariedId() != null) ?
						precioPromProdTmp.getVariedId() : null);

				if (precioPromProdTmp.getProducto() != null) {
					precioPromProdDTO2.setProducto(precioPromProdTmp.getProducto());
				} else {
					precioPromProdDTO2.setProducto(null);
				}

				if (precioPromProdTmp.getProducto() != null) {
					precioPromProdDTO2.setCodProducto(precioPromProdTmp.getProducto().getCodigo());
				} else {
					precioPromProdDTO2.setCodProducto(null);
				}


				if (precioPromProdTmp.getProducto() != null) {
					precioPromProdDTO2.setNomProducto(precioPromProdTmp.getProducto().getNombre());
				} else {
					precioPromProdDTO2.setNomProducto(null);
				}
				
				if (precioPromProdTmp.getAlmacenId() != null) {
					precioPromProdDTO2.setCodAlmacen(precioPromProdTmp.getAlmacenId().getCodigo());
				} else {
					precioPromProdDTO2.setCodAlmacen(null);
				}

				if (precioPromProdTmp.getUnidadMedida() != null) {
					precioPromProdDTO2.setNombreUnidadMedida(precioPromProdTmp.getUnidadMedida().getCodigo());
				} else {
					precioPromProdDTO2.setNombreUnidadMedida(null);
				}

				if (precioPromProdTmp.getUbicacionesAlmacen() != null) {
					precioPromProdDTO2.setUbicacionesAlmacen(precioPromProdTmp.getUbicacionesAlmacen());
				} else {
					precioPromProdDTO2.setUbicacionesAlmacen(null);
				}

				if (precioPromProdTmp.getUbicacionesAlmacen() != null) {
					precioPromProdDTO2.setNomUbicacionesAlmacen(precioPromProdTmp.getUbicacionesAlmacen().getNombre());
				} else {
					precioPromProdDTO2.setNomUbicacionesAlmacen(null);
				}

				precioPromProdDTO2.setCantidadCompra(precioPromProdTmp.getCantidadCompra());
				precioPromProdDTO2.setFechaVencimiento(precioPromProdTmp.getFechaVencimiento());
				precioPromProdDTO2.setRegistroIca(precioPromProdTmp.getRegistroIca());
				precioPromProdDTO2.setLoteCompraProducto(precioPromProdTmp.getLoteCompraProducto());

				if (precioPromProdTmp.getPersEmpr() != null) {
					precioPromProdDTO2.setPersEmprId_PersEmpr(precioPromProdTmp.getPersEmpr());
				} else {
					precioPromProdDTO2.setPersEmprId_PersEmpr(null);
				}

				if (precioPromProdTmp.getPersEmpr() != null) {
					precioPromProdDTO2.setCodPersEmpr(precioPromProdTmp.getPersEmpr().getCodigo());
				} else {
					precioPromProdDTO2.setCodPersEmpr(null);
				}
 
				precioPromProdDTO2.setPorcIva(precioPromProdTmp.getPorcIva());
				precioPromProdDTO2.setValorIva(precioPromProdTmp.getValorIva());
				precioPromProdDTO2.setCostoTotal(precioPromProdTmp.getCostoTotal());
				precioPromProdDTO2.setNumFacturaCompra(precioPromProdTmp.getNumFacturaCompra());
				precioPromProdDTO2.setTipoMovimiento(precioPromProdTmp.getTipoMovimiento());			 
				
				if (precioPromProdTmp.getConceptoKardexId() != null) {
					precioPromProdDTO2.setConceptoKardexId(precioPromProdTmp.getConceptoKardexId());
				} else {
					precioPromProdDTO2.setConceptoKardexId(null);
				}
				
				if (precioPromProdTmp.getNivel2Id() != null) {
					precioPromProdDTO2.setNivel2Id_Nivel2(precioPromProdTmp.getNivel2Id());
				} else {
					precioPromProdDTO2.setNivel2Id_Nivel2(null);
				}
				
				if (precioPromProdTmp.getNivel2Id() != null) {
					precioPromProdDTO2.setCodNivel2(precioPromProdTmp.getNivel2Id().getCodigo());
				} else {
					precioPromProdDTO2.setCodNivel2(null);
				}
				
				if (precioPromProdTmp.getNivel4Id() != null) {
					precioPromProdDTO2.setNivel4Id_Nivel4(precioPromProdTmp.getNivel4Id());
				} else {
					precioPromProdDTO2.setNivel4Id_Nivel4(null);
				}
				
				if (precioPromProdTmp.getNivel4Id() != null) {
					precioPromProdDTO2.setCodNivel4(precioPromProdTmp.getNivel4Id().getCodigo());
				} else {
					precioPromProdDTO2.setCodNivel4(null);
				}

				if (precioPromProdTmp.getConceptoKardexId() != null) {
					precioPromProdDTO2.setCodConceptoKardex(precioPromProdTmp.getConceptoKardexId().getCodigo());
				} else {
					precioPromProdDTO2.setCodConceptoKardex(null);
				}

				if (precioPromProdTmp.getEquipoId() != null) {
					precioPromProdDTO2.setEquipoId(precioPromProdTmp.getEquipoId());
				} else {
					precioPromProdDTO2.setEquipoId(null);
				}

				if (precioPromProdTmp.getEquipoId() != null) {
					precioPromProdDTO2.setCodEquipo(precioPromProdTmp.getEquipoId().getCodigo());
				} else {
					precioPromProdDTO2.setCodEquipo(null);
				}
				
				if (precioPromProdTmp.getTrabajador() != null) {
					precioPromProdDTO2.setTrabajador(precioPromProdTmp.getTrabajador());
				} else {
					precioPromProdDTO2.setTrabajador(null);
				}

				if (precioPromProdTmp.getTrabajador() != null) {
					precioPromProdDTO2.setCodTrabajador(precioPromProdTmp.getTrabajador().getCodigo());
				} else {
					precioPromProdDTO2.setCodTrabajador(null);
				}
				if (precioPromProdTmp.getHorometro_abastecimiento() != null) {
					precioPromProdDTO2.setHorometro_abastecimiento(precioPromProdTmp.getHorometro_abastecimiento());
				} else {
					precioPromProdDTO2.setHorometro_abastecimiento(null);
				}
				precioPromProdDTO2.setIndicador_vuelta_medidor(
						(precioPromProdTmp.getIndicador_vuelta_medidor() != null) ? precioPromProdTmp.getIndicador_vuelta_medidor() : null);
				
				if (precioPromProdTmp.getImplementoId() != null) {
					precioPromProdDTO2.setImplementoId(precioPromProdTmp.getImplementoId().getEquipoId());
					precioPromProdDTO2.setCodImplemento(precioPromProdTmp.getImplementoId().getCodigo() +"-"+precioPromProdTmp.getImplementoId().getNombre());
				} else {
					precioPromProdDTO2.setCodImplemento(null);
					precioPromProdDTO2.setImplementoId(null);
				}
				if (precioPromProdTmp.getCentCostId() != null) {
					CentCost centCost = logicCentCost.getCentCost(precioPromProdTmp.getCentCostId());
					precioPromProdDTO2.setCentCostId(precioPromProdTmp.getCentCostId());
					precioPromProdDTO2.setNombreCentCost(centCost.getNombre());
				} else {
					precioPromProdDTO2.setCentCostId(null);
					precioPromProdDTO2.setNombreCentCost(null);	
				}
				
				if (precioPromProdTmp.getReferenciaFacCompra() != null) {
					precioPromProdDTO2.setReferenciaFacCompra(precioPromProdTmp.getReferenciaFacCompra());
				} else {
					precioPromProdDTO2.setReferenciaFacCompra(null);
					}
				if (precioPromProdTmp.getDescuentoProducto() != null) {
					precioPromProdDTO2.setDescuentoProducto(precioPromProdTmp.getDescuentoProducto());
				} else {
					precioPromProdDTO2.setDescuentoProducto(null);
					}
				precioPromProdDTO.add(precioPromProdDTO2);
			}

			return precioPromProdDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public PrecioPromProd getPrecioPromProd(Long precioProdId) throws Exception {
		log.debug("getting PrecioPromProd instance");

		PrecioPromProd entity = null;

		try {
			entity = precioPromProdDAO.findById(precioProdId);
		} catch (Exception e) {
			log.error("get PrecioPromProd failed", e);
			throw new ZMessManager().new FindingException("PrecioPromProd");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<PrecioPromProd> findPagePrecioPromProd(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<PrecioPromProd> entity = null;

		try {
			entity = precioPromProdDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("PrecioPromProd Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberPrecioPromProd() throws Exception {
		Long entity = null;

		try {
			entity = precioPromProdDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("PrecioPromProd Count");
		} finally {
		}

		return entity;
	}

	/**
	 *
	 * @param varibles
	 *            este arreglo debera tener:
	 *
	 *            [0] = String variable = (String) varibles[i]; representa como
	 *            se llama la variable en el pojo
	 *
	 *            [1] = Boolean booVariable = (Boolean) varibles[i + 1];
	 *            representa si el valor necesita o no ''(comillas simples)usado
	 *            para campos de tipo string
	 *
	 *            [2] = Object value = varibles[i + 2]; representa el valor que
	 *            se va a buscar en la BD
	 *
	 *            [3] = String comparator = (String) varibles[i + 3]; representa
	 *            que tipo de busqueda voy a hacer.., ejemplo: where
	 *            nombre=william o where nombre<>william, en este campo iria el
	 *            tipo de comparador que quiero si es = o <>
	 *
	 *            Se itera de 4 en 4..., entonces 4 registros del arreglo
	 *            representan 1 busqueda en un campo, si se ponen mas pues el
	 *            continuara buscando en lo que se le ingresen en los otros 4
	 *
	 *
	 * @param variablesBetween
	 *
	 *            la diferencia son estas dos posiciones
	 *
	 *            [0] = String variable = (String) varibles[j]; la variable ne
	 *            la BD que va a ser buscada en un rango
	 *
	 *            [1] = Object value = varibles[j + 1]; valor 1 para buscar en
	 *            un rango
	 *
	 *            [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en
	 *            un rango ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria
	 *            value2
	 *
	 *            [3] = String comparator1 = (String) varibles[j + 3];
	 *            comparador 1 ejemplo: a comparator1 1 and a < 5
	 *
	 *            [4] = String comparator2 = (String) varibles[j + 4];
	 *            comparador 2 ejemplo: a comparador1>1 and a comparador2<5 (el
	 *            original: a > 1 and a < 5) *
	 * @param variablesBetweenDates(en
	 *            este caso solo para mysql) [0] = String variable = (String)
	 *            varibles[k]; el nombre de la variable que hace referencia a
	 *            una fecha
	 *
	 *            [1] = Object object1 = varibles[k + 2]; fecha 1 a
	 *            comparar(deben ser dates)
	 *
	 *            [2] = Object object2 = varibles[k + 3]; fecha 2 a
	 *            comparar(deben ser dates)
	 *
	 *            esto hace un between entre las dos fechas.
	 *
	 * @return lista con los objetos que se necesiten
	 * @throws Exception
	 */
	@Override
	@Transactional(readOnly = true)
	public List<PrecioPromProd> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<PrecioPromProd> list = new ArrayList<PrecioPromProd>();
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
							? ("(model." + variable + " bet" + "ween \'" + value + "\' and \'" + value2 + "\')")
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
			list = precioPromProdDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<PrecioPromProdDTO> getDataProductosByPrecioPromProdId(Long productoId2) throws Exception {
		try {
			List<PrecioPromProd> precioPromProd = precioPromProdDAO
					.findByCriteria("producto.productoId= " + productoId2);

			List<PrecioPromProdDTO> PrecioPromProdDTO = new ArrayList<PrecioPromProdDTO>();

			for (PrecioPromProd precioPromProdTmp : precioPromProd) {
				PrecioPromProdDTO PrecioPromProdDTO2 = new PrecioPromProdDTO();

				PrecioPromProdDTO2.setPrecioProdId((precioPromProdTmp.getPrecioProdId()));
				PrecioPromProdDTO2.setAlmacenId(precioPromProdTmp.getAlmacenId());
				PrecioPromProdDTO2.setUnidadMedida(precioPromProdTmp.getUnidadMedida());
				PrecioPromProdDTO2.setCompania(precioPromProdTmp.getCompania());
				PrecioPromProdDTO2.setFechaCreacion(precioPromProdTmp.getFechaCreacion());
				PrecioPromProdDTO2.setFechaModificacion(precioPromProdTmp.getFechaModificacion());
				PrecioPromProdDTO2.setFechaInicial(precioPromProdTmp.getFechaInicial());
				PrecioPromProdDTO2.setFechaFinal(precioPromProdTmp.getFechaFinal());
				PrecioPromProdDTO2.setValorUnitario(precioPromProdTmp.getValorUnitario());
				PrecioPromProdDTO2.setOrigenDatos(precioPromProdTmp.getOrigenDatos());

				if (precioPromProdTmp.getPrecioProdId() != null) {
					PrecioPromProdDTO2.setProducto(precioPromProdTmp.getProducto());
				} else {
					PrecioPromProdDTO2.setProducto(null);
				}

				if (precioPromProdTmp.getProducto() != null) {
					PrecioPromProdDTO2.setCodProducto(precioPromProdTmp.getProducto().getCodigo());
				} else {
					PrecioPromProdDTO2.setCodProducto(null);
				}

				if (precioPromProdTmp.getUbicacionesAlmacen() != null) {
					PrecioPromProdDTO2.setUbicacionesAlmacen(precioPromProdTmp.getUbicacionesAlmacen());
				} else {
					PrecioPromProdDTO2.setUbicacionesAlmacen(null);
				}

				if (precioPromProdTmp.getUbicacionesAlmacen() != null) {
					PrecioPromProdDTO2.setNomUbicacionesAlmacen(precioPromProdTmp.getUbicacionesAlmacen().getNombre());
				} else {
					PrecioPromProdDTO2.setNomUbicacionesAlmacen(null);
				}

				if (precioPromProdTmp.getProducto() != null) {
					PrecioPromProdDTO2.setNomProducto(precioPromProdTmp.getProducto().getNombre());
				} else {
					PrecioPromProdDTO2.setNomProducto(null);
				}
				
				if (precioPromProdTmp.getAlmacenId() != null) {
					PrecioPromProdDTO2.setCodAlmacen(precioPromProdTmp.getAlmacenId().getCodigo());
				} else {
					PrecioPromProdDTO2.setCodAlmacen(null);
				}

				if (precioPromProdTmp.getUnidadMedida() != null) {
					PrecioPromProdDTO2.setNombreUnidadMedida(precioPromProdTmp.getUnidadMedida().getCodigo());
				} else {
					PrecioPromProdDTO2.setNombreUnidadMedida(null);
				}

				PrecioPromProdDTO2.setCantidadCompra(precioPromProdTmp.getCantidadCompra());
				PrecioPromProdDTO2.setFechaVencimiento(precioPromProdTmp.getFechaVencimiento());
				PrecioPromProdDTO2.setRegistroIca(precioPromProdTmp.getRegistroIca());
				PrecioPromProdDTO2.setLoteCompraProducto(precioPromProdTmp.getLoteCompraProducto());
				
				PrecioPromProdDTO2.setEtapaId((precioPromProdTmp.getEtapaId() != null) ?
						precioPromProdTmp.getEtapaId() : null);
				PrecioPromProdDTO2.setVariedId((precioPromProdTmp.getVariedId() != null) ?
						precioPromProdTmp.getVariedId() : null);

				if (precioPromProdTmp.getPersEmpr() != null) {
					PrecioPromProdDTO2.setPersEmprId_PersEmpr(precioPromProdTmp.getPersEmpr());
				} else {
					PrecioPromProdDTO2.setPersEmprId_PersEmpr(null);
				}

				if (precioPromProdTmp.getPersEmpr() != null) {
					PrecioPromProdDTO2.setCodPersEmpr(precioPromProdTmp.getPersEmpr().getCodigo());
				} else {
					PrecioPromProdDTO2.setCodPersEmpr(null);
				}
				
				if (precioPromProdTmp.getNivel2Id() != null) {
					PrecioPromProdDTO2.setNivel2Id_Nivel2(precioPromProdTmp.getNivel2Id());
				} else {
					PrecioPromProdDTO2.setNivel2Id_Nivel2(null);
				}
				
				if (precioPromProdTmp.getNivel2Id() != null) {
					PrecioPromProdDTO2.setCodNivel2(precioPromProdTmp.getNivel2Id().getCodigo());
				} else {
					PrecioPromProdDTO2.setCodNivel2(null);
				}
				
				if (precioPromProdTmp.getNivel4Id() != null) {
					PrecioPromProdDTO2.setNivel4Id_Nivel4(precioPromProdTmp.getNivel4Id());
				} else {
					PrecioPromProdDTO2.setNivel4Id_Nivel4(null);
				}
				
				if (precioPromProdTmp.getNivel4Id() != null) {
					PrecioPromProdDTO2.setCodNivel4(precioPromProdTmp.getNivel4Id().getCodigo());
				} else {
					PrecioPromProdDTO2.setCodNivel4(null);
				}
				PrecioPromProdDTO2.setInfoAdicional(
						(precioPromProdTmp.getInfoAdicional() != null) ? precioPromProdTmp.getInfoAdicional() : null);
				PrecioPromProdDTO2.setInfoAdicional2(
						(precioPromProdTmp.getInfoAdicional2() != null) ? precioPromProdTmp.getInfoAdicional2() : null);

				if (precioPromProdTmp.getHorometro_abastecimiento() != null) {
					PrecioPromProdDTO2.setHorometro_abastecimiento(precioPromProdTmp.getHorometro_abastecimiento());
				} else {
					PrecioPromProdDTO2.setHorometro_abastecimiento(null);
				}
				PrecioPromProdDTO2.setIndicador_vuelta_medidor(
						(precioPromProdTmp.getIndicador_vuelta_medidor() != null) ? precioPromProdTmp.getIndicador_vuelta_medidor() : null);
				
				if (precioPromProdTmp.getImplementoId() != null) {
					PrecioPromProdDTO2.setImplementoId(precioPromProdTmp.getImplementoId().getEquipoId());
				
					PrecioPromProdDTO2.setCodImplemento(precioPromProdTmp.getImplementoId().getCodigo() +"-"+precioPromProdTmp.getImplementoId().getNombre());
				} else {
					PrecioPromProdDTO2.setCodImplemento(null);
					PrecioPromProdDTO2.setImplementoId(null);
				}
				if (precioPromProdTmp.getCentCostId() != null) {
					CentCost centCost = logicCentCost.getCentCost(precioPromProdTmp.getCentCostId());
					PrecioPromProdDTO2.setCentCostId(precioPromProdTmp.getCentCostId());
					PrecioPromProdDTO2.setNombreCentCost(centCost.getNombre());
				} else {
					PrecioPromProdDTO2.setCentCostId(null);
					PrecioPromProdDTO2.setNombreCentCost(null);	
				}
				
				if (precioPromProdTmp.getReferenciaFacCompra() != null) {
					PrecioPromProdDTO2.setReferenciaFacCompra(precioPromProdTmp.getReferenciaFacCompra());
				} else {
					PrecioPromProdDTO2.setReferenciaFacCompra(null);
					}
				if (precioPromProdTmp.getDescuentoProducto() != null) {
					PrecioPromProdDTO2.setDescuentoProducto(precioPromProdTmp.getDescuentoProducto());
				} else {
					PrecioPromProdDTO2.setDescuentoProducto(null);
					}
				PrecioPromProdDTO.add(PrecioPromProdDTO2);
			}

			return PrecioPromProdDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	

	@Override
	@Transactional(readOnly = true)
	public List<PrecioPromProdDTO> getDataProductosByInventarios(Long datOtrosMovInventarioId) throws Exception {
		try {
			List<PrecioPromProd> precioPromProd = precioPromProdDAO
					.findByCriteria("datOtrosMovInventarioId.datOtrosMovInventarioId= " + datOtrosMovInventarioId);

			List<PrecioPromProdDTO> PrecioPromProdDTO = new ArrayList<PrecioPromProdDTO>();

			for (PrecioPromProd precioPromProdTmp : precioPromProd) {
				PrecioPromProdDTO PrecioPromProdDTO2 = new PrecioPromProdDTO();

				PrecioPromProdDTO2.setPrecioProdId((precioPromProdTmp.getPrecioProdId()));
				
				PrecioPromProdDTO2.setUnidadMedida(precioPromProdTmp.getUnidadMedida());
				PrecioPromProdDTO2.setCompania(precioPromProdTmp.getCompania());
				PrecioPromProdDTO2.setFechaCreacion(precioPromProdTmp.getFechaCreacion());
				PrecioPromProdDTO2.setFechaModificacion(precioPromProdTmp.getFechaModificacion());
				PrecioPromProdDTO2.setFechaInicial(precioPromProdTmp.getFechaInicial());
				PrecioPromProdDTO2.setFechaFinal(precioPromProdTmp.getFechaFinal());
				PrecioPromProdDTO2.setValorUnitario(precioPromProdTmp.getValorUnitario());
				PrecioPromProdDTO2.setOrigenDatos(precioPromProdTmp.getOrigenDatos());

				if (precioPromProdTmp.getProducto() != null) {
					PrecioPromProdDTO2.setCodProducto(precioPromProdTmp.getProducto().getCodigo());
				} else {
					PrecioPromProdDTO2.setCodProducto(null);
				}


				if (precioPromProdTmp.getProducto() != null) {
					PrecioPromProdDTO2.setNomProducto(precioPromProdTmp.getProducto().getNombre());
				} else {
					PrecioPromProdDTO2.setNomProducto(null);
				}

				if (precioPromProdTmp.getProducto() != null) {
					PrecioPromProdDTO2.setProducto(precioPromProdTmp.getProducto());
				} else {
					PrecioPromProdDTO2.setProducto(null);
				}

				if (precioPromProdTmp.getAlmacenId() != null) {
					PrecioPromProdDTO2.setAlmacenId(precioPromProdTmp.getAlmacenId());
				} else {
					PrecioPromProdDTO2.setAlmacenId(null);
				}

				if (precioPromProdTmp.getUbicacionesAlmacen() != null) {
					PrecioPromProdDTO2.setUbicacionesAlmacen(precioPromProdTmp.getUbicacionesAlmacen());
				} else {
					PrecioPromProdDTO2.setUbicacionesAlmacen(null);
				}

				if (precioPromProdTmp.getUbicacionesAlmacen() != null) {
					PrecioPromProdDTO2.setNomUbicacionesAlmacen(precioPromProdTmp.getUbicacionesAlmacen().getNombre());
				} else {
					PrecioPromProdDTO2.setNomUbicacionesAlmacen(null);
				}
				
				if (precioPromProdTmp.getAlmacenId() != null) {
					PrecioPromProdDTO2.setCodAlmacen(precioPromProdTmp.getAlmacenId().getCodigo());
				} else {
					PrecioPromProdDTO2.setCodAlmacen(null);
				}

				if (precioPromProdTmp.getUnidadMedida() != null) {
					PrecioPromProdDTO2.setUnidadMedida(precioPromProdTmp.getUnidadMedida());
				} else {
					PrecioPromProdDTO2.setUnidadMedida(null);
				}
				
				if (precioPromProdTmp.getUnidadMedida() != null) {
					PrecioPromProdDTO2.setNombreUnidadMedida(precioPromProdTmp.getUnidadMedida().getCodigo());
				} else {
					PrecioPromProdDTO2.setNombreUnidadMedida(null);
				}

				PrecioPromProdDTO2.setCantidadCompra(precioPromProdTmp.getCantidadCompra());
				PrecioPromProdDTO2.setFechaVencimiento(precioPromProdTmp.getFechaVencimiento());
				PrecioPromProdDTO2.setRegistroIca(precioPromProdTmp.getRegistroIca());
				PrecioPromProdDTO2.setLoteCompraProducto(precioPromProdTmp.getLoteCompraProducto());

				PrecioPromProdDTO2.setPorcIva(precioPromProdTmp.getPorcIva());
				PrecioPromProdDTO2.setValorIva(precioPromProdTmp.getValorIva());
				PrecioPromProdDTO2.setCostoTotal(precioPromProdTmp.getCostoTotal());
				PrecioPromProdDTO2.setNumFacturaCompra(precioPromProdTmp.getNumFacturaCompra());
				PrecioPromProdDTO2.setTipoMovimiento(precioPromProdTmp.getTipoMovimiento());
				
				PrecioPromProdDTO2.setEtapaId((precioPromProdTmp.getEtapaId() != null) ?
						precioPromProdTmp.getEtapaId() : null);
				PrecioPromProdDTO2.setVariedId((precioPromProdTmp.getVariedId() != null) ?
						precioPromProdTmp.getVariedId() : null);
				
				
				if (precioPromProdTmp.getPersEmpr() != null) {
					PrecioPromProdDTO2.setPersEmprId_PersEmpr(precioPromProdTmp.getPersEmpr());
				} else {
					PrecioPromProdDTO2.setPersEmprId_PersEmpr(null);
				}

				if (precioPromProdTmp.getPersEmpr() != null) {
					PrecioPromProdDTO2.setCodPersEmpr(precioPromProdTmp.getPersEmpr().getCodigo());
				} else {
					PrecioPromProdDTO2.setCodPersEmpr(null);
				}

				
				if (precioPromProdTmp.getConceptoKardexId() != null) {
					PrecioPromProdDTO2.setConceptoKardexId(precioPromProdTmp.getConceptoKardexId());
				} else {
					PrecioPromProdDTO2.setConceptoKardexId(null);
				}

				if (precioPromProdTmp.getConceptoKardexId() != null) {
					PrecioPromProdDTO2.setCodConceptoKardex(precioPromProdTmp.getConceptoKardexId().getCodigo());
				} else {
					PrecioPromProdDTO2.setCodConceptoKardex(null);
				}

				if (precioPromProdTmp.getEquipoId() != null) {
					PrecioPromProdDTO2.setEquipoId(precioPromProdTmp.getEquipoId());
				} else {
					PrecioPromProdDTO2.setEquipoId(null);
				}

				if (precioPromProdTmp.getEquipoId() != null) {
					PrecioPromProdDTO2.setCodEquipo(precioPromProdTmp.getEquipoId().getCodigo());
				} else {
					PrecioPromProdDTO2.setCodEquipo(null);
				}
				
				if (precioPromProdTmp.getTrabajador() != null) {
					PrecioPromProdDTO2.setTrabajador(precioPromProdTmp.getTrabajador());
				} else {
					PrecioPromProdDTO2.setTrabajador(null);
				}

				if (precioPromProdTmp.getTrabajador() != null) {
					PrecioPromProdDTO2.setCodTrabajador(precioPromProdTmp.getTrabajador().getCodigo());
				} else {
					PrecioPromProdDTO2.setCodTrabajador(null);
				}
								
				if (precioPromProdTmp.getNivel2Id() != null) {
					PrecioPromProdDTO2.setNivel2Id_Nivel2(precioPromProdTmp.getNivel2Id());
				} else {
					PrecioPromProdDTO2.setNivel2Id_Nivel2(null);
				}
				
				if (precioPromProdTmp.getNivel2Id() != null) {
					PrecioPromProdDTO2.setCodNivel2(precioPromProdTmp.getNivel2Id().getCodigo());
				} else {
					PrecioPromProdDTO2.setCodNivel2(null);
				}
				
				if (precioPromProdTmp.getNivel4Id() != null) {
					PrecioPromProdDTO2.setNivel4Id_Nivel4(precioPromProdTmp.getNivel4Id());
				} else {
					PrecioPromProdDTO2.setNivel4Id_Nivel4(null);
				}
				
				if (precioPromProdTmp.getNivel4Id() != null) {
					PrecioPromProdDTO2.setCodNivel4(precioPromProdTmp.getNivel4Id().getCodigo());
				} else {
					PrecioPromProdDTO2.setCodNivel4(null);
				}
				PrecioPromProdDTO2.setInfoAdicional(
						(precioPromProdTmp.getInfoAdicional() != null) ? precioPromProdTmp.getInfoAdicional() : null);
				PrecioPromProdDTO2.setInfoAdicional2(
						(precioPromProdTmp.getInfoAdicional2() != null) ? precioPromProdTmp.getInfoAdicional2() : null);
				if (precioPromProdTmp.getHorometro_abastecimiento() != null) {
					PrecioPromProdDTO2.setHorometro_abastecimiento(precioPromProdTmp.getHorometro_abastecimiento());
				} else {
					PrecioPromProdDTO2.setHorometro_abastecimiento(null);
				}
				PrecioPromProdDTO2.setIndicador_vuelta_medidor(
						(precioPromProdTmp.getIndicador_vuelta_medidor() != null) ? precioPromProdTmp.getIndicador_vuelta_medidor() : null);
				
				if (precioPromProdTmp.getImplementoId() != null) {
					PrecioPromProdDTO2.setImplementoId(precioPromProdTmp.getImplementoId().getEquipoId());
					PrecioPromProdDTO2.setCodImplemento(precioPromProdTmp.getImplementoId().getCodigo() +"-"+precioPromProdTmp.getImplementoId().getNombre());
				} else {
					PrecioPromProdDTO2.setCodImplemento(null);
					PrecioPromProdDTO2.setImplementoId(null);
				}
				if (precioPromProdTmp.getCentCostId() != null) {
					CentCost centCost = logicCentCost.getCentCost(precioPromProdTmp.getCentCostId());
					PrecioPromProdDTO2.setCentCostId(precioPromProdTmp.getCentCostId());
					PrecioPromProdDTO2.setNombreCentCost(centCost.getNombre());
				} else {
					PrecioPromProdDTO2.setCentCostId(null);
					PrecioPromProdDTO2.setNombreCentCost(null);	
				}
				if (precioPromProdTmp.getReferenciaFacCompra() != null) {
					PrecioPromProdDTO2.setReferenciaFacCompra(precioPromProdTmp.getReferenciaFacCompra());
				} else {
					PrecioPromProdDTO2.setReferenciaFacCompra(null);
					}
				if (precioPromProdTmp.getDescuentoProducto() != null) {
					PrecioPromProdDTO2.setDescuentoProducto(precioPromProdTmp.getDescuentoProducto());
				} else {
					PrecioPromProdDTO2.setDescuentoProducto(null);
					}
				PrecioPromProdDTO.add(PrecioPromProdDTO2);
			}

			return PrecioPromProdDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	

	@Override
	@Transactional(readOnly = true)
	public List<PrecioPromProdDTO> getDataProductosByCompras(Long datCompraProductosId) throws Exception {
		try {
			List<PrecioPromProd> precioPromProd = precioPromProdDAO
					.findByCriteria("datCompraProductosId.datCompraProductosId= " + datCompraProductosId);

			List<PrecioPromProdDTO> PrecioPromProdDTO = new ArrayList<PrecioPromProdDTO>();

			for (PrecioPromProd precioPromProdTmp : precioPromProd) {
				PrecioPromProdDTO PrecioPromProdDTO2 = new PrecioPromProdDTO();

				PrecioPromProdDTO2.setPrecioProdId((precioPromProdTmp.getPrecioProdId()));
				
				PrecioPromProdDTO2.setUnidadMedida(precioPromProdTmp.getUnidadMedida());
				PrecioPromProdDTO2.setCompania(precioPromProdTmp.getCompania());
				PrecioPromProdDTO2.setFechaCreacion(precioPromProdTmp.getFechaCreacion());
				PrecioPromProdDTO2.setFechaModificacion(precioPromProdTmp.getFechaModificacion());
				PrecioPromProdDTO2.setFechaInicial(precioPromProdTmp.getFechaInicial());
				PrecioPromProdDTO2.setFechaFinal(precioPromProdTmp.getFechaFinal());
				PrecioPromProdDTO2.setValorUnitario(precioPromProdTmp.getValorUnitario());
				PrecioPromProdDTO2.setOrigenDatos(precioPromProdTmp.getOrigenDatos());

				if (precioPromProdTmp.getProducto() != null) {
					PrecioPromProdDTO2.setProducto(precioPromProdTmp.getProducto());
				} else {
					PrecioPromProdDTO2.setProducto(null);
				}

				if (precioPromProdTmp.getProducto() != null) {
					PrecioPromProdDTO2.setCodProducto(precioPromProdTmp.getProducto().getCodigo());
				} else {
					PrecioPromProdDTO2.setCodProducto(null);
				}


				if (precioPromProdTmp.getUbicacionesAlmacen() != null) {
					PrecioPromProdDTO2.setUbicacionesAlmacen(precioPromProdTmp.getUbicacionesAlmacen());
				} else {
					PrecioPromProdDTO2.setUbicacionesAlmacen(null);
				}

				if (precioPromProdTmp.getUbicacionesAlmacen() != null) {
					PrecioPromProdDTO2.setNomUbicacionesAlmacen(precioPromProdTmp.getUbicacionesAlmacen().getNombre());
				} else {
					PrecioPromProdDTO2.setNomUbicacionesAlmacen(null);
				}

				if (precioPromProdTmp.getProducto() != null) {
					PrecioPromProdDTO2.setNomProducto(precioPromProdTmp.getProducto().getNombre());
				} else {
					PrecioPromProdDTO2.setNomProducto(null);
				}
				
				if (precioPromProdTmp.getAlmacenId() != null) {
					PrecioPromProdDTO2.setAlmacenId(precioPromProdTmp.getAlmacenId());
				} else {
					PrecioPromProdDTO2.setAlmacenId(null);
				}

				
				if (precioPromProdTmp.getAlmacenId() != null) {
					PrecioPromProdDTO2.setCodAlmacen(precioPromProdTmp.getAlmacenId().getCodigo());
				} else {
					PrecioPromProdDTO2.setCodAlmacen(null);
				}

				if (precioPromProdTmp.getUnidadMedida() != null) {
					PrecioPromProdDTO2.setUnidadMedida(precioPromProdTmp.getUnidadMedida());
				} else {
					PrecioPromProdDTO2.setUnidadMedida(null);
				}
				
				if (precioPromProdTmp.getUnidadMedida() != null) {
					PrecioPromProdDTO2.setNombreUnidadMedida(precioPromProdTmp.getUnidadMedida().getCodigo());
				} else {
					PrecioPromProdDTO2.setNombreUnidadMedida(null);
				}

				PrecioPromProdDTO2.setCantidadCompra(precioPromProdTmp.getCantidadCompra());
				PrecioPromProdDTO2.setFechaVencimiento(precioPromProdTmp.getFechaVencimiento());
				PrecioPromProdDTO2.setRegistroIca(precioPromProdTmp.getRegistroIca());
				PrecioPromProdDTO2.setLoteCompraProducto(precioPromProdTmp.getLoteCompraProducto());

				PrecioPromProdDTO2.setPorcIva(precioPromProdTmp.getPorcIva());
				PrecioPromProdDTO2.setValorIva(precioPromProdTmp.getValorIva());
				PrecioPromProdDTO2.setCostoTotal(precioPromProdTmp.getCostoTotal());
				PrecioPromProdDTO2.setNumFacturaCompra(precioPromProdTmp.getNumFacturaCompra());
				PrecioPromProdDTO2.setTipoMovimiento(precioPromProdTmp.getTipoMovimiento());
				
				PrecioPromProdDTO2.setEtapaId((precioPromProdTmp.getEtapaId() != null) ?
						precioPromProdTmp.getEtapaId() : null);
				PrecioPromProdDTO2.setVariedId((precioPromProdTmp.getVariedId() != null) ?
						precioPromProdTmp.getVariedId() : null);
				
				
				if (precioPromProdTmp.getPersEmpr() != null) {
					PrecioPromProdDTO2.setPersEmprId_PersEmpr(precioPromProdTmp.getPersEmpr());
				} else {
					PrecioPromProdDTO2.setPersEmprId_PersEmpr(null);
				}

				if (precioPromProdTmp.getPersEmpr() != null) {
					PrecioPromProdDTO2.setCodPersEmpr(precioPromProdTmp.getPersEmpr().getCodigo());
				} else {
					PrecioPromProdDTO2.setCodPersEmpr(null);
				}

				
				if (precioPromProdTmp.getConceptoKardexId() != null) {
					PrecioPromProdDTO2.setConceptoKardexId(precioPromProdTmp.getConceptoKardexId());
				} else {
					PrecioPromProdDTO2.setConceptoKardexId(null);
				}

				if (precioPromProdTmp.getConceptoKardexId() != null) {
					PrecioPromProdDTO2.setCodConceptoKardex(precioPromProdTmp.getConceptoKardexId().getCodigo());
				} else {
					PrecioPromProdDTO2.setCodConceptoKardex(null);
				}

				if (precioPromProdTmp.getEquipoId() != null) {
					PrecioPromProdDTO2.setEquipoId(precioPromProdTmp.getEquipoId());
				} else {
					PrecioPromProdDTO2.setEquipoId(null);
				}

				if (precioPromProdTmp.getEquipoId() != null) {
					PrecioPromProdDTO2.setCodEquipo(precioPromProdTmp.getEquipoId().getCodigo());
				} else {
					PrecioPromProdDTO2.setCodEquipo(null);
				}
				
				if (precioPromProdTmp.getTrabajador() != null) {
					PrecioPromProdDTO2.setTrabajador(precioPromProdTmp.getTrabajador());
				} else {
					PrecioPromProdDTO2.setTrabajador(null);
				}

				if (precioPromProdTmp.getTrabajador() != null) {
					PrecioPromProdDTO2.setCodTrabajador(precioPromProdTmp.getTrabajador().getCodigo());
				} else {
					PrecioPromProdDTO2.setCodTrabajador(null);
				}
								
				if (precioPromProdTmp.getConceptoGastoId() != null) {
					PrecioPromProdDTO2.setConceptoGastoId(precioPromProdTmp.getConceptoGastoId());
				} else {
					PrecioPromProdDTO2.setConceptoGastoId(null);
				}
					
				if (precioPromProdTmp.getDiferido() != null) {
					PrecioPromProdDTO2.setDiferido(precioPromProdTmp.getDiferido());
				} else {
					PrecioPromProdDTO2.setDiferido(null);
				}
					
				PrecioPromProdDTO2.setInfoAdicional(
						(precioPromProdTmp.getInfoAdicional() != null) ? precioPromProdTmp.getInfoAdicional() : null);
				PrecioPromProdDTO2.setInfoAdicional2(
						(precioPromProdTmp.getInfoAdicional2() != null) ? precioPromProdTmp.getInfoAdicional2() : null);
				
				if (precioPromProdTmp.getHorometro_abastecimiento() != null) {
					PrecioPromProdDTO2.setHorometro_abastecimiento(precioPromProdTmp.getHorometro_abastecimiento());
				} else {
					PrecioPromProdDTO2.setHorometro_abastecimiento(null);
				}
				
				PrecioPromProdDTO2.setIndicador_vuelta_medidor(
						(precioPromProdTmp.getIndicador_vuelta_medidor() != null) ? precioPromProdTmp.getIndicador_vuelta_medidor() : null);
				
				if (precioPromProdTmp.getImplementoId() != null) {
					PrecioPromProdDTO2.setImplementoId(precioPromProdTmp.getImplementoId().getEquipoId());
					PrecioPromProdDTO2.setCodImplemento(precioPromProdTmp.getImplementoId().getCodigo() +"-"+precioPromProdTmp.getImplementoId().getNombre());
				} else {
					PrecioPromProdDTO2.setCodImplemento(null);
					PrecioPromProdDTO2.setImplementoId(null);
				}
				if (precioPromProdTmp.getCentCostId() != null) {
					CentCost centCost = logicCentCost.getCentCost(precioPromProdTmp.getCentCostId());
					PrecioPromProdDTO2.setCentCostId(precioPromProdTmp.getCentCostId());
					PrecioPromProdDTO2.setNombreCentCost(centCost.getNombre());
				} else {
					PrecioPromProdDTO2.setCentCostId(null);
					PrecioPromProdDTO2.setNombreCentCost(null);	
				}
				if (precioPromProdTmp.getReferenciaFacCompra() != null) {
					PrecioPromProdDTO2.setReferenciaFacCompra(precioPromProdTmp.getReferenciaFacCompra());
				} else {
					PrecioPromProdDTO2.setReferenciaFacCompra(null);
					}
				if (precioPromProdTmp.getDescuentoProducto() != null) {
					PrecioPromProdDTO2.setDescuentoProducto(precioPromProdTmp.getDescuentoProducto());
				} else {
					PrecioPromProdDTO2.setDescuentoProducto(null);
					}
				PrecioPromProdDTO.add(PrecioPromProdDTO2);
			}

			return PrecioPromProdDTO;
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public List<PrecioPromProdDTO> getDataProductosByServRealizados(Long datServRealizadosEquipoId) throws Exception {
		try {
			List<PrecioPromProd> precioPromProd = precioPromProdDAO
					.findByCriteria("datServRealizadosEquipoId.datServRealizadosEquipoId= " + datServRealizadosEquipoId);

			List<PrecioPromProdDTO> PrecioPromProdDTO = new ArrayList<PrecioPromProdDTO>();

			for (PrecioPromProd precioPromProdTmp : precioPromProd) {
				PrecioPromProdDTO PrecioPromProdDTO2 = new PrecioPromProdDTO();

				PrecioPromProdDTO2.setPrecioProdId((precioPromProdTmp.getPrecioProdId()));
				
				PrecioPromProdDTO2.setUnidadMedida(precioPromProdTmp.getUnidadMedida());
				PrecioPromProdDTO2.setCompania(precioPromProdTmp.getCompania());
				PrecioPromProdDTO2.setFechaCreacion(precioPromProdTmp.getFechaCreacion());
				PrecioPromProdDTO2.setFechaModificacion(precioPromProdTmp.getFechaModificacion());
				PrecioPromProdDTO2.setFechaInicial(precioPromProdTmp.getFechaInicial());
				PrecioPromProdDTO2.setFechaFinal(precioPromProdTmp.getFechaFinal());
				PrecioPromProdDTO2.setValorUnitario(precioPromProdTmp.getValorUnitario());
				PrecioPromProdDTO2.setOrigenDatos(precioPromProdTmp.getOrigenDatos());

				if (precioPromProdTmp.getProducto() != null) {
					PrecioPromProdDTO2.setProducto(precioPromProdTmp.getProducto());
				} else {
					PrecioPromProdDTO2.setProducto(null);
				}

				if (precioPromProdTmp.getProducto() != null) {
					PrecioPromProdDTO2.setCodProducto(precioPromProdTmp.getProducto().getCodigo());
				} else {
					PrecioPromProdDTO2.setCodProducto(null);
				}
				
				if (precioPromProdTmp.getUbicacionesAlmacen() != null) {
					PrecioPromProdDTO2.setUbicacionesAlmacen(precioPromProdTmp.getUbicacionesAlmacen());
				} else {
					PrecioPromProdDTO2.setUbicacionesAlmacen(null);
				}
				

				if (precioPromProdTmp.getUbicacionesAlmacen() != null) {
					PrecioPromProdDTO2.setUbicacionId(precioPromProdTmp.getUbicacionesAlmacen().getUbicacionesAlmacenId());
				} else {
					PrecioPromProdDTO2.setUbicacionId(null);
				}

				if (precioPromProdTmp.getUbicacionesAlmacen() != null) {
					PrecioPromProdDTO2.setNomUbicacionesAlmacen(precioPromProdTmp.getUbicacionesAlmacen().getNombre());
				} else {
					PrecioPromProdDTO2.setNomUbicacionesAlmacen(null);
				}

				if (precioPromProdTmp.getProducto() != null) {
					PrecioPromProdDTO2.setNomProducto(precioPromProdTmp.getProducto().getNombre());
				} else {
					PrecioPromProdDTO2.setNomProducto(null);
				}
				
				if (precioPromProdTmp.getAlmacenId() != null) {
					PrecioPromProdDTO2.setAlmacenId(precioPromProdTmp.getAlmacenId());
				} else {
					PrecioPromProdDTO2.setAlmacenId(null);
				}

				
				if (precioPromProdTmp.getAlmacenId() != null) {
					PrecioPromProdDTO2.setCodAlmacen(precioPromProdTmp.getAlmacenId().getCodigo());
				} else {
					PrecioPromProdDTO2.setCodAlmacen(null);
				}

				if (precioPromProdTmp.getUnidadMedida() != null) {
					PrecioPromProdDTO2.setUnidadMedida(precioPromProdTmp.getUnidadMedida());
				} else {
					PrecioPromProdDTO2.setUnidadMedida(null);
				}
				
				if (precioPromProdTmp.getUnidadMedida() != null) {
					PrecioPromProdDTO2.setNombreUnidadMedida(precioPromProdTmp.getUnidadMedida().getCodigo());
				} else {
					PrecioPromProdDTO2.setNombreUnidadMedida(null);
				}

				PrecioPromProdDTO2.setCantidadCompra(precioPromProdTmp.getCantidadCompra());
				PrecioPromProdDTO2.setFechaVencimiento(precioPromProdTmp.getFechaVencimiento());
				PrecioPromProdDTO2.setRegistroIca(precioPromProdTmp.getRegistroIca());
				PrecioPromProdDTO2.setLoteCompraProducto(precioPromProdTmp.getLoteCompraProducto());

				PrecioPromProdDTO2.setPorcIva(precioPromProdTmp.getPorcIva());
				PrecioPromProdDTO2.setValorIva(precioPromProdTmp.getValorIva());
				PrecioPromProdDTO2.setCostoTotal(precioPromProdTmp.getCostoTotal());
				PrecioPromProdDTO2.setNumFacturaCompra(precioPromProdTmp.getNumFacturaCompra());
				PrecioPromProdDTO2.setTipoMovimiento(precioPromProdTmp.getTipoMovimiento());
				
				PrecioPromProdDTO2.setEtapaId((precioPromProdTmp.getEtapaId() != null) ?
						precioPromProdTmp.getEtapaId() : null);
				PrecioPromProdDTO2.setVariedId((precioPromProdTmp.getVariedId() != null) ?
						precioPromProdTmp.getVariedId() : null);
				
				
				if (precioPromProdTmp.getPersEmpr() != null) {
					PrecioPromProdDTO2.setPersEmprId_PersEmpr(precioPromProdTmp.getPersEmpr());
				} else {
					PrecioPromProdDTO2.setPersEmprId_PersEmpr(null);
				}

				if (precioPromProdTmp.getPersEmpr() != null) {
					PrecioPromProdDTO2.setCodPersEmpr(precioPromProdTmp.getPersEmpr().getCodigo());
				} else {
					PrecioPromProdDTO2.setCodPersEmpr(null);
				}

				
				if (precioPromProdTmp.getConceptoKardexId() != null) {
					PrecioPromProdDTO2.setConceptoKardexId(precioPromProdTmp.getConceptoKardexId());
				} else {
					PrecioPromProdDTO2.setConceptoKardexId(null);
				}

				if (precioPromProdTmp.getConceptoKardexId() != null) {
					PrecioPromProdDTO2.setCodConceptoKardex(precioPromProdTmp.getConceptoKardexId().getCodigo());
				} else {
					PrecioPromProdDTO2.setCodConceptoKardex(null);
				}

				if (precioPromProdTmp.getEquipoId() != null) {
					PrecioPromProdDTO2.setEquipoId(precioPromProdTmp.getEquipoId());
				} else {
					PrecioPromProdDTO2.setEquipoId(null);
				}

				if (precioPromProdTmp.getEquipoId() != null) {
					PrecioPromProdDTO2.setCodEquipo(precioPromProdTmp.getEquipoId().getCodigo());
				} else {
					PrecioPromProdDTO2.setCodEquipo(null);
				}
				
				if (precioPromProdTmp.getTrabajador() != null) {
					PrecioPromProdDTO2.setTrabajador(precioPromProdTmp.getTrabajador());
				} else {
					PrecioPromProdDTO2.setTrabajador(null);
				}

				if (precioPromProdTmp.getTrabajador() != null) {
					PrecioPromProdDTO2.setCodTrabajador(precioPromProdTmp.getTrabajador().getCodigo());
				} else {
					PrecioPromProdDTO2.setCodTrabajador(null);
				}
								
				if (precioPromProdTmp.getConceptoGastoId() != null) {
					PrecioPromProdDTO2.setConceptoGastoId(precioPromProdTmp.getConceptoGastoId());
				} else {
					PrecioPromProdDTO2.setConceptoGastoId(null);
				}
					
				if (precioPromProdTmp.getDiferido() != null) {
					PrecioPromProdDTO2.setDiferido(precioPromProdTmp.getDiferido());
				} else {
					PrecioPromProdDTO2.setDiferido(null);
				}
					
				
				
				if (precioPromProdTmp.getHorometro_abastecimiento() != null) {
					PrecioPromProdDTO2.setHorometro_abastecimiento(precioPromProdTmp.getHorometro_abastecimiento());
				} else {
					PrecioPromProdDTO2.setHorometro_abastecimiento(null);
				}
					
				if (precioPromProdTmp.getOperario_equipo_id() != null) {
					PrecioPromProdDTO2.setOperario_equipo_id(precioPromProdTmp.getOperario_equipo_id());
				} else {
					PrecioPromProdDTO2.setOperario_equipo_id(null);
				}

				if (precioPromProdTmp.getOperario_equipo_id() != null) {
					PrecioPromProdDTO2.setNomOperarioEquipo(precioPromProdTmp.getOperario_equipo_id().getNombre());
				} else {
					PrecioPromProdDTO2.setNomOperarioEquipo(null);
				}
				
				
				if (precioPromProdTmp.getDatServRealizadosEquipoId() != null) {
					PrecioPromProdDTO2.setDatServRealizadosEquipoId(precioPromProdTmp.getDatServRealizadosEquipoId());
				} else {
					PrecioPromProdDTO2.setDatServRealizadosEquipoId(null);
				}
				
				PrecioPromProdDTO2.setInfoAdicional(
						(precioPromProdTmp.getInfoAdicional() != null) ? precioPromProdTmp.getInfoAdicional() : null);
				PrecioPromProdDTO2.setInfoAdicional2(
						(precioPromProdTmp.getInfoAdicional2() != null) ? precioPromProdTmp.getInfoAdicional2() : null);
				
				PrecioPromProdDTO2.setIndicador_vuelta_medidor(
						(precioPromProdTmp.getIndicador_vuelta_medidor() != null) ? precioPromProdTmp.getIndicador_vuelta_medidor() : null);
				
				PrecioPromProdDTO2.setInfoAdicional2(
						(precioPromProdTmp.getInfoAdicional2() != null) ? precioPromProdTmp.getInfoAdicional2() : null);
				
				PrecioPromProdDTO2.setInfoAdicional2(
						(precioPromProdTmp.getInfoAdicional2() != null) ? precioPromProdTmp.getInfoAdicional2() : null);
				
				
				if (precioPromProdTmp.getImplementoId() != null) {
					PrecioPromProdDTO2.setImplementoId(precioPromProdTmp.getImplementoId().getEquipoId());
					PrecioPromProdDTO2.setCodImplemento(precioPromProdTmp.getImplementoId().getCodigo() +"-"+precioPromProdTmp.getImplementoId().getNombre());
				} else {
					PrecioPromProdDTO2.setCodImplemento(null);
					PrecioPromProdDTO2.setImplementoId(null);
				}
				if (precioPromProdTmp.getDatMantenimientoEquipoId() != null) {
					PrecioPromProdDTO2.setDatMantenimientoEquipoId(precioPromProdTmp.getDatMantenimientoEquipoId());
				} else {
					PrecioPromProdDTO2.setDatMantenimientoEquipoId(null);
					}
				
				if (precioPromProdTmp.getCentCostId() != null) {
					CentCost centCost = logicCentCost.getCentCost(precioPromProdTmp.getCentCostId());
					PrecioPromProdDTO2.setCentCostId(precioPromProdTmp.getCentCostId());
					PrecioPromProdDTO2.setNombreCentCost(centCost.getNombre());
				} else {
					PrecioPromProdDTO2.setCentCostId(null);
					PrecioPromProdDTO2.setNombreCentCost(null);	
				}
				
				if (precioPromProdTmp.getReferenciaFacCompra() != null) {
					PrecioPromProdDTO2.setReferenciaFacCompra(precioPromProdTmp.getReferenciaFacCompra());
				} else {
					PrecioPromProdDTO2.setReferenciaFacCompra(null);
					}
				
				if (precioPromProdTmp.getDescuentoProducto() != null) {
					PrecioPromProdDTO2.setDescuentoProducto(precioPromProdTmp.getDescuentoProducto());
				} else {
					PrecioPromProdDTO2.setDescuentoProducto(null);
					}
				PrecioPromProdDTO.add(PrecioPromProdDTO2);
			}

			return PrecioPromProdDTO;
		} catch (Exception e) {
			throw e;
		}
	}

}
