package solmovdrareeg.htf_soldra.model;

/**
 * Created by Drareeg on 11.12.14.
 */
public class City {

    private long id;
    private String name;
    private int zipcode;
    private String procince;
    private String alertCode;
    private String kind;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getProcince() {
        return procince;
    }

    public void setProcince(String procince) {
        this.procince = procince;
    }

    public String getAlertCode() {
        return alertCode;
    }

    public void setAlertCode(String alertCode) {
        this.alertCode = alertCode;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
