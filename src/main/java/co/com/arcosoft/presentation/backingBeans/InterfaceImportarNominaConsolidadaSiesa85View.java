package co.com.arcosoft.presentation.backingBeans;

import java.io.File;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.spinner.Spinner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.DatNominaTrabajador;
import co.com.arcosoft.modelo.DatNominaTrabajadorDet;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.DatNominaTrabajadorDetDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;

@ManagedBean
@ViewScoped
public class InterfaceImportarNominaConsolidadaSiesa85View implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(InterfaceImportarNominaConsolidadaSiesa85View.class);
	private DatNominaTrabajador entity;
	private List<DatNominaTrabajadorDetDTO> dataNominaTrabajadorDet;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private SelectOneMenu txtMes;
	private Spinner txtAnio;
	private CommandButton btnImportar;
	private CommandButton btnGenerarInterface;

	public void cargarNominaErp() throws Exception {

		try {
			String filename = "C://Arcosoft/ERP/NOMINA_CONSOLIDADA/NOMINA.XML";
			File file = new File(filename);

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(filename);
			// Long compania = new Long(getCompaniaIdSession());
			// Long usuarioId = new Long(getUsuarioIdSession());

			Long compania = new Long(getCompaniaIdSession());
			;
			Long usuarioId = new Long(getUsuarioIdSession());

			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("REGISTRO");

			DatNominaTrabajadorDetDTO datNominaTrabajadorDetDTO = null;
			Trabajador trabajador = null;
			ConceptoNomina cn = null;
			DatNominaTrabajadorDet valor = null;
			List<DatNominaTrabajadorDet> nominaTrabajadordet = null;

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					Object[] condicion = { "codigo", true,
							new String(eElement.getElementsByTagName("FUNC").item(0).getTextContent()), "=" };
					List<Trabajador> listaTrabajador = businessDelegatorView.findByCriteriaInTrabajador(condicion, null,
							null);

					Object[] condicion2 = { "codigo", true,
							new String(eElement.getElementsByTagName("CONCEITOFP").item(0).getTextContent()), "=" };
					List<ConceptoNomina> listaConceptoNomina = businessDelegatorView
							.findByCriteriaInConceptoNomina(condicion2, null, null);

					if ((listaTrabajador != null && listaTrabajador.size() > 0)
							&& (listaConceptoNomina != null && listaConceptoNomina.size() > 0)) {

						// trabajador

						SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
						SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
						SimpleDateFormat formatter3 = new SimpleDateFormat("dd-MM-yyyy");

						String dateIniXml = eElement.getElementsByTagName("DATAI").item(0).getTextContent().toString()
								.trim().toString();
						String dateFinXml = eElement.getElementsByTagName("DATAF").item(0).getTextContent().toString()
								.trim().toString();

						Date dateIni = formatter.parse(dateIniXml);
						Date dateFin = formatter.parse(dateFinXml);

						String formatoFechaIni = formatter2.format(dateIni);
						String formatoFechaFin = formatter2.format(dateFin);

						Date formato1 = formatter2.parse(formatoFechaIni);
						Date formato2 = formatter2.parse(formatoFechaFin);

						GregorianCalendar calendario1 = new GregorianCalendar();
						calendario1.setTime(formato1);

						int diaHoy = calendario1.get(java.util.Calendar.DAY_OF_MONTH);
						int mesHoy = calendario1.get(java.util.Calendar.MONTH);
						int anoHoy = calendario1.get(java.util.Calendar.YEAR);

						calendario1.set(anoHoy, mesHoy, diaHoy);
						java.sql.Date fechaIni = new java.sql.Date(calendario1.getTimeInMillis());

						DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
						String formatoFechaIniFinal = dateFormat.format(fechaIni);
						Date fechaIniFin = dateFormat.parse(formatoFechaIniFinal);
						// String formatoFechaIniFinal =
						// formatter3.format(fechaIni);
						// java.sql.Date fechaIniFin = new
						// java.sql.Date(formatter3.parse(formatoFechaIniFinal).getTime());

						GregorianCalendar calendario2 = new GregorianCalendar();
						calendario2.setTime(formato2);

						int diaHoy2 = calendario2.get(java.util.Calendar.DAY_OF_MONTH);
						int mesHoy2 = calendario2.get(java.util.Calendar.MONTH);
						int anoHoy2 = calendario2.get(java.util.Calendar.YEAR);

						calendario2.set(anoHoy2, mesHoy2, diaHoy2);
						java.sql.Date fechaFIn = new java.sql.Date(calendario2.getTimeInMillis());

						String formatoFechaFinFinal = formatter3.format(fechaFIn);
						java.sql.Date fechaFinFin = new java.sql.Date(formatter3.parse(formatoFechaFinFinal).getTime());

						Object[] condicion3 = { "fechaInicial", true, formatoFechaIni, "=", "fechaFinal", true,
								formatoFechaFin, "=" };

						List<DatNominaTrabajador> datNominaTrabajador = businessDelegatorView
								.findByCriteriaInDatNominaTrabajador(condicion3, null, null);

						if (datNominaTrabajador != null && datNominaTrabajador.size() > 0) {

							trabajador = new Trabajador();

							cn = new ConceptoNomina();

							cn = listaConceptoNomina.get(0);
							trabajador = listaTrabajador.get(0);

							// Trabajador
							entity = new DatNominaTrabajador();
							entity = datNominaTrabajador.get(0);

							entity.setFechaInicial(fechaIni);
							entity.setFechaFinal(fechaFIn);
							entity.setEstado("A");
							entity.setCompania(compania);
							entity.setUsuarioDigitacion(usuarioId);
							entity.setObservacion("Generado por integración");
							// detalle trabajador

							Double valorTotal = null;

							valorTotal = new Double(eElement.getElementsByTagName("VALOR").item(0).getTextContent());

							Object[] condicion4 = { "datNominaTrabajador.datNominaTrabajadorId", true,
									entity.getDatNominaTrabajadorId().longValue(), "=", "trabajador.trabId", true,
									trabajador.getTrabId().longValue(), "=", "conceptoNomina.ceptoNominaId", true,
									cn.getCeptoNominaId().longValue(), "=" };

							nominaTrabajadordet = businessDelegatorView
									.findByCriteriaInDatNominaTrabajadorDet(condicion4, null, null);

							if (nominaTrabajadordet != null && nominaTrabajadordet.size() > 0) {

								valor = new DatNominaTrabajadorDet();
								valor = nominaTrabajadordet.get(0);

								dataNominaTrabajadorDet = new ArrayList<DatNominaTrabajadorDetDTO>();

								datNominaTrabajadorDetDTO = new DatNominaTrabajadorDetDTO();

								datNominaTrabajadorDetDTO.setTrabId_Trabajador(trabajador);
								datNominaTrabajadorDetDTO.setCeptoNominaId_ConceptoNomina(cn);
								datNominaTrabajadorDetDTO
										.setDatNominaTrabajadorDetId(valor.getDatNominaTrabajadorDetId());
								datNominaTrabajadorDetDTO.setValorTotal(
										new Double(eElement.getElementsByTagName("VALOR").item(0).getTextContent()));

								dataNominaTrabajadorDet.add(datNominaTrabajadorDetDTO);

								businessDelegatorView.updateDatNominaTrabajador(entity, dataNominaTrabajadorDet);

							} else {

								dataNominaTrabajadorDet = new ArrayList<DatNominaTrabajadorDetDTO>();

								datNominaTrabajadorDetDTO = new DatNominaTrabajadorDetDTO();

								datNominaTrabajadorDetDTO.setTrabId_Trabajador(trabajador);
								datNominaTrabajadorDetDTO.setCeptoNominaId_ConceptoNomina(cn);
								datNominaTrabajadorDetDTO.setValorTotal(
										new Double(eElement.getElementsByTagName("VALOR").item(0).getTextContent()));

								dataNominaTrabajadorDet.add(datNominaTrabajadorDetDTO);

								businessDelegatorView.updateDatNominaTrabajador(entity, dataNominaTrabajadorDet);

							}

						} else {

							// Trabajador

							System.out.println("Crea el primer registro saveDatNominaTrabajador");

							trabajador = new Trabajador();
							cn = new ConceptoNomina();

							cn = listaConceptoNomina.get(0);
							trabajador = listaTrabajador.get(0);

							entity = new DatNominaTrabajador();

							entity.setConsecutivo(
									(businessDelegatorView.consultarConsecutivoConsolidadoNomina(compania)));

							entity.setFechaInicial(fechaIni);
							entity.setFechaFinal(fechaFIn);

							// detalle trabajador

							dataNominaTrabajadorDet = new ArrayList<DatNominaTrabajadorDetDTO>();

							datNominaTrabajadorDetDTO = new DatNominaTrabajadorDetDTO();
							datNominaTrabajadorDetDTO.setTrabId_Trabajador(trabajador);
							datNominaTrabajadorDetDTO.setCeptoNominaId_ConceptoNomina(cn);
							datNominaTrabajadorDetDTO.setValorTotal(
									new Double(eElement.getElementsByTagName("VALOR").item(0).getTextContent()));

							dataNominaTrabajadorDet.add(datNominaTrabajadorDetDTO);

							businessDelegatorView.saveDatNominaTrabajador(entity, dataNominaTrabajadorDet);
						}

						// se imprime informacion de prueba

						System.out.println("FUNC : " + eElement.getElementsByTagName("FUNC").item(0).getTextContent());
						System.out
								.println("DATAI : " + eElement.getElementsByTagName("DATAI").item(0).getTextContent());
						System.out
								.println("DATAF : " + eElement.getElementsByTagName("DATAF").item(0).getTextContent());
						System.out
								.println("VALOR : " + eElement.getElementsByTagName("VALOR").item(0).getTextContent());

						// se limpian las variables

						entity = null;
						dataNominaTrabajadorDet = null;
						fechaFIn = null;
						fechaIni = null;
						cn = null;
						trabajador = null;
						datNominaTrabajadorDetDTO = null;
						listaConceptoNomina = null;
						listaTrabajador = null;
						datNominaTrabajador = null;
						dateIni = null;
						dateFin = null;
						valor = null;
						nominaTrabajadordet = null;

						FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_INFO, "",
										"La interface de consolidación de nómina se ha importado con éxito. Registros importados:"
												+ nList.getLength()));

					} else {

						FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_INFO, "",
										"La interface de consolidación de nómina no se ha importado con éxito. debido a que el código del trabajador:"
												+ eElement.getElementsByTagName("FUNC").item(0).getTextContent()
												+ " y/o " + "el código del concepto de nómina:"
												+ eElement.getElementsByTagName("CONCEITOFP").item(0).getTextContent()
												+ " no exite en AgroView"));

					}

				}
			}

			System.out.println("La interface INT_XXXXXX se ha ejecutado con éxito");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getLoginSession() throws Exception {

		FacesContext fc = FacesContext.getCurrentInstance();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String login = null;
		String passWord = null;

		if (auth != null) {

			login = auth.getName();

		} else {

			throw new Exception("No user logged in ");

		}

		return login;
	}

	public String getCompaniaIdSession() throws Exception {

		String compania = null;

		Object[] condicion = { "login", true, getLoginSession(), "=" };
		List<Usuarios> u = businessDelegatorView.findByCriteriaInUsuarios(condicion, null, null);

		if (u != null) {
			for (Usuarios usuarios : u) {
				compania = usuarios.getCompania().getCompaniaId().toString();
			}
		}

		return compania;
	}

	public String getUsuarioIdSession() throws Exception {

		String usuarioId = null;

		Object[] condicion = { "login", true, getLoginSession(), "=" };
		List<Usuarios> u = businessDelegatorView.findByCriteriaInUsuarios(condicion, null, null);

		if (u != null) {
			for (Usuarios usuarios : u) {
				usuarioId = usuarios.getUsuarioId().toString();
			}
		}

		return usuarioId;
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public SelectOneMenu getTxtMes() {
		return txtMes;
	}

	public void setTxtMes(SelectOneMenu txtMes) {
		this.txtMes = txtMes;
	}

	public Spinner getTxtAnio() {
		return txtAnio;
	}

	public void setTxtAnio(Spinner txtAnio) {
		this.txtAnio = txtAnio;
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

}
