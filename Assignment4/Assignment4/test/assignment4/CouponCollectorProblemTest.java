/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

import assignment4.CouponCollectorProblem;
import org.junit.Test;
import static org.junit.Assert.*;


public class CouponCollectorProblemTest {
    @Test public void test1() {
         CouponCollectorProblem<String, Integer> hashTable = new CouponCollectorProblem<String, Integer>(2);
        assertEquals(0,hashTable.size());
        //assertTrue(hashTable.check(1,2));
    }
    @Test public void test2() {
         CouponCollectorProblem<String, Integer> hashTable = new CouponCollectorProblem<String, Integer>(2);
        hashTable.put("A",1);
        hashTable.put("B",2);
        assertEquals(2,hashTable.size());
        assertNotNull(hashTable.get("A"));
        assertNotNull(hashTable.get("B"));

    }
}
