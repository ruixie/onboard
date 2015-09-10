/*******************************************************************************
 * Copyright [2015] [Onboard team of SERC, Peking University]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.onboard.service.wiki.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onboard.domain.model.Activity;
import com.onboard.domain.model.Document;
import com.onboard.domain.model.type.BaseProjectItem;
import com.onboard.service.activity.ActivityActionType;
import com.onboard.service.activity.ActivityGenerator;
import com.onboard.service.wiki.DocumentService;

/**
 * 生成文档相关活动信息的辅助类
 * 
 * @author yewei
 * 
 */
@Service("documentActivityGeneratorBean")
public class DocumentActivityGenerator implements ActivityGenerator {

    public static final String CREATE_SUBJECT = "创建了文档";
    public static final String UPDATE_SUBJECT = "更新了文档";
    public static final String DISCARD_SUBJECT = "删除了文档:";
    public static final String RECOVER_SUBJECT = "从回收站还原了文档";
    public static final String MOVE_SUBJECT = "移动了文档";

    @Autowired
    private DocumentService documentService;

    public static final String NAME_UPDATE = "标题由“%s”变为“%s”";

    private Activity generateActivityByActionType(String actionType, String subject, Document document) {

        Activity activity = new Activity();

        activity.setAttachId(document.getId());
        activity.setAttachType(document.getType());
        activity.setSubject(subject);
        activity.setAction(actionType);
        activity.setTarget(document.getTitle());
        activity.setProjectId(document.getProjectId());
        activity.setCompanyId(document.getCompanyId());

        return activity;

    }

    @Override
    public Activity generateCreateActivity(BaseProjectItem item) {

        Document document = (Document) item;

        return this.generateActivityByActionType(ActivityActionType.CREATE, CREATE_SUBJECT, document);

    }

    private Activity generateUpdateActivity(Document originalDoc, Document modifiedDoc) {

        if (modifiedDoc.getProjectId() != null && !originalDoc.getProjectId().equals(modifiedDoc.getProjectId())) {
            Activity activity = this.generateActivityByActionType(ActivityActionType.MOVE, MOVE_SUBJECT, originalDoc);

            // TODO set up move information
            // ActivityRecorderHelper.setupMoveInformation(
            // originalDoc.getProjectId(), modifiedDoc.getProjectId(),
            // activity);

            return activity;
        } else if (modifiedDoc.getTitle() != null && !modifiedDoc.getTitle().equals(originalDoc.getTitle())) {
            Activity activity = this.generateActivityByActionType(ActivityActionType.UPDATE, UPDATE_SUBJECT, modifiedDoc);

            activity.setContent(String.format(NAME_UPDATE, originalDoc.getTitle(), modifiedDoc.getTitle()));

            return activity;
        } else {
            Activity activity = this.generateActivityByActionType(ActivityActionType.UPDATE, UPDATE_SUBJECT, modifiedDoc);
            return activity;
        }

    }

    @Override
    public Activity generateUpdateActivity(BaseProjectItem item, BaseProjectItem modifiedItem) {
        Document p1 = (Document) item;
        Document p2 = (Document) modifiedItem;

        if (p2.getDeleted() != null && p1.getDeleted() != p2.getDeleted()) {
            if (p2.getDeleted()) {
                return this.generateActivityByActionType(ActivityActionType.DISCARD, DISCARD_SUBJECT, p1);
            } else {
                return this.generateActivityByActionType(ActivityActionType.RECOVER, RECOVER_SUBJECT, p1);
            }
        } else {
            return this.generateUpdateActivity(p1, p2);
        }
    }

    @Override
    public String modelType() {
        return new Document().getType();
    }

    @Override
    public BaseProjectItem enrichModel(BaseProjectItem identifiable) {
        return new Document(documentService.getById(identifiable.getId()));
    }

    @Override
    public String modelService() {
        return DocumentService.class.getName();
    }

}
