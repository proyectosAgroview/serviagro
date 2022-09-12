package co.com.arcosoft.rest.service.control;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.control.IPersEmprLogic;
import co.com.arcosoft.rest.service.dto.ClientesDTO;



@Controller
@RequestMapping("/catalogos")
public class WsClientes {

	private static final Logger logger = LoggerFactory.getLogger(WsClientes.class);

	@Autowired
	IPersEmprLogic  persEmprlogic;

	@RequestMapping(value = "/listarClientes", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<ClientesDTO>> listarClientes() throws Exception {

		List<PersEmpr> a = new ArrayList<PersEmpr>();
		List<ClientesDTO> ma = new ArrayList<ClientesDTO>();

		a = persEmprlogic.getPersEmpr();

		if (a != null && a.size() > 0) {

			for (PersEmpr mPersEmpr : a) {

				if (mPersEmpr.getEstado().equals("A") && 
						!mPersEmpr.getTipoEmpresa().equals("2") &&
						!mPersEmpr.getTipoEmpresa().equals("3") &&
						!mPersEmpr.getTipoEmpresa().equals("5") &&
						!mPersEmpr.getTipoEmpresa().equals("6")) {

					ClientesDTO tmp = new ClientesDTO();
					tmp.setPersEmprId(mPersEmpr.getPersEmprId());
					tmp.setCodigo(mPersEmpr.getCodigo());
					tmp.setNombre(mPersEmpr.getNombre());
					tmp.setCompania(mPersEmpr.getCompania());
					tmp.setTipoEmpresa(mPersEmpr.getTipoEmpresa());
					ma.add(tmp);
				}

			}

			return new ResponseEntity<List<ClientesDTO>>(ma, HttpStatus.OK);

		} else {

			return new ResponseEntity<List<ClientesDTO>>(HttpStatus.NO_CONTENT);
		}

	}

}
