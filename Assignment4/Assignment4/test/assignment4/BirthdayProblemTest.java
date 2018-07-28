/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

import assignment4.BirthdayProblem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;



public class BirthdayProblemTest {
    @Test public void test1() {
         BirthdayProblem<String, Integer> hashTable = new BirthdayProblem<String, Integer>(2);
         assertEquals(0,hashTable.size());
 
    }
    @Test public void test2() {
         BirthdayProblem<String, Integer> hashTable = new BirthdayProblem<String, Integer>(2);
        hashTable.put("A",1);
        hashTable.put("B",2);
        assertEquals(2,hashTable.size());
        assertNotNull(hashTable.get("A"));
        assertNotNull(hashTable.get("B"));

    }
}
