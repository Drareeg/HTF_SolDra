package solmovdrareeg.htf_soldra.model;

/**
 * Created by Dries on 11/12/2014.
 */
public class LegendaEntry {
    private int image;
    private String description;

    public LegendaEntry(){}

    public LegendaEntry(int image, String description){
        setImage(image);
        setDescription(description);
    };

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
