package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    //동시성 문제가 고려되어 있지 않기 때문에, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려해야한다!
    private static Map<Long, Member> store = new HashMap<>();
    private  static  Long sequence = 0L;

    private  static final  MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance(){
        return instance;
    }

    //싱글톤으로 만들 때 private로
    private  MemberRepository(){
    }

    public  Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
