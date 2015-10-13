package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.socialnetworkphotolibrary.AbstractSocialNetworkPhotoLibrary;
import fr.inria.phoenix.diasuite.framework.device.socialnetworkphotolibrary.PhotosIndices;
import fr.inria.phoenix.diasuite.framework.device.socialnetworkphotolibrary.AlbumsIndices;
import fr.inria.phoenix.diasuite.framework.device.socialnetworkphotolibrary.RecentPhotosSharedByContactsIndices;
import fr.inria.phoenix.diasuite.framework.device.socialnetworkphotolibrary.CommentsIndices;
import fr.inria.phoenix.diasuite.framework.device.socialnetworkphotolibrary.TagsIndices;

// @internal
public final class SocialNetworkPhotoLibraryMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractSocialNetworkPhotoLibrary {
        private Proxy(ServiceConfiguration serviceConfiguration,
                java.lang.String idValue,
                java.lang.String ownerValue) {
            super(serviceConfiguration, idValue, ownerValue);
        }
        
        public void _updateId(java.lang.String newIdValue) {
            updateId(newIdValue);
        }
        
        public void _updateOwner(java.lang.String newOwnerValue) {
            updateOwner(newOwnerValue);
        }
        
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photoalbum.PhotoAlbum> getAlbums(fr.inria.phoenix.diasuite.framework.datatype.photoalbumfilter.PhotoAlbumFilter filter) throws Exception {
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photoalbum.PhotoAlbum> result = __albums.get(new AlbumsIndices(filter));
            if(result == null)
                return super.getAlbums(filter);
            return result;
        }
        
        public void _publishAlbums(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photoalbum.PhotoAlbum> newAlbumsValue,
                fr.inria.phoenix.diasuite.framework.datatype.photoalbumfilter.PhotoAlbumFilter filter) {
            publishAlbums(newAlbumsValue,
                filter);
        }
        
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.comment.Comment> getComments(java.lang.String photoID) throws Exception {
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.comment.Comment> result = __comments.get(new CommentsIndices(photoID));
            if(result == null)
                return super.getComments(photoID);
            return result;
        }
        
        public void _publishComments(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.comment.Comment> newCommentsValue,
                java.lang.String photoID) {
            publishComments(newCommentsValue,
                photoID);
        }
        
        protected java.lang.Boolean getIsAlive() throws Exception {
            java.lang.Boolean result = __isAlive;
            if(result == null)
                return super.getIsAlive();
            return result;
        }
        
        public void _publishIsAlive(java.lang.Boolean newIsAliveValue) {
            publishIsAlive(newIsAliveValue);
        }
        
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photo.Photo> getPhotos(fr.inria.phoenix.diasuite.framework.datatype.photofilter.PhotoFilter filter) throws Exception {
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photo.Photo> result = __photos.get(new PhotosIndices(filter));
            if(result == null)
                return super.getPhotos(filter);
            return result;
        }
        
        public void _publishPhotos(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photo.Photo> newPhotosValue,
                fr.inria.phoenix.diasuite.framework.datatype.photofilter.PhotoFilter filter) {
            publishPhotos(newPhotosValue,
                filter);
        }
        
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photo.Photo> getRecentPhotosSharedByContacts(fr.inria.phoenix.diasuite.framework.datatype.photofilter.PhotoFilter filter) throws Exception {
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photo.Photo> result = __recentPhotosSharedByContacts.get(new RecentPhotosSharedByContactsIndices(filter));
            if(result == null)
                return super.getRecentPhotosSharedByContacts(filter);
            return result;
        }
        
        public void _publishRecentPhotosSharedByContacts(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photo.Photo> newRecentPhotosSharedByContactsValue,
                fr.inria.phoenix.diasuite.framework.datatype.photofilter.PhotoFilter filter) {
            publishRecentPhotosSharedByContacts(newRecentPhotosSharedByContactsValue,
                filter);
        }
        
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.tag.Tag> getTags(java.lang.String photoID) throws Exception {
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.tag.Tag> result = __tags.get(new TagsIndices(photoID));
            if(result == null)
                return super.getTags(photoID);
            return result;
        }
        
        public void _publishTags(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.tag.Tag> newTagsValue,
                java.lang.String photoID) {
            publishTags(newTagsValue,
                photoID);
        }
        
