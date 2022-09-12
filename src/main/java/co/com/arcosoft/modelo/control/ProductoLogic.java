package co.com.arcosoft.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.arcosoft.dataaccess.dao.IDatAplicProdDetDAO;
import co.com.arcosoft.dataaccess.dao.IDatHerramientaDAO;
import co.com.arcosoft.dataaccess.dao.IDatProductosRelacionadosDAO;
import co.com.arcosoft.dataaccess.dao.IDatRgtroInventDAO;
import co.com.arcosoft.dataaccess.dao.IDatTransProdDetDAO;
import co.com.arcosoft.dataaccess.dao.IEmpaqueProductoDAO;
import co.com.arcosoft.dataaccess.dao.IIngrActivProdDAO;
import co.com.arcosoft.dataaccess.dao.IMaduranteProductoDAO;
import co.com.arcosoft.dataaccess.dao.IPrecioPromProdDAO;
import co.com.arcosoft.dataaccess.dao.IProductoDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatAplicProdDet;
import co.com.arcosoft.modelo.DatHerramienta;
import co.com.arcosoft.modelo.DatProductosRelacionados;
import co.com.arcosoft.modelo.DatRgtroInvent;
import co.com.arcosoft.modelo.DatTransProdDet;
import co.com.arcosoft.modelo.EmpaqueProducto;
import co.com.arcosoft.modelo.IngrActivProd;
import co.com.arcosoft.modelo.MaduranteProducto;
import co.com.arcosoft.modelo.PrecioPromProd;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.dto.DatProductosRelacionadosDTO;
import co.com.arcosoft.modelo.dto.PrecioPromProdDTO;
import co.com.arcosoft.modelo.dto.ProductoDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("ProductoLogic")
public class ProductoLogic implements IProductoLogic {
	private static final Logger log = LoggerFactory.getLogger(ProductoLogic.class);

	/**
	 * DAO injected by Spring that manages Producto entities
	 *
	 */
	@Autowired
	private IProductoDAO productoDAO;

	/**
	 * DAO injected by Spring that manages DatAplicProdDet entities
	 *
	 */
	@Autowired
	private IDatAplicProdDetDAO datAplicProdDetDAO;

	/**
	 * DAO injected by Spring that manages DatHerramienta entities
	 *
	 */
	@Autowired
	private IDatHerramientaDAO datHerramientaDAO;

	/**
	 * DAO injected by Spring that manages DatRgtroInvent entities
	 *
	 */
	@Autowired
	private IDatRgtroInventDAO datRgtroInventDAO;

	/**
	 * DAO injected by Spring that manages DatTransProdDet entities
	 *
	 */
	@Autowired
	private IDatTransProdDetDAO datTransProdDetDAO;

	/**
	 * DAO injected by Spring that manages EmpaqueProducto entities
	 *
	 */
	@Autowired
	private IEmpaqueProductoDAO empaqueProductoDAO;

	/**
	 * DAO injected by Spring that manages IngrActivProd entities
	 *
	 */
	@Autowired
	private IIngrActivProdDAO ingrActivProdDAO;

	/**
	 * DAO injected by Spring that manages MaduranteProducto entities
	 *
	 */
	@Autowired
	private IMaduranteProductoDAO maduranteProductoDAO;

	/**
	 * DAO injected by Spring that manages PrecioPromProd entities
	 *
	 */
	@Autowired
	private IPrecioPromProdDAO precioPromProdDAO;

	@Autowired
	private IDatProductosRelacionadosDAO datProductosRelacionadosDAO;

	/**
	 * Logic injected by Spring that manages Almacen entities
	 *
	 */
	@Autowired
	IAlmacenLogic logicAlmacen1;

	/**
	 * Logic injected by Spring that manages CentCost entities
	 *
	 */
	@Autowired
	ICentCostLogic logicCentCost2;

