package a.b;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Olga Pavlova on 1/9/2017.
 */
@Entity
@Table(name = "PARENT")
public class Parent {
    private int idParent;
    private String name;
    private Collection<Child> childrenByIdParent;

    @Id
    @Column(name = "ID_PARENT", nullable = false)
    public int getIdParent() {
        return idParent;
    }

    public void setIdParent(int idParent) {
        this.idParent = idParent;
    }

    @Basic
    @Column(name = "NAME", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parent parent = (Parent) o;

        if (idParent != parent.idParent) return false;
        if (name != null ? !name.equals(parent.name) : parent.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idParent;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "parentByChIdParent")
    public Collection<Child> getChildrenByIdParent() {
        return childrenByIdParent;
    }

    public void setChildrenByIdParent(Collection<Child> childrenByIdParent) {
        this.childrenByIdParent = childrenByIdParent;
    }
}
