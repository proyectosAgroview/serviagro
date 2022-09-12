package co.com.arcosoft.rest.service.control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.arcosoft.modelo.CentCost;
import co.com.arcosoft.modelo.control.ICentCostLogic;
import co.com.arcosoft.rest.service.dto.CcostoDTO;

@Controller
@RequestMapping("/catalogos")
public class WsCentroCosto {

	private static final Logger logger = LoggerFactory.getLogger(WsCentroCosto.class);

	@Autowired
	ICentCostLogic centcostlogic;

	// @Resource(name = "jdbc/postgres")
	// private DataSource ds;

	private CentCost entity;

	@RequestMapping(value = "/ErpObtenerCcosto", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<CcostoDTO> ErpObtenerCcosto() throws NamingException {

		Connection conn = null;
		Statement statement = null; // Or PreparedStatement if needed
		ResultSet rs = null;
		List<CcostoDTO> ccosto = null;

		try {

			/*
			 * Context initContext = new InitialContext(); Context envContext =
			 * (Context) initContext.lookup("java:/comp/env"); DataSource ds =
			 * (DataSource) envContext.lookup("jdbc/postgres");
			 * 
			 * conn = ds.getConnection();
			 * 
			 * statement = conn.createStatement();
			 * 
			 * String sql = "select * from ccosto";
			 * 
			 * rs = statement.executeQuery(sql);
			 * 
			 * ccosto = new ArrayList<CcostoDTO>();
			 * 
			 * while (rs.next()) {
			 * 
			 * CcostoDTO tmp = new CcostoDTO();
			 * 
			 * Long id = rs.getLong("ID"); String codigo =
			 * rs.getString("CODIGO"); String nombre = rs.getString("NOMBRE");
			 * 
			 * tmp.setId(id); tmp.setCodigo(codigo); tmp.setNombre(nombre);
			 * ccosto.add(tmp);
			 * 
			 * 
			 * }
			 */

			/*
			 * if(ccosto != null && ccosto.size()>0) {
			 * 
			 * List<CentCost> tmp = centcostlogic.getCentCost();
			 * 
			 * for (CcostoDTO ccostoDTO : ccosto) {
			 * 
			 * for (CentCost centCost : tmp) {
			 * 
			 * if(centCost.getCodigo().equals(ccostoDTO.getCodigo().toString()))
			 * {
			 * 
			 * Long compania =1L; entity.setCompania(compania);
			 * entity.setEstado("A");
			 * entity.setCodigo(ccostoDTO.getCodigo().toString());
			 * entity.setNombre(ccostoDTO.getNombre().toString());
			 * 
			 * centcostlogic.updateCentCost(entity);
			 * 
			 * System.out.
			 * println("Actualizando centro de costos en AgroView....");
			 * 
			 * }else{
			 * 
			 * entity = new CentCost();
			 * 
			 * Long compania =1L; entity.setEstado("A");
			 * entity.setCompania(compania);
			 * entity.setCodigo(ccostoDTO.getCodigo().toString());
			 * entity.setNombre(ccostoDTO.getNombre().toString());
			 * 
			 * centcostlogic.saveCentCost(entity);
			 * 
			 * System.out.println("Grabando centro de costos en AgroView...");
			 * 
			 * }
			 * 
			 * }
			 * 
			 * 
			 * }
			 * 
			 * }
			 */

			rs = null;
			statement.close();
			statement = null;
			conn.close();
			conn = null;

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

		return ccosto;

	}

}
