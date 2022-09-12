package co.com.arcosoft.rest.service.control;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedProperty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.arcosoft.modelo.CategoriaEquipo;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.TipoProducto;
import co.com.arcosoft.modelo.control.IProductoLogic;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.rest.service.dto.ProductoDTO;

@Controller
@RequestMapping("/catalogos")
public class WsProductoCombustible {

	private static final Logger logger = LoggerFactory.getLogger(WsProductoCombustible.class);

	@Autowired
	IProductoLogic productologic;
	
	@Autowired
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	

	@RequestMapping(value = "/listarProductosCombustible", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<ProductoDTO>> listarProductos() throws Exception {

		List<Producto> a = new ArrayList<Producto>();
		List<ProductoDTO> ma = new ArrayList<ProductoDTO>();

		a = productologic.getProducto();

		if (a != null && a.size() > 0) {

			for (Producto mProcuto : a) {
				
				Long tipoProductoId =  mProcuto.getTipoProducto().getTipoProdId();
				TipoProducto tipProd = businessDelegatorView.getTipoProducto(tipoProductoId);
				String funcion =tipProd.getClaseProducto();
				 
				
				if(funcion!=null) {
					if (mProcuto.getEstado().equals("A") && funcion.equals("Combustibles") ) {
	
						ProductoDTO tmp = new ProductoDTO();
						tmp.setProductoId(mProcuto.getProductoId());
						tmp.setCodigo(mProcuto.getCodigo());
						tmp.setNombre(mProcuto.getNombre());
						tmp.setUdadMedByUdadMedProd(mProcuto.getUdadMedByUdadMedProd().getUdadMedId());
					
						ma.add(tmp);
					}
				}

			}

			return new ResponseEntity<List<ProductoDTO>>(ma, HttpStatus.OK);

		} else {

			return new ResponseEntity<List<ProductoDTO>>(HttpStatus.NO_CONTENT);
		}

		
		
	}


	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}


	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

}
