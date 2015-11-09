package data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Collection;

/**
 * Created by Olga Pavlova on 11/9/2015.
 */
@Entity
public class Parent {
    private int idParent;
    private String name;
    private Collection<Child> child;

    public Collection<Child> getChild() {
        return child;
    }

    public void setChild(Collection<Child> child) {
        this.child = child;
    }

    @Id
    @Column(name = "ID_PARENT", nullable = false)
    public int getIdParent() {
        return idParent;
    }

    public void setIdParent(int id) {
        this.idParent = id;
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
}
