package entity;

public class Todolist {
    /*
        entity ini adalah representasi dari data

        kemudian bisanya kalau mau pake datanya yaa pake tipe data class entity nya
     */
    private String todo;

    public Todolist() {
    }

    public Todolist(String todo) {
        this.todo = todo;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }
}
