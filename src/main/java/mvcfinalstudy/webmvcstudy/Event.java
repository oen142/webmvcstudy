package mvcfinalstudy.webmvcstudy;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Event {

    private Integer id;

    @NotBlank
    private String name;

    @Min(value = 0)
    private Long limit;

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