        protected void addPhoto(fr.inria.phoenix.diasuite.framework.datatype.photo.Photo photo) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("addPhoto");
                __action.add(photo);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void addPhotoToAlbum(fr.inria.phoenix.diasuite.framework.datatype.photo.Photo photo,
                fr.inria.phoenix.diasuite.framework.datatype.photoalbum.PhotoAlbum album) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("addPhotoToAlbum");
                __action.add(photo);
                __action.add(album);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void removeAll() throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("removeAll");
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void removeAllFromAlbum(java.lang.String albumID) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("removeAllFromAlbum");
                __action.add(albumID);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void removePhoto(java.lang.String photoID) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("removePhoto");
                __action.add(photoID);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void removePhotoFromAlbum(java.lang.String photoID,
                java.lang.String albumID) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("removePhotoFromAlbum");
                __action.add(photoID);
                __action.add(albumID);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void removePhotos(java.util.List<java.lang.String> photoIDs) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("removePhotos");
                __action.add(photoIDs);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void removePhotosFromAlbum(java.util.List<java.lang.String> photoIDs,
                java.lang.String albumID) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("removePhotosFromAlbum");
                __action.add(photoIDs);
                __action.add(albumID);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
    }
    
    Proxy proxy;
    
    SocialNetworkPhotoLibraryMock(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue,
            java.lang.String ownerValue) {
        this.proxy = new Proxy(serviceConfiguration, idValue, ownerValue);
    }
    
    
    // Code for the attribute id from device Device
    /**
     * Set the value of the <code>id</code> attribute from device <code>Device</code>.
    
    <pre>
    attribute id as String;
    </pre>
    @param newIdValue the new value of <code>id</code>
    @return this for fluent interface
     */
    public SocialNetworkPhotoLibraryMock id(java.lang.String newIdValue) {
        proxy._updateId(newIdValue);
        return this;
    }
    // End of code for the attribute id from device Device
    
    // Code for the attribute owner from device PhotoLibrary
    /**
     * Set the value of the <code>owner</code> attribute from device <code>PhotoLibrary</code>.
    
    <pre>
    attribute owner as String;
    </pre>
    @param newOwnerValue the new value of <code>owner</code>
    @return this for fluent interface
     */
    public SocialNetworkPhotoLibraryMock owner(java.lang.String newOwnerValue) {
        proxy._updateOwner(newOwnerValue);
        return this;
    }
    // End of code for the attribute owner from device PhotoLibrary
    
    // Code for source albums from device PhotoLibrary
    /**
     * Publish the value of source <code>albums</code> from device <code>PhotoLibrary</code>.
    
    <pre>
    source albums as PhotoAlbum [] indexed by filter as PhotoAlbumFilter;
    </pre>
    @param newAlbumsValue the new value for the source <code>albums</code>
    @param filter the value of the index <code>filter</code>
    @return this for fluent interface
     */
    public SocialNetworkPhotoLibraryMock albums(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photoalbum.PhotoAlbum> newAlbumsValue,
            fr.inria.phoenix.diasuite.framework.datatype.photoalbumfilter.PhotoAlbumFilter filter) {
        proxy._publishAlbums(newAlbumsValue,
            filter);
        return this;
    }
    
    private java.util.HashMap<AlbumsIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photoalbum.PhotoAlbum>> __albums = new java.util.HashMap<AlbumsIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photoalbum.PhotoAlbum>>();
    /**
     * Set the value (without publication) of source <code>albums</code> from device <code>PhotoLibrary</code>.
    
    <pre>
    source albums as PhotoAlbum [] indexed by filter as PhotoAlbumFilter;
    </pre>
    @param newAlbumsValue the new value for the source <code>albums</code>
    @param filter the value of the index <code>filter</code>
    @return this for fluent interface
     */
    public SocialNetworkPhotoLibraryMock setAlbums(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photoalbum.PhotoAlbum> newAlbumsValue,
            fr.inria.phoenix.diasuite.framework.datatype.photoalbumfilter.PhotoAlbumFilter filter) {
        AlbumsIndices _indices_ = new AlbumsIndices(filter);
        __albums.put(_indices_, newAlbumsValue);
        return this;
    }
    // End of code for source albums from device PhotoLibrary
    
    // Code for source comments from device SocialNetworkPhotoLibrary
    /**
     * Publish the value of source <code>comments</code> from device <code>SocialNetworkPhotoLibrary</code>.
    
    <pre>
    source comments as Comment [] indexed by photoID as String;
    </pre>
    @param newCommentsValue the new value for the source <code>comments</code>
    @param photoID the value of the index <code>photoID</code>
    @return this for fluent interface
     */
    public SocialNetworkPhotoLibraryMock comments(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.comment.Comment> newCommentsValue,
            java.lang.String photoID) {
        proxy._publishComments(newCommentsValue,
            photoID);
        return this;
    }
    
    private java.util.HashMap<CommentsIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.comment.Comment>> __comments = new java.util.HashMap<CommentsIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.comment.Comment>>();
    /**
     * Set the value (without publication) of source <code>comments</code> from device <code>SocialNetworkPhotoLibrary</code>.
    
    <pre>
    source comments as Comment [] indexed by photoID as String;
    </pre>
    @param newCommentsValue the new value for the source <code>comments</code>
    @param photoID the value of the index <code>photoID</code>
    @return this for fluent interface
     */
    public SocialNetworkPhotoLibraryMock setComments(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.comment.Comment> newCommentsValue,
            java.lang.String photoID) {
        CommentsIndices _indices_ = new CommentsIndices(photoID);
        __comments.put(_indices_, newCommentsValue);
        return this;
    }
    // End of code for source comments from device SocialNetworkPhotoLibrary
    
    // Code for source isAlive from device Device
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public SocialNetworkPhotoLibraryMock isAlive(java.lang.Boolean newIsAliveValue) {
        proxy._publishIsAlive(newIsAliveValue);
        return this;
    }
    
    private java.lang.Boolean __isAlive = null;
    /**
     * Set the value (without publication) of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public SocialNetworkPhotoLibraryMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source photos from device PhotoLibrary
    /**
     * Publish the value of source <code>photos</code> from device <code>PhotoLibrary</code>.
    
    <pre>
    source photos as Photo [] indexed by filter as PhotoFilter;
    </pre>
    @param newPhotosValue the new value for the source <code>photos</code>
    @param filter the value of the index <code>filter</code>
    @return this for fluent interface
     */
    public SocialNetworkPhotoLibraryMock photos(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photo.Photo> newPhotosValue,
            fr.inria.phoenix.diasuite.framework.datatype.photofilter.PhotoFilter filter) {
        proxy._publishPhotos(newPhotosValue,
            filter);
        return this;
    }
    
    private java.util.HashMap<PhotosIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photo.Photo>> __photos = new java.util.HashMap<PhotosIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photo.Photo>>();
    /**
     * Set the value (without publication) of source <code>photos</code> from device <code>PhotoLibrary</code>.
    
    <pre>
    source photos as Photo [] indexed by filter as PhotoFilter;
    </pre>
    @param newPhotosValue the new value for the source <code>photos</code>
    @param filter the value of the index <code>filter</code>
    @return this for fluent interface
     */
    public SocialNetworkPhotoLibraryMock setPhotos(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photo.Photo> newPhotosValue,
            fr.inria.phoenix.diasuite.framework.datatype.photofilter.PhotoFilter filter) {
        PhotosIndices _indices_ = new PhotosIndices(filter);
        __photos.put(_indices_, newPhotosValue);
        return this;
    }
    // End of code for source photos from device PhotoLibrary
    
    // Code for source recentPhotosSharedByContacts from device SocialNetworkPhotoLibrary
    /**
     * Publish the value of source <code>recentPhotosSharedByContacts</code> from device <code>SocialNetworkPhotoLibrary</code>.
    
    <pre>
    source recentPhotosSharedByContacts as Photo [] indexed by filter as PhotoFilter;
    </pre>
    @param newRecentPhotosSharedByContactsValue the new value for the source <code>recentPhotosSharedByContacts</code>
    @param filter the value of the index <code>filter</code>
    @return this for fluent interface
     */
    public SocialNetworkPhotoLibraryMock recentPhotosSharedByContacts(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photo.Photo> newRecentPhotosSharedByContactsValue,
            fr.inria.phoenix.diasuite.framework.datatype.photofilter.PhotoFilter filter) {
        proxy._publishRecentPhotosSharedByContacts(newRecentPhotosSharedByContactsValue,
            filter);
        return this;
    }
    
    private java.util.HashMap<RecentPhotosSharedByContactsIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photo.Photo>> __recentPhotosSharedByContacts = new java.util.HashMap<RecentPhotosSharedByContactsIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photo.Photo>>();
    /**
     * Set the value (without publication) of source <code>recentPhotosSharedByContacts</code> from device <code>SocialNetworkPhotoLibrary</code>.
    
    <pre>
    source recentPhotosSharedByContacts as Photo [] indexed by filter as PhotoFilter;
    </pre>
    @param newRecentPhotosSharedByContactsValue the new value for the source <code>recentPhotosSharedByContacts</code>
    @param filter the value of the index <code>filter</code>
    @return this for fluent interface
     */
    public SocialNetworkPhotoLibraryMock setRecentPhotosSharedByContacts(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photo.Photo> newRecentPhotosSharedByContactsValue,
            fr.inria.phoenix.diasuite.framework.datatype.photofilter.PhotoFilter filter) {
        RecentPhotosSharedByContactsIndices _indices_ = new RecentPhotosSharedByContactsIndices(filter);
        __recentPhotosSharedByContacts.put(_indices_, newRecentPhotosSharedByContactsValue);
        return this;
    }
    // End of code for source recentPhotosSharedByContacts from device SocialNetworkPhotoLibrary
    
    // Code for source tags from device SocialNetworkPhotoLibrary
    /**
     * Publish the value of source <code>tags</code> from device <code>SocialNetworkPhotoLibrary</code>.
    
    <pre>
    source tags as Tag [] indexed by photoID as String;
    </pre>
    @param newTagsValue the new value for the source <code>tags</code>
    @param photoID the value of the index <code>photoID</code>
    @return this for fluent interface
     */
    public SocialNetworkPhotoLibraryMock tags(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.tag.Tag> newTagsValue,
            java.lang.String photoID) {
        proxy._publishTags(newTagsValue,
            photoID);
        return this;
    }
    
    private java.util.HashMap<TagsIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.tag.Tag>> __tags = new java.util.HashMap<TagsIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.tag.Tag>>();
    /**
     * Set the value (without publication) of source <code>tags</code> from device <code>SocialNetworkPhotoLibrary</code>.
    
    <pre>
    source tags as Tag [] indexed by photoID as String;
    </pre>
    @param newTagsValue the new value for the source <code>tags</code>
    @param photoID the value of the index <code>photoID</code>
    @return this for fluent interface
     */
    public SocialNetworkPhotoLibraryMock setTags(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.tag.Tag> newTagsValue,
            java.lang.String photoID) {
        TagsIndices _indices_ = new TagsIndices(photoID);
        __tags.put(_indices_, newTagsValue);
        return this;
    }
    // End of code for source tags from device SocialNetworkPhotoLibrary
    
    private java.util.Queue<java.util.Queue<Object>> __actions = new java.util.LinkedList<java.util.Queue<Object>>();
    
    /**
     * Check that the <code>addPhoto</code> order from the <code>AddPhoto</code> action
     * defined in device PhotoLibrary was called.
     * 
    
    <pre>
    addPhoto(photo as Photo);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAddPhoto() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("addPhoto".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>addPhoto</code> order from the <code>AddPhoto</code> action
     * defined in device PhotoLibrary was called.
     * 
    
    <pre>
    addPhoto(photo as Photo);
    </pre>
     * @param photo parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectAddPhoto(fr.inria.phoenix.diasuite.framework.datatype.photo.Photo photo) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("addPhoto".equals(__action.poll())))
                    return false;
                if(!photo.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>addPhotoToAlbum</code> order from the <code>AddPhotoToAlbum</code> action
     * defined in device PhotoLibrary was called.
     * 
    
    <pre>
    addPhotoToAlbum(photo as Photo, album as PhotoAlbum);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAddPhotoToAlbum() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("addPhotoToAlbum".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>addPhotoToAlbum</code> order from the <code>AddPhotoToAlbum</code> action
     * defined in device PhotoLibrary was called.
     * 
    
    <pre>
    addPhotoToAlbum(photo as Photo, album as PhotoAlbum);
    </pre>
     * @param photo parameter 1 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAddPhotoToAlbum(fr.inria.phoenix.diasuite.framework.datatype.photo.Photo photo) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("addPhotoToAlbum".equals(__action.poll())))
                    return false;
                if(!photo.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>addPhotoToAlbum</code> order from the <code>AddPhotoToAlbum</code> action
     * defined in device PhotoLibrary was called.
     * 
    
    <pre>
    addPhotoToAlbum(photo as Photo, album as PhotoAlbum);
    </pre>
     * @param photo parameter 1 of the order.
     * @param album parameter 2 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectAddPhotoToAlbum(fr.inria.phoenix.diasuite.framework.datatype.photo.Photo photo,
            fr.inria.phoenix.diasuite.framework.datatype.photoalbum.PhotoAlbum album) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("addPhotoToAlbum".equals(__action.poll())))
                    return false;
                if(!photo.equals(__action.poll()))
                    return false;
                if(!album.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>removeAll</code> order from the <code>RemovePhoto</code> action
     * defined in device PhotoLibrary was called.
     * 
    
    <pre>
    removeAll();
    </pre>    @return true if the action happened with the given parameters
     */
    public boolean expectRemoveAll() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("removeAll".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>removeAllFromAlbum</code> order from the <code>RemovePhotoFromAlbum</code> action
     * defined in device PhotoLibrary was called.
     * 
    
    <pre>
    removeAllFromAlbum(albumID as String);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectRemoveAllFromAlbum() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("removeAllFromAlbum".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>removeAllFromAlbum</code> order from the <code>RemovePhotoFromAlbum</code> action
     * defined in device PhotoLibrary was called.
     * 
    
    <pre>
    removeAllFromAlbum(albumID as String);
    </pre>
     * @param albumID parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectRemoveAllFromAlbum(java.lang.String albumID) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("removeAllFromAlbum".equals(__action.poll())))
                    return false;
                if(!albumID.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>removePhoto</code> order from the <code>RemovePhoto</code> action
     * defined in device PhotoLibrary was called.
     * 
    
    <pre>
    removePhoto(photoID as String);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectRemovePhoto() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("removePhoto".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>removePhoto</code> order from the <code>RemovePhoto</code> action
     * defined in device PhotoLibrary was called.
     * 
    
    <pre>
    removePhoto(photoID as String);
    </pre>
     * @param photoID parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectRemovePhoto(java.lang.String photoID) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("removePhoto".equals(__action.poll())))
                    return false;
                if(!photoID.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>removePhotoFromAlbum</code> order from the <code>RemovePhotoFromAlbum</code> action
     * defined in device PhotoLibrary was called.
     * 
    
    <pre>
    removePhotoFromAlbum(photoID as String, albumID as String);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectRemovePhotoFromAlbum() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("removePhotoFromAlbum".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>removePhotoFromAlbum</code> order from the <code>RemovePhotoFromAlbum</code> action
     * defined in device PhotoLibrary was called.
     * 
    
    <pre>
    removePhotoFromAlbum(photoID as String, albumID as String);
    </pre>
     * @param photoID parameter 1 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectRemovePhotoFromAlbum(java.lang.String photoID) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("removePhotoFromAlbum".equals(__action.poll())))
                    return false;
                if(!photoID.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>removePhotoFromAlbum</code> order from the <code>RemovePhotoFromAlbum</code> action
     * defined in device PhotoLibrary was called.
     * 
    
    <pre>
    removePhotoFromAlbum(photoID as String, albumID as String);
    </pre>
     * @param photoID parameter 1 of the order.
     * @param albumID parameter 2 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectRemovePhotoFromAlbum(java.lang.String photoID,
            java.lang.String albumID) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("removePhotoFromAlbum".equals(__action.poll())))
                    return false;
                if(!photoID.equals(__action.poll()))
                    return false;
                if(!albumID.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>removePhotos</code> order from the <code>RemovePhoto</code> action
     * defined in device PhotoLibrary was called.
     * 
    
    <pre>
    removePhotos(photoIDs as String []);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectRemovePhotos() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("removePhotos".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>removePhotos</code> order from the <code>RemovePhoto</code> action
     * defined in device PhotoLibrary was called.
     * 
    
    <pre>
    removePhotos(photoIDs as String []);
    </pre>
     * @param photoIDs parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectRemovePhotos(java.util.List<java.lang.String> photoIDs) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("removePhotos".equals(__action.poll())))
                    return false;
                if(!photoIDs.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>removePhotosFromAlbum</code> order from the <code>RemovePhotoFromAlbum</code> action
     * defined in device PhotoLibrary was called.
     * 
    
    <pre>
    removePhotosFromAlbum(photoIDs as String [], albumID as String);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectRemovePhotosFromAlbum() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("removePhotosFromAlbum".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>removePhotosFromAlbum</code> order from the <code>RemovePhotoFromAlbum</code> action
     * defined in device PhotoLibrary was called.
     * 
    
    <pre>
    removePhotosFromAlbum(photoIDs as String [], albumID as String);
    </pre>
     * @param photoIDs parameter 1 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectRemovePhotosFromAlbum(java.util.List<java.lang.String> photoIDs) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("removePhotosFromAlbum".equals(__action.poll())))
                    return false;
                if(!photoIDs.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>removePhotosFromAlbum</code> order from the <code>RemovePhotoFromAlbum</code> action
     * defined in device PhotoLibrary was called.
     * 
    
    <pre>
    removePhotosFromAlbum(photoIDs as String [], albumID as String);
    </pre>
     * @param photoIDs parameter 1 of the order.
     * @param albumID parameter 2 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectRemovePhotosFromAlbum(java.util.List<java.lang.String> photoIDs,
            java.lang.String albumID) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("removePhotosFromAlbum".equals(__action.poll())))
                    return false;
                if(!photoIDs.equals(__action.poll()))
                    return false;
                if(!albumID.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
}
