package br.com.adatask.controller;

import br.com.adatask.domain.BaseTask;
import br.com.adatask.domain.PersonalTask;
import br.com.adatask.domain.StudyTask;
import br.com.adatask.domain.WorkTask;
import br.com.adatask.domain.enums.Priority;
import br.com.adatask.service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class Controller {
    private Service service;

    public Controller(Service service) {
        this.service = service;
    }

    public void showMenu() {
        out.println("Bem-vindo ao AdaTask!");
        out.println("Escolha uma opção:");
        out.println("1 - Criar uma tarefa pessoal");
        out.println("2 - Criar uma tarefa de trabalho");
        out.println("3 - Criar uma tarefa de estudo");
        out.println("4 - Editar uma tarefa");
        out.println("5 - Remover uma tarefa");
        out.println("6 - Listar todas as tarefas");
        out.println("7 - Filtrar as tarefas por tipo");
        out.println("0 - Sair");
    }

    public void processCommand(String command) {
        Scanner scanner = new Scanner(System.in);
        switch (command) {
            case "1":
                out.println("Digite o título da tarefa:");
                String title = scanner.nextLine();
                out.println("Digite a descrição da tarefa:");
                String description = scanner.nextLine();
                out.println("Digite o prazo da tarefa:");
                String deadline = scanner.nextLine();
                out.println("Digite a prioridade da tarefa:");
                String priority = scanner.nextLine();
                service.createPersonalTask(title, description, deadline, Priority.valueOf(priority));
                out.println("Tarefa pessoal criada com sucesso!");
                break;
            case "2":
                out.println("Digite o título da tarefa:");
                title = scanner.nextLine();
                out.println("Digite a descrição da tarefa:");
                description = scanner.nextLine();
                out.println("Digite o prazo da tarefa:");
                deadline = scanner.nextLine();
                out.println("Digite a categoria da tarefa:");
                String category = scanner.nextLine();
                service.createWorkTask(title, description, deadline, category);
                out.println("Tarefa de trabalho criada com sucesso!");
                break;
            case "3":
                out.println("Digite o título da tarefa:");
                title = scanner.nextLine();
                out.println("Digite a descrição da tarefa:");
                description = scanner.nextLine();
                out.println("Digite o prazo da tarefa:");
                deadline = scanner.nextLine();
                out.println("Digite o status da tarefa:");
                String status = scanner.nextLine();
                service.createStudyTask(title, description, deadline, status);
                out.println("Tarefa de estudo criada com sucesso!");
                break;
            case "4":
                out.println("Digite o título da tarefa que deseja editar:");
                title = scanner.nextLine();
                BaseTask task = service.filterTask(title);
                if (task != null) {
                    out.println("Digite o novo título da tarefa ou deixe em branco para manter o atual:");
                    String newTitle = scanner.nextLine();
                    out.println("Digite a nova descrição da tarefa ou deixe em branco para manter a atual:");
                    String newDescription = scanner.nextLine();
                    out.println("Digite o novo prazo da tarefa ou deixe em branco para manter o atual:");
                    String newDeadline = scanner.nextLine();
                    String newPriority = null;
                    String newCategory = null;
                    String newStatus = null;
                    if (task instanceof PersonalTask) {
                        out.println("Digite a nova prioridade da tarefa ou deixe em branco para manter a atual:");
                        newPriority = scanner.nextLine();
                    } else if (task instanceof WorkTask) {
                        out.println("Digite a nova categoria da tarefa ou deixe em branco para manter a atual:");
                        newCategory = scanner.nextLine();
                    } else if (task instanceof StudyTask) {
                        out.println("Digite o novo status da tarefa ou deixe em branco para manter o atual:");
                        newStatus = scanner.nextLine();
                    }
                    service.editTask(title, newTitle, newDescription, newDeadline, Priority.valueOf(newPriority), newCategory, newStatus);
                    out.println("Tarefa editada com sucesso!");
                } else {
                    out.println("Tarefa não encontrada!");
                }
                break;
            case "5":
                out.println("Digite o título da tarefa que deseja remover:");
                title = scanner.nextLine();
                service.removeTask(title);
                out.println("Tarefa removida com sucesso!");
                break;
            case "6":
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
            case "7":
                out.println("Digite o tipo de tarefa que deseja filtrar:");
                out.println("1 - Tarefa pessoal");
                out.println("2 - Tarefa de trabalho");
                out.println("3 - Tarefa de estudo");
                String type = scanner.nextLine();
                switch (type) {
                    case "1":
                        tasks = service.filterByType(PersonalTask.class);
                        break;
                    case "2":
                        tasks = service.filterByType(WorkTask.class);
                        break;
                    case "3":
                        tasks = service.filterByType(StudyTask.class);
                        break;
                    default:
                        tasks = new ArrayList<>();
                        break;
                }
                if (tasks.isEmpty()) {
                    out.println("Não há tarefas do tipo solicitado!");
                } else {
                    out.println("Há " + tasks.size() + " tarefas do tipo solicitado:");
                    for (BaseTask t : tasks) {
                        out.println(t);
                    }
                }
                break;
            case "0":
                out.println("Obrigado por usar o AdaTask!");
        }

    }
}