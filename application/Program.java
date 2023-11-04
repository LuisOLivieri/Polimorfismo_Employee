package application;

import entities.Employee;
import entities.OutsourceEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.print("Enter a number Employee: ");
        int N = sc.nextInt();
        for(int i = 1; i <= N; i++){
            System.out.println("Employee #" + (i) + " data:");
            System.out.print("Outsourced (y/n)? "); //TERCEIZADO S OU NAO ?
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine(); //Consumir quebra de linha
            String name = sc.nextLine();
            System.out.print("Hours: ");
            int hours = sc.nextInt();
            System.out.print("Value per Hour: ");
            double valuePerHour = sc.nextDouble();
            if (ch == 'y'){ //Se a respota for sim (Y)
                System.out.print("Addtional charge: ");
                double additionalCharge = sc.nextDouble();
                Employee emp = new OutsourceEmployee(name, hours, valuePerHour, additionalCharge); //Instancia fun terce
                list.add(emp); //adicionar na lista
            } else {
                Employee emp = new Employee(name, hours, valuePerHour);//Intanciar fun normal
                list.add(emp);
            }

        }

        System.out.println();
        System.out.println("PAYMENTS: ");
        for(Employee emp : list){ //Para cada func emp na lista
            System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));
        }


        sc.close();

    }
}