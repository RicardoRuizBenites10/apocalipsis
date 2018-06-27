/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory.hibernate;

import com.bruce.dao.design.IAccesoDAO;
import com.bruce.dao.design.IAfiliacionDAO;
import com.bruce.dao.design.IAreaDAO;
import com.bruce.dao.design.ICargoContratoDAO;
import com.bruce.dao.design.ICargoDAO;
import com.bruce.dao.design.ICategoriaOcupacionalDAO;
import com.bruce.dao.design.IContratoTrabajadorDAO;
import com.bruce.dao.design.ICuentaCtsDAO;
import com.bruce.dao.design.ICuentaSueldoDAO;
import com.bruce.dao.design.IECivilDAO;
import com.bruce.dao.design.IEmpresaDAO;
import com.bruce.dao.design.IEntidadFinancieraDAO;
import com.bruce.dao.design.IEstadoContratoDAO;
import com.bruce.dao.design.IEstadoEstudioDAO;
import com.bruce.dao.design.IEstadoTrabajadorDAO;
import com.bruce.dao.design.IFormaPagoDAO;
import com.bruce.dao.design.IFormacionDAO;
import com.bruce.dao.design.IGeneroDAO;
import com.bruce.dao.design.IHijoDAO;
import com.bruce.dao.design.IMenuDAO;
import com.bruce.dao.design.INacionalidadDAO;
import com.bruce.dao.design.IPeriocidadDAO;
import com.bruce.dao.design.IPeriodoDAO;
import com.bruce.dao.design.IRegimenPensionarioDAO;
import com.bruce.dao.design.IRemuneracionDAO;
import com.bruce.dao.design.ISubareaDAO;
import com.bruce.dao.design.ISucursalDAO;
import com.bruce.dao.design.ITiempoContratoDAO;
import com.bruce.dao.design.ITipoContratoDAO;
import com.bruce.dao.design.ITipoDocumentoDAO;
import com.bruce.dao.design.ITipoEstudioDAO;
import com.bruce.dao.design.ITipoPeriodoDAO;
import com.bruce.dao.design.ITipoTExtraDAO;
import com.bruce.dao.design.ITipoTrabajadorDAO;
import com.bruce.dao.design.ITrabajadorDAO;
import com.bruce.dao.design.IUsuarioDAO;
import com.bruce.dao.design.IVacacionDAO;
import com.bruce.dao.implement.AccesoDAO;
import com.bruce.dao.implement.AfiliacionDAO;
import com.bruce.dao.implement.AreaDAO;
import com.bruce.dao.implement.CargoContratoDAO;
import com.bruce.dao.implement.CargoDAO;
import com.bruce.dao.implement.CategoriaOcupacionalDAO;
import com.bruce.dao.implement.ContratoTrabajadorDAO;
import com.bruce.dao.implement.CuentaCtsDAO;
import com.bruce.dao.implement.CuentaSueldoDAO;
import com.bruce.dao.implement.ECivilDAO;
import com.bruce.dao.implement.EmpresaDAO;
import com.bruce.dao.implement.EntidadFinancieraDAO;
import com.bruce.dao.implement.EstadoContratoDAO;
import com.bruce.dao.implement.EstadoEstudioDAO;
import com.bruce.dao.implement.EstadoTrabajadorDAO;
import com.bruce.dao.implement.FormaPagoDAO;
import com.bruce.dao.implement.FormacionDAO;
import com.bruce.dao.implement.GeneroDAO;
import com.bruce.dao.implement.HijoDAO;
import com.bruce.dao.implement.MenuDAO;
import com.bruce.dao.implement.NacionalidadDAO;
import com.bruce.dao.implement.PeriocidadDAO;
import com.bruce.dao.implement.PeriodoDAO;
import com.bruce.dao.implement.RegimenPensionarioDAO;
import com.bruce.dao.implement.RemuneracionDAO;
import com.bruce.dao.implement.SubareaDAO;
import com.bruce.dao.implement.SucursalDAO;
import com.bruce.dao.implement.TiempoContratoDAO;
import com.bruce.dao.implement.TipoContratoDAO;
import com.bruce.dao.implement.TipoDocumentoDAO;
import com.bruce.dao.implement.TipoEstudioDAO;
import com.bruce.dao.implement.TipoPeriodoDAO;
import com.bruce.dao.implement.TipoTExtraDAO;
import com.bruce.dao.implement.TipoTrabajadorDAO;
import com.bruce.dao.implement.TrabajadorDAO;
import com.bruce.dao.implement.UsuarioDAO;
import com.bruce.dao.implement.VacacionDAO;

