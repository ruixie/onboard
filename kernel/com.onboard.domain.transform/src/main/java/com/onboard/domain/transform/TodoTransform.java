package com.onboard.domain.transform;

import org.springframework.beans.BeanUtils;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.onboard.domain.model.Project;
import com.onboard.domain.model.Todo;
import com.onboard.dto.TodoDTO;

public class TodoTransform {

    /**
     * only basic datas
     */
    public static final Function<Todo, TodoDTO> TODO_DTO_FUNCTION = new Function<Todo, TodoDTO>() {
        @Override
        public TodoDTO apply(Todo input) {
            TodoDTO result = todoToTodoDTO(input);
            Project project = input.getProject();
            if (project != null) {
                result.projectName = project.getName();
            }
            return result;
        }
    };

    public static TodoDTO todoToTodoDTO(Todo todo) {
        TodoDTO todoDTO = new TodoDTO();
        BeanUtils.copyProperties(todo, todoDTO);
        return todoDTO;
    }

    public static TodoDTO todoToTodoDTOWithComments(Todo todo) {
        TodoDTO todoDTO = new TodoDTO();
        BeanUtils.copyProperties(todo, todoDTO);
        if (todo.getComments() != null) {
            todoDTO.setComments(Lists.transform(todo.getComments(), CommentTransform.COMMENT_TO_DTO_FUNCTION));
        }
        if (todo.getSubscribers() != null) {
            todoDTO.setSubscribers(Lists.transform(todo.getSubscribers(), UserTransform.USER_TO_USERDTO_FUNCTION));
        }
        return todoDTO;
    }

}
