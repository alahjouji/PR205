package fr.inria.phoenix.diasuite.framework.datatype.bikesav;

import java.io.Serializable;

/**
 * <pre>
structure BikesAv {
 * 	dep as String[];
 * 	arr as String[];
 * }
</pre>
 */
public class BikesAv implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field dep
    private java.util.List<java.lang.String> dep;
    
    /**
     * Returns the value of the dep field.
    
    <pre>
    dep as String[]
    </pre>
    @return the value of dep
     */
    public java.util.List<java.lang.String> getDep() {
        return dep;
    }
    
    /**
     * Set the value of the dep field.
    
    <pre>
    dep as String[]
    </pre>
    @param dep the new value of dep
     */
    public void setDep(java.util.List<java.lang.String> dep) {
        this.dep = dep;
    }
    // End of code for field dep

    // Code for field arr
    private java.util.List<java.lang.String> arr;
    
    /**
     * Returns the value of the arr field.
    
    <pre>
    arr as String[]
    </pre>
    @return the value of arr
     */
    public java.util.List<java.lang.String> getArr() {
        return arr;
    }
    
    /**
     * Set the value of the arr field.
    
    <pre>
    arr as String[]
    </pre>
    @param arr the new value of arr
     */
    public void setArr(java.util.List<java.lang.String> arr) {
        this.arr = arr;
    }
    // End of code for field arr

    public BikesAv() {
    }

    public BikesAv(java.util.List<java.lang.String> dep,
            java.util.List<java.lang.String> arr) {
        this.dep = dep;
        this.arr = arr;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dep == null) ? 0 : dep.hashCode());
        result = prime * result + ((arr == null) ? 0 : arr.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BikesAv other = (BikesAv) obj;
        if (dep == null) {
            if (other.dep != null)
                return false;
        } else if (!dep.equals(other.dep))
            return false;
        if (arr == null) {
            if (other.arr != null)
                return false;
        } else if (!arr.equals(other.arr))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "BikesAv [" + 
            "dep=" + dep +", " + 
            "arr=" + arr +
        "]";
    }
}
