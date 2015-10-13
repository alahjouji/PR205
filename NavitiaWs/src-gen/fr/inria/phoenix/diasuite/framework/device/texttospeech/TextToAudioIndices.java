package fr.inria.phoenix.diasuite.framework.device.texttospeech;

import java.io.Serializable;

/**
 * Container for the indices of the source <code>textToAudio</code> from device <code>TextToSpeech</code>.

<pre>
source textToAudio as File indexed by text as String;
</pre>
 */
public final class TextToAudioIndices implements Serializable {
    private static final long serialVersionUID = 0;
    
    public TextToAudioIndices(java.lang.String text) {
        this._text = text;
    }
    
    // Code for index text
    private java.lang.String _text;
    
    /**
     * Get the <code>text</code> index
     * 
     * @return the value of the <code>text</code> index
     */
    public java.lang.String text() {
        return _text;
    }
    
    /**
     * Set the <code>text</code> index
     * 
     * @param newText the new value for the <code>text</code> index
     */
    public void setText(java.lang.String newText) {
        this._text = newText;
    }
    // End of code for index text
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_text == null) ? 0 : _text.hashCode());
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
        TextToAudioIndices other = (TextToAudioIndices) obj;
        if (_text == null) {
            if (other._text != null)
                return false;
        } else if (!_text.equals(other._text))
            return false;
        return true;
    }
}
