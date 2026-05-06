
=======
# 软件构造课程项目

这是一个按实验迭代整理的 Java 课程仓库，用来持续保存每次实验的源码、文档和设计资料，方便后续继续开发并提交到 GitHub。

## 目录结构

```text
untitled/
├─ docs/
│  ├─ lab2/                 # 实验二文档
│  ├─ lab3/                 # 实验三文档
│  └─ lab4/                 # 实验四文档、UML、代码说明
├─ src/
│  ├─ lab23/                # 实验二、三阶段迭代源码（project001 ~ project005）
│  └─ lab4/                 # 实验四面向对象重构源码
├─ .gitignore
└─ README.md
```

## 当前实验对应关系

- `src/lab23/`
  - `project001.java` 到 `project005.java`
  - 对应实验三逐步迭代版本
- `src/lab4/`
  - `BinaryOperation.java`
  - `Exercise3_1.java`
  - `project006.java`
  - 对应实验四在实验三基础上的面向对象重构版本

## 实验四运行方式

在项目根目录执行：

```bash
javac -d build src/lab4/*.java
java -cp build lab4.project006
```

## 后续扩展建议

- 新实验继续按 `docs/lab5`、`src/lab5` 的方式新增，不要把新文件直接堆到根目录。
- 每次提交前保留源码、文档和必要图片，忽略 `.class`、`.idea`、`build` 等生成文件。
- 如果后续实验规模变大，可以再增加：
  - `assets/`：保存截图、流程图、UML 导出图片
  - `reports/`：保存最终提交版实验报告

## GitHub 提交建议

每次实验可以按下面节奏提交：

1. `docs`：补充实验要求和报告
2. `src`：新增或重构代码
3. `README`：同步更新目录说明或运行方式

