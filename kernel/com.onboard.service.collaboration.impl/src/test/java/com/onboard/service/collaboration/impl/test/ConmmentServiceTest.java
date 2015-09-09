package com.onboard.service.collaboration.impl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.onboard.domain.mapper.model.CommentExample;
import com.onboard.domain.mapper.model.common.BaseExample;
import com.onboard.domain.model.Attachment;
import com.onboard.domain.model.Comment;
import com.onboard.domain.model.Discussion;
import com.onboard.domain.model.Todo;
import com.onboard.domain.model.Topic;
import com.onboard.domain.model.User;
import com.onboard.domain.model.type.BaseProjectItem;
import com.onboard.domain.model.type.Commentable;
import com.onboard.domain.model.type.Subscribable;
import com.onboard.service.account.UserService;
import com.onboard.service.collaboration.AttachmentService;
import com.onboard.service.collaboration.DiscussionService;
import com.onboard.service.collaboration.TopicService;
import com.onboard.service.collaboration.impl.CommentServiceImpl;
import com.onboard.service.collaboration.impl.abstractfiles.AbstractCommentServiceImplTest;
import com.onboard.service.common.identifiable.IdentifiableManager;
import com.onboard.service.common.subscrible.SubscriberService;
import com.onboard.service.web.SessionService;
import com.onboard.test.exampleutils.CriterionVerifier;
import com.onboard.test.exampleutils.ExampleMatcher;
import com.onboard.test.exampleutils.ObjectMatcher;
import com.onboard.test.moduleutils.ModuleHelper;

public class ConmmentServiceTest extends AbstractCommentServiceImplTest {

    @Mock
    private AttachmentService mockAttachmentService;
    @Mock
    private UserService mockUserService;
    @Mock
    private TopicService mockTopicService;
    @Mock
    private SessionService mockSessionService;
    @Mock
    private DiscussionService mockDiscussionService;
    @Mock
    private IdentifiableManager mockIdentifiableManager;
    @Mock
    private SubscriberService mockSubscriberService;
    @Mock
    private Commentable mockCommentable;

    @InjectMocks
    private CommentServiceImpl mockCommentServiceImpl;

    @Test
    public void testGetCommentById() {
        Comment comment0 = mockCommentServiceImpl.getById(ModuleHelper.id);
        verify(mockCommentMapper).selectByPrimaryKey(ModuleHelper.id);
        assertEquals(comment0.getId(), comment.getId());
    }

    @Test
    public void testGetCommentByWithExtraInfo1() {
        Mockito.reset(mockCommentMapper);
        when(mockCommentMapper.selectByPrimaryKey(ModuleHelper.id)).thenReturn(null);
        Comment comment0 = mockCommentServiceImpl.getByIdWithDetail(ModuleHelper.id);
        verify(mockCommentMapper).selectByPrimaryKey(ModuleHelper.id);
        assertNull(comment0);
    }

    @Test
    public void testGetCommentByWithExtraInfo2() {

        when(mockAttachmentService.getAttachmentsByTypeAndId(comment.getType(), ModuleHelper.id, 0, -1)).thenReturn(
                attachmentList);
        when(mockUserService.getById(ModuleHelper.creatorId)).thenReturn(user);

        Comment retComment = mockCommentServiceImpl.getByIdWithDetail(ModuleHelper.id);

        verify(mockCommentMapper).selectByPrimaryKey(ModuleHelper.id);
        verify(mockAttachmentService).getAttachmentsByTypeAndId("comment", ModuleHelper.id, 0, -1);
        verify(mockUserService).getById(ModuleHelper.creatorId);

        assertEquals(retComment.getAttachments(), attachmentList);
        assertEquals(user, retComment.getCreator());

    }

