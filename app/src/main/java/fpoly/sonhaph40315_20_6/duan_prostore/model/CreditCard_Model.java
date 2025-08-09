package fpoly.sonhaph40315_20_6.duan_prostore.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CreditCard_Model {
    private int sothe;
    private String ten;
    private long ngayhethan;

    public CreditCard_Model(int sothe, String ten, long ngayhethan) {
        this.sothe = sothe;
        this.ten = ten;
        this.ngayhethan = ngayhethan;
    }

    public int getSothe() {
        return sothe;
    }

    public void setSothe(int sothe) {
        this.sothe = sothe;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public long getNgayhethan() {
        return ngayhethan;
    }

    public void setNgayhethan(long ngayhethan) {
        this.ngayhethan = ngayhethan;
    }
}
