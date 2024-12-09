package com.education.ztu.spring.controller;

import com.education.ztu.spring.entity.TodoItem;
import com.education.ztu.spring.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.constraints.NotNull;

@Controller
@RequestMapping("/todo")
public class TodoItemController {

    private final TodoService todoService;

    public TodoItemController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        TodoItem todoItem = todoService.getTodoItemById(id);
        model.addAttribute("todoItem", todoItem);
        return "edit";
    }

    @PostMapping("/edit")
    public String editTodoItem(@ModelAttribute TodoItem item) {
        todoService.saveTodoItem(item);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") @NotNull Long id) {
        todoService.deleteTodoItemById(id);
        return "redirect:/";
    }
}