package fr.inria.phoenix.diasuite.framework.datatype.file;

import java.io.Serializable;

/**
 * <pre>
structure File {
 * 	info as FileInfo;
 * 	content as Binary;
 * }
</pre>
 */
public class File implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field info
    private fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo info;
    
    /**
     * Returns the value of the info field.
    
    <pre>
    info as FileInfo
    </pre>
    @return the value of info
     */
    public fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo getInfo() {
        return info;
    }
    
    /**
     * Set the value of the info field.
    
    <pre>
    info as FileInfo
    </pre>
    @param info the new value of info
     */
    public void setInfo(fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo info) {
        this.info = info;
    }
    // End of code for field info

    // Code for field content
    private byte[] content;
    
    /**
     * Returns the value of the content field.
    
    <pre>
    content as Binary
    </pre>
    @return the value of content
     */
    public byte[] getContent() {
        return content;
    }
    
    /**
     * Set the value of the content field.
    
    <pre>
    content as Binary
    </pre>
    @param content the new value of content
     */
    public void setContent(byte[] content) {
        this.content = content;
    }
    // End of code for field content

    public File() {
    }

    public File(fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo info,
            byte[] content) {
        this.info = info;
        this.content = content;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((info == null) ? 0 : info.hashCode());
        result = prime * result + ((content == null) ? 0 : content.hashCode());
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
        File other = (File) obj;
        if (info == null) {
            if (other.info != null)
                return false;
        } else if (!info.equals(other.info))
            return false;
        if (content == null) {
            if (other.content != null)
                return false;
        } else if (!content.equals(other.content))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "File [" + 
            "info=" + info +", " + 
            "content.length=" + content.length +
        "]";
    }
}
