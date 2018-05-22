package package01.validate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import package01.common.Common;
import package01.dao.TblAdminDAO;

@Service
@PropertySource(value = "classpath:properties/login.properties", encoding = "UTF-8")
public class LoginValidate {

    @Autowired
    private TblAdminDAO tblAdminDAO;

    @Autowired
    private Environment envi;

    public List<String> checkLogin(String loginname, String password) {
        List<String> listErr = new ArrayList<>();

        if ("".equals(loginname)) {
            listErr.add(envi.getProperty("err.loginname"));
        }
        if ("".equals(password)) {
            listErr.add(envi.getProperty("err.password"));
        } else if (!"".equals(loginname) && !checkAdmin(loginname, password)) {
            listErr.add(envi.getProperty("err.login"));

        }
        return listErr;
    }

    public boolean checkAdmin(String loginname, String password) {
        String loginnameDB = tblAdminDAO.getTblAdmin().getUsername();
        String passwordDB = tblAdminDAO.getTblAdmin().getPassword();
        String passwordEcryp = Common.md5(password);
        if (loginnameDB.equals(loginname) && passwordDB.equals(passwordEcryp))
            return true;
        else {
            return false;
        }
    }
}
