import repository.TodolistRepository;
import repository.TodolistRepositoryImpl;
import service.TodolistService;
import service.TodolistServiceImpl;
import view.TodolistView;

public class AplikasiTodolistV2 {
    public static void main(String[] args) {
        /*
            logic untuk data ada di repository
            logic untuk business ada di service
            logic untuk view ada di view
         */
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
        TodolistView todolistView = new TodolistView(todolistService);

        todolistView.showTodolist();
    }
}