	/**
	 * Logic injected by Spring that manages ClaseToxicologica entities
	 *
	 */
	@Autowired
	IClaseToxicologicaLogic logicClaseToxicologica3;

	/**
	 * Logic injected by Spring that manages ElementoCosto entities
	 *
	 */
	@Autowired
	IElementoCostoLogic logicElementoCosto4;

	/**
	 * Logic injected by Spring that manages TipoProducto entities
	 *
	 */
	@Autowired
	ITipoProductoLogic logicTipoProducto5;

	/**
	 * Logic injected by Spring that manages UdadMed entities
	 *
	 */
	@Autowired
	IUdadMedLogic logicUdadMed6;

	@Override
	@Transactional(readOnly = true)
	public List<Producto> getProducto() throws Exception {
		log.debug("finding all Producto instances");

		List<Producto> list = new ArrayList<Producto>();

		try {
			list = productoDAO.findAll();
		} catch (Exception e) {
			log.error("finding all Producto failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "Producto");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveProducto(Producto entity, List<PrecioPromProdDTO> dataDetPrecioProductos, List<DatProductosRelacionadosDTO> 
			dataProdRelacionado) throws Exception {
		log.debug("saving Producto instance");

		try {
			if (entity.getAlmacen() == null) {
				throw new ZMessManager().new ForeignException("almacen");
			}

			if (entity.getTipoProducto() == null) {
				throw new ZMessManager().new ForeignException("tipoProducto");
			}

			if (entity.getUdadMedByUdadMedProd() == null) {
				throw new ZMessManager().new ForeignException("udadMedByUdadMedProd");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getEsGranel() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEsGranel(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("esGranel");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getFlujoMovimiento() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getFlujoMovimiento(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("flujoMovimiento");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 300) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 300) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if (entity.getAlmacen().getAlmacenId() == null) {
				throw new ZMessManager().new EmptyFieldException("almacenId_Almacen");
			}

			if ((entity.getAlmacen().getAlmacenId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAlmacen().getAlmacenId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("almacenId_Almacen");
			}

			if ((entity.getCentCost() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCentCost(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("centCostId_CentCost");
			}

			if ((entity.getClaseToxicologica() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getClaseToxicologica(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("claseToxicId_ClaseToxicologica");
			}

			if ((entity.getElementoCosto() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getElementoCosto(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("elemCostoId_ElementoCosto");
			}

			if (entity.getTipoProducto().getTipoProdId() == null) {
				throw new ZMessManager().new EmptyFieldException("tipoProdId_TipoProducto");
			}

			if ((entity.getTipoProducto().getTipoProdId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getTipoProducto().getTipoProdId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoProdId_TipoProducto");
			}

			if (entity.getUdadMedByUdadMedProd().getUdadMedId() == null) {
				throw new ZMessManager().new EmptyFieldException("udadMedId_UdadMed");
			}

			if ((entity.getUdadMedByUdadMedProd().getUdadMedId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getUdadMedByUdadMedProd().getUdadMedId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("udadMedId_UdadMed");
			}

			if ((entity.getUdadMedByUdadMedCosecha() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUdadMedByUdadMedCosecha(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("udadMedId_UdadMed");
			}

			productoDAO.save(entity);

			if (dataDetPrecioProductos != null) {

				for (PrecioPromProdDTO valorDto : dataDetPrecioProductos) {

					if (valorDto.getPrecioProdId() == null) {

						PrecioPromProd valor = new PrecioPromProd();

						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaVencimiento(valorDto.getFechaVencimiento());
						valor.setCantidadCompra(valorDto.getCantidadCompra());
						valor.setUnidadMedida(valorDto.getUnidadMedida());
						valor.setLoteCompraProducto(valorDto.getLoteCompraProducto());
						valor.setRegistroIca(valorDto.getRegistroIca());
						valor.setAlmacenId(valorDto.getAlmacenId());
						valor.setValorUnitario(valorDto.getValorUnitario());
						valor.setCompania(valorDto.getCompania());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaModificacion(valorDto.getFechaModificacion());

						valor.setProducto(entity);

						precioPromProdDAO.save(valor);
					}
				}
			}

			if (dataProdRelacionado != null) {

				for (DatProductosRelacionadosDTO valorDto : dataProdRelacionado) {

					if (valorDto.getDatProductosAgregadosId() == null) {

						DatProductosRelacionados valor = new DatProductosRelacionados();

						valor.setProductoAsociadoId(valorDto.getProductoAsociadoId());
						valor.setUdadMed(logicUdadMed6.getUdadMed(valorDto.getUdadMedId_UdadMed()));
						valor.setPorcentaje(valorDto.getPorcentaje());
						valor.setDosis(valorDto.getDosis());
						valor.setCantidad(valorDto.getCantidad());
						
						valor.setProducto(entity);

						datProductosRelacionadosDAO.save(valor);
					}
				}
			}
			
			log.debug("save Producto successful");
		} catch (Exception e) {
			log.error("save Producto failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteProducto(Producto entity) throws Exception {
		log.debug("deleting Producto instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Producto");
		}

		if (entity.getProductoId() == null) {
			throw new ZMessManager().new EmptyFieldException("productoId");
		}

		List<DatAplicProdDet> datAplicProdDets = null;
		List<DatHerramienta> datHerramientas = null;
		List<DatRgtroInvent> datRgtroInvents = null;
		List<DatTransProdDet> datTransProdDets = null;
		List<EmpaqueProducto> empaqueProductos = null;
		List<IngrActivProd> ingrActivProds = null;
		List<MaduranteProducto> maduranteProductos = null;
		List<PrecioPromProd> precioPromProds = null;

		try {
			datAplicProdDets = datAplicProdDetDAO.findByProperty("producto.productoId", entity.getProductoId());

			if (Utilities.validationsList(datAplicProdDets) == true) {
				throw new ZMessManager().new DeletingException("datAplicProdDets");
			}

			datHerramientas = datHerramientaDAO.findByProperty("producto.productoId", entity.getProductoId());

			if (Utilities.validationsList(datHerramientas) == true) {
				throw new ZMessManager().new DeletingException("datHerramientas");
			}

			datRgtroInvents = datRgtroInventDAO.findByProperty("producto.productoId", entity.getProductoId());

			if (Utilities.validationsList(datRgtroInvents) == true) {
				throw new ZMessManager().new DeletingException("datRgtroInvents");
			}

			datTransProdDets = datTransProdDetDAO.findByProperty("producto.productoId", entity.getProductoId());

			if (Utilities.validationsList(datTransProdDets) == true) {
				throw new ZMessManager().new DeletingException("datTransProdDets");
			}

			empaqueProductos = empaqueProductoDAO.findByProperty("producto.productoId", entity.getProductoId());

			if (Utilities.validationsList(empaqueProductos) == true) {
				throw new ZMessManager().new DeletingException("empaqueProductos");
			}

			ingrActivProds = ingrActivProdDAO.findByProperty("producto.productoId", entity.getProductoId());

			if (Utilities.validationsList(ingrActivProds) == true) {
				throw new ZMessManager().new DeletingException("ingrActivProds");
			}

			maduranteProductos = maduranteProductoDAO.findByProperty("producto.productoId", entity.getProductoId());

			if (Utilities.validationsList(maduranteProductos) == true) {
				throw new ZMessManager().new DeletingException("maduranteProductos");
			}

			precioPromProds = precioPromProdDAO.findByProperty("producto.productoId", entity.getProductoId());

			if (Utilities.validationsList(precioPromProds) == true) {
				throw new ZMessManager().new DeletingException("precioPromProds");
			}

			productoDAO.delete(entity);

			log.debug("delete Producto successful");
		} catch (Exception e) {
			log.error("delete Producto failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateProducto(Producto entity, List<PrecioPromProdDTO> dataDetPrecioProductos, List<DatProductosRelacionadosDTO> dataProdRelacionado) throws Exception {
		log.debug("updating Producto instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Producto");
			}

			if (entity.getAlmacen() == null) {
				throw new ZMessManager().new ForeignException("almacen");
			}

			if (entity.getUdadMedByUdadMedProd() == null) {
				throw new ZMessManager().new ForeignException("udadMedByUdadMedProd");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getEsGranel() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEsGranel(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("esGranel");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getFlujoMovimiento() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getFlujoMovimiento(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("flujoMovimiento");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 300) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 300) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if (entity.getProductoId() == null) {
				throw new ZMessManager().new EmptyFieldException("productoId");
			}

			if ((entity.getProductoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getProductoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("productoId");
			}

			if (entity.getAlmacen().getAlmacenId() == null) {
				throw new ZMessManager().new EmptyFieldException("almacenId_Almacen");
			}

			if ((entity.getAlmacen().getAlmacenId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAlmacen().getAlmacenId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("almacenId_Almacen");
			}

			if ((entity.getCentCost() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCentCost(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("centCostId_CentCost");
			}

			if ((entity.getClaseToxicologica() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getClaseToxicologica(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("claseToxicId_ClaseToxicologica");
			}

			if ((entity.getElementoCosto() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getElementoCosto(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("elemCostoId_ElementoCosto");
			}

			if (entity.getTipoProducto().getTipoProdId() == null) {
				throw new ZMessManager().new EmptyFieldException("tipoProdId_TipoProducto");
			}

			if ((entity.getTipoProducto().getTipoProdId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getTipoProducto().getTipoProdId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoProdId_TipoProducto");
			}

			if (entity.getUdadMedByUdadMedProd().getUdadMedId() == null) {
				throw new ZMessManager().new EmptyFieldException("udadMedId_UdadMed");
			}

			if ((entity.getUdadMedByUdadMedProd().getUdadMedId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getUdadMedByUdadMedProd().getUdadMedId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("udadMedId_UdadMed");
			}

			if ((entity.getUdadMedByUdadMedCosecha() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUdadMedByUdadMedCosecha(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("udadMedId_UdadMed");
			}

			productoDAO.update(entity);

			if (dataDetPrecioProductos != null) {

				for (PrecioPromProdDTO valorDto : dataDetPrecioProductos) {

					if (valorDto.getPrecioProdId() == null) {

						PrecioPromProd valor = new PrecioPromProd();

						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaVencimiento(valorDto.getFechaVencimiento());
						valor.setCantidadCompra(valorDto.getCantidadCompra());
						valor.setUnidadMedida(valorDto.getUnidadMedida());
						valor.setLoteCompraProducto(valorDto.getLoteCompraProducto());
						valor.setRegistroIca(valorDto.getRegistroIca());
						valor.setAlmacenId(valorDto.getAlmacenId());
						valor.setValorUnitario(valorDto.getValorUnitario());
						valor.setCompania(valorDto.getCompania());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaModificacion(valorDto.getFechaModificacion());

						valor.setProducto(entity);

						precioPromProdDAO.save(valor);
						
					} else {
						
						PrecioPromProd valor = precioPromProdDAO.findById(valorDto.getPrecioProdId());

						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaVencimiento(valorDto.getFechaVencimiento());
						valor.setCantidadCompra(valorDto.getCantidadCompra());
						valor.setUnidadMedida(valorDto.getUnidadMedida());
						valor.setLoteCompraProducto(valorDto.getLoteCompraProducto());
						valor.setRegistroIca(valorDto.getRegistroIca());
						valor.setAlmacenId(valorDto.getAlmacenId());
						valor.setValorUnitario(valorDto.getValorUnitario());
						valor.setCompania(valorDto.getCompania());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaModificacion(valorDto.getFechaModificacion());

						valor.setProducto(entity);

						precioPromProdDAO.save(valor);
					}
				}
			}

			if (dataProdRelacionado != null) {

				for (DatProductosRelacionadosDTO valorDto : dataProdRelacionado) {

					if (valorDto.getDatProductosAgregadosId() == null) {

						DatProductosRelacionados valor = new DatProductosRelacionados();

						valor.setProductoAsociadoId(valorDto.getProductoAsociadoId());
						valor.setUdadMed(logicUdadMed6.getUdadMed(valorDto.getUdadMedId_UdadMed()));
						valor.setPorcentaje(valorDto.getPorcentaje());
						valor.setDosis(valorDto.getDosis());
						valor.setCantidad(valorDto.getCantidad());
						valor.setProducto(entity);

						datProductosRelacionadosDAO.save(valor);
					} else {
						
						DatProductosRelacionados valor = datProductosRelacionadosDAO.findById(valorDto.getDatProductosAgregadosId());
						valor.setProductoAsociadoId(valorDto.getProductoAsociadoId());
						valor.setUdadMed(logicUdadMed6.getUdadMed(valorDto.getUdadMedId_UdadMed()));
						valor.setPorcentaje(valorDto.getPorcentaje());
						valor.setDosis(valorDto.getDosis());
						valor.setCantidad(valorDto.getCantidad());
						valor.setProducto(entity);
				 

						datProductosRelacionadosDAO.update(valor);
					}
				}
			}

			log.debug("update Producto successful");
		} catch (Exception e) {
			log.error("update Producto failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductoDTO> getDataProducto() throws Exception {
		try {
			List<Producto> producto = productoDAO.findAll();

			List<ProductoDTO> productoDTO = new ArrayList<ProductoDTO>();

			for (Producto productoTmp : producto) {
				ProductoDTO productoDTO2 = new ProductoDTO();

				productoDTO2.setProductoId(productoTmp.getProductoId());
				productoDTO2.setCodigo((productoTmp.getCodigo() != null) ? productoTmp.getCodigo() : null);
				productoDTO2.setCompania((productoTmp.getCompania() != null) ? productoTmp.getCompania() : null);
				productoDTO2.setRequiereSellos((productoTmp.getRequiereSellos() != null) ? productoTmp.getRequiereSellos() : null);
				productoDTO2.setEsGranel((productoTmp.getEsGranel() != null) ? productoTmp.getEsGranel() : null);
				productoDTO2.setEstado((productoTmp.getEstado() != null) ? productoTmp.getEstado() : null);
				productoDTO2.setFechaCreacion(productoTmp.getFechaCreacion());
				productoDTO2.setFechaModificacion(productoTmp.getFechaModificacion());
				productoDTO2.setFlujoMovimiento(
						(productoTmp.getFlujoMovimiento() != null) ? productoTmp.getFlujoMovimiento() : null);
				productoDTO2.setInfoAdicional(
						(productoTmp.getInfoAdicional() != null) ? productoTmp.getInfoAdicional() : null);
				productoDTO2.setInfoAdicional2(
						(productoTmp.getInfoAdicional2() != null) ? productoTmp.getInfoAdicional2() : null);
				productoDTO2.setNombre((productoTmp.getNombre() != null) ? productoTmp.getNombre() : null);
				productoDTO2
						.setObservacion((productoTmp.getObservacion() != null) ? productoTmp.getObservacion() : null);

				if (productoTmp.getAlmacen() != null) {
					productoDTO2.setAlmacenId_Almacen(productoTmp.getAlmacen().getAlmacenId());
				} else {
					productoDTO2.setAlmacenId_Almacen(null);
				}
				
				if (productoTmp.getUbicacionesAlmacenId() != null) {
					productoDTO2.setUbicacionesAlmacenId(productoTmp.getUbicacionesAlmacenId());
				} else {
					productoDTO2.setUbicacionesAlmacenId(null);
				}

				productoDTO2
						.setCentCostId_CentCost((productoTmp.getCentCost() != null) ? productoTmp.getCentCost() : null);
				productoDTO2.setClaseToxicId_ClaseToxicologica(
						(productoTmp.getClaseToxicologica() != null) ? productoTmp.getClaseToxicologica() : null);
				productoDTO2.setElemCostoId_ElementoCosto(
						(productoTmp.getElementoCosto() != null) ? productoTmp.getElementoCosto() : null);
				productoDTO2.setTipoProdId_TipoProducto((productoTmp.getTipoProducto().getTipoProdId() != null)
						? productoTmp.getTipoProducto().getTipoProdId() : null);
				productoDTO2.setUdadMedId_UdadMed_Prod((productoTmp.getUdadMedByUdadMedProd().getUdadMedId() != null)
						? productoTmp.getUdadMedByUdadMedProd().getUdadMedId() : null);
				productoDTO2.setUdadMedId_UdadMed_Cosecha((productoTmp.getUdadMedByUdadMedCosecha() != null)
						? productoTmp.getUdadMedByUdadMedCosecha() : null);

				productoDTO2.setUsuarioDigitacion((productoTmp.getUsuarioDigitacion() != null)
						? productoTmp.getUsuarioDigitacion() : null);

				if (productoTmp.getTipoProducto() != null) {
					productoDTO2.setCodTipoProducto(productoTmp.getTipoProducto().getCodigo());
				} else {
					productoDTO2.setCodTipoProducto(null);
				}

				if (productoTmp.getTipoProducto() != null) {
					productoDTO2.setNomTipoProducto(productoTmp.getTipoProducto().getNombre());
				} else {
					productoDTO2.setNomTipoProducto(null);
				}
				

				productoDTO2.setSaldoMinimo(productoTmp.getSaldoMinimo());
				productoDTO2.setSaldoMaximo(productoTmp.getSaldoMaximo());
				
				productoDTO.add(productoDTO2);
			}

			return productoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Producto getProducto(Long productoId) throws Exception {
		log.debug("getting Producto instance");

		Producto entity = null;

		try {
			entity = productoDAO.findById(productoId);
		} catch (Exception e) {
			log.error("get Producto failed", e);
			throw new ZMessManager().new FindingException("Producto");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findPageProducto(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Producto> entity = null;

		try {
			entity = productoDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Producto Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberProducto() throws Exception {
		Long entity = null;

		try {
			entity = productoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Producto Count");
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
	 * @param variablesBetweenDates
	 *            (en este caso solo para mysql) [0] = String variable =
	 *            (String) varibles[k]; el nombre de la variable que hace
	 *            referencia a una fecha
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
	public List<Producto> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Producto> list = new ArrayList<Producto>();
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
			list = productoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	@Transactional(readOnly = true)
	public List<ProductoDTO> findByCriteriaPageProducto(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception {
		try {
			List<Producto> entity = null;

			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();

			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();
				whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
						+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";
			}

			entity = productoDAO.findByCriteriaPage(whereCondition, sortField, sortOrder, startRow, pageSize);

			List<ProductoDTO> productoDTO = new ArrayList<ProductoDTO>();

			for (Producto productoTmp : entity) {
				ProductoDTO productoDTO2 = new ProductoDTO();

				productoDTO2.setProductoId(productoTmp.getProductoId());
				productoDTO2.setCodigo((productoTmp.getCodigo() != null) ? productoTmp.getCodigo() : null);
				productoDTO2.setCompania((productoTmp.getCompania() != null) ? productoTmp.getCompania() : null);
				productoDTO2.setRequiereSellos((productoTmp.getRequiereSellos() != null) ? productoTmp.getRequiereSellos() : null);
				productoDTO2.setEsGranel((productoTmp.getEsGranel() != null) ? productoTmp.getEsGranel() : null);
				productoDTO2.setEstado((productoTmp.getEstado() != null) ? productoTmp.getEstado() : null);
				productoDTO2.setFechaCreacion(productoTmp.getFechaCreacion());
				productoDTO2.setFechaModificacion(productoTmp.getFechaModificacion());
				productoDTO2.setFlujoMovimiento(
						(productoTmp.getFlujoMovimiento() != null) ? productoTmp.getFlujoMovimiento() : null);
				productoDTO2.setInfoAdicional(
						(productoTmp.getInfoAdicional() != null) ? productoTmp.getInfoAdicional() : null);
				productoDTO2.setInfoAdicional2(
						(productoTmp.getInfoAdicional2() != null) ? productoTmp.getInfoAdicional2() : null);
				productoDTO2.setNombre((productoTmp.getNombre() != null) ? productoTmp.getNombre() : null);
				productoDTO2
						.setObservacion((productoTmp.getObservacion() != null) ? productoTmp.getObservacion() : null);

				if (productoTmp.getAlmacen() != null) {
					productoDTO2.setAlmacenId_Almacen(productoTmp.getAlmacen().getAlmacenId());
				} else {
					productoDTO2.setAlmacenId_Almacen(null);
				}

				productoDTO2
						.setCentCostId_CentCost((productoTmp.getCentCost() != null) ? productoTmp.getCentCost() : null);
				productoDTO2.setClaseToxicId_ClaseToxicologica(
						(productoTmp.getClaseToxicologica() != null) ? productoTmp.getClaseToxicologica() : null);
				productoDTO2.setElemCostoId_ElementoCosto(
						(productoTmp.getElementoCosto() != null) ? productoTmp.getElementoCosto() : null);
				productoDTO2.setTipoProdId_TipoProducto((productoTmp.getTipoProducto().getTipoProdId() != null)
						? productoTmp.getTipoProducto().getTipoProdId() : null);
				productoDTO2.setUdadMedId_UdadMed_Prod((productoTmp.getUdadMedByUdadMedProd().getUdadMedId() != null)
						? productoTmp.getUdadMedByUdadMedProd().getUdadMedId() : null);
				productoDTO2.setUdadMedId_UdadMed_Cosecha((productoTmp.getUdadMedByUdadMedCosecha() != null)
						? productoTmp.getUdadMedByUdadMedCosecha() : null);

				productoDTO2.setUsuarioDigitacion((productoTmp.getUsuarioDigitacion() != null)
						? productoTmp.getUsuarioDigitacion() : null);
				
				if (productoTmp.getTipoProducto() != null) {
					productoDTO2.setCodTipoProducto(productoTmp.getTipoProducto().getCodigo());
				} else {
					productoDTO2.setCodTipoProducto(null);
				}
				
				if (productoTmp.getUbicacionesAlmacenId() != null) {
					productoDTO2.setUbicacionesAlmacenId(productoTmp.getUbicacionesAlmacenId());
				} else {
					productoDTO2.setUbicacionesAlmacenId(null);
				}

				if (productoTmp.getTipoProducto() != null) {
					productoDTO2.setNomTipoProducto(productoTmp.getTipoProducto().getNombre());
				} else {
					productoDTO2.setNomTipoProducto(null);
				}

				productoDTO2.setSaldoMinimo(productoTmp.getSaldoMinimo());
				productoDTO2.setSaldoMaximo(productoTmp.getSaldoMaximo());
				productoDTO2.setEsFormula(productoTmp.getEsFormula());
				productoDTO.add(productoDTO2);
			}

			return productoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberProducto(Map<String, Object> filters) throws Exception {
		Long entity = null;

		try {
			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();
				whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
						+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";
			}
			entity = productoDAO.countByCriteria(whereCondition);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("EstPluvio Count");
		} finally {
		}
		return entity;
	}
}
