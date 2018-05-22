package package01.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import package01.dao.TblUserDAO;
import package01.model.EmployeeInfo;

@Repository
public class TblUserLogic {

    @Autowired
    private TblUserDAO tblUserDAO;

    public List<EmployeeInfo> getListUserFormated() {
        return tblUserDAO.getListUserInfo();
    }

}
