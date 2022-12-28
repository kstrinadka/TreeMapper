import java.util.List;
import java.util.Objects;

public class TreeDTO {
    private Integer id;
    private String name;
    private List<TreeDTO> children;

    public TreeDTO() {}

    public TreeDTO(Integer id, String name, List<TreeDTO> children) {
        this.id = id;
        this.name = name;
        this.children = children;
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

    public List<TreeDTO> getChildren() {
        return children;
    }

    public void setChildren(List<TreeDTO> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeDTO treeDTO)) return false;
        return getId().equals(treeDTO.getId()) && getName().equals(treeDTO.getName()) && getChildren().equals(treeDTO.getChildren());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getChildren());
    }

    @Override
    public String toString() {
        return "TreeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", children=" + children +
                '}';
    }
}
