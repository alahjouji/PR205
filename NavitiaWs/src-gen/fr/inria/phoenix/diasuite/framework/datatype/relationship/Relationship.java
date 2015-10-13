package fr.inria.phoenix.diasuite.framework.datatype.relationship;

import java.io.Serializable;

/**
 * ------------------
Healthcare
------------------------------------

<pre>
enumeration Relationship {
 * 	ME, FRIEND, FAMILY, CAREGIVER, MEDICAL
 * }
</pre>
 */
public enum Relationship implements Serializable {
    ME,FRIEND,FAMILY,CAREGIVER,MEDICAL
}
