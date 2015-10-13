package fr.inria.phoenix.diasuite.framework.device.photolibrary;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * ** DEVICES **

<pre>
device PhotoLibrary extends Device {
 * 	attribute owner as String;
 * 	source photos as Photo [] indexed by filter as PhotoFilter;
 * 	source albums as PhotoAlbum [] indexed by filter as PhotoAlbumFilter;
 * 	action AddPhoto;
 * 	action AddPhotoToAlbum;
 * 	action RemovePhoto;
 * 	action RemovePhotoFromAlbum;
 * }
</pre>
 */
public abstract class AbstractPhotoLibrary extends Service {
    
    public AbstractPhotoLibrary(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue,
            java.lang.String ownerValue) {
        super("/Device/Device/PhotoLibrary/", serviceConfiguration);
        updateId(idValue);
        updateOwner(ownerValue);
    }
    
    // Methods from the Service class
    @Override
    public final java.util.Map<String, Object> getAttributesCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source) {
        java.util.Map<String, Object> attributes = new java.util.HashMap<String, Object>();
        attributes.put("id", _id);
        attributes.put("owner", _owner);
        return attributes;
    }
    
    @Override
    protected final void internalPostInitialize() {
        postInitialize();
    }
    
    @SuppressWarnings("all")
    @Override
    public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("addPhoto")) {
            addPhoto((fr.inria.phoenix.diasuite.framework.datatype.photo.Photo) args[0]);
            return null;
        }
        if (orderName.equals("addPhotoToAlbum")) {
            addPhotoToAlbum((fr.inria.phoenix.diasuite.framework.datatype.photo.Photo) args[0],
                    (fr.inria.phoenix.diasuite.framework.datatype.photoalbum.PhotoAlbum) args[1]);
            return null;
        }
        if (orderName.equals("removeAll")) {
            removeAll();
            return null;
        }
        if (orderName.equals("removeAllFromAlbum")) {
            removeAllFromAlbum((java.lang.String) args[0]);
            return null;
        }
        if (orderName.equals("removePhoto")) {
            removePhoto((java.lang.String) args[0]);
            return null;
        }
        if (orderName.equals("removePhotoFromAlbum")) {
            removePhotoFromAlbum((java.lang.String) args[0],
                    (java.lang.String) args[1]);
            return null;
        }
        if (orderName.equals("removePhotos")) {
            removePhotos((java.util.List<java.lang.String>) args[0]);
            return null;
        }
        if (orderName.equals("removePhotosFromAlbum")) {
            removePhotosFromAlbum((java.util.List<java.lang.String>) args[0],
                    (java.lang.String) args[1]);
            return null;
        }
        throw new InvocationException("Undefined method name " + orderName);
    }
    
    @Override
    public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("id")) {
            return _id;
        }
        if (orderName.equals("owner")) {
            return _owner;
        }
        if (orderName.equals("albums")) {
            return getAlbums((fr.inria.phoenix.diasuite.framework.datatype.photoalbumfilter.PhotoAlbumFilter) args[0]);
        }
        if (orderName.equals("isAlive")) {
            return getIsAlive();
        }
        if (orderName.equals("photos")) {
            return getPhotos((fr.inria.phoenix.diasuite.framework.datatype.photofilter.PhotoFilter) args[0]);
        }
        throw new InvocationException("Undefined method name " + orderName);
    }
    // End of methods from the Service class
    
    // Code for the attribute id from device Device
    private java.lang.String _id;
    
    /**
     * Set the value of the <code>id</code> attribute from device <code>Device</code>.
    
    <pre>
    attribute id as String;
    </pre>
    @param newIdValue the new value of <code>id</code>
     */
    protected void updateId(java.lang.String newIdValue) {
        if (_id != newIdValue) {
            _id = newIdValue;
            updateAttribute("id", newIdValue);
        }
    }
    
    /**
     * Returns the value of the <code>id</code> attribute from device <code>Device</code>.
    
    <pre>
    attribute id as String;
    </pre>
    @return the value of <code>id</code>
     */
    public java.lang.String getId() {
        return _id;
    }
    // End of code for the attribute id from device Device
    
    // Code for the attribute owner from device PhotoLibrary
    private java.lang.String _owner;
    
    /**
     * Set the value of the <code>owner</code> attribute from device <code>PhotoLibrary</code>.
    
    <pre>
    attribute owner as String;
    </pre>
    @param newOwnerValue the new value of <code>owner</code>
     */
    protected void updateOwner(java.lang.String newOwnerValue) {
        if (_owner != newOwnerValue) {
            _owner = newOwnerValue;
            updateAttribute("owner", newOwnerValue);
        }
    }
    
    /**
     * Returns the value of the <code>owner</code> attribute from device <code>PhotoLibrary</code>.
    
    <pre>
    attribute owner as String;
    </pre>
    @return the value of <code>owner</code>
     */
    public java.lang.String getOwner() {
        return _owner;
    }
    // End of code for the attribute owner from device PhotoLibrary
    
    // Code for source albums from device PhotoLibrary
    private java.util.HashMap<AlbumsIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photoalbum.PhotoAlbum>> _albums = new java.util.HashMap<AlbumsIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photoalbum.PhotoAlbum>>();
    
    /**
     * Publish the value of source <code>albums</code> from device <code>PhotoLibrary</code>.
    
    <pre>
    source albums as PhotoAlbum [] indexed by filter as PhotoAlbumFilter;
    </pre>
    @param newAlbumsValue the new value for the source <code>albums</code>
    @param filter the value of the index <code>filter</code>
     */
    protected void publishAlbums(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photoalbum.PhotoAlbum> newAlbumsValue,
            fr.inria.phoenix.diasuite.framework.datatype.photoalbumfilter.PhotoAlbumFilter filter) {
        AlbumsIndices _indices_ = new AlbumsIndices(filter);
        _albums.put(_indices_, newAlbumsValue);
        getProcessor().publishValue(getOutProperties(), "albums", newAlbumsValue, filter); 
    }
    
    /**
     * Returns the value of source <code>albums</code> from device <code>PhotoLibrary</code>.
    
    <pre>
    source albums as PhotoAlbum [] indexed by filter as PhotoAlbumFilter;
    </pre>
    @param filter the value of the index <code>filter</code>
    @return the value of the source <code>albums</code>
     */
    protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photoalbum.PhotoAlbum> getAlbums(fr.inria.phoenix.diasuite.framework.datatype.photoalbumfilter.PhotoAlbumFilter filter) throws Exception {
        return _albums.get(new AlbumsIndices(filter));
    }
    // End of code for source albums from device PhotoLibrary
    
    // Code for source isAlive from device Device
    private java.lang.Boolean _isAlive;
    
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
     */
    protected void publishIsAlive(java.lang.Boolean newIsAliveValue) {
        _isAlive = newIsAliveValue;
        getProcessor().publishValue(getOutProperties(), "isAlive", newIsAliveValue); 
    }
    
    /**
     * Returns the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @return the value of the source <code>isAlive</code>
     */
    protected java.lang.Boolean getIsAlive() throws Exception {
        return _isAlive;
    }
    // End of code for source isAlive from device Device
    
    // Code for source photos from device PhotoLibrary
    private java.util.HashMap<PhotosIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photo.Photo>> _photos = new java.util.HashMap<PhotosIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photo.Photo>>();
    
    /**
     * Publish the value of source <code>photos</code> from device <code>PhotoLibrary</code>.
    
    <pre>
    source photos as Photo [] indexed by filter as PhotoFilter;
    </pre>
    @param newPhotosValue the new value for the source <code>photos</code>
    @param filter the value of the index <code>filter</code>
     */
    protected void publishPhotos(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photo.Photo> newPhotosValue,
            fr.inria.phoenix.diasuite.framework.datatype.photofilter.PhotoFilter filter) {
        PhotosIndices _indices_ = new PhotosIndices(filter);
        _photos.put(_indices_, newPhotosValue);
        getProcessor().publishValue(getOutProperties(), "photos", newPhotosValue, filter); 
    }
    
    /**
     * Returns the value of source <code>photos</code> from device <code>PhotoLibrary</code>.
    
    <pre>
    source photos as Photo [] indexed by filter as PhotoFilter;
    </pre>
    @param filter the value of the index <code>filter</code>
    @return the value of the source <code>photos</code>
     */
    protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photo.Photo> getPhotos(fr.inria.phoenix.diasuite.framework.datatype.photofilter.PhotoFilter filter) throws Exception {
        return _photos.get(new PhotosIndices(filter));
    }
    // End of code for source photos from device PhotoLibrary
    
    /**
     * Implement this method to define the <code>addPhoto</code> order from the <code>AddPhoto</code> action
     * defined in device PhotoLibrary.
     * 
    
    <pre>
    addPhoto(photo as Photo);
    </pre>
     * @param photo parameter 1 of the order.
     */
    protected abstract void addPhoto(fr.inria.phoenix.diasuite.framework.datatype.photo.Photo photo) throws Exception;
    
    /**
     * Implement this method to define the <code>addPhotoToAlbum</code> order from the <code>AddPhotoToAlbum</code> action
     * defined in device PhotoLibrary.
     * 
    
    <pre>
    addPhotoToAlbum(photo as Photo, album as PhotoAlbum);
    </pre>
     * @param photo parameter 1 of the order.
     * @param album parameter 2 of the order.
     */
    protected abstract void addPhotoToAlbum(fr.inria.phoenix.diasuite.framework.datatype.photo.Photo photo,
            fr.inria.phoenix.diasuite.framework.datatype.photoalbum.PhotoAlbum album) throws Exception;
    
    /**
     * Implement this method to define the <code>removeAll</code> order from the <code>RemovePhoto</code> action
     * defined in device PhotoLibrary.
     * 
    
    <pre>
    removeAll();
    </pre>
     */
    protected abstract void removeAll() throws Exception;
    
    /**
     * Implement this method to define the <code>removeAllFromAlbum</code> order from the <code>RemovePhotoFromAlbum</code> action
     * defined in device PhotoLibrary.
     * 
    
    <pre>
    removeAllFromAlbum(albumID as String);
    </pre>
     * @param albumID parameter 1 of the order.
     */
    protected abstract void removeAllFromAlbum(java.lang.String albumID) throws Exception;
    
    /**
     * Implement this method to define the <code>removePhoto</code> order from the <code>RemovePhoto</code> action
     * defined in device PhotoLibrary.
     * 
    
    <pre>
    removePhoto(photoID as String);
    </pre>
     * @param photoID parameter 1 of the order.
     */
    protected abstract void removePhoto(java.lang.String photoID) throws Exception;
    
    /**
     * Implement this method to define the <code>removePhotoFromAlbum</code> order from the <code>RemovePhotoFromAlbum</code> action
     * defined in device PhotoLibrary.
     * 
    
    <pre>
    removePhotoFromAlbum(photoID as String, albumID as String);
    </pre>
     * @param photoID parameter 1 of the order.
     * @param albumID parameter 2 of the order.
     */
    protected abstract void removePhotoFromAlbum(java.lang.String photoID,
            java.lang.String albumID) throws Exception;
    
    /**
     * Implement this method to define the <code>removePhotos</code> order from the <code>RemovePhoto</code> action
     * defined in device PhotoLibrary.
     * 
    
    <pre>
    removePhotos(photoIDs as String []);
    </pre>
     * @param photoIDs parameter 1 of the order.
     */
    protected abstract void removePhotos(java.util.List<java.lang.String> photoIDs) throws Exception;
    
    /**
     * Implement this method to define the <code>removePhotosFromAlbum</code> order from the <code>RemovePhotoFromAlbum</code> action
     * defined in device PhotoLibrary.
     * 
    
    <pre>
    removePhotosFromAlbum(photoIDs as String [], albumID as String);
    </pre>
     * @param photoIDs parameter 1 of the order.
     * @param albumID parameter 2 of the order.
     */
    protected abstract void removePhotosFromAlbum(java.util.List<java.lang.String> photoIDs,
            java.lang.String albumID) throws Exception;
}
