package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//테이블 명이 클래스명과 다를 때
//@Table(name = "USER")
public class Member {

    @Id
    private long id;
    // 컬럼 명이 다를 때
//    @Column(name = "username")
    private String name;

    public Member() {
    }

    public Member(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
