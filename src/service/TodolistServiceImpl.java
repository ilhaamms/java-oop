package service;

import entity.Todolist;
import repository.TodolistRepository;

/*
    buatlah class yang mengimplementasi interface service dengan nama file diakhirnya ada impl
 */
public class TodolistServiceImpl implements TodolistService{

    /*
        karna service ini manggil repository, maka kita buat todolistRepository
        dengan tipe data interface si TodolistRepository

        kemudian bikin juga constructor dengan parameter yang bertipe data TodolistRepository
     */
    private TodolistRepository todolistRepository;

    public TodolistServiceImpl(TodolistRepository todolistRepository) {
        this.todolistRepository = todolistRepository;
    }

    @Override
    public void showTodolist() {
        Todolist[] model = todolistRepository.getAll(); // manggil method yang ada di repository

        System.out.println("TODOLIST");
        for (int i = 0; i < model.length; i++) {
            var no = i + 1;
            var todo = model[i];

            /*
                // pake getter, soalnya todo tipe data nya class
             */
            if (model[i] != null){
                System.out.println(no + ". " + todo.getTodo());
            }
        }
    }

    @Override
    public void addTodolist(String todo) {
        Todolist todolist = new Todolist(todo);
        todolistRepository.add(todolist);

        System.out.println("Sukses menambah todo : " + todo);
    }

    @Override
    public void removeTodolist(Integer number) {
        boolean success = todolistRepository.remove(number);
        if (success){
            System.out.println("Sukses menghapus todolist : " + number);
        }else{
            System.out.println("Gagal menghapus todolist : " + number);
        }
    }
}
