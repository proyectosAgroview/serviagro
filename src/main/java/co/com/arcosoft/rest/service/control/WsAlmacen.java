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

import co.com.arcosoft.modelo.Almacen;
import co.com.arcosoft.modelo.control.IAlmacenLogic;
import co.com.arcosoft.presentation.businessDelegate2.IBusinessDelegator2View;
import co.com.arcosoft.rest.service.dto.AlmacenDTO;

@Controller
@RequestMapping("/catalogos")
public class WsAlmacen {

	private static final Logger logger = LoggerFactory.getLogger(WsAlmacen.class);

	@Autowired
	IAlmacenLogic almacenlogic;

	@Autowired
	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	
	@RequestMapping(value = "/listarAlmacen", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<AlmacenDTO>> listarAlmacenes() throws Exception {

		List<Almacen> a = new ArrayList<Almacen>();
		List<AlmacenDTO> ma = new ArrayList<AlmacenDTO>();

		a = almacenlogic.getAlmacen();

		if (a != null && a.size() > 0) {

			for (Almacen mAlmacen : a) {

				if (mAlmacen.getEstado().equals("A")) {

					AlmacenDTO tmp = new AlmacenDTO();
					tmp.setAlmacenId(mAlmacen.getAlmacenId());
					if(mAlmacen.getAlmacenId()<=5l) {
						Double saldo = businessDelegator2View.pr_saldo_prom_producto(1L, mAlmacen.getAlmacenId(), mAlmacen.getCompania());
						tmp.setCodigo(mAlmacen.getCodigo() +" Saldo: "+ saldo );
					}else {
						tmp.setCodigo(mAlmacen.getCodigo() +" -- "+mAlmacen.getNombre() );
					}
					
					tmp.setNombre(mAlmacen.getNombre() );
					ma.add(tmp);
				}

			}

			return new ResponseEntity<List<AlmacenDTO>>(ma, HttpStatus.OK);

		} else {

			return new ResponseEntity<List<AlmacenDTO>>(HttpStatus.NO_CONTENT);
		}

	}

}