    @Test
    public void testGetCommentsByTopic() {

        when(mockAttachmentService.getAttachmentsByTypeAndId(new Comment().getType(), ModuleHelper.id, 0, -1)).thenReturn(
                attachmentList);

        List<Comment> commentlist = mockCommentServiceImpl.getCommentsByTopic(ModuleHelper.attachType, ModuleHelper.attachId,
                ModuleHelper.start, ModuleHelper.limit);

        verify(mockCommentMapper).selectByExample(argThat(new ExampleMatcher<CommentExample>() {
            @Override
            public boolean matches(BaseExample example) {
                return CriterionVerifier.verifyEqualTo(example, "attachId", ModuleHelper.attachId)
                        && CriterionVerifier.verifyEqualTo(example, "attachType", ModuleHelper.attachType)
                        && CriterionVerifier.verifyEqualTo(example, "deleted", false)
                        && CriterionVerifier.verifyStart(example, ModuleHelper.start)
                        && CriterionVerifier.verifyLimit(example, ModuleHelper.limit);
            }
        }));
        verify(mockAttachmentService, times(2)).getAttachmentsByTypeAndId("comment", ModuleHelper.id, 0, -1);
        for (int i = 0; i < commentlist.size(); i++) {
            assertEquals(commentlist.get(i).getAttachments(), attachmentList);
        }
    }

    @Test
    public void testCountByExample() {
        int result = mockCommentServiceImpl.countBySample(comment);
        assertEquals(ModuleHelper.count, result);
    }

    @Test
    public void testFillCommenttable1() {
        mockCommentServiceImpl.fillCommentable(null, ModuleHelper.start, ModuleHelper.limit);
        verify(mockCommentable, never()).getType();
        verify(mockCommentable, never()).getId();
        verify(mockCommentable, never()).setComments(listOfComments);
    }

    @Test
    public void testFillCommenttable2() {
        CommentServiceImpl spyCommentServiceImpl = spy(mockCommentServiceImpl);
        doReturn(listOfComments).when(spyCommentServiceImpl).getCommentsByTopic(ModuleHelper.attachType, ModuleHelper.attachId,
                ModuleHelper.start, ModuleHelper.limit);
        when(mockCommentable.getType()).thenReturn(ModuleHelper.attachType);
        when(mockCommentable.getId()).thenReturn(ModuleHelper.attachId);
        spyCommentServiceImpl.fillCommentable(mockCommentable, ModuleHelper.start, ModuleHelper.limit);

        verify(spyCommentServiceImpl).getCommentsByTopic(ModuleHelper.attachType, ModuleHelper.attachId, ModuleHelper.start,
                ModuleHelper.limit);
        verify(mockCommentable).getId();
        verify(mockCommentable).getType();
        verify(mockCommentable).setComments(listOfComments);
    }

    @Test
    public void testCreateComment1() {
        BaseProjectItem mockIdentifiable = mock(Subscribable.class);
        when(mockSessionService.getCurrentUser()).thenReturn(user);
        when(mockUserService.getById(comment.getCreatorId())).thenReturn(new User(ModuleHelper.creatorId));
        when(mockTopicService.buildTopicFromComment(comment, comment.getProjectId())).thenReturn(topic);
        when(mockTopicService.createOrUpdateTopic(topic)).thenReturn(topic);
        when(mockIdentifiableManager.getIdentifiableByTypeAndId(comment.getAttachType(), comment.getAttachId())).thenReturn(
                mockIdentifiable);
        doNothing().when(mockSubscriberService).generateSubscribers(any(Subscribable.class), any(User.class));
        doNothing().when(mockSubscriberService).addSubscribers(any(Subscribable.class));

        Comment comment1 = mockCommentServiceImpl.create(comment);
        verify(mockCommentMapper).insertSelective(comment);
        verify(mockTopicService).buildTopicFromComment(comment, ModuleHelper.projectId);
        verify(mockTopicService).createOrUpdateTopic(topic);
        verify(mockIdentifiableManager).getIdentifiableByTypeAndId(comment.getAttachType(), comment.getAttachId());
        verify(mockSubscriberService).generateSubscribers(any(Subscribable.class), any(User.class));
        verify(mockSubscriberService).addSubscribers(any(Subscribable.class));

        assertEquals(false, comment1.getDeleted());
        assertNotNull(comment1.getCreated());
        assertTrue(ModuleHelper.compareCreatedItemDateWithToday(comment1.getCreated()));
        assertEquals(comment1.getUpdated(), comment.getCreated());
        assertEquals(ModuleHelper.creatorName, comment1.getCreatorName());

    }

