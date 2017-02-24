package org.amadeus.charon.data;
import junit.framework.TestCase;

public class RegisterTest extends TestCase {

	private static final String[] goodUsernames={"joe"};
	private static final String[] goodPassword={"ABC12345"};
	private static final String[] goodEmail={"joe@email.com"};
	
	private static final String[] badUsernames={"","joe","joe"};
	private static final String[] badPassword={"","1234567","123456789"};
	private static final String[] badEmail={"","joe@email.com","bademailnotarealemail"};
		
	public void testBadRegistration(){
		UserManager userManager = UserManager.getInstance();
		assertNotNull(userManager);
		for(int i=0;i<badUsernames.length;i++){
			boolean success = userManager.register(badUsernames[i], 
					badEmail[i], badPassword[i]);
			assertFalse(success);
		}
	}
	public void testGoodRegistration(){
		UserManager userManager = UserManager.getInstance();
		assertNotNull(userManager);
		for(int i=0;i<goodUsernames.length;i++){
			boolean success = userManager.register(goodUsernames[i], 
					goodEmail[i], goodPassword[i]);
			assertTrue(success);
		}
	}
	
}

