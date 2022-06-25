package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
//테이블 명이 클래스명과 다를 때
//@Table(name = "USER")
public class Member {

    @Id
    private long id;

    @Column(name = "name")
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    public Member() {

    }
}