    @Test
    public void testCreateComment2() {
        BaseProjectItem mockIdentifiable = mock(Subscribable.class);
        when(mockSessionService.getCurrentUser()).thenReturn(user);
        when(mockUserService.getById(comment.getCreatorId())).thenReturn(new User(ModuleHelper.creatorId));
        when(mockTopicService.buildTopicFromComment(comment, comment.getProjectId())).thenReturn(topic);
        when(mockTopicService.createOrUpdateTopic(topic)).thenReturn(topic);
        when(mockIdentifiableManager.getIdentifiableByTypeAndId(comment.getAttachType(), comment.getAttachId())).thenReturn(
                mockIdentifiable);
        doNothing().when(mockSubscriberService).generateSubscribers(any(Subscribable.class), any(User.class));
        doNothing().when(mockSubscriberService).addSubscribers(any(Subscribable.class));
        List<Attachment> resultAttachmentList = new ArrayList<Attachment>();
        Attachment resultAttachment = getAAttachment();
        resultAttachmentList.add(resultAttachment);
        when(mockAttachmentService.addAttachmentsForAttachable(comment, attachmentList)).thenReturn(resultAttachmentList);

        comment.setAttachments(attachmentList);

        Comment comment1 = mockCommentServiceImpl.create(comment);

        verify(mockCommentMapper).insertSelective(comment);
        verify(mockTopicService).buildTopicFromComment(comment, ModuleHelper.projectId);
        verify(mockTopicService).createOrUpdateTopic(topic);
        verify(mockIdentifiableManager).getIdentifiableByTypeAndId(comment.getAttachType(), comment.getAttachId());
        verify(mockSubscriberService).generateSubscribers(any(Subscribable.class), any(User.class));
        verify(mockSubscriberService).addSubscribers(any(Subscribable.class));
        verify(mockAttachmentService).addAttachmentsForAttachable(comment, attachmentList);

        assertEquals(resultAttachmentList, comment1.getAttachments());
        assertEquals(resultAttachment, comment1.getAttachments().get(0));
        assertEquals(false, comment1.getDeleted());
        assertNotNull(comment1.getCreated());
        assertTrue(ModuleHelper.compareCreatedItemDateWithToday(comment1.getCreated()));
        assertEquals(comment1.getUpdated(), comment.getCreated());
        assertEquals(ModuleHelper.creatorName, comment1.getCreatorName());

    }

    /**
     * 当前topic显示为discussion
     */
    private void mockTopicCurrentShowDiscussion() {

        Comment comment = getAComment();
        comment.setUpdated(ModuleHelper.updated);
        comment.setAttachType(new Discussion().getType());
        ArrayList<Comment> comments = new ArrayList<Comment>();
        comments.add(comment);
        when(mockCommentMapper.selectByExample(any(CommentExample.class))).thenReturn(comments);

        Discussion discussion = new Discussion();
        discussion.setUpdated(ModuleHelper.updated);
        when(mockDiscussionService.getById(anyInt())).thenReturn(discussion);
    }

    /**
     * 当前topic显示为discussion时，不应该对topicService进行任何操作
     */
    private void verifyTopicCurrentShowDiscussion() {
        verify(mockTopicService, times(0)).createOrUpdateTopic(any(Topic.class));
        verify(mockTopicService, times(0)).updateTopic(any(Topic.class));
        verify(mockTopicService, times(0)).deleteTopcic(anyInt());
        verify(mockTopicService, times(0)).discardTopcicByTypeAndId(anyString(), anyInt());
    }

