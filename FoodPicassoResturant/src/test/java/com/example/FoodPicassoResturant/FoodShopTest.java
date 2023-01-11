package com.example.FoodPicassoResturant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.example.FoodPicassoResturant.exception.InvalidFoodOrderException;
import com.example.FoodPicassoResturant.model.FoodOrder;
import com.example.FoodPicassoResturant.util.FoodShop;

public class FoodShopTest {

	private static FoodShop bObj;
	private static FoodShop bObj1;

	static FoodOrder b1;
	static FoodOrder b2;
	static FoodOrder b3;

	@BeforeAll
	public static void setUp() throws Exception {

		bObj = new FoodShop();

		b1 = new FoodOrder(1, "Asir", "Pizza", "Veg", 1, "FastDelivery", (double) 200);

		b2 = new FoodOrder(2, "Prasanth", "Burger", "Veg", 2, "NormalDelivery", (double) 150);

		b3 = new FoodOrder(3, "Rishi", "Sandwich", "Veg", 1, "NormalDelivery", (double) 100);

		List<FoodOrder> food = new ArrayList<>();
		food.add(b1);
		food.add(b2);
		food.add(b3);
		bObj.setFoodOrderList(food);

		bObj1 = new FoodShop();

		List<FoodOrder> food1 = new ArrayList<>();

		bObj1.setFoodOrderList(food1);

	}

	@Test
	public void test11ViewFoodOrdersByFoodType() throws InvalidFoodOrderException {
		List<FoodOrder> result;
		result = bObj.viewFoodOrdersByFoodType("Veg");
		assertEquals(3, result.size()); // Returns the number of food type matches - 3
		result = bObj.viewFoodOrdersByFoodType("Non-Veg");
		assertEquals(0, result.size()); // Returns the number of food type matches - 0
	}

	@Test
	public void test12ViewFoodOrdersByFoodTypeWise() throws InvalidFoodOrderException {

		Map<String, List<FoodOrder>> result = bObj.viewFoodOrdersByFoodTypeWise();
		assertEquals(true, result.containsKey("Veg")); // Returns the value as "true" - foodtype is present
		assertEquals(false, result.containsKey("Non-Veg")); // Returns the value as "false" - foodtype not present

	}

	@Test
	public void test13ViewFoodOrdersByFoodTypeForEmptyList() throws InvalidFoodOrderException {

		// As the List bObj1 is null - throws InvalidFoodOrderException
		assertThrows(InvalidFoodOrderException.class, () -> bObj1.viewFoodOrdersByFoodType("Veg"));
	}

	@Test
	public void test14ViewFoodOrdersByFoodTypeWiseForEmptyList() {

		// As the List bObj1 is null - throws InvalidFoodOrderException
		assertThrows(InvalidFoodOrderException.class, () -> bObj1.viewFoodOrdersByFoodTypeWise());
	}

}
