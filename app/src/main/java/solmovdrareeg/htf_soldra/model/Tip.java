package solmovdrareeg.htf_soldra.model;

/**
 * Created by Dries on 11/12/2014.
 */
public class Tip {
    private String title;
    private String description;

    public Tip(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
