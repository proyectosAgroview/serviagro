package co.com.arcosoft.rest.service.control;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.bean.ManagedProperty;

import org.apache.commons.logging.Log;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.arcosoft.modelo.Almacen;
import co.com.arcosoft.modelo.CategoriaEquipo;
import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.ConceptoKardex;
import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.DatOtrosMovInventario;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Nivel2Clientesmq;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.PrecioPromProd;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.control.IAlmacenLogic;
import co.com.arcosoft.modelo.control.IConceptoKardexLogic;
import co.com.arcosoft.modelo.control.IDatPlanLaborDetLogic;
import co.com.arcosoft.modelo.control.IEquipoLogic;
import co.com.arcosoft.modelo.control.ILaborLogic;
import co.com.arcosoft.modelo.control.INivel2ClientesmqLogic;
import co.com.arcosoft.modelo.control.IPersEmprLogic;
import co.com.arcosoft.modelo.control.IProductoLogic;
import co.com.arcosoft.modelo.control.ITrabajadorLogic;
import co.com.arcosoft.modelo.dto.PrecioPromProdDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.presentation.businessDelegate2.IBusinessDelegator2View;
import co.com.arcosoft.rest.service.dto.SalidaCombustibleSensorDTO;

@Controller
@RequestMapping("/transacciones")
public class WsSalidaCombustibleSensor2 {

	private static final Logger logger = LoggerFactory.getLogger(WsSalidaCombustibleSensor2.class);

	@Autowired
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@Autowired
	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	private PrecioPromProd entityDet = null;
	private DatOtrosMovInventario entity = null;
	 
	List<PrecioPromProdDTO> precioPromProdDTO = null;
	List<PrecioPromProdDTO> dataDetPrecioProductos = null;
	List<PrecioPromProdDTO> dataDetPrecioProductosEntrada = null;
	
	@Autowired
	IDatPlanLaborDetLogic planLaborLogic;

	@Autowired
	ILaborLogic laborlogic;

	@Autowired
	ITrabajadorLogic trabajadorLogic;

	@Autowired
	IProductoLogic productoLogic;

	@Autowired
	IConceptoKardexLogic conceptoKardexLogic;

	@Autowired
	INivel2ClientesmqLogic nivel2ClientesmqLogic;

	@Autowired
	IPersEmprLogic persEmprLogic;

	@Autowired
	IEquipoLogic equipoLogic;

	@Autowired
	IAlmacenLogic almacenLogic;
	
	@Resource
	private SessionFactory sessionFactory;
	
	boolean existeOT = false;

