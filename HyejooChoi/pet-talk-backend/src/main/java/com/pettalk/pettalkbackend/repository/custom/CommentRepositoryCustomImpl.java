package com.pettalk.pettalkbackend.repository.custom;

import com.pettalk.pettalkbackend.dto.BoardType;
import com.pettalk.pettalkbackend.entity.Gallery;
import com.pettalk.pettalkbackend.entity.QComment;
import com.pettalk.pettalkbackend.entity.QUser;
import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Repository
@Transactional
@RequiredArgsConstructor
public class CommentRepositoryCustomImpl implements CommentRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    QComment comment = QComment.comment;
    QUser user = QUser.user;

    public List<Object[]> findByBoardTypeAndBoardNoCustom(BoardType boardType, long boardNo) {
        QueryResults<Tuple> results = queryFactory
                .select(comment, user)
                .from(comment)
                .innerJoin(user)
                .on(comment.writer.eq(user.id))
                .where(comment.boardType.eq(boardType))
                .where(comment.boardNo.eq(boardNo))
                .orderBy(comment.createdAt.desc())
                .fetchResults();
        List<Tuple> content = results.getResults();
        return new ArrayList<>(content.stream().map(tuple -> tuple.toArray()).collect(Collectors.toList()));
    }
}
