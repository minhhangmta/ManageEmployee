package package01.common;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Common {

    /**
     * Hàm chuyển string null thành ""
     * 
     * @param stringInput
     *            chuỗi nhập vào
     * @return stringInput fixed
     */
    public static String convertStringNull(String stringInput) {
        if (stringInput == null) {
            stringInput = "";
        }
        return stringInput;
    }

    /**
     * Hàm mã hóa mật khẩu
     * 
     * @param password
     *            mật khẩu nhập vào
     * @return passwordEncrypted1 mật khẩu đã được mã hóa lần 1
     */
    public static String md5(String password) {
        String passwordEncrypted = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] encryptText = md.digest(password.getBytes());
            BigInteger bigInt = new BigInteger(1, encryptText);
            passwordEncrypted = bigInt.toString(16).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Lỗi mã hóa");
        }
        return passwordEncrypted;
    }

    public static String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateFormated = dateFormat.format(date);
        return dateFormated;

    }

    /**
     * Hàm chuyển string thành int
     * 
     * @param stringInput
     *            chuỗi string truyền vào
     * @param defaultValue
     *            giá trị mặc định nếu chuyển kiểu bị lỗi
     * @return intOutput giá trị kiểu int
     */
    public static int stringToInt(String stringInput, int defaultValue) {
        int intOutput = defaultValue;
        try {
            intOutput = Integer.parseInt(stringInput);
        } catch (NumberFormatException e) {
            intOutput = defaultValue;
        }
        return intOutput;
    }

    public static int longToInt(long value) {
        if ((int) value != value) {
            throw new ArithmeticException("integer overflow");
        }
        return (int) value;
    }

    public static int getLimit() {
        int limit = 5;
        return limit;
    }

    public static int getOffset(int curentPage, int limit) {
        int offSet = (curentPage - 1) * limit;
        return offSet;
    }

    public static int getTotalPage(int totalUser, int limit) {
        int totalPage = (int) Math.ceil((float) totalUser / limit);
        return totalPage;
    }

    private static int getEndPage(int curentPage, int numPage) {
        int endPage = (int) Math.ceil((double) curentPage / numPage) * numPage;
        return endPage;
    }

    public static List<Integer> getListPage(int totalUser, int limit, int curentPage) {
        int totalPage = getTotalPage(totalUser, limit);
        int numPage = 99;
        int endPage = getEndPage(curentPage, numPage);
        List<Integer> listPage = new ArrayList<Integer>();
        for (int page = endPage - numPage + 1; page <= endPage && page <= totalPage; page++) {
            listPage.add(page);
        }
        return listPage;
    }
}
