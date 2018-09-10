package test;


import org.junit.Assert;
import org.junit.Test;

import com.cg.shop.CapGeminiCart;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by LalinPethiyagoda on 10/09/2018.
 */

public class CapGeminiTest {

    CapGeminiCart cart;

    @Test
    public void happyPath(){

        String itemsList = "apple,orange";
        List<String> list = new ArrayList<String>(Arrays.asList(itemsList.split(",")));
        cart = new CapGeminiCart(list);
        BigDecimal total = cart.getCartTotal();
        Assert.assertEquals(new BigDecimal("0.75"),total);

    }

    @Test
    public void test_two_for_one_apple_offer(){

        String itemsList = "apple,apple,orange";
        List<String> list = new ArrayList<String>(Arrays.asList(itemsList.split(",")));
        cart = new CapGeminiCart(list);
        BigDecimal total = cart.getCartTotal();
        Assert.assertEquals(new BigDecimal("0.75"),total);
    }

    @Test
    public void test_three_for_two_orange_offer(){

        String itemsList = "apple,apple,orange,orange,orange,orange";
        List<String> list = new ArrayList<String>(Arrays.asList(itemsList.split(",")));
        cart = new CapGeminiCart(list);
        BigDecimal total = cart.getCartTotal();
        Assert.assertEquals(new BigDecimal("1.75"),total);
    }

    @Test
    public void test_three_for_two_orange_by_one_get_one_apple_offer(){

        String itemsList = "apple,apple,apple,apple,apple,orange,orange,orange,orange";
        List<String> list = new ArrayList<String>(Arrays.asList(itemsList.split(",")));
        cart = new CapGeminiCart(list);
        BigDecimal total = cart.getCartTotal();
        Assert.assertEquals(new BigDecimal("2.25"),total);
    }

    @Test
    public void test_empty_list_returns_zero(){

        String itemsList = "";
        List<String> list = new ArrayList<String>(Arrays.asList(itemsList.split(",")));
        cart = new CapGeminiCart(list);
        BigDecimal total = cart.getCartTotal();
        Assert.assertEquals(new BigDecimal("0.00"),total);
    }


}
