import main.java.org.lykj.ReplacePhoneNumber;
import org.junit.jupiter.api.Test;

class ReplacePhoneNumberTest {

    @Test
    void replacePhone() {
        System.out.println(ReplacePhoneNumber.replacePhone("13053954937"));
    }

    @Test
    void replacePhoneWithRegular() {
        System.out.println(ReplacePhoneNumber.replacePhoneWithRegular("123132"));
    }
}