package core;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StringManipulationTest {

	@Rule
	public ExpectedException mEE = ExpectedException.none();

	@Test
	public void PalindromeTest(){
		Assert.assertTrue( StringManipulation.getPalindrome( "abcba" ) );
		Assert.assertFalse( StringManipulation.getPalindrome( "aBcba" ) );
		Assert.assertFalse( StringManipulation.getPalindrome( "coreramiro" ) );
		Assert.assertTrue( StringManipulation.getPalindrome( "core ramiro orimar eroc" ) );
		
	}

	@Test
	public void PalindromeTestNull(){
		this.mEE.expect( NullPointerException.class );
		Assert.assertTrue( StringManipulation.getPalindrome( null ) );
		
	}
}
