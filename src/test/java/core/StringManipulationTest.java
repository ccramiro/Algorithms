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

	@Test
	public void TestIPV4(){
		Assert.assertTrue( StringManipulation.validateIPV4("255.254.188.255") );
		Assert.assertTrue( StringManipulation.validateIPV4("255.245.188.123") );
		Assert.assertTrue( StringManipulation.validateIPV4("1.13.0.251") );
		Assert.assertFalse( StringManipulation.validateIPV4("122,13.35.251") );
		Assert.assertFalse( StringManipulation.validateIPV4("122.13.35.261") );
	}

	@Test
	public void TestIPV6(){
		Assert.assertTrue( StringManipulation.validateIPV6("ABCD:EF01:2345:6789:ABCD:EF01:2345:6789") );
		Assert.assertTrue( StringManipulation.validateIPV6("2001:DB8:0:0:8:800:200C:417A") );
		Assert.assertTrue( StringManipulation.validateIPV6("FF01:0:0:0:0:0:0:101") );
		Assert.assertTrue( StringManipulation.validateIPV6("0:0:0:0:0:0:0:1") );
		Assert.assertTrue( StringManipulation.validateIPV6("2001:DB8::8:800:200C:417A:") );
	}

}
