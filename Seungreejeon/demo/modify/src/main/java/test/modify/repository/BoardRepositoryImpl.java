package test.modify.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import test.modify.controller.BoardDto;
import test.modify.controller.QBoardDto;
import test.modify.domain.QBoard;

import javax.persistence.EntityManager;

import java.util.List;

import static test.modify.domain.QBoard.*;

public class BoardRepositoryImpl implements BoardRepositoryCustom{
// 레포지토리 impl시 꼭 규칙 맞게 사용하기
//impl 네이밍 규칙은 Repository Interface + Impl 이어야합니다. 그래야 JPA가 사용자 정의 구현 클래스로 인식할 수 있습니다.
    private final JPAQueryFactory queryFactory;
    private final EntityManager em;

    public BoardRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
        this.em = em;
    }

    @Override
    public Page<BoardDto> searchPageSimple(EmployeeCondition condition, Pageable pageable) {
        QueryResults<BoardDto> result = queryFactory

                .select(new QBoardDto(
                        board.boardNo.as("boardNo"),
                        board.title,
                        board.content
                ))
                .from(board)
                .where(board.title.eq(condition.getTitle()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        List<BoardDto> content = result.getResults();

        long total = result.getTotal();

        return new PageImpl<>(content, pageable, total);
    }
}
