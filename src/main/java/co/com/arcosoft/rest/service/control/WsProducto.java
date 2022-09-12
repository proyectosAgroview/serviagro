package co.com.arcosoft.rest.service.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.control.IProductoLogic;
import co.com.arcosoft.modelo.informes.dto.ConsultaStockMaquinariaDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.presentation.businessDelegate2.IBusinessDelegator2View;
import co.com.arcosoft.rest.service.dto.ProductoDTO;
import co.com.arcosoft.utilities.DriverManagerDataSourceUtils;

@Controller
@RequestMapping("/catalogos")
public class WsProducto {

	private static final Logger logger = LoggerFactory.getLogger(WsProducto.class);

	@Autowired
	IProductoLogic productologic;


	@Autowired
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	
	@Autowired
	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	@RequestMapping(value = "/listarProductos", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<ProductoDTO>> listarProductos() throws Exception {

		List<Producto> a = new ArrayList<Producto>();
		List<ProductoDTO> ma = new ArrayList<ProductoDTO>();
		List<ConsultaStockMaquinariaDTO> listaProductos = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaFinalDateRegistro =null;
		Date fechaOriginal = foriginal.parse("1970-01-01");
		String fsalida = sdf.format(fechaOriginal);
		fechaFinalDateRegistro = sdf.parse(fsalida);
	
		GregorianCalendar calendar = new GregorianCalendar();
		Date date = new Date();
			
		calendar.setTime(date); // Configuramos la fecha que se
											// recibe
		calendar.add(GregorianCalendar.DAY_OF_YEAR, 365); 
		
		//a = productologic.getProducto();
		listaProductos = businessDelegator2View.pr_inventario_saldo_producto_movil(1L, fechaFinalDateRegistro,
				calendar.getTime(),  "0",1l, "0",1l) ;
		
		if (listaProductos != null && listaProductos.size() > 0) {

			for (ConsultaStockMaquinariaDTO mProcuto : listaProductos) {

					ProductoDTO tmp = new ProductoDTO();
					tmp.setProductoId(mProcuto.getIdProducto().longValue());
					tmp.setCodigo(mProcuto.getCodProducto());

					Double saldo = 0.0;
					if (mProcuto.getAlmacen() != null) {
						tmp.setAlmacen(mProcuto.getIdAlmacen().longValue());
						tmp.setSaldo(mProcuto.getCantidadDisponible().doubleValue());
						tmp.setCompania(1L);
						
						if (mProcuto.getIdUdadMed() != null ) {
							tmp.setUdadMedByUdadMedProd(mProcuto.getIdUdadMed().longValue());
							tmp.setNombre(mProcuto.getCodProducto() + "--" + mProcuto.getNomProducto() + " ("
									+ mProcuto.getNombreUdadMed() + ")");
						} else {
							tmp.setNombre(mProcuto.getCodProducto() + "--" + mProcuto.getNomProducto());

						}

						ma.add(tmp);

					}

				
			}

			return new ResponseEntity<List<ProductoDTO>>(ma, HttpStatus.OK);

		} else {

			return new ResponseEntity<List<ProductoDTO>>(HttpStatus.NO_CONTENT);
		}

	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}
	
	

}