    /**
     * 当前topic显示为其他Comment
     */
    private void mockTopicCurrentShowOtherComment() {
        Comment otherComment = getAComment();
        otherComment.setId(ModuleHelper.id + 1);
        otherComment.setUpdated(ModuleHelper.updated);
        otherComment.setAttachType(new Discussion().getType());
        ArrayList<Comment> comments = new ArrayList<Comment>();
        comments.add(otherComment);
        when(mockCommentMapper.selectByExample(any(CommentExample.class))).thenReturn(comments);

        Discussion discussion = new Discussion();
        discussion.setUpdated(ModuleHelper.updated);
        when(mockDiscussionService.getById(anyInt())).thenReturn(discussion);
    }

    /**
     * 当前topic显示为其他Comment时，不应该对topic进行任何操作
     */
    private void verifyTopicCurrentShowOtherComment() {
        verify(mockTopicService, times(0)).createOrUpdateTopic(any(Topic.class));
        verify(mockTopicService, times(0)).updateTopic(any(Topic.class));
        verify(mockTopicService, times(0)).deleteTopcic(anyInt());
        verify(mockTopicService, times(0)).discardTopcicByTypeAndId(anyString(), anyInt());
    }

    /**
     * 当前topic显示为Comment, 删除该Comment后最终删除该topic
     */
    private void mockTopicCurrentShowThisCommentDeleteTopic() {
        ArrayList<Comment> comments = new ArrayList<Comment>();
        comments.add(comment);
        comment.setAttachType(new Todo().getType());
        when(mockCommentMapper.selectByExample(any(CommentExample.class))).thenReturn(comments);
    }

    /**
     * 验证topic操作是否正确
     */
    private void verifyTopicCurrentShowThisCommentDeleteTopic() {
        verify(mockTopicService, times(0)).createOrUpdateTopic(any(Topic.class));
        verify(mockTopicService, times(0)).updateTopic(any(Topic.class));
        verify(mockTopicService).discardTopcicByTypeAndId(comment.getAttachType(), comment.getAttachId());
    }

    /**
     * 当前topic显示为Comment, 删除topic显示discussion
     */
    private void mockTopicCurrentShowThisCommentUpdateWithDiscussion() {
        ArrayList<Comment> comments = new ArrayList<Comment>();
        comments.add(comment);
        comment.setAttachType(new Discussion().getType());
        when(mockCommentMapper.selectByExample(any(CommentExample.class))).thenReturn(comments);

        Discussion discussion = new Discussion();
        discussion.setUpdated(ModuleHelper.updated);
        when(mockDiscussionService.getById(anyInt())).thenReturn(discussion);
    }

    /**
     * 验证topic操作是否正确
     */
    private void verifyTopicCurrentShowThisCommentUpdateWithDiscussion() {
        verify(mockTopicService, times(0)).deleteTopcic(anyInt());
        verify(mockTopicService, times(0)).discardTopcicByTypeAndId(anyString(), anyInt());
        verify(mockTopicService).createOrUpdateTopic(any(Topic.class));
    }

    /**
     * 当前topic显示为Comment, 删除topic显示其他Comment
     */
    private void mockTopicCurrentShowThisCommentUpdateWithOtherComment() {
        Comment otherComment = getAComment();
        otherComment.setUpdated(ModuleHelper.updated);
        otherComment.setId(ModuleHelper.id + 1);
        comment.setAttachType(new Todo().getType());
        ArrayList<Comment> comments = new ArrayList<Comment>();
        comments.add(comment);
        comments.add(otherComment);
        when(mockCommentMapper.selectByExample(any(CommentExample.class))).thenReturn(comments);
    }

    /**
     * 验证topic操作是否正确
     */
    private void verifyTopicCurrentShowThisCommentUpdateWithOtherComment() {
        verify(mockTopicService, times(0)).deleteTopcic(anyInt());
        verify(mockTopicService, times(0)).discardTopcicByTypeAndId(anyString(), anyInt());
        verify(mockTopicService).createOrUpdateTopic(any(Topic.class));
    }

