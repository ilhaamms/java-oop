package test.service;

import entity.Todolist;
import repository.TodolistRepository;
import repository.TodolistRepositoryImpl;
import service.TodolistService;
import service.TodolistServiceImpl;

public class TodolistServiceTest {
    public static void main(String[] args) {
        testRemoveTodolist();
    }

    public static void testShowTodolist(){
        /*
            karna mau akses variabel data maka ada di TodolistRepositoryImpl

            memasukan data menggunakan new Todolist("Java"), karena data tipe datanya adalah class
         */
        TodolistRepositoryImpl todolistRepository = new TodolistRepositoryImpl();
        todolistRepository.data[0] = new Todolist("Java");
        todolistRepository.data[1] = new Todolist("Java OOP");
        todolistRepository.data[2] = new Todolist("Java Classes");

        /*
            karna mau manggil method showTodolist() yang ada di interface TodolistService
            maka kita bisa di polimorphism dengan TodolistServiceImpl

            jadi intinya karna tipe interface ini bisa dibilang sebuah parent
            maka bisa berubah bentuk menjadi class yang meng-extends nya
            atau bisa dibilang polimorphism
         */
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
        todolistService.showTodolist();
    }

    public static void testAddTodolist(){
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);

        todolistService.addTodolist("Fiber");
        todolistService.addTodolist("Gin");
        todolistService.addTodolist("Spring Boot");

        todolistService.showTodolist();
    }

    public static void testRemoveTodolist(){
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);

        todolistService.addTodolist("Gin");
        todolistService.addTodolist("Fiber");
        todolistService.addTodolist("Spring Boot");

        todolistService.showTodolist();

        todolistService.removeTodolist(1);
        todolistService.removeTodolist(4);
        todolistService.removeTodolist(2);
        todolistService.removeTodolist(5);
        todolistService.removeTodolist(1);

        todolistService.showTodolist();
    }
}
