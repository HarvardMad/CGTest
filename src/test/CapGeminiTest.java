package test;


import com.cg.shop.CapGeminiCart;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

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
        BigDecimal expected = new BigDecimal("0.85").setScale(2,BigDecimal.ROUND_CEILING);
        Assert.assertEquals(expected,total.setScale(2,BigDecimal.ROUND_CEILING));

    }

    @Test
    public void test_two_for_one_apple_offer(){

        String itemsList = "apple,apple,orange";
        List<String> list = new ArrayList<String>(Arrays.asList(itemsList.split(",")));
        cart = new CapGeminiCart(list);
        BigDecimal total = cart.getCartTotal().setScale(2, RoundingMode.CEILING);
        Assert.assertEquals(new BigDecimal("0.85").setScale(2,BigDecimal.ROUND_CEILING),total);
    }

    @Test
    public void test_three_for_two_orange_offer(){

        String itemsList = "apple,apple,orange,orange,orange,orange";
        List<String> list = new ArrayList<String>(Arrays.asList(itemsList.split(",")));
        cart = new CapGeminiCart(list);
        float total = cart.getCartTotal().floatValue();
        Assert.assertEquals(new BigDecimal("2.05").floatValue(),total,00.00);
    }

    @Test
    public void test_three_for_two_orange_by_one_get_one_apple_offer(){

        String itemsList = "apple,apple,apple,apple,apple,orange,orange,orange,orange";
        List<String> list = new ArrayList<String>(Arrays.asList(itemsList.split(",")));
        cart = new CapGeminiCart(list);
        BigDecimal total = cart.getCartTotal().setScale(2,BigDecimal.ROUND_CEILING);
        Assert.assertEquals(new BigDecimal("2.55").setScale(2,BigDecimal.ROUND_CEILING),total);
    }

    @Test
    public void test_empty_list_returns_zero(){

        String itemsList = "";
        List<String> list = new ArrayList<String>(Arrays.asList(itemsList.split(",")));
        cart = new CapGeminiCart(list);
        BigDecimal total = cart.getCartTotal().setScale(2,BigDecimal.ROUND_CEILING);
        Assert.assertEquals(new BigDecimal("0.00").setScale(2,BigDecimal.ROUND_CEILING),total);
    }


}
