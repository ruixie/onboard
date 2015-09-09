package com.onboard.service.collaboration;

import java.util.List;

import com.onboard.domain.model.Trash;

/**
 * {@link Trash} Service Interface
 * 
 * @generated_by_elevenframework
 * 
 */
public interface TrashService {
    /**
     * Get item by id
     * 
     * @param id
     * @return item
     */
    Trash getTrashById(int id);

    /**
     * Get item list
     * 
     * @param start
     * @param limit
     * @return the item list
     */
    List<Trash> getTrashes(int start, int limit);

    /**
     * Get item list by example
     * 
     * @param item
     * @param start
     * @param limit
     * @return the item list
     */
    List<Trash> getTrashesByExample(Trash item, int start, int limit);

    /**
     * Get item count by example
     * 
     * @param item
     * @return the count
     */
    int countByExample(Trash item);

    /**
     * Create
     * 
     * @param item
     * @return the created Trash
     */
    Trash addTrash(Trash item);

    /**
     * Update
     * 
     * @param item
     * @return the updated item
     */
    Trash updateTrash(Trash item);

    /**
     * Delete
     * 
     * @param id
     */
    void deleteTrash(int id);

    /**
     * 
     * @param trash
     */
    void deleteTrashByExample(Trash trash);
}
