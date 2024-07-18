package view;

import service.TodolistService;
import util.InputUtil;

public class TodolistView {
    /*
        untuk view gaada interfacenya
     */

    private TodolistService todolistService;

    public TodolistView(TodolistService todolistService) {
        this.todolistService = todolistService;
    }

    public void showTodolist(){
        while (true){
            todolistService.showTodolist();

            System.out.println("MENU");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x  Keluar");

            /*
                kalau di java ngebandingin pake == untuk tipe data number aja
                kalau tipe data string pakenya equals
             */
            var input = InputUtil.input("Pilih");
            if (input.equals("1")){
                addTodolist();
            }else if(input.equals("2")){
                removeTodolist();
            }else if (input.equals("x")){
                break;
            }else{
                System.out.println("Pilihan tidak dimenegerti");
            }
        }
    }

    public void addTodolist(){
        System.out.println("MENAMBAH TODOLIST");

        String todo = InputUtil.input("Todo (x jika batal) ");
        if (todo.equals("x")){

        }else{
            todolistService.addTodolist(todo);
        }
    }

    public void removeTodolist(){
        var number = InputUtil.input("Nomor yang dihapus (x jika batal) ");
        if (number.equals("x")){

        }else{
            todolistService.removeTodolist(Integer.valueOf(number));
        }
    }
}