    @Test
    public void testDeleteComment() {
        mockCommentServiceImpl.deleteFromTrash(ModuleHelper.id);
        verify(mockCommentMapper).deleteByPrimaryKey(ModuleHelper.id);
        verify(mockAttachmentService).deleteAttachmentByAttachTypeAndId(new Comment().getType(), ModuleHelper.id);
    }

    private void verifyNormalDiscardComment() {
        verify(mockCommentMapper).updateByPrimaryKeySelective(argThat(new ObjectMatcher<Comment>() {

            @Override
            public boolean verifymatches(Comment item) {
                return item.getId().equals(ModuleHelper.id) && item.getDeleted().equals(true);
            }
        }));
        verify(mockAttachmentService).discardAttachment(comment.getType(), comment.getId());
    }

    // @Test
    // public void testDiscardCommentWhenTopicCurrentShowDiscussion() {
    // mockTopicCurrentShowDiscussion();
    // mockCommentServiceImpl.delete(ModuleHelper.id);
    // verifyTopicCurrentShowDiscussion();
    // verifyNormalDiscardComment();
    // }
    //
    // @Test
    // public void testDiscardCommentWhenTopicCurrentShowOtherComment() {
    // mockTopicCurrentShowOtherComment();
    //
    // Comment result = mockCommentServiceImpl.discardComment(comment);
    //
    // verifyTopicCurrentShowOtherComment();
    // verifyNormalDiscardComment(result);
    // }
    //
    // @Test
    // public void testDiscardCommentWhenTopicCurrentShowThisCommentDeleteTopic() {
    // mockTopicCurrentShowThisCommentDeleteTopic();
    //
    // Comment result = mockCommentServiceImpl.discardComment(comment);
    //
    // verifyTopicCurrentShowThisCommentDeleteTopic();
    // verifyNormalDiscardComment(result);
    // }
    //
    // @Test
    // public void testDiscardCommentWhenTopicCurrentShowThisCommentUpdateWithDiscussion() {
    // mockTopicCurrentShowThisCommentUpdateWithDiscussion();
    //
    // Comment result = mockCommentServiceImpl.discardComment(comment);
    //
    // verifyTopicCurrentShowThisCommentUpdateWithDiscussion();
    // verifyNormalDiscardComment(result);
    // }
    //
    // @Test
    // public void testDiscardCommentWhenTopicCurrentShowThisCommentUpdateWithOtherComment() {
    // mockTopicCurrentShowThisCommentUpdateWithOtherComment();
    //
    // Comment result = mockCommentServiceImpl.discardComment(comment);
    //
    // verifyTopicCurrentShowThisCommentUpdateWithOtherComment();
    // verifyNormalDiscardComment(result);
    // }

    @Test
    public void testUpdateComment() {
        final String newContent = "new content";
        comment.setContent(newContent);

        mockCommentServiceImpl.updateSelective(comment);

        verify(mockTopicService).createOrUpdateTopic(any(Topic.class));
        verify(mockCommentMapper).updateByPrimaryKeySelective(argThat(new ObjectMatcher<Comment>() {
            @Override
            public boolean verifymatches(Comment item) {
                return item.getId().equals(ModuleHelper.id) && item.getContent().equals(newContent);
            }
        }));
    }

    @Test
    public void testUpdateCommentWithContentNull() {
        comment.setContent(null);

        mockCommentServiceImpl.updateSelective(comment);

        verify(mockTopicService, times(0)).createOrUpdateTopic(any(Topic.class));
        verify(mockCommentMapper).updateByPrimaryKeySelective(argThat(new ObjectMatcher<Comment>() {
            @Override
            public boolean verifymatches(Comment item) {
                return item.getId().equals(ModuleHelper.id) && item.getContent() == null;
            }
        }));
    }

    @Test
    public void testGetCommentTarget() {
        mockCommentServiceImpl.getCommentTarget(comment.getAttachType(), comment.getAttachId());

        verify(mockIdentifiableManager).getIdentifiableByTypeAndId(ModuleHelper.attachType, ModuleHelper.attachId);

    }
}
