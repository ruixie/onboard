package com.onboard.domain.transform;

import org.springframework.beans.BeanUtils;

import com.google.common.base.Function;
import com.onboard.domain.model.Activity;
import com.onboard.domain.model.User;
import com.onboard.dto.ActivityDTO;

public class ActivityTransForm {

    public static final Function<Activity, ActivityDTO> ACTIVITY_TO_ACTIVITYDTO_FUNCTION = new Function<Activity, ActivityDTO>() {
        @Override
        public ActivityDTO apply(Activity input) {
            ActivityDTO activityDTO = new ActivityDTO();
            BeanUtils.copyProperties(input, activityDTO);
            return activityDTO;
        }
    };

    public static ActivityDTO ActivityAndUserToActivityDTO(Activity activity, User user) {
        ActivityDTO activityDTO = new ActivityDTO();
        BeanUtils.copyProperties(activity, activityDTO);
        if (user != null && activityDTO.getCreatorId().equals(user.getId())) {
            activityDTO.setCreator(UserTransform.userToUserDTO(user));
        }
        return activityDTO;
    }

    public static ActivityDTO activityToActivityDTO(Activity activity) {
        ActivityDTO activityDTO = new ActivityDTO();
        BeanUtils.copyProperties(activity, activityDTO);
        return activityDTO;
    }

    public static Activity activityDTOToActivity(ActivityDTO activityDTO) {
        Activity activity = new Activity();
        BeanUtils.copyProperties(activityDTO, activity);
        if (activityDTO.getCreator() != null) {
            activity.setCreator(UserTransform.userDTOToUser(activityDTO.getCreator()));
        }
        return activity;
    }
}