/**
 *
 * @author SISTEMAS
 */
public class FactoryDAO {
    
    private FactoryDAO() {
    }
    
    public static FactoryDAO getInstance() {
        return FactoryDAOHolder.INSTANCE;
    }
    
    private static class FactoryDAOHolder {
        private static final FactoryDAO INSTANCE = new FactoryDAO();
    }
    
    public IUsuarioDAO getUsuarioDAO(){
        return new UsuarioDAO();
    }
    
    public IAreaDAO getAreaDAO(){
        return new AreaDAO();
    }
    
    public ISubareaDAO getSubareaDAO(){
        return new SubareaDAO();
    }
    
    public ICargoDAO getCargoDAO(){
        return new CargoDAO();
    }
    
    public ITrabajadorDAO getTrabajadorDAO(){
        return new TrabajadorDAO();
    }
    
    public IContratoTrabajadorDAO getContratoTrabajadorDAO(){
        return new ContratoTrabajadorDAO();
    }
    
    public ITipoTrabajadorDAO getTipoTrabajadorDAO(){
        return new TipoTrabajadorDAO();
    }
    
    public ITipoContratoDAO getTipoContratoDAO(){
        return new TipoContratoDAO();
    }
    
    public IFormaPagoDAO getTipoPagoDAO(){
        return new FormaPagoDAO();
    }
    
    public IEstadoTrabajadorDAO getEstadoTrabajadorDAO(){
        return new EstadoTrabajadorDAO();
    }
    
    public IEstadoContratoDAO getEstadoContratoDAO(){
        return new EstadoContratoDAO();
    }
    
    public IFormacionDAO getFormacionDAO(){
        return new FormacionDAO();
    }
    
    public IEntidadFinancieraDAO getEntidadFinancieraDAO(){
        return new EntidadFinancieraDAO();
    }
    
    public IAfiliacionDAO getAfiliacionDAO(){
        return new AfiliacionDAO();
    }
    
    public ICuentaCtsDAO getCuentaCtsDAO(){
        return new CuentaCtsDAO();
    }
    
    public IEmpresaDAO getEmpresaDAO(){
        return new EmpresaDAO();
    }
    
    public IGeneroDAO getGeneroDAO(){
        return new GeneroDAO();
    }
    
    public IECivilDAO getECivilDAO(){
        return new ECivilDAO();
    }
    
    public ICategoriaOcupacionalDAO getCategoriaOcupacionDAO(){
        return new CategoriaOcupacionalDAO();
    }
    
    public INacionalidadDAO getNacionalidadDAO(){
        return new NacionalidadDAO();
    }
    
    public ISucursalDAO getSucursalDAO(){
        return new SucursalDAO();
    }
    
    public ICuentaSueldoDAO getCuentaSueldoDAO(){
        return new CuentaSueldoDAO();
    }
    
    public ITipoEstudioDAO getTipoEstudioDAO(){
        return new TipoEstudioDAO();
    }
    
    public IEstadoEstudioDAO getEstadoEstudioDAO(){
        return new EstadoEstudioDAO();
    }
    
    public IRegimenPensionarioDAO getRegimenPensionarioDAO(){
        return new RegimenPensionarioDAO();
    }
    
    public IMenuDAO getMenuDAO(){
        return new MenuDAO();
    }
    
    public IPeriodoDAO getPeriodoDAO(){
        return new PeriodoDAO();
    }
    
    public ITipoTExtraDAO getTipoTExtra(){
        return new TipoTExtraDAO();
    }
    
    public IHijoDAO getHijoDAO(){
        return new HijoDAO();
    }
    
    public IFormaPagoDAO getFormaPagoDAO(){
        return new FormaPagoDAO();
    }
    
    public IPeriocidadDAO getPeriocidadDAO(){
        return new PeriocidadDAO();
    }
    
    public IRemuneracionDAO getRemuneracionDAO(){
        return new RemuneracionDAO();
    }
    
    public ICargoContratoDAO getCargoContratoDAO(){
        return new CargoContratoDAO();
    }
    
    public IAccesoDAO getAccesoDAO(){
        return new AccesoDAO();
    }
    
    public ITipoDocumentoDAO getTipoDocumentoDAO(){
        return new TipoDocumentoDAO();
    }
    
    public ITiempoContratoDAO getTiempoContratoDAO(){
        return new TiempoContratoDAO();
    }
    
    public ITipoPeriodoDAO getTipoPeriodoDAO(){
        return new TipoPeriodoDAO();
    }
    
    public IVacacionDAO getVacacionDAO(){
        return new VacacionDAO();
    }
    
}
