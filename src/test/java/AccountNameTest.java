import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class AccountNameTest {
    private final String name;
    private final boolean expected;
    public AccountNameTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }
    @Parameterized.Parameters(name = "Тестовые данные: name - {0}, expected - {1}")
    public static Object[][] getNameTest() {
        return new Object[][]{
                {"", false}, //пустая строка
                {" ", false}, //пустая строка с пробелом
                {"jd", false}, //символов меньше 3
                {"TatianaTat TatianaTat", false}, //символов больше 19
                {" Tatiana", false}, //пробел в начале
                {"Tatiana ", false}, //пробел в конце
                {"Carmen Maria Cortez", false}, //19 символов, но 2 пробела
                {"Mandragora", false}, //нет пробелов, но количество символов в пределах границ
                {"Tatiana Pavlenko", true}, //хэппи кейс
                {"T P", true}, //хэппи кейс
                {"Tania PavlenkoPavle", true}, //хэппи кейс
                {null, false}, //проверка на null
        };
    }
    @Test
    public void shouldCheckNameToRequirements() {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals("Все пропало", expected, actual);
    }
}