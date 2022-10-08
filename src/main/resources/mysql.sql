create database my_company;

DROP TABLE IF EXISTS `dept`;
create table my_company.dept
(
    deptno int auto_increment comment '部门编号'
        primary key,
    dname  varchar(16) not null comment '部门名称',
    constraint deptno
        unique (deptno) comment '外键'
);

create index deptno
    on my_company.emp (deptno) comment '设置deptno为索引';

DROP TABLE IF EXISTS `emp`;
create table emp
(
    empon  int auto_increment comment '员工编号'
        primary key,
    ename  varchar(32) null comment '员工名字',
    mgrno  tinyint null comment '上级编号',
    sal    int null comment '薪金',
    bir    date null comment ' 出生日期',
    gender varchar(4) default '男' comment '性别',
    deptno int null,
    constraint emp_ibfk_1
        foreign key (deptno) references my_company.dept (deptno)
);

/*
dept data
*/
INSERT INTO my_company.dept (deptno, dname) VALUES (1, '业务部');
INSERT INTO my_company.dept (deptno, dname) VALUES (2, '外包部');
INSERT INTO my_company.dept (deptno, dname) VALUES (3, '物业部');
INSERT INTO my_company.dept (deptno, dname) VALUES (6, '事业部');
INSERT INTO my_company.dept (deptno, dname) VALUES (7, '吃饭部');

/*
emp data
*/

INSERT INTO my_company.emp (ename, mgrno, sal, bir,gender,deptno) VALUES ('chen', 100, 1000, '2022-09-08','男', 1);
INSERT INTO my_company.emp (ename, mgrno, sal, bir,gender,deptno) VALUES ('张磨', 11, 1000, '2022-09-29', '女',3);
INSERT INTO my_company.emp (ename, mgrno, sal, bir,gender,deptno) VALUES ('张楠', 11, 7000, '2022-09-10','女', 3);
INSERT INTO my_company.emp (ename, mgrno, sal, bir,gender,deptno) VALUES ('fff', 23, 111, '2022-09-08','女', 2);
INSERT INTO my_company.emp (ename, mgrno, sal, bir,gender,deptno) VALUES ('xiaohua', 11, 2000, '2022-09-15','女', 1);
INSERT INTO my_company.emp (ename, mgrno, sal, bir,gender,deptno) VALUES ('rrrr', 22, 5000, '2022-09-16', '男',3);
INSERT INTO my_company.emp (ename, mgrno, sal, bir,gender,deptno) VALUES ('fdsfsd', 11, 50000, '2022-10-13', '男',1);
INSERT INTO my_company.emp (ename, mgrno, sal, bir,gender,deptno) VALUES ('sdfsdeee', 11, 60000, '2022-10-19','女', 2);
INSERT INTO my_company.emp (ename, mgrno, sal, bir,gender,deptno) VALUES ( 'sfafsdf', 44, 40000, '2022-10-07', '男',3);


/*插入一条数据*/
INSERT INTO my_company.dept (deptno, dname)
VALUES (6, '业务部');

/*删除姓张的女性员工*/
delete
from emp
where emp.ename like '张%' and gender = '女';

/*
3.将部门为 003 所有女性员工工资改为 5500

 1.第一种连表查询
*/
update emp
    inner join dept d
on emp.deptno = d.deptno
    set sal = 5000
where d.deptno = 3 and gender = '女';

/*
 2. 第二种方式使用外键修改
*/
update emp
set sal = 5000
where deptno = 3 and gender = '女';

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
         right join dept d on e.deptno = d.deptno;

/*
7. 列出员工少于 3 人的部门编号
*/
select deptno
from emp
group by emp.deptno
having count(*) < 3;

select d.deptno
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
