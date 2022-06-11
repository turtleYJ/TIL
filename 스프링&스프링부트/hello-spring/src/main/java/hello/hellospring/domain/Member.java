package hello.hellospring.domain;

import javax.persistence.*;

@Entity
public class Member {

    // db가 아이디를 자동으로 생성해 주는 것을 IDENTITY전략이라 한다.
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column(name = "username") 이 어노테이션은 DB의 컬럼명을 명시해 준다.
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
