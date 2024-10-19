package tacos.data;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import tacos.Ingredient;
import tacos.Taco;

@Repository
public class JdbcTacoRepository implements TacoRepository {

    private JdbcTemplate jdbc;

    public JdbcTacoRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // save() 메서드는 
    @Override
    public Taco save(Taco taco) {
        long tacoId = saveTacoInfo(taco);
        taco.setId(tacoId);
        for (Ingredient ingredient : taco.getIngredients()) {
            saveIngredientToTaco(ingredient, tacoId);
        }
        return taco;
    }

    // SaveTacoInfo() 메서드는 Taco 객체의 이름과 생성 날짜를 Taco 테이블에 저장
    private long saveTacoInfo(Taco taco) {
        taco.setCreatedAt(new Date());

        // 자동 생성된 키 반환 설정
        PreparedStatementCreatorFactory pscFactory = new PreparedStatementCreatorFactory(
                "insert into Taco (name, createdAt) values (?, ?)",
                Types.VARCHAR, Types.TIMESTAMP
        );
        pscFactory.setReturnGeneratedKeys(true);

        PreparedStatementCreator psc = pscFactory.newPreparedStatementCreator(
                Arrays.asList(
                        taco.getName(),
                        new Timestamp(taco.getCreatedAt().getTime())
                )
        );

        // KeyHolder는 자동 생성된 키를 저장하는 데 사용
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(psc, keyHolder);

        Number key = keyHolder.getKey(); // 생성된 키 확인
        if (key != null) {
            return key.longValue();
        }  else {
            throw new IllegalStateException("Fail to retrieve auto-generated key");
        }
    }

    private void saveIngredientToTaco(
        Ingredient ingredient, long tacoId) {
            jdbc.update(
                "insert into Taco_Ingredients (taco, ingredient) " +
                "values (?, ?)",
                tacoId, ingredient.getId());
    }
}
