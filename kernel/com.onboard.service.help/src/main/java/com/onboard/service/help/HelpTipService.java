package com.onboard.service.help;

import java.util.List;
import java.util.Map;

import com.onboard.domain.model.HelpTip;

/**
 * {@link HelpTip} Service Interface
 * 
 * @generated_by_elevenframework
 * 
 */
public interface HelpTipService {
    /**
     * Get item by id
     * 
     * @param id
     * @return item
     */
    HelpTip getHelpTipById(int id);

    /**
     * Get item list
     * 
     * @param start
     * @param limit
     * @return the item list
     */
    List<HelpTip> getHelpTips(int start, int limit);

    /**
     * Get item list by example
     * 
     * @param item
     * @param start
     * @param limit
     * @return the item list
     */
    List<HelpTip> getHelpTipsByExample(HelpTip item, int start, int limit);

    /**
     * Get item count by example
     * 
     * @param item
     * @return the count
     */
    int countByExample(HelpTip item);

    /**
     * Create
     * 
     * @param item
     * @return the created HelpTip
     */
    HelpTip createHelpTip(HelpTip item);

    /**
     * Update
     * 
     * @param item
     * @return the updated item
     */
    HelpTip updateHelpTip(HelpTip item);

    /**
     * Delete
     * 
     * @param id
     */
    void deleteHelpTip(int id);

    Map<String, List<HelpTip>> groupHelpTipsByTitle(List<HelpTip> helpTips);

    List<HelpTip> updateHelpTipByGroupTitle(String title, String newTitle);

    void deleteHelpTipByGroupTitle(String title);

    void discardHelpTip(int id);

    void discardHelpTipsByGroupTitle(String title);
}
