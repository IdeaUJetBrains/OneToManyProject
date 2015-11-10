package data;

import javax.persistence.*;

/**
 * Created by Olga Pavlova on 11/9/2015.
 */
@Entity
public class Child {
    private int idChild;
    private String nameChild;

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


    //=====================================
    @ManyToOne
    @JoinColumn(name = "CH_ID_PARENT", referencedColumnName="ID_PARENT", nullable = true)
    private Parent chIdParent;
    public Parent getDriversidfk() {
        return chIdParent;
    }
    public void setDriversidfk(Parent chIdParent) {
        this.chIdParent = chIdParent;
    }

    //=====================================



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Child child = (Child) o;

        if (idChild != child.idChild) return false;
        if (nameChild != null ? !nameChild.equals(child.nameChild) : child.nameChild != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idChild;
        result = 31 * result + (nameChild != null ? nameChild.hashCode() : 0);
        return result;
    }
}
