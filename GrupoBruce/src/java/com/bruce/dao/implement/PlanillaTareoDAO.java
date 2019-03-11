/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IPlanillaTareoDAO;
import com.bruce.dao.to.PlanillaTareo;
import com.bruce.util.FilterPage;
import com.bruce.util.ReverseQuery;
import com.bruce.util.SortPage;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SISTEMAS
 */
@Repository
public class PlanillaTareoDAO implements IPlanillaTareoDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public void create(PlanillaTareo t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(PlanillaTareo t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(PlanillaTareo t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public PlanillaTareo get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PlanillaTareo lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("ASISTENCIA", "A");
        reverse.addResult("PP.ID_PPLANILLA");
        reverse.addResult("A.ID_TRABAJADOR");
        reverse.addResult("T.AP_PATERNO + ' ' + T.AP_MATERNO + ' ' + T.NOMBRES TRABAJADOR");
        reverse.addResult("T.HABER_BASICO");
        reverse.addResult("PP.DIAS_PERIODO PRP_DIAS_PER");
        reverse.addResult("SUM(CASE WHEN A.ASISTIO = 1 THEN 1 ELSE 0 END) PRP_DIAS_TRAB");
        reverse.addResult("SUM(A.HRS_DSCTO) NUM_H_DESCT");
        reverse.addResult("SUM(CASE WHEN A.STD_EXTRA = 1 THEN A.HRS_EXTRA ELSE 0 END) NUM_H_EXT25");
        reverse.addResult("SUM(CASE WHEN A.STD_EXTRA = 0 THEN A.HRS_EXTRA ELSE 0 END) NUM_H_EXT35");
        reverse.addResult("SUM(CASE WHEN AL.EN_COMEDOR = 1 THEN AL.COSTO ELSE 0 END) OTROS_DESCT");
        reverse.addResult("CASE WHEN TT.JORNAL_DIARIO = 1 THEN 0 ELSE T.HABER_BASICO/2 END ADELANTO");
        reverse.addResult("ISNULL((SELECT TOP 1 CASE WHEN P.MPRESTADO > P.MPAGADO THEN (CASE WHEN P.MPRESTADO - P.MPAGADO > P.PAGO_CUOTA THEN P.PAGO_CUOTA ELSE P.MPRESTADO - P.MPAGADO END) ELSE 1 END FROM PRESTAMO P WHERE P.ID_TRABAJADOR = A.ID_TRABAJADOR),0) PRESTAMO");
        reverse.addResult("T.MONTO_PASAJE MOVILIDAD");
        reverse.addResult("0 REINTEGRO");
        reverse.addResult("0 DEVOLUCION");
        reverse.addResult("CASE WHEN (SELECT COUNT(*) FROM HIJO H WHERE H.ID_TRABAJADOR=A.ID_TRABAJADOR) > 0 THEN 1 ELSE 0 END FLAG_ASIG");
        reverse.addResult("CASE WHEN T.ID_COMISIONRP IS NULL THEN 0 ELSE 1 END FLAG_AFP");
        reverse.addResult("EM.BASICO EMP_RMV");
        reverse.addResult("DATEDIFF(DAY,PP.INI_PLAME,PP.FIN_PLAME) + 1 DIAS_PLAME");
        reverse.addResult("0 APROBADO");
        reverse.addResult("0 PROCESADO");
        reverse.addJoin("INNER JOIN TRABAJADOR T", "T.ID_TRABAJADOR = A.ID_TRABAJADOR");
        reverse.addJoin("INNER JOIN EMPRESA EM", "EM.ID_EMPRESA = T.ID_EMPRESA");
        reverse.addJoin("INNER JOIN TIPO_TRABAJADOR TT", "TT.ID_TTRABAJADOR = T.ID_TTRABAJADOR");
        reverse.addJoin("INNER JOIN PERIODO_PLANILLA PP", "PP.ID_TTRABAJADOR = T.ID_TTRABAJADOR AND A.FECHA BETWEEN PP.INICIO AND PP.FIN");
        reverse.addJoin("LEFT JOIN ALMUERZO AL", "AL.ID_TRABAJADOR = A.ID_TRABAJADOR AND AL.FECHA = A.FECHA");
        reverse.setFilters(filters);
        reverse.setGroup("A.ID_TRABAJADOR,T.MONTO_PASAJE,T.AP_PATERNO,T.AP_MATERNO,T.NOMBRES,T.ID_COMISIONRP,T.HABER_BASICO,TT.PENSION,TT.JORNAL_DIARIO,PP.DIAS_PERIODO,PP.ID_PPLANILLA,EM.BASICO,PP.INI_PLAME,PP.FIN_PLAME");
        reverse.getLSorts().add(new SortPage("ID_TRABAJADOR", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(PlanillaTareo.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        PlanillaTareo planillaTareo = !result.isEmpty() ? (PlanillaTareo) result.get(0) : null;
        return planillaTareo;
    }

    @Override
    public List<PlanillaTareo> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PlanillaTareo> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("PLANILLA_TAREO", "PT");
        reverse.addResult("PT.ID_PPLANILLA");
        reverse.addResult("PT.ID_TRABAJADOR");
        reverse.addResult("T.AP_PATERNO + ' ' + T.AP_MATERNO + ' ' + T.NOMBRES TRABAJADOR");
        reverse.addResult("PT.HABER_BASICO");
        reverse.addResult("PT.PRP_DIAS_PER");
        reverse.addResult("PT.PRP_DIAS_TRAB");
        reverse.addResult("PT.NUM_H_DESCT");
        reverse.addResult("PT.NUM_H_EXT25");
        reverse.addResult("PT.NUM_H_EXT35");
        reverse.addResult("PT.OTROS_DESCT");
        reverse.addResult("PT.ADELANTO");
        reverse.addResult("PT.PRESTAMO");
        reverse.addResult("PT.MOVILIDAD");
        reverse.addResult("PT.REINTEGRO");
        reverse.addResult("PT.DEVOLUCION");
        reverse.addResult("PT.FLAG_ASIG");
        reverse.addResult("PT.FLAG_AFP");
        reverse.addResult("PT.DIAS_PLAME");
        reverse.addResult("PT.EMP_RMV");
        reverse.addResult("PT.APROBADO");
        reverse.addResult("PT.PROCESADO");
        reverse.addJoin("INNER JOIN TRABAJADOR T", "T.ID_TRABAJADOR = PT.ID_TRABAJADOR");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(PlanillaTareo.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        return query.list();
    }

    @Override
    public int countByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("PLANILLA_TAREO", "PT");
        reverse.addResult("PT.ID_PPLANILLA");
        reverse.setFilters(filters);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        return result.size();
    }

    @Override
    public List<PlanillaTareo> getByCFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("ASISTENCIA", "A");
        reverse.addResult("PP.ID_PPLANILLA");
        reverse.addResult("A.ID_TRABAJADOR");
        reverse.addResult("T.AP_PATERNO + ' ' + T.AP_MATERNO + ' ' + T.NOMBRES TRABAJADOR");
        reverse.addResult("T.HABER_BASICO");
        reverse.addResult("PP.DIAS_PERIODO PRP_DIAS_PER");
        reverse.addResult("SUM(CASE WHEN A.ASISTIO = 1 THEN 1 ELSE 0 END) PRP_DIAS_TRAB");
        reverse.addResult("SUM(A.HRS_DSCTO) NUM_H_DESCT");
        reverse.addResult("SUM(CASE WHEN A.STD_EXTRA = 1 THEN A.HRS_EXTRA ELSE 0 END) NUM_H_EXT25");
        reverse.addResult("SUM(CASE WHEN A.STD_EXTRA = 0 THEN A.HRS_EXTRA ELSE 0 END) NUM_H_EXT35");
        reverse.addResult("SUM(CASE WHEN AL.EN_COMEDOR = 1 THEN AL.COSTO ELSE 0 END) OTROS_DESCT");
        reverse.addResult("CASE WHEN TT.JORNAL_DIARIO = 1 THEN 0 ELSE T.HABER_BASICO/2 END ADELANTO");
        reverse.addResult("ISNULL((SELECT TOP 1 CASE WHEN P.MPRESTADO > P.MPAGADO THEN (CASE WHEN P.MPRESTADO - P.MPAGADO > P.PAGO_CUOTA THEN P.PAGO_CUOTA ELSE P.MPRESTADO - P.MPAGADO END) ELSE 1 END FROM PRESTAMO P WHERE P.ID_TRABAJADOR = A.ID_TRABAJADOR),0) PRESTAMO");
        reverse.addResult("T.MONTO_PASAJE MOVILIDAD");
        reverse.addResult("0 REINTEGRO");
        reverse.addResult("0 DEVOLUCION");
        reverse.addResult("CASE WHEN (SELECT COUNT(*) FROM HIJO H WHERE H.ID_TRABAJADOR=A.ID_TRABAJADOR) > 0 THEN 1 ELSE 0 END FLAG_ASIG");
        reverse.addResult("CASE WHEN T.ID_COMISIONRP IS NULL THEN 0 ELSE 1 END FLAG_AFP");
        reverse.addResult("EM.BASICO EMP_RMV");
        reverse.addResult("DATEDIFF(DAY,PP.INI_PLAME,PP.FIN_PLAME) + 1 DIAS_PLAME");
        reverse.addResult("0 APROBADO");
        reverse.addResult("0 PROCESADO");
        reverse.addJoin("INNER JOIN TRABAJADOR T", "T.ID_TRABAJADOR = A.ID_TRABAJADOR");
        reverse.addJoin("INNER JOIN EMPRESA EM", "EM.ID_EMPRESA = T.ID_EMPRESA");
        reverse.addJoin("INNER JOIN TIPO_TRABAJADOR TT", "TT.ID_TTRABAJADOR = T.ID_TTRABAJADOR");
        reverse.addJoin("INNER JOIN PERIODO_PLANILLA PP", "PP.ID_TTRABAJADOR = T.ID_TTRABAJADOR AND A.FECHA BETWEEN PP.INICIO AND PP.FIN");
        reverse.addJoin("LEFT JOIN ALMUERZO AL", "AL.ID_TRABAJADOR = A.ID_TRABAJADOR AND AL.FECHA = A.FECHA");
        reverse.setFilters(filters);
        reverse.setGroup("A.ID_TRABAJADOR,T.MONTO_PASAJE,T.AP_PATERNO,T.AP_MATERNO,T.NOMBRES,T.ID_COMISIONRP,T.HABER_BASICO,TT.PENSION,TT.JORNAL_DIARIO,PP.DIAS_PERIODO,PP.ID_PPLANILLA,EM.BASICO,PP.INI_PLAME,PP.FIN_PLAME");
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(PlanillaTareo.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        return query.list();
    }

    @Override
    public int countByCFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("ASISTENCIA", "A");
        reverse.addResult("PP.ID_PPLANILLA");
        reverse.addJoin("INNER JOIN TRABAJADOR T", "T.ID_TRABAJADOR = A.ID_TRABAJADOR");
        reverse.addJoin("INNER JOIN EMPRESA EM", "EM.ID_EMPRESA = T.ID_EMPRESA");
        reverse.addJoin("INNER JOIN TIPO_TRABAJADOR TT", "TT.ID_TTRABAJADOR = T.ID_TTRABAJADOR");
        reverse.addJoin("INNER JOIN PERIODO_PLANILLA PP", "PP.ID_TTRABAJADOR = T.ID_TTRABAJADOR AND A.FECHA BETWEEN PP.INICIO AND PP.FIN");
        reverse.addJoin("LEFT JOIN ALMUERZO AL", "AL.ID_TRABAJADOR = A.ID_TRABAJADOR AND AL.FECHA = A.FECHA");
        reverse.setFilters(filters);
        reverse.setGroup("A.ID_TRABAJADOR,T.MONTO_PASAJE,T.AP_PATERNO,T.AP_MATERNO,T.NOMBRES,T.ID_COMISIONRP,T.HABER_BASICO,TT.PENSION,TT.JORNAL_DIARIO,PP.DIAS_PERIODO,PP.ID_PPLANILLA,EM.BASICO,PP.INI_PLAME,PP.FIN_PLAME");
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        return result.size();
    }

}
