package co.com.arcosoft.presentation.backingBeans;

import co.com.arcosoft.exceptions.*;
import co.com.arcosoft.modelo.*;
import co.com.arcosoft.modelo.dto.PrecioPromMateriaPrimaDTO;
import co.com.arcosoft.presentation.businessDelegate.*;
import co.com.arcosoft.presentation.businessDelegate2.IBusinessDelegator2View;
import co.com.arcosoft.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class PrecioPromMateriaPrimaView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(PrecioPromMateriaPrimaView.class);
    private InputText txtAlmacenId;
    private InputText txtCantidadCompra;
    private InputText txtCompania;
    private InputText txtConceptoGastoId;
    private InputText txtConceptoKardexId;
    private InputText txtConsecutivo;
    private InputText txtCostoTotal;
    private InputText txtDatCompraProductosId;
    private InputText txtDatServRealizadosEquipoId;
    private InputText txtDiferido;
    private InputText txtEquipoId;
    private InputText txtEtapaId;
    private InputText txtHorometroAbastecimiento;
    private InputText txtIdInsumo;
    private InputText txtIdMaquinaria;
    private InputText txtIdalmacen;
    private InputText txtIndicadorVueltaMedidor;
    private InputText txtInfoAdicional;
    private InputText txtInfoAdicional2;
    private InputText txtLoteCompraProducto;
    private InputText txtNivel2ClientesmqId;
    private InputText txtNivel4ClientesmqId;
    private InputText txtNumFacturaCompra;
    private InputText txtOperarioEquipoId;
    private InputText txtOrigenDatos;
    private InputText txtPorcIva;
    private InputText txtRegistroIca;
    private InputText txtTipoMovimiento;
    private InputText txtTransportadoraFactura;
    private InputText txtTransportadoraNguia;
    private InputText txtTransportadoraValorFlete;
    private InputText txtUbicacionAlmacen;
    private InputText txtUbicacionesAlmacenId;
    private InputText txtUnidadMedida;
    private InputText txtUsuarioDigitacion;
    private InputText txtValorIva;
    private InputText txtValorUnitario;
    private InputText txtVariedId;
    private InputText txtDatOtrosMovInventarioId_DatOtrosMovInventario;
    private InputText txtNivel2Id_Nivel2;
    private InputText txtNivel4Id_Nivel4;
    private InputText txtPersEmprId_PersEmpr;
    private InputText txtProductoId_Producto;
    private InputText txtTrabId_Trabajador;
    private InputText txtPrecioPromMateriaPrimaId;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaFinal;
    private Calendar txtFechaInicial;
    private Calendar txtFechaModificacion;
    private Calendar txtFechaVencimiento;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<PrecioPromMateriaPrimaDTO> data;
    private PrecioPromMateriaPrimaDTO selectedPrecioPromMateriaPrima;
    private PrecioPromMateriaPrima entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;
    
    @ManagedProperty(value = "#{BusinessDelegator2View}")
    private IBusinessDelegator2View businessDelegator2View;

    public PrecioPromMateriaPrimaView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            PrecioPromMateriaPrimaDTO precioPromMateriaPrimaDTO = (PrecioPromMateriaPrimaDTO) e.getObject();

            if (txtAlmacenId == null) {
                txtAlmacenId = new InputText();
            }

            txtAlmacenId.setValue(precioPromMateriaPrimaDTO.getAlmacenId());

            if (txtCantidadCompra == null) {
                txtCantidadCompra = new InputText();
            }

            txtCantidadCompra.setValue(precioPromMateriaPrimaDTO.getCantidadCompra());

            if (txtCompania == null) {
                txtCompania = new InputText();
            }

            txtCompania.setValue(precioPromMateriaPrimaDTO.getCompania());

            if (txtConceptoGastoId == null) {
                txtConceptoGastoId = new InputText();
            }

            txtConceptoGastoId.setValue(precioPromMateriaPrimaDTO.getConceptoGastoId());

            if (txtConceptoKardexId == null) {
                txtConceptoKardexId = new InputText();
            }

            txtConceptoKardexId.setValue(precioPromMateriaPrimaDTO.getConceptoKardexId());

            if (txtConsecutivo == null) {
                txtConsecutivo = new InputText();
            }

            txtConsecutivo.setValue(precioPromMateriaPrimaDTO.getConsecutivo());

            if (txtCostoTotal == null) {
                txtCostoTotal = new InputText();
            }

            txtCostoTotal.setValue(precioPromMateriaPrimaDTO.getCostoTotal());

            if (txtDatCompraProductosId == null) {
                txtDatCompraProductosId = new InputText();
            }

            txtDatCompraProductosId.setValue(precioPromMateriaPrimaDTO.getDatCompraMateriaPrimaId());

            if (txtDatServRealizadosEquipoId == null) {
                txtDatServRealizadosEquipoId = new InputText();
            }

            txtDatServRealizadosEquipoId.setValue(precioPromMateriaPrimaDTO.getDatServRealizadosEquipoId());

            if (txtDiferido == null) {
                txtDiferido = new InputText();
            }

            txtDiferido.setValue(precioPromMateriaPrimaDTO.getDiferido());

            if (txtEquipoId == null) {
                txtEquipoId = new InputText();
            }

            txtEquipoId.setValue(precioPromMateriaPrimaDTO.getEquipoId());

            if (txtEtapaId == null) {
                txtEtapaId = new InputText();
            }

            txtEtapaId.setValue(precioPromMateriaPrimaDTO.getEtapaId());

            if (txtHorometroAbastecimiento == null) {
                txtHorometroAbastecimiento = new InputText();
            }

            txtHorometroAbastecimiento.setValue(precioPromMateriaPrimaDTO.getHorometroAbastecimiento());

            if (txtIdInsumo == null) {
                txtIdInsumo = new InputText();
            }

            txtIdInsumo.setValue(precioPromMateriaPrimaDTO.getIdInsumo());

            if (txtIdMaquinaria == null) {
                txtIdMaquinaria = new InputText();
            }

            txtIdMaquinaria.setValue(precioPromMateriaPrimaDTO.getIdMaquinaria());

            if (txtIdalmacen == null) {
                txtIdalmacen = new InputText();
            }

            txtIdalmacen.setValue(precioPromMateriaPrimaDTO.getIdalmacen());

            if (txtIndicadorVueltaMedidor == null) {
                txtIndicadorVueltaMedidor = new InputText();
            }

            txtIndicadorVueltaMedidor.setValue(precioPromMateriaPrimaDTO.getIndicadorVueltaMedidor());

            if (txtInfoAdicional == null) {
                txtInfoAdicional = new InputText();
            }

            txtInfoAdicional.setValue(precioPromMateriaPrimaDTO.getInfoAdicional());

            if (txtInfoAdicional2 == null) {
                txtInfoAdicional2 = new InputText();
            }

            txtInfoAdicional2.setValue(precioPromMateriaPrimaDTO.getInfoAdicional2());

            if (txtLoteCompraProducto == null) {
                txtLoteCompraProducto = new InputText();
            }

            txtLoteCompraProducto.setValue(precioPromMateriaPrimaDTO.getLoteCompraProducto());

            if (txtNivel2ClientesmqId == null) {
                txtNivel2ClientesmqId = new InputText();
            }

            txtNivel2ClientesmqId.setValue(precioPromMateriaPrimaDTO.getNivel2ClientesmqId());

            if (txtNivel4ClientesmqId == null) {
                txtNivel4ClientesmqId = new InputText();
            }

            txtNivel4ClientesmqId.setValue(precioPromMateriaPrimaDTO.getNivel4ClientesmqId());

            if (txtNumFacturaCompra == null) {
                txtNumFacturaCompra = new InputText();
            }

            txtNumFacturaCompra.setValue(precioPromMateriaPrimaDTO.getNumFacturaCompra());

            if (txtOperarioEquipoId == null) {
                txtOperarioEquipoId = new InputText();
            }

            txtOperarioEquipoId.setValue(precioPromMateriaPrimaDTO.getOperarioEquipoId());

            if (txtOrigenDatos == null) {
                txtOrigenDatos = new InputText();
            }

            txtOrigenDatos.setValue(precioPromMateriaPrimaDTO.getOrigenDatos());

            if (txtPorcIva == null) {
                txtPorcIva = new InputText();
            }

            txtPorcIva.setValue(precioPromMateriaPrimaDTO.getPorcIva());

            if (txtRegistroIca == null) {
                txtRegistroIca = new InputText();
            }

            txtRegistroIca.setValue(precioPromMateriaPrimaDTO.getRegistroIca());

            if (txtTipoMovimiento == null) {
                txtTipoMovimiento = new InputText();
            }

            txtTipoMovimiento.setValue(precioPromMateriaPrimaDTO.getTipoMovimiento());

            if (txtTransportadoraFactura == null) {
                txtTransportadoraFactura = new InputText();
            }

            txtTransportadoraFactura.setValue(precioPromMateriaPrimaDTO.getTransportadoraFactura());

            if (txtTransportadoraNguia == null) {
                txtTransportadoraNguia = new InputText();
            }

            txtTransportadoraNguia.setValue(precioPromMateriaPrimaDTO.getTransportadoraNguia());

            if (txtTransportadoraValorFlete == null) {
                txtTransportadoraValorFlete = new InputText();
            }

            txtTransportadoraValorFlete.setValue(precioPromMateriaPrimaDTO.getTransportadoraValorFlete());

            if (txtUbicacionAlmacen == null) {
                txtUbicacionAlmacen = new InputText();
            }

            txtUbicacionAlmacen.setValue(precioPromMateriaPrimaDTO.getUbicacionAlmacen());

            if (txtUbicacionesAlmacenId == null) {
                txtUbicacionesAlmacenId = new InputText();
            }

            txtUbicacionesAlmacenId.setValue(precioPromMateriaPrimaDTO.getUbicacionesAlmacenId());

            if (txtUnidadMedida == null) {
                txtUnidadMedida = new InputText();
            }

            txtUnidadMedida.setValue(precioPromMateriaPrimaDTO.getUnidadMedida());

            if (txtUsuarioDigitacion == null) {
                txtUsuarioDigitacion = new InputText();
            }

            txtUsuarioDigitacion.setValue(precioPromMateriaPrimaDTO.getUsuarioDigitacion());

            if (txtValorIva == null) {
                txtValorIva = new InputText();
            }

            txtValorIva.setValue(precioPromMateriaPrimaDTO.getValorIva());

            if (txtValorUnitario == null) {
                txtValorUnitario = new InputText();
            }

            txtValorUnitario.setValue(precioPromMateriaPrimaDTO.getValorUnitario());

            if (txtVariedId == null) {
                txtVariedId = new InputText();
            }

            txtVariedId.setValue(precioPromMateriaPrimaDTO.getVariedId());

            if (txtDatOtrosMovInventarioId_DatOtrosMovInventario == null) {
                txtDatOtrosMovInventarioId_DatOtrosMovInventario = new InputText();
            }

            txtDatOtrosMovInventarioId_DatOtrosMovInventario.setValue(precioPromMateriaPrimaDTO.getDatOtrosMovInventarioId_DatOtrosMovInventario());

            if (txtNivel2Id_Nivel2 == null) {
                txtNivel2Id_Nivel2 = new InputText();
            }

            txtNivel2Id_Nivel2.setValue(precioPromMateriaPrimaDTO.getNivel2Id_Nivel2());

            if (txtNivel4Id_Nivel4 == null) {
                txtNivel4Id_Nivel4 = new InputText();
            }

            txtNivel4Id_Nivel4.setValue(precioPromMateriaPrimaDTO.getNivel4Id_Nivel4());

            if (txtPersEmprId_PersEmpr == null) {
                txtPersEmprId_PersEmpr = new InputText();
            }

            txtPersEmprId_PersEmpr.setValue(precioPromMateriaPrimaDTO.getPersEmprId_PersEmpr());

            if (txtProductoId_Producto == null) {
                txtProductoId_Producto = new InputText();
            }

            txtProductoId_Producto.setValue(precioPromMateriaPrimaDTO.getProductoId_Producto());

            if (txtTrabId_Trabajador == null) {
                txtTrabId_Trabajador = new InputText();
            }

            txtTrabId_Trabajador.setValue(precioPromMateriaPrimaDTO.getTrabId_Trabajador());

            if (txtPrecioPromMateriaPrimaId == null) {
                txtPrecioPromMateriaPrimaId = new InputText();
            }

            txtPrecioPromMateriaPrimaId.setValue(precioPromMateriaPrimaDTO.getPrecioPromMateriaPrimaId());

            if (txtFechaCreacion == null) {
                txtFechaCreacion = new Calendar();
            }

            txtFechaCreacion.setValue(precioPromMateriaPrimaDTO.getFechaCreacion());

            if (txtFechaFinal == null) {
                txtFechaFinal = new Calendar();
            }

            txtFechaFinal.setValue(precioPromMateriaPrimaDTO.getFechaFinal());

            if (txtFechaInicial == null) {
                txtFechaInicial = new Calendar();
            }

            txtFechaInicial.setValue(precioPromMateriaPrimaDTO.getFechaInicial());

            if (txtFechaModificacion == null) {
                txtFechaModificacion = new Calendar();
            }

            txtFechaModificacion.setValue(precioPromMateriaPrimaDTO.getFechaModificacion());

            if (txtFechaVencimiento == null) {
                txtFechaVencimiento = new Calendar();
            }

            txtFechaVencimiento.setValue(precioPromMateriaPrimaDTO.getFechaVencimiento());

            Long precioPromMateriaPrimaId = FacesUtils.checkLong(txtPrecioPromMateriaPrimaId);
            entity = businessDelegator2View.getPrecioPromMateriaPrima(precioPromMateriaPrimaId);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedPrecioPromMateriaPrima = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedPrecioPromMateriaPrima = null;

        if (txtAlmacenId != null) {
            txtAlmacenId.setValue(null);
            txtAlmacenId.setDisabled(true);
        }

        if (txtCantidadCompra != null) {
            txtCantidadCompra.setValue(null);
            txtCantidadCompra.setDisabled(true);
        }

        if (txtCompania != null) {
            txtCompania.setValue(null);
            txtCompania.setDisabled(true);
        }

        if (txtConceptoGastoId != null) {
            txtConceptoGastoId.setValue(null);
            txtConceptoGastoId.setDisabled(true);
        }

        if (txtConceptoKardexId != null) {
            txtConceptoKardexId.setValue(null);
            txtConceptoKardexId.setDisabled(true);
        }

        if (txtConsecutivo != null) {
            txtConsecutivo.setValue(null);
            txtConsecutivo.setDisabled(true);
        }

        if (txtCostoTotal != null) {
            txtCostoTotal.setValue(null);
            txtCostoTotal.setDisabled(true);
        }

        if (txtDatCompraProductosId != null) {
            txtDatCompraProductosId.setValue(null);
            txtDatCompraProductosId.setDisabled(true);
        }

        if (txtDatServRealizadosEquipoId != null) {
            txtDatServRealizadosEquipoId.setValue(null);
            txtDatServRealizadosEquipoId.setDisabled(true);
        }

        if (txtDiferido != null) {
            txtDiferido.setValue(null);
            txtDiferido.setDisabled(true);
        }

        if (txtEquipoId != null) {
            txtEquipoId.setValue(null);
            txtEquipoId.setDisabled(true);
        }

        if (txtEtapaId != null) {
            txtEtapaId.setValue(null);
            txtEtapaId.setDisabled(true);
        }

        if (txtHorometroAbastecimiento != null) {
            txtHorometroAbastecimiento.setValue(null);
            txtHorometroAbastecimiento.setDisabled(true);
        }

        if (txtIdInsumo != null) {
            txtIdInsumo.setValue(null);
            txtIdInsumo.setDisabled(true);
        }

        if (txtIdMaquinaria != null) {
            txtIdMaquinaria.setValue(null);
            txtIdMaquinaria.setDisabled(true);
        }

        if (txtIdalmacen != null) {
            txtIdalmacen.setValue(null);
            txtIdalmacen.setDisabled(true);
        }

        if (txtIndicadorVueltaMedidor != null) {
            txtIndicadorVueltaMedidor.setValue(null);
            txtIndicadorVueltaMedidor.setDisabled(true);
        }

        if (txtInfoAdicional != null) {
            txtInfoAdicional.setValue(null);
            txtInfoAdicional.setDisabled(true);
        }

        if (txtInfoAdicional2 != null) {
            txtInfoAdicional2.setValue(null);
            txtInfoAdicional2.setDisabled(true);
        }

        if (txtLoteCompraProducto != null) {
            txtLoteCompraProducto.setValue(null);
            txtLoteCompraProducto.setDisabled(true);
        }

        if (txtNivel2ClientesmqId != null) {
            txtNivel2ClientesmqId.setValue(null);
            txtNivel2ClientesmqId.setDisabled(true);
        }

        if (txtNivel4ClientesmqId != null) {
            txtNivel4ClientesmqId.setValue(null);
            txtNivel4ClientesmqId.setDisabled(true);
        }

        if (txtNumFacturaCompra != null) {
            txtNumFacturaCompra.setValue(null);
            txtNumFacturaCompra.setDisabled(true);
        }

        if (txtOperarioEquipoId != null) {
            txtOperarioEquipoId.setValue(null);
            txtOperarioEquipoId.setDisabled(true);
        }

        if (txtOrigenDatos != null) {
            txtOrigenDatos.setValue(null);
            txtOrigenDatos.setDisabled(true);
        }

        if (txtPorcIva != null) {
            txtPorcIva.setValue(null);
            txtPorcIva.setDisabled(true);
        }

        if (txtRegistroIca != null) {
            txtRegistroIca.setValue(null);
            txtRegistroIca.setDisabled(true);
        }

        if (txtTipoMovimiento != null) {
            txtTipoMovimiento.setValue(null);
            txtTipoMovimiento.setDisabled(true);
        }

        if (txtTransportadoraFactura != null) {
            txtTransportadoraFactura.setValue(null);
            txtTransportadoraFactura.setDisabled(true);
        }

        if (txtTransportadoraNguia != null) {
            txtTransportadoraNguia.setValue(null);
            txtTransportadoraNguia.setDisabled(true);
        }

        if (txtTransportadoraValorFlete != null) {
            txtTransportadoraValorFlete.setValue(null);
            txtTransportadoraValorFlete.setDisabled(true);
        }

        if (txtUbicacionAlmacen != null) {
            txtUbicacionAlmacen.setValue(null);
            txtUbicacionAlmacen.setDisabled(true);
        }

        if (txtUbicacionesAlmacenId != null) {
            txtUbicacionesAlmacenId.setValue(null);
            txtUbicacionesAlmacenId.setDisabled(true);
        }

        if (txtUnidadMedida != null) {
            txtUnidadMedida.setValue(null);
            txtUnidadMedida.setDisabled(true);
        }

        if (txtUsuarioDigitacion != null) {
            txtUsuarioDigitacion.setValue(null);
            txtUsuarioDigitacion.setDisabled(true);
        }

        if (txtValorIva != null) {
            txtValorIva.setValue(null);
            txtValorIva.setDisabled(true);
        }

        if (txtValorUnitario != null) {
            txtValorUnitario.setValue(null);
            txtValorUnitario.setDisabled(true);
        }

        if (txtVariedId != null) {
            txtVariedId.setValue(null);
            txtVariedId.setDisabled(true);
        }

        if (txtDatOtrosMovInventarioId_DatOtrosMovInventario != null) {
            txtDatOtrosMovInventarioId_DatOtrosMovInventario.setValue(null);
            txtDatOtrosMovInventarioId_DatOtrosMovInventario.setDisabled(true);
        }

        if (txtNivel2Id_Nivel2 != null) {
            txtNivel2Id_Nivel2.setValue(null);
            txtNivel2Id_Nivel2.setDisabled(true);
        }

        if (txtNivel4Id_Nivel4 != null) {
            txtNivel4Id_Nivel4.setValue(null);
            txtNivel4Id_Nivel4.setDisabled(true);
        }

        if (txtPersEmprId_PersEmpr != null) {
            txtPersEmprId_PersEmpr.setValue(null);
            txtPersEmprId_PersEmpr.setDisabled(true);
        }

        if (txtProductoId_Producto != null) {
            txtProductoId_Producto.setValue(null);
            txtProductoId_Producto.setDisabled(true);
        }

        if (txtTrabId_Trabajador != null) {
            txtTrabId_Trabajador.setValue(null);
            txtTrabId_Trabajador.setDisabled(true);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
        }

        if (txtFechaFinal != null) {
            txtFechaFinal.setValue(null);
            txtFechaFinal.setDisabled(true);
        }

        if (txtFechaInicial != null) {
            txtFechaInicial.setValue(null);
            txtFechaInicial.setDisabled(true);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(true);
        }

        if (txtFechaVencimiento != null) {
            txtFechaVencimiento.setValue(null);
            txtFechaVencimiento.setDisabled(true);
        }

        if (txtPrecioPromMateriaPrimaId != null) {
            txtPrecioPromMateriaPrimaId.setValue(null);
            txtPrecioPromMateriaPrimaId.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtFechaCreacion() {
        Date inputDate = (Date) txtFechaCreacion.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtFechaFinal() {
        Date inputDate = (Date) txtFechaFinal.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtFechaInicial() {
        Date inputDate = (Date) txtFechaInicial.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtFechaModificacion() {
        Date inputDate = (Date) txtFechaModificacion.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtFechaVencimiento() {
        Date inputDate = (Date) txtFechaVencimiento.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            Long precioPromMateriaPrimaId = FacesUtils.checkLong(txtPrecioPromMateriaPrimaId);
            entity = (precioPromMateriaPrimaId != null)
                ? businessDelegator2View.getPrecioPromMateriaPrima(precioPromMateriaPrimaId)
                : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtAlmacenId.setDisabled(false);
            txtCantidadCompra.setDisabled(false);
            txtCompania.setDisabled(false);
            txtConceptoGastoId.setDisabled(false);
            txtConceptoKardexId.setDisabled(false);
            txtConsecutivo.setDisabled(false);
            txtCostoTotal.setDisabled(false);
            txtDatCompraProductosId.setDisabled(false);
            txtDatServRealizadosEquipoId.setDisabled(false);
            txtDiferido.setDisabled(false);
            txtEquipoId.setDisabled(false);
            txtEtapaId.setDisabled(false);
            txtHorometroAbastecimiento.setDisabled(false);
            txtIdInsumo.setDisabled(false);
            txtIdMaquinaria.setDisabled(false);
            txtIdalmacen.setDisabled(false);
            txtIndicadorVueltaMedidor.setDisabled(false);
            txtInfoAdicional.setDisabled(false);
            txtInfoAdicional2.setDisabled(false);
            txtLoteCompraProducto.setDisabled(false);
            txtNivel2ClientesmqId.setDisabled(false);
            txtNivel4ClientesmqId.setDisabled(false);
            txtNumFacturaCompra.setDisabled(false);
            txtOperarioEquipoId.setDisabled(false);
            txtOrigenDatos.setDisabled(false);
            txtPorcIva.setDisabled(false);
            txtRegistroIca.setDisabled(false);
            txtTipoMovimiento.setDisabled(false);
            txtTransportadoraFactura.setDisabled(false);
            txtTransportadoraNguia.setDisabled(false);
            txtTransportadoraValorFlete.setDisabled(false);
            txtUbicacionAlmacen.setDisabled(false);
            txtUbicacionesAlmacenId.setDisabled(false);
            txtUnidadMedida.setDisabled(false);
            txtUsuarioDigitacion.setDisabled(false);
            txtValorIva.setDisabled(false);
            txtValorUnitario.setDisabled(false);
            txtVariedId.setDisabled(false);
            txtDatOtrosMovInventarioId_DatOtrosMovInventario.setDisabled(false);
            txtNivel2Id_Nivel2.setDisabled(false);
            txtNivel4Id_Nivel4.setDisabled(false);
            txtPersEmprId_PersEmpr.setDisabled(false);
            txtProductoId_Producto.setDisabled(false);
            txtTrabId_Trabajador.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaFinal.setDisabled(false);
            txtFechaInicial.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtFechaVencimiento.setDisabled(false);
            txtPrecioPromMateriaPrimaId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtAlmacenId.setValue(entity.getAlmacenId());
            txtAlmacenId.setDisabled(false);
            txtCantidadCompra.setValue(entity.getCantidadCompra());
            txtCantidadCompra.setDisabled(false);
            txtCompania.setValue(entity.getCompania());
            txtCompania.setDisabled(false);
            txtConceptoGastoId.setValue(entity.getConceptoGastoId());
            txtConceptoGastoId.setDisabled(false);
            txtConceptoKardexId.setValue(entity.getConceptoKardexId());
            txtConceptoKardexId.setDisabled(false);
            txtConsecutivo.setValue(entity.getConsecutivo());
            txtConsecutivo.setDisabled(false);
            txtCostoTotal.setValue(entity.getCostoTotal());
            txtCostoTotal.setDisabled(false);
            txtDatCompraProductosId.setValue(entity.getDatCompraMateriaPrimaId());
            txtDatCompraProductosId.setDisabled(false);
            txtDatServRealizadosEquipoId.setValue(entity.getDatServRealizadosEquipoId());
            txtDatServRealizadosEquipoId.setDisabled(false);
            txtDiferido.setValue(entity.getDiferido());
            txtDiferido.setDisabled(false);
            txtEquipoId.setValue(entity.getEquipoId());
            txtEquipoId.setDisabled(false);
            txtEtapaId.setValue(entity.getEtapaId());
            txtEtapaId.setDisabled(false);
            txtFechaCreacion.setValue(entity.getFechaCreacion());
            txtFechaCreacion.setDisabled(false);
            txtFechaFinal.setValue(entity.getFechaFinal());
            txtFechaFinal.setDisabled(false);
            txtFechaInicial.setValue(entity.getFechaInicial());
            txtFechaInicial.setDisabled(false);
            txtFechaModificacion.setValue(entity.getFechaModificacion());
            txtFechaModificacion.setDisabled(false);
            txtFechaVencimiento.setValue(entity.getFechaVencimiento());
            txtFechaVencimiento.setDisabled(false);
            txtHorometroAbastecimiento.setValue(entity.getHorometroAbastecimiento());
            txtHorometroAbastecimiento.setDisabled(false);
            txtIdInsumo.setValue(entity.getIdInsumo());
            txtIdInsumo.setDisabled(false);
            txtIdMaquinaria.setValue(entity.getIdMaquinaria());
            txtIdMaquinaria.setDisabled(false);
            txtIdalmacen.setValue(entity.getIdalmacen());
            txtIdalmacen.setDisabled(false);
            txtIndicadorVueltaMedidor.setValue(entity.getIndicadorVueltaMedidor());
            txtIndicadorVueltaMedidor.setDisabled(false);
            txtInfoAdicional.setValue(entity.getInfoAdicional());
            txtInfoAdicional.setDisabled(false);
            txtInfoAdicional2.setValue(entity.getInfoAdicional2());
            txtInfoAdicional2.setDisabled(false);
            txtLoteCompraProducto.setValue(entity.getLoteCompraProducto());
            txtLoteCompraProducto.setDisabled(false);
            txtNivel2ClientesmqId.setValue(entity.getNivel2ClientesmqId());
            txtNivel2ClientesmqId.setDisabled(false);
            txtNivel4ClientesmqId.setValue(entity.getNivel4ClientesmqId());
            txtNivel4ClientesmqId.setDisabled(false);
            txtNumFacturaCompra.setValue(entity.getNumFacturaCompra());
            txtNumFacturaCompra.setDisabled(false);
            txtOperarioEquipoId.setValue(entity.getOperarioEquipoId());
            txtOperarioEquipoId.setDisabled(false);
            txtOrigenDatos.setValue(entity.getOrigenDatos());
            txtOrigenDatos.setDisabled(false);
            txtPorcIva.setValue(entity.getPorcIva());
            txtPorcIva.setDisabled(false);
            txtRegistroIca.setValue(entity.getRegistroIca());
            txtRegistroIca.setDisabled(false);
            txtTipoMovimiento.setValue(entity.getTipoMovimiento());
            txtTipoMovimiento.setDisabled(false);
            txtTransportadoraFactura.setValue(entity.getTransportadoraFactura());
            txtTransportadoraFactura.setDisabled(false);
            txtTransportadoraNguia.setValue(entity.getTransportadoraNguia());
            txtTransportadoraNguia.setDisabled(false);
            txtTransportadoraValorFlete.setValue(entity.getTransportadoraValorFlete());
            txtTransportadoraValorFlete.setDisabled(false);
            txtUbicacionAlmacen.setValue(entity.getUbicacionAlmacen());
            txtUbicacionAlmacen.setDisabled(false);
            txtUbicacionesAlmacenId.setValue(entity.getUbicacionesAlmacenId());
            txtUbicacionesAlmacenId.setDisabled(false);
            txtUnidadMedida.setValue(entity.getUnidadMedida());
            txtUnidadMedida.setDisabled(false);
            txtUsuarioDigitacion.setValue(entity.getUsuarioDigitacion());
            txtUsuarioDigitacion.setDisabled(false);
            txtValorIva.setValue(entity.getValorIva());
            txtValorIva.setDisabled(false);
            txtValorUnitario.setValue(entity.getValorUnitario());
            txtValorUnitario.setDisabled(false);
            txtVariedId.setValue(entity.getVariedId());
            txtVariedId.setDisabled(false);
            txtDatOtrosMovInventarioId_DatOtrosMovInventario.setValue(entity.getDatOtrosMovInventario()
                                                                            .getDatOtrosMovInventarioId());
            txtDatOtrosMovInventarioId_DatOtrosMovInventario.setDisabled(false);
            txtNivel2Id_Nivel2.setValue(entity.getNivel2().getNivel2Id());
            txtNivel2Id_Nivel2.setDisabled(false);
            txtNivel4Id_Nivel4.setValue(entity.getNivel4().getNivel4Id());
            txtNivel4Id_Nivel4.setDisabled(false);
            txtPersEmprId_PersEmpr.setValue(entity.getPersEmpr().getPersEmprId());
            txtPersEmprId_PersEmpr.setDisabled(false);
            txtProductoId_Producto.setValue(entity.getProducto().getProductoId());
            txtProductoId_Producto.setDisabled(false);
            txtTrabId_Trabajador.setValue(entity.getTrabajador().getTrabId());
            txtTrabId_Trabajador.setDisabled(false);
            txtPrecioPromMateriaPrimaId.setValue(entity.getPrecioPromMateriaPrimaId());
            txtPrecioPromMateriaPrimaId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedPrecioPromMateriaPrima = (PrecioPromMateriaPrimaDTO) (evt.getComponent()
                                                                         .getAttributes()
                                                                         .get("selectedPrecioPromMateriaPrima"));
        txtAlmacenId.setValue(selectedPrecioPromMateriaPrima.getAlmacenId());
        txtAlmacenId.setDisabled(false);
        txtCantidadCompra.setValue(selectedPrecioPromMateriaPrima.getCantidadCompra());
        txtCantidadCompra.setDisabled(false);
        txtCompania.setValue(selectedPrecioPromMateriaPrima.getCompania());
        txtCompania.setDisabled(false);
        txtConceptoGastoId.setValue(selectedPrecioPromMateriaPrima.getConceptoGastoId());
        txtConceptoGastoId.setDisabled(false);
        txtConceptoKardexId.setValue(selectedPrecioPromMateriaPrima.getConceptoKardexId());
        txtConceptoKardexId.setDisabled(false);
        txtConsecutivo.setValue(selectedPrecioPromMateriaPrima.getConsecutivo());
        txtConsecutivo.setDisabled(false);
        txtCostoTotal.setValue(selectedPrecioPromMateriaPrima.getCostoTotal());
        txtCostoTotal.setDisabled(false);
        txtDatCompraProductosId.setValue(selectedPrecioPromMateriaPrima.getDatCompraMateriaPrimaId());
        txtDatCompraProductosId.setDisabled(false);
        txtDatServRealizadosEquipoId.setValue(selectedPrecioPromMateriaPrima.getDatServRealizadosEquipoId());
        txtDatServRealizadosEquipoId.setDisabled(false);
        txtDiferido.setValue(selectedPrecioPromMateriaPrima.getDiferido());
        txtDiferido.setDisabled(false);
        txtEquipoId.setValue(selectedPrecioPromMateriaPrima.getEquipoId());
        txtEquipoId.setDisabled(false);
        txtEtapaId.setValue(selectedPrecioPromMateriaPrima.getEtapaId());
        txtEtapaId.setDisabled(false);
        txtFechaCreacion.setValue(selectedPrecioPromMateriaPrima.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtFechaFinal.setValue(selectedPrecioPromMateriaPrima.getFechaFinal());
        txtFechaFinal.setDisabled(false);
        txtFechaInicial.setValue(selectedPrecioPromMateriaPrima.getFechaInicial());
        txtFechaInicial.setDisabled(false);
        txtFechaModificacion.setValue(selectedPrecioPromMateriaPrima.getFechaModificacion());
        txtFechaModificacion.setDisabled(false);
        txtFechaVencimiento.setValue(selectedPrecioPromMateriaPrima.getFechaVencimiento());
        txtFechaVencimiento.setDisabled(false);
        txtHorometroAbastecimiento.setValue(selectedPrecioPromMateriaPrima.getHorometroAbastecimiento());
        txtHorometroAbastecimiento.setDisabled(false);
        txtIdInsumo.setValue(selectedPrecioPromMateriaPrima.getIdInsumo());
        txtIdInsumo.setDisabled(false);
        txtIdMaquinaria.setValue(selectedPrecioPromMateriaPrima.getIdMaquinaria());
        txtIdMaquinaria.setDisabled(false);
        txtIdalmacen.setValue(selectedPrecioPromMateriaPrima.getIdalmacen());
        txtIdalmacen.setDisabled(false);
        txtIndicadorVueltaMedidor.setValue(selectedPrecioPromMateriaPrima.getIndicadorVueltaMedidor());
        txtIndicadorVueltaMedidor.setDisabled(false);
        txtInfoAdicional.setValue(selectedPrecioPromMateriaPrima.getInfoAdicional());
        txtInfoAdicional.setDisabled(false);
        txtInfoAdicional2.setValue(selectedPrecioPromMateriaPrima.getInfoAdicional2());
        txtInfoAdicional2.setDisabled(false);
        txtLoteCompraProducto.setValue(selectedPrecioPromMateriaPrima.getLoteCompraProducto());
        txtLoteCompraProducto.setDisabled(false);
        txtNivel2ClientesmqId.setValue(selectedPrecioPromMateriaPrima.getNivel2ClientesmqId());
        txtNivel2ClientesmqId.setDisabled(false);
        txtNivel4ClientesmqId.setValue(selectedPrecioPromMateriaPrima.getNivel4ClientesmqId());
        txtNivel4ClientesmqId.setDisabled(false);
        txtNumFacturaCompra.setValue(selectedPrecioPromMateriaPrima.getNumFacturaCompra());
        txtNumFacturaCompra.setDisabled(false);
        txtOperarioEquipoId.setValue(selectedPrecioPromMateriaPrima.getOperarioEquipoId());
        txtOperarioEquipoId.setDisabled(false);
        txtOrigenDatos.setValue(selectedPrecioPromMateriaPrima.getOrigenDatos());
        txtOrigenDatos.setDisabled(false);
        txtPorcIva.setValue(selectedPrecioPromMateriaPrima.getPorcIva());
        txtPorcIva.setDisabled(false);
        txtRegistroIca.setValue(selectedPrecioPromMateriaPrima.getRegistroIca());
        txtRegistroIca.setDisabled(false);
        txtTipoMovimiento.setValue(selectedPrecioPromMateriaPrima.getTipoMovimiento());
        txtTipoMovimiento.setDisabled(false);
        txtTransportadoraFactura.setValue(selectedPrecioPromMateriaPrima.getTransportadoraFactura());
        txtTransportadoraFactura.setDisabled(false);
        txtTransportadoraNguia.setValue(selectedPrecioPromMateriaPrima.getTransportadoraNguia());
        txtTransportadoraNguia.setDisabled(false);
        txtTransportadoraValorFlete.setValue(selectedPrecioPromMateriaPrima.getTransportadoraValorFlete());
        txtTransportadoraValorFlete.setDisabled(false);
        txtUbicacionAlmacen.setValue(selectedPrecioPromMateriaPrima.getUbicacionAlmacen());
        txtUbicacionAlmacen.setDisabled(false);
        txtUbicacionesAlmacenId.setValue(selectedPrecioPromMateriaPrima.getUbicacionesAlmacenId());
        txtUbicacionesAlmacenId.setDisabled(false);
        txtUnidadMedida.setValue(selectedPrecioPromMateriaPrima.getUnidadMedida());
        txtUnidadMedida.setDisabled(false);
        txtUsuarioDigitacion.setValue(selectedPrecioPromMateriaPrima.getUsuarioDigitacion());
        txtUsuarioDigitacion.setDisabled(false);
        txtValorIva.setValue(selectedPrecioPromMateriaPrima.getValorIva());
        txtValorIva.setDisabled(false);
        txtValorUnitario.setValue(selectedPrecioPromMateriaPrima.getValorUnitario());
        txtValorUnitario.setDisabled(false);
        txtVariedId.setValue(selectedPrecioPromMateriaPrima.getVariedId());
        txtVariedId.setDisabled(false);
        txtDatOtrosMovInventarioId_DatOtrosMovInventario.setValue(selectedPrecioPromMateriaPrima.getDatOtrosMovInventarioId_DatOtrosMovInventario());
        txtDatOtrosMovInventarioId_DatOtrosMovInventario.setDisabled(false);
        txtNivel2Id_Nivel2.setValue(selectedPrecioPromMateriaPrima.getNivel2Id_Nivel2());
        txtNivel2Id_Nivel2.setDisabled(false);
        txtNivel4Id_Nivel4.setValue(selectedPrecioPromMateriaPrima.getNivel4Id_Nivel4());
        txtNivel4Id_Nivel4.setDisabled(false);
        txtPersEmprId_PersEmpr.setValue(selectedPrecioPromMateriaPrima.getPersEmprId_PersEmpr());
        txtPersEmprId_PersEmpr.setDisabled(false);
        txtProductoId_Producto.setValue(selectedPrecioPromMateriaPrima.getProductoId_Producto());
        txtProductoId_Producto.setDisabled(false);
        txtTrabId_Trabajador.setValue(selectedPrecioPromMateriaPrima.getTrabId_Trabajador());
        txtTrabId_Trabajador.setDisabled(false);
        txtPrecioPromMateriaPrimaId.setValue(selectedPrecioPromMateriaPrima.getPrecioPromMateriaPrimaId());
        txtPrecioPromMateriaPrimaId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedPrecioPromMateriaPrima == null) && (entity == null)) {
                action_create();
            } else {
                action_modify();
            }

            data = null;
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_create() {
        try {
            entity = new PrecioPromMateriaPrima();

            Long precioPromMateriaPrimaId = FacesUtils.checkLong(txtPrecioPromMateriaPrimaId);

            entity.setAlmacenId(FacesUtils.checkLong(txtAlmacenId));
            entity.setCantidadCompra(FacesUtils.checkDouble(txtCantidadCompra));
            entity.setCompania(FacesUtils.checkLong(txtCompania));
            entity.setConceptoGastoId(FacesUtils.checkLong(txtConceptoGastoId));
            entity.setConceptoKardexId(FacesUtils.checkLong(txtConceptoKardexId));
            entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
            entity.setCostoTotal(FacesUtils.checkDouble(txtCostoTotal));
            entity.setDatCompraMateriaPrimaId(FacesUtils.checkLong(
                    txtDatCompraProductosId));
            entity.setDatServRealizadosEquipoId(FacesUtils.checkLong(
                    txtDatServRealizadosEquipoId));
            entity.setDiferido(FacesUtils.checkString(txtDiferido));
            entity.setEquipoId(FacesUtils.checkLong(txtEquipoId));
            entity.setEtapaId(FacesUtils.checkLong(txtEtapaId));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
            entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setFechaVencimiento(FacesUtils.checkDate(txtFechaVencimiento));
            entity.setHorometroAbastecimiento(FacesUtils.checkDouble(
                    txtHorometroAbastecimiento));
            entity.setIdInsumo(FacesUtils.checkString(txtIdInsumo));
            entity.setIdMaquinaria(FacesUtils.checkString(txtIdMaquinaria));
            entity.setIdalmacen(FacesUtils.checkString(txtIdalmacen));
            entity.setIndicadorVueltaMedidor(FacesUtils.checkLong(
                    txtIndicadorVueltaMedidor));
            entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
            entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
            entity.setLoteCompraProducto(FacesUtils.checkString(
                    txtLoteCompraProducto));
            entity.setNivel2ClientesmqId(FacesUtils.checkLong(
                    txtNivel2ClientesmqId));
            entity.setNivel4ClientesmqId(FacesUtils.checkLong(
                    txtNivel4ClientesmqId));
            entity.setNumFacturaCompra(FacesUtils.checkLong(txtNumFacturaCompra));
            entity.setOperarioEquipoId(FacesUtils.checkLong(txtOperarioEquipoId));
            entity.setOrigenDatos(FacesUtils.checkString(txtOrigenDatos));
            entity.setPorcIva(FacesUtils.checkDouble(txtPorcIva));
            entity.setPrecioPromMateriaPrimaId(precioPromMateriaPrimaId);
            entity.setRegistroIca(FacesUtils.checkString(txtRegistroIca));
            entity.setTipoMovimiento(FacesUtils.checkString(txtTipoMovimiento));
            entity.setTransportadoraFactura(FacesUtils.checkString(
                    txtTransportadoraFactura));
            entity.setTransportadoraNguia(FacesUtils.checkString(
                    txtTransportadoraNguia));
            entity.setTransportadoraValorFlete(FacesUtils.checkDouble(
                    txtTransportadoraValorFlete));
            entity.setUbicacionAlmacen(FacesUtils.checkLong(txtUbicacionAlmacen));
            entity.setUbicacionesAlmacenId(FacesUtils.checkLong(
                    txtUbicacionesAlmacenId));
            entity.setUnidadMedida(FacesUtils.checkLong(txtUnidadMedida));
            entity.setUsuarioDigitacion(FacesUtils.checkLong(
                    txtUsuarioDigitacion));
            entity.setValorIva(FacesUtils.checkDouble(txtValorIva));
            entity.setValorUnitario(FacesUtils.checkDouble(txtValorUnitario));
            entity.setVariedId(FacesUtils.checkLong(txtVariedId));
            entity.setDatOtrosMovInventario((FacesUtils.checkLong(
                    txtDatOtrosMovInventarioId_DatOtrosMovInventario) != null)
                ? businessDelegator2View.getDatOtrosMovInventario(
                    FacesUtils.checkLong(
                        txtDatOtrosMovInventarioId_DatOtrosMovInventario)) : null);
            entity.setNivel2((FacesUtils.checkLong(txtNivel2Id_Nivel2) != null)
                ? businessDelegatorView.getNivel2(FacesUtils.checkLong(
                        txtNivel2Id_Nivel2)) : null);
            entity.setNivel4((FacesUtils.checkLong(txtNivel4Id_Nivel4) != null)
                ? businessDelegatorView.getNivel4(FacesUtils.checkLong(
                        txtNivel4Id_Nivel4)) : null);
            entity.setPersEmpr((FacesUtils.checkLong(txtPersEmprId_PersEmpr) != null)
                ? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(
                        txtPersEmprId_PersEmpr)) : null);
            entity.setProducto((FacesUtils.checkLong(txtProductoId_Producto) != null)
                ? businessDelegatorView.getProducto(FacesUtils.checkLong(
                        txtProductoId_Producto)) : null);
            entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador) != null)
                ? businessDelegatorView.getTrabajador(FacesUtils.checkLong(
                        txtTrabId_Trabajador)) : null);
            businessDelegator2View.savePrecioPromMateriaPrima(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            entity = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            if (entity == null) {
                Long precioPromMateriaPrimaId = new Long(selectedPrecioPromMateriaPrima.getPrecioPromMateriaPrimaId());
                entity = businessDelegator2View.getPrecioPromMateriaPrima(precioPromMateriaPrimaId);
            }

            entity.setAlmacenId(FacesUtils.checkLong(txtAlmacenId));
            entity.setCantidadCompra(FacesUtils.checkDouble(txtCantidadCompra));
            entity.setCompania(FacesUtils.checkLong(txtCompania));
            entity.setConceptoGastoId(FacesUtils.checkLong(txtConceptoGastoId));
            entity.setConceptoKardexId(FacesUtils.checkLong(txtConceptoKardexId));
            entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
            entity.setCostoTotal(FacesUtils.checkDouble(txtCostoTotal));
            entity.setDatCompraMateriaPrimaId(FacesUtils.checkLong(
                    txtDatCompraProductosId));
            entity.setDatServRealizadosEquipoId(FacesUtils.checkLong(
                    txtDatServRealizadosEquipoId));
            entity.setDiferido(FacesUtils.checkString(txtDiferido));
            entity.setEquipoId(FacesUtils.checkLong(txtEquipoId));
            entity.setEtapaId(FacesUtils.checkLong(txtEtapaId));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
            entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setFechaVencimiento(FacesUtils.checkDate(txtFechaVencimiento));
            entity.setHorometroAbastecimiento(FacesUtils.checkDouble(
                    txtHorometroAbastecimiento));
            entity.setIdInsumo(FacesUtils.checkString(txtIdInsumo));
            entity.setIdMaquinaria(FacesUtils.checkString(txtIdMaquinaria));
            entity.setIdalmacen(FacesUtils.checkString(txtIdalmacen));
            entity.setIndicadorVueltaMedidor(FacesUtils.checkLong(
                    txtIndicadorVueltaMedidor));
            entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
            entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
            entity.setLoteCompraProducto(FacesUtils.checkString(
                    txtLoteCompraProducto));
            entity.setNivel2ClientesmqId(FacesUtils.checkLong(
                    txtNivel2ClientesmqId));
            entity.setNivel4ClientesmqId(FacesUtils.checkLong(
                    txtNivel4ClientesmqId));
            entity.setNumFacturaCompra(FacesUtils.checkLong(txtNumFacturaCompra));
            entity.setOperarioEquipoId(FacesUtils.checkLong(txtOperarioEquipoId));
            entity.setOrigenDatos(FacesUtils.checkString(txtOrigenDatos));
            entity.setPorcIva(FacesUtils.checkDouble(txtPorcIva));
            entity.setRegistroIca(FacesUtils.checkString(txtRegistroIca));
            entity.setTipoMovimiento(FacesUtils.checkString(txtTipoMovimiento));
            entity.setTransportadoraFactura(FacesUtils.checkString(
                    txtTransportadoraFactura));
            entity.setTransportadoraNguia(FacesUtils.checkString(
                    txtTransportadoraNguia));
            entity.setTransportadoraValorFlete(FacesUtils.checkDouble(
                    txtTransportadoraValorFlete));
            entity.setUbicacionAlmacen(FacesUtils.checkLong(txtUbicacionAlmacen));
            entity.setUbicacionesAlmacenId(FacesUtils.checkLong(
                    txtUbicacionesAlmacenId));
            entity.setUnidadMedida(FacesUtils.checkLong(txtUnidadMedida));
            entity.setUsuarioDigitacion(FacesUtils.checkLong(
                    txtUsuarioDigitacion));
            entity.setValorIva(FacesUtils.checkDouble(txtValorIva));
            entity.setValorUnitario(FacesUtils.checkDouble(txtValorUnitario));
            entity.setVariedId(FacesUtils.checkLong(txtVariedId));
            entity.setDatOtrosMovInventario((FacesUtils.checkLong(
                    txtDatOtrosMovInventarioId_DatOtrosMovInventario) != null)
                ? businessDelegator2View.getDatOtrosMovInventario(
                    FacesUtils.checkLong(
                        txtDatOtrosMovInventarioId_DatOtrosMovInventario)) : null);
            entity.setNivel2((FacesUtils.checkLong(txtNivel2Id_Nivel2) != null)
                ? businessDelegatorView.getNivel2(FacesUtils.checkLong(
                        txtNivel2Id_Nivel2)) : null);
            entity.setNivel4((FacesUtils.checkLong(txtNivel4Id_Nivel4) != null)
                ? businessDelegatorView.getNivel4(FacesUtils.checkLong(
                        txtNivel4Id_Nivel4)) : null);
            entity.setPersEmpr((FacesUtils.checkLong(txtPersEmprId_PersEmpr) != null)
                ? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(
                        txtPersEmprId_PersEmpr)) : null);
            entity.setProducto((FacesUtils.checkLong(txtProductoId_Producto) != null)
                ? businessDelegatorView.getProducto(FacesUtils.checkLong(
                        txtProductoId_Producto)) : null);
            entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador) != null)
                ? businessDelegatorView.getTrabajador(FacesUtils.checkLong(
                        txtTrabId_Trabajador)) : null);
            businessDelegator2View.updatePrecioPromMateriaPrima(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedPrecioPromMateriaPrima = (PrecioPromMateriaPrimaDTO) (evt.getComponent()
                                                                             .getAttributes()
                                                                             .get("selectedPrecioPromMateriaPrima"));

            Long precioPromMateriaPrimaId = new Long(selectedPrecioPromMateriaPrima.getPrecioPromMateriaPrimaId());
            entity = businessDelegator2View.getPrecioPromMateriaPrima(precioPromMateriaPrimaId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long precioPromMateriaPrimaId = FacesUtils.checkLong(txtPrecioPromMateriaPrimaId);
            entity = businessDelegator2View.getPrecioPromMateriaPrima(precioPromMateriaPrimaId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegator2View.deletePrecioPromMateriaPrima(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data = null;
        } catch (Exception e) {
            throw e;
        }
    }

    public String action_closeDialog() {
        setShowDialog(false);
        action_clear();

        return "";
    }

    public String actionDeleteDataTableEditable(ActionEvent evt) {
        try {
            selectedPrecioPromMateriaPrima = (PrecioPromMateriaPrimaDTO) (evt.getComponent()
                                                                             .getAttributes()
                                                                             .get("selectedPrecioPromMateriaPrima"));

            Long precioPromMateriaPrimaId = new Long(selectedPrecioPromMateriaPrima.getPrecioPromMateriaPrimaId());
            entity = businessDelegator2View.getPrecioPromMateriaPrima(precioPromMateriaPrimaId);
            businessDelegator2View.deletePrecioPromMateriaPrima(entity);
            data.remove(selectedPrecioPromMateriaPrima);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long almacenId, Double cantidadCompra,
        Long compania, Long conceptoGastoId, Long conceptoKardexId,
        Long consecutivo, Double costoTotal, Long datCompraProductosId,
        Long datServRealizadosEquipoId, String diferido, Long equipoId,
        Long etapaId, Date fechaCreacion, Date fechaFinal, Date fechaInicial,
        Date fechaModificacion, Date fechaVencimiento,
        Double horometroAbastecimiento, String idInsumo, String idMaquinaria,
        String idalmacen, Long indicadorVueltaMedidor, String infoAdicional,
        String infoAdicional2, String loteCompraProducto,
        Long nivel2ClientesmqId, Long nivel4ClientesmqId,
        Long numFacturaCompra, Long operarioEquipoId, String origenDatos,
        Double porcIva, Long precioPromMateriaPrimaId, String registroIca,
        String tipoMovimiento, String transportadoraFactura,
        String transportadoraNguia, Double transportadoraValorFlete,
        Long ubicacionAlmacen, Long ubicacionesAlmacenId, Long unidadMedida,
        Long usuarioDigitacion, Double valorIva, Double valorUnitario,
        Long variedId, Long datOtrosMovInventarioId_DatOtrosMovInventario,
        Long nivel2Id_Nivel2, Long nivel4Id_Nivel4, Long persEmprId_PersEmpr,
        Long productoId_Producto, Long trabId_Trabajador)
        throws Exception {
        try {
            entity.setAlmacenId(FacesUtils.checkLong(almacenId));
            entity.setCantidadCompra(FacesUtils.checkDouble(cantidadCompra));
            entity.setCompania(FacesUtils.checkLong(compania));
            entity.setConceptoGastoId(FacesUtils.checkLong(conceptoGastoId));
            entity.setConceptoKardexId(FacesUtils.checkLong(conceptoKardexId));
            entity.setConsecutivo(FacesUtils.checkLong(consecutivo));
            entity.setCostoTotal(FacesUtils.checkDouble(costoTotal));
            entity.setDatCompraMateriaPrimaId(FacesUtils.checkLong(
                    datCompraProductosId));
            entity.setDatServRealizadosEquipoId(FacesUtils.checkLong(
                    datServRealizadosEquipoId));
            entity.setDiferido(FacesUtils.checkString(diferido));
            entity.setEquipoId(FacesUtils.checkLong(equipoId));
            entity.setEtapaId(FacesUtils.checkLong(etapaId));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaFinal(FacesUtils.checkDate(fechaFinal));
            entity.setFechaInicial(FacesUtils.checkDate(fechaInicial));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setFechaVencimiento(FacesUtils.checkDate(fechaVencimiento));
            entity.setHorometroAbastecimiento(FacesUtils.checkDouble(
                    horometroAbastecimiento));
            entity.setIdInsumo(FacesUtils.checkString(idInsumo));
            entity.setIdMaquinaria(FacesUtils.checkString(idMaquinaria));
            entity.setIdalmacen(FacesUtils.checkString(idalmacen));
            entity.setIndicadorVueltaMedidor(FacesUtils.checkLong(
                    indicadorVueltaMedidor));
            entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
            entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
            entity.setLoteCompraProducto(FacesUtils.checkString(
                    loteCompraProducto));
            entity.setNivel2ClientesmqId(FacesUtils.checkLong(
                    nivel2ClientesmqId));
            entity.setNivel4ClientesmqId(FacesUtils.checkLong(
                    nivel4ClientesmqId));
            entity.setNumFacturaCompra(FacesUtils.checkLong(numFacturaCompra));
            entity.setOperarioEquipoId(FacesUtils.checkLong(operarioEquipoId));
            entity.setOrigenDatos(FacesUtils.checkString(origenDatos));
            entity.setPorcIva(FacesUtils.checkDouble(porcIva));
            entity.setRegistroIca(FacesUtils.checkString(registroIca));
            entity.setTipoMovimiento(FacesUtils.checkString(tipoMovimiento));
            entity.setTransportadoraFactura(FacesUtils.checkString(
                    transportadoraFactura));
            entity.setTransportadoraNguia(FacesUtils.checkString(
                    transportadoraNguia));
            entity.setTransportadoraValorFlete(FacesUtils.checkDouble(
                    transportadoraValorFlete));
            entity.setUbicacionAlmacen(FacesUtils.checkLong(ubicacionAlmacen));
            entity.setUbicacionesAlmacenId(FacesUtils.checkLong(
                    ubicacionesAlmacenId));
            entity.setUnidadMedida(FacesUtils.checkLong(unidadMedida));
            entity.setUsuarioDigitacion(FacesUtils.checkLong(usuarioDigitacion));
            entity.setValorIva(FacesUtils.checkDouble(valorIva));
            entity.setValorUnitario(FacesUtils.checkDouble(valorUnitario));
            entity.setVariedId(FacesUtils.checkLong(variedId));
            businessDelegator2View.updatePrecioPromMateriaPrima(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("PrecioPromMateriaPrimaView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtAlmacenId() {
        return txtAlmacenId;
    }

    public void setTxtAlmacenId(InputText txtAlmacenId) {
        this.txtAlmacenId = txtAlmacenId;
    }

    public InputText getTxtCantidadCompra() {
        return txtCantidadCompra;
    }

    public void setTxtCantidadCompra(InputText txtCantidadCompra) {
        this.txtCantidadCompra = txtCantidadCompra;
    }

    public InputText getTxtCompania() {
        return txtCompania;
    }

    public void setTxtCompania(InputText txtCompania) {
        this.txtCompania = txtCompania;
    }

    public InputText getTxtConceptoGastoId() {
        return txtConceptoGastoId;
    }

    public void setTxtConceptoGastoId(InputText txtConceptoGastoId) {
        this.txtConceptoGastoId = txtConceptoGastoId;
    }

    public InputText getTxtConceptoKardexId() {
        return txtConceptoKardexId;
    }

    public void setTxtConceptoKardexId(InputText txtConceptoKardexId) {
        this.txtConceptoKardexId = txtConceptoKardexId;
    }

    public InputText getTxtConsecutivo() {
        return txtConsecutivo;
    }

    public void setTxtConsecutivo(InputText txtConsecutivo) {
        this.txtConsecutivo = txtConsecutivo;
    }

    public InputText getTxtCostoTotal() {
        return txtCostoTotal;
    }

    public void setTxtCostoTotal(InputText txtCostoTotal) {
        this.txtCostoTotal = txtCostoTotal;
    }

    public InputText getTxtDatCompraProductosId() {
        return txtDatCompraProductosId;
    }

    public void setTxtDatCompraProductosId(InputText txtDatCompraProductosId) {
        this.txtDatCompraProductosId = txtDatCompraProductosId;
    }

    public InputText getTxtDatServRealizadosEquipoId() {
        return txtDatServRealizadosEquipoId;
    }

    public void setTxtDatServRealizadosEquipoId(
        InputText txtDatServRealizadosEquipoId) {
        this.txtDatServRealizadosEquipoId = txtDatServRealizadosEquipoId;
    }

    public InputText getTxtDiferido() {
        return txtDiferido;
    }

    public void setTxtDiferido(InputText txtDiferido) {
        this.txtDiferido = txtDiferido;
    }

    public InputText getTxtEquipoId() {
        return txtEquipoId;
    }

    public void setTxtEquipoId(InputText txtEquipoId) {
        this.txtEquipoId = txtEquipoId;
    }

    public InputText getTxtEtapaId() {
        return txtEtapaId;
    }

    public void setTxtEtapaId(InputText txtEtapaId) {
        this.txtEtapaId = txtEtapaId;
    }

    public InputText getTxtHorometroAbastecimiento() {
        return txtHorometroAbastecimiento;
    }

    public void setTxtHorometroAbastecimiento(
        InputText txtHorometroAbastecimiento) {
        this.txtHorometroAbastecimiento = txtHorometroAbastecimiento;
    }

    public InputText getTxtIdInsumo() {
        return txtIdInsumo;
    }

    public void setTxtIdInsumo(InputText txtIdInsumo) {
        this.txtIdInsumo = txtIdInsumo;
    }

    public InputText getTxtIdMaquinaria() {
        return txtIdMaquinaria;
    }

    public void setTxtIdMaquinaria(InputText txtIdMaquinaria) {
        this.txtIdMaquinaria = txtIdMaquinaria;
    }

    public InputText getTxtIdalmacen() {
        return txtIdalmacen;
    }

    public void setTxtIdalmacen(InputText txtIdalmacen) {
        this.txtIdalmacen = txtIdalmacen;
    }

    public InputText getTxtIndicadorVueltaMedidor() {
        return txtIndicadorVueltaMedidor;
    }

    public void setTxtIndicadorVueltaMedidor(
        InputText txtIndicadorVueltaMedidor) {
        this.txtIndicadorVueltaMedidor = txtIndicadorVueltaMedidor;
    }

    public InputText getTxtInfoAdicional() {
        return txtInfoAdicional;
    }

    public void setTxtInfoAdicional(InputText txtInfoAdicional) {
        this.txtInfoAdicional = txtInfoAdicional;
    }

    public InputText getTxtInfoAdicional2() {
        return txtInfoAdicional2;
    }

    public void setTxtInfoAdicional2(InputText txtInfoAdicional2) {
        this.txtInfoAdicional2 = txtInfoAdicional2;
    }

    public InputText getTxtLoteCompraProducto() {
        return txtLoteCompraProducto;
    }

    public void setTxtLoteCompraProducto(InputText txtLoteCompraProducto) {
        this.txtLoteCompraProducto = txtLoteCompraProducto;
    }

    public InputText getTxtNivel2ClientesmqId() {
        return txtNivel2ClientesmqId;
    }

    public void setTxtNivel2ClientesmqId(InputText txtNivel2ClientesmqId) {
        this.txtNivel2ClientesmqId = txtNivel2ClientesmqId;
    }

    public InputText getTxtNivel4ClientesmqId() {
        return txtNivel4ClientesmqId;
    }

    public void setTxtNivel4ClientesmqId(InputText txtNivel4ClientesmqId) {
        this.txtNivel4ClientesmqId = txtNivel4ClientesmqId;
    }

    public InputText getTxtNumFacturaCompra() {
        return txtNumFacturaCompra;
    }

    public void setTxtNumFacturaCompra(InputText txtNumFacturaCompra) {
        this.txtNumFacturaCompra = txtNumFacturaCompra;
    }

    public InputText getTxtOperarioEquipoId() {
        return txtOperarioEquipoId;
    }

    public void setTxtOperarioEquipoId(InputText txtOperarioEquipoId) {
        this.txtOperarioEquipoId = txtOperarioEquipoId;
    }

    public InputText getTxtOrigenDatos() {
        return txtOrigenDatos;
    }

    public void setTxtOrigenDatos(InputText txtOrigenDatos) {
        this.txtOrigenDatos = txtOrigenDatos;
    }

    public InputText getTxtPorcIva() {
        return txtPorcIva;
    }

    public void setTxtPorcIva(InputText txtPorcIva) {
        this.txtPorcIva = txtPorcIva;
    }

    public InputText getTxtRegistroIca() {
        return txtRegistroIca;
    }

    public void setTxtRegistroIca(InputText txtRegistroIca) {
        this.txtRegistroIca = txtRegistroIca;
    }

    public InputText getTxtTipoMovimiento() {
        return txtTipoMovimiento;
    }

    public void setTxtTipoMovimiento(InputText txtTipoMovimiento) {
        this.txtTipoMovimiento = txtTipoMovimiento;
    }

    public InputText getTxtTransportadoraFactura() {
        return txtTransportadoraFactura;
    }

    public void setTxtTransportadoraFactura(InputText txtTransportadoraFactura) {
        this.txtTransportadoraFactura = txtTransportadoraFactura;
    }

    public InputText getTxtTransportadoraNguia() {
        return txtTransportadoraNguia;
    }

    public void setTxtTransportadoraNguia(InputText txtTransportadoraNguia) {
        this.txtTransportadoraNguia = txtTransportadoraNguia;
    }

    public InputText getTxtTransportadoraValorFlete() {
        return txtTransportadoraValorFlete;
    }

    public void setTxtTransportadoraValorFlete(
        InputText txtTransportadoraValorFlete) {
        this.txtTransportadoraValorFlete = txtTransportadoraValorFlete;
    }

    public InputText getTxtUbicacionAlmacen() {
        return txtUbicacionAlmacen;
    }

    public void setTxtUbicacionAlmacen(InputText txtUbicacionAlmacen) {
        this.txtUbicacionAlmacen = txtUbicacionAlmacen;
    }

    public InputText getTxtUbicacionesAlmacenId() {
        return txtUbicacionesAlmacenId;
    }

    public void setTxtUbicacionesAlmacenId(InputText txtUbicacionesAlmacenId) {
        this.txtUbicacionesAlmacenId = txtUbicacionesAlmacenId;
    }

    public InputText getTxtUnidadMedida() {
        return txtUnidadMedida;
    }

    public void setTxtUnidadMedida(InputText txtUnidadMedida) {
        this.txtUnidadMedida = txtUnidadMedida;
    }

    public InputText getTxtUsuarioDigitacion() {
        return txtUsuarioDigitacion;
    }

    public void setTxtUsuarioDigitacion(InputText txtUsuarioDigitacion) {
        this.txtUsuarioDigitacion = txtUsuarioDigitacion;
    }

    public InputText getTxtValorIva() {
        return txtValorIva;
    }

    public void setTxtValorIva(InputText txtValorIva) {
        this.txtValorIva = txtValorIva;
    }

    public InputText getTxtValorUnitario() {
        return txtValorUnitario;
    }

    public void setTxtValorUnitario(InputText txtValorUnitario) {
        this.txtValorUnitario = txtValorUnitario;
    }

    public InputText getTxtVariedId() {
        return txtVariedId;
    }

    public void setTxtVariedId(InputText txtVariedId) {
        this.txtVariedId = txtVariedId;
    }

    public InputText getTxtDatOtrosMovInventarioId_DatOtrosMovInventario() {
        return txtDatOtrosMovInventarioId_DatOtrosMovInventario;
    }

    public void setTxtDatOtrosMovInventarioId_DatOtrosMovInventario(
        InputText txtDatOtrosMovInventarioId_DatOtrosMovInventario) {
        this.txtDatOtrosMovInventarioId_DatOtrosMovInventario = txtDatOtrosMovInventarioId_DatOtrosMovInventario;
    }

    public InputText getTxtNivel2Id_Nivel2() {
        return txtNivel2Id_Nivel2;
    }

    public void setTxtNivel2Id_Nivel2(InputText txtNivel2Id_Nivel2) {
        this.txtNivel2Id_Nivel2 = txtNivel2Id_Nivel2;
    }

    public InputText getTxtNivel4Id_Nivel4() {
        return txtNivel4Id_Nivel4;
    }

    public void setTxtNivel4Id_Nivel4(InputText txtNivel4Id_Nivel4) {
        this.txtNivel4Id_Nivel4 = txtNivel4Id_Nivel4;
    }

    public InputText getTxtPersEmprId_PersEmpr() {
        return txtPersEmprId_PersEmpr;
    }

    public void setTxtPersEmprId_PersEmpr(InputText txtPersEmprId_PersEmpr) {
        this.txtPersEmprId_PersEmpr = txtPersEmprId_PersEmpr;
    }

    public InputText getTxtProductoId_Producto() {
        return txtProductoId_Producto;
    }

    public void setTxtProductoId_Producto(InputText txtProductoId_Producto) {
        this.txtProductoId_Producto = txtProductoId_Producto;
    }

    public InputText getTxtTrabId_Trabajador() {
        return txtTrabId_Trabajador;
    }

    public void setTxtTrabId_Trabajador(InputText txtTrabId_Trabajador) {
        this.txtTrabId_Trabajador = txtTrabId_Trabajador;
    }

    public Calendar getTxtFechaCreacion() {
        return txtFechaCreacion;
    }

    public void setTxtFechaCreacion(Calendar txtFechaCreacion) {
        this.txtFechaCreacion = txtFechaCreacion;
    }

    public Calendar getTxtFechaFinal() {
        return txtFechaFinal;
    }

    public void setTxtFechaFinal(Calendar txtFechaFinal) {
        this.txtFechaFinal = txtFechaFinal;
    }

    public Calendar getTxtFechaInicial() {
        return txtFechaInicial;
    }

    public void setTxtFechaInicial(Calendar txtFechaInicial) {
        this.txtFechaInicial = txtFechaInicial;
    }

    public Calendar getTxtFechaModificacion() {
        return txtFechaModificacion;
    }

    public void setTxtFechaModificacion(Calendar txtFechaModificacion) {
        this.txtFechaModificacion = txtFechaModificacion;
    }

    public Calendar getTxtFechaVencimiento() {
        return txtFechaVencimiento;
    }

    public void setTxtFechaVencimiento(Calendar txtFechaVencimiento) {
        this.txtFechaVencimiento = txtFechaVencimiento;
    }

    public InputText getTxtPrecioPromMateriaPrimaId() {
        return txtPrecioPromMateriaPrimaId;
    }

    public void setTxtPrecioPromMateriaPrimaId(
        InputText txtPrecioPromMateriaPrimaId) {
        this.txtPrecioPromMateriaPrimaId = txtPrecioPromMateriaPrimaId;
    }

    public List<PrecioPromMateriaPrimaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegator2View.getDataPrecioPromMateriaPrima();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(
        List<PrecioPromMateriaPrimaDTO> precioPromMateriaPrimaDTO) {
        this.data = precioPromMateriaPrimaDTO;
    }

    public PrecioPromMateriaPrimaDTO getSelectedPrecioPromMateriaPrima() {
        return selectedPrecioPromMateriaPrima;
    }

    public void setSelectedPrecioPromMateriaPrima(
        PrecioPromMateriaPrimaDTO precioPromMateriaPrima) {
        this.selectedPrecioPromMateriaPrima = precioPromMateriaPrima;
    }

    public CommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(CommandButton btnSave) {
        this.btnSave = btnSave;
    }

    public CommandButton getBtnModify() {
        return btnModify;
    }

    public void setBtnModify(CommandButton btnModify) {
        this.btnModify = btnModify;
    }

    public CommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(CommandButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public CommandButton getBtnClear() {
        return btnClear;
    }

    public void setBtnClear(CommandButton btnClear) {
        this.btnClear = btnClear;
    }

    public TimeZone getTimeZone() {
        return java.util.TimeZone.getDefault();
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

    public void setBusinessDelegator2View(
        IBusinessDelegator2View businessDelegator2View) {
        this.businessDelegator2View = businessDelegator2View;
    }

    public boolean isShowDialog() {
        return showDialog;
    }

    public void setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
    }
}
