import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.BonusService;

public class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOutOfRangeBonus () {
        BonusService service = new BonusService();

        long amount = 16_634;
        boolean registered = true;
        long expected = 499;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndMaxBonus () {
        BonusService service = new BonusService();

        long amount = 16_667; // сумма для величины бонуса ровно 500
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndMoreValueBonus () {
        BonusService service = new BonusService();

        long amount = 16_700; // сумма для величины бонуса 501
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredAndOutOfRangeBonus () {
        BonusService service = new BonusService();

        long amount = 49_900;
        boolean registered = false;
        long expected = 499;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void shouldCalculateForUnregisteredAndMaxBonus () {
        BonusService service = new BonusService();

        long amount = 50_000; // сумма для величины бонуса ровно 500
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredAndMoreValueBonus () {
        BonusService service = new BonusService();

        long amount = 50_100; // сумма для величины бонуса 501
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }
}