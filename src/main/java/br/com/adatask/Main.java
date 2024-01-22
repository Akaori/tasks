package br.com.adatask;

import br.com.adatask.controller.Controller;
import br.com.adatask.repository.ListRepository;
import br.com.adatask.service.Service;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Controller controller = new Controller(new Service(new ListRepository<>()));
        controller.showMenu();

        Scanner scanner = new Scanner(System.in);
        String opcao = scanner.nextLine();
        controller.processCommand(opcao);

        while (!opcao.equals("0")) {
            controller.showMenu();
            opcao = scanner.nextLine();
            controller.processCommand(opcao);
        }
    }
}