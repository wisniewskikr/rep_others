describe("function add()", function() {
	it ("adds simple numbers", function() {
		expect(add(0, 0)).toBe(0);
		expect(add(1, 0)).toBe(1);
		expect(add(0, 1)).toBe(1);
		expect(add(1, 1)).toBe(2);

		// example of test error
		//expect(add(1, 1)).toBe(3);

		expect(add(1, -10)).toBe(-9);
		expect(add(-10, 1)).toBe(-9);
		expect(add(-1, -10)).toBe(-11);
	});


	it ("adds large numbers", function() {
		expect(add(900000, 99999)).toBe(999999);
		expect(isNaN(add(900001, 99999))).toBeTruthy();
	});
});

describe("function subtract()", function() {
	it("subtracts simple numbers", function() {
		expect(subtract(0, 0)).toBe(0);
		expect(subtract(0, 1)).toBe(-1);
		expect(subtract(1, 0)).toBe(1);
		expect(subtract(1, 1)).toBe(0);
		
		// example of test error
		//expect(subtract(1, 1)).toBe(3);

		expect(subtract(2, 7)).toBe(-5);
		expect(subtract(7, 2)).toBe(5);
	});


	it("subtracts large numbers", function() {
		expect(subtract(-900000, 99999)).toBe(-999999);
		expect(isNaN(subtract(-900001, 99999))).toBeTruthy();
	});
});
