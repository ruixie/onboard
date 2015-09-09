package com.onboard.service.collaboration.impl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jsoup.Jsoup;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.onboard.domain.model.Activity;
import com.onboard.domain.model.Bug;
import com.onboard.domain.model.Comment;
import com.onboard.service.activity.ActivityActionType;
import com.onboard.service.activity.util.ActivityHelper;
import com.onboard.service.collaboration.CommentService;
import com.onboard.service.collaboration.activity.BugActivityGenerator;
import com.onboard.service.collaboration.activity.CommentActivityGenerator;
import com.onboard.test.moduleutils.ModuleHelper;

@RunWith(MockitoJUnitRunner.class)
public class CommentActivityGeneratorTest {

    @InjectMocks
    CommentActivityGenerator testedCommentActivityGenerator;
    
    @Mock
    CommentService mockCommentService;
    
    @Before
    public void setupCommentActivityGeneratorTest() {
        Mockito.doReturn(ModuleHelper.commentTargetName).when(mockCommentService).getCommentTargetName(ModuleHelper.attachType, ModuleHelper.attachId);
    }
    
    public void runAsserts(Activity activity, Comment comment, String actionType, String subject) {
        /* CommentActivityGenerator.generateActivityByActionType */
        assertEquals((int) comment.getProjectId(), (int) activity.getProjectId());
        assertEquals((int) comment.getCompanyId(), (int) activity.getCompanyId());
        assertEquals(ModuleHelper.commentTargetName, activity.getTarget());
        assertEquals(ActivityHelper.cutoffActivityContent(Jsoup.parse(ModuleHelper.content).text()), activity.getContent());

        /* ActivityHelper.generateActivityByActionType */
        assertEquals((int) comment.getId(), (int) activity.getAttachId());
        assertEquals(new Comment().getType(), activity.getAttachType());
        assertEquals(subject, activity.getSubject());
        assertEquals(actionType, activity.getAction());
    }
    
    /**
     * @author Steven
     */
    @Test
    public void testGenerateCreateActivity() {
        Comment comment = ModuleHelper.getASampleComment();
        
        Activity activity = testedCommentActivityGenerator.generateCreateActivity(comment);
        
        runAsserts(activity, comment, ActivityActionType.REPLY, CommentActivityGenerator.CREATE_SUBJECT);
    }
    
    /**
     * @author Steven
     * Test that deletes the comment
     */
    @Test
    public void testGenerateUpdateActivity_Test1() {
        Comment origin = ModuleHelper.getASampleComment();
        Comment update = ModuleHelper.getASampleComment();
        origin.setDeleted(false);
        update.setDeleted(true);
        
        Activity activity = testedCommentActivityGenerator.generateUpdateActivity(origin, update);
        
        runAsserts(activity, origin, ActivityActionType.DISCARD, CommentActivityGenerator.DISCARD_SUBJECT);
    }
    
    /**
     * @author Steven
     * Test that recovers the comment
     */
    @Test
    public void testGenerateUpdateActivity_Test2() {
        Comment origin = ModuleHelper.getASampleComment();
        Comment update = ModuleHelper.getASampleComment();
        origin.setDeleted(true);
        update.setDeleted(false);
        
        Activity activity = testedCommentActivityGenerator.generateUpdateActivity(origin, update);
        
        runAsserts(activity, origin, ActivityActionType.RECOVER, CommentActivityGenerator.RECOVER_SUBJECT);
    }
    
    /**
     * @author Steven
     * Test that updates the comment
     */
    @Test
    public void testGenerateUpdateActivity_Test3() {
        Comment origin = ModuleHelper.getASampleComment();
        Comment update = ModuleHelper.getASampleComment();
        
        Activity activity = testedCommentActivityGenerator.generateUpdateActivity(origin, update);
        
        runAsserts(activity, origin, ActivityActionType.UPDATE, CommentActivityGenerator.UPDATE_SUBJECT);
    }
    
}
