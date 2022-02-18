import com.alibaba.druid.DbType;
import com.alibaba.druid.sql.SQLUtils;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class MainTest {

    public static void main(String[] args) {
        String sqlContent = "select * from test where s=123";
        testSql(sqlContent);
    }

    public static void json() {
        JSONLexer lexer = new JSONLexer(CharStreams.fromString(" {\"key1\": \"value1\"}"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JSONParser parser = new JSONParser(tokens);
        JSONParser.ObjContext objCtx = parser.obj();
        JSONObject jsonObject = new JSONObject(objCtx);

        System.out.println(jsonObject);
        System.out.println(jsonObject.toJSONString());
    }

    public static void caculator() {
        String query = "3-1*3/3+2";
        //String query = "3.1 * (6.3 - 4.51) + 5 * 4";

        CalculatorLexer lexer = new CalculatorLexer(new ANTLRInputStream(query));
        CalculatorParser parser = new CalculatorParser(new CommonTokenStream(lexer));
        CalculatorVisitor visitor = new MyCalculatorVisitor();

        System.out.println(visitor.visit(parser.expr()));
    }

    public static void testSql(String sqlContent) {
        String afterFormat = SQLUtils.format(sqlContent, DbType.mysql);
        System.out.println(afterFormat);
    }

}
