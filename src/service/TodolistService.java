package service;

public interface TodolistService {
    /*
        service ini adalah business logicnya
        untuk package service pas bikin method biasanya diakhirnya ada nama entitynya
     */
    void showTodolist();
    void addTodolist(String todo);
    void removeTodolist(Integer number);
}
