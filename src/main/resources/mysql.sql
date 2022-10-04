create database my_company;

create table my_company.dept
(
    deptno int auto_increment
        primary key,
    dname  varchar(16) not null,
    constraint deptno
        unique (deptno)
);

create table my_company.emp
(
    empon  int auto_increment
        primary key,
    ename  varchar(32) null,
    mgrno  tinyint null,
    sal    int null,
    bir    date null,
    deptno int null,
    constraint emp_ibfk_1
        foreign key (deptno) references my_company.dept (deptno)
);
/*
emp data
*/
INSERT INTO my_company.emp (empon, ename, mgrno, sal, bir, deptno) VALUES (1, 'chen', 100, 1000, '2022-09-08', 1);
INSERT INTO my_company.emp (empon, ename, mgrno, sal, bir, deptno) VALUES (2, 'hua', 11, 1000, '2022-09-29', 2);
INSERT INTO my_company.emp (empon, ename, mgrno, sal, bir, deptno) VALUES (3, 'eee', 11, 7000, '2022-09-10', 2);
INSERT INTO my_company.emp (empon, ename, mgrno, sal, bir, deptno) VALUES (4, 'fff', 23, 111, '2022-09-08', 2);
INSERT INTO my_company.emp (empon, ename, mgrno, sal, bir, deptno) VALUES (5, 'xiaohua', 11, 2000, '2022-09-15', 1);
INSERT INTO my_company.emp (empon, ename, mgrno, sal, bir, deptno) VALUES (6, 'rrrr', 22, 5000, '2022-09-16', 3);
INSERT INTO my_company.emp (empon, ename, mgrno, sal, bir, deptno) VALUES (8, 'fdsfsd', 11, 50000, '2022-10-13', 1);
INSERT INTO my_company.emp (empon, ename, mgrno, sal, bir, deptno) VALUES (9, 'sdfsdeee', 11, 60000, '2022-10-19', 2);
INSERT INTO my_company.emp (empon, ename, mgrno, sal, bir, deptno) VALUES (10, 'sfafsdf', 44, 40000, '2022-10-07', 3);


/*
dept data
*/
INSERT INTO my_company.dept (deptno, dname) VALUES (1, '业务部');
INSERT INTO my_company.dept (deptno, dname) VALUES (2, '外包部');
INSERT INTO my_company.dept (deptno, dname) VALUES (3, '物业部');
INSERT INTO my_company.dept (deptno, dname) VALUES (6, 'chenfan');
INSERT INTO my_company.dept (deptno, dname) VALUES (7, '吃饭部');


create index deptno
    on my_company.emp (deptno);

/*插入一条数据*/
INSERT INTO my_company.dept (deptno, dname)
VALUES (6, '业务部');

/*删除姓张的行*/
delete
from emp
where emp.ename like '张%';

/*
3.将部门为 003 所有女性员工工资改为 5500
 第一种连表查询
 第二种方式使用外键修改
*/
update emp
    inner join dept d
on emp.deptno = d.deptno
    set sal = 5000
where d.deptno = 3;

update emp
set sal = 5000
where deptno = 3;

/*4.工资降序显示表*/
SELECT t.*
FROM my_company.emp t
ORDER BY sal DESC LIMIT 501;

/*
5.列出工资大于 7000 的员工所属的部门编号，部门名称，员工名称。
*/
select e.ename, d.dname, d.deptno
from emp as e
         inner join dept d on e.deptno = d.deptno
where sal > 7000;

/*
6.列出员工表中的部门名称和员工名称(要用外连接
*/
select e.ename, d.dname
from emp as e
         inner join dept d on e.deptno = d.deptno;

/*
7. 列出员工少于 3 人的部门编号
*/
select deptno
from emp
group by emp.deptno
having count(*) < 3;

select d.*
from dept d,
     (select e.deptno,
             count(1) n
      from emp e
      group by e.deptno) t
where d.deptno = t.deptno
  and t.n < 3;


/*8.工资最高的姓名*/
SELECT t.ename
FROM my_company.emp t
ORDER BY sal DESC limit 0,1;

/*
9.求各部门的工资
*/
select e.deptno,
       avg(e.sal)
from emp e
group by e.deptno;

/*
10..求每个部门中的最大工资值和最小工资值,并且它的最小值小于5000,最大值大于 15000
*/
select d.deptno,max(e.sal) ,min(e.sal)
from dept d,emp e
where d.deptno = e.deptno
group by d.deptno having min(e.sal)>5000 and max(e.sal)>15000;
