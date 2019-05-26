package expenseMain;

import org.testng.annotations.DataProvider;

public class TestData {

	
 	@DataProvider(name="InputExpense")
 	public Object[][] addDataE() {
 		return new Object[][] {
 			{"21", "04", "2019", "books", "10", "yoga"},
 			{"11", "05", "2019", "movie", "11", "5th element"},
 			{"12", "05", "2019", "shopping", "11", "5th element"}
 		};
 	}
 		
	
	@DataProvider(name="InputCategory")
	public Object[][] addDataC() {
		return new Object[][] {
			{"yoga"}, 
				{"books"}, 
				{"music"}, 
				{"movie"},
				{"shopping"}};
		}
	
	@DataProvider(name="RegUserNow")
	public Object[][] RegUser() {
		return new Object[][] {
			{"friend", "friend", "friend"}
				
		};
		
	}
	
}
	

