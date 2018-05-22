package package01.dao;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import package01.entity.TblAdmin;

@Repository
public class TblAdminDAO {

    @Autowired
    private EntityManager entityManager;

    public TblAdmin getTblAdmin() {
        String sql = "FROM " + TblAdmin.class.getName();
        return (TblAdmin) entityManager.createQuery(sql).getSingleResult();
    }

}
