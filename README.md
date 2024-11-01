# Zero-Hana
Zero-Hana
# 1. 概述
## 1.1 简介
SAP HANA（高性能分析工具）是一款将数据存储在内存而不是硬盘的多模型数据库。这款列式内存数据库支持企业在同一系统中执行快速的事务处理和先进的分析处理。
为什么 SAP HANA 如此重要？因为该产品支持企业近乎零延迟地处理海量数据，即时查询数据，并真正实现由数据驱动。SAP HANA 拥有独特的优势。
该平台将数据存储在主内存的列存储表中，并且集联机分析处理 (OLAP) 和联机事务处理 (OLTP) 于一体，处理速度比目前市场上的其他数据库管理系统 (DBMS) 快很多。
## 1.2. 内存数据库
内存数据库 (IMDB) 是一种将数据存储在计算机主内存 (RAM)，而不是传统磁盘或固态硬盘 (SSD) 的数据库。虽然如今大多数数据库都增加了许多内存功能，但从根本上来说还是基于磁盘的存储数据库。
SAP HANA 则是从零开始构建，主要目的是利用内存处理数据，其次才是利用其他必要的存储机制来平衡性能和成本。从内存中检索数据要比从磁盘或固态硬盘中检索数据快得多，因此 SAP HANA 可以实现瞬时响应。
## 1.3. 速度
- 比传统数据库快 3600 倍
- 1 秒内给出查询结果
- 每核每秒扫描 35 亿次
- 每核每秒执行 1,500 万次聚合
## 1.4. 架构
SAP HANA 采用列式内存架构，支持快速执行查询和事务处理。除此之外，该架构还提供数据库管理、应用开发、高级分析处理和灵活的数据虚拟化功能。

# 2. 功能

# 3. 使用
## 3.1. 安装
```shell
# 原始镜像
docker pull sap/hana:2.0-sapmachine
# 精简镜像
docker pull saplabs/hanaexpress:latest
```
## 3.2. 运行
```shell
docker run -p 39013:39013 -p 39017:39017 -p 39041-39045:39041-39045 -p 1128-1129:1128-1129 -p 59013-59014:59013-59014 \
-v D:/IdeaProjects/ETFramework/hana/docker/hana/data/sap:/hana/mounts \
--name hana1 saplabs/hanaexpress:latest \
--passwords-url file:///hana/mounts/passwd.json --agree-to-sap-license
```
## 3.3. 登录
```shell
docker exec -it hana1 bash

# To log into your system database via JDBC, use the following command:
jdbc:sap://<ip_address>:39017/?databaseName=<database_name>

# To log into your tenant database via JDBC, use the following command:
jdbc:sap://<ip_address>:39041/?databaseName=<tenant_name>
```

## 3.4. 配置
### 3.4.1. ${path}/hana/data/sap/passwd.json
```json
{
  "system_user_password" : "Hyd20240531",
  "default_tenant_system_user_password" : "Hyd20240531"
}
```
### 3.4.2. 默认用户名
> system_user： SYSTEM
> default_tenant_system_user：SYSTEM

## 3.5. 数据库
```sql
-- 创建新数据库
CREATE DATABASE demo;

-- 授予权限给特定用户
GRANT ALL PRIVILEGES ON DATABASE demo TO my_user;

-- 创建表
CREATE TABLE Employees (
EmployeeID INT PRIMARY KEY,
FirstName NVARCHAR(50),
LastName NVARCHAR(50),
Department NVARCHAR(50),
Salary DECIMAL(10, 2)
);

-- 插入测试数据
INSERT INTO Employees (EmployeeID, FirstName, LastName, Department, Salary)
SELECT 1, 'John', 'Doe', 'Engineering', 60000.00 FROM DUMMY UNION ALL
SELECT 2, 'Jane', 'Smith', 'HR', 55000.00 FROM DUMMY UNION ALL
SELECT 3, 'Alice', 'Johnson', 'Finance', 65000.00 FROM DUMMY UNION ALL
SELECT 4, 'Bob', 'Brown', 'Marketing', 58000.00 FROM DUMMY UNION ALL
SELECT 5, 'Emma', 'Lee', 'Engineering', 62000.00 FROM DUMMY;

```

# 4. 其他

# 5. 参考