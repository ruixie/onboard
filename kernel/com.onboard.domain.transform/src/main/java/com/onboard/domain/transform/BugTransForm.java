package com.onboard.domain.transform;

import org.springframework.beans.BeanUtils;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.onboard.domain.model.Bug;
import com.onboard.domain.model.Project;
import com.onboard.dto.BugDTO;

public class BugTransForm {

    public static final Function<Bug, BugDTO> BUG_TO_BUGDTO_FUNCTION = new Function<Bug, BugDTO>() {
        @Override
        public BugDTO apply(Bug input) {
            BugDTO result = bugToBugDTO(input);
            Project project = input.getProject();
            if (project != null) {
                result.setProjectName(project.getName());
            }
            return result;
        }
    };
    public static final Function<BugDTO, Bug> BUGDTO_TO_BUG_FUNCTION = new Function<BugDTO, Bug>() {
        @Override
        public Bug apply(BugDTO input) {
            return bugDTOToBug(input);
        }
    };

    public static BugDTO bugToBugDTO(Bug bug) {
        BugDTO bugDTO = new BugDTO();
        BeanUtils.copyProperties(bug, bugDTO);
        if (bug.getAssignee() != null && bug.getAssigneeId().equals(bug.getAssignee().getId())) {
            bugDTO.setBugAssigneeDTO(UserTransform.userToUserDTO(bug.getAssignee()));
        }
        if (bug.getSubscribers() != null) {
            bugDTO.setSubscribers(Lists.transform(bug.getSubscribers(), UserTransform.USER_TO_USERDTO_FUNCTION));
        }
        return bugDTO;
    }

    public static Bug bugDTOToBug(BugDTO bugDTO) {
        Bug bug = new Bug();
        BeanUtils.copyProperties(bugDTO, bug);
        if (bugDTO.getSubscribers() != null) {
            bug.setSubscribers(Lists.transform(bugDTO.getSubscribers(), UserTransform.USERDTO_TO_USER_FUNCTION));
        }
        if (bugDTO.getBugAssigneeDTO() != null) {
            bug.setAssignee(UserTransform.userDTOToUser(bugDTO.getBugAssigneeDTO()));
        }
        return bug;
    }

}
