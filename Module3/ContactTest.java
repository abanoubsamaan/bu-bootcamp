import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach; 
 
public class ContactTest { 

  private Contact contact;

  @BeforeEach
  public void setUp() { 
    contact = new Contact("Ada Lovelace", "+1 617 555 0101");
  }
 
  @Test 
  void constructor_setsNameCorrectly() { 
    assertEquals("Ada Lovelace", contact.getName()); 
  } 
 
  @Test
  void constructor_setsPhoneCorrectly() { 
    assertEquals("+1 617 555 0101", contact.getPhone()); 
  } 
 
  @Test
  void getName_returnsExactString_notTransformed() { 
    assertEquals("Ada Lovelace", contact.getName());
  } 
 
  @Test
  void toString_containsName() { 
    assertTrue(contact.toString().contains("Lovelace"));
  } 
 
  @Test
  void toString_containsPhone() {
    assertTrue(contact.toString().contains("555 0101"));
  }

  @Test
  void getName_returnsNameStartingWithAda() { 
    assertTrue(contact.getName().startsWith("Ada"));
  }

  @Test
  void getName_returnsNameEndingWithLovelace() { 
    assertTrue(contact.getName().endsWith("Lovelace"));
  }

  @Test
  void getName_DonetContaainBibo() { 
    assertFalse(contact.getName().contains("bibo"));
  }
 
} 
