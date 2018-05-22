package package01.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import package01.entity.Employee;
import package01.model.EmployeeInfo;

@Repository
@Transactional
public class TblUserDAO {
    private StringBuilder sql;
    @Autowired
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<EmployeeInfo> getListUserInfo() {
        sql = new StringBuilder();
        sql.append(" FROM ");
        sql.append(Employee.class.getName());

        Query query = entityManager.createQuery(sql.toString());
        return query.getResultList();
    }

}