	@RequestMapping(value = "/guardarSalidaCombustibleSensor", method = RequestMethod.POST)
	public ResponseEntity<String> guardarSalidaCombustible(@RequestBody SalidaCombustibleSensorDTO salidaCombustible)
			throws Exception {

		Labor labor = null;
		Nivel2Clientesmq nivNivel2Clientesmqel2 = null;
		PersEmpr persEmpr = null;
		Producto producto = null;
		ConceptoKardex conceptoKardex = null;
		PrecioPromProd precioPromProd = null;
		Compania compania = null;
		Equipo equipo = null;

		PrecioPromProdDTO detDto = null;
		PrecioPromProdDTO detEntradaDto = null;
		UdadMed unidadpago = null;
		Trabajador bombero = null;
		Date fechaFinalDateRegistro = null;
		Long consecutivo = null;
		ConceptoNomina conceptoNomina = null;
		Almacen almacen = null;
		Trabajador operarioMaquina = null;
		Usuarios usuarios =null;
		Almacen almacenEntrada =null;
		
		Almacen almacenSalida =null;
		Long companiaId = 1L;
		ConceptoKardex kardexSalida = null;
		ConceptoKardex kardexEntrada = null;
		
		logger.info("Recepción de informacion del sensor");

		Long usuarioId = null;
		compania = businessDelegatorView.getCompania(companiaId);
		
		if (salidaCombustible != null		) {
			String codigoMaquina = ""+salidaCombustible.getCodigoMaquina();
			
			if(codigoMaquina.equals("NPR") || codigoMaquina.equals("FORD") ) {

				Date date = new Date();

				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
				SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");

				String fechaOriginal =""+  salidaCombustible.getFecha();// foriginal.parse(salidaCombustible.getFechaInicial());
				// String fsalida = sdf.format(fechaOriginal);
				fechaFinalDateRegistro = sdf.parse(fechaOriginal);
				Long idCompania = 1L;
				compania = businessDelegatorView.getCompania(1L);
				entity = new DatOtrosMovInventario();
				entity.setEstado("A");
				entity.setFechaRegistro(fechaFinalDateRegistro);
				entity.setCompania(1L);
				entity.setFechaCreacion(date);
				entity.setDetalleNota("TRASLADO DE COMBUSTIBLE DESDE EL SENSOR DE ABASTECIMIENTO");
				
				
			/*** AGREGAR SESION CONCEPTO DE KARDEX**/

				
				// PRECIO_PROM_PROD
				dataDetPrecioProductos = new ArrayList<PrecioPromProdDTO>();
				detDto = new PrecioPromProdDTO();
				
				dataDetPrecioProductosEntrada = new ArrayList<PrecioPromProdDTO>();
				detEntradaDto = new PrecioPromProdDTO();
				
				String codigoUsuario = ""+salidaCombustible.getCodigoUsuario();
				Object[] condicionUsuario = {"login" , true , codigoUsuario.toString().trim().toUpperCase() , "=" };
				List<Usuarios> listaUsuario  = (condicionUsuario != null)
						? businessDelegatorView.findByCriteriaInUsuarios(condicionUsuario, null, null) : null;
				if(listaUsuario!=null && listaUsuario.size() >=0) {
					usuarios =listaUsuario.get(0);
					usuarioId = usuarios.getUsuarioId();
					entity.setUsuarioDigitacion(usuarioId);
					if (usuarioId != null) {
						Object[] condicionBombero = { "usuario_asociado", true, usuarioId, "=" };
						List<Trabajador> listaBombero = (condicionBombero != null)
								? businessDelegatorView.findByCriteriaInTrabajador(condicionBombero, null, null)
								: null;
						if (listaBombero != null && listaBombero.size() > 0) {
							bombero = listaBombero.get(0);
							detDto.setTrabajador(bombero);
							detDto.setUsuarioDigitacion(usuarioId);
							detEntradaDto.setTrabajador(bombero);
							detEntradaDto.setUsuarioDigitacion(usuarioId);
						}
					}
					
				}
				
				

				detDto.setInfoAdicional("Traslado de combustible automático desde el sensor");
				detEntradaDto.setInfoAdicional("Traslado de combustible automático desde el sensor");
				

				Double cantidadAbastecimiento = salidaCombustible.getCantidadCombustibleSurtidor().doubleValue();
			
				
				
				Long productoFinal =  compania.getProductoCombustibleId();
				producto = businessDelegatorView.getProducto(productoFinal);
				Long udadMedId = producto.getUdadMedByUdadMedProd().getUdadMedId();

				unidadpago = businessDelegatorView.getUdadMed(udadMedId);

				detDto.setFechaInicial(fechaFinalDateRegistro);
				detDto.setProducto(producto);
				detDto.setUnidadMedida(unidadpago);
			
				detEntradaDto.setFechaInicial(fechaFinalDateRegistro);
				detEntradaDto.setProducto(producto);
				detEntradaDto.setUnidadMedida(unidadpago);
			
				
				Double horometroAbastecimiento = (double) Math.round(salidaCombustible.getHorometroAbastecimiento().doubleValue() *10)/10;
				detDto.setHorometro_abastecimiento(horometroAbastecimiento);
				detEntradaDto.setHorometro_abastecimiento(horometroAbastecimiento);
				
				String id_registro = salidaCombustible.getId_registro().toString();
				detDto.setInfoAdicional2(id_registro);
				detEntradaDto.setInfoAdicional2(id_registro);
				
				/**********almacen salida ***/
				Long idAlmacenSalida=null;
				String codigoAlmacenSalida =""+ salidaCombustible.getCodigoSurtidor();
				Object[] condicionAlmacenSalida = {"codigo" , true , codigoAlmacenSalida.toString().trim().toUpperCase() , "=" };
				List<Almacen> listaAlmacenSalida  = (condicionAlmacenSalida != null)
						? businessDelegatorView.findByCriteriaInAlmacen(condicionAlmacenSalida, null, null) : null;
				if(listaAlmacenSalida!=null && listaAlmacenSalida.size() >=0) {
					almacenSalida = listaAlmacenSalida.get(0);
					idAlmacenSalida=almacenSalida.getAlmacenId();
					almacenSalida = businessDelegatorView.getAlmacen(idAlmacenSalida);
					detDto.setAlmacenId(almacenSalida);
				}
				
				
				/***** almacen de entrada***/
				Long idAlmacenEntrada=null;
				String codigoAlmacenEntrada =""+ salidaCombustible.getCodigoMaquina();
				Object[] condicionAlmacenEntrada = {"codigo" , true , codigoAlmacenEntrada.toString().trim().toUpperCase() , "=" };
				List<Almacen> listaAlmacenEntrada  = (condicionAlmacenEntrada != null)
						? businessDelegatorView.findByCriteriaInAlmacen(condicionAlmacenEntrada, null, null) : null;
				if(listaAlmacenEntrada!=null && listaAlmacenEntrada.size() >=0) {
					almacenEntrada = listaAlmacenEntrada.get(0);
					idAlmacenEntrada=almacenEntrada.getAlmacenId();
					almacenEntrada = businessDelegatorView.getAlmacen(idAlmacenEntrada);
					detEntradaDto.setAlmacenId(almacenEntrada);
				}
				
			
			

				Double costoUnitCombustible = businessDelegatorView.consultarPrecioPromProducto(productoFinal, idAlmacenSalida,
						idCompania, fechaFinalDateRegistro);
				Double costoCombustible = 0.0;
				if (costoUnitCombustible != null) {
					costoCombustible = costoUnitCombustible.doubleValue() * cantidadAbastecimiento;
				}
				detDto.setCantidadCompra(cantidadAbastecimiento);
				detDto.setValorUnitario(costoUnitCombustible);
				detDto.setCostoTotal(costoCombustible);
				detDto.setCompania(companiaId);
				detDto.setFechaCreacion(date);

				detEntradaDto.setCantidadCompra(cantidadAbastecimiento);
				detEntradaDto.setValorUnitario(costoUnitCombustible);
				detEntradaDto.setCostoTotal(costoCombustible);
				detEntradaDto.setCompania(companiaId);
				detEntradaDto.setFechaCreacion(date);

				detDto.setTipoMovimiento("INTERFAZ");
				detDto.setDiferido("NO");
				
				detEntradaDto.setTipoMovimiento("INTERFAZ");
				detEntradaDto.setDiferido("NO");
				
				kardexSalida = businessDelegator2View.getConceptoKardex(10L);
				kardexEntrada = businessDelegator2View.getConceptoKardex(9L);
				
				detDto.setConceptoKardexId(kardexSalida);
				detEntradaDto.setConceptoKardexId(kardexEntrada);
				
				/***************movimiento de traslado de salida***/
				entity.setConsecutivo(businessDelegator2View.consec_otros_mov_inventario(companiaId));
				entity.setConceptoKardex(kardexSalida);
				consecutivo = entity.getConsecutivo().longValue();
				detDto.setConsecutivo(consecutivo);
				dataDetPrecioProductos.add(detDto);
				businessDelegator2View.saveDatOtrosMovInventario(entity, dataDetPrecioProductos);
				
				
				/***************movimiento de traslado de entrada***/
				//entity.setConsecutivo(businessDelegator2View.consec_otros_mov_inventario(companiaId));
				entity.setConceptoKardex(kardexEntrada);
				detEntradaDto.setConsecutivo(consecutivo);
				dataDetPrecioProductosEntrada.add(detEntradaDto);
				businessDelegator2View.saveDatOtrosMovInventario(entity, dataDetPrecioProductosEntrada);
				

				detDto = null;
				detEntradaDto = null;
				fechaFinalDateRegistro = null;
				existeOT = false;
				
				producto = null;
				conceptoKardex = null;
				precioPromProd = null;
				compania = null;
				equipo = null;

				detDto = null;
				unidadpago = null;
				bombero = null;
				fechaFinalDateRegistro = null;
				consecutivo = null;
				
				almacen = null;
				operarioMaquina = null;
			
			}else {
				entityDet = new PrecioPromProd();
				Date date = new Date();

				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
				SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");

				String fechaOriginal =""+  salidaCombustible.getFecha();// foriginal.parse(salidaCombustible.getFechaInicial());
				// String fsalida = sdf.format(fechaOriginal);
				fechaFinalDateRegistro = sdf.parse(fechaOriginal);
				
				entityDet.setInfoAdicional("");
				

				Double cantidadAbastecimiento = salidaCombustible.getCantidadCombustibleSurtidor().doubleValue();
				Long conceptoKardexSalida =null;
				
				Long idAlmacen =0L;
				Double costoUnitCombustible =0.0;
				
				Object[] condicionMaquina = {"codigo" , true , codigoMaquina.toString().trim().toUpperCase() , "=" };
				List<Equipo> listaMaquina  = (condicionMaquina != null)
						? businessDelegatorView.findByCriteriaInEquipo(condicionMaquina, null, null) : null;
				
				if(listaMaquina!=null && listaMaquina.size() >0) {
					equipo = listaMaquina.get(0);
					Long categoriaId =equipo.getCategoriaEquipo().getCategEquipId();
					CategoriaEquipo categoria = businessDelegatorView.getCategoriaEquipo(categoriaId);
					if(equipo.getCentCost()!=null) {
						entityDet.setCentCostId(equipo.getCentCost());	
						
					}
					if(categoria.getConceptoKardexId()!=null) {
						conceptoKardexSalida= categoria.getConceptoKardexId().getConceptoKardexId();
						conceptoKardex = businessDelegator2View.getConceptoKardex(conceptoKardexSalida);
					}else {
						conceptoKardexSalida= 8L;//compania.getKardexSalidaEstandar();
						conceptoKardex = businessDelegator2View.getConceptoKardex(conceptoKardexSalida);
					}
					
				
					if(equipo.getProductoId()!=null) {
						Long productoAsociado = equipo.getProductoId();

						producto = businessDelegatorView.getProducto(productoAsociado);
						Long udadMedId = producto.getUdadMedByUdadMedProd().getUdadMedId();

						unidadpago = businessDelegatorView.getUdadMed(udadMedId);
						 costoUnitCombustible = businessDelegatorView.consultarPrecioPromProducto(productoAsociado, 1l,
								companiaId, fechaFinalDateRegistro);
						}
				}
				
				
				entityDet.setConceptoKardexId(conceptoKardex);
				 
				
			
				
				entityDet.setFechaInicial(fechaFinalDateRegistro);
				entityDet.setProducto(producto);
				entityDet.setUnidadMedida(unidadpago);
				entityDet.setEquipoId(equipo);
				
				Double horometroAbastecimiento = salidaCombustible.getHorometroAbastecimiento().doubleValue();
				entityDet.setHorometro_abastecimiento(horometroAbastecimiento);

				Long indicador_vuelta_medidor=0L;
				if(equipo.getIndicador_vuelta_medidor()!=null) {
					indicador_vuelta_medidor = equipo.getIndicador_vuelta_medidor();
				}
				entityDet.setIndicador_vuelta_medidor(indicador_vuelta_medidor);
				
				
				String codigoAlmacen =""+ salidaCombustible.getCodigoSurtidor();
				Object[] condicionAlmacen = {"codigo" , true , codigoAlmacen.toString().trim().toUpperCase() , "=" };
				List<Almacen> listaAlmacen  = (condicionAlmacen != null)
						? businessDelegatorView.findByCriteriaInAlmacen(condicionAlmacen, null, null) : null;
				if(listaAlmacen!=null && listaAlmacen.size() >=0) {
					almacen = listaAlmacen.get(0);
					idAlmacen=almacen.getAlmacenId();
					almacen = businessDelegatorView.getAlmacen(idAlmacen);
					entityDet.setAlmacenId(almacen);
				}
				
			
				Double costoCombustible = 0.0;
				if (costoUnitCombustible != null) {
					costoCombustible = costoUnitCombustible.doubleValue() * cantidadAbastecimiento;
					costoCombustible = (double) Math.round((costoCombustible) * 1000) / 1000;
				}
				entityDet.setCantidadCompra(cantidadAbastecimiento);
				entityDet.setValorUnitario(costoUnitCombustible);
				entityDet.setCostoTotal(costoCombustible);
				entityDet.setCompania(companiaId);
				entityDet.setFechaCreacion(date);

				
				String codigoUsuario = ""+salidaCombustible.getCodigoUsuario();
				Object[] condicionUsuario = {"login" , true , codigoUsuario.toString().trim().toUpperCase() , "=" };
				List<Usuarios> listaUsuario  = (condicionUsuario != null)
						? businessDelegatorView.findByCriteriaInUsuarios(condicionUsuario, null, null) : null;
				if(listaUsuario!=null && listaUsuario.size() >=0) {
					usuarios =listaUsuario.get(0);
					usuarioId = usuarios.getUsuarioId();
					entityDet.setUsuarioDigitacion(usuarioId);
					if (usuarioId != null) {
						Object[] condicionBombero = { "usuario_asociado", true, usuarioId, "=" };
						List<Trabajador> listaBombero = (condicionBombero != null)
								? businessDelegatorView.findByCriteriaInTrabajador(condicionBombero, null, null)
								: null;
						if (listaBombero != null && listaBombero.size() > 0) {
							bombero = listaBombero.get(0);
							entityDet.setTrabajador(bombero);
						}
					}
					
				}

	
				entityDet.setTipoMovimiento("INTERFAZ");
				entityDet.setDiferido("NO");

				String id_registro = salidaCombustible.getId_registro().toString();
				
				entityDet.setInfoAdicional2(id_registro);
				
				
				businessDelegatorView.savePrecioPromProd(entityDet);

				entityDet = null;
				fechaFinalDateRegistro = null;
				existeOT = false;
				labor = null;
				nivNivel2Clientesmqel2 = null;
				persEmpr = null;
				producto = null;
				conceptoKardex = null;
				precioPromProd = null;
				compania = null;
				equipo = null;

				detDto = null;
				
				unidadpago = null;
				bombero = null;
				fechaFinalDateRegistro = null;
				consecutivo = null;
				conceptoNomina = null;
				almacen = null;
				operarioMaquina = null;
				
			}
			

			return new ResponseEntity<String>("OK", HttpStatus.CREATED);
			
			
			
			
			
			
		} else {

			return new ResponseEntity<String>("El objeto Sálida de combustible enviado desde AgroViewMobile es nulo",
					HttpStatus.BAD_REQUEST);
		}

	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

}
