package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//인터페이스만 만들어도 스프링 데이터 JPA가 구현체를 자동으로 만들어서 스프링 빈으로 등록해줌
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //메서드 이름만으로 JPQL 생성: select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
