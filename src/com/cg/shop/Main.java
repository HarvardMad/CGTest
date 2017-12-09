package com.cg.shop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        System.out.println("Enter Basket Items");
        Scanner sc = new Scanner(System.in);
        String itemsList = sc.nextLine();
        List<String> list = new ArrayList<String>(Arrays.asList(itemsList.split(",")));
        CapGeminiCart cart = new CapGeminiCart(list);
        System.out.println(cart.getCartTotal());

    }
}
