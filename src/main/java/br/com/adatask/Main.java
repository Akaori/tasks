package br.com.adatask;

import br.com.adatask.controller.Controller;
import br.com.adatask.repository.ListRepository;
import br.com.adatask.service.impl.ServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Controller controller = new Controller(new ServiceImpl(new ListRepository<>()));

        Scanner scanner = new Scanner(System.in);
        String opcao = "-1";

        while (!opcao.equals("0")) {
            controller.showMenu();
            opcao = scanner.nextLine();
            controller.processCommand(opcao);
            System.out.println("--------------------------------");
        }

        scanner.close();
    }
}