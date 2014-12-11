package solmovdrareeg.htf_soldra.model;

/**
 * Created by Drareeg on 11.12.14.
 */
public class CityList {

    public City[] items;
    public String kind;
    public String etag;


    public City[] getItems() {
        return items;
    }

    public void setItems(City[] items) {
        this.items = items;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }
}
