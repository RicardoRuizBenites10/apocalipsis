/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory.hibernate;

import dao.design.hibernate.IAccesoDAO;
import dao.design.hibernate.IAfiliacionDAO;
import dao.design.hibernate.IAreaDAO;
import dao.design.hibernate.ICargoContratoDAO;
import dao.design.hibernate.ICargoDAO;
import dao.design.hibernate.ICategoriaOcupacionalDAO;
import dao.design.hibernate.IContratoTrabajadorDAO;
import dao.design.hibernate.ICuentaCtsDAO;
import dao.design.hibernate.ICuentaSueldoDAO;
import dao.design.hibernate.IECivilDAO;
import dao.design.hibernate.IEmpresaDAO;
import dao.design.hibernate.IEntidadFinancieraDAO;
import dao.design.hibernate.IEstadoContratoDAO;
import dao.design.hibernate.IEstadoEstudioDAO;
import dao.design.hibernate.IEstadoTrabajadorDAO;
import dao.design.hibernate.IFormaPagoDAO;
import dao.design.hibernate.IFormacionDAO;
import dao.design.hibernate.IGeneroDAO;
import dao.design.hibernate.IHijoDAO;
import dao.design.hibernate.IMenuDAO;
import dao.design.hibernate.INacionalidadDAO;
import dao.design.hibernate.IPeriocidadDAO;
import dao.design.hibernate.IPeriodoDAO;
import dao.design.hibernate.IRegimenPensionarioDAO;
import dao.design.hibernate.IRemuneracionDAO;
import dao.design.hibernate.ISubareaDAO;
import dao.design.hibernate.ISucursalDAO;
import dao.design.hibernate.ITiempoContratoDAO;
import dao.design.hibernate.ITipoContratoDAO;
import dao.design.hibernate.ITipoDocumentoDAO;
import dao.design.hibernate.ITipoEstudioDAO;
import dao.design.hibernate.ITipoPeriodoDAO;
import dao.design.hibernate.ITipoTExtraDAO;
import dao.design.hibernate.ITipoTrabajadorDAO;
import dao.design.hibernate.ITrabajadorDAO;
import dao.design.hibernate.IUsuarioDAO;
import dao.design.hibernate.IVacacionDAO;
import dao.implement.hibernate.AccesoDAO;
import dao.implement.hibernate.AfiliacionDAO;
import dao.implement.hibernate.AreaDAO;
import dao.implement.hibernate.CargoContratoDAO;
import dao.implement.hibernate.CargoDAO;
import dao.implement.hibernate.CategoriaOcupacionalDAO;
import dao.implement.hibernate.ContratoTrabajadorDAO;
import dao.implement.hibernate.CuentaCtsDAO;
import dao.implement.hibernate.CuentaSueldoDAO;
import dao.implement.hibernate.ECivilDAO;
import dao.implement.hibernate.EmpresaDAO;
import dao.implement.hibernate.EntidadFinancieraDAO;
import dao.implement.hibernate.EstadoContratoDAO;
import dao.implement.hibernate.EstadoEstudioDAO;
import dao.implement.hibernate.EstadoTrabajadorDAO;
import dao.implement.hibernate.FormaPagoDAO;
import dao.implement.hibernate.FormacionDAO;
import dao.implement.hibernate.GeneroDAO;
import dao.implement.hibernate.HijoDAO;
import dao.implement.hibernate.MenuDAO;
import dao.implement.hibernate.NacionalidadDAO;
import dao.implement.hibernate.PeriocidadDAO;
import dao.implement.hibernate.PeriodoDAO;
import dao.implement.hibernate.RegimenPensionarioDAO;
import dao.implement.hibernate.RemuneracionDAO;
import dao.implement.hibernate.SubareaDAO;
import dao.implement.hibernate.SucursalDAO;
import dao.implement.hibernate.TiempoContratoDAO;
import dao.implement.hibernate.TipoContratoDAO;
import dao.implement.hibernate.TipoDocumentoDAO;
import dao.implement.hibernate.TipoEstudioDAO;
import dao.implement.hibernate.TipoPeriodoDAO;
import dao.implement.hibernate.TipoTExtraDAO;
import dao.implement.hibernate.TipoTrabajadorDAO;
import dao.implement.hibernate.TrabajadorDAO;
import dao.implement.hibernate.UsuarioDAO;
import dao.implement.hibernate.VacacionDAO;

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
