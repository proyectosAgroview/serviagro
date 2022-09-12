package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Almacen;
import co.com.arcosoft.modelo.CentCost;
import co.com.arcosoft.modelo.Ciudad;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.Profesion;
import co.com.arcosoft.modelo.TipoProducto;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;

@ManagedBean
@ViewScoped
public class interfaceCatalogosManagerView implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(interfaceCatalogosManagerView.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private CommandButton btnImportar;
	private CommandButton btnGenerarInterface;

	@Resource(name = "jdbc/postgres")
	private DataSource ds;

	private Almacen entityAlmacen = null;
	private TipoProducto entityTipo = null;
	private Producto entityProducto = null;
	private PersEmpr entityPer = null;
	private CentCost entityCenCost = null;
	private Profesion entityProf = null;
	private Trabajador entityTrab = null;
	private UdadMed entityUm = null;

	private InputTextarea logImport;
	private String importandoTxt = "";

	private Integer progress;
	private Integer sizeNum;
	private String mensaje = "";

	public void cargarCatalogos() throws SQLException, Exception {

		cargarAlmacenErp();
		cargarUnidadMedidaErp();
		cargarCentroCostoErp();
		cargarTipoProductoErp();
		cargarProductoErp();
		cargarEmpresasErp();
	}

	public void onComplete() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Importanción completada.."));
	}

	public int cantidadRegistros(String modulo) throws SQLException, Exception {

		Connection conn = null;
		Statement statement = null; // Or PreparedStatement if needed
		ResultSet rs = null;
		String consulta = "";
		int cantidadReg = 0;

		if (modulo.equals("unidad_medida")) {
			consulta = "select count(*) AS total from integra_agroview.vw_agvw_unimed";
		}

		if (modulo.equals("almacen")) {
			consulta = "select count(*) AS total from integra_agroview.vw_agvw_almacen";
		}

		if (modulo.equals("tipo_producto")) {
			consulta = "select count(*) AS total from integra_agroview.vw_agvw_tipo_producto";
		}

		if (modulo.equals("producto")) {
			consulta = "select count(*) AS total from integra_agroview.vw_agvw_producto";
		}

		if (modulo.equals("empresas")) {
			consulta = "select count(*) AS total from integra_agroview.vw_agvw_empresa";
		}

		if (modulo.equals("centroConsto")) {
			consulta = "select count(*) AS total from integra_agroview.vw_agvw_cent_cost";
		}

		try {

			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/postgres");

			conn = ds.getConnection();
			statement = conn.createStatement();
			rs = statement.executeQuery(consulta);

			while (rs.next()) {
				cantidadReg = rs.getInt("total");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null;
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				statement = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}

		return cantidadReg;
	}

	public void cargarUnidadMedidaErp() throws SQLException, Exception {

		String metodo = "unidad_medida";
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		List<UdadMed> cc = null;

		int count = 0;

		try {

			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/postgres");
			conn = ds.getConnection();

			String sql = "select * from integra_agroview.vw_agvw_unimed";
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);

			Date date = new Date();

			while (rs.next()) {

				++count;

				entityUm = null;
				Date fmodificAW = null;
				Date fcreacionAW = null;

				String codigo = rs.getString("CODIGO").trim();
				String nombre = rs.getString("NOMBRE").trim();
				Long compania = rs.getLong("COMPANIA");
				String estado = rs.getString("ESTADO");
				String clasificacion = "Otros";

				Date fmodific = rs.getTimestamp("FECHA_MODIFICACION");
				Date fcrea = rs.getTimestamp("FECHA_CREACION");

				Object[] condicion = { "codigo", true, codigo, "=" };
				cc = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);

				if (cc != null && cc.size() > 0) {
					if (cc.get(0).getFechaModificacion() != null && fmodific != null) {

						fmodificAW = cc.get(0).getFechaModificacion();
						if (fmodific.getTime() > fmodificAW.getTime()) {
							entityUm = cc.get(0);
							entityUm.setCodigo(codigo);
							entityUm.setNombre(nombre);
							entityUm.setCompania(compania);
							entityUm.setEstado(estado);
							entityUm.setClasificacionUm(clasificacion);
							entityUm.setFechaModificacion(fmodific);
							businessDelegatorView.updateUdadMed(entityUm);
						}

					} else {

						if (cc.get(0).getFechaCreacion() != null && fmodific != null) {
							fcreacionAW = cc.get(0).getFechaCreacion();
							if (fmodific.getTime() > fcreacionAW.getTime()) {

								entityUm = cc.get(0);
								entityUm.setCodigo(codigo);
								entityUm.setNombre(nombre);
								entityUm.setCompania(compania);
								entityUm.setEstado(estado);
								entityUm.setClasificacionUm(clasificacion);
								entityUm.setFechaModificacion(fmodific);
								businessDelegatorView.updateUdadMed(entityUm);
							}
						}
					}

				} else {

					entityUm = new UdadMed();
					entityUm.setCodigo(codigo);
					entityUm.setNombre(nombre);
					entityUm.setCompania(compania);
					entityUm.setEstado(estado);
					entityUm.setClasificacionUm(clasificacion);
					entityUm.setFechaCreacion(fcrea);
					businessDelegatorView.saveUdadMed(entityUm);
				}

			}

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "",
							"El catalogo de Centro de Costos ha sido importado con éxito. Registros importados: ("
									+ count + ")"));

			rs = null;
			statement.close();
			statement = null;
			conn.close();
			conn = null;
			count = 0;
			entityUm = null;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					;
				}
				rs = null;
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					;
				}
				statement = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					;
				}
				conn = null;
			}
		}

	}

	public void cargarAlmacenErp() throws SQLException, Exception {

		String metodo = "almacen";
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		List<Almacen> alamcen = null;

		int count = 0;

		try {

			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/postgres");

			conn = ds.getConnection();
			String sql = "select * from integra_agroview.vw_agvw_almacen";
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);

			Date date = new Date();

			while (rs.next()) {

				++count;

				entityAlmacen = null;
				Date fmodificAW = null;
				Date fcreacionAW = null;

				String codigo = rs.getString("CODIGO").trim();
				String nombre = rs.getString("NOMBRE").trim();
				Long compania = rs.getLong("COMPANIA");
				Long capacidadTon = rs.getLong("CAPACIDAD_TONELADAS");
				String estado = rs.getString("ESTADO");
				Date fmodific = rs.getTimestamp("FECHA_MODIFICACION");
				Date fcrea = rs.getTimestamp("FECHA_CREACION");

				Object[] condicion = { "codigo", true, codigo, "=" };
				alamcen = businessDelegatorView.findByCriteriaInAlmacen(condicion, null, null);

				if (alamcen != null && alamcen.size() > 0) {
					if (alamcen.get(0).getFechaModificacion() != null && fmodific != null) {

						fmodificAW = alamcen.get(0).getFechaModificacion();
						if (fmodific.getTime() > fmodificAW.getTime()) {
							entityAlmacen = alamcen.get(0);
							entityAlmacen.setCodigo(codigo);
							entityAlmacen.setNombre(nombre);
							entityAlmacen.setCompania(compania);
							entityAlmacen.setEstado(estado);
							entityAlmacen.setFechaModificacion(fmodific);
							businessDelegatorView.updateAlmacen(entityAlmacen);
						}

					} else {

						if (alamcen.get(0).getFechaCreacion() != null && fmodific != null) {
							fcreacionAW = alamcen.get(0).getFechaCreacion();
							if (fmodific.getTime() > fcreacionAW.getTime()) {
								entityAlmacen = alamcen.get(0);
								entityAlmacen.setCodigo(codigo);
								entityAlmacen.setNombre(nombre);
								entityAlmacen.setCompania(compania);
								entityAlmacen.setEstado(estado);
								entityAlmacen.setFechaModificacion(fmodific);
								businessDelegatorView.updateAlmacen(entityAlmacen);

							}

						}

					}

				} else {

					entityAlmacen = new Almacen();
					entityAlmacen.setCodigo(codigo);
					entityAlmacen.setNombre(nombre);
					entityAlmacen.setCompania(compania);
					entityAlmacen.setEstado(estado);
					entityAlmacen.setFechaCreacion(fcrea);
					businessDelegatorView.saveAlmacen(entityAlmacen);

				}

			}

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",
					"El catalogo de Almacen ha sido importado con éxito. Registros importados: (" + count + ")"));

			rs = null;
			statement.close();
			statement = null;
			conn.close();
			conn = null;
			count = 0;
			entityAlmacen = null;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null;
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				statement = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}

	}

	public void cargarTipoProductoErp() throws SQLException, Exception {

		String metodo = "tipo_producto";
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		List<TipoProducto> tipoproducto = null;

		int count = 0;

		try {

			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/postgres");

			conn = ds.getConnection();
			statement = conn.createStatement();
			String sql = "select * from integra_agroview.vw_agvw_tipo_producto";
			rs = statement.executeQuery(sql);

			Date date = new Date();

			while (rs.next()) {

				++count;

				entityTipo = null;
				Date fmodificAW = null;
				Date fcreacionAW = null;

				String codigo = rs.getString("CODIGO").trim();
				String nombre = rs.getString("LINEA").trim();
				Long compania = rs.getLong("COMPANIA");
				String clase_producto = rs.getString("BPCHAR");
				String estado = rs.getString("ESTADO");
				Date fmodific = rs.getTimestamp("FECHA_MODIFICACION");
				Date fcrea = rs.getTimestamp("FECHA_CREACION");

				Object[] condicion = { "codigo", true, codigo, "=" };
				tipoproducto = businessDelegatorView.findByCriteriaInTipoProducto(condicion, null, null);

				if (tipoproducto != null && tipoproducto.size() > 0) {
					if (tipoproducto.get(0).getFechaModificacion() != null && fmodific != null) {

						fmodificAW = tipoproducto.get(0).getFechaModificacion();
						if (fmodific.getTime() > fmodificAW.getTime()) {

							entityTipo = tipoproducto.get(0);
							entityTipo.setCodigo(codigo);
							entityTipo.setNombre(nombre);
							entityTipo.setCompania(compania);
							entityTipo.setClaseProducto(clase_producto);
							entityTipo.setEstado(estado);
							entityTipo.setFechaModificacion(fmodific);
							businessDelegatorView.updateTipoProducto(entityTipo);
						}
					} else {

						if (tipoproducto.get(0).getFechaCreacion() != null && fmodific != null) {
							fcreacionAW = tipoproducto.get(0).getFechaCreacion();
							if (fmodific.getTime() > fcreacionAW.getTime()) {

								entityTipo = tipoproducto.get(0);
								entityTipo.setCodigo(codigo);
								entityTipo.setNombre(nombre);
								entityTipo.setCompania(compania);
								entityTipo.setClaseProducto(clase_producto);
								entityTipo.setEstado(estado);
								entityTipo.setFechaModificacion(fmodific);
								businessDelegatorView.updateTipoProducto(entityTipo);

							}
						}
					}

				} else {

					entityTipo = new TipoProducto();
					entityTipo.setCodigo(codigo);
					entityTipo.setNombre(nombre);
					entityTipo.setCompania(compania);
					entityTipo.setClaseProducto(clase_producto);
					entityTipo.setEstado(estado);
					entityTipo.setFechaCreacion(fcrea);
					businessDelegatorView.saveTipoProducto(entityTipo);

				}

			}

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",
					"El catalogo de Tipo Producto ha sido importado con éxito. Registros importados: (" + count + ")"));

			rs = null;
			statement.close();
			statement = null;
			conn.close();
			conn = null;
			count = 0;
			entityTipo = null;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					;
				}
				rs = null;
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					;
				}
				statement = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					;
				}
				conn = null;
			}
		}

	}

	public void cargarProductoErp() throws SQLException, Exception {

		String metodo = "producto";
		Connection conn = null;
		Statement statement = null; // Or PreparedStatement if needed
		ResultSet rs = null;
		List<Producto> producto = null;
		TipoProducto tp = null;
		List<TipoProducto> listTp = null;
		UdadMed um = null;
		List<UdadMed> listUm = null;
		Almacen almacen = null;
		List<Almacen> listAlmacen = null;
		int count = 0;

		try {

			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/postgres");

			conn = ds.getConnection();
			statement = conn.createStatement();
			String sql = "select * from integra_agroview.vw_agvw_producto";
			rs = statement.executeQuery(sql);

			Date date = new Date();

			while (rs.next()) {

				++count;

				entityProducto = null;
				Date fmodificAW = null;
				Date fcreacionAW = null;

				String codigo = rs.getString("CODIGO").trim();
				String nombre = rs.getString("NOMBRE").trim();
				Long compania = rs.getLong("COMPANIA");
				String tiposProd_id = rs.getString("TIPO_PROD_ID").trim();
				String udad_med_prod = rs.getString("UDAD_MED_PROD").trim();
				String flujo_moviento = rs.getString("FLUJO_MOVIMIENTO");
				String es_granel = rs.getString("ES_GRANEL").trim();
				String alamcen_id = rs.getString("ALMACEN_ID").trim();
				String estado = rs.getString("ESTADO");
				Date fmodific = rs.getTimestamp("FECHA_MODIFICACION");
				Date fcrea = rs.getTimestamp("FECHA_CREACION");

				Object[] condicion = { "codigo", true, codigo, "=" };
				producto = businessDelegatorView.findByCriteriaInProducto(condicion, null, null);

				Object[] condicionTp = { "codigo", true, tiposProd_id, "=" };
				listTp = businessDelegatorView.findByCriteriaInTipoProducto(condicionTp, null, null);

				Object[] condicionUm = { "codigo", true, udad_med_prod, "=" };
				listUm = businessDelegatorView.findByCriteriaInUdadMed(condicionUm, null, null);

				Object[] condicionAlamcen = { "codigo", true, alamcen_id, "=" };
				listAlmacen = businessDelegatorView.findByCriteriaInAlmacen(condicionAlamcen, null, null);

				if (producto != null && producto.size() > 0) {
					if (producto.get(0).getFechaModificacion() != null && fmodific != null) {

						fmodificAW = producto.get(0).getFechaModificacion();
						if (fmodific.getTime() > fmodificAW.getTime()) {

							entityProducto = producto.get(0);

							tp = new TipoProducto();
							tp = listTp.get(0);

							um = new UdadMed();
							um = listUm.get(0);

							almacen = new Almacen();
							almacen = listAlmacen.get(0);

							entityProducto.setCodigo(codigo);
							entityProducto.setNombre(nombre);
							entityProducto.setCompania(compania);
							entityProducto.setTipoProducto(tp);
							entityProducto.setEstado(estado);
							entityProducto.setFechaModificacion(date);
							entityProducto.setUdadMedByUdadMedProd(um);
							entityProducto.setFlujoMovimiento(flujo_moviento);
							entityProducto.setEsGranel(es_granel);
							entityProducto.setAlmacen(almacen);
							entityProducto.setFechaModificacion(fmodific);

							businessDelegatorView.updateProducto(entityProducto);
						}

					} else {

						if (producto.get(0).getFechaCreacion() != null && fmodific != null) {
							fcreacionAW = producto.get(0).getFechaCreacion();
							if (fmodific.getTime() > fcreacionAW.getTime()) {

								tp = new TipoProducto();
								tp = listTp.get(0);

								um = new UdadMed();
								um = listUm.get(0);

								almacen = new Almacen();
								almacen = listAlmacen.get(0);

								entityProducto.setCodigo(codigo);
								entityProducto.setNombre(nombre);
								entityProducto.setCompania(compania);
								entityProducto.setTipoProducto(tp);
								entityProducto.setEstado(estado);
								entityProducto.setFechaModificacion(date);
								entityProducto.setUdadMedByUdadMedProd(um);
								entityProducto.setFlujoMovimiento(flujo_moviento);
								entityProducto.setEsGranel(es_granel);
								entityProducto.setAlmacen(almacen);
								entityProducto.setFechaModificacion(fmodific);

								businessDelegatorView.updateProducto(entityProducto);

							}
						}
					}

				} else {

					if (listTp != null && listTp.size() > 0) {

						if (listUm != null && listUm.size() > 0) {

							if (listAlmacen != null && listAlmacen.size() > 0) {

								entityProducto = new Producto();

								tp = new TipoProducto();
								tp = listTp.get(0);

								um = new UdadMed();
								um = listUm.get(0);

								almacen = new Almacen();
								almacen = listAlmacen.get(0);

								entityProducto.setCodigo(codigo);
								entityProducto.setNombre(nombre);
								entityProducto.setCompania(compania);
								entityProducto.setTipoProducto(tp);
								entityProducto.setEstado(estado);
								entityProducto.setFechaCreacion(date);
								entityProducto.setUdadMedByUdadMedProd(um);
								entityProducto.setFlujoMovimiento(flujo_moviento);
								entityProducto.setAlmacen(almacen);
								entityProducto.setFechaCreacion(fcrea);

								businessDelegatorView.saveProducto(entityProducto);

							} else {

								FacesContext.getCurrentInstance().addMessage(null,
										new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al Crear Producto",
												"El código del Almacen (" + alamcen_id
														+ ") no existe en AgroView, para el producto (" + codigo + "-"
														+ nombre + ")"));
							}

						} else {

							FacesContext.getCurrentInstance().addMessage(null,
									new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al Crear Producto",
											"La Unidad de Medida (" + udad_med_prod
													+ ") no existe en AgroView, para el producto (" + codigo + "-"
													+ nombre + ")"));

						}

					} else {

						FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al Crear Producto",
										"El código del tipo de producto (" + tiposProd_id
												+ ") no existe en AgroView, para el producto (" + codigo + "-" + nombre
												+ ")"));

					}

				}

				tp = null;
				um = null;
				almacen = null;
				listUm = null;
				listAlmacen = null;
				listTp = null;

			}

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",
					"El catalogo de Productos ha sido importado con éxito. Registros importados: (" + count + ")"));

			rs = null;
			statement.close();
			statement = null;
			conn.close();
			conn = null;
			count = 0;
			entityProducto = null;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					;
				}
				rs = null;
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					;
				}
				statement = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					;
				}
				conn = null;
			}
		}

	}

	public void cargarEmpresasErp() throws SQLException, Exception {

		String metodo = "empresas";
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		List<PersEmpr> pe = null;
		Ciudad ciudad = null;
		List<Ciudad> listCiudad = null;

		int count = 0;

		try {

			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/postgres");

			conn = ds.getConnection();
			statement = conn.createStatement();
			String sql = "select * from integra_agroview.vw_agvw_empresa";
			rs = statement.executeQuery(sql);

			Date date = new Date();

			while (rs.next()) {

				++count;

				entityPer = null;
				Date fmodificAW = null;
				Date fcreacionAW = null;

				String estado = rs.getString("ESTADO");
				String codigo = rs.getString("CODIGO").trim();
				String nombre = rs.getString("NOMBRE").trim();
				Long compania = rs.getLong("COMPANIA");

				String tipoIdentificacion = rs.getString("TIPO_IDENTIFICACION").trim();
				String tipoPersona = rs.getString("TIPO_PERSONA").trim();
				String identificiacion = rs.getString("IDENTIFICACION").trim();
				String representanteLegal = rs.getString("REPRESENTANTE_LEGAL").trim(); //
				String estadoCivil = rs.getString("ESTADO_CIVIL").trim();
				String email = rs.getString("EMAIL").trim();
				String sitioWeb = rs.getString("SITIO_WEB").trim();
				String direccion = rs.getString("DIRECCION").trim();
				String tipoEmpresa = rs.getString("TIPO_EMPRESA").trim();
				String ciudad_id = rs.getString("CIUDAD_ID").trim();

				Date fmodific = rs.getTimestamp("FECHA_MODIFICACION");
				Date fcrea = rs.getTimestamp("FECHA_CREACION");

				Object[] condicion = { "codigo", true, codigo, "=" };
				pe = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);

				Object[] condicionCiudad = { "codigo", true, ciudad_id, "=" };
				listCiudad = businessDelegatorView.findByCriteriaInCiudad(condicionCiudad, null, null);

				if (pe != null && pe.size() > 0) {
					if (pe.get(0).getFechaModificacion() != null && fmodific != null) {
						fmodificAW = pe.get(0).getFechaModificacion();
						if (fmodific.getTime() > fmodificAW.getTime()) {

							entityPer = pe.get(0);

							ciudad = new Ciudad();
							if (listCiudad != null && listCiudad.size() > 0) {
								ciudad = listCiudad.get(0);
								entityPer.setCiudad(ciudad.getCiudadId());
							}

							entityPer.setCodigo(codigo);
							entityPer.setNombre(nombre);
							entityPer.setCompania(compania);
							entityPer.setEstado(estado);
							entityPer.setFechaModificacion(fmodific);
							entityPer.setTipoIdentificacion(tipoIdentificacion);
							entityPer.setTipoPersona(tipoPersona);
							entityPer.setIdentificacion(identificiacion);
							entityPer.setRepresentanteLegal(representanteLegal);
							entityPer.setEstadoCivil(estadoCivil);
							entityPer.setEmail(email);
							entityPer.setSitioWeb(sitioWeb);
							entityPer.setDireccion(direccion);
							entityPer.setTipoEmpresa(tipoEmpresa);
							businessDelegatorView.updatePersEmpr(entityPer, null);

						}
					} else {

						if (pe.get(0).getFechaCreacion() != null && fmodific != null) {
							fcreacionAW = pe.get(0).getFechaCreacion();
							if (fmodific.getTime() > fcreacionAW.getTime()) {

								entityPer = pe.get(0);

								ciudad = new Ciudad();
								if (listCiudad != null && listCiudad.size() > 0) {
									ciudad = listCiudad.get(0);
									entityPer.setCiudad(ciudad.getCiudadId());
								}

								entityPer.setCodigo(codigo);
								entityPer.setNombre(nombre);
								entityPer.setCompania(compania);
								entityPer.setEstado(estado);
								entityPer.setFechaModificacion(fmodific);
								entityPer.setTipoIdentificacion(tipoIdentificacion);
								entityPer.setTipoPersona(tipoPersona);
								entityPer.setIdentificacion(identificiacion);
								entityPer.setRepresentanteLegal(representanteLegal);
								entityPer.setEstadoCivil(estadoCivil);
								entityPer.setEmail(email);
								entityPer.setSitioWeb(sitioWeb);
								entityPer.setDireccion(direccion);
								entityPer.setTipoEmpresa(tipoEmpresa);
								businessDelegatorView.updatePersEmpr(entityPer, null);
							}

						}

					}

				} else {

					entityPer = new PersEmpr();

					ciudad = new Ciudad();
					if (listCiudad != null && listCiudad.size() > 0) {
						ciudad = listCiudad.get(0);
						entityPer.setCiudad(ciudad.getCiudadId());
					}

					entityPer.setCodigo(codigo);
					entityPer.setNombre(nombre);
					entityPer.setCompania(compania);
					entityPer.setEstado(estado);
					entityPer.setFechaCreacion(fcrea);

					entityPer.setTipoIdentificacion(tipoIdentificacion);
					entityPer.setTipoPersona(tipoPersona);
					entityPer.setIdentificacion(identificiacion);
					entityPer.setRepresentanteLegal(representanteLegal);
					entityPer.setEstadoCivil(estadoCivil);
					entityPer.setEmail(email);
					entityPer.setSitioWeb(sitioWeb);
					entityPer.setDireccion(direccion);
					entityPer.setTipoEmpresa(tipoEmpresa);

					businessDelegatorView.savePersEmpr(entityPer, null);

				}

			}

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",
					"El catalogo de Empresas ha sido importado con éxito. Registros importados: (" + count + ")"));

			rs = null;
			statement.close();
			statement = null;
			conn.close();
			conn = null;
			count = 0;
			entityPer = null;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					;
				}
				rs = null;
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					;
				}
				statement = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					;
				}
				conn = null;
			}
		}

	}

	public void cargarCentroCostoErp() throws SQLException, Exception {

		String metodo = "centroConsto";
		Connection conn = null;
		Statement statement = null; // Or PreparedStatement if needed
		ResultSet rs = null;
		List<CentCost> cc = null;

		int count = 0;

		try {

			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/postgres");

			conn = ds.getConnection();
			statement = conn.createStatement();
			String sql = "select * from integra_agroview.vw_agvw_cent_cost ";
			rs = statement.executeQuery(sql);

			Date date = new Date();

			while (rs.next()) {

				++count;

				entityCenCost = null;
				Date fmodificAW = null;
				Date fcreacionAW = null;

				String codigo = rs.getString("CODIGO").trim();
				String nombre = rs.getString("NOMBRE").trim();
				Long compania = rs.getLong("COMPANIA");
				String tipo_centro_consto = rs.getString("TIPO_CENTRO_COSTO");
				String estado = rs.getString("ESTADO");
				Date fmodific = rs.getTimestamp("FECHA_MODIFICACION");
				Date fcrea = rs.getTimestamp("FECHA_CREACION");

				Object[] condicion = { "codigo", true, codigo, "=" };

				cc = businessDelegatorView.findByCriteriaInCentCost(condicion, null, null);

				if (cc != null && cc.size() > 0) {
					if (cc.get(0).getFechaModificacion() != null && fmodific != null) {

						fmodificAW = cc.get(0).getFechaModificacion();
						if (fmodific.getTime() > fmodificAW.getTime()) {

							entityCenCost = cc.get(0);

							entityCenCost.setCodigo(codigo);
							entityCenCost.setNombre(nombre);
							entityCenCost.setCompania(compania);
							entityCenCost.setTipoCentroCosto(tipo_centro_consto);
							entityCenCost.setEstado(estado);
							entityCenCost.setFechaModificacion(fmodific);

							businessDelegatorView.updateCentCost(entityCenCost);
						}

					} else {

						if (cc.get(0).getFechaCreacion() != null && fmodific != null) {
							fcreacionAW = cc.get(0).getFechaCreacion();
							if (fmodific.getTime() > fcreacionAW.getTime()) {
								entityCenCost = cc.get(0);

								entityCenCost.setCodigo(codigo);
								entityCenCost.setNombre(nombre);
								entityCenCost.setCompania(compania);
								entityCenCost.setTipoCentroCosto(tipo_centro_consto);
								entityCenCost.setEstado(estado);
								entityCenCost.setFechaModificacion(fmodific);

								businessDelegatorView.updateCentCost(entityCenCost);

							}
						}
					}

				} else {

					entityCenCost = new CentCost();

					entityCenCost.setCodigo(codigo);
					entityCenCost.setNombre(nombre);
					entityCenCost.setCompania(compania);
					entityCenCost.setEstado(estado);
					entityCenCost.setFechaCreacion(fcrea);
					entityCenCost.setTipoCentroCosto(tipo_centro_consto);

					businessDelegatorView.saveCentCost(entityCenCost);

				}

			}

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "",
							"El catalogo de Centro de Costos ha sido importado con éxito. Registros importados: ("
									+ count + ")"));

			rs = null;
			statement.close();
			statement = null;
			conn.close();
			conn = null;
			count = 0;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					;
				}
				rs = null;
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					;
				}
				statement = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					;
				}
				conn = null;
			}
		}

	}

	public void cargarProfesionesErp() {

		Connection conn = null;
		Statement statement = null; // Or PreparedStatement if needed
		ResultSet rs = null;
		List<Profesion> p = null;

		int count = 0;

		try {

			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/postgres");

			conn = ds.getConnection();
			statement = conn.createStatement();
			String sql = "select * from integra_agroview.vw_agvw_profesion";
			rs = statement.executeQuery(sql);

			Date date = new Date();

			while (rs.next()) {

				++count;

				entityProf = null;

				// importandoTxt += "importado: " + "Profesiones( " + count + "
				// ) " + "";

				String codigo = rs.getString("CODIGO").trim();
				String nombre = rs.getString("NOMBRE").trim();
				Long compania = rs.getLong("COMPANIA");
				String funciones = rs.getString("FUNCIONES");
				String estado = rs.getString("ESTADO");
				Date fmodific = rs.getTimestamp("FECHA_MODIFICACION");
				Date fcrea = rs.getTimestamp("FECHA_CREACION");

				Object[] condicion = { "codigo", true, codigo, "=" };

				p = businessDelegatorView.findByCriteriaInProfesion(condicion, null, null);

				if (p != null && p.size() > 0) {

					if (p.get(0).getFechaModificacion() != null) {

						Date fmodificAW = p.get(0).getFechaModificacion();

						if (fmodific.getTime() > fmodificAW.getTime()) {

							entityProf = new Profesion();
							entityProf = p.get(0);

							entityProf.setCodigo(codigo);
							entityProf.setNombre(nombre);
							entityProf.setCompania(compania);
							entityProf.setFunciones(funciones);
							entityProf.setEstado(estado);
							entityProf.setFechaModificacion(fmodific);

							businessDelegatorView.updateProfesion(entityProf);
						}
					} else {

						entityProf = new Profesion();
						entityProf = p.get(0);

						entityProf.setCodigo(codigo);
						entityProf.setNombre(nombre);
						entityProf.setCompania(compania);
						entityProf.setFunciones(funciones);
						entityProf.setEstado(estado);
						entityProf.setFechaModificacion(fmodific);

						businessDelegatorView.updateProfesion(entityProf);

					}

				} else {

					entityProf = new Profesion();

					entityProf.setCodigo(codigo);
					entityProf.setNombre(nombre);
					entityProf.setCompania(compania);
					entityProf.setEstado(estado);
					entityProf.setFechaCreacion(fcrea);
					entityProf.setFunciones(funciones);

					businessDelegatorView.saveCentCost(entityCenCost);

				}

			}

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",
					"El catalogo de Cargos ha sido importado con éxito. Registros importados: (" + count + ")"));

			rs = null;
			statement.close();
			statement = null;
			conn.close();
			conn = null;
			count = 0;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					;
				}
				rs = null;
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					;
				}
				statement = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					;
				}
				conn = null;
			}
		}

	}

	public void cargarTrabajadorErp() {

		Connection conn = null;
		Statement statement = null; // Or PreparedStatement if needed
		ResultSet rs = null;
		List<Trabajador> trabajador = null;
		List<PersEmpr> pr = null;
		List<Profesion> prof = null;
		List<Ciudad> listCiudad = null;
		List<Profesion> p = null;
		List<CentCost> centrocosto = null;

		int count = 0;

		try {

			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/postgres");

			conn = ds.getConnection();
			statement = conn.createStatement();
			String sql = "select * from integra_agroview.vw_agvw_trabajador";
			rs = statement.executeQuery(sql);

			Date date = new Date();

			while (rs.next()) {

				++count;

				entityTrab = null;

				// importandoTxt += "importado: " + "Trabajador( " + count + " )
				// " + "";

				String codigo = rs.getString("CODIGO").trim();
				String nombre = rs.getString("NOMBRE").trim();
				String primer_nombre = rs.getString("PRIMER_NOMBRE").trim();
				String segundo_nombre = rs.getString("SEGUNDO_NOMBRE").trim();
				String primer_apellido = rs.getString("PRIMER_APELLIDO").trim();
				String segundo_apellido = rs.getString("SEGUNDO_APELLIDO").trim(); //

				String identificacion = rs.getString("N_IDENTIFICACION").trim();
				Long centro_costo_id = rs.getLong("CENT_COST_ID"); //
				String genero = rs.getString("GENERO").trim(); //
				Date fecha_naciemiento = rs.getDate("FECHA_NACIMIENTO"); //
				Date fecha_admision = rs.getDate("FECHA_ADMISION"); //

				Long contratistaId = rs.getLong("CONTRATISTA_ID"); //
				Long prof_id = rs.getLong("PROF_ID");
				String telefono = rs.getString("TELEFONO").trim(); //
				String email = rs.getString("EMAIL").trim(); //

				String estadoCivil = rs.getString("ESTADO_CIVIL").trim(); //
				String direccion = rs.getString("DIRECCION").trim();
				Long ciudad_id = rs.getLong("CIUDAD_ID"); //
				String clase_contrato = rs.getString("CLASE_CONTRATO").trim();

				Long compania = rs.getLong("COMPANIA");
				String estado = rs.getString("ESTADO");

				Date fmodific = rs.getTimestamp("FECHA_MODIFICACION");
				Date fcrea = rs.getTimestamp("FECHA_CREACION");

				Object[] condicion = { "codigo", true, codigo, "=" };

				trabajador = businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null);

				Object[] condicionEmpresas = { "codigo", true, contratistaId, "=" };

				pr = businessDelegatorView.findByCriteriaInPersEmpr(condicionEmpresas, null, null);

				Object[] condicionCiudad = { "codigo", true, ciudad_id, "=" };

				listCiudad = businessDelegatorView.findByCriteriaInCiudad(condicionCiudad, null, null);

				Object[] condicionProfesion = { "codigo", true, prof_id, "=" };

				p = businessDelegatorView.findByCriteriaInProfesion(condicionProfesion, null, null);

				Object[] condicionCC = { "codigo", true, centro_costo_id, "=" };

				centrocosto = businessDelegatorView.findByCriteriaInCentCost(condicionCC, null, null);

				if (trabajador != null && trabajador.size() > 0) {

					if (trabajador.get(0).getFechaModificacion() != null) {

						Date fmodificAW = trabajador.get(0).getFechaModificacion();

						if (fmodific.getTime() > fmodificAW.getTime()) {

							entityTrab = new Trabajador();
							entityTrab = trabajador.get(0);

							PersEmpr empresa = new PersEmpr();
							empresa = pr.get(0);

							Profesion profesion = new Profesion();
							profesion = p.get(0);

							CentCost ccost = new CentCost();
							ccost = centrocosto.get(0);

							entityTrab.setEstado(estado);
							entityTrab.setCodigo(codigo);
							entityTrab.setPrimerNombre(primer_nombre);
							entityTrab.setSegundoNombre(segundo_nombre);
							entityTrab.setPrimerApellido(primer_apellido);
							entityTrab.setSegundoApellido(segundo_apellido);
							entityTrab.setNombre(nombre);
							entityTrab.setnIdentificacion(identificacion);
							entityTrab.setCentCost(ccost);
							entityTrab.setGenero(genero);
							entityTrab.setFechaNacimiento(fecha_naciemiento);
							entityTrab.setFechaAdmision(fecha_admision);

							entityTrab.setContratista(empresa);
							entityTrab.setProfesion(profesion);
							entityTrab.setCiudad(listCiudad.get(0).getCiudadId());

							entityTrab.setTelefono(telefono);
							entityTrab.setEmail(email);

							entityTrab.setEstadoCivil(estadoCivil);
							entityTrab.setDireccion(direccion);
							entityTrab.setEmail(email);
							entityTrab.setClaseContrato(clase_contrato);

							entityTrab.setCompania(compania);
							entityTrab.setEstado(estado);
							entityTrab.setFechaModificacion(fmodific);

							businessDelegatorView.updateTrabajador(entityTrab, null, null);

						}
					} else {

						entityTrab = new Trabajador();
						entityTrab = trabajador.get(0);

						PersEmpr empresa = new PersEmpr();
						empresa = pr.get(0);

						Profesion profesion = new Profesion();
						profesion = p.get(0);

						CentCost ccost = new CentCost();
						ccost = centrocosto.get(0);

						entityTrab.setEstado(estado);
						entityTrab.setCodigo(codigo);
						entityTrab.setPrimerNombre(primer_nombre);
						entityTrab.setSegundoNombre(segundo_nombre);
						entityTrab.setPrimerApellido(primer_apellido);
						entityTrab.setSegundoApellido(segundo_apellido);
						entityTrab.setNombre(nombre);
						entityTrab.setnIdentificacion(identificacion);
						entityTrab.setCentCost(ccost);
						entityTrab.setGenero(genero);
						entityTrab.setFechaNacimiento(fecha_naciemiento);
						entityTrab.setFechaAdmision(fecha_admision);

						entityTrab.setContratista(empresa);
						entityTrab.setProfesion(profesion);
						entityTrab.setCiudad(listCiudad.get(0).getCiudadId());

						entityTrab.setTelefono(telefono);
						entityTrab.setEmail(email);

						entityTrab.setEstadoCivil(estadoCivil);
						entityTrab.setDireccion(direccion);
						entityTrab.setEmail(email);
						entityTrab.setClaseContrato(clase_contrato);

						entityTrab.setCompania(compania);
						entityTrab.setEstado(estado);
						entityTrab.setFechaModificacion(fmodific);

						businessDelegatorView.updateTrabajador(entityTrab, null, null);

					}

				} else {

					entityTrab = new Trabajador();

					PersEmpr empresa = new PersEmpr();
					empresa = pr.get(0);

					Profesion profesion = new Profesion();
					profesion = p.get(0);

					CentCost ccost = new CentCost();
					ccost = centrocosto.get(0);

					entityTrab.setEstado(estado);
					entityTrab.setCodigo(codigo);
					entityTrab.setPrimerNombre(primer_nombre);
					entityTrab.setSegundoNombre(segundo_nombre);
					entityTrab.setPrimerApellido(primer_apellido);
					entityTrab.setSegundoApellido(segundo_apellido);
					entityTrab.setNombre(nombre);
					entityTrab.setnIdentificacion(identificacion);
					entityTrab.setCentCost(ccost);
					entityTrab.setGenero(genero);
					entityTrab.setFechaNacimiento(fecha_naciemiento);
					entityTrab.setFechaAdmision(fecha_admision);

					entityTrab.setContratista(empresa);
					entityTrab.setProfesion(profesion);
					entityTrab.setCiudad(listCiudad.get(0).getCiudadId());

					entityTrab.setTelefono(telefono);
					entityTrab.setEmail(email);

					entityTrab.setEstadoCivil(estadoCivil);
					entityTrab.setDireccion(direccion);
					entityTrab.setEmail(email);
					entityTrab.setClaseContrato(clase_contrato);

					entityTrab.setCompania(compania);
					entityTrab.setEstado(estado);
					entityTrab.setFechaCreacion(fcrea);

					businessDelegatorView.saveTrabajador(entityTrab, null, null);

				}

				pr = null;
				prof = null;
				centrocosto = null;
				p = null;

			}

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "",
							"El catalogo de Trabajadores se han sido importado con éxito. Registros importados: ("
									+ count + ")"));

			statement.close();
			statement = null;
			conn.close();
			conn = null;
			count = 0;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					;
				}
				rs = null;
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					;
				}
				statement = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					;
				}
				conn = null;
			}
		}

	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public CommandButton getBtnImportar() {
		return btnImportar;
	}

	public void setBtnImportar(CommandButton btnImportar) {
		this.btnImportar = btnImportar;
	}

	public CommandButton getBtnGenerarInterface() {
		return btnGenerarInterface;
	}

	public void setBtnGenerarInterface(CommandButton btnGenerarInterface) {
		this.btnGenerarInterface = btnGenerarInterface;
	}

	public String getImportandoTxt() {
		return importandoTxt;
	}

	public void setImportandoTxt(String importandoTxt) {
		this.importandoTxt = importandoTxt;
	}

	public InputTextarea getLogImport() {
		return logImport;
	}

	public void setLogImport(InputTextarea logImport) {
		this.logImport = logImport;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
