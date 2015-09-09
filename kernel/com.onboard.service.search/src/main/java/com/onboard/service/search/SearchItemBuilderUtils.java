//package com.onboard.service.search;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.onboard.domain.mapper.ProjectMapper;
//import com.onboard.domain.model.Project;
//import com.onboard.service.index.model.IndexDocument;
//
//@Service("searchItemBuilderUtils")
//public class SearchItemBuilderUtils {
//
//    private static final String SEPRATOR = "_";
//
//    private static ProjectMapper projectMapper;
//
//    @Autowired
//    public void setProjectMapper(ProjectMapper projectMapper) {
//        SearchItemBuilderUtils.projectMapper = projectMapper;
//    }
//
//    public static String getItemType(IndexDocument indexDocument) {
//        String itemIdWithTableName = indexDocument.getId();
//        int index = itemIdWithTableName.lastIndexOf(SEPRATOR);
//        if (index < 0) {
//            return itemIdWithTableName;
//        }
//        return itemIdWithTableName.substring(0, index);
//    }
//
//    public static String getItemId(IndexDocument indexDocument) {
//        String itemIdWithTableName = indexDocument.getId();
//        int index = itemIdWithTableName.lastIndexOf(SEPRATOR);
//
//        return itemIdWithTableName.substring(index + 1);
//    }
//
//    public static String getProjectName(int projectId) {
//        Project project = projectMapper.selectByPrimaryKey(projectId);
//        if (project != null) {
//            return project.getName();
//        }
//        return null;
//    }
//}
