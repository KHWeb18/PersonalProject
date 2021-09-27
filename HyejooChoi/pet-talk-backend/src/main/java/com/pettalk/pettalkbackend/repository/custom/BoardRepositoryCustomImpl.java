package com.pettalk.pettalkbackend.repository.custom;

import com.pettalk.pettalkbackend.entity.Board;
import com.pettalk.pettalkbackend.entity.Gallery;
import com.pettalk.pettalkbackend.entity.QBoard;
import com.pettalk.pettalkbackend.entity.QUser;
import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Repository
@Transactional
@RequiredArgsConstructor
public class BoardRepositoryCustomImpl implements BoardRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    QBoard board = QBoard.board;
    QUser user = QUser.user;

    @Override
    public PageImpl<Object[]> findAllCustom(Pageable pageable) {
        QueryResults<Tuple> results = queryFactory
                .select(board, user)
                .from(board)
                .join(user)
                .on(board.writer.eq(user.id))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(getOrderSpecifier(pageable.getSort()).stream().toArray(OrderSpecifier[]::new))
                .fetchResults();
        List<Tuple> content = results.getResults();
        long total = results.getTotal();
        return new PageImpl<Object[]>(content.stream().map(tuple -> tuple.toArray()).collect(Collectors.toList()), pageable, total);
    }

    @Override
    public List<Board> findPopularList() {
        QueryResults<Board> results = queryFactory
                .select(Projections.fields(Board.class, board.id, board.title, board.count))
                .from(board)
                .orderBy(board.count.desc())
                .orderBy(board.createdAt.asc())
                .limit(10)
                .fetchResults();
        List<Board> content = results.getResults();
        return content;
    }

    private List<OrderSpecifier> getOrderSpecifier(Sort sort) {
        List<OrderSpecifier> orders = new ArrayList<>();
        // Sort
        sort.stream().forEach(order -> {
            Order direction = order.isAscending() ? Order.ASC : Order.DESC;
            String prop = order.getProperty();
            PathBuilder orderByExpression = new PathBuilder(Board.class, "board");
            orders.add(new OrderSpecifier(direction, orderByExpression.get(prop)));
        });
        return orders;
    }
}
