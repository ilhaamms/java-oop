package test.view;

import repository.TodolistRepository;
import repository.TodolistRepositoryImpl;
import service.TodolistService;
import service.TodolistServiceImpl;
import view.TodolistView;

public class TodolistViewTest {
    public static void main(String[] args) {
        testRemoveTodolist();
    }

    public static void testShowTodolist(){
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
        TodolistView todolistView = new TodolistView(todolistService);

        todolistService.addTodolist("Java Dasar");
        todolistService.addTodolist("Java OOP");
        todolistService.addTodolist("Java SpringBoot");

        todolistView.showTodolist();
    }

    public static void testAddTodolist(){
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
        TodolistView todolistView = new TodolistView(todolistService);

        todolistService.showTodolist();

        todolistView.addTodolist();

        todolistService.showTodolist();

        todolistView.addTodolist();

        todolistService.showTodolist();
    }

    public static void testRemoveTodolist(){
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
        TodolistView todolistView = new TodolistView(todolistService);

        todolistService.addTodolist("Java Dasar");
        todolistService.addTodolist("Java OOP");
        todolistService.addTodolist("Java SpringBoot");

        todolistService.showTodolist();

        todolistView.removeTodolist();
        todolistService.showTodolist();


        todolistView.removeTodolist();
        todolistService.showTodolist();
    }
}
