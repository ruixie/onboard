package com.onboard.domain.transform;

import org.springframework.beans.BeanUtils;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.onboard.domain.model.Todolist;
import com.onboard.dto.TodolistDTO;

public class TodolistTransform {

    public static final Function<Todolist, TodolistDTO> TODOLIST_DTO_FUNCTION = new Function<Todolist, TodolistDTO>() {
        @Override
        public TodolistDTO apply(Todolist input) {
            return todolistToTodolist(input);
        }
    };
    public static final Function<Todolist, TodolistDTO> TODOLIST_DTO_TODOS_FUNCTION = new Function<Todolist, TodolistDTO>() {
        @Override
        public TodolistDTO apply(Todolist input) {
            return todolistToTodolistWithTodos(input);
        }
    };
    public static final Function<Todolist, TodolistDTO> TODOLIST_DTO_ALL_FUNCTION = new Function<Todolist, TodolistDTO>() {
        @Override
        public TodolistDTO apply(Todolist input) {
            return todolistToTodolistWithDicardTodosAndCommentsAndTodos(input);
        }
    };

    public static TodolistDTO todolistToTodolist(Todolist todolist) {
        TodolistDTO todolistDTO = new TodolistDTO();
        BeanUtils.copyProperties(todolist, todolistDTO);
        return todolistDTO;
    }

    public static TodolistDTO todolistToTodolistWithTodos(Todolist todolist) {
        TodolistDTO todolistDTO = new TodolistDTO();
        BeanUtils.copyProperties(todolist, todolistDTO);
        if (todolist.getTodos() != null) {
            todolistDTO.setTodos(Lists.transform(todolist.getTodos(), TodoTransform.TODO_DTO_FUNCTION));
        }
        return todolistDTO;
    }

    public static TodolistDTO todolistToTodolistWithDicardTodosAndCommentsAndTodos(Todolist todolist) {
        TodolistDTO todolistDTO = new TodolistDTO();
        BeanUtils.copyProperties(todolist, todolistDTO);
        if (todolist.getTodos() != null) {
            todolistDTO.setTodos(Lists.transform(todolist.getTodos(), TodoTransform.TODO_DTO_FUNCTION));
        }
        if (todolist.getDicardTodos() != null) {
            todolistDTO.setDicardTodos(Lists.transform(todolist.getDicardTodos(), TodoTransform.TODO_DTO_FUNCTION));
        }
        if (todolist.getComments() != null) {
            todolistDTO.setComments(Lists.transform(todolist.getComments(), CommentTransform.COMMENT_TO_DTO_FUNCTION));
        }
        if (todolist.getSubscribers() != null) {
            todolistDTO.setSubscribers(Lists.transform(todolist.getSubscribers(), UserTransform.USER_TO_USERDTO_FUNCTION));
        }
        return todolistDTO;
    }
}
