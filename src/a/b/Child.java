package a.b;

import javax.persistence.*;

/**
 * Created by Olga Pavlova on 1/9/2017.
 */
@Entity
@Table(name = "CHILD")
public class Child {
    private int idChild;
    private String nameChild;
    private Integer chIdParent;
    private Parent parentByChIdParent;

    @Id
    @Column(name = "ID_CHILD", nullable = false)
    public int getIdChild() {
        return idChild;
    }

    public void setIdChild(int idChild) {
        this.idChild = idChild;
    }

    @Basic
    @Column(name = "NAME_CHILD", nullable = true, length = 255)
    public String getNameChild() {
        return nameChild;
    }

    public void setNameChild(String nameChild) {
        this.nameChild = nameChild;
    }

    @Basic
    @Column(name = "CH_ID_PARENT", nullable = true, insertable= false, updatable= false )
    public Integer getChIdParent() {
        return chIdParent;
    }

    public void setChIdParent(Integer chIdParent) {
        this.chIdParent = chIdParent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Child child = (Child) o;

        if (idChild != child.idChild) return false;
        if (nameChild != null ? !nameChild.equals(child.nameChild) : child.nameChild != null) return false;
        if (chIdParent != null ? !chIdParent.equals(child.chIdParent) : child.chIdParent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idChild;
        result = 31 * result + (nameChild != null ? nameChild.hashCode() : 0);
        result = 31 * result + (chIdParent != null ? chIdParent.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CH_ID_PARENT", referencedColumnName = "ID_PARENT")
    public Parent getParentByChIdParent() {
        return parentByChIdParent;
    }

    public void setParentByChIdParent(Parent parentByChIdParent) {
        this.parentByChIdParent = parentByChIdParent;
    }
}
