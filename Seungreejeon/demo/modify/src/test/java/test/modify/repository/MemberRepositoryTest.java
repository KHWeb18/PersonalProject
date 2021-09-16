package test.modify.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import test.modify.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static test.modify.domain.QEmployee.*;
import static test.modify.domain.QProject.*;


@SpringBootTest
@Transactional
@Commit
class MemberRepositoryTest {

    @PersistenceContext
    private EntityManager em;

    private JPAQueryFactory queryFactory;

    @Autowired
    private EmployeeRepository employeeRepository;

    @BeforeEach
    public void before() {
        this.queryFactory = new JPAQueryFactory(em);
        for (int i = 0; i < 10; i++) {
            Employee employeeTest = Employee.builder()
                    .name("bobbugger" + i)
                    .email("test@naver.com" + i)
                    .password("testpassword" + i)
                    .phoneNumber("1010101010110" + i)
                    .address(new Address("0912093", "road", "seoul"))
                    .build();
            if (i % 2 == 0) {
                employeeTest.addAuth(new Auth(AuthEnum.ADMIN));
                employeeTest.addTeam(new Team(TeamEnum.DEV));
            } else {
                employeeTest.addAuth(new Auth(AuthEnum.EMPLOYEE));
                employeeTest.addTeam(new Team(TeamEnum.PLAN));
            }
            employeeRepository.save(employeeTest);
            em.flush();
            em.clear();
        }
    }

    @Test
    public void joinTest() throws Exception {
        //given
        this.queryFactory = new JPAQueryFactory(em);
        Employee employeeTest = Employee.builder()
                .name("bobbugger")
                .email("test@naver.com")
                .password("testpassword")
                .phoneNumber("1010101010110")
                .address(new Address("0912093","road","seoul"))
                .build();

        employeeTest.addAuth(new Auth(AuthEnum.ADMIN));
        employeeTest.addTeam(new Team(TeamEnum.DEV));
        employeeRepository.save(employeeTest);
        em.flush();
        em.clear();
        //when
        List<Employee> result = queryFactory
                .selectFrom(employee)
                .where(employee.employeeNo.eq(1L))
                .fetch();
        //then
        assertThat(employeeTest.getEmail()).isEqualTo("test@naver.com");
    }

    @Test
    public void deleteTest() throws Exception {
        //given
        this.queryFactory = new JPAQueryFactory(em);
        Long findEmployee = 3L;

        Employee employeeNo = queryFactory
                .select(employee)
                .from(employee)
                .where(employee.employeeNo.eq(findEmployee))
                .fetchOne();

        //when
        employeeRepository.delete(employeeNo);
        em.flush();
        em.clear();

        //then
        Employee employeeCheck = queryFactory
                .select(employee)
                .from(employee)
                .where(employee.employeeNo.eq(findEmployee))
                .fetchOne();
        assertThat(employeeCheck).isEqualTo(null);
    }

    @Test
    public void projectTest() throws Exception {
        //given
        Employee findEmployee = employeeRepository.findByEmployeeNo(3L);
        Project projectTest1 = Project.builder()
                .title("testYong")
                .person(findEmployee.getName())
                .due("20191919")
                .status(StatusEnum.COMPLETE)
                .build();
        projectTest1.addTeam(findEmployee.getTeam());

        Project projectTest2 = Project.builder()
                .title("checkYong")
                .person(findEmployee.getName())
                .due("20191919")
                .status(StatusEnum.COMPLETE)
                .build();
        projectTest2.addTeam(findEmployee.getTeam());

        em.persist(projectTest1);
        em.persist(projectTest2);
        em.flush();
        em.clear();
        //when
        List<Project> result = queryFactory
                .selectFrom(project)
                .fetch();
        //then
        assertThat(result.get(0).getPerson()).contains("bobbugger2");
    }

    @Test
    public void deleteProject() throws Exception {
        //given
        Employee findEmployee = employeeRepository.findByEmployeeNo(3L);

        Project projectTest2 = Project.builder()
                .title("checkYong")
                .person(findEmployee.getName())
                .due("20191919")
                .status(StatusEnum.COMPLETE)
                .build();

        projectTest2.addTeam(findEmployee.getTeam());

        em.persist(projectTest2);
        em.flush();
        em.clear();
        //when
        queryFactory
                .delete(project)
                .where(project.projectNo.eq(1L))
                .execute();
        em.flush();
        em.clear();
        Project result = queryFactory
                .selectFrom(project)
                .where(project.projectNo.eq(1L))
                .fetchOne();
        //then
        assertThat(result).isEqualTo(null);
    }

    @Test
    public void boardTest() throws Exception {
        //given
        Employee findEmployee = employeeRepository.findByEmployeeNo(1L);

        Auth auth = new Auth();
        //관리자 여부 확인
        auth.validateAuth(findEmployee);

        Board board = Board.builder()
                .title("testYong")
                .writer(findEmployee.getName())
                .content("1a2a3a4a5a6a")
                .build();

        board.addBoardAuth(findEmployee);
        em.persist(board);
        em.flush();
        em.clear();
        //when
        List<Board> result = queryFactory
                .selectFrom(QBoard.board)
                .fetch();
        //then
        assertThat(result.get(0).getAuth().getAuthNo()).isEqualTo(1L);
    }


    @Test
    public void pagingTest() throws Exception {
        //given
        Employee findEmployee = employeeRepository.findByEmployeeNo(3L);
        for (int i = 0; i < 10; i++) {
            Project projectTest= Project.builder()
                    .title("checkYong" + i)
                    .person(findEmployee.getName())
                    .due("20191919" + i)
                    .status(StatusEnum.COMPLETE)
                    .build();

            projectTest.addTeam(findEmployee.getTeam());
            em.persist(projectTest);
            em.flush();
            em.clear();
        }
        //when
        QueryResults<ProjectDto> paging = queryFactory
                .select(Projections.constructor(ProjectDto.class,
                        project.title,
                        project.person))
                .from(project)
                .where(project.team.team.eq(TeamEnum.DEV))
                .offset(0)
                .limit(5)
                .fetchResults();
        //then
        assertThat(paging.getResults()).extracting(ProjectDto::getTitle)
                .contains("checkYong" + 0,
                        "checkYong" + 1,
                        "checkYong" + 2,
                        "checkYong" + 3,
                        "checkYong" + 4);

        System.out.println(paging.getLimit());
        System.out.println(paging.getTotal());
    }
    
    @Test
    public void lookupProject() throws Exception {
        //given
        Employee findEmployee = employeeRepository.findByEmployeeNo(3L);
        for (int i = 0; i < 10; i++) {
            Project projectTest= Project.builder()
                    .title("checkYong" + i)
                    .person(findEmployee.getName())
                    .due("20191919" + i)
                    .status(StatusEnum.COMPLETE)
                    .build();

            projectTest.addTeam(findEmployee.getTeam());
            em.persist(projectTest);
            em.flush();
            em.clear();
        }
        //when
        queryFactory
                .select(employee.team.projects)
                .from(employee)
                .where(employee.team.team_no.eq(3L))
                .fetch();

//        List<Employee> result = em.createQuery("select e from Employee e" +
//                        " join fetch e.team t" +
//                        " join fetch t.projects" +
//                        " where e.employeeNo = :no",
//                        Employee.class)
//                .setParameter("no", 3L)
//                .getResultList();

    }

    @Test
    public void pr() throws Exception {

        String bobbugger0 = employeeRepository.EmployeeName("bobbugger0");

        System.out.println(bobbugger0);


    }

}