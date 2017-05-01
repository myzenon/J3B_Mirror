package J3B.farmapp.util;

import static org.junit.Assert.*;
import org.junit.Test;

import J3B.farmapp.util.MathUtil;


public class MathUtilTest {
	@Test
	public void testAdd(){
		MathUtil mathUtil = new MathUtil();
		assertEquals(mathUtil.add(10,10),20);
	}
}
