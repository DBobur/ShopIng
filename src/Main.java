import shop.model.Order;
import shop.model.Product;
import shop.model.User;
import shop.service.OrderService;
import shop.service.ProductService;
import shop.service.UserService;

import java.util.Scanner;

public class Main {
    static Scanner scInt =  new Scanner(System.in);
    static Scanner scStr =  new Scanner(System.in);
    static User user = null;
    static UserService userService = new UserService();
    static ProductService productService = new ProductService();
    static OrderService orderService = new OrderService();
    public static void main(String[] args) {
        while (true){
            System.out.println("1. SignIn\t2. SignUp\t0.Exit");
            System.out.print(">>");
            int i = scInt.nextInt();
            switch (i){
                case 1 -> {
                    signIn();
                }

                case 2 -> {
                    signUp();
                }
                case 0 -> {
                    return;
                }
            }
        }
    }

    private static void signIn() {
        System.out.print("username: ");
        String username = scStr.nextLine();
        System.out.print("password: ");
        String password = scStr.nextLine();
        user = userService.signIn(username,password);
        if(user != null){
            if(user.getState()){
                adminMenu();
            }else {
                userMenu();
            }
        }
    }

    private static void userMenu() {
        while (true){
            System.out.println("1. Order\t2.Show\t3.UpdateProfile\t0.LogOut");
            System.out.print(">>");
            int i = scInt.nextInt();
            switch (i){
                case 1 -> {
                   order();
                }
                case 2 -> {
                    orderShow();
                }
                case 3 -> {
                    updateProfile();
                }
                case 0 -> {
                    return;
                }
            }
    }

}

    private static void orderShow() {
        Order[] myOrder = orderService.show(user.getId());
        for (int i = 0; i < myOrder.length; i++) {
            System.out.println(myOrder[i].toList());
        }
    }

    private static void order() {
        productService.ShowList();
        System.out.print("enter product number: ");
        int i = scInt.nextInt();
        Product product = productService.buy(i);
        Order order = new Order(user.getId(), product.getId());
        if (orderService.add(order)){
            System.out.println("Ordered!!!");
        }else {
            System.out.println("Error!!!");
        }

    }

    private static void adminMenu() {
        while (true){
            System.out.println("1. Create\t2.Show\t3.Delete\t0.LogOut");
            System.out.print(">>");
            int i = scInt.nextInt();
            switch (i){
                case 1 -> {
                    create();
                }
                case 2 -> {
                    show();
                }
                case 3 -> {
                    delete();
                }
                case 0 -> {
                    return;
                }
            }
        }
    }

    private static void delete() {
        show();
        System.out.print("enter productNumber: ");
        int number = scInt.nextInt();
        if(productService.delete(user.getId(),number)){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }

    private static void show() {
        Product[] myProduct = productService.show(user.getId());
        int j = 1;
        for (int i = 0; i < myProduct.length; i++) {
            System.out.println((j++)+" "+myProduct[i].toString());
        }
    }

    private static void create() {
        System.out.print("name: ");
        String name = scStr.nextLine();
        System.out.print("price: ");
        double price = scInt.nextDouble();
        if(productService.add(new Product(user.getId(),name,price))){
            System.out.println("Created!!!");
        }else{
            System.out.println("Error???");
        }
    }

    private static void signUp() {
        System.out.print("name: ");
        String name = scStr.nextLine();
        System.out.print("username: ");
        String username = scStr.nextLine();
        System.out.print("password: ");
        String password = scStr.nextLine();
        if(userService.add(new User(name,username,password))){
            System.out.println("Welcome!!!");
        }else{
            System.out.println("Error???");
        }

    }

    private static void updateProfile() {
        System.out.print("1. ToAdmin\t2. ToUser");
        int i =scInt.nextInt();
        if(i==1){
            user.setState(true);
        }else {
            user.setState(false);
        }
    }
    }