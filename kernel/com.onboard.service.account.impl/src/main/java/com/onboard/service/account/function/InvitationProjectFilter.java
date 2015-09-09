package com.onboard.service.account.function;

import java.util.Collection;
import java.util.Set;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.onboard.domain.model.InvitationProjects;
import com.onboard.domain.model.Project;

/**
 * 用于过滤一个Project集合中的元素
 *
 * Created by luoruici on 13-12-12.
 */
public class InvitationProjectFilter implements Predicate<Project> {

    private Set<Integer> existingProjectIds;

    public InvitationProjectFilter(Collection<InvitationProjects> existings) {
        this.existingProjectIds = ImmutableSet.copyOf(Iterables.transform(existings, new Function<InvitationProjects, Integer>() {
            @Override
            public Integer apply(InvitationProjects input) {
                return input.getProjectId();
            }
        }));
    }

    @Override
    public boolean apply(Project input) {
        return !this.existingProjectIds.contains(input.getId());
    }
}
