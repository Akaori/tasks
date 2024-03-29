package br.com.adatask.controller;

import br.com.adatask.domain.BaseTask;
import br.com.adatask.service.Service;
import jdk.jfr.Label;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class Controller {
    private final Service service;
    private final List<Class<? extends BaseTask>> tasksTypes;

    public Controller(Service service, List<Class<? extends BaseTask>> tasksTypes) {
        this.service = service;
        this.tasksTypes = tasksTypes;
    }

    public void showMenu() {
        out.println("Bem-vindo ao AdaTask!");
        out.println("Escolha uma opção:");
        out.println("1 - Criar uma tarefa");
        out.println("2 - Editar uma tarefa");
        out.println("3 - Remover uma tarefa");
        out.println("4 - Listar todas as tarefas");
        out.println("5 - Filtrar as tarefas por tipo");
        out.println("6 - Filtrar as tarefas por id");
        out.println("0 - Sair");
    }

    public void processCommand(String command) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        switch (command) {
            case "1":
                out.println("Digite o tipo de tarefa que deseja criar:");
                List<String> validAnswers = new ArrayList<>();
                for (int i=0; i<tasksTypes.size(); i++) {
                    validAnswers.add(String.valueOf(i+1));
                    out.println((i + 1) + " - Criar uma tarefa de " + tasksTypes.get(i).getAnnotation(Label.class).value());
                }
                String type = scanner.nextLine();
                if (validAnswers.contains(type)) {
                    Class taskClass = tasksTypes.get(Integer.parseInt(type) - 1);
                    out.println("Digite o título da tarefa:");
                    String title = scanner.nextLine();
                    out.println("Digite a descrição da tarefa:");
                    String description = scanner.nextLine();
                    out.println("Digite o prazo da tarefa:");
                    String deadline = scanner.nextLine();
                    service.createTask(taskClass, title, description, deadline);
                    out.println("Tarefa pessoal criada com sucesso!");
                } else {
                    out.println("Opção inválida!");
                }
                break;
            case "2":
                out.println("Digite o título da tarefa que deseja editar:");
                String title = scanner.nextLine();
                BaseTask task = service.filterTaskByTitle(title);
                if (task != null) {
                    out.println("Digite o novo título da tarefa:");
                    String newTitle = scanner.nextLine();
                    out.println("Digite a nova descrição da tarefa:");
                    String newDescription = scanner.nextLine();
                    out.println("Digite o novo prazo da tarefa:");
                    String newDeadline = scanner.nextLine();
                    service.editTask(title, newTitle, newDescription, newDeadline);
                    out.println("Tarefa editada com sucesso!");
                } else {
                    out.println("Tarefa não encontrada!");
                }
                break;
            case "3":
                out.println("Digite o título da tarefa que deseja remover:");
                title = scanner.nextLine();
                service.removeTask(title);
                out.println("Tarefa removida com sucesso!");
                break;
            case "4":
                List<BaseTask> tasks = service.listAllTasks();
                if (tasks.isEmpty()) {
                    out.println("Não há tarefas cadastradas!");
                } else {
                    out.println("Há " + tasks.size() + " tarefas cadastradas:");
                    for (BaseTask t : tasks) {
                        out.println(t);
                    }
                }
                break;
            case "5":
                out.println("Digite o tipo de tarefa que deseja filtrar:");
                validAnswers = new ArrayList<>();
                for (int i=0; i<tasksTypes.size(); i++) {
                    validAnswers.add(String.valueOf(i+1));
                    out.println((i + 1) + " - Filtrar tarefas de " + tasksTypes.get(i).getAnnotation(Label.class).value());
                }
                type = scanner.nextLine();
                if (validAnswers.contains(type)) {
                    Class taskClass = tasksTypes.get(Integer.parseInt(type) - 1);
                    tasks = service.filterByType(taskClass);
                    if (tasks.isEmpty()) {
                        out.println("Não há tarefas do tipo solicitado!");
                    } else {
                        out.println("Há " + tasks.size() + " tarefas do tipo solicitado:");
                        for (BaseTask t : tasks) {
                            out.println(t);
                        }
                    }
                } else {
                    out.println("Opção inválida");
                }
                break;
            case "6":
                out.println("Digite o id da tarefa que deseja filtrar:");
                String id = scanner.nextLine();
                task = service.filterTaskById(Long.parseLong(id));
                if (task != null) {
                    out.println(task);
                } else {
                    out.println("Não há tarefa com esse id.");
                }
                break;
            case "0":
                out.println("Obrigado por usar o AdaTask!");
                break;
            default:
                out.println("Essa opção não existe. Por favor, tente outra opção listada acima.");
        }

    }
}
