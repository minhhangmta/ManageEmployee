package package01.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import package01.entity.TblDepartment;
import package01.model.TblDepartmentInfo;

@Repository
public class TblDepartmentDAO {

    @Autowired
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<TblDepartmentInfo> getListTblCompanyInfo() {
        String sql = "SELECT new " + TblDepartmentInfo.class.getName() + " (dpm.department_id, dpm.department) "
                + " FROM " + TblDepartment.class.getName() + " dpm ORDER BY dpm.department_id";
        Query query = entityManager.createQuery(sql, TblDepartmentInfo.class);
        return query.getResultList();

    }
}
