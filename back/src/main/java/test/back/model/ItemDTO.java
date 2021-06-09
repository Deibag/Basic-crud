package test.back.model;

import javax.validation.constraints.Size;


public class ItemDTO {

    private Integer id;

    @Size(max = 255)
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

}
