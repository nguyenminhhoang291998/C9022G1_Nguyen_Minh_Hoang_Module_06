import com.sun.org.apache.xalan.internal.xsltc.compiler.CompilerException;

public class TestOCA {
    void readCard(int cardNo) throws Exception {
        System.out.println("z");
    }
    void checkCard(int cardNo) throws RuntimeException {
        System.out.println("zzz");
    }

    public static void main(String[] args) {
        TestOCA ex = new TestOCA();
        int cardNo = 12344;
        ex.checkCard(cardNo);
        ex.readCard(cardNo);
    }
}
