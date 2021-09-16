package test.modify.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import test.modify.domain.Board;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Profile("local")
@Component
@RequiredArgsConstructor
public class InitEmpolyee {

    private final InitEmpolyeeService InitEmpolyeeService;

    @PostConstruct
    public void init() {
        InitEmpolyeeService.init();
    }

    @Component
    static class InitEmpolyeeService {
        @PersistenceContext
        EntityManager em;
        @Transactional
        public void init() {
            for (int i = 0; i < 100; i++) {
                Board board1 = Board.builder()
                        .title("hihi")
                        .writer("duplicate")
                        .content("random")
                        .build();
                em.persist(board1);
            }
        }
    }
}